package me.harsh.cosmeticaddon.Menu.VictoryDance;

import com.yapzhenyie.GadgetsMenu.GadgetsMenu;
import com.yapzhenyie.GadgetsMenu.api.GadgetsMenuAPI;
import com.yapzhenyie.GadgetsMenu.player.PlayerManager;
import me.harsh.cosmeticaddon.Configs.ConfigYamlSettings;
import me.harsh.cosmeticaddon.CosmeticAddon;
import me.harsh.cosmeticaddon.Cosmetics.VictoryDanceNames;
import me.harsh.cosmeticaddon.Configs.StoreConfig;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.permissions.PermissionAttachment;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.Valid;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.button.Button;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.plugin.SimplePlugin;
import org.mineacademy.fo.remain.CompMaterial;
import org.mineacademy.fo.remain.Remain;

import java.util.ArrayList;
import java.util.List;

public class VictoryDanceMenu extends Menu {
    private final List<Player> dragonSummor = new ArrayList<>();
    private final List<Player> joyStick = new ArrayList<>();
    private final List<Player> witherDomination = new ArrayList<>();

    private final Button dragonSummoner;

    private final String DRAGON_PERM = "addon.dragon";

    private final Integer dragonMoney = ConfigYamlSettings.DRAGON;
    public VictoryDanceMenu(){
        setSize(45);
        setTitle("&b&lVictory Dances");
        dragonSummoner = new Button() {
            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType click) {
                StoreConfig config = new StoreConfig(player.getUniqueId());
                if (player.hasPermission(DRAGON_PERM) && config.getDance() != VictoryDanceNames.ENDER_DRAGON) {
                    config.setDance(VictoryDanceNames.ENDER_DRAGON);
                    Common.tell(player, "&aSucessfully Setted Victory Dance to Dragon!");
                }

                if (!player.hasPermission(DRAGON_PERM)){
                    switch (CosmeticAddon.getMode()){
                        case "eco":
                            Valid.checkBoolean(CosmeticAddon.getEconomy().getBalance(player) < dragonMoney, "&cYou Dont Have Enough Coins");
                            CosmeticAddon.getEconomy().withdrawPlayer(player, dragonMoney);
                            break;
                        case "md":
                            PlayerManager playerManager = GadgetsMenu.getPlayerManager(player);
                            Valid.checkBoolean(playerManager.getMysteryDust() < dragonMoney, "&cYou Dont Have Enough Coins");
                            break;
                    }
                    player.addAttachment(SimplePlugin.getInstance(), DRAGON_PERM, true);
                }


            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(
                        CompMaterial.DRAGON_HEAD,
                        "&aDragon Sumonner",
                        "",
                        "&bDragon Will Carry You",
                        "",
                        "&aPrice: &6" + ConfigYamlSettings.DRAGON + "$"
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
