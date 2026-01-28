package com.iamkaf.explodingsheep;

import com.iamkaf.amber.api.core.v2.AmberInitializer;
import com.iamkaf.explodingsheep.platform.Services;

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
        AmberInitializer.initialize(ExplodingSheepConstants.MOD_ID);
    }
}
