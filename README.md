# Vampirism — Fabric port (Minecraft 1.16.5)

> **Migration progress: ~6% (compiles on Fabric; test item registered; not yet launched).** The Fabric scaffold builds in CI and part of the Teamlapen Library compiles on Fabric 1.16.5. Nothing has been launched in a game client yet, and no gameplay content has been ported.

This is an unofficial Fabric port of **Vampirism** by TeamLapen (Maxanier and Cheaterpaul). It is **not** affiliated with or endorsed by the original authors.

## Original project

- Source: https://github.com/TeamLapen/Vampirism (branch `version/1.16/latest`, commit `6734000f07b5ea56dd29ed034eef5743ecbf2609`)
- Please check out the original repository for the real, supported mod.
- Teamlapen Library is included in the original repository under `src/lib`. It is not a separate project here.
- Werewolves (the companion mod) is a separate project: https://github.com/TeamLapen/Werewolves. It is not part of this repository yet.

## Licence

- The project is licensed under the **GNU Lesser General Public License v3.0** (see `LICENCE`), as in the original.
- Textures under `src/main/resources/assets/vampirism/textures/` carry their own terms in `LICENCE.txt`. Those terms are inherited from upstream and are unchanged.
- **Open licence issue:** `src/main/java/de/teamlapen/vampirism/sit/` contains code under the **GNU GPL v3** (its own `LICENSE.txt`), not LGPL. This is kept untouched for now. Before any port work touches it, the licence situation of that code needs to be resolved.
- All changes made in this port will be marked as such, and original copyright and licence notices are kept.

## Version note

The source in this repository is version **1.9.11** (`gradle.properties`), while the jar the port was started from is **1.9.10**. Differences between the two are not yet checked.

## Milestones

Each milestone needs to be tested in a Fabric dev client by the maintainer before it is ticked. Fabric API is the only intended dependency.

- [ ] **M0 — Scaffold:** Fabric Loom project for 1.16.5, Fabric API as the only dependency, builds and launches with no mod content.
- [ ] **M1 — Teamlapen Library folded in:** the `src/lib` code moved into the mod, Forge-only parts removed or replaced.
- [ ] **M2 — Registries and event bus (partial: test item registered):** blocks, items, entities, and effects registered through Fabric; Forge event subscriptions replaced.
- [ ] **M3 — Capabilities:** Forge capabilities replaced with Fabric attachments or a custom equivalent (about 34 files).
- [ ] **M4 — Networking:** Forge `SimpleChannel` packets replaced with Fabric networking (about 33 files).
- [ ] **M5 — Configuration:** `ForgeConfigSpec` replaced (about 12 files).
- [ ] **M6 — Fluids and items:** Transfer API used in place of Forge fluid and item handlers (about 25 files).
- [ ] **M7 — Rendering and client:** renderers, GUIs, and key bindings ported (about 27 files).
- [ ] **M8 — Data and assets:** recipes, loot tables, tags, and models in place; datagen replaced or dropped.
- [ ] **M9 — Vampire core:** transformation, blood, and main vampire abilities working.
- [ ] **M10 — Hunter and factions:** hunter features and faction logic working.
- [ ] **M11 — Remaining features:** everything not covered above, including any optional integrations that are dropped or kept.
- [ ] **M12 — Werewolves:** companion mod ported in a separate pass once Vampirism runs.

## Status log

- 2026-11-18: Repository created from the 1.16 branch of upstream. No code changes yet.
- 2026-11-18: M0 scaffold on the `fabric` branch. Forge sources moved to `legacy/forge-src` (reference only). Loom build, `fabric.mod.json`, and entrypoint added. GitHub Actions `fabric-build` passes (compiles and builds the jar). Not yet launched in a dev client, so M0 is not ticked.
- 2026-11-18: M1 (partial) compiles on Fabric. 17 Forge-free library classes plus the `HelperLib`-style dependents moved as needed; Forge/MCP names mapped to Yarn 1.16.5 names. Still in `legacy/` until their milestones: classes needing network (`ISyncable`, `UpdateEntityPacket`), config (`BloodValueLoader`), client GUI widgets (`ScrollableListWidget`), and the spawner logic. `WeightedRandomItem` rewritten without Minecraft dependencies. CI `fabric-build` is green (compile and jar build). Not launched in a dev client, so M1 is not ticked.
- 2026-11-19: M2 (partial): test item `vampirism:test_item` registered through Fabric, with model, texture, and English name. CI builds now inject the commit hash into the jar, and the mod logs `Build commit: <hash>` on load. Local builds omit it. Not yet launched in a dev client, so M2 is not ticked.
