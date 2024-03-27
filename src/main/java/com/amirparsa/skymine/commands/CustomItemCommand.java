package com.amirparsa.skymine.commands;

import com.amirparsa.skymine.SkyMine;
import com.amirparsa.skymine.SkyMinePlayer;
import com.amirparsa.skymine.customitem.CustomItem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class CustomItemCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player p){
            if(!p.hasPermission("iransky.admin")) return true;
            if(strings.length != 3){
                p.sendMessage(ChatColor.RED + "Wrong Arguments");
                return false;
            }

            String id = strings[0];
            boolean magical = false;
            int level;

            if(strings[2].equals("true")) magical = true;

            try {
                level = Integer.parseInt(strings[1]);
            }catch (NumberFormatException exception){
                p.sendMessage(ChatColor.RED + "Unknown Number");
                return true;
            }

            CustomItem item = SkyMine.getPlugin().getItemManager().getMap().get(id);

            p.getInventory().addItem(item.build(magical, level));
        }
        return true;
    }
}
