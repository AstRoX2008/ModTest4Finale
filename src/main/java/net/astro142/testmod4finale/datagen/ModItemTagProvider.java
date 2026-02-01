package net.astro142.testmod4finale.datagen;


import net.astro142.testmod4finale.TestMod4Finale;
import net.astro142.testmod4finale.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, TestMod4Finale.MOD_ID);
    }


    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(ItemTags.SWORDS)
                .add(ModItems.EMERALD_SWORD.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.EMERALD_PICKAXE.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.EMERALD_SHOVEL.get());
        tag(ItemTags.HOES)
                .add(ModItems.EMERALD_HOE.get());
        tag(ItemTags.AXES)
                .add(ModItems.EMERALD_AXE.get());
    }
}
