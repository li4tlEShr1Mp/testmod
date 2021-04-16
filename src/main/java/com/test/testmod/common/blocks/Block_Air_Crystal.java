package com.test.testmod.common.blocks;

import com.test.testmod.TestMod;
import com.test.testmod.util.IModelExisted;
import com.test.testmod.util.handlers.BlockHandler;
import com.test.testmod.util.handlers.ItemHandler;
import com.test.testmod.util.loaders.CreativeTabLoader;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class Block_Air_Crystal extends Block implements IModelExisted {
    private static final String name="air_crystal";
    public Block_Air_Crystal() {
        super(Material.IRON);
        this.setCreativeTab(CreativeTabLoader.TESTMOD);
        this.setHardness(1.2f);
        this.setHarvestLevel("pickaxe",2);
        this.setSoundType(SoundType.GLASS);
        this.setResistance(8.5f);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setLightLevel(5/15.0f);
        this.setLightOpacity(12);
        BlockHandler.blocks.add(this);
        ItemHandler.items.add(new ItemBlock(this).setRegistryName(name));
    }

    @Override
    public void registerModel() {
        TestMod.proxy.registerItemRenderer(Item.getItemFromBlock(this),0,"inventory");
    }
}

