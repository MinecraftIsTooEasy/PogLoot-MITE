package com.github.Debris.PogLoot.mixins.chest.misc;

import com.github.Debris.PogLoot.config.PogLootConfig;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.ItemEnchantedBook;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Random;

@Mixin(value = ItemEnchantedBook.class, priority = 0)
public class ItemEnchantedBookMixin {

    @WrapOperation(method = "func_92112_a", at = @At(value = "INVOKE", target = "Lnet/minecraft/MathHelper;getRandomIntegerInRange(Ljava/util/Random;II)I"), require = 0)
    private int alwaysChooseMaxLevel(Random par0Random, int par1, int par2, Operation<Integer> original) {
        if (PogLootConfig.LootEnchantmentBookMaxLevel.getBooleanValue()) return Math.max(par1, par2);
        return original.call(par0Random, par1, par2);
    }
}
