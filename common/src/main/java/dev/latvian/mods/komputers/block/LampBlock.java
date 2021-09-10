package dev.latvian.mods.komputers.block;

import dev.latvian.mods.komputers.item.KomputersItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.BlockHitResult;

public class LampBlock extends Block {
	public static final EnumProperty<LampColor> COLOR = EnumProperty.create("color", LampColor.class);
	public static final BooleanProperty ACTIVE = BooleanProperty.create("active");
	public static final BooleanProperty CTM = BooleanProperty.create("ctm");

	public LampBlock() {
		super(Properties.of(Material.METAL, MaterialColor.TERRACOTTA_WHITE).strength(1.5F).lightLevel(value -> value.getValue(ACTIVE) ? 15 : 0));

		registerDefaultState(defaultBlockState()
				.setValue(COLOR, LampColor.WHITE)
				.setValue(ACTIVE, false)
				.setValue(CTM, true)
		);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(COLOR, ACTIVE, CTM);
	}

	@Override
	@Deprecated
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		if (player.getItemInHand(hand).getItem() == KomputersItems.LAMP.get()) {
			return InteractionResult.PASS;
		}

		return InteractionResult.SUCCESS;
	}
}
