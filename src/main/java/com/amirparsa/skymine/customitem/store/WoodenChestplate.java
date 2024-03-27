package com.amirparsa.skymine.customitem.store;

import com.amirparsa.skymine.customitem.CustomEnchantment;
import com.amirparsa.skymine.customitem.CustomItem;
import com.amirparsa.skymine.customitem.Rarity;
import com.amirparsa.skymine.customitem.Type;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

public class WoodenChestplate extends CustomItem {
    public WoodenChestplate(){
        super("WOOD_CHESTPLATE", "Wood Chestplate", Rarity.COMMON, Type.ARMOR, new CustomEnchantment[]{new CustomEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1, 1, Rarity.COMMON)}, Material.LEATHER_CHESTPLATE);
    }
}
