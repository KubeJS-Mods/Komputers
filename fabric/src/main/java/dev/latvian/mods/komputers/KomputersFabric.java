package dev.latvian.mods.komputers;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class KomputersFabric implements ModInitializer {
	@Override
	public void onInitialize() {
		Komputers.instance = new Komputers();
		FabricLoader.getInstance().getEntrypoints("komputers-init", KomputersInitializer.class).forEach(KomputersInitializer::onInit);
	}
}
