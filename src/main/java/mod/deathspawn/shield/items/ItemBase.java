package mod.deathspawn.shield.items;

import mod.deathspawn.shield.ShieldHeroMod;
import mod.deathspawn.shield.init.ModItems;
import mod.deathspawn.shield.lib.Reference;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public abstract class ItemBase extends Item{

    public ItemBase(String unlocalizedName){
        this.setUnlocalizedName(unlocalizedName);
        this.setRegistryName(new ResourceLocation(Reference.MODID, unlocalizedName));

        ModItems.ITEMS.add(this);
    }

    public abstract void registerModels();
}
