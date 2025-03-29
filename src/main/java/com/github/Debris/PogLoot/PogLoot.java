package com.github.Debris.PogLoot;

import com.github.Debris.PogLoot.event.EventRegistry;
import fi.dy.masa.malilib.event.InitializationHandler;
import net.fabricmc.api.ModInitializer;

public class PogLoot implements ModInitializer {
    public static final String MOD_ID = "PogLoot";

    @Override
    public void onInitialize() {
        EventRegistry.register();
        InitializationHandler.getInstance().registerInitializationHandler(new PogLootInit());
    }
}