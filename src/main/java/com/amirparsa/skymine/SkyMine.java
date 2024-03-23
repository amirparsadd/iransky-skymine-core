package com.amirparsa.skymine;

import com.amirparsa.skymine.respawnblocks.BrokenBlock;
import com.amirparsa.skymine.respawnblocks.RespawnBlocksRunnable;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class SkyMine extends JavaPlugin {

    private static SkyMine plugin;
    RespawnBlocksRunnable blockRespawner;

    @Override
    public void onEnable() {
        //Setup External Plugin Instance
        plugin = this;

        // Register Placeholder Expansion
        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            new PlaceholderExpansion(this).register();
        }

        //Setup RespawnBlocksRunnable
        blockRespawner = new RespawnBlocksRunnable();
        blockRespawner.runTaskTimer(this, 1, 20 * 5);
    }

    @Override
    public void onDisable() {
        for(BrokenBlock block : blockRespawner.getBlocks()){
            block.getLocation().getBlock().setType(block.getType());
        }
    }

    public static SkyMine getPlugin() {
        return plugin;
    }
}
