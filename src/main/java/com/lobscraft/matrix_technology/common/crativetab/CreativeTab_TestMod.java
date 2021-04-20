package com.lobscraft.matrix_technology.common.crativetab;

import com.lobscraft.matrix_technology.util.handlers.BlockHandler;
import com.lobscraft.matrix_technology.util.handlers.ItemHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTab_TestMod extends CreativeTabs {
    public CreativeTab_TestMod() {
        super("matrix_technology");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ItemHandler.MATRIX_CRYSTAL);
    }
}
