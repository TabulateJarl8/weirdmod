package tech.tabulate.weirdmod.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import tech.tabulate.weirdmod.WeirdMod;

public class FunnyBlockEntity extends BlockEntity {

    public static int count = 0;

    public FunnyBlockEntity(BlockPos pos, BlockState state) {
        super(WeirdMod.FUNNY_BLOCK_ENTITY, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, FunnyBlockEntity be) {
        if (count == 0) {
            if (!world.isClient) {
                world.playSound(null, pos, WeirdMod.BEEP_SOUND_EVENT, SoundCategory.BLOCKS, 1f, 1f);
            }
        }
        count++;

        if (count == 33) {
            count = 0;
        }

    }


}
