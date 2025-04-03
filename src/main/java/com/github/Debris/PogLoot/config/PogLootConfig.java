package com.github.Debris.PogLoot.config;

import fi.dy.masa.malilib.config.ConfigTab;
import fi.dy.masa.malilib.config.SimpleConfigs;
import fi.dy.masa.malilib.config.options.*;

import java.util.ArrayList;
import java.util.List;

import static com.github.Debris.PogLoot.PogLootInit.MOD_ID;

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
    public static final ConfigBoolean LootEnchantmentBookMaxLevel = new ConfigBoolean("战利品箱子附魔书强制最大等级", true);
    public static final ConfigBoolean LootItemMaxNum = new ConfigBoolean("战利品箱子物品强制最大数量", true);
    public static final ConfigBoolean StrongholdLootToolChancesMaximum = new ConfigBoolean("要塞战利品箱工具始终生成最大数量", true);
    public static final ConfigBoolean StrongholdLootOnlyTheTreasureRemains = new ConfigBoolean("要塞战利品箱只保留宝藏", true);
    public static final ConfigBoolean VillageLootToolChancesMaximum = new ConfigBoolean("村庄战利品箱工具始终生成最大数量", true);
    public static final ConfigBoolean DesertPyramidLootToolChancesMaximum = new ConfigBoolean("沙漠神殿战利品箱工具始终生成最大数量", true);
    public static final ConfigBoolean DesertPyramidLootOnlyTheTreasureRemains = new ConfigBoolean("沙漠神殿战利品箱只保留宝藏", true);
    public static final ConfigBoolean JungleTempleLootToolChancesMaximum = new ConfigBoolean("丛林神庙战利品箱工具始终生成最大数量", true);
    public static final ConfigBoolean JungleTempleLootOnlyTheTreasureRemains = new ConfigBoolean("丛林神庙战利品箱只保留宝藏", true);
    public static final ConfigBoolean MineshaftLootToolChancesMaximum = new ConfigBoolean("废弃矿道战利品箱子矿车工具始终生成最大数量", true);
    public static final ConfigBoolean SwampHutLootToolChancesMaximum = new ConfigBoolean("女巫小屋战利品箱工具始终生成最大数量", true);
    public static final ConfigBoolean SwampHutLootOnlyTheTreasureRemains = new ConfigBoolean("女巫小屋战战利品箱只保留宝藏", true);
    public static final ConfigBoolean DungeonsLootOnlyTheTreasureRemains = new ConfigBoolean("地牢战战利品箱只保留宝藏", true);
    public static final ConfigBoolean AnimalsMaximumChanceOfDroppingLoot = new ConfigBoolean("动物掉落战利品概率最大化", true);
    public static final ConfigBoolean MonsterMaximumChanceOfDroppingLoot = new ConfigBoolean("怪物掉落战利品概率最大化", true);
    public static final ConfigBoolean UltraFortune = new ConfigBoolean("超级时运", true, "小于1概率改为必掉, 1以上概率改为必翻倍");
    public static final ConfigBoolean LootNoSlotOverlap = new ConfigBoolean("战利品避免槽位重叠", true, "原版中会出现覆盖现象");
    public static final ConfigBoolean LapisDropRateMaximum = new ConfigBoolean("青金石矿石掉落概率最大化", true);
    public static final ConfigBoolean RedstoneDropRateMaximum = new ConfigBoolean("红石矿石掉落概率最大化", true);
    public static final ConfigBoolean GravelDropRateMaximum = new ConfigBoolean("沙砾掉落概率最大化", true);

    // rates
    public static final ConfigDouble LeavesTickRate = new ConfigDouble("树叶更新时掉落物品概率", 0.01D, 0.0D, 1.0D, false, "游戏默认0.002");
    public static final ConfigDouble LeavesDropFruitRate = new ConfigDouble("树叶破坏时掉落水果概率", 0.1D, 0.0D, 1.0D, false, "游戏默认0.005");
    public static final ConfigDouble LeavesDropSaplingRate = new ConfigDouble("树叶破坏时掉落树苗概率", 0.1D, 0.0D, 1.0D, false, "游戏默认0.01");
    public static final ConfigDouble LeavesDropStickRate = new ConfigDouble("树叶破坏时掉落木棍概率", 0.5D, 0.0D, 1.0D, false, "游戏默认0.05");
    public static final ConfigDouble DeadBushDropStickRate = new ConfigDouble("枯死的灌木破坏时掉落木棍概率", 1.0D, 0.0D, 1.0D, false, "游戏默认0.05");
    public static final ConfigDouble WitherDeadBushDropStickRate = new ConfigDouble("凋灵灌木破坏时掉落木棍概率", 1.0D, 0.0D, 1.0D, false, "游戏默认0.5");
    public static final ConfigDouble GrassDropSeedRate = new ConfigDouble("草破坏时掉落种子概率", 1.0D, 0.0D, 1.0D, false, "游戏默认0.2");
    public static final ConfigDouble StrongholdArtifactChances = new ConfigDouble("要塞创世之书概率", 1.0D, 0.0D, 1.0D, false, "游戏默认0.5");
    public static final ConfigDouble DesertPyramidArtifactChances = new ConfigDouble("沙漠神殿创世之书概率", 1.0D, 0.0D, 1.0D, false, "游戏默认0.1");
    public static final ConfigDouble JungleTempleArtifactChances = new ConfigDouble("丛林神庙创世之书概率", 1.0D, 0.0D, 1.0D, false, "游戏默认0.25");
    public static final ConfigDouble EatRottenFleshPoisonChance = new ConfigDouble("食用腐肉中毒概率", 0.0D, 0.0D, 1.0D, false, "游戏默认0.8");

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
        settings = List.of(
                ArtifactUnchecked,
                ArtifactUnlimited,
                MetalToolsUnchecked,
                LootEnchantmentBookMaxLevel,
                LootItemMaxNum,
                StrongholdLootToolChancesMaximum,
                StrongholdLootOnlyTheTreasureRemains,
                VillageLootToolChancesMaximum,
                DesertPyramidLootToolChancesMaximum,
                DesertPyramidLootOnlyTheTreasureRemains,
                JungleTempleLootToolChancesMaximum,
                JungleTempleLootOnlyTheTreasureRemains,
                MineshaftLootToolChancesMaximum,
                SwampHutLootToolChancesMaximum,
                SwampHutLootOnlyTheTreasureRemains,
                DungeonsLootOnlyTheTreasureRemains,
                AnimalsMaximumChanceOfDroppingLoot,
                MonsterMaximumChanceOfDroppingLoot,
                UltraFortune,
                LootNoSlotOverlap,
                LapisDropRateMaximum,
                RedstoneDropRateMaximum,
                GravelDropRateMaximum
        );
        rates = List.of(LeavesTickRate, LeavesDropFruitRate, LeavesDropSaplingRate, LeavesDropStickRate,
                DeadBushDropStickRate, WitherDeadBushDropStickRate, GrassDropSeedRate, StrongholdArtifactChances,
                DesertPyramidArtifactChances, JungleTempleArtifactChances, EatRottenFleshPoisonChance);
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
