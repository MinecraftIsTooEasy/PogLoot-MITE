package com.github.Debris.PogLoot.mixins.chest;

import com.github.Debris.PogLoot.config.PogLootConfig;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldGenDungeons.class)
public abstract class WorldGenDungeonsMixin {
    @Mutable
    @Shadow
    @Final
    private static WeightedRandomChestContent[] chest_contents_for_underworld;

    @Mutable
    @Shadow
    @Final
    private static WeightedRandomChestContent[] field_111189_a;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void inject(CallbackInfo ci) {
        if (PogLootConfig.DungeonsLootOnlyTheTreasureRemains.getBooleanValue()) {
            field_111189_a = new WeightedRandomChestContent[]{
                    new WeightedRandomChestContent(Item.carrot.itemID, 0, 1, 1, 5),
                    new WeightedRandomChestContent(Item.potato.itemID, 0, 1, 1, 5),
                    new WeightedRandomChestContent(Item.appleGold.itemID, 0, 1, 1, 1)};
            chest_contents_for_underworld = new WeightedRandomChestContent[]{
                    new WeightedRandomChestContent(Item.ingotAncientMetal.itemID, 0, 1, 4, 10)};
        }
    }
}
