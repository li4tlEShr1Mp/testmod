package com.lobscraft.matrix_technology.util.handlers;

import com.lobscraft.matrix_technology.common.blocks.Block_Air_Crystal;
import com.lobscraft.matrix_technology.common.blocks.Block_Inner_Meteorite;
import com.lobscraft.matrix_technology.common.blocks.Block_Iron_Meteorite;
import com.lobscraft.matrix_technology.common.blocks.Block_Matrix_Crystal_Meteorite;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class BlockHandler {
    public static final List<Block> blocks = new ArrayList<>();
    public static final Block INNER_METEORITE = new Block_Inner_Meteorite();
    public static final Block IRON_METEORITE = new Block_Iron_Meteorite();
    public static final Block MATRIX_CRYSTAL_METEORITE = new Block_Matrix_Crystal_Meteorite();
    public static final Block AIR_CRYSTAL = new Block_Air_Crystal();

}
