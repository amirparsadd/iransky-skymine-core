package com.amirparsa.skymine.handlers;

import com.amirparsa.skymine.PlayerManager;
import com.amirparsa.skymine.SkyMine;
import com.amirparsa.skymine.SkyMinePlayer;
import com.amirparsa.skymine.respawnblocks.BlockData;
import com.amirparsa.skymine.respawnblocks.BlockDataMap;
import com.amirparsa.skymine.respawnblocks.BrokenBlock;
import com.amirparsa.skymine.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDropItemEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlockBreakHandler implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBlockBreak(BlockBreakEvent event) {
        if(event.getPlayer().getGameMode() == GameMode.CREATIVE) return;
        if(BlockDataMap.getMap().get(event.getBlock().getType()) == null) event.setCancelled(true);
        if(event.isCancelled()) return;

        Player player = event.getPlayer();
        SkyMinePlayer playerAccount = SkyMine.getPlugin().getPlayerManager().getPlayer(player.getUniqueId());
        Block block = event.getBlock();
        BlockData blockData = BlockDataMap.getMap().get(block.getType());

        if(!Arrays.asList(blockData.mineable).contains(player.getInventory().getItemInMainHand().getType())){
            event.setCancelled(true);
            player.sendMessage(ChatColor.RED + "You Atleast Need A " + Utils.getFriendlyText(blockData.mineable[0] == Material.AIR ? "FIST" : blockData.mineable[0].name()) + " To Break This!");
            return;
        }

        playerAccount.setLastBlockBroken(block.getType());
        playerAccount.setBlocksBroken(playerAccount.getBlocksBroken() + 1);
        SkyMine.getPlugin().getBlockRespawner().getBlocks().add(new BrokenBlock(block.getLocation(), block.getType()));
    }

    @EventHandler(ignoreCancelled = true)
    public void onBlockDropItem(BlockDropItemEvent event) {
        event.setCancelled(true);

        Player player = event.getPlayer();
        SkyMinePlayer playerAccount = SkyMine.getPlugin().getPlayerManager().getPlayer(player.getUniqueId());
        BlockData blockData = BlockDataMap.getMap().get(playerAccount.getLastBlockBroken());

        player.getInventory().addItem(blockData.drop);
    }
}
