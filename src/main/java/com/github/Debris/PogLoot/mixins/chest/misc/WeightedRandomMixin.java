package com.github.Debris.PogLoot.mixins.chest.misc;

import com.github.Debris.PogLoot.config.PogLootConfig;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.IInventory;
import net.minecraft.ItemStack;
import net.minecraft.WeightedRandomChestContent;
import net.minecraft.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WeightedRandomChestContent.class)
public class WeightedRandomMixin {
    @Shadow
    private int min_quantity;

    @Inject(method = "<init>(Lnet/minecraft/ItemStack;III)V", at = @At("TAIL"))
    private void alwaysMostQuantity(ItemStack item_stack, int min_quantity, int max_quantity, int weight, CallbackInfo ci) {
        if (PogLootConfig.LootItemMaxNum.getBooleanValue())
            this.min_quantity = max_quantity;
    }

    @Inject(method = "<init>(IIIII)V", at = @At("TAIL"))
    private void alwaysMostQuantity(int item_id, int subtype, int min_quantity, int max_quantity, int weight, CallbackInfo ci) {
        if (PogLootConfig.LootItemMaxNum.getBooleanValue())
            this.min_quantity = max_quantity;
    }

    @ModifyConstant(method = "tryAddArtifact", constant = @Constant(intValue = 10))
    private static int tryMore(int constant) {
        if (PogLootConfig.LootItemMaxNum.getBooleanValue()) return 64;
        return constant;
    }


    @ModifyConstant(method = "tryAddArtifact", constant = @Constant(intValue = 40))
    private static int noDayNeeded(int constant) {
        return PogLootConfig.ArtifactUnchecked.getBooleanValue() ? 0 : 40;
    }

    @ModifyExpressionValue(method = "tryAddArtifact", at = @At(value = "INVOKE", target = "Lnet/minecraft/WorldInfo;hasAchievementUnlockedOrIsNull(Lnet/minecraft/Achievement;)Z"))
    private static boolean noAchievementNeeded(boolean original) {
        return PogLootConfig.ArtifactUnchecked.getBooleanValue() || original;
    }

    @ModifyExpressionValue(method = "tryAddArtifact", at = @At(value = "INVOKE", target = "Lnet/minecraft/WorldInfo;hasSignatureBeenAdded(I)Z"))
    private static boolean unlimited(boolean original) {
        return PogLootConfig.ArtifactUnlimited.getBooleanValue() || original;
    }

    @WrapOperation(method = "generateChestContents", at = @At(value = "INVOKE", target = "Lnet/minecraft/World;getDayOfWorld()I"))
    private static int noDayCheck(World instance, Operation<Integer> original) {
        return PogLootConfig.MetalToolsUnchecked.getBooleanValue() ? 1 << 30 : original.call(instance);
    }

    @WrapOperation(method = "generateChestContents", at = @At(value = "INVOKE", target = "Lnet/minecraft/IInventory;setInventorySlotContents(ILnet/minecraft/ItemStack;)V"))
    private static void noSlotOverlap(IInventory instance, int slot, ItemStack itemStack, Operation<Void> original) {
        int finalSlot = slot;
        if (PogLootConfig.LootNoSlotOverlap.getBooleanValue() && instance.getStackInSlot(slot) != null) {
            int size = instance.getSizeInventory();
            int attempt = (slot + 1) % size;
            while (attempt != slot) {
                if (instance.getStackInSlot(attempt) == null) finalSlot = attempt;
                attempt = (attempt + 1) % size;
            }
        }
        original.call(instance, finalSlot, itemStack);
    }
}
