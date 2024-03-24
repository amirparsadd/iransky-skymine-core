package com.amirparsa.skymine.respawnblocks;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class BlockDataMap {
    private static final HashMap<Material, BlockData> map = new HashMap<>();

    static {
        map.put(Material.BIRCH_WOOD, new BlockData(0, new ItemStack(Material.BIRCH_WOOD), false, new Material[]{Material.AIR, Material.WOODEN_AXE, Material.STONE_AXE, Material.IRON_AXE, Material.GOLDEN_AXE, Material.DIAMOND_AXE, Material.NETHERITE_AXE}));
        map.put(Material.STRIPPED_BIRCH_WOOD, new BlockData(0, new ItemStack(Material.BIRCH_WOOD), false, new Material[]{Material.AIR, Material.WOODEN_AXE, Material.STONE_AXE, Material.IRON_AXE, Material.GOLDEN_AXE, Material.DIAMOND_AXE, Material.NETHERITE_AXE}));
        map.put(Material.BIRCH_PLANKS, new BlockData(0, new ItemStack(Material.BIRCH_WOOD), false, new Material[]{Material.AIR, Material.WOODEN_AXE, Material.STONE_AXE, Material.IRON_AXE, Material.GOLDEN_AXE, Material.DIAMOND_AXE, Material.NETHERITE_AXE}));

        map.put(Material.STONE, new BlockData(5, new ItemStack(Material.STONE), false, new Material[]{Material.WOODEN_PICKAXE, Material.STONE_PICKAXE, Material.IRON_PICKAXE, Material.GOLDEN_PICKAXE, Material.DIAMOND_PICKAXE, Material.NETHERITE_PICKAXE}));
        map.put(Material.COAL_ORE, new BlockData(10, new ItemStack(Material.COAL), false, new Material[]{Material.WOODEN_PICKAXE, Material.STONE_PICKAXE, Material.IRON_PICKAXE, Material.GOLDEN_PICKAXE, Material.DIAMOND_PICKAXE, Material.NETHERITE_PICKAXE}));
        map.put(Material.COAL_BLOCK, new BlockData(12, new ItemStack(Material.COAL, 9), false, new Material[]{Material.STONE_PICKAXE, Material.IRON_PICKAXE, Material.GOLDEN_PICKAXE, Material.DIAMOND_PICKAXE, Material.NETHERITE_PICKAXE}));

        map.put(Material.IRON_ORE, new BlockData(18, new ItemStack(Material.IRON_INGOT), false, new Material[]{Material.STONE_PICKAXE, Material.IRON_PICKAXE, Material.GOLDEN_PICKAXE, Material.DIAMOND_PICKAXE, Material.NETHERITE_PICKAXE}));
        map.put(Material.IRON_BLOCK, new BlockData(20, new ItemStack(Material.IRON_INGOT, 9), false, new Material[]{Material.IRON_PICKAXE, Material.GOLDEN_PICKAXE, Material.DIAMOND_PICKAXE, Material.NETHERITE_PICKAXE}));

        map.put(Material.GOLD_ORE, new BlockData(25, new ItemStack(Material.GOLD_INGOT), false, new Material[]{Material.IRON_PICKAXE, Material.GOLDEN_PICKAXE, Material.DIAMOND_PICKAXE, Material.NETHERITE_PICKAXE}));
        map.put(Material.GOLD_BLOCK, new BlockData(28, new ItemStack(Material.GOLD_INGOT, 9), false, new Material[]{Material.IRON_PICKAXE, Material.GOLDEN_PICKAXE, Material.DIAMOND_PICKAXE, Material.NETHERITE_PICKAXE}));

        map.put(Material.EMERALD_ORE, new BlockData(30, new ItemStack(Material.EMERALD), false, new Material[]{Material.GOLDEN_PICKAXE, Material.DIAMOND_PICKAXE, Material.NETHERITE_PICKAXE}));
        map.put(Material.EMERALD_BLOCK, new BlockData(32, new ItemStack(Material.EMERALD, 9), false, new Material[]{Material.GOLDEN_PICKAXE, Material.DIAMOND_PICKAXE, Material.NETHERITE_PICKAXE}));

        map.put(Material.DIAMOND_ORE, new BlockData(37, new ItemStack(Material.DIAMOND), false, new Material[]{Material.GOLDEN_PICKAXE, Material.DIAMOND_PICKAXE, Material.NETHERITE_PICKAXE}));
        map.put(Material.DIAMOND_BLOCK, new BlockData(40, new ItemStack(Material.DIAMOND, 9), false, new Material[]{Material.GOLDEN_PICKAXE, Material.DIAMOND_PICKAXE, Material.NETHERITE_PICKAXE}));

        map.put(Material.ANCIENT_DEBRIS, new BlockData(45, new ItemStack(Material.NETHERITE_INGOT), false, new Material[]{Material.DIAMOND_PICKAXE, Material.NETHERITE_PICKAXE}));
        map.put(Material.OBSIDIAN, new BlockData(50, new ItemStack(Material.OBSIDIAN), false, new Material[]{Material.NETHERITE_PICKAXE}));
        map.put(Material.CRYING_OBSIDIAN, new BlockData(50, new ItemStack(Material.CRYING_OBSIDIAN), false, new Material[]{Material.NETHERITE_PICKAXE}));

        map.put(Material.END_STONE, new BlockData(70, new ItemStack(Material.END_STONE), false, new Material[]{Material.NETHERITE_PICKAXE}));
        map.put(Material.ENDER_CHEST, new BlockData(70, new ItemStack(Material.ENDER_CHEST), true, new Material[]{Material.NETHERITE_PICKAXE}));
        map.put(Material.PURPLE_STAINED_GLASS, new BlockData(100, new ItemStack(Material.POTATO), true, new Material[]{Material.NETHERITE_PICKAXE}));
    }

    public static HashMap<Material, BlockData> getMap() {
        return map;
    }
}
