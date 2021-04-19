package com.lobscraft.matrix_technology.util.loaders;

import com.lobscraft.matrix_technology.common.crativetab.CreativeTab_TestMod;
import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabLoader {

    public static CreativeTabs Matrix_Technology;

    public static void load() {
        Matrix_Technology = new CreativeTab_TestMod();
    }
}