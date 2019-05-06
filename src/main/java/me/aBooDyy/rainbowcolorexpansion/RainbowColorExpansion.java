package me.aBooDyy.rainbowcolorexpansion;

import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;

public class RainbowColorExpansion extends PlaceholderExpansion {

    private StringBuilder text;
    private int i;

    @Override
    public String getIdentifier() {
        return "rainbowcolor";
    }

    @Override
    public String getAuthor() {
        return "aBooDyy";
    }

    @Override
    public String getVersion() {
        return "1.1";
    }

    @Override
    public String onRequest(OfflinePlayer p, String identifier) {
        identifier = PlaceholderAPI.setBracketPlaceholders(p, identifier);
        if (identifier.startsWith("custom_")) {
            text = new StringBuilder();
            i = 0;
            String[] args = identifier.replace("custom_", "").split("_", 2);
            if (args.length <= 1) return null;

            String[] rainbow = args[0].split(",");

            for (char c : args[1].toCharArray()) {
                if (c == ' ') {
                    text.append(" ");
                    continue;
                }

                text.append(ChatColor.COLOR_CHAR);
                text.append(rainbow[i]);
                text.append(c);
                i++;

                if (i == rainbow.length) {
                    i = 0;
                }
            }
            return text.toString();
        }
        text = new StringBuilder();
        String[] rainbow = {"c", "6", "e", "a", "b", "9", "5"};
        i = 0;
        for (char c : identifier.toCharArray()) {
            if (c == ' ') {
                text.append(" ");
                continue;
            }

            text.append(ChatColor.COLOR_CHAR);
            text.append(rainbow[i]);
            text.append(c);
            i++;

            if (i == rainbow.length) {
                i = 0;
            }
        }
        return text.toString();
    }
}
