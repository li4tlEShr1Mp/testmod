package com.test.testmod.common.blocks;

import com.test.testmod.TestMod;
import com.test.testmod.util.IModelExisted;
import com.test.testmod.util.handlers.BlockHandler;
import com.test.testmod.util.handlers.ItemHandler;
import com.test.testmod.util.loaders.CreativeTabLoader;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class Block_Mithril extends Block implements IModelExisted {
    private static final String name="mithril";

    public Block_Mithril() {
        super(Material.ROCK);
        this.setCreativeTab(CreativeTabLoader.TESTMOD);
        this.setHardness(10f);
        this.setHarvestLevel("pickaxe",3);
        this.setLightLevel(10/15.0f);
        this.setSoundType(SoundType.STONE);
        this.setResistance(8.0f);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        BlockHandler.blocks.add(this);
        ItemHandler.items.add(new ItemBlock(this).setRegistryName(name));


    }

    @Override
    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack) {
        super.harvestBlock(worldIn, player, pos, state, te, stack);
    }

    @Override
    public void registerModel() {
        TestMod.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");

    }
}

