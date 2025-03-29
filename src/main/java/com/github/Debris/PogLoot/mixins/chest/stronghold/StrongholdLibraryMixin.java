package com.github.Debris.PogLoot.mixins.chest.stronghold;

import com.github.Debris.PogLoot.config.PogLootConfig;
import net.minecraft.ComponentStrongholdLibrary;
import net.minecraft.Item;
import net.minecraft.WeightedRandomChestContent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import java.util.Random;


@Mixin(ComponentStrongholdLibrary.class)
public class StrongholdLibraryMixin {

    @ModifyArg(method = "addComponentParts", at = @At(value = "INVOKE", target = "Lnet/minecraft/ComponentStrongholdLibrary;generateStructureChestContents(Lnet/minecraft/World;Lnet/minecraft/StructureBoundingBox;Ljava/util/Random;IIII[Lnet/minecraft/WeightedRandomChestContent;I[FLnet/minecraft/EnumDirection;)Z"), index = 7)
    private WeightedRandomChestContent[] inject(WeightedRandomChestContent[] par8) {
        if (PogLootConfig.StrongholdLootOnlyTheTreasureRemains.getBooleanValue())
            return new WeightedRandomChestContent[]{
                Item.enchantedBook.func_92112_a(new Random(), 1, 5, 2)};
        else return par8;
    }

    @ModifyArg(method = "addComponentParts", at = @At(value = "INVOKE", target = "Lnet/minecraft/ComponentStrongholdLibrary;generateStructureChestContents(Lnet/minecraft/World;Lnet/minecraft/StructureBoundingBox;Ljava/util/Random;IIII[Lnet/minecraft/WeightedRandomChestContent;I[FLnet/minecraft/EnumDirection;)Z"), index = 8)
    private int inject(int par4) {
        if (PogLootConfig.StrongholdLootToolChancesMaximum.getBooleanValue()) return 4;
        else return par4;
    }


    @ModifyConstant(method = "addComponentParts", constant = @Constant(floatValue = 0.5F))
    private float maximize(float constant) {
        return (float) PogLootConfig.StrongholdArtifactChances.getDoubleValue();
    }
}
