package com.amirparsa.skymine;

import java.util.HashMap;
import java.util.UUID;

public class PlayerManager {
    private static HashMap<UUID, SkyMinePlayer> map = new HashMap<>();

    public static void addPlayer(UUID uuid){
        map.put(uuid, new SkyMinePlayer(uuid));
    }

    public static void removePlayer(UUID uuid){
        map.remove(uuid);
    }

    public static SkyMinePlayer getPlayer(UUID uuid){
        return map.get(uuid);
    }
}
