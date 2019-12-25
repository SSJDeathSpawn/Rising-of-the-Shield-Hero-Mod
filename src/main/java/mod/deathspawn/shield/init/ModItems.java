package mod.deathspawn.shield.init;

import mod.deathspawn.shield.items.ItemBase;
import mod.deathspawn.shield.items.ItemShield;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static List<Item> ITEMS = new ArrayList<Item>();

    public static ItemShield shield = new ItemShield("shield_normal");
}
