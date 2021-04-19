package com.lobscraft.matrix_technology.util.handlers;

import com.lobscraft.matrix_technology.common.blocks.Block_Matrix_Crystal_Meteorite;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

@Mod.EventBusSubscriber
public class HarvestDropHandler {
    @SubscribeEvent()
    public static void Matrix_Crystal_Meteorite_Drops(BlockEvent.HarvestDropsEvent event) {
        if (event.getState().getBlock() instanceof Block_Matrix_Crystal_Meteorite) {
            if (!event.isSilkTouching()) {
                event.getDrops().clear();
                for (int i = 0; i <= event.getFortuneLevel(); i++) {
                    int j = (new Random().nextInt(event.getFortuneLevel()) + 3 - i) / 3;
                    event.getDrops().add(new ItemStack(ItemHandler.MATRIX_CRYSTAL, j));
                    if (j != 0)
                        event.getWorld().spawnEntity(new EntityXPOrb(event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), j * 3));
                }
            }
        }
    }
}
