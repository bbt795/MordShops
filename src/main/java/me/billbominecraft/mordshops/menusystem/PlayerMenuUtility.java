package me.billbominecraft.mordshops.menusystem;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class PlayerMenuUtility {

    private Player owner;
    private Block signInteract;

    public PlayerMenuUtility(Player p) {
        this.owner = p;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Block getSignInteract() {
        return signInteract;
    }

    public void setSignInteract(Block signInteract) {
        this.signInteract = signInteract;
    }

}
