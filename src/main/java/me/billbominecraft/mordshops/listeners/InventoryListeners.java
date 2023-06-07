package me.billbominecraft.mordshops.listeners;

import me.billbominecraft.mordshops.utils.ShopUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;

public class InventoryListeners implements Listener {

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e){

        if (e.getView().getTitle().equalsIgnoreCase(((Player) e.getPlayer()).getDisplayName() + "'s Shop")){

            Player p = (Player) e.getPlayer();

            ArrayList<ItemStack> prunedItems = new ArrayList<>();

            Arrays.stream(e.getInventory().getContents())
                    .filter(itemStack -> {
                        if (itemStack == null){
                            return false;
                        }
                        return true;
                    })
                    .forEach(itemStack -> prunedItems.add(itemStack));

            System.out.println("size: " + prunedItems.size());

            ShopUtils.storeItems(prunedItems, p);

        }

    }


}
