package com.lobscraft.matrix_technology.common.blocks;

import com.lobscraft.matrix_technology.MatrixTechnology;
import com.lobscraft.matrix_technology.util.IModelExisted;
import com.lobscraft.matrix_technology.util.handlers.BlockHandler;
import com.lobscraft.matrix_technology.util.handlers.ItemHandler;
import com.lobscraft.matrix_technology.util.loaders.CreativeTabLoader;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

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


    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        super.getDrops(drops, world, pos, state, fortune);
        drops.clear();
        for (int i = 0; i <= fortune; i++) {
            int j = fortune == 0 ? 1 : (new Random().nextInt(fortune + 1) + 3 - i) / 3;
            drops.add(new ItemStack(ItemHandler.MATRIX_CRYSTAL, j));
        }
    }

    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
        return super.getExpDrop(state, world, pos, fortune);
    }

    @Override
    public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
        return true;
    }

    @Override
    protected ItemStack getSilkTouchDrop(IBlockState state) {
        return super.getSilkTouchDrop(state);
    }

}
