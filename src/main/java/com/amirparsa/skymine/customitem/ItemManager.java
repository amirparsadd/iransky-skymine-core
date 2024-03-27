package com.amirparsa.skymine.customitem;

import java.util.HashMap;

public class ItemManager {
    private HashMap<String, CustomItem> map = new HashMap<>();

    public HashMap<String, CustomItem> getMap() {
        return map;
    }

    public void register(CustomItem item){
        map.put(item.getId(), item);
    }

    public void setMap(HashMap<String, CustomItem> map) {
        this.map = map;
    }
}
