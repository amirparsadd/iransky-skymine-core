package com.amirparsa.skymine.customitem.store;

import com.amirparsa.skymine.customitem.CustomEnchantment;
import com.amirparsa.skymine.customitem.CustomItem;
import com.amirparsa.skymine.customitem.Rarity;
import com.amirparsa.skymine.customitem.Type;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

public class StoneAxe extends CustomItem {
    public StoneAxe(){
        super("ROCK_AXE", "Rock Axe", Rarity.COMMON, Type.AXE, new CustomEnchantment[]{new CustomEnchantment(Enchantment.DIG_SPEED, 1, 1, Rarity.COMMON)}, Material.STONE_AXE);
    }
}
