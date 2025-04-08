package com.github.Debris.PogLoot.mixins.world;

import com.github.Debris.PogLoot.config.PogLootConfig;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.ItemInWorldManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Random;

@Mixin(ItemInWorldManager.class)
public class ItemInWorldManagerMixin {
    @WrapOperation(method = "removeBlock", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I", ordinal = 0))
    private int disableOoze(Random instance, int i, Operation<Integer> original) {
        if (PogLootConfig.DisableStoneBrokenOoze.getBooleanValue()) return -1;
        return original.call(instance, i);
    }
}
