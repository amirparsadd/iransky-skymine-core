package com.amirparsa.skymine;

import com.amirparsa.skymine.handlers.BlockBreakHandler;
import com.amirparsa.skymine.handlers.PlayerConnectionHandler;
import com.amirparsa.skymine.respawnblocks.BrokenBlock;
import com.amirparsa.skymine.respawnblocks.RespawnBlocksRunnable;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class SkyMine extends JavaPlugin {

    private static SkyMine plugin;
    private RespawnBlocksRunnable blockRespawner;
    private PlayerManager playerManager = new PlayerManager();

    @Override
    public void onEnable() {
        //Setup External Plugin Instance
        plugin = this;

        // Register Placeholder Expansion
        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            new PlaceholderExpansion(this).register();
        }

        //Register Stuff
        registerHandlers();

        //Setup RespawnBlocksRunnable
        blockRespawner = new RespawnBlocksRunnable();
        blockRespawner.runTaskTimer(this, 1, 20 * 5);
    }

    @Override
    public void onDisable() {
        for(BrokenBlock block : blockRespawner.getBlocks()){
            block.getLocation().getBlock().setType(block.getType());
        }

        for(SkyMinePlayer player : playerManager.getPlayers().values()){
            player.save();
        }
    }

    public void registerHandlers() {
        getServer().getPluginManager().registerEvents(new BlockBreakHandler(), this);
        getServer().getPluginManager().registerEvents(new PlayerConnectionHandler(), this);
    }

    public static SkyMine getPlugin() {
        return plugin;
    }

    public RespawnBlocksRunnable getBlockRespawner() {
        return blockRespawner;
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }
}
