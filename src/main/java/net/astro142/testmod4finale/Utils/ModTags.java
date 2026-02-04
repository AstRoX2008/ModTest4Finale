package net.astro142.testmod4finale.Utils;

import net.astro142.testmod4finale.TestMod4Finale;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> SPECIAL_WALL_BLOCKS = createTag("special_wall_blocks");

        public static final TagKey<Block> NEEDS_EMERALD_TOOL = createTag("needs_emerald_tool");

        public static final TagKey<Block> INCORRECT_FOR_EMERALD_TOOL = createTag("incorrect_for_emerald_tool");
        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(TestMod4Finale.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> EMERALD_REPAIRABLE = createTag("emerald_repairable");
        public static final TagKey<Item> AMETHYST_REPAIRABLE = createTag("amethyst_repairable");
        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(TestMod4Finale.MOD_ID, name));
        }
    }
}
