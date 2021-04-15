package com.test.testmod.util.loaders;

import com.test.testmod.common.crativetab.CreativeTab_TestMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class TestModCreativeTab {

    public static CreativeTabs TESTMOD;
    public TestModCreativeTab(FMLPreInitializationEvent event) {
        TESTMOD = new CreativeTab_TestMod();
    }
}
