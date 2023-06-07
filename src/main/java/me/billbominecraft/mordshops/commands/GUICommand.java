package me.billbominecraft.mordshops.commands;

import me.billbominecraft.mordshops.classes.Shop;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class GUICommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player player = (Player) sender;

            Shop shop = new Shop(player);

            shop.shopOpenInventory(player);


        }

        return true;
    }
}
