package com.iamkaf.explodingsheep;

import com.iamkaf.explodingsheep.platform.Services;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

/**
 * Common entry point for the mod.
 * Replace the contents with your own implementation.
 */
public class ExplodingSheepMod {

    /**
     * Called during mod initialization for all loaders.
     */
    public static void init() {
        ExplodingSheepConstants.LOG.info("Initializing {} on {}...", ExplodingSheepConstants.MOD_NAME, Services.PLATFORM.getPlatformName());
    }
}
