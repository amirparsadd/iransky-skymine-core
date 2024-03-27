package com.amirparsa.skymine.customitem.store;

import com.amirparsa.skymine.customitem.CustomEnchantment;
import com.amirparsa.skymine.customitem.CustomItem;
import com.amirparsa.skymine.customitem.Rarity;
import com.amirparsa.skymine.customitem.Type;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

public class WoodenSword extends CustomItem {
    public WoodenSword(){
        super("WOOD_SWORD", "Wood Sword", Rarity.COMMON, Type.SWORD, new CustomEnchantment[]{new CustomEnchantment(Enchantment.DAMAGE_ALL, 1, 1, Rarity.COMMON)}, Material.WOODEN_SWORD);
    }
}
