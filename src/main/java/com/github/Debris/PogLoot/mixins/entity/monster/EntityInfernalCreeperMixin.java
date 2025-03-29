package com.github.Debris.PogLoot.mixins.entity.monster;

import net.minecraft.EntityInfernalCreeper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(EntityInfernalCreeper.class)
public class EntityInfernalCreeperMixin {

    @ModifyVariable(method = "dropFewItems", at = @At("HEAD"), ordinal = 0, argsOnly = true)
    private boolean inject(boolean recently_hit_by_player) {
        return true;
    }

    @Redirect(method = "dropFewItems", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int inject(Random random, int x) {
        return x - 1;
    }
}
