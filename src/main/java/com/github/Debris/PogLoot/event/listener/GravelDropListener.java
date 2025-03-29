package com.github.Debris.PogLoot.event.listener;

import moddedmite.rustedironcore.api.event.listener.IGravelDropListener;
import net.minecraft.BlockBreakInfo;

public class GravelDropListener implements IGravelDropListener {
    @Override
    public float onDropAsGravelChanceModify(BlockBreakInfo info, float original) {
        return 0;
    }

    @Override
    public float onDropFlintAsChipChanceModify(BlockBreakInfo info, float original) {
        return 0;
    }
}
