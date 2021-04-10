package com.test.testmod.util.handlers;

import com.test.testmod.util.ModelExisted;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class RegistryHandler {
    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ItemHandler.items.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(BlockHandler.blocks.toArray(new Block[0]));
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
        for (Item item : ItemHandler.items) {
            if (item instanceof ModelExisted) {
                ((ModelExisted) item).registerModel();
            }
        }
        for (Block block :BlockHandler.blocks){
            if(block instanceof ModelExisted){
                ((ModelExisted) block).registerModel();
            }
        }
    }
}
