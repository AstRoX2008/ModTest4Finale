package net.astro142.testmod4finale.item;

import net.astro142.testmod4finale.TestMod4Finale;
import net.astro142.testmod4finale.block.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.apache.logging.log4j.core.config.plugins.util.ResolverUtil;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TestMod4Finale.MOD_ID);

    public static final Supplier<CreativeModeTab> GNB_STUFF = CREATIVE_MODE_TAB.register("gnb_stuff",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.ARTFUL_CUBE.get()))
                    .title(Component.translatable("creativetab.testmod4finale.gnb_stuff"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.BLACKPOWDER);
                        output.accept(ModBlocks.ARTFUL_CUBE);
                        output.accept(ModItems.ARTFUL_WAND);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
