package com.github.Debris.PogLoot.mixins.block;

import com.github.Debris.PogLoot.config.PogLootConfig;
import net.minecraft.BlockLeaves;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(BlockLeaves.class)
public class BlockLeavesMixin {

    @ModifyConstant(method = "updateTick", constant = @Constant(intValue = 500))
    private int leavesDropMore(int constant) {
        double doubleValue = PogLootConfig.LeavesTickRate.getDoubleValue();
        if (doubleValue == 0.0D) return Integer.MAX_VALUE;
        double reciprocal = 1.0D / doubleValue;
        return (int) reciprocal;
    }

    @ModifyConstant(method = "dropBlockAsEntityItem", constant = @Constant(floatValue = 0.005F))
    private float moreFruit(float constant) {
        return (float) PogLootConfig.LeavesDropFruitRate.getDoubleValue();
    }

    @ModifyConstant(method = "dropBlockAsEntityItem", constant = @Constant(floatValue = 0.01F))
    private float modifySapling(float constant) {
        return (float) PogLootConfig.LeavesDropSaplingRate.getDoubleValue();
    }

    @ModifyConstant(method = "dropBlockAsEntityItem", constant = @Constant(floatValue = 0.05F))
    private float modifyStick(float constant) {
        return (float) PogLootConfig.LeavesDropStickRate.getDoubleValue();
    }
}
