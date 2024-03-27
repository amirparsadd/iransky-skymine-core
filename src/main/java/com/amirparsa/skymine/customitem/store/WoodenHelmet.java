package com.amirparsa.skymine.customitem.store;

import com.amirparsa.skymine.customitem.CustomEnchantment;
import com.amirparsa.skymine.customitem.CustomItem;
import com.amirparsa.skymine.customitem.Rarity;
import com.amirparsa.skymine.customitem.Type;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

public class WoodenHelmet extends CustomItem {
    public WoodenHelmet(){
        super("WOOD_HELMET", "Wood Helmet", Rarity.COMMON, Type.ARMOR, new CustomEnchantment[]{new CustomEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1, 1, Rarity.COMMON)}, Material.LEATHER_HELMET);
    }
}
