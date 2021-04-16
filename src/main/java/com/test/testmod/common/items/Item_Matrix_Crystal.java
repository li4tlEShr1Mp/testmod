package com.test.testmod.common.items;

import com.test.testmod.TestMod;
import com.test.testmod.util.IModelExisted;
import com.test.testmod.util.handlers.ItemHandler;
import com.test.testmod.util.loaders.CreativeTabLoader;
import net.minecraft.item.Item;

public class Item_Matrix_Crystal extends Item implements IModelExisted {
    private static final String name="matrix_crystal";
    public Item_Matrix_Crystal() {
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(CreativeTabLoader.TESTMOD);
        ItemHandler.items.add(this);
    }

    @Override
    public void registerModel() {
        TestMod.proxy.registerItemRenderer(this,0,"inventory");
    }
}
