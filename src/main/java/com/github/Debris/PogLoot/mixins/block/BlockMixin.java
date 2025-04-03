package com.github.Debris.PogLoot.mixins.block;

import com.github.Debris.PogLoot.config.PogLootConfig;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Random;

@Mixin(Block.class)
public class BlockMixin {
    @WrapOperation(method = "dropBlockAsEntityItem(Lnet/minecraft/BlockBreakInfo;IIIF)I", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextFloat()F"))
    private float ultraFortune(Random instance, Operation<Float> original) {
        if (PogLootConfig.UltraFortune.getBooleanValue()) return 0;
        return original.call(instance);
    }
}
