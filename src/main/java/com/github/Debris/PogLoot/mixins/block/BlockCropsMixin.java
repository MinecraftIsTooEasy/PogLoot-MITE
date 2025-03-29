package com.github.Debris.PogLoot.mixins.block;

import net.minecraft.BlockCrops;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(BlockCrops.class)
public class BlockCropsMixin {
//    @ModifyArg(method = "updateTick", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
//    private int inject_1(int bound) {
//        bound
//        return par5;
//    }
//    @ModifyArg(method = "dropBlockAsEntityItem", at = @At(value = "INVOKE", target = "drop"), index = 4)
//    private float inject_1(float par5) {// TODO
//        if (par5 == 0.01f) par5 = 0.1f;
//        if (par5 == 0.05f) par5 = 0.3f;
//        if (par5 == 0.005f) par5 = 1.0f;
//        return par5;
//    }
}
