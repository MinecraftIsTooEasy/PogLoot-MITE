package com.github.Debris.PogLoot.mixins.entity.animal;

import com.github.Debris.PogLoot.config.PogLootConfig;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntitySheep.class)
public abstract class EntitySheepMixin extends EntityLivestock {
    @Shadow
    public abstract boolean getSheared();

    @Shadow
    public abstract int getFleeceColor();

    public EntitySheepMixin(World world) {
        super(world);
    }

    @Inject(method = "dropFewItems", at = @At("HEAD"), cancellable = true)
    private void inject(boolean recently_hit_by_player, DamageSource damage_source, CallbackInfo ci) {
        if (PogLootConfig.AnimalsMaximumChanceOfDroppingLoot.getBooleanValue()) {
            if (!this.getSheared() && !this.isBurning()) {
                this.dropItemStack(new ItemStack(Block.cloth.blockID, 1, this.getFleeceColor()));
            }
            if (this.isWell()) {
                int num_drops = 1 + damage_source.getButcheringModifier();
                for (int i = 0; i < num_drops; ++i) {
                    this.dropItem(this.isBurning() ? Item.lambchopCooked.itemID : Item.lambchopRaw.itemID, 1);
                }
            }
            this.dropItem(Item.leather.itemID, 1);
            ci.cancel();
        }
    }
}
