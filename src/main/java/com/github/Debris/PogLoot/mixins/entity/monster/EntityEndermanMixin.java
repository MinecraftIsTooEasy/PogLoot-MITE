package com.github.Debris.PogLoot.mixins.entity.monster;

import com.github.Debris.PogLoot.config.PogLootConfig;
import net.minecraft.EntityEnderman;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(EntityEnderman.class)
public class EntityEndermanMixin {
    @Redirect(method = "dropFewItems", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int inject(Random random, int x) {
        if (PogLootConfig.MonsterMaximumChanceOfDroppingLoot.getBooleanValue()) return x - 1;
        else return x;
    }
}
