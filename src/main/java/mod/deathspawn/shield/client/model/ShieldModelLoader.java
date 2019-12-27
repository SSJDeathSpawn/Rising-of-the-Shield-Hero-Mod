package mod.deathspawn.shield.client.model;

import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;

public class ShieldModelLoader implements ICustomModelLoader {
    @Override
    public void onResourceManagerReload(IResourceManager resourceManager) { }

    @Override
    public boolean accepts(ResourceLocation modelLocation) {
        return modelLocation.getResourceDomain().equals("shield") && modelLocation.getResourcePath().startsWith("models/item/shield_P");
    }

    @Override
    public IModel loadModel(ResourceLocation modelLocation) throws Exception {
        ModelShield modelShield = new ModelShield(modelLocation.getResourcePath().substring("models/item/shield_P".length()));
        return (IModel)modelShield;
    }
}
