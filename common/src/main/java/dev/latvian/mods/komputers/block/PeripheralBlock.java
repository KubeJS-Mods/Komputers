package dev.latvian.mods.komputers.block;

import dev.latvian.mods.komputers.block.entity.PeripheralBlockEntity;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class PeripheralBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {
	public static final VoxelShape[] SHAPES = {
			box(4D, 0D, 4D, 12D, 3D, 12D),
			box(4D, 13D, 4D, 12D, 16D, 12D),
			box(4D, 4D, 0D, 12D, 12D, 3D),
			box(4D, 4D, 13D, 12D, 12D, 16D),
			box(0D, 4D, 4D, 3D, 12D, 12D),
			box(13D, 4D, 4D, 16D, 12D, 12D)
	};

	public PeripheralBlock() {
		super(Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).strength(1.5F));

		registerDefaultState(defaultBlockState()
				.setValue(BlockStateProperties.FACING, Direction.DOWN)
				.setValue(BlockStateProperties.WATERLOGGED, false)
		);
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockGetter world) {
		return new PeripheralBlockEntity();
	}

	@Override
	@Deprecated
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext ctx) {
		return SHAPES[state.getValue(BlockStateProperties.FACING).ordinal()];
	}

	@Override
	@Deprecated
	public RenderShape getRenderShape(BlockState blockState) {
		return RenderShape.MODEL;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(BlockStateProperties.FACING, BlockStateProperties.WATERLOGGED);
	}

	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext ctx) {
		return defaultBlockState()
				.setValue(BlockStateProperties.FACING, ctx.getClickedFace().getOpposite())
				.setValue(BlockStateProperties.WATERLOGGED, ctx.getLevel().getFluidState(ctx.getClickedPos()).getType() == Fluids.WATER)
				;
	}

	@Override
	@Deprecated
	public FluidState getFluidState(BlockState state) {
		return state.getValue(BlockStateProperties.WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	@Deprecated
	public BlockState updateShape(BlockState state, Direction direction, BlockState changedState, LevelAccessor level, BlockPos pos, BlockPos changedPos) {
		if (state.getValue(BlockStateProperties.WATERLOGGED)) {
			level.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
		}

		return state;
	}

	@Override
	@Deprecated
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		if (!level.isClientSide()) {
			player.sendMessage(new TextComponent("Available peripherals: (Click to copy ID)"), Util.NIL_UUID);
		}

		return InteractionResult.SUCCESS;
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter level, BlockPos pos) {
		return !state.getValue(BlockStateProperties.WATERLOGGED);
	}
}
