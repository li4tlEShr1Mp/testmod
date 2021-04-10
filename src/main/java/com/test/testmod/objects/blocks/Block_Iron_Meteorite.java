package com.test.testmod.objects.blocks;

import com.test.testmod.TestMod;
import com.test.testmod.util.ModelExisted;
import com.test.testmod.util.handlers.BlockHandler;
import com.test.testmod.util.handlers.ItemHandler;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class Block_Iron_Meteorite extends Block implements ModelExisted {
    private final String name="iron_meteorite";
    public Block_Iron_Meteorite() {
        super(Material.IRON);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        this.setHardness(10.0f);
        this.setResistance(6.0f);
        this.setSoundType(SoundType.STONE);
        BlockHandler.blocks.add(this);
        ItemHandler.items.add(new ItemBlock(this).setRegistryName(name));

    }

    @Override
    public void registerModel() {
        TestMod.proxy.registerItemRenderer(Item.getItemFromBlock(this),0,"inventory");
    }
}
