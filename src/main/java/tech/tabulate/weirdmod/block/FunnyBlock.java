package tech.tabulate.weirdmod.block;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import tech.tabulate.weirdmod.WeirdMod;

public class FunnyBlock extends BlockWithEntity {

    public FunnyBlock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new FunnyBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, WeirdMod.FUNNY_BLOCK_ENTITY, (world1, pos, state1, be) -> FunnyBlockEntity.tick(world1, pos, state1, be));
    }
}
