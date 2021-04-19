package com.lobscraft.matrix_technology;

import com.lobscraft.matrix_technology.proxy.CommonProxy;
import com.lobscraft.matrix_technology.util.loaders.CreativeTabLoader;
import com.lobscraft.matrix_technology.util.loaders.SmeltingLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = MatrixTechnology.MODID, name = MatrixTechnology.NAME, version = MatrixTechnology.VERSION)
public class MatrixTechnology {
    public static final String MODID = "matrix_technology";
    public static final String NAME = "Matrix Technology";
    public static final String VERSION = "0.0.1";
    public static Logger logger;
    public static final String CLIENT_PROXY_CLASS = "com.lobscraft.matrix_technology.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "com.lobscraft.matrix_technology.proxy.ServerProxy";
    //@Mod.Instance
    //public static TestMod instance =new TestMod();
    @SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        CreativeTabLoader.load();
        logger = event.getModLog();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        SmeltingLoader.load();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
