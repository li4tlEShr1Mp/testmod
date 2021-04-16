package com.test.testmod.util.handlers;

import com.test.testmod.common.blocks.Block_Air_Crystal;
import com.test.testmod.common.blocks.Block_Iron_Meteorite;
import com.test.testmod.common.blocks.Block_MatrixCrystal_Meteorite;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class BlockHandler {
    public static final List<Block> blocks=new ArrayList<>();
    public static final Block IRON_METEORITE=new Block_Iron_Meteorite();
    public static final Block MATRIX_CRYSTAL_METEORITE=new Block_MatrixCrystal_Meteorite();
    public static final Block AIR_CRYSTAL=new Block_Air_Crystal();

}
