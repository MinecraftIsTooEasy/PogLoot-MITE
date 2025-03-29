package com.github.Debris.PogLoot.event;

import com.github.Debris.PogLoot.event.listener.GravelDropListener;
import moddedmite.rustedironcore.api.event.Handlers;

public class EventRegistry extends Handlers {
    public static void register() {
        GravelDrop.register(new GravelDropListener());
    }
}
