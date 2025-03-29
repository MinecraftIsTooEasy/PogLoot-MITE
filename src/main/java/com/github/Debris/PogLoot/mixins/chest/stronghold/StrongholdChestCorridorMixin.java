package com.github.Debris.PogLoot.mixins.chest.stronghold;

import net.minecraft.ComponentStrongholdChestCorridor;
import net.minecraft.Item;
import net.minecraft.WeightedRandomChestContent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.Random;

@Mixin(ComponentStrongholdChestCorridor.class)
public class StrongholdChestCorridorMixin {

    @ModifyArg(method = "addComponentParts", at = @At(value = "INVOKE", target = "Lnet/minecraft/ComponentStrongholdChestCorridor;generateStructureChestContents(Lnet/minecraft/World;Lnet/minecraft/StructureBoundingBox;Ljava/util/Random;IIII[Lnet/minecraft/WeightedRandomChestContent;I[FLnet/minecraft/EnumDirection;)Z"), index = 7)
    private WeightedRandomChestContent[] inject(WeightedRandomChestContent[] par7ArrayOfWeightedRandomChestContent) {
        return new WeightedRandomChestContent[]{
                Item.enchantedBook.func_92114_b(new Random())
        };
    }

    @ModifyArg(method = "addComponentParts", at = @At(value = "INVOKE", target = "Lnet/minecraft/ComponentStrongholdChestCorridor;generateStructureChestContents(Lnet/minecraft/World;Lnet/minecraft/StructureBoundingBox;Ljava/util/Random;IIII[Lnet/minecraft/WeightedRandomChestContent;I[FLnet/minecraft/EnumDirection;)Z"), index = 8)
    private int inject(int par4) {
        return 3;
    }
}
