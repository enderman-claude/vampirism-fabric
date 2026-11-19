package de.teamlapen.vampirism.registry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * Items for the Fabric port. M2 test item only: confirms registration works in game.
 */
public final class VampirismItems {

    public static final String MOD_ID = "vampirism";

    public static final Item TEST_ITEM = register("test_item", new Item(new Item.Settings().group(ItemGroup.MISC)));

    private VampirismItems() {
    }

    private static Item register(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(MOD_ID, name), item);
    }

    /** Forces class initialisation, which performs the registrations. */
    public static void init() {
    }
}
