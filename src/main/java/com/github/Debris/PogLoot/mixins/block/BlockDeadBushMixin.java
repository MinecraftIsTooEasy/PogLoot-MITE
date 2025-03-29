package com.github.Debris.PogLoot.mixins.block;

import net.minecraft.BlockDeadBush;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(BlockDeadBush.class)
public class BlockDeadBushMixin {
    @ModifyArg(method = "dropBlockAsEntityItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/BlockDeadBush;dropBlockAsEntityItem(Lnet/minecraft/BlockBreakInfo;IIIF)I"), index = 4)
    private float inject_1(float par5) {
        return 1.0f;
    }
}
