package com.github.Debris.PogLoot.mixins.block;

import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockGrass.class)
public abstract class BlockGrassMixin extends Block {
    protected BlockGrassMixin(int par1, Material par2Material, BlockConstants constants) {
        super(par1, par2Material, constants);
    }

    @Inject(method = "dropBlockAsEntityItem", at = @At("HEAD"), cancellable = true)
    private void inject(BlockBreakInfo info, CallbackInfoReturnable<Integer> cir) {// TODO
        if (info.wasHarvestedByPlayer() && !info.world.isFreezing(info.x, info.z)) {
            int fortune = info.getHarvesterFortune();
            if (fortune > 3) {
                fortune = 3;
            }
            if (info.world.isInRain(info.x, info.y + 1, info.z)) {
                fortune += 12;
            }
            if (fortune > 14) {
                fortune = 14;
            }
            if (info.world.rand.nextInt(16 - fortune) == 0) {
                cir.setReturnValue(this.dropBlockAsEntityItem(info, Item.wormRaw));
            }
        }
        cir.setReturnValue(this.dropBlockAsEntityItem(info, Block.dirt.blockID));
    }
}
