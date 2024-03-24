package com.amirparsa.skymine.handlers;

import com.amirparsa.skymine.SkyMine;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerConnectionHandler implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        SkyMine.getPlugin().getPlayerManager().addPlayer(event.getPlayer().getUniqueId());
        event.getPlayer().sendMessage(ChatColor.GREEN.toString() + "Welcome To IranSky SkyMine!");
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        SkyMine.getPlugin().getPlayerManager().getPlayer(event.getPlayer().getUniqueId()).save();
        SkyMine.getPlugin().getPlayerManager().removePlayer(event.getPlayer().getUniqueId());
    }
}
