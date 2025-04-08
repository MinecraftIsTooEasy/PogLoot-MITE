package com.github.Debris.PogLoot.mixins.chest;

import com.github.Debris.PogLoot.config.PogLootConfig;
import net.minecraft.ComponentScatteredFeatureSwampHut;
import net.minecraft.Item;
import net.minecraft.WeightedRandomChestContent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(ComponentScatteredFeatureSwampHut.class)
public class SwampHutMixin {
    @ModifyArg(method = "addComponentParts", at = @At(value = "INVOKE", target = "Lnet/minecraft/ComponentScatteredFeatureSwampHut;generateStructureChestContents(Lnet/minecraft/World;Lnet/minecraft/StructureBoundingBox;Ljava/util/Random;IIII[Lnet/minecraft/WeightedRandomChestContent;I[FLnet/minecraft/EnumDirection;)Z"), index = 7)
    private WeightedRandomChestContent[] inject(WeightedRandomChestContent[] par8) {
        if (PogLootConfig.SwampHutLootOnlyTreasure.getBooleanValue())
            return new WeightedRandomChestContent[]{
                new WeightedRandomChestContent(Item.carrot.itemID, 0, 1, 2, 3),//77-79
                new WeightedRandomChestContent(Item.potato.itemID, 0, 1, 2, 3),//80-82
                new WeightedRandomChestContent(Item.potion.itemID, 16424, 1, 1, 1)//95 weak
            };
        else return par8;
    }

    @ModifyArg(method = "addComponentParts", at = @At(value = "INVOKE", target = "Lnet/minecraft/ComponentScatteredFeatureSwampHut;generateStructureChestContents(Lnet/minecraft/World;Lnet/minecraft/StructureBoundingBox;Ljava/util/Random;IIII[Lnet/minecraft/WeightedRandomChestContent;I[FLnet/minecraft/EnumDirection;)Z"), index = 8)
    private int inject(int par4) {
        if (PogLootConfig.SwampHutLootToolChancesMaximum.getBooleanValue()) return 8;
        else return par4;
    }
}
