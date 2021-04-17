package com.test.testmod.common.blocks;

import com.test.testmod.TestMod;
import com.test.testmod.util.IModelExisted;
import com.test.testmod.util.handlers.BlockHandler;
import com.test.testmod.util.handlers.ItemHandler;
import com.test.testmod.util.loaders.CreativeTabLoader;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class Block_Inner_Meteorite extends Block implements IModelExisted {
    private static final String name = "inner_meteorite";

    public Block_Inner_Meteorite() {
        super(Material.ROCK);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(CreativeTabLoader.TESTMOD);
        this.setHardness(10.0f);
        this.setResistance(6.0f);
        this.setSoundType(SoundType.STONE);
        this.setHarvestLevel("pickaxe", 1);
        BlockHandler.blocks.add(this);
        ItemHandler.items.add(new ItemBlock(this).setRegistryName(name));
    }

    @Override
    public void registerModel() {
        TestMod.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
