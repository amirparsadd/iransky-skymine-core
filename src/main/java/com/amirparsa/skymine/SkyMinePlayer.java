package com.amirparsa.skymine;

import com.amirparsa.skymine.utils.PDCHelper;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;

import java.util.UUID;

public class SkyMinePlayer {
    private UUID uuid;

    private Material lastBlockBroken;
    private int blocksBroken = 0;

    private int level = 1;
    private int xp = 0;
    private int magicOre = 0;

    private SkyMinePlayer(){}

    public SkyMinePlayer(UUID uuid){
        this.uuid = uuid;
        if(PDCHelper.getBool(Bukkit.getPlayer(this.uuid).getPersistentDataContainer(), KeyStore.PLAYED_BEFORE.key)){
            load();
        }else{
            save();
            PDCHelper.setBool(Bukkit.getPlayer(this.uuid).getPersistentDataContainer(), KeyStore.PLAYED_BEFORE.key, true);
        }
    }

    public void load(){
        level = PDCHelper.getInteger(Bukkit.getPlayer(this.uuid).getPersistentDataContainer(), KeyStore.LEVEL.key);
        xp = PDCHelper.getInteger(Bukkit.getPlayer(this.uuid).getPersistentDataContainer(), KeyStore.XP.key);
        blocksBroken = PDCHelper.getInteger(Bukkit.getPlayer(this.uuid).getPersistentDataContainer(), KeyStore.BLOCKS_BROKEN.key);
        magicOre = PDCHelper.getInteger(Bukkit.getPlayer(this.uuid).getPersistentDataContainer(), KeyStore.MAGIC_ORE.key);
    }

    public void save(){
        PDCHelper.setInteger(Bukkit.getPlayer(this.uuid).getPersistentDataContainer(), KeyStore.LEVEL.key, level);
        PDCHelper.setInteger(Bukkit.getPlayer(this.uuid).getPersistentDataContainer(), KeyStore.XP.key, xp);
        PDCHelper.setInteger(Bukkit.getPlayer(this.uuid).getPersistentDataContainer(), KeyStore.BLOCKS_BROKEN.key, blocksBroken);
        PDCHelper.setInteger(Bukkit.getPlayer(this.uuid).getPersistentDataContainer(), KeyStore.MAGIC_ORE.key, magicOre);
    }

    public UUID getUuid() {
        return uuid;
    }

    public void increaseXP(int amount){
        xp += amount;

        TextComponent textComponent = new TextComponent();
        textComponent.setColor(net.md_5.bungee.api.ChatColor.DARK_AQUA);
        textComponent.setBold(true);
        textComponent.setText("+" + amount + " ("+ xp + "/" + (level * 100) + ")");
        Bukkit.getPlayer(uuid).spigot().sendMessage(ChatMessageType.ACTION_BAR, textComponent);

        if(xp > level * 100){
            xp -= level * 100;
            level++;
            Bukkit.getPlayer(uuid).sendTitle(
                    ChatColor.AQUA.toString() + ChatColor.BOLD + "LEVEL UP!",
                    ChatColor.DARK_AQUA.toString() + (level-1) + " ➡ " + level,
                    4, 35, 7);
            Bukkit.getPlayer(uuid).playSound(Bukkit.getPlayer(uuid).getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100, 1);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "crates give " + Bukkit.getPlayer(uuid).getName() + " Mining");
        }
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Material getLastBlockBroken() {
        return lastBlockBroken;
    }

    public void setLastBlockBroken(Material lastBlockBroken) {
        this.lastBlockBroken = lastBlockBroken;
    }

    public int getBlocksBroken() {
        return blocksBroken;
    }

    public void setBlocksBroken(int blocksBroken) {
        this.blocksBroken = blocksBroken;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getMagicOre() {
        return magicOre;
    }

    public void setMagicOre(int magicOre) {
        this.magicOre = magicOre;
    }
}
