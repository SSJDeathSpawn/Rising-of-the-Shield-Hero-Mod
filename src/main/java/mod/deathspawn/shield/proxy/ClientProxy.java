package mod.deathspawn.shield.proxy;

import mod.deathspawn.shield.ShieldHeroMod;
import mod.deathspawn.shield.client.model.ShieldModelLoader;
import mod.deathspawn.shield.init.ModItems;
import mod.deathspawn.shield.lib.Reference;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;

public class ClientProxy implements IProxy{

    @Override
    public void init() { }

    @Override
    public void preInit() {
        ModelLoaderRegistry.registerLoader(new ShieldModelLoader());
        ShieldHeroMod.logger.info("Registering Items");
        this.registerItemRenderer(ModItems.shield, 0, "inventory", new ResourceLocation(Reference.MODID,"shield_normal"));
        this.registerItemRenderer(ModItems.shield, 0, "inventory", new ResourceLocation(Reference.MODID,"shield_normal_3d"));
        ModelBakery.registerItemVariants(ModItems.shield, new ModelResourceLocation("shield:shield_normal", "inventory"), new ModelResourceLocation("shield:shield_normal_3d", "inventory"));
    }

    @Override
    public void postInit() { }

    @Override
    public void registerItemRenderer(Item item, int meta, String variant, ResourceLocation name) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(name, variant));
    }
}
