package dev.latvian.mods.komputers;

import me.shedaniel.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Komputers.MOD_ID)
public class KomputersForge {
	public KomputersForge() {
		EventBuses.registerModEventBus(Komputers.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
		Komputers.instance = new Komputers();
	}
}
