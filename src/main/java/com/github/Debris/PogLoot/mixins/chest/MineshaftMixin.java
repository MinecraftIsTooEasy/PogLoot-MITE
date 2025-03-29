package com.github.Debris.PogLoot.mixins.chest;

import com.github.Debris.PogLoot.config.PogLootConfig;
import net.minecraft.ComponentMineshaftCorridor;
import net.minecraft.Item;
import net.minecraft.WeightedRandomChestContent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.Random;

@Mixin(ComponentMineshaftCorridor.class)
public class MineshaftMixin {
    @ModifyArg(method = "addComponentParts", at = @At(value = "INVOKE", target = "Lnet/minecraft/ComponentMineshaftCorridor;generateStructureChestContents(Lnet/minecraft/World;Lnet/minecraft/StructureBoundingBox;Ljava/util/Random;IIII[Lnet/minecraft/WeightedRandomChestContent;I)Z"), index = 8)
    private int inject(int par4) {
        if (PogLootConfig.MineshaftLootToolChancesMaximum.getBooleanValue()) return 6;
        else return par4;
    }
}
