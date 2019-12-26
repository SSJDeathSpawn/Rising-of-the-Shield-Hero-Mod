package mod.deathspawn.shield.items;


import mod.deathspawn.shield.ShieldHeroMod;
import mod.deathspawn.shield.init.ModItems;
import mod.deathspawn.shield.lib.IHasModel;
import mod.deathspawn.shield.lib.Reference;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ItemShield extends Item implements IHasModel {

    public ResourceLocation shield3d;

    public ItemShield(String unlocalizedName){
        this.setUnlocalizedName(unlocalizedName);
        this.setRegistryName(new ResourceLocation(Reference.MODID, unlocalizedName));
        shield3d = new ResourceLocation(unlocalizedName,"_3d");

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        ShieldHeroMod.proxy.registerItemRenderer(ModItems.shield, 0, "inventory", new ResourceLocation(Reference.MODID,"shield_normal"));
        ShieldHeroMod.proxy.registerItemRenderer(ModItems.shield, 0, "inventory", new ResourceLocation(Reference.MODID,"shield_normal_3d"));
    }
}
