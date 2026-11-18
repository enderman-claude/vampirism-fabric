package de.teamlapen.lib.lib.util;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import net.minecraft.util.Identifier;

import java.io.IOException;

public final class ResourceLocationTypeAdapter extends TypeAdapter<Identifier> {

    @Override
    public Identifier read(JsonReader in) throws IOException {
        return new Identifier(in.nextString());
    }

    @Override
    public void write(JsonWriter out, Identifier value) throws IOException {
        if (value == null) {
            out.nullValue();
            return;
        }
        out.value(value.toString());
    }
}
