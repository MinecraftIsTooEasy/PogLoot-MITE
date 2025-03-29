package com.github.Debris.PogLoot.mixins.block;

import net.minecraft.BlockRedstoneOre;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(BlockRedstoneOre.class)
public class BlockRedstoneOreMixin {
    @Redirect(method = "dropBlockAsEntityItem", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int inject(Random random, int x) {
        return x - 1;
    }
}
