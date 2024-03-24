package com.amirparsa.skymine.respawnblocks;

import com.amirparsa.skymine.SkyMine;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class RespawnBlocksRunnable extends BukkitRunnable {

    private ArrayList<BrokenBlock> blocks = new ArrayList<>();

    @Override
    public void run() {
        for (BrokenBlock block : blocks) {
            block.lowerTimer();
            if(block.getTimer() <= 0) {
                if (block.isLoaded()) {
                    block.getLocation().getBlock().setType(block.getType());
                    blocks.remove(block);
                }
            }
        }
    }

    public ArrayList<BrokenBlock> getBlocks() {
        return blocks;
    }
}
