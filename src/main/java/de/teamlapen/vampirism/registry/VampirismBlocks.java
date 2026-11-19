package de.teamlapen.vampirism.registry;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * Blocks for the Fabric port. M2 test block only: confirms block registration works in game.
 */
public final class VampirismBlocks {

    public static final Block TEST_BLOCK = register("test_block",
            new Block(AbstractBlock.Settings.of(Material.STONE).strength(1.5f, 6.0f)));

    private VampirismBlocks() {
    }

    private static Block register(String name, Block block) {
        Identifier id = new Identifier(VampirismItems.MOD_ID, name);
        Registry.register(Registry.ITEM, id,
                new BlockItem(block, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        return Registry.register(Registry.BLOCK, id, block);
    }

    /** Forces class initialisation, which performs the registrations. */
    public static void init() {
    }
}
