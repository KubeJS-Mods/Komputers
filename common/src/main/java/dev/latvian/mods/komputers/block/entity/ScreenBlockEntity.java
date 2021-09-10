package dev.latvian.mods.komputers.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ScreenBlockEntity extends BlockEntity {
	public BlockPos controllerPos = null;

	public ScreenBlockEntity() {
		super(KomputersBlockEntities.SCREEN.get());
	}

	@Override
	public CompoundTag save(CompoundTag tag) {
		super.save(tag);

		if (controllerPos != null) {
			tag.putInt("ControllerX", controllerPos.getX());
			tag.putInt("ControllerY", controllerPos.getY());
			tag.putInt("ControllerZ", controllerPos.getZ());
		}

		return tag;
	}

	@Override
	public void load(BlockState state, CompoundTag tag) {
		super.load(state, tag);
		controllerPos = null;

		if (tag.contains("ControllerX")) {
			controllerPos = new BlockPos(tag.getInt("ControllerX"), tag.getInt("ControllerY"), tag.getInt("ControllerZ"));
		}
	}
}
