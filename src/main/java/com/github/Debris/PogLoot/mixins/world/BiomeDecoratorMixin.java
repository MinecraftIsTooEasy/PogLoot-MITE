package com.github.Debris.PogLoot.mixins.world;

import com.github.Debris.PogLoot.config.PogLootConfig;
import net.minecraft.BiomeDecorator;
import net.minecraft.BiomeGenBase;
import net.minecraft.WorldGenMinable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BiomeDecorator.class)
public class BiomeDecoratorMixin {
    @Shadow
    protected WorldGenMinable coalGen;

    @Shadow
    protected WorldGenMinable copperGen;

    @Shadow
    protected WorldGenMinable silverGen;

    @Shadow
    protected WorldGenMinable goldGen;

    @Shadow
    protected WorldGenMinable ironGen;

    @Shadow
    protected WorldGenMinable mithrilGen;

    @Shadow
    protected WorldGenMinable adamantiteGen;

    @Shadow
    protected WorldGenMinable redstoneGen;

    @Shadow
    protected WorldGenMinable diamondGen;

    @Shadow
    protected WorldGenMinable lapisGen;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void modifyOreSize(BiomeGenBase par1BiomeGenBase, CallbackInfo ci) {
        if (!PogLootConfig.VeinSizeOverride.getBooleanValue()) return;
        this.coalGen.numberOfBlocks = PogLootConfig.CoalSize.getIntegerValue();
        this.copperGen.numberOfBlocks = PogLootConfig.CopperSize.getIntegerValue();
        this.silverGen.numberOfBlocks = PogLootConfig.SilverSize.getIntegerValue();
        this.goldGen.numberOfBlocks = PogLootConfig.GoldSize.getIntegerValue();
        this.ironGen.numberOfBlocks = PogLootConfig.IronSize.getIntegerValue();
        this.mithrilGen.numberOfBlocks = PogLootConfig.MithrilSize.getIntegerValue();
        this.adamantiteGen.numberOfBlocks = PogLootConfig.AdamantiumSize.getIntegerValue();
        this.redstoneGen.numberOfBlocks = PogLootConfig.RedstoneSize.getIntegerValue();
        this.diamondGen.numberOfBlocks = PogLootConfig.DiamondSize.getIntegerValue();
        this.lapisGen.numberOfBlocks = PogLootConfig.LapisSize.getIntegerValue();
    }
}
