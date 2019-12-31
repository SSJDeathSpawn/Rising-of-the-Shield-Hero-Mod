package mod.deathspawn.shield.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public abstract class ItemMetadataBase extends ItemBase {

    public  ItemMetadataBase(String unlocalizedName) {
        super(unlocalizedName);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
    }

    @Override
    public abstract void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items);

    @Override
    public abstract String getUnlocalizedName(ItemStack stack);
}
