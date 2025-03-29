package com.github.Debris.PogLoot.mixins.chest;

import net.minecraft.ComponentVillageHouse2;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(ComponentVillageHouse2.class)
public class BlackSmithMixin {
    @ModifyArg(method = "addComponentParts", at = @At(value = "INVOKE", target = "Lnet/minecraft/ComponentVillageHouse2;generateStructureChestContents(Lnet/minecraft/World;Lnet/minecraft/StructureBoundingBox;Ljava/util/Random;IIII[Lnet/minecraft/WeightedRandomChestContent;I[FLnet/minecraft/EnumDirection;)Z"), index = 8)
    private int inject(int par4) {
        return 8;
    }
}
