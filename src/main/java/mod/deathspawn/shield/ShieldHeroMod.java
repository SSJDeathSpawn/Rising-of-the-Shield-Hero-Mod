package mod.deathspawn.shield;

import mod.deathspawn.shield.lib.Reference;
import mod.deathspawn.shield.proxy.IProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MODID, name = Reference.MODNAME, version = Reference.MODVER)
public class ShieldHeroMod {

    public static Logger logger = LogManager.getFormatterLogger(Reference.MODID);

    public ShieldHeroMod() {
        logger.info("The Rising of the Shield Hero Mod is activated!");
    }

    @Mod.Instance
    public static ShieldHeroMod instance;

    @SidedProxy(clientSide = "mod.deathspawn.shield.proxy.ClientProxy", serverSide = "mod.deathspawn.shield.proxy.ServerProxy")
    public static IProxy proxy;


    @EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        proxy.preInit();

    }

    @EventHandler
    public static void init(FMLInitializationEvent event) {
        proxy.init();
    }

    @EventHandler
    public static void postInit(FMLPostInitializationEvent event) {
        proxy.postInit();
    }

}
