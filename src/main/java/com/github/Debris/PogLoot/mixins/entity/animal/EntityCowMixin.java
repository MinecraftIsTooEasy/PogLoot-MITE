package com.github.Debris.PogLoot.mixins.entity.animal;

import net.minecraft.EntityCow;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(EntityCow.class)
public class EntityCowMixin {
    @Redirect(method = "dropFewItems", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int inject(Random random, int x) {
        return x - 1;
    }
}
