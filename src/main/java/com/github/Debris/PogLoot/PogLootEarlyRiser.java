package com.github.Debris.PogLoot;

import com.github.Debris.PogLoot.config.PogLootConfig;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;

public class PogLootEarlyRiser implements PreLaunchEntrypoint {
    @Override
    public void onPreLaunch() {
        PogLootConfig.getInstance().load();
    }
}
