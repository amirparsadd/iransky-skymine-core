package com.amirparsa.skymine.commands;

import com.amirparsa.skymine.SkyMine;
import com.amirparsa.skymine.SkyMinePlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AddMagicOreCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof ConsoleCommandSender){
            if(strings.length != 2){
                Bukkit.getLogger().info(ChatColor.RED + "Wrong Arguments");
                return false;
            }

            Player player = Bukkit.getPlayer(strings[0]);

            if(player == null){
                Bukkit.getLogger().info(ChatColor.RED + "Unknown Player");
                return true;
            }

            SkyMinePlayer playerAccount = SkyMine.getPlugin().getPlayerManager().getPlayer(player.getUniqueId());
            int amount;

            try {
                amount = Integer.parseInt(strings[1]);
            }catch (NumberFormatException exception){
                Bukkit.getLogger().info(ChatColor.RED + "Unknown Number");
                return true;
            }

            playerAccount.setMagicOre(playerAccount.getMagicOre() + amount);
        }else if(commandSender instanceof Player p){
            if(!p.hasPermission("iransky.admin")) return true;
            if(strings.length != 2){
                p.sendMessage(ChatColor.RED + "Wrong Arguments");
                return false;
            }

            Player player = Bukkit.getPlayer(strings[0]);

            if(player == null){
                p.sendMessage(ChatColor.RED + "Unknown Player");
                return true;
            }

            SkyMinePlayer playerAccount = SkyMine.getPlugin().getPlayerManager().getPlayer(player.getUniqueId());
            int amount;

            try {
                amount = Integer.parseInt(strings[1]);
            }catch (NumberFormatException exception){
                p.sendMessage(ChatColor.RED + "Unknown Number");
                return true;
            }

            playerAccount.setMagicOre(playerAccount.getMagicOre() + amount);
        }
        return true;
    }
}
