package me.harsh.cosmeticaddon.Menu.VictoryDance;

import com.comphenix.protocol.PacketType;
import com.yapzhenyie.GadgetsMenu.api.GadgetsMenuAPI;
import com.yapzhenyie.GadgetsMenu.player.PlayerManager;
import fr.xephi.authme.libs.de.rtner.security.auth.spi.MacBasedPRF;
import me.harsh.cosmeticaddon.Configs.ConfigYamlSettings;
import me.harsh.cosmeticaddon.CosmeticAddon;
import me.harsh.cosmeticaddon.Cosmetics.VictoryDance;
import me.harsh.cosmeticaddon.Cosmetics.VictoryDanceNames;
import me.harsh.cosmeticaddon.Cosmetics.VictoryDances.DragonSummoner;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.MenuPagged;
import org.mineacademy.fo.menu.button.Button;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class VictoryDanceMenu extends Menu {
    private final List<Player> dragonSummor = new ArrayList<>();
    private final List<Player> joyStick = new ArrayList<>();
    private final List<Player> witherDomination = new ArrayList<>();

    private final Button dragonSummoner;
    public VictoryDanceMenu(){
        setSize(45);
        setTitle("&b&lVictory Dances");
        dragonSummoner = new Button() {
            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType click) {
                if (dragonSummor.contains(player) && CosmeticAddon.playerCosmetic.containsKey(player.getUniqueId())) {
                    CosmeticAddon.playerCosmetic.replace(player.getUniqueId(), VictoryDanceNames.ENDER_DRAGON);
                    tell("&aYou Setted Your Victory Dance to Dragon Summoner");
                }else if (!dragonSummor.contains(player) && !CosmeticAddon.playerCosmetic.containsKey(player.getUniqueId())){
                    if (CosmeticAddon.getMode().equalsIgnoreCase("eco")){
                        if (CosmeticAddon.getEconomy().has(player, ConfigYamlSettings.DRAGON)){
                            CosmeticAddon.getEconomy().withdrawPlayer(player, ConfigYamlSettings.DRAGON);
                            dragonSummor.add(player);
                        }
                    }else {
                        PlayerManager manager = GadgetsMenuAPI.getPlayerManager(player);
                       int mysteryDust = manager.getMysteryDust();
                       if (mysteryDust >= ConfigYamlSettings.DRAGON){
                           manager.removeMysteryDust(ConfigYamlSettings.DRAGON);
                           dragonSummor.add(player);
                           CosmeticAddon.playerCosmetic.put(player.getUniqueId(), VictoryDanceNames.ENDER_DRAGON);
                           tell("&aSucessfully Bought Dragon Summoner");
                       }else {
                           tell("&c&lYou Dont Have Enough MysteryDust!");
                       }
                    }
                }
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(
                        CompMaterial.DRAGON_HEAD,
                        "&aDragon Sumonner",
                        "",
                        "&bDragon Will Carry You",
                        "&bAfter Victory"
                ).build().make();
            }
        };
    }

    @Override
    public ItemStack getItemAt(int slot) {
        if (slot == 14){
            return dragonSummoner.getItem();
        }
        return null;
    }

    @Override
    protected String[] getInfo() {
        return new String[]{"In Game Victory Dances"};
    }
}
