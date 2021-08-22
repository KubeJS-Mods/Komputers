package dev.latvian.mods.komputers.block.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ComputerBlockEntity extends BlockEntity {
	public BlockEntityComputerHolder computerHolder;

	public ComputerBlockEntity() {
		super(KomputersBlockEntities.COMPUTER.get());
	}

	@Override
	public CompoundTag save(CompoundTag tag) {
		super.save(tag);

		if (computerHolder != null) {
			tag.putLong("ComputerID", computerHolder.id);
		}

		return tag;
	}

	@Override
	public void load(BlockState state, CompoundTag tag) {
		super.load(state, tag);

		long id = tag.getLong("ComputerID");
		computerHolder = id == 0L ? null : new BlockEntityComputerHolder(id, this);
	}
}
