package com.test.testmod.common.blocks;

import com.test.testmod.TestMod;
import com.test.testmod.util.IModelExisted;
import com.test.testmod.util.handlers.BlockHandler;
import com.test.testmod.util.handlers.ItemHandler;
import com.test.testmod.util.loaders.TestModCreativeTab;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class Block_MatrixCystal_Meteorite extends Block implements IModelExisted {
    private final String name="matrix_crystal_meteorite";
    public Block_MatrixCystal_Meteorite() {
        super(Material.ROCK);
        setUnlocalizedName(name);
        setRegistryName(name);
        this.setCreativeTab(TestModCreativeTab.TESTMOD);
        this.setHardness(10.0f);
        this.setResistance(6.0f);
        this.setSoundType(SoundType.STONE);
        this.setHarvestLevel("pickaxe",1);
        BlockHandler.blocks.add(this);
        ItemHandler.items.add(new ItemBlock(this).setRegistryName(name));
    }
    @Override
    public void registerModel() {
        TestMod.proxy.registerItemRenderer(Item.getItemFromBlock(this),0,"inventory");
    }
}
