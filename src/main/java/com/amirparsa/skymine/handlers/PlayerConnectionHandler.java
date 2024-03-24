package com.amirparsa.skymine.handlers;

import com.amirparsa.skymine.SkyMine;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerConnectionHandler implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        SkyMine.getPlugin().getPlayerManager().addPlayer(event.getPlayer().getUniqueId());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        SkyMine.getPlugin().getPlayerManager().removePlayer(event.getPlayer().getUniqueId());
    }
}
