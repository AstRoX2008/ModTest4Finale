package net.astro142.testmod4finale.effect;


import net.astro142.testmod4finale.TestMod4Finale;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, TestMod4Finale.MOD_ID);

    public static final Holder<MobEffect> ADRENALINE_EFFECT = MOB_EFFECTS.register("adrenaline",
            () -> new Adrenaline(MobEffectCategory.NEUTRAL, 0x36ebab)
                    .addAttributeModifier(Attributes.ATTACK_DAMAGE,
                            ResourceLocation.fromNamespaceAndPath(TestMod4Finale.MOD_ID, "adrenaline"), 1f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL).addAttributeModifier(Attributes.MOVEMENT_SPEED,
                            ResourceLocation.fromNamespaceAndPath(TestMod4Finale.MOD_ID, "adrenaline"), 5f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));



    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
