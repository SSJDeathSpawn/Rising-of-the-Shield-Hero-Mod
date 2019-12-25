package mod.deathspawn.shield;

import mod.deathspawn.shield.client.model.ShieldModelLoader;
import mod.deathspawn.shield.init.ModItems;
import mod.deathspawn.shield.lib.Reference;
import mod.deathspawn.shield.proxy.IProxy;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import scala.tools.nsc.backend.icode.TypeKinds;

@Mod(modid = Reference.MODID, name = Reference.MODNAME, version = Reference.MODVER)
public class ShieldHeroMod {

    @Mod.Instance
    public static ShieldHeroMod instance;

    @SidedProxy(clientSide = "mod.deathspawn.shield.proxy.ClientProxy")
    public static IProxy proxy;


    @EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        //ModelBakery.registerItemVariants(ModItems.shield, new ModelResourceLocation(new ResourceLocation(Reference.MODID, "shield_normal"), "inventory"), new ModelResourceLocation(new ResourceLocation(Reference.MODID, "shield_normal_3d"), "inventory"));
        ModelLoaderRegistry.registerLoader(new ShieldModelLoader());

    }

    @EventHandler
    public static void init(FMLInitializationEvent event) {

    }

    @EventHandler
    public static void postInit(FMLPostInitializationEvent event) {

    }

}
