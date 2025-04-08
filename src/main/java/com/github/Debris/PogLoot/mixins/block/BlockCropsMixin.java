package com.github.Debris.PogLoot.mixins.block;

import com.github.Debris.PogLoot.config.PogLootConfig;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.BlockCrops;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Random;

@Mixin(BlockCrops.class)
public class BlockCropsMixin {
    @WrapOperation(method = "updateTick", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I", ordinal = 4))
    private int modifySpeed(Random instance, int i, Operation<Integer> original) {
        if (PogLootConfig.CropsCertainGrowth.getBooleanValue()) return 0;
        return original.call(instance, i);
    }
}
