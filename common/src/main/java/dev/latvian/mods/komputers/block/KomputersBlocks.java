package dev.latvian.mods.komputers.block;

import dev.latvian.mods.komputers.Komputers;
import me.shedaniel.architectury.registry.Registries;
import me.shedaniel.architectury.registry.Registry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.util.function.Supplier;

public interface KomputersBlocks {
	Registry<Block> REGISTRY = Registries.get(Komputers.MOD_ID).get(net.minecraft.core.Registry.BLOCK_REGISTRY);

	Supplier<Block> COMPUTER_PARTS_BLOCK = REGISTRY.register(Komputers.id("computer_parts_block"), () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BLACK).strength(2F)));
	Supplier<Block> COMPUTER_PARTS_BLOCK_CTM = REGISTRY.register(Komputers.id("computer_parts_block_ctm"), () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BLACK).strength(2F)));
	Supplier<Block> COMPUTER = REGISTRY.register(Komputers.id("computer"), ComputerBlock::new);
	Supplier<Block> PERIPHERAL = REGISTRY.register(Komputers.id("peripheral"), PeripheralBlock::new);
	Supplier<Block> LAMP = REGISTRY.register(Komputers.id("lamp"), LampBlock::new);
	Supplier<Block> SCREEN = REGISTRY.register(Komputers.id("screen"), ScreenBlock::new);

	static void init() {
	}
}
