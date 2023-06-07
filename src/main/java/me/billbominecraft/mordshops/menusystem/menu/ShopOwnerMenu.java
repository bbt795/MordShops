package me.billbominecraft.mordshops.menusystem.menu;

import me.billbominecraft.mordshops.menusystem.PaginatedMenu;
import me.billbominecraft.mordshops.menusystem.PlayerMenuUtility;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.block.TileState;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataContainer;

import java.util.UUID;

public class ShopOwnerMenu extends PaginatedMenu {

    public ShopOwnerMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return null;
    }

    @Override
    public int getSlots() {
        return 54;
    }

    @Override
    public void handleMenu(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();

        if(e.getCurrentItem().getType().equals(Material.ARROW)){

            if(page == 0){


            }

        }

    }

    @Override
    public void setMenuItems() {

        ItemStack[] itemList = new ItemStack[54];
        for (int i = 0; i < 54; i++) {

            if (i >= 18 && i <= 44) {

                continue;

            }

            switch (i) {

                case 4:
                    Player playerToOpenInventory = playerMenuUtility.getOwner();
                    PlayerMenuUtility playerMenuUtility = new PlayerMenuUtility(playerToOpenInventory);
                    TileState sign = (TileState) playerMenuUtility.getSignInteract().getState();
                    PersistentDataContainer data = sign.getPersistentDataContainer();
                    OfflinePlayer ownerHead = Bukkit.getOfflinePlayer(UUID.fromString(data.toString()));

                    ItemStack playerSkull = new ItemStack(Material.PLAYER_HEAD);
                    SkullMeta playerSkull_meta = (SkullMeta) playerSkull.getItemMeta();

                    playerSkull_meta.setDisplayName(ChatColor.LIGHT_PURPLE + ownerHead.getName() + "'s Shop");
                    playerSkull_meta.setOwningPlayer(ownerHead);

                    playerSkull.setItemMeta(playerSkull_meta);

                    itemList[i] = playerSkull;
                    break;

                case 11:
                    ItemStack leftSign = new ItemStack(Material.OAK_SIGN);
                    ItemMeta leftSign_meta = leftSign.getItemMeta();

                    leftSign_meta.setDisplayName(ChatColor.LIGHT_PURPLE + "See Reviews");

                    leftSign.setItemMeta(leftSign_meta);

                    itemList[i] = leftSign;
                    break;

                case 15:
                    ItemStack rightSign = new ItemStack(Material.OAK_SIGN);
                    ItemMeta rightSign_meta = rightSign.getItemMeta();

                    rightSign_meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Edit Shop");

                    rightSign.setItemMeta(rightSign_meta);

                    itemList[i] = rightSign;
                    break;

                case 13:
                    ItemStack goldIngot = new ItemStack(Material.GOLD_INGOT);
                    ItemMeta goldIngot_meta = goldIngot.getItemMeta();

                    goldIngot_meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Balance");

                    goldIngot.setItemMeta(goldIngot_meta);

                    itemList[i] = goldIngot;
                    break;

                case 53:
                    ItemStack arrow = new ItemStack(Material.ARROW);
                    ItemMeta arrow_meta = arrow.getItemMeta();

                    arrow_meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Next Page");

                    arrow.setItemMeta(arrow_meta);

                    itemList[i] = arrow;
                    break;

                default:
                    itemList[i] = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                    break;

            }

            }

            inventory.setContents(itemList);

    }


}
