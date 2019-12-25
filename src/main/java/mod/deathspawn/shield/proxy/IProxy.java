package mod.deathspawn.shield.proxy;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public interface IProxy {

    void init();
    void preInit();
    void postInit();
    void registerItemRenderer(Item item, int meta, String variant, ResourceLocation name);

}
