package com.amirparsa.skymine;

import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

public class PlaceholderExpansion extends me.clip.placeholderapi.expansion.PlaceholderExpansion {

    private final SkyMine plugin;

    public PlaceholderExpansion(SkyMine plugin) {
        this.plugin = plugin;
    }

    @Override
    @NotNull
    public String getAuthor() {
        return String.join(", ", plugin.getDescription().getAuthors());
    }

    @Override
    @NotNull
    public String getIdentifier() {
        return "skymine";
    }

    @Override
    @NotNull
    public String getVersion() {
        return plugin.getDescription().getVersion();
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public String onRequest(OfflinePlayer player, @NotNull String params) {
        SkyMinePlayer playerAccount = plugin.getPlayerManager().getPlayer(player.getUniqueId());
        if(playerAccount == null) return null;
        switch (params){
            case "level": return playerAccount.getLevel() + "";
            case "xp": return playerAccount.getXp() + "";
            case "magicore": return playerAccount.getMagicOre() + "";
            case "blocks": return playerAccount.getBlocksBroken() + "";
            case "progress": return (playerAccount.getXp() * 100 / (playerAccount.getLevel() * 100)) + "";
        }
        return null;
    }
}