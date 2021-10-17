package me.harsh.cosmeticaddon.Menu;

import me.harsh.cosmeticaddon.Menu.BedBreakEffect.BedBreakMenu;
import me.harsh.cosmeticaddon.Menu.BowTrails.BowTrailMenu;
import me.harsh.cosmeticaddon.Menu.FinalKillEffect.FinalKillMenu;
import me.harsh.cosmeticaddon.Menu.VictoryDance.VictoryDanceMenu;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.button.Button;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.model.SimpleSound;
import org.mineacademy.fo.remain.CompMaterial;
import org.mineacademy.fo.remain.CompSound;


public class MainMenu extends Menu {

    private final Button victoryDance;
    private final Button bowTrails;
    private final Button finalKillEffect;
    private final Button bedBreakEffect;

    public MainMenu(){
        setSize(45);
        setTitle("&b&lIn Game Cosmetics");
        victoryDance = new Button() {
            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType click) {
                VictoryDanceMenu menu1 = new VictoryDanceMenu();
                CompSound.WITHER_SPAWN.play(player);
                menu1.displayTo(player);
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(
                        CompMaterial.DRAGON_EGG,
                        "&aVictory Dances",
                        "",
                        "&bInGame Victory Dances"
                ).build().make();
            }
        };
        bedBreakEffect = new Button() {
            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType click) {
                Menu menu1 = new BedBreakMenu();
                CompSound.WITHER_SPAWN.play(player);
                menu1.displayTo(player);
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(
                        CompMaterial.RED_BED,
                        "&aBed BreakEffects",
                        "",
                        "&bEffects After You Break A Bed"
                ).build().make();
            }
        };
        bowTrails = new Button() {
            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType click) {
                Menu menu1 = new BowTrailMenu();
                menu1.displayTo(player);
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(
                        CompMaterial.BOW,
                        "&aBow Trails",
                        "",
                        "&bShows Particle On Your Arrow",
                        "When You Use a Bow"
                ).build().make();
            }
        };

        finalKillEffect = new Button() {
            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType click) {
                Menu menu1 = new FinalKillMenu();
                menu1.displayTo(player);
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(
                        CompMaterial.DIAMOND_SWORD,
                        "&aFinal Kill Effets",
                        "",
                        "&bIn Game Effect After You",
                        "Final Kill Some one"
                ).build().make();
            }
        };
    }

    @Override
    public ItemStack getItemAt(int slot) {
        switch (slot){
            case 11:
                return  victoryDance.getItem();
            case 14:
                return bedBreakEffect.getItem();
            case 21:
                return finalKillEffect.getItem();
        }
        return ItemCreator.of(CompMaterial.CYAN_STAINED_GLASS_PANE, "").build().make();
    }

    @Override
    protected String[] getInfo() {
        return new String[]{"Left Click to Enter Category"};
    }
}
