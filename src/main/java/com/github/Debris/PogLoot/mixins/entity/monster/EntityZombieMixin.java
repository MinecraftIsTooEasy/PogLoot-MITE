package com.github.Debris.PogLoot.mixins.entity.monster;

import com.github.Debris.PogLoot.config.PogLootConfig;
import net.minecraft.EntityZombie;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityZombie.class)
public class EntityZombieMixin {

    @Inject(method = "getBaseChanceOfRareDrop", at = @At("HEAD"), cancellable = true)
    private void alwaysDropRare(CallbackInfoReturnable<Integer> cir) {
        if (PogLootConfig.MonsterMaximumChanceOfDroppingLoot.getBooleanValue()) cir.setReturnValue(1);
    }
}
