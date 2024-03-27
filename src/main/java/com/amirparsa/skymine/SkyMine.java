package com.amirparsa.skymine;

import com.amirparsa.skymine.commands.AddMagicOreCommand;
import com.amirparsa.skymine.commands.CustomItemCommand;
import com.amirparsa.skymine.customitem.ItemManager;
import com.amirparsa.skymine.customitem.store.*;
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
    private ItemManager itemManager = new ItemManager();

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
        registerCommands();
        registerItems();

        //Setup RespawnBlocksRunnable
        blockRespawner = new RespawnBlocksRunnable();
        blockRespawner.runTaskTimer(this, 1, 20);
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

    public void registerCommands(){
        getCommand("addmagicore").setExecutor(new AddMagicOreCommand());
        getCommand("customitem").setExecutor(new CustomItemCommand());
    }

    public void registerItems(){
        itemManager.register(new TestShovel());
        itemManager.register(new WoodenPick());
        itemManager.register(new WoodenHelmet());
        itemManager.register(new WoodenBoots());
        itemManager.register(new WoodenLeggings());
        itemManager.register(new WoodenChestplate());
        itemManager.register(new WoodenAxe());
        itemManager.register(new WoodenSword());
        itemManager.register(new StoneAxe());
        itemManager.register(new StoneSword());
        itemManager.register(new StonePick());
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

    public ItemManager getItemManager() {
        return itemManager;
    }
}
