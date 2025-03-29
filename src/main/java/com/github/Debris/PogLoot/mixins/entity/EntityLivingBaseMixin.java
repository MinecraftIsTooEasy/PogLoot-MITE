package com.github.Debris.PogLoot.mixins.entity;

import com.github.Debris.PogLoot.config.PogLootConfig;
import net.minecraft.EntityLivingBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(EntityLivingBase.class)
public class EntityLivingBaseMixin {
    @ModifyConstant(method = "onDeath", constant = @Constant(floatValue = 0.1f))
    private float alwaysDrop(float constant) {
        if (PogLootConfig.MonsterMaximumChanceOfDroppingLoot.getBooleanValue())
            return 1.0f;
        return constant;
    }
}
