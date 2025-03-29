package com.github.Debris.PogLoot.mixins.item;

import com.github.Debris.PogLoot.config.PogLootConfig;
import net.minecraft.ItemFood;
import net.minecraft.Potion;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ItemFood.class)
public class ItemFoodMixin {
    @Shadow
    private float potionEffectProbability;

    @Shadow
    private int potionId;

    @Redirect(method = "setPotionEffect", at = @At(value = "FIELD", target = "Lnet/minecraft/ItemFood;potionEffectProbability:F", opcode = Opcodes.PUTFIELD))
    private void inject(ItemFood instance, float value) {
        if (this.potionId == Potion.poison.id && value < 1.0F) value = (float) PogLootConfig.EatRottenFleshPoisonChance.getDoubleValue();
        this.potionEffectProbability = value;
    }
}
