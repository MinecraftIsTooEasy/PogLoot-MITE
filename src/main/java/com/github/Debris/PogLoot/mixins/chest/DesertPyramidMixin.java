package com.github.Debris.PogLoot.mixins.chest;

import com.github.Debris.PogLoot.config.PogLootConfig;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import java.util.Random;

@Mixin(ComponentScatteredFeatureDesertPyramid.class)
public class DesertPyramidMixin {

    @ModifyArg(method = "addComponentParts", at = @At(value = "INVOKE", target = "Lnet/minecraft/ComponentScatteredFeatureDesertPyramid;generateStructureChestContents(Lnet/minecraft/World;Lnet/minecraft/StructureBoundingBox;Ljava/util/Random;IIII[Lnet/minecraft/WeightedRandomChestContent;I[FLnet/minecraft/EnumDirection;)Z"), index = 7)
    private WeightedRandomChestContent[] inject(WeightedRandomChestContent[] par8) {
        if (PogLootConfig.DesertPyramidLootOnlyTreasure.getBooleanValue())
            return new WeightedRandomChestContent[]{
                new WeightedRandomChestContent(Item.shardDiamond.itemID, 0, 1, 3, 1),//3
                new WeightedRandomChestContent(Item.goldNugget.itemID, 0, 2, 7, 1),//15
                new WeightedRandomChestContent(Item.shardEmerald.itemID, 0, 1, 3, 1),//2
                Item.enchantedBook.func_92114_b(new Random())};
        else return par8;
    }

    @ModifyArg(method = "addComponentParts", at = @At(value = "INVOKE", target = "Lnet/minecraft/ComponentScatteredFeatureDesertPyramid;generateStructureChestContents(Lnet/minecraft/World;Lnet/minecraft/StructureBoundingBox;Ljava/util/Random;IIII[Lnet/minecraft/WeightedRandomChestContent;I[FLnet/minecraft/EnumDirection;)Z"), index = 8)
    private int inject(int par4) {
        if (PogLootConfig.DesertPyramidLootToolChancesMaximum.getBooleanValue()) return 6;
        else return par4;
    }

    @ModifyConstant(method = "addComponentParts", constant = @Constant(floatValue = 0.1f))
    private float maximize(float constant) {
        return (float) PogLootConfig.DesertPyramidArtifactChances.getDoubleValue();
    }
}
