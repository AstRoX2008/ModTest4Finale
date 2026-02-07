package net.astro142.testmod4finale.item;

import net.astro142.testmod4finale.TestMod4Finale;
import net.astro142.testmod4finale.item.custom.ArtfulWand;
import net.astro142.testmod4finale.item.custom.FuelItem;
import net.astro142.testmod4finale.item.custom.ModArmorItem;
import net.astro142.testmod4finale.sound.ModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.equipment.ArmorType;
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

    public static final DeferredItem<Item> EMERALD_SWORD = ITEMS.registerItem("emerald_sword",
            (properties) -> new Item(properties.sword(ModToolTiers.EMERALD, 5, -2.4f)));
    public static final DeferredItem<Item> EMERALD_PICKAXE = ITEMS.registerItem("emerald_pickaxe",
            (properties) -> new Item(properties.pickaxe(ModToolTiers.EMERALD, 1.0F, -2.8f)));
    public static final DeferredItem<ShovelItem> EMERALD_SHOVEL = ITEMS.registerItem("emerald_shovel",
            (properties) -> new ShovelItem(ModToolTiers.EMERALD, 1.5F, -3.0f, properties));
    public static final DeferredItem<AxeItem> EMERALD_AXE = ITEMS.registerItem("emerald_axe",
            (properties) -> new AxeItem(ModToolTiers.EMERALD, 6.0F, -3.2f, properties));
    public static final DeferredItem<HoeItem> EMERALD_HOE = ITEMS.registerItem("emerald_hoe",
            (properties) -> new HoeItem(ModToolTiers.EMERALD, 0F, -3.0f, properties));

    public static final DeferredItem<Item> EMERALD_HELMET = ITEMS.registerItem("emerald_helmet",
            (properties) -> new ModArmorItem(properties.humanoidArmor(ModArmorMaterials.EMERALD_ARMOR_MATERIAL, ArmorType.HELMET)));
    public static final DeferredItem<Item> EMERALD_CHESTPLATE = ITEMS.registerItem("emerald_chestplate",
            (properties) -> new Item(properties.humanoidArmor(ModArmorMaterials.EMERALD_ARMOR_MATERIAL, ArmorType.CHESTPLATE)));
    public static final DeferredItem<Item> EMERALD_LEGGINGS = ITEMS.registerItem("emerald_leggings",
            (properties) -> new Item(properties.humanoidArmor(ModArmorMaterials.EMERALD_ARMOR_MATERIAL, ArmorType.LEGGINGS)));
    public static final DeferredItem<Item> EMERALD_BOOTS = ITEMS.registerItem("emerald_boots",
            (properties) -> new Item(properties.humanoidArmor(ModArmorMaterials.EMERALD_ARMOR_MATERIAL, ArmorType.BOOTS)));

    public static final DeferredItem<Item> AMETHYST_HORSE_ARMOR = ITEMS.registerItem("amethyst_horse_armor",
            (properties) -> new Item( properties.stacksTo(1).horseArmor(ModArmorMaterials.AMETHYST_ARMOR_MATERIAL)));

    public static final DeferredItem<Item> GNB_MUSIC_DISC_1 = ITEMS.registerItem("gnb_music_disc_1",
            (properties) -> new Item(properties.jukeboxPlayable(ModSounds.GNB_MUSIC_1_KEY).stacksTo(1)));
    public static final DeferredItem<Item> GNB_MUSIC_DISC_2 = ITEMS.registerItem("gnb_music_disc_2",
            (properties) -> new Item(properties.jukeboxPlayable(ModSounds.GNB_MUSIC_2_KEY).stacksTo(1)));
    public static final DeferredItem<Item> GNB_MUSIC_DISC_3 = ITEMS.registerItem("gnb_music_disc_3",
            (properties) -> new Item(properties.jukeboxPlayable(ModSounds.GNB_MUSIC_3_KEY).stacksTo(1)));
    public static final DeferredItem<Item> GNB_MUSIC_DISC_4 = ITEMS.registerItem("gnb_music_disc_4",
            (properties) -> new Item(properties.jukeboxPlayable(ModSounds.GNB_MUSIC_4_KEY).stacksTo(1)));
    public static final DeferredItem<Item> GNB_MUSIC_DISC_5 = ITEMS.registerItem("gnb_music_disc_5",
            (properties) -> new Item(properties.jukeboxPlayable(ModSounds.GNB_MUSIC_5_KEY).stacksTo(1)));

    public static final DeferredItem<Item> PIZZA = ITEMS.registerItem("pizza",
            Item::new, new Item.Properties().food(ModFoodProperties.PIZZA, ModFoodProperties.PIZZA_EFFECT));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
