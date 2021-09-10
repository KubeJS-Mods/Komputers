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

	Supplier<Item> COMPUTER_PARTS_BLOCK = blockItem("computer_parts_block", KomputersBlocks.COMPUTER_PARTS_BLOCK);
	Supplier<Item> COMPUTER_PARTS_BLOCK_CTM = blockItem("computer_parts_block_ctm", KomputersBlocks.COMPUTER_PARTS_BLOCK_CTM);
	Supplier<Item> COMPUTER = blockItem("computer", KomputersBlocks.COMPUTER);
	Supplier<Item> PERIPHERAL = blockItem("peripheral", KomputersBlocks.PERIPHERAL);
	Supplier<Item> LAMP = blockItem("lamp", KomputersBlocks.LAMP);
	Supplier<Item> SCREEN = blockItem("screen", KomputersBlocks.SCREEN);
	Supplier<Item> COMPUTER_PARTS = REGISTRY.register(Komputers.id("computer_parts"), () -> new Item(new Item.Properties().tab(Komputers.TAB)));
	Supplier<Item> POCKET_COMPUTER = REGISTRY.register(Komputers.id("pocket_computer"), PocketComputerItem::new);

	static void init() {
	}
}
