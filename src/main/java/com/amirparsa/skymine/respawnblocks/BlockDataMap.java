package com.amirparsa.skymine.respawnblocks;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class BlockDataMap {
    private static final HashMap<Material, BlockData> map = new HashMap<>();

    static {
        map.put(Material.BIRCH_WOOD, new BlockData(0, new ItemStack(Material.BIRCH_WOOD), false, new Material[]{null, Material.WOODEN_AXE, Material.STONE_AXE, Material.IRON_AXE, Material.GOLDEN_AXE, Material.DIAMOND_AXE, Material.NETHERITE_AXE}));
        map.put(Material.STRIPPED_BIRCH_WOOD, new BlockData(0, new ItemStack(Material.BIRCH_WOOD), false, new Material[]{null, Material.WOODEN_AXE, Material.STONE_AXE, Material.IRON_AXE, Material.GOLDEN_AXE, Material.DIAMOND_AXE, Material.NETHERITE_AXE}));
        map.put(Material.BIRCH_PLANKS, new BlockData(0, new ItemStack(Material.BIRCH_WOOD), false, new Material[]{null, Material.WOODEN_AXE, Material.STONE_AXE, Material.IRON_AXE, Material.GOLDEN_AXE, Material.DIAMOND_AXE, Material.NETHERITE_AXE}));

        map.put(Material.STONE, new BlockData(5, new ItemStack(Material.STONE), false, new Material[]{Material.WOODEN_PICKAXE, Material.STONE_PICKAXE, Material.IRON_PICKAXE, Material.GOLDEN_PICKAXE, Material.DIAMOND_PICKAXE, Material.NETHERITE_PICKAXE}));
        map.put(Material.COAL_ORE, new BlockData(10, new ItemStack(Material.COAL), false, new Material[]{Material.WOODEN_PICKAXE, Material.STONE_PICKAXE, Material.IRON_PICKAXE, Material.GOLDEN_PICKAXE, Material.DIAMOND_PICKAXE, Material.NETHERITE_PICKAXE}));
        map.put(Material.COAL_BLOCK, new BlockData(12, new ItemStack(Material.COAL, 9), false, new Material[]{Material.STONE_PICKAXE, Material.IRON_PICKAXE, Material.GOLDEN_PICKAXE, Material.DIAMOND_PICKAXE, Material.NETHERITE_PICKAXE}));

        map.put(Material.IRON_ORE, new BlockData(18, new ItemStack(Material.IRON_INGOT), false, new Material[]{Material.STONE_PICKAXE, Material.IRON_PICKAXE, Material.GOLDEN_PICKAXE, Material.DIAMOND_PICKAXE, Material.NETHERITE_PICKAXE}));
        map.put(Material.IRON_BLOCK, new BlockData(20, new ItemStack(Material.IRON_INGOT, 9), false, new Material[]{Material.IRON_PICKAXE, Material.GOLDEN_PICKAXE, Material.DIAMOND_PICKAXE, Material.NETHERITE_PICKAXE}));

    }

    public static HashMap<Material, BlockData> getMap() {
        return map;
    }
}
