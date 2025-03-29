package com.github.Debris.PogLoot.event.listener;

import com.github.Debris.PogLoot.config.PogLootConfig;
import moddedmite.rustedironcore.api.event.listener.IGravelDropListener;
import net.minecraft.BlockBreakInfo;

public class GravelDropListener implements IGravelDropListener {
    @Override
    public float onDropAsGravelChanceModify(BlockBreakInfo info, float original) {
        if (PogLootConfig.GravelDropRateMaximum.getBooleanValue()) return 0;
        else return original;
    }

    @Override
    public float onDropFlintAsChipChanceModify(BlockBreakInfo info, float original) {
        if (PogLootConfig.GravelDropRateMaximum.getBooleanValue()) return 0;
        else return original;
    }
}
