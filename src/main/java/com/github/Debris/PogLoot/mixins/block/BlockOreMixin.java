package com.github.Debris.PogLoot.mixins.block;

import com.github.Debris.PogLoot.config.PogLootConfig;
import net.minecraft.BlockOre;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(BlockOre.class)
public class BlockOreMixin {
    @Redirect(method = "dropBlockAsEntityItem", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int inject(Random random, int x) {
        if (PogLootConfig.LapisDropRateMaximum.getBooleanValue()) return x - 1;
        else return x;
    }
}
