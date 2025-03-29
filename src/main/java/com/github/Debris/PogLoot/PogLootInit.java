package com.github.Debris.PogLoot;

import com.github.Debris.PogLoot.config.PogLootConfig;
import fi.dy.masa.malilib.config.ConfigManager;
import fi.dy.masa.malilib.interfaces.IInitializationHandler;

public class PogLootInit implements IInitializationHandler {
    @Override
    public void registerModHandlers() {
        ConfigManager.getInstance().registerConfig(PogLootConfig.getInstance());
    }
}
