package com.amirparsa.skymine.customitem;

import com.amirparsa.skymine.KeyStore;
import com.amirparsa.skymine.utils.RomanNumber;
import com.amirparsa.skymine.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public abstract class CustomItem {
    private String id;
    private String name;
    private Rarity rarity;
    private Type type;
    private CustomEnchantment[] enchantments;
    private Material material;

    public CustomItem(String id, String name, Rarity rarity, Type type, CustomEnchantment[] enchantments, Material material) {
        this.id = id;
        this.name = name;
        this.rarity = rarity;
        this.type = type;
        this.enchantments = enchantments;
        this.material = material;
    }

    public ItemStack build(boolean magical, int level){
        ItemStack itemStack = new ItemStack(material);
        ItemMeta meta = itemStack.getItemMeta();

        meta.setDisplayName(ChatColor.AQUA + name + " " + ChatColor.LIGHT_PURPLE.toString() + ChatColor.BOLD + RomanNumber.toRoman(level));
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_DYE, ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_POTION_EFFECTS);
        meta.getPersistentDataContainer().set(KeyStore.ITEM_KEY.key, PersistentDataType.STRING, id);
        meta.setUnbreakable(!magical);
        if(magical) meta.getPersistentDataContainer().set(KeyStore.MAGICAL_ATTR.key, PersistentDataType.INTEGER, 1);

        for(CustomEnchantment enchantment : enchantments){
            meta.addEnchant(enchantment.getEnchantment(), enchantment.getLevel() + (enchantment.getLevelMultiplier() * (level-1)), true);
        }

        meta.setLore(buildLore(magical, level));

        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public List<String> buildLore(boolean magical, int level){
        ArrayList<String> lore = new ArrayList<>();

        lore.add(ChatColor.DARK_GRAY + " ");
        
        if(enchantments.length != 0){
            lore.add(ChatColor.LIGHT_PURPLE + "Enchantments");
            for(CustomEnchantment enchantment : enchantments){
                lore.add(ChatColor.AQUA + "|- " + enchantment.getRarity().color + Utils.getFriendlyText(enchantment.getEnchantment().getKey().getKey()) + " " + RomanNumber.toRoman(enchantment.getLevel() + (enchantment.getLevelMultiplier() * (level-1))));
            }
            lore.add(ChatColor.DARK_GRAY + " ");
        }

        if(magical) lore.add(ChatColor.GRAY + "This Item Is Magical!");
        lore.add(rarity.color + ChatColor.BOLD.toString() + rarity.name() + " " + type.name());

        return lore;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public CustomEnchantment[] getEnchantments() {
        return enchantments;
    }

    public void setEnchantments(CustomEnchantment[] enchantments) {
        this.enchantments = enchantments;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
