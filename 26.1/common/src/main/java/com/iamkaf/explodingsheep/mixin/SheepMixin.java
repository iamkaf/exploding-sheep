package com.iamkaf.explodingsheep.mixin;

import net.minecraft.world.entity.animal.sheep.Sheep;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Level.ExplosionInteraction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Sheep.class)
public class SheepMixin {

    @Inject(method = "ate()V", at = @At("TAIL"))
    private void explodingsheep$explodeWhenEatingGrass(CallbackInfo ci) {
        Sheep self = (Sheep) (Object) this;
        Level level = self.level();

        if (!level.isClientSide()) {
            level.explode(
                null,
                self.getX(),
                self.getY(),
                self.getZ(),
                4.0F,
                ExplosionInteraction.MOB
            );
            self.discard();
        }
    }
}
