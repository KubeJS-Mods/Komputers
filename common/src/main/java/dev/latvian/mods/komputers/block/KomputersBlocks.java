package dev.latvian.mods.komputers.block;

import dev.latvian.mods.komputers.Komputers;
import me.shedaniel.architectury.registry.Registries;
import me.shedaniel.architectury.registry.Registry;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public interface KomputersBlocks {
	Registry<Block> REGISTRY = Registries.get(Komputers.MOD_ID).get(net.minecraft.core.Registry.BLOCK_REGISTRY);

	Supplier<Block> COMPUTER = REGISTRY.register(Komputers.id("computer"), ComputerBlock::new);
	Supplier<Block> LAMP = REGISTRY.register(Komputers.id("lamp"), LampBlock::new);

	static void init() {
	}
}
