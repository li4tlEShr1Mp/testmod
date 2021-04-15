package com.test.testmod.common.crativetab;

import com.test.testmod.util.handlers.BlockHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTab_TestMod extends CreativeTabs {
    public CreativeTab_TestMod(){
        super("testmod");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(Item.getItemFromBlock(BlockHandler.IRON_METEORITE));
    }
}
