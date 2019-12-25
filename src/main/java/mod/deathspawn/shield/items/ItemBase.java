package mod.deathspawn.shield.items;

import mod.deathspawn.shield.ShieldHeroMod;
import mod.deathspawn.shield.init.ModItems;
import mod.deathspawn.shield.lib.IHasModel;
import mod.deathspawn.shield.lib.Reference;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ItemBase extends Item implements IHasModel {

    public ItemBase(String unlocalizedName){
        this.setUnlocalizedName(unlocalizedName);
        this.setRegistryName(new ResourceLocation(Reference.MODID, unlocalizedName));

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        ShieldHeroMod.proxy.registerItemRenderer(this, 0, "inventory", this.getRegistryName());
    }
}
