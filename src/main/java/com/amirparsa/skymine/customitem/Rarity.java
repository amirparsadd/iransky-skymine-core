package com.amirparsa.skymine.customitem;

import org.bukkit.ChatColor;

public enum Rarity {
    COMMON     (ChatColor.WHITE),
    UNCOMMON   (ChatColor.GREEN),
    RARE       (ChatColor.BLUE),
    EPIC       (ChatColor.DARK_PURPLE),
    LEGENDARY  (ChatColor.GOLD),
    MYTHIC     (ChatColor.LIGHT_PURPLE),
    DIVINE     (ChatColor.AQUA),
    SPECIAL    (ChatColor.RED),
    ADMIN      (ChatColor.DARK_RED);


    final ChatColor color;

    Rarity(ChatColor color){
        this.color = color;
    }
}
