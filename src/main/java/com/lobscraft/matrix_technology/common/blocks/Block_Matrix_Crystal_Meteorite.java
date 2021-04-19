package com.lobscraft.matrix_technology.common.blocks;

import com.lobscraft.matrix_technology.MatrixTechnology;
import com.lobscraft.matrix_technology.util.IModelExisted;
import com.lobscraft.matrix_technology.util.handlers.BlockHandler;
import com.lobscraft.matrix_technology.util.handlers.ItemHandler;
import com.lobscraft.matrix_technology.util.loaders.CreativeTabLoader;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class Block_Matrix_Crystal_Meteorite extends Block implements IModelExisted {
    private final String name = "matrix_crystal_meteorite";

    public Block_Matrix_Crystal_Meteorite() {
        super(Material.ROCK);
        setUnlocalizedName(name);
        setRegistryName(name);
        this.setCreativeTab(CreativeTabLoader.Matrix_Technology);
        this.setHardness(10.0f);
        this.setResistance(6.0f);
        this.setSoundType(SoundType.STONE);
        this.setHarvestLevel("pickaxe", 1);
        BlockHandler.blocks.add(this);
        ItemHandler.items.add(new ItemBlock(this).setRegistryName(name));
    }

    @Override
    public void registerModel() {
        MatrixTechnology.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
