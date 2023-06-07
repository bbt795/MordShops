package me.billbominecraft.mordshops.classes;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Shop {

    Player owner;
    ItemStack[] shopItems = new ItemStack[27];
    Boolean open;
    int balance;
    String name;
    String description;
    Material backgroundColor;
    int pageNumber;
    String tag = ChatColor.BLUE + "[" + ChatColor.AQUA + "MordShops" + ChatColor.BLUE + "] " + ChatColor.RESET;


    public Shop(Player owner){

        this.owner = owner;
        this.open = true;

    }

    private void shopClose(){

        this.open = false;

    }

    private void shopOpen(){

        this.open = true;

    }

    public String getName(){

        return name;

    }

    public String getStatus(){

        if(open){

            return ChatColor.GREEN + "Open";

        } else {

            return ChatColor.RED + "Closed";

        }

    }

    public void shopOpenInventory(Player player){

        player.sendMessage(tag + "Opening shop...");

        if(!open){

            player.sendMessage(tag + ChatColor.RED + "This shop is currently closed. Please come back later.");

        }

        Inventory gui = Bukkit.createInventory(player, 54, owner.getDisplayName() + "'s Shop");

        if(player.getDisplayName().equals(owner.getDisplayName())){

                ItemStack[] itemList = new ItemStack[54];
                for (int i = 0; i < 54; i++) {

                    if (i >= 18 && i <= 44) {

                        continue;

                    }

                    switch (i) {

                        case 4:
                            itemList[i] = new ItemStack(Material.GRAY_STAINED_GLASS);
                            break;

                        case 11:

                        case 15:
                            itemList[i] = new ItemStack(Material.OAK_SIGN);
                            break;

                        case 13:
                            itemList[i] = new ItemStack(Material.GOLD_INGOT);
                            break;

                        case 53:
                            itemList[i] = new ItemStack(Material.ARROW);
                            break;

                        default:
                            itemList[i] = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                            break;

                    }

                }

                gui.setContents(itemList);

                player.openInventory(gui);

        } else {

                ItemStack[] itemList = new ItemStack[54];
                for(int i = 0; i < 54; i++){

                    if(i >= 18 && i <= 44){

                        continue;

                    }

                    switch(i) {

                        case 4:
                            itemList[i] = new ItemStack(Material.GRAY_STAINED_GLASS);
                            break;

                        case 45:
                            itemList[i] = new ItemStack(Material.BOOK);
                            break;

                        case 53:
                            itemList[i] = new ItemStack(Material.ARROW);
                            break;

                        default:
                            itemList[i] = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                            break;

                    }

                }

                gui.setContents(itemList);

                player.openInventory(gui);

        }

    }

}
