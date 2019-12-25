package mod.deathspawn.shield.proxy;

import mod.deathspawn.shield.lib.Reference;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.PerspectiveMapWrapper;

public class ClientProxy implements IProxy{

    @Override
    public void init() { }

    @Override
    public void preInit() { }

    @Override
    public void postInit() { }

    @Override
    public void registerItemRenderer(Item item, int meta, String variant, ResourceLocation name) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(name,variant));
    }
}
