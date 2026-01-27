package net.astro142.testmod4finale.block;

import net.astro142.testmod4finale.TestMod4Finale;
import net.astro142.testmod4finale.block.custom.ArtfulCube;
import net.astro142.testmod4finale.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.naming.ldap.PagedResultsControl;
import java.util.function.Function;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(TestMod4Finale.MOD_ID);

    public static final DeferredBlock<Block> ARTFUL_CUBE = registerBlock("artful_cube",
            (properties) -> new Block(properties),BlockBehaviour.Properties.of().strength(1f).noLootTable().sound(SoundType.BAMBOO));
    public static final DeferredBlock<StairBlock> ARTFUL_STAIRS = registerBlock("artful_stairs",
            (properties) -> new StairBlock(ModBlocks.ARTFUL_CUBE.get().defaultBlockState(),properties),BlockBehaviour.Properties.of().strength(1f).noLootTable().sound(SoundType.BAMBOO));
    public static final DeferredBlock<SlabBlock> ARTFUL_SLAB = registerBlock("artful_slab",
            (properties) -> new SlabBlock(properties),BlockBehaviour.Properties.of().strength(1f).noLootTable().sound(SoundType.BAMBOO));
    public static final DeferredBlock<WallBlock> ARTFUL_WALL = registerBlock("artful_wall",
            (properties) -> new WallBlock(properties),BlockBehaviour.Properties.of().strength(1f).noLootTable().sound(SoundType.BAMBOO));
    public static final DeferredBlock<FenceBlock> ARTFUL_FENCE = registerBlock("artful_fence",
            (properties) -> new FenceBlock(properties),BlockBehaviour.Properties.of().strength(1f).noLootTable().sound(SoundType.BAMBOO));
    public static final DeferredBlock<FenceGateBlock> ARTFUL_FENCE_GATE = registerBlock("artful_fence_gate",
            (properties) -> new FenceGateBlock(WoodType.ACACIA,properties),BlockBehaviour.Properties.of().strength(1f).noLootTable().sound(SoundType.BAMBOO));
    public static final DeferredBlock<PressurePlateBlock> ARTFUL_PRESSURE_PLATE = registerBlock("artful_pressure_plate",
            (properties) -> new PressurePlateBlock(BlockSetType.IRON,properties),BlockBehaviour.Properties.of().strength(1f).noLootTable().sound(SoundType.BAMBOO));
    public static final DeferredBlock<ButtonBlock> ARTFUL_BUTTON = registerBlock("artful_button",
            (properties) -> new ButtonBlock(BlockSetType.IRON,40,properties),BlockBehaviour.Properties.of().strength(1f).noLootTable().sound(SoundType.BAMBOO));


    private static <B extends Block> DeferredBlock<B> registerBlock(String name, Function<BlockBehaviour.Properties, ? extends B> blockFactory, BlockBehaviour.Properties blockProperties) {
        DeferredBlock<B> block = BLOCKS.registerBlock(name, blockFactory, blockProperties);
        registerBlockItem(name, block);
        return block;
    }

    private static <B extends Block> void registerBlockItem(String name, DeferredBlock<B> block) {
        ModItems.ITEMS.registerSimpleBlockItem(name, block);
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
