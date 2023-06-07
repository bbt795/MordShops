package me.billbominecraft.mordshops.listeners;

import me.billbominecraft.mordshops.MordShops;
import me.billbominecraft.mordshops.classes.Shop;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Sign;
import org.bukkit.block.TileState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class SignListeners implements Listener {

    @EventHandler
    public void onSignPlace(SignChangeEvent e){

        if(e.getLine(1).equals("[shop create]")){

            Player player = e.getPlayer();
            Shop shop = new Shop(player);
            TileState sign = (TileState) e.getBlock().getState();
            PersistentDataContainer data = sign.getPersistentDataContainer();
            NamespacedKey key = new NamespacedKey(MordShops.getPlugin(), "shop");

            if(!(MordShops.playerShops.containsKey(player.getUniqueId().toString()))) {

                data.set(key, PersistentDataType.STRING, player.getUniqueId().toString());
                sign.update();

                e.setLine(0, ChatColor.GOLD + "--==++==--");
                e.setLine(1, ChatColor.GREEN + shop.getStatus());
                e.setLine(2, ChatColor.BLUE + player.getDisplayName() + "'s Shop");
                e.setLine(3, ChatColor.GOLD + "--==++==--");

                shop.shopOpenInventory(player);
                MordShops.playerShops.put(player.getUniqueId().toString(), shop);

            } else {

                String tag = ChatColor.BLUE + "[" + ChatColor.AQUA + "MordShops" + ChatColor.BLUE + "] " + ChatColor.RESET;
                player.sendMessage(tag + "You already own a shop. Please move or remove your current one.");

            }

        }

    }

    @EventHandler
    public void onSignOpen(PlayerInteractEvent e){

        Player player = e.getPlayer();

        if(!e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){

            return;

        }

        if(e.getClickedBlock().getState() instanceof Sign) {

            Sign sign = (Sign) e.getClickedBlock().getState();
            PersistentDataContainer data = sign.getPersistentDataContainer();

            if(data.has(new NamespacedKey(MordShops.getPlugin(), "shop"), PersistentDataType.STRING)){

                String signUUID = data.get(new NamespacedKey(MordShops.getPlugin(), "shop"), PersistentDataType.STRING);
                MordShops.playerShops.get(signUUID).shopOpenInventory(player);

            }

        }

    }

    @EventHandler
    public void onSignRemove(BlockBreakEvent e){

        if(!(e.getBlock() instanceof Sign)){

            return;

        }

        Sign sign = (Sign) e.getBlock().getState();
        PersistentDataContainer data = sign.getPersistentDataContainer();

        if(data.has(new NamespacedKey(MordShops.getPlugin(), "shop"), PersistentDataType.STRING)){

            String signUUID = data.get(new NamespacedKey(MordShops.getPlugin(), "shop"), PersistentDataType.STRING);
            MordShops.playerShops.remove(signUUID);

        }

    }

}
