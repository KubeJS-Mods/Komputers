package dev.latvian.mods.komputers;

import dev.latvian.mods.komputers.block.KomputersBlocks;
import dev.latvian.mods.komputers.block.entity.KomputersBlockEntities;
import dev.latvian.mods.komputers.client.KomputersClient;
import dev.latvian.mods.komputers.item.KomputersItems;
import dev.latvian.mods.komputers.net.KomputersNet;
import me.shedaniel.architectury.registry.CreativeTabs;
import me.shedaniel.architectury.utils.EnvExecutor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author LatvianModder
 */
public class Komputers {
	public static final String MOD_ID = "komputers";
	public static final String MOD_NAME = "Komputers";
	public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);

	public static ResourceLocation id(String path) {
		return new ResourceLocation(MOD_ID, path);
	}

	public static Komputers instance;
	public static KomputersCommon PROXY;
	public static final CreativeModeTab TAB = CreativeTabs.create(id("komputers"), () -> new ItemStack(KomputersItems.COMPUTER.get()));

	public Komputers() {
		PROXY = EnvExecutor.getEnvSpecific(() -> KomputersClient::new, () -> KomputersCommon::new);

		KomputersBlocks.init();
		KomputersBlockEntities.init();
		KomputersItems.init();
		KomputersNet.init();

		PROXY.init();
	}
}