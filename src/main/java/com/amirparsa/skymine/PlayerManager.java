package com.amirparsa.skymine;

import java.util.HashMap;
import java.util.UUID;

public class PlayerManager {
    private HashMap<UUID, SkyMinePlayer> map = new HashMap<>();

    public void addPlayer(UUID uuid){
        map.put(uuid, new SkyMinePlayer(uuid));
    }

    public void removePlayer(UUID uuid){
        map.remove(uuid);
    }

    public SkyMinePlayer getPlayer(UUID uuid){
        return map.get(uuid);
    }

    public HashMap<UUID, SkyMinePlayer> getPlayers() {
        return map;
    }
}
