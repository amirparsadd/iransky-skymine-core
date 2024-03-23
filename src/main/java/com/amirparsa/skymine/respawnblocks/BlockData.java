package com.amirparsa.skymine.respawnblocks;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class BlockData {
    public int level;
    public ItemStack drop;
    public boolean magical;
    public Material[] mineable;

    public BlockData(int level, ItemStack drop, boolean magical, Material[] minable) {
        this.level = level;
        this.drop = drop;
        this.magical = magical;
        this.mineable = minable;
    }
}
