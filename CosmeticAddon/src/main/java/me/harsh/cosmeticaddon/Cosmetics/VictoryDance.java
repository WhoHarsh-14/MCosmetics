package me.harsh.cosmeticaddon.Cosmetics;



import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.Valid;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;
import org.mineacademy.fo.remain.CompMetadata;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter(AccessLevel.PROTECTED)
public abstract class VictoryDance {
    private Player player;
    protected String ITEM_KEY = "VictoryDance";
    private String name;
    private String itemName;
    private Integer countdown = 0;

    public void spawn(EntityType entityType) {
        Valid.checkNotNull(player);
        Location location = player.getLocation();
        Valid.checkBoolean(entityType.isAlive() && entityType.isSpawnable(), "It Is Not Spawnable");
        Entity entity = (LivingEntity) location.getWorld().spawnEntity(location, entityType);
        entity.setCustomName(name);
        entity.setCustomNameVisible(true);
        entity.addPassenger(player);
        player.setGlowing(true);
        location.getWorld().createExplosion(location, 1);
        player.setHealthScale(30);
        player.setHealth(player.getHealthScale());
        entity.setVelocity(player.getEyeLocation().getDirection().multiply(3));
        Common.runTimer(20, () -> {
            countdown ++;
            if (countdown == 5){
                entity.remove();
                countdown = 0;
                return;
            }
        });
    }
    public void spawnItem(CompMaterial material){
        Valid.checkNotNull(player);
        ItemStack item = ItemCreator.of(material, Common.colorize(itemName)).build().make();
        CompMetadata.setMetadata(item, ITEM_KEY, "Items");
        player.getInventory().clear();
        player.getInventory().addItem(item);
    }

    public String getName() {
        return name;
    }

    public Player getPlayer() {
        return player;
    }
}
