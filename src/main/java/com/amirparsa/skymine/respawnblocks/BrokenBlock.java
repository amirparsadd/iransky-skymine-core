package com.amirparsa.skymine.respawnblocks;

import org.bukkit.Location;
import org.bukkit.Material;

public class BrokenBlock {
    private Location location;
    private Material type;
    private int timer;

    public boolean isLoaded(){
        //Check And See If The Chunk IS Loaded
        return location.getChunk().isLoaded();
    }

    public Material getType() {
        return type;
    }

    public void setType(Material type) {
        this.type = type;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        timer = timer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public BrokenBlock(Location location, Material type) {
        this.location = location;
        this.type = type;
        this.timer = 5;
    }

    public BrokenBlock(Location location, Material type, int timer) {
        this.location = location;
        this.type = type;
        this.timer = timer;
    }
}
