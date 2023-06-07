package me.billbominecraft.mordshops;

import org.bukkit.ChatColor;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;
import org.bukkit.conversations.StringPrompt;

public class ConvPrompt extends StringPrompt {
    @Override
    public String getPromptText(ConversationContext context) {

        String tag = ChatColor.BLUE + "[" + ChatColor.AQUA + "MordShops" + ChatColor.BLUE + "] " + ChatColor.RESET;
        return tag + "Please enter the name of your shop.";

    }

    @Override
    public Prompt acceptInput(ConversationContext context, String input) {
        return null;
    }
}
