package com.github.Debris.PogLoot.config;

import fi.dy.masa.malilib.config.ConfigTab;
import fi.dy.masa.malilib.config.SimpleConfigs;
import fi.dy.masa.malilib.config.options.*;

import java.util.ArrayList;
import java.util.List;

import static com.github.Debris.PogLoot.PogLootInit.MOD_ID;

public class PogLootConfig extends SimpleConfigs {
    public static final PogLootConfig Instance;

    private static final String WorldGenWarning = "[§4影响世界生成§r]";

    private PogLootConfig(String name, List<ConfigHotkey> hotkeys, List<ConfigBase<?>> values) {
        super(name, hotkeys, values);
    }

    public static final List<ConfigBase<?>> settings;
    public static final List<ConfigBase<?>> ints;
    public static final List<ConfigBase<?>> rates;
    public static final List<ConfigBase<?>> oreSize;
    public static final List<ConfigTab> tabs;
    public static final List<ConfigBase<?>> values;

    // settings
    public static final ConfigBoolean ArtifactUnchecked = new ConfigBoolean("创世之书无检查", WorldGenWarning + "创世之书生成不再检查条件");
    public static final ConfigBoolean ArtifactUnlimited = new ConfigBoolean("创世之书无限制", WorldGenWarning + "创世之书不再只有9本");
    public static final ConfigBoolean MetalToolsUnchecked = new ConfigBoolean("金属工具无检查", WorldGenWarning + "金属工具不再检查天数");
    public static final ConfigBoolean LootEnchantmentBookMaxLevel = new ConfigBoolean("战利品箱子附魔书强制最大等级", true, WorldGenWarning);
    public static final ConfigBoolean LootItemMaxNum = new ConfigBoolean("战利品箱子物品强制最大数量", true, WorldGenWarning);
    public static final ConfigBoolean StrongholdLootToolChancesMaximum = new ConfigBoolean("要塞战利品箱工具始终生成最大数量", true, WorldGenWarning);
    public static final ConfigBoolean StrongholdLootOnlyTreasure = new ConfigBoolean("要塞战利品箱只保留宝藏", true, WorldGenWarning);
    public static final ConfigBoolean VillageLootToolChancesMaximum = new ConfigBoolean("村庄战利品箱工具始终生成最大数量", true, WorldGenWarning);
    public static final ConfigBoolean DesertPyramidLootToolChancesMaximum = new ConfigBoolean("沙漠神殿战利品箱工具始终生成最大数量", true, WorldGenWarning);
    public static final ConfigBoolean DesertPyramidLootOnlyTreasure = new ConfigBoolean("沙漠神殿战利品箱只保留宝藏", true, WorldGenWarning);
    public static final ConfigBoolean JungleTempleLootToolChancesMaximum = new ConfigBoolean("丛林神庙战利品箱工具始终生成最大数量", true, WorldGenWarning);
    public static final ConfigBoolean JungleTempleLootOnlyTreasure = new ConfigBoolean("丛林神庙战利品箱只保留宝藏", true, WorldGenWarning);
    public static final ConfigBoolean MineshaftLootToolChancesMaximum = new ConfigBoolean("废弃矿道战利品箱子矿车工具始终生成最大数量", true, WorldGenWarning);
    public static final ConfigBoolean SwampHutLootToolChancesMaximum = new ConfigBoolean("女巫小屋战利品箱工具始终生成最大数量", true, WorldGenWarning);
    public static final ConfigBoolean SwampHutLootOnlyTreasure = new ConfigBoolean("女巫小屋战战利品箱只保留宝藏", true, WorldGenWarning);
    public static final ConfigBoolean DungeonsLootOnlyTreasure = new ConfigBoolean("地牢战战利品箱只保留宝藏", true, WorldGenWarning);
    public static final ConfigBoolean AnimalsMaximumChanceOfDroppingLoot = new ConfigBoolean("动物掉落战利品概率最大化", true);
    public static final ConfigBoolean MonsterMaximumChanceOfDroppingLoot = new ConfigBoolean("怪物掉落战利品概率最大化", true);
    public static final ConfigBoolean UltraFortune = new ConfigBoolean("超级时运", true, "小于1概率改为必掉, 1以上概率改为必翻倍");
    public static final ConfigBoolean LootNoSlotOverlap = new ConfigBoolean("战利品避免槽位重叠", true, WorldGenWarning + "原版中会出现覆盖现象");
    public static final ConfigBoolean LapisDropRateMaximum = new ConfigBoolean("青金石矿石掉落概率最大化", true);
    public static final ConfigBoolean RedstoneDropRateMaximum = new ConfigBoolean("红石矿石掉落概率最大化", true);
    public static final ConfigBoolean GravelDropRateMaximum = new ConfigBoolean("沙砾掉落概率最大化", true);
    public static final ConfigBoolean DisableStoneBrokenOoze = new ConfigBoolean("禁止破坏石头产生灰色史莱姆", true);
    public static final ConfigBoolean DisableBucketMelting = new ConfigBoolean("禁止桶融毁", true);
    public static final ConfigBoolean CropsCertainGrowth = new ConfigBoolean("作物必生长", true, "配合随机刻速度调节更佳");


    // ints
    public static final ConfigInteger RandomTickSpeed = new ConfigInteger("随机刻速度", 10, 0, 10000, "原版默认3");


    // rates
    public static final ConfigDouble LeavesTickRate = new ConfigDouble("树叶更新时掉落物品概率", 0.01D, 0.0D, 1.0D, false, "游戏默认0.002");
    public static final ConfigDouble LeavesDropFruitRate = new ConfigDouble("树叶破坏时掉落水果概率", 0.1D, 0.0D, 1.0D, false, "游戏默认0.005\n树叶掉落物顺序: 树苗, 木棍, 水果\n前者成功掉落时, 后者将跳过\n若超级时运开启, 概率不为0者将必定成功掉落, 跳过其后的物品");
    public static final ConfigDouble LeavesDropSaplingRate = new ConfigDouble("树叶破坏时掉落树苗概率", 0.1D, 0.0D, 1.0D, false, "游戏默认0.01\n树叶掉落物顺序: 树苗, 木棍, 水果\n前者成功掉落时, 后者将跳过\n若超级时运开启, 概率不为0者将必定成功掉落, 跳过其后的物品");
    public static final ConfigDouble LeavesDropStickRate = new ConfigDouble("树叶破坏时掉落木棍概率", 0.5D, 0.0D, 1.0D, false, "游戏默认0.05\n树叶掉落物顺序: 树苗, 木棍, 水果\n前者成功掉落时, 后者将跳过\n若超级时运开启, 概率不为0者将必定成功掉落, 跳过其后的物品");
    public static final ConfigDouble DeadBushDropStickRate = new ConfigDouble("枯死的灌木破坏时掉落木棍概率", 1.0D, 0.0D, 1.0D, false, "游戏默认0.05");
    public static final ConfigDouble WitherDeadBushDropStickRate = new ConfigDouble("凋灵灌木破坏时掉落木棍概率", 1.0D, 0.0D, 1.0D, false, "游戏默认0.5");
    public static final ConfigDouble GrassDropSeedRate = new ConfigDouble("草破坏时掉落种子概率", 1.0D, 0.0D, 1.0D, false, "游戏默认0.2");
    public static final ConfigDouble StrongholdArtifactChances = new ConfigDouble("要塞创世之书概率", 1.0D, 0.0D, 1.0D, false, WorldGenWarning + "游戏默认0.5");
    public static final ConfigDouble DesertPyramidArtifactChances = new ConfigDouble("沙漠神殿创世之书概率", 1.0D, 0.0D, 1.0D, false, WorldGenWarning + "游戏默认0.1");
    public static final ConfigDouble JungleTempleArtifactChances = new ConfigDouble("丛林神庙创世之书概率", 1.0D, 0.0D, 1.0D, false, WorldGenWarning + "游戏默认0.25");
    public static final ConfigDouble EatRottenFleshPoisonChance = new ConfigDouble("食用腐肉中毒概率", 0.0D, 0.0D, 1.0D, false, "游戏默认0.8");


    // ore
    public static final ConfigBoolean VeinSizeOverride = new ConfigBoolean("矿脉大小覆写", false, WorldGenWarning + "需重启游戏生效");
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
                StrongholdLootOnlyTreasure,
                VillageLootToolChancesMaximum,
                DesertPyramidLootToolChancesMaximum,
                DesertPyramidLootOnlyTreasure,
                JungleTempleLootToolChancesMaximum,
                JungleTempleLootOnlyTreasure,
                MineshaftLootToolChancesMaximum,
                SwampHutLootToolChancesMaximum,
                SwampHutLootOnlyTreasure,
                DungeonsLootOnlyTreasure,
                AnimalsMaximumChanceOfDroppingLoot,
                MonsterMaximumChanceOfDroppingLoot,
                UltraFortune,
                LootNoSlotOverlap,
                LapisDropRateMaximum,
                RedstoneDropRateMaximum,
                GravelDropRateMaximum,
                DisableStoneBrokenOoze,
                DisableBucketMelting,
                CropsCertainGrowth
        );
        ints = List.of(RandomTickSpeed);
        rates = List.of(LeavesTickRate, LeavesDropFruitRate, LeavesDropSaplingRate, LeavesDropStickRate,
                DeadBushDropStickRate, WitherDeadBushDropStickRate, GrassDropSeedRate, StrongholdArtifactChances,
                DesertPyramidArtifactChances, JungleTempleArtifactChances, EatRottenFleshPoisonChance);
        oreSize = List.of(VeinSizeOverride, CoalSize, CopperSize, SilverSize, GoldSize, IronSize, MithrilSize, AdamantiumSize, RedstoneSize, DiamondSize, LapisSize);
        tabs = new ArrayList<>();
        tabs.add(new ConfigTab("设定", settings));
        tabs.add(new ConfigTab("数值", ints));
        tabs.add(new ConfigTab("掉率", rates));
        tabs.add(new ConfigTab("矿脉大小", oreSize));

        values = new ArrayList<>();
        values.addAll(settings);
        values.addAll(ints);
        values.addAll(rates);
        values.addAll(oreSize);
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
