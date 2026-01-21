package net.astro142.testmod4finale.item;

import net.astro142.testmod4finale.TestMod4Finale;
import net.astro142.testmod4finale.item.custom.ArtfulWand;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TestMod4Finale.MOD_ID);

    public static final DeferredItem<Item> BLACKPOWDER = ITEMS.registerItem("blackpowder",
            Item::new, new Item.Properties());

    public static final DeferredItem<Item> ARTFUL_WAND = ITEMS.registerItem("artful_wand",
            ArtfulWand::new, new Item.Properties().durability(32));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
