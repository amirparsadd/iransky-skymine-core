package com.amirparsa.skymine;

import org.bukkit.NamespacedKey;

public enum KeyStore {

    PLAYED_BEFORE(new NamespacedKey(SkyMine.getPlugin(), "has-played-before")),
    LEVEL(new NamespacedKey(SkyMine.getPlugin(), "level")),
    XP(new NamespacedKey(SkyMine.getPlugin(), "xp")),
    MAGIC_ORE(new NamespacedKey(SkyMine.getPlugin(), "magic-ore")),
    ITEM_KEY(new NamespacedKey(SkyMine.getPlugin(), "item-key")),
    MAGICAL_ATTR(new NamespacedKey(SkyMine.getPlugin(), "item-magical")),
    BLOCKS_BROKEN(new NamespacedKey(SkyMine.getPlugin(), "blocks-broken"));


    public final NamespacedKey key;

    KeyStore(NamespacedKey key){
        this.key = key;
    }
}
