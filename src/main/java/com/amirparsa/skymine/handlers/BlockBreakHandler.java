package com.amirparsa.skymine.handlers;

import com.amirparsa.skymine.PlayerManager;
import com.amirparsa.skymine.SkyMine;
import com.amirparsa.skymine.SkyMinePlayer;
import com.amirparsa.skymine.respawnblocks.BlockData;
import com.amirparsa.skymine.respawnblocks.BlockDataMap;
import com.amirparsa.skymine.respawnblocks.BrokenBlock;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDropItemEvent;

public class BlockBreakHandler implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBlockBreak(BlockBreakEvent event) {
        if(BlockDataMap.getMap().get(event.getBlock().getType()) == null) event.setCancelled(true);
        if(event.isCancelled()) return;

        Player player = event.getPlayer();
        SkyMinePlayer playerAccount = PlayerManager.getPlayer(player.getUniqueId());
        Block block = event.getBlock();

        playerAccount.setLastBlockBroken(block.getType());
        SkyMine.getPlugin().getBlockRespawner().getBlocks().add(new BrokenBlock(block.getLocation(), block.getType()));
    }

    @EventHandler(ignoreCancelled = true)
    public void onBlockDropItem(BlockDropItemEvent event) {
        event.setCancelled(true);

        Player player = event.getPlayer();
        SkyMinePlayer playerAccount = PlayerManager.getPlayer(player.getUniqueId());
        BlockData blockData = BlockDataMap.getMap().get(playerAccount.getLastBlockBroken());

        player.getInventory().addItem(blockData.drop);
    }
}
