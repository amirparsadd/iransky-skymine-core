package com.amirparsa.skymine.utils;

import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class PDCHelper {

    public static boolean getBool(PersistentDataContainer pdc, NamespacedKey key){
        if(pdc.has(key, PersistentDataType.INTEGER)){
            return pdc.get(key, PersistentDataType.INTEGER) == 1;
        }else{
            return false;
        }
    }

    public static void setBool(PersistentDataContainer pdc, NamespacedKey key, boolean bool){
        pdc.set(key, PersistentDataType.INTEGER, bool ? 1 : 0);
    }

    public static int getInteger(PersistentDataContainer pdc, NamespacedKey key){
        if(pdc.has(key, PersistentDataType.INTEGER)){
            return pdc.get(key, PersistentDataType.INTEGER);
        }else{
            return 0;
        }
    }

    public static void setInteger(PersistentDataContainer pdc, NamespacedKey key, int integer){
        pdc.set(key, PersistentDataType.INTEGER, integer);
    }
}
