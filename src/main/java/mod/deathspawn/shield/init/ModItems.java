package mod.deathspawn.shield.init;

import mod.deathspawn.shield.items.ItemBase;
import mod.deathspawn.shield.items.ItemShield;
import mod.deathspawn.shield.lib.Reference;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static List<ItemBase> ITEMS = new ArrayList<ItemBase>();

    public static ItemShield shield = new ItemShield(Reference.ModdedItems.SHIELD.toString());
}
