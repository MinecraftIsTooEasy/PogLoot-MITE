package com.github.Debris.PogLoot.mixins.block;

import com.github.Debris.PogLoot.config.PogLootConfig;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.BlockBreakInfo;
import net.minecraft.BlockDeadBush;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(BlockDeadBush.class)
public abstract class BlockDeadBushMixin {
    @Shadow public abstract boolean isWitherwood(int metadata);

    @ModifyArg(method = "dropBlockAsEntityItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/BlockDeadBush;dropBlockAsEntityItem(Lnet/minecraft/BlockBreakInfo;IIIF)I"), index = 4)
    private float bushDropStickDate(float par5, @Local(argsOnly = true) BlockBreakInfo info) {
        if (this.isWitherwood(info.getMetadata())) {
            return (float) PogLootConfig.WitherDeadBushDropStickRate.getDoubleValue();
        } else {
            return (float) PogLootConfig.DeadBushDropStickRate.getDoubleValue();
        }
    }
}
