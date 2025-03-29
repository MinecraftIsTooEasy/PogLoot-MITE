package com.github.Debris.PogLoot.config;

import fi.dy.masa.malilib.config.ConfigTab;
import fi.dy.masa.malilib.config.SimpleConfigs;
import fi.dy.masa.malilib.config.options.*;

import java.util.ArrayList;
import java.util.List;

import static com.github.Debris.PogLoot.PogLoot.MOD_ID;

public class PogLootConfig extends SimpleConfigs {
    public static final PogLootConfig Instance;

    public PogLootConfig(String name, List<ConfigHotkey> hotkeys, List<ConfigBase<?>> values) {
        super(name, hotkeys, values);
    }

    public static final List<ConfigBase<?>> settings;
    public static final List<ConfigBase<?>> rates;
    public static final List<ConfigBase<?>> oreSize;
    public static final List<ConfigTab> tabs;
    public static final List<ConfigBase<?>> values;

    // settings
    public static final ConfigBoolean ArtifactUnchecked = new ConfigBoolean("创世之书无检查", "创世之书生成不再检查条件");
    public static final ConfigBoolean ArtifactUnlimited = new ConfigBoolean("创世之书无限制", "创世之书不再只有9本");
    public static final ConfigBoolean MetalToolsUnchecked = new ConfigBoolean("金属工具无检查", "金属工具不再检查天数");

    // rates
    public static final ConfigDouble LeavesTickRate = new ConfigDouble("树叶更新时掉落物品概率", 0.01D, 0.0D, 1.0D, "游戏默认0.002");
    public static final ConfigDouble LeavesDropSaplingRate = new ConfigDouble("树叶破坏时掉落树苗概率", 0.1D, 0.0D, 1.0D, "游戏默认0.01");
    public static final ConfigDouble LeavesDropStickRate = new ConfigDouble("树叶破坏时掉落木棍概率", 0.5D, 0.0D, 1.0D, "游戏默认0.05");

    // ore
    public static final ConfigBoolean VeinSizeOverride = new ConfigBoolean("矿脉大小覆写", true);
    public static final ConfigInteger CoalSize = new ConfigInteger("煤矿大小", 16, 1, 32);
    public static final ConfigInteger CopperSize = new ConfigInteger("铜矿大小", 6, 1, 32);
    public static final ConfigInteger SilverSize = new ConfigInteger("银矿大小", 6, 1, 32);
    public static final ConfigInteger GoldSize = new ConfigInteger("金矿大小", 4, 1, 32);
    public static final ConfigInteger IronSize = new ConfigInteger("金矿大小", 6, 1, 32);
    public static final ConfigInteger MithrilSize = new ConfigInteger("秘银矿大小", 3, 1, 32);
    public static final ConfigInteger AdamantiumSize = new ConfigInteger("艾德曼矿大小", 3, 1, 32);
    public static final ConfigInteger RedstoneSize = new ConfigInteger("红石矿大小", 5, 1, 32);
    public static final ConfigInteger DiamondSize = new ConfigInteger("钻石矿大小", 3, 1, 32);
    public static final ConfigInteger LapisSize = new ConfigInteger("青金石矿大小", 3, 1, 32);

    static {
        settings = List.of(ArtifactUnchecked, ArtifactUnlimited, MetalToolsUnchecked);
        rates = List.of(LeavesTickRate, LeavesDropSaplingRate, LeavesDropStickRate);
        oreSize = List.of(VeinSizeOverride, CoalSize, CopperSize, SilverSize, GoldSize, IronSize, MithrilSize, AdamantiumSize, RedstoneSize, DiamondSize, LapisSize);
        tabs = new ArrayList<>();
        tabs.add(new ConfigTab("设定", settings));
        tabs.add(new ConfigTab("掉率", rates));
        tabs.add(new ConfigTab("矿脉大小", oreSize));

        values = new ArrayList<>();
        values.addAll(settings);
        values.addAll(rates);
        Instance = new PogLootConfig(MOD_ID, null, values);
    }

    @Override
    public List<ConfigTab> getConfigTabs() {
        return tabs;
    }

    public static PogLootConfig getInstance() {
        return Instance;
    }
}
