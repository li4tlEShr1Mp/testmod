package com.test.testmod.common.items;

import com.test.testmod.TestMod;
import com.test.testmod.util.IModelExisted;
import com.test.testmod.util.handlers.ItemHandler;
import com.test.testmod.util.loaders.TestModCreativeTab;
import net.minecraft.item.Item;

public class ItemDick extends Item implements IModelExisted {
    private final String name="dick";
    public ItemDick(){
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(TestModCreativeTab.TESTMOD);
        ItemHandler.items.add(this);
    }

    @Override
    public void registerModel() {
        TestMod.proxy.registerItemRenderer(this,0,"inventory");
    }
}
