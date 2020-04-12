package me.reconcubed.homeupdate.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.material.PushReaction;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import java.util.stream.Stream;

public class CarpentersBenchBlock extends Block {

    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    public static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(0, 14, 1.7763568394002505e-15, 16, 16, 16),
            Block.makeCuboidShape(-16, 14, 1.7763568394002505e-15, 0, 16, 16),
            Block.makeCuboidShape(10, 0, 1.7763568394002505e-15, 13, 3, 16),
            Block.makeCuboidShape(-13, 0, 1.7763568394002505e-15, -10, 3, 16),
            Block.makeCuboidShape(-12.5, 3, 11.5, -10.5, 14, 13.5),
            Block.makeCuboidShape(-12.5, 3, 2.5000000000000018, -10.5, 14, 4.500000000000002),
            Block.makeCuboidShape(10.5, 3, 11.5, 12.5, 14, 13.5),
            Block.makeCuboidShape(10.5, 3, 2.5000000000000018, 12.5, 14, 4.500000000000002),
            Block.makeCuboidShape(-13.5, 7.5, 12.25, 13.5, 9.5, 12.75),
            Block.makeCuboidShape(-13.5, 7.5, 3.2500000000000018, 13.5, 9.5, 3.7500000000000018)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(16, 14, 0, 32, 16, 16),
            Block.makeCuboidShape(0, 14, 0, 16, 16, 16),
            Block.makeCuboidShape(3, 0, 0, 6, 3, 16),
            Block.makeCuboidShape(26, 0, 0, 29, 3, 16),
            Block.makeCuboidShape(26.5, 3, 2.5, 28.5, 14, 4.5),
            Block.makeCuboidShape(26.5, 3, 11.5, 28.5, 14, 13.5),
            Block.makeCuboidShape(3.5, 3, 2.5, 5.5, 14, 4.5),
            Block.makeCuboidShape(3.5, 3, 11.5, 5.5, 14, 13.5),
            Block.makeCuboidShape(2.5, 7.5, 12.25, 29.5, 9.5, 12.75),
            Block.makeCuboidShape(2.5, 7.5, 3.25, 29.5, 9.5, 3.75)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(0, 14, -16, 16, 16, 0),
            Block.makeCuboidShape(0, 14, 0, 16, 16, 16),
            Block.makeCuboidShape(0, 0, 10, 16, 3, 13),
            Block.makeCuboidShape(0, 0, -13, 16, 3, -10),
            Block.makeCuboidShape(2.5, 3, -12.5, 4.5, 14, -10.5),
            Block.makeCuboidShape(11.5, 3, -12.5, 13.5, 14, -10.5),
            Block.makeCuboidShape(2.5, 3, 10.5, 4.5, 14, 12.5),
            Block.makeCuboidShape(11.5, 3, 10.5, 13.5, 14, 12.5),
            Block.makeCuboidShape(12.25, 7.5, -13.5, 12.75, 9.5, 13.5),
            Block.makeCuboidShape(3.25, 7.5, -13.5, 3.75, 9.5, 13.5)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

public static final VoxelShape SHAPE_W = Stream.of(
        Block.makeCuboidShape(0, 14, 16, 16, 16, 32),
        Block.makeCuboidShape(0, 14, 0, 16, 16, 16),
        Block.makeCuboidShape(0, 0, 3, 16, 3, 6),
        Block.makeCuboidShape(0, 0, 26, 16, 3, 29),
        Block.makeCuboidShape(11.5, 3, 26.5, 13.5, 14, 28.5),
        Block.makeCuboidShape(2.5, 3, 26.5, 4.5, 14, 28.5),
        Block.makeCuboidShape(11.5, 3, 3.5, 13.5, 14, 5.5),
        Block.makeCuboidShape(2.5, 3, 3.5, 4.5, 14, 5.5),
        Block.makeCuboidShape(3.25, 7.5, 2.5, 3.75, 9.5, 29.5),
        Block.makeCuboidShape(12.25, 7.5, 2.5, 12.75, 9.5, 29.5)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public CarpentersBenchBlock(Properties builder) {
        super(builder);
        this.setDefaultState(this.getDefaultState()
                .with(FACING, Direction.NORTH)
        );
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch(state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case EAST:
                return SHAPE_E;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }


    /**
     * Returns the blockstate with the given rotation from the passed blockstate.
     * If inapplicable, returns the passed blockstate.
     *
     * @deprecated call via {@link BlockState#rotate(Rotation)} whenever possible. Implementing/overriding is fine.
     */
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    /**
     * Returns the blockstate with the given mirror of the passed blockstate.
     * If inapplicable, returns the passed blockstate.
     *
     * @deprecated call via {@link BlockState#mirror(Mirror)} whenever possible. Implementing/overriding is fine.
     */
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

}
