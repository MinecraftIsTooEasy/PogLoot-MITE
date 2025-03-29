package com.github.Debris.PogLoot.mixins.chest.misc;

import com.github.Debris.PogLoot.config.PogLootConfig;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WeightedRandomChestContent.class)
public class WeightedRandomMixin {
    @Shadow
    private int min_quantity;

    @Inject(method = "<init>(Lnet/minecraft/ItemStack;III)V", at = @At("TAIL"))
    private void alwaysMostQuantity(ItemStack item_stack, int min_quantity, int max_quantity, int weight, CallbackInfo ci) {
        this.min_quantity = max_quantity;
    }

    @Inject(method = "<init>(IIIII)V", at = @At("TAIL"))
    private void alwaysMostQuantity(int item_id, int subtype, int min_quantity, int max_quantity, int weight, CallbackInfo ci) {
        this.min_quantity = max_quantity;
    }


    @ModifyConstant(method = "tryAddArtifact", constant = @Constant(intValue = 10))
    private static int tryMore(int constant) {
        return 64;
    }


    @ModifyConstant(method = "tryAddArtifact", constant = @Constant(intValue = 40))
    private static int noDayNeeded(int constant) {
        return PogLootConfig.ArtifactUnchecked.get() ? 0 : 40;
    }

    @ModifyExpressionValue(method = "tryAddArtifact", at = @At(value = "INVOKE", target = "Lnet/minecraft/WorldInfo;hasAchievementUnlockedOrIsNull(Lnet/minecraft/Achievement;)Z"))
    private static boolean noAchievementNeeded(boolean original) {
        return PogLootConfig.ArtifactUnchecked.get() || original;
    }

    @ModifyExpressionValue(method = "tryAddArtifact", at = @At(value = "INVOKE", target = "Lnet/minecraft/WorldInfo;hasSignatureBeenAdded(I)Z"))
    private static boolean unlimited(boolean original) {
        return PogLootConfig.ArtifactUnlimited.get() || original;
    }

    @Redirect(method = "generateChestContents", at = @At(value = "INVOKE", target = "Lnet/minecraft/World;getDayOfWorld()I"))
    private static int noDayCheck(World instance) {
        return PogLootConfig.MetalToolsUnchecked.get() ? 1 << 30 : instance.getDayOfWorld();
    }

    @Redirect(method = "generateChestContents", at = @At(value = "INVOKE", target = "Lnet/minecraft/IInventory;setInventorySlotContents(ILnet/minecraft/ItemStack;)V"))
    private static void noOverlap(IInventory instance, int i, ItemStack itemStack) {
        int finalSlot = i;
        if (instance.getStackInSlot(i) != null) {
            int attempt = (i + 1) % instance.getSizeInventory();
            while (attempt != i) {
                if (instance.getStackInSlot(attempt) == null) finalSlot = attempt;
                attempt = (attempt + 1) % instance.getSizeInventory();
            }
        }
        instance.setInventorySlotContents(finalSlot, itemStack);
    }
}
