package com.iamkaf.explodingsheep;

import com.iamkaf.explodingsheep.ExplodingSheepConstants;
import com.iamkaf.explodingsheep.ExplodingSheepMod;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(ExplodingSheepConstants.MOD_ID)
public class ExplodingSheepNeoForge {
    public ExplodingSheepNeoForge(IEventBus eventBus) {
        ExplodingSheepMod.init();
    }
}