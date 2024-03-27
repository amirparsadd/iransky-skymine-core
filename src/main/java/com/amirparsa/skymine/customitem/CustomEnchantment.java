package com.amirparsa.skymine.customitem;

import org.bukkit.enchantments.Enchantment;

public class CustomEnchantment {
    private Enchantment enchantment;
    private int level;
    private int levelMultiplier;
    private Rarity rarity;

    public CustomEnchantment(Enchantment enchantment, int level, int levelMultiplier, Rarity rarity) {
        this.enchantment = enchantment;
        this.level = level;
        this.rarity = rarity;
        this.levelMultiplier = levelMultiplier;
    }

    public Enchantment getEnchantment() {
        return enchantment;
    }

    public void setEnchantment(Enchantment enchantment) {
        this.enchantment = enchantment;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public int getLevelMultiplier() {
        return levelMultiplier;
    }

    public void setLevelMultiplier(int levelMultiplier) {
        this.levelMultiplier = levelMultiplier;
    }
}
