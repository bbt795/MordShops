package me.billbominecraft.mordshops.menusystem;

public abstract class PaginatedMenu extends Menu{

    //Keep track of what page the menu is on
    protected int page = 0;
    //28 is max items because with the border set below,
    //28 empty slots are remaining.
    protected int maxItemsPerPage = 28;
    //the index represents the index of the slot
    //that the loop is on
    protected int index = 0;

    public PaginatedMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    public int getMaxItemsPerPage() {
        return maxItemsPerPage;
    }


}
