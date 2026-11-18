#!/usr/bin/env python3
"""Convert javac errors in build.log into GitHub Actions annotations.

Annotations are readable through the Checks API, unlike the raw job log.
"""
import os
import re

LOG = "build.log"
if not os.path.exists(LOG):
    print("::notice::no build.log produced")
    raise SystemExit(0)

lines = open(LOG, encoding="utf-8", errors="replace").read().splitlines()
pat = re.compile(r"^(.*\.java):(\d+): error: (.*)$")
count = 0
for i, line in enumerate(lines):
    m = pat.match(line)
    if not m:
        continue
    count += 1
    if count > 150:
        continue
    path = re.sub(r"^/home/runner/work/[^/]+/[^/]+/", "", m.group(1))
    sym = ""
    for j in range(i + 1, min(i + 5, len(lines))):
        s = lines[j].strip()
        if s.startswith("symbol:") or s.startswith("symbol "):
            sym = s
            break
    msg = m.group(3) + (" | " + sym if sym else "")
    msg = msg.replace("%", "%25").replace("\r", "").replace("\n", " ")
    print(f"::error file={path},line={m.group(2)}::{msg}")

print(f"::notice::{count} javac errors found in build.log")
