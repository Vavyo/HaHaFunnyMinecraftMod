package com.example.examplemod.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class ExampleBlock extends Block {
    public ExampleBlock() {
        super(Properties.of(Material.METAL)
            .sound(SoundType.METAL)
            .strength(2.0f)
            .lightLevel(state -> state.getValue(BlockStateProperties.LIT) ? 10 : 2)
        );
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult trace)
    {
        if(world.isClientSide){
            BlockState state1 = state.cycle(BlockStateProperties.LIT);

            return ActionResultType.SUCCESS;
        } else {
            return ActionResultType.CONSUME;
        }

    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.LIT);
    }
}
