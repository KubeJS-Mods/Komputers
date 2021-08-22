package dev.latvian.mods.komputers.item;

import dev.latvian.mods.komputers.Komputers;
import dev.latvian.mods.komputers.block.KomputersBlocks;
import me.shedaniel.architectury.registry.Registries;
import me.shedaniel.architectury.registry.Registry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public interface KomputersItems {
	Registry<Item> REGISTRY = Registries.get(Komputers.MOD_ID).get(net.minecraft.core.Registry.ITEM_REGISTRY);

	static Supplier<Item> blockItem(String id, Supplier<Block> block) {
		return REGISTRY.register(Komputers.id(id), () -> new BlockItem(block.get(), new Item.Properties().tab(Komputers.TAB)));
	}

	Supplier<Item> COMPUTER = blockItem("computer", KomputersBlocks.COMPUTER);
	Supplier<Item> LAMP = blockItem("lamp", KomputersBlocks.LAMP);
	Supplier<Item> COMPUTER_PARTS = REGISTRY.register(Komputers.id("computer_parts"), () -> new Item(new Item.Properties().tab(Komputers.TAB)));
	Supplier<Item> POCKET_COMPUTER = REGISTRY.register(Komputers.id("pocket_computer"), PocketComputerItem::new);

	static void init() {
	}
}
