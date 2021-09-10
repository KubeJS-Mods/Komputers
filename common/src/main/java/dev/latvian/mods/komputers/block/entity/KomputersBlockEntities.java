package dev.latvian.mods.komputers.block.entity;

import dev.latvian.mods.komputers.Komputers;
import dev.latvian.mods.komputers.block.KomputersBlocks;
import me.shedaniel.architectury.registry.Registries;
import me.shedaniel.architectury.registry.Registry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public interface KomputersBlockEntities {
	Registry<BlockEntityType<?>> REGISTRY = Registries.get(Komputers.MOD_ID).get(net.minecraft.core.Registry.BLOCK_ENTITY_TYPE_REGISTRY);

	static <T extends BlockEntity> Supplier<BlockEntityType<T>> register(String id, Supplier<T> entity, Block... blocks) {
		return REGISTRY.register(Komputers.id(id), () -> BlockEntityType.Builder.of(entity, blocks).build(null));
	}

	Supplier<BlockEntityType<ComputerBlockEntity>> COMPUTER = register("computer", ComputerBlockEntity::new, KomputersBlocks.COMPUTER.get());
	Supplier<BlockEntityType<PeripheralBlockEntity>> PERIPHERAL = register("peripheral", PeripheralBlockEntity::new, KomputersBlocks.PERIPHERAL.get());
	Supplier<BlockEntityType<ScreenBlockEntity>> SCREEN = register("screen", ScreenBlockEntity::new, KomputersBlocks.SCREEN.get());

	static void init() {
	}
}
