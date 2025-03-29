package com.github.Debris.PogLoot.mixins.block;

import net.minecraft.BlockTallGrass;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(BlockTallGrass.class)
public class BlockTallGrassMixin {
    @ModifyArg(method = "dropBlockAsEntityItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/BlockTallGrass;dropBlockAsEntityItem(Lnet/minecraft/BlockBreakInfo;IIIF)I"), index = 4)
    private float fullLoot(float par5) {
        return 1.0f;
    }
}
