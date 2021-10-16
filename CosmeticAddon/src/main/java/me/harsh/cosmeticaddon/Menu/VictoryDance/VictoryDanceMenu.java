package me.harsh.cosmeticaddon.Menu.VictoryDance;

import me.harsh.cosmeticaddon.Cosmetics.VictoryDance;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.MenuPagged;

public class VictoryDanceMenu extends Menu {

    public VictoryDanceMenu(){
        setSize(45);
        setTitle("&b&lVictory Dances");
    }

    @Override
    public ItemStack getItemAt(int slot) {
        return null;
    }

    @Override
    protected String[] getInfo() {
        return new String[]{"In Game Victory Dances"};
    }
}
