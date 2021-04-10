package com.test.testmod.objects.items;

import com.test.testmod.TestMod;
import com.test.testmod.util.ModelExisted;
import com.test.testmod.util.handlers.ItemHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemDick extends Item implements ModelExisted {
    private final String name="dick";
    public ItemDick(){
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(CreativeTabs.TRANSPORTATION);
        ItemHandler.items.add(this);
    }

    @Override
    public void registerModel() {
        TestMod.proxy.registerItemRenderer(this,0,"inventory");
    }
}
