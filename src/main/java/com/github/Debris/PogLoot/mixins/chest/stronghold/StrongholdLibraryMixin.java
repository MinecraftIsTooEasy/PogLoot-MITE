package com.github.Debris.PogLoot.mixins.chest.stronghold;

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
        return new WeightedRandomChestContent[]{
                Item.enchantedBook.func_92112_a(new Random(), 1, 5, 2)};
    }

    @ModifyArg(method = "addComponentParts", at = @At(value = "INVOKE", target = "Lnet/minecraft/ComponentStrongholdLibrary;generateStructureChestContents(Lnet/minecraft/World;Lnet/minecraft/StructureBoundingBox;Ljava/util/Random;IIII[Lnet/minecraft/WeightedRandomChestContent;I[FLnet/minecraft/EnumDirection;)Z"), index = 8)
    private int inject(int par4) {
        return 4;
    }


    @ModifyConstant(method = "addComponentParts", constant = @Constant(floatValue = 0.5f))
    private float maximize(float constant) {
        return 1.0f;
    }
}
