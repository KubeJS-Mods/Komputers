package dev.latvian.mods.komputers.client;

import dev.latvian.mods.komputers.KomputersCommon;
import net.minecraft.client.Minecraft;

public class KomputersClient extends KomputersCommon {
	@Override
	public void init() {
		if (Minecraft.getInstance() == null) {
			return;
		}

		// ItemProperties.register()
	}

	@Override
	public void knetUpdate(long id, int value) {
	}
}
