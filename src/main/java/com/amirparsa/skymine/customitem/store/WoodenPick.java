package com.amirparsa.skymine.customitem.store;

import com.amirparsa.skymine.customitem.CustomEnchantment;
import com.amirparsa.skymine.customitem.CustomItem;
import com.amirparsa.skymine.customitem.Rarity;
import com.amirparsa.skymine.customitem.Type;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

public class WoodenPick extends CustomItem {
    public WoodenPick(){
        super("WOOD_PICK", "Wood Pick", Rarity.COMMON, Type.PICK, new CustomEnchantment[]{new CustomEnchantment(Enchantment.DIG_SPEED, 1, 1, Rarity.COMMON)}, Material.WOODEN_PICKAXE);
    }
}
