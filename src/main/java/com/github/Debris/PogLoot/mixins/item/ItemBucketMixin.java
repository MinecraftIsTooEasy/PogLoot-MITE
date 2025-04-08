package com.github.Debris.PogLoot.mixins.item;

import com.github.Debris.PogLoot.config.PogLootConfig;
import net.minecraft.ItemBucket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemBucket.class)
public class ItemBucketMixin {
    @Inject(method = "getChanceOfMeltingWhenFilledWithLava", at = @At("HEAD"), cancellable = true)
    private void disableMelting(CallbackInfoReturnable<Float> cir) {
        if (PogLootConfig.DisableBucketMelting.getBooleanValue()) cir.setReturnValue(0.0F);
    }
}
