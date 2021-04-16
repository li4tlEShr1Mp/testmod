package com.test.testmod.util.loaders;

import com.test.testmod.util.handlers.BlockHandler;
import com.test.testmod.util.handlers.ItemHandler;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SmeltingLoader {
    public static void load(){
        addSmelting(Item.getItemFromBlock(BlockHandler.IRON_METEORITE), Items.IRON_INGOT,1,3,1.5f);
    }
    private static void addSmelting(Item in, Item output,int inNum,int outNum,float experiences){
        GameRegistry.addSmelting(new ItemStack(in,inNum),new ItemStack(output,outNum),experiences);
    }
    private static void addSmelting(Item in, Item output,float experiences){
        GameRegistry.addSmelting(new ItemStack(in),new ItemStack(output),experiences);
    }
}
