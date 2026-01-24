package net.astro142.testmod4finale.item.custom;

import com.mojang.logging.LogUtils;
import net.astro142.testmod4finale.Utils.ModTags;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockCollisions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import java.util.function.Consumer;

public class ArtfulWand extends Item {
    public static final Logger LOGGER = LogUtils.getLogger();
    public ArtfulWand(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();
        Block wallBlock = Blocks.WHITE_CONCRETE;
        if(level.getBlockState(context.getClickedPos()).is(ModTags.Blocks.SPECIAL_WALL_BLOCKS)){
            wallBlock = Blocks.QUARTZ_BLOCK;
        }

            if(!level.isClientSide()) {
                final int xe = context.getHorizontalDirection().getStepX();
                final int xee = context.getClickedFace().getStepX();
                final int yee = context.getClickedFace().getStepY();
                final int zee = context.getClickedFace().getStepZ();
                Vec3i newoff = new Vec3i(xee,yee,zee);
                int addx = 1; int addz = 1;
                if(xe != 0){addx = 0;}else{addz = 0;}
                LOGGER.info("X{}",xe);
                level.setBlockAndUpdate(context.getClickedPos().offset(newoff.getX(),newoff.getY(),newoff.getZ()), wallBlock.defaultBlockState());
                level.setBlockAndUpdate(context.getClickedPos().offset(newoff.getX()+addx,newoff.getY(),newoff.getZ()+addz), wallBlock.defaultBlockState());
                level.setBlockAndUpdate(context.getClickedPos().offset(newoff.getX()-addx,newoff.getY(),newoff.getZ()-addz), wallBlock.defaultBlockState());
                level.setBlockAndUpdate(context.getClickedPos().offset(newoff.getX(),newoff.getY()+1,newoff.getZ()), wallBlock.defaultBlockState());
                level.setBlockAndUpdate(context.getClickedPos().offset(newoff.getX()+addx,newoff.getY()+1,newoff.getZ()+addz), wallBlock.defaultBlockState());
                level.setBlockAndUpdate(context.getClickedPos().offset(newoff.getX()-addx,newoff.getY()+1,newoff.getZ()-addz), wallBlock.defaultBlockState());

                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos().offset(0,1,0), SoundEvents.AMETHYST_CLUSTER_PLACE, SoundSource.BLOCKS);
            }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, TooltipDisplay tooltipDisplay, Consumer<Component> components, TooltipFlag tooltipFlag) {

        components.accept(Component.translatable("tooltip.testmod4finale.artful_wand.tooltip"));
        super.appendHoverText(pStack, pContext, tooltipDisplay, components, tooltipFlag);
    }

}
