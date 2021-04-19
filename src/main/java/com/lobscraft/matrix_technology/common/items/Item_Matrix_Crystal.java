package com.lobscraft.matrix_technology.common.items;

import com.lobscraft.matrix_technology.MatrixTechnology;
import com.lobscraft.matrix_technology.util.IModelExisted;
import com.lobscraft.matrix_technology.util.handlers.ItemHandler;
import com.lobscraft.matrix_technology.util.loaders.CreativeTabLoader;
import net.minecraft.item.Item;

public class Item_Matrix_Crystal extends Item implements IModelExisted {
    private static final String name = "matrix_crystal";

    public Item_Matrix_Crystal() {
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(CreativeTabLoader.Matrix_Technology);
        ItemHandler.items.add(this);
    }

    @Override
    public void registerModel() {
        MatrixTechnology.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
