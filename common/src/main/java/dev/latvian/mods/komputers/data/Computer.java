package dev.latvian.mods.komputers.data;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.saveddata.SavedData;

public class Computer extends SavedData {
	public final long id;

	public Computer(long l) {
		super(String.format("komputers_%016x", l));
		id = l;
	}

	@Override
	public void load(CompoundTag tag) {
	}

	@Override
	public CompoundTag save(CompoundTag tag) {
		return tag;
	}
}
