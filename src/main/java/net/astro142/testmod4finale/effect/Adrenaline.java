package net.astro142.testmod4finale.effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

// Climbing Effect by SameDifferent: https://github.com/samedifferent/TrickOrTreat/blob/master/LICENSE
// Distributed under MIT
public class Adrenaline extends MobEffect {
    public Adrenaline(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(ServerLevel level, LivingEntity livingEntity, int amplifier) {


        return super.applyEffectTick(level, livingEntity, amplifier);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
