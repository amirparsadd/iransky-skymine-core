package com.amirparsa.skymine;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class BlockData {
    public int level;
    public ItemStack drop;
    public boolean magical;
    public Material[] minable;

    public BlockData(int level, ItemStack drop, boolean magical, Material[] minable) {
        this.level = level;
        this.drop = drop;
        this.magical = magical;
        this.minable = minable;
    }
}
