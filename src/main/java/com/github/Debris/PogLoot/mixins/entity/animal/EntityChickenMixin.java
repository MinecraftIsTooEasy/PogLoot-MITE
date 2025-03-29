package com.github.Debris.PogLoot.mixins.entity.animal;

import com.github.Debris.PogLoot.config.PogLootConfig;
import net.minecraft.EntityChicken;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(EntityChicken.class)
public class EntityChickenMixin {
    @Redirect(method = "produceGoods", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int inject(Random random, int x) {
        if (PogLootConfig.AnimalsMaximumChanceOfDroppingLoot.getBooleanValue()) return x == 20 ? 0 : 1;
        else return x;
    }
}
