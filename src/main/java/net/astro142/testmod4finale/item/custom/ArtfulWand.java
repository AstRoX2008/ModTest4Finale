package net.astro142.testmod4finale.item.custom;

import net.astro142.testmod4finale.block.ModBlocks;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class ArtfulWand extends Item {


    public ArtfulWand(Properties properties) {
        super(properties);
    }
    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();
        if(clickedBlock != ModBlocks.ARTFUL_CUBE.get().defaultBlockState().getBlock()){
            if(!level.isClientSide()) {
                level.setBlockAndUpdate(context.getClickedPos(), ModBlocks.ARTFUL_CUBE.get().defaultBlockState());

                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos(), SoundEvents.ALLAY_DEATH, SoundSource.BLOCKS);
            }
        }


        return InteractionResult.SUCCESS;
    }


}
