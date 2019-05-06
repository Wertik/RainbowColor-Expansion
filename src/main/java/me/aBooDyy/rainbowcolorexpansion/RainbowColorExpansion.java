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
        return "1.2";
    }

    @Override
    public String onRequest(OfflinePlayer p, String identifier) {
        identifier = PlaceholderAPI.setBracketPlaceholders(p, identifier);
        text = new StringBuilder();
        String[] rainbow = {"c", "6", "e", "a", "b", "9", "5"};
        i = 0;

        if (identifier.startsWith("custom_")) {
            String[] args = identifier.replace("custom_", "").split("_", 2);
            if (args.length <= 1) return null;
            rainbow = args[0].split(",");
            identifier = args[1];
        }

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
