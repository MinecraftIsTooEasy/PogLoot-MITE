package com.github.Debris.PogLoot.mixins.chest.stronghold;

import net.minecraft.ComponentStrongholdRoomCrossing;
import net.minecraft.Item;
import net.minecraft.WeightedRandomChestContent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.Random;

@Mixin(ComponentStrongholdRoomCrossing.class)
public class StrongholdRoomCrossingMixin {

    @ModifyArg(method = "addComponentParts", at = @At(value = "INVOKE", target = "Lnet/minecraft/ComponentStrongholdRoomCrossing;generateStructureChestContents(Lnet/minecraft/World;Lnet/minecraft/StructureBoundingBox;Ljava/util/Random;IIII[Lnet/minecraft/WeightedRandomChestContent;I[FLnet/minecraft/EnumDirection;)Z"), index = 7)
    private WeightedRandomChestContent[] inject(WeightedRandomChestContent[] par7ArrayOfWeightedRandomChestContent) {
        return new WeightedRandomChestContent[]{
                new WeightedRandomChestContent(Item.carrot.itemID, 0, 1, 1, 5),
                new WeightedRandomChestContent(Item.potato.itemID, 0, 1, 1, 5),
                new WeightedRandomChestContent(Item.appleGold.itemID, 0, 1, 1, 1),
                Item.enchantedBook.func_92114_b(new Random())
        };
    }

    @ModifyArg(method = "addComponentParts", at = @At(value = "INVOKE", target = "Lnet/minecraft/ComponentStrongholdRoomCrossing;generateStructureChestContents(Lnet/minecraft/World;Lnet/minecraft/StructureBoundingBox;Ljava/util/Random;IIII[Lnet/minecraft/WeightedRandomChestContent;I[FLnet/minecraft/EnumDirection;)Z"), index = 8)
    private int inject(int par4) {
        return 4;
    }
}
