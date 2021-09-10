package dev.latvian.mods.komputers.block.entity;

import dev.latvian.mods.komputers.data.Computer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ComputerBlockEntity extends BlockEntity {
	public long computerId = 0L;
	public Computer<BlockEntity> computer;

	public ComputerBlockEntity() {
		super(KomputersBlockEntities.COMPUTER.get());
	}

	@Override
	public CompoundTag save(CompoundTag tag) {
		super.save(tag);
		tag.putLong("ComputerID", computerId);
		return tag;
	}

	@Override
	public void load(BlockState state, CompoundTag tag) {
		super.load(state, tag);
		computerId = tag.getLong("ComputerID");
	}

	@Override
	public String toString() {
		return String.format("Computer#%016x", computerId);
	}
}
