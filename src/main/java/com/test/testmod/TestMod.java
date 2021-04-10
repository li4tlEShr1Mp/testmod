package com.test.testmod;

import com.test.testmod.proxy.CommonProxy;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = TestMod.MODID, name = TestMod.NAME, version = TestMod.VERSION)
public class TestMod {
    public static final String MODID = "testmod";
    public static final String NAME = "Test Mod";
    public static final String VERSION = "1.0";
    public static Logger logger;
    public static final String CLIENT_PROXY_CLASS="com.test.testmod.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS="com.test.testmod.proxy.ServerProxy";
    //@Mod.Instance
    //public static TestMod instance =new TestMod();
    @SidedProxy(clientSide = CLIENT_PROXY_CLASS,serverSide = SERVER_PROXY_CLASS)
    public static CommonProxy proxy;
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        logger=event.getModLog();
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent event){

    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){

    }
}
