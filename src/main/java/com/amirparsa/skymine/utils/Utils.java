package com.amirparsa.skymine.utils;

public class Utils {
    public static String getFriendlyText(String text){
        //Credits To My Bro ChatGpt
        String[] words = text.toLowerCase().split("_");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(word.substring(0, 1).toUpperCase())
                        .append(word.substring(1))
                        .append(" ");
            }
        }

        return result.toString().trim();
    }
}
