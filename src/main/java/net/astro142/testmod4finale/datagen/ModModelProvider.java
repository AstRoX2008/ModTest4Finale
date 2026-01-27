package net.astro142.testmod4finale.datagen;


import net.astro142.testmod4finale.TestMod4Finale;
import net.astro142.testmod4finale.block.ModBlocks;
import net.astro142.testmod4finale.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.client.renderer.item.ClientItem;
import net.minecraft.client.renderer.item.ConditionalItemModel;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.properties.conditional.HasComponent;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.stream.Stream;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, TestMod4Finale.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(ModItems.BLACKPOWDER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.PIZZA.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.ARTFUL_WAND.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        /* BLOCKS */

        blockModels.family(ModBlocks.ARTFUL_CUBE.get())
                .fence(ModBlocks.ARTFUL_FENCE.get())
                .fenceGate(ModBlocks.ARTFUL_FENCE_GATE.get())
                .wall(ModBlocks.ARTFUL_WALL.get())
                .stairs(ModBlocks.ARTFUL_STAIRS.get())
                .slab(ModBlocks.ARTFUL_SLAB.get())
                .button(ModBlocks.ARTFUL_BUTTON.get())
                .pressurePlate(ModBlocks.ARTFUL_PRESSURE_PLATE.get());

    }

    @Override
    protected Stream<? extends Holder<Block>> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream();
    }

    @Override
    protected Stream<? extends Holder<Item>> getKnownItems() {
        return ModItems.ITEMS.getEntries().stream();
    }
}
