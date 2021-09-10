package dev.latvian.mods.komputers.block.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class PeripheralBlockEntity extends BlockEntity {
	public long peripheralId = 0L;

	public PeripheralBlockEntity() {
		super(KomputersBlockEntities.PERIPHERAL.get());
	}

	@Override
	public CompoundTag save(CompoundTag tag) {
		super.save(tag);
		tag.putLong("PeripheralID", peripheralId);
		return tag;
	}

	@Override
	public void load(BlockState state, CompoundTag tag) {
		super.load(state, tag);
		peripheralId = tag.getLong("PeripheralID");
	}

	@Override
	public String toString() {
		return String.format("Peripheral#%016x", peripheralId);
	}
}
