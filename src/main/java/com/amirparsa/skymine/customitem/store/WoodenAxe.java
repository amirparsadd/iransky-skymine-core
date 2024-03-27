package com.amirparsa.skymine.customitem.store;

import com.amirparsa.skymine.customitem.CustomEnchantment;
import com.amirparsa.skymine.customitem.CustomItem;
import com.amirparsa.skymine.customitem.Rarity;
import com.amirparsa.skymine.customitem.Type;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

public class WoodenAxe extends CustomItem {
    public WoodenAxe(){
        super("WOOD_AXE", "Wood Axe", Rarity.COMMON, Type.AXE, new CustomEnchantment[]{new CustomEnchantment(Enchantment.DIG_SPEED, 1, 1, Rarity.COMMON)}, Material.WOODEN_AXE);
    }
}
