package com.github.Debris.PogLoot.mixins.world;

import com.github.Debris.PogLoot.config.PogLootConfig;
import net.minecraft.WorldServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(WorldServer.class)
public class WorldServerMixin {
    @ModifyConstant(method = "tickBlocksAndAmbiance", constant = @Constant(intValue = 3, ordinal = 2))
    private int moreRandomTicks(int constant) {
        return PogLootConfig.RandomTickSpeed.getIntegerValue();
    }
}
