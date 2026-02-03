package net.astro142.testmod4finale.event;


import net.astro142.testmod4finale.TestMod4Finale;
import net.astro142.testmod4finale.item.ModItems;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ComputeFovModifierEvent;

@EventBusSubscriber(modid = TestMod4Finale.MOD_ID, value =  Dist.CLIENT)
public class ModClientEvents {
    @SubscribeEvent
    public static void onComputeFovModifierEvent(ComputeFovModifierEvent event) {

    }
}
