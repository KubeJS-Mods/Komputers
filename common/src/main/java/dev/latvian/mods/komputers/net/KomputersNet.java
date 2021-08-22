package dev.latvian.mods.komputers.net;

import dev.latvian.mods.komputers.Komputers;
import me.shedaniel.architectury.networking.simple.MessageType;
import me.shedaniel.architectury.networking.simple.SimpleNetworkManager;

/**
 * @author LatvianModder
 */
public interface KomputersNet {
	SimpleNetworkManager NET = SimpleNetworkManager.create(Komputers.MOD_ID);

	MessageType PAINT = NET.registerS2C("knet_update", KNetUpdate::new);

	static void init() {
	}
}