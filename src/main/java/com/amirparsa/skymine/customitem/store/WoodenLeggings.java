package com.amirparsa.skymine.customitem.store;

import com.amirparsa.skymine.customitem.CustomEnchantment;
import com.amirparsa.skymine.customitem.CustomItem;
import com.amirparsa.skymine.customitem.Rarity;
import com.amirparsa.skymine.customitem.Type;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

public class WoodenLeggings extends CustomItem {
    public WoodenLeggings(){
        super("WOOD_LEGGINGS", "Wood Leggings", Rarity.COMMON, Type.ARMOR, new CustomEnchantment[]{new CustomEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1, 1, Rarity.COMMON)}, Material.LEATHER_LEGGINGS);
    }
}
