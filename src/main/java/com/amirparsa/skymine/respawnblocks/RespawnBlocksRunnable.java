package com.amirparsa.skymine.respawnblocks;

import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class RespawnBlocksRunnable extends BukkitRunnable {

    private ArrayList<BrokenBlock> blocks = new ArrayList<>();

    @Override
    public void run() {
        for (BrokenBlock block : blocks) {
            if(block.getTimer() == 0){
                if(block.isLoaded()){
                    block.getLocation().getBlock().setType(block.getType());
                    blocks.remove(block);
                }
            }else {
                block.setTimer(block.getTimer() - 1);
            }
        }
    }

    public ArrayList<BrokenBlock> getBlocks() {
        return blocks;
    }
}
