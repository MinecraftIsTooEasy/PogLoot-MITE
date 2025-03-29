package com.github.Debris.PogLoot.mixins.entity;

import net.minecraft.EntityLivingBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(EntityLivingBase.class)
public class EntityLivingBaseMixin {
    @ModifyConstant(method = "onDeath", constant = @Constant(floatValue = 0.1f))
    private float alwaysDrop(float constant) {
        return 1.0f;
    }
}
