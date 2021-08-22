package dev.latvian.mods.komputers.item;

import dev.latvian.mods.komputers.Komputers;
import net.minecraft.world.item.Item;

public class PocketComputerItem extends Item {
	public PocketComputerItem() {
		super(new Item.Properties().tab(Komputers.TAB).stacksTo(1).fireResistant());
	}
}
