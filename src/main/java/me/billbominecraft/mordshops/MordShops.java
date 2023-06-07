package me.billbominecraft.mordshops;

import me.billbominecraft.mordshops.classes.Shop;
import me.billbominecraft.mordshops.commands.GUICommand;
import me.billbominecraft.mordshops.listeners.InventoryListeners;
import me.billbominecraft.mordshops.listeners.SignListeners;
import me.billbominecraft.mordshops.menusystem.PlayerMenuUtility;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class MordShops extends JavaPlugin {

    private static MordShops plugin;
    private static final HashMap<Player, PlayerMenuUtility> playerMenuUtilityMap = new HashMap<>();
    public static final HashMap<String, Shop> playerShops = new HashMap<>();

    @Override
    public void onEnable() {
        // Plugin startup logic

        plugin = this;

        getCommand("gui").setExecutor(new GUICommand());
        Bukkit.getServer().getPluginManager().registerEvents(new SignListeners(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new InventoryListeners(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static PlayerMenuUtility getPlayerMenuUtility(Player p){

        PlayerMenuUtility playerMenuUtility;

        if(!(playerMenuUtilityMap.containsKey(p))){

            playerMenuUtility = new PlayerMenuUtility(p);
            playerMenuUtilityMap.put(p, playerMenuUtility);

            return playerMenuUtility;

        } else {

            return playerMenuUtilityMap.get(p);

        }

    }

    public static MordShops getPlugin() {

        return plugin;

    }

}
