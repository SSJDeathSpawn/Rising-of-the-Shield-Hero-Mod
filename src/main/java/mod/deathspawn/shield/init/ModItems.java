package mod.deathspawn.shield.init;

import mod.deathspawn.shield.items.ItemBase;
import mod.deathspawn.shield.items.ItemShield;
import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static List<ItemBase> ITEMS = new ArrayList<ItemBase>();

    public static ItemShield shield = new ItemShield("shield_normal");
}
