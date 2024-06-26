package com.amirparsa.skymine.handlers;

import com.amirparsa.skymine.KeyStore;
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
import org.bukkit.persistence.PersistentDataType;

import java.util.Arrays;
import java.util.Random;


public class BlockBreakHandler implements Listener {

    private static final Random random = new Random();

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBlockBreak(BlockBreakEvent event) {
        if(event.getPlayer().getGameMode() == GameMode.CREATIVE) return;
        if(BlockDataMap.getMap().get(event.getBlock().getType()) == null) event.setCancelled(true);
        if(event.isCancelled()) return;

        Player player = event.getPlayer();
        SkyMinePlayer playerAccount = SkyMine.getPlugin().getPlayerManager().getPlayer(player.getUniqueId());
        Block block = event.getBlock();
        BlockData blockData = BlockDataMap.getMap().get(block.getType());

        if(playerAccount.getLevel() < blockData.level-1){
            player.sendMessage(ChatColor.RED + "You Need To Be Level " + blockData.level + " To Break This!");
            event.setCancelled(true);
            return;
        }

        if(!Arrays.asList(blockData.mineable).contains(player.getInventory().getItemInMainHand().getType())){
            event.setCancelled(true);
            player.sendMessage(ChatColor.RED + "You Atleast Need A " + Utils.getFriendlyText(blockData.mineable[0] == Material.AIR ? "FIST" : blockData.mineable[0].name()) + " To Break This!");
            return;
        }

        if (blockData.magical && !player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().has(KeyStore.MAGICAL_ATTR.key, PersistentDataType.INTEGER)){
            player.sendMessage(ChatColor.RED + "This Block IS Magical! You Need A Magical Tool To Break It.");
            event.setCancelled(true);
            return;
        }

        playerAccount.setLastBlockBroken(block.getType());
        playerAccount.setBlocksBroken(playerAccount.getBlocksBroken() + 1);

        int totalXP = 1;
        if(player.hasPermission("iransky.skyking")) totalXP++;
        if(player.hasPermission("iransky.skywarrior")) totalXP++;
        if(player.hasPermission("iransky.skygod")) totalXP++;
        if(player.hasPermission("iransky.iransky")) totalXP++;
        playerAccount.increaseXP(totalXP);

        SkyMine.getPlugin().getBlockRespawner().getBlocks().add(new BrokenBlock(block.getLocation(), block.getType()));
    }

    @EventHandler
    public void onBlockDropItem(BlockDropItemEvent event) {
        event.setCancelled(true);

        Player player = event.getPlayer();
        if(player.getGameMode().equals(GameMode.CREATIVE)) return;

        SkyMinePlayer playerAccount = SkyMine.getPlugin().getPlayerManager().getPlayer(player.getUniqueId());
        BlockData blockData = BlockDataMap.getMap().get(playerAccount.getLastBlockBroken());
        if(blockData == null) return;

        if(blockData.magical && random.nextInt(20) == 7){
            playerAccount.setMagicOre(playerAccount.getMagicOre() + 1);
            player.sendMessage(ChatColor.DARK_PURPLE + ChatColor.BOLD.toString() + "MAGICAL DROP! " + ChatColor.LIGHT_PURPLE + "+1 Magic Ore");
        }

        player.getInventory().addItem(blockData.drop);
    }
}
