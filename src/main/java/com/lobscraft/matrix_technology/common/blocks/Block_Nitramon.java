package com.lobscraft.matrix_technology.common.blocks;

import com.lobscraft.matrix_technology.MatrixTechnology;
import com.lobscraft.matrix_technology.util.IModelExisted;
import com.lobscraft.matrix_technology.util.handlers.BlockHandler;
import com.lobscraft.matrix_technology.util.handlers.ItemHandler;
import com.lobscraft.matrix_technology.util.loaders.CreativeTabLoader;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class Block_Nitramon extends BlockDirectional implements IModelExisted {
    private static final String name = "nitramon";
    private static final AxisAlignedBB NITRAMON_AABB_NS = new AxisAlignedBB(0.1875D, 0.1875D, 0.0D, 0.8125D, 0.8125D, 1.0D);
    private static final AxisAlignedBB NITRAMON_AABB_WE = new AxisAlignedBB(0.0D, 0.1875D, 0.1875D, 1.0D, 0.8125D, 0.8125D);
    private static final AxisAlignedBB NITRAMON_AABB_UD = new AxisAlignedBB(0.1875D, 0.0D, 0.1875D, 0.8125D, 1.0D, 0.8125D);

    public Block_Nitramon() {
        super(Material.TNT);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabLoader.Matrix_Technology);
        BlockHandler.blocks.add(this);
        ItemHandler.items.add(new ItemBlock(this).setRegistryName(name));
    }

    //region [BlockState]
    protected @NotNull BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
    }

    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getDirectionFromEntityLiving(pos, placer).getOpposite());
    }

    public int getMetaFromState(IBlockState state) {
        int i = 0;
        i = i | state.getValue(FACING).getIndex();
        return i;
    }

    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getFront(meta & 7));
    }

    /*public EnumPushReaction getMobilityFlag(IBlockState state) {
        return EnumPushReaction.DESTROY;
    }*/

    //endregion
    //region [Model]
    @Override
    public void registerModel() {
        MatrixTechnology.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        switch (state.getValue(FACING)) {
            case NORTH:
            case SOUTH:
                return NITRAMON_AABB_NS;
            case WEST:
            case EAST:
                return NITRAMON_AABB_WE;
            case UP:
            case DOWN:
                return NITRAMON_AABB_UD;
        }
        return NITRAMON_AABB_UD;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    //endregion
    //region [Explosion]
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!playerIn.getHeldItemMainhand().isEmpty() && playerIn.getHeldItemMainhand().getItem() == ItemHandler.MATRIX_CRYSTAL) {
            this.explode(worldIn, pos, state.getValue(FACING), 60, 10);
            return true;
        } else {
            return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
        }
    }

    private void explode(World worldIn, BlockPos pos, EnumFacing facing, int angle, int distance) {
        if (angle < 0 || angle > 90) angle = 90;
        int x = facing.getDirectionVec().getX();
        int y = facing.getDirectionVec().getY();
        int z = facing.getDirectionVec().getZ();
        double angleD = Math.tan(Math.PI / 180.0d * angle / 2);
        for (float currentDistance = 0; currentDistance < distance; currentDistance += 2.0f) {
            for (int rotation = 0; rotation < 360; rotation += 30) {
                if (x != 0) {
                    worldIn.createExplosion(null,
                            pos.getX() + x * (currentDistance - 3f * x),
                            pos.getY() + Math.cos(Math.PI / 180.0f * rotation) * angleD * (currentDistance - 3f * y),
                            pos.getZ() + Math.sin(Math.PI / 180.0f * rotation) * angleD * (currentDistance - 3f * z),
                            3.0f, true);
                } else if (y != 0) {
                    worldIn.createExplosion(null,
                            pos.getX() + Math.cos(Math.PI / 180.0f * rotation) * angleD * (currentDistance - 3f * x),
                            pos.getY() + y * (currentDistance - 3f * y),
                            pos.getZ() + Math.sin(Math.PI / 180.0f * rotation) * angleD * (currentDistance - 3f * z),
                            3.0f, true);
                } else if (z != 0) {
                    worldIn.createExplosion(null,
                            pos.getX() + Math.sin(Math.PI / 180.0f * rotation) * angleD * (currentDistance - 3f * x),
                            pos.getY() + Math.cos(Math.PI / 180.0f * rotation) * angleD * (currentDistance - 3f * y),
                            pos.getZ() + z * (currentDistance - 3f * z),
                            3.0f, true);
                }
            }
        }
    }
    //endregion
}
