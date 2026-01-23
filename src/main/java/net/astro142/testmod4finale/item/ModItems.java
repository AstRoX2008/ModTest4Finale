package net.astro142.testmod4finale.item;

import net.astro142.testmod4finale.TestMod4Finale;
import net.astro142.testmod4finale.item.custom.ArtfulWand;
import net.astro142.testmod4finale.item.custom.FuelItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Consumer;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TestMod4Finale.MOD_ID);


    public static final DeferredItem<Item> BLACKPOWDER = ITEMS.registerItem("blackpowder",
            (properties) -> new FuelItem(properties, 400){
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, TooltipDisplay tooltipDisplay, Consumer<Component> components, TooltipFlag tooltipFlag) {
                    components.accept(Component.translatable("tooltip.testmod4finale.blackpowder.tooltip"));
                    super.appendHoverText(pStack, pContext, tooltipDisplay, components, tooltipFlag);
                }
            });

    public static final DeferredItem<Item> ARTFUL_WAND = ITEMS.registerItem("artful_wand",
            ArtfulWand::new, new Item.Properties().durability(32)
    );

    public static final DeferredItem<Item> PIZZA = ITEMS.registerItem("pizza",
            Item::new, new Item.Properties().food(ModFoodProperties.PIZZA, ModFoodProperties.PIZZA_EFFECT));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
