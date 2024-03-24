package com.amirparsa.skymine.respawnblocks;

import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class RespawnBlocksRunnable extends BukkitRunnable {

    private ArrayList<BrokenBlock> blocks = new ArrayList<>();

    @Override
    public void run() {
        if(blocks.isEmpty()) return;
        for (int i = 0; i < blocks.size(); i++) {
            if(blocks.get(i).getTimer() == 0){
                blocks.get(i).getLocation().getBlock().setType(blocks.get(i).getType());
                blocks.remove(i);
                i--;
            }else{
                blocks.get(i).setTimer(blocks.get(i).getTimer() - 1);
            }
        }
    }

    public ArrayList<BrokenBlock> getBlocks() {
        return blocks;
    }
}
