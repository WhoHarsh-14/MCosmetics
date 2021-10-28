package me.harsh.cosmeticaddon.Configs;

import lombok.Getter;
import me.harsh.cosmeticaddon.Cosmetics.VictoryDanceNames;
import org.mineacademy.fo.settings.YamlSectionConfig;

import java.util.UUID;

@Getter
public class StoreConfig extends YamlSectionConfig {

    private final UUID uuid;
    private VictoryDanceNames dance;
    public StoreConfig(final UUID uuid){
        super(uuid.toString());

        this.uuid = uuid;
        loadConfiguration(NO_DEFAULT, "data.db");
    }

    @Override
    protected void onLoadFinish() {
        this.dance = getEnum("dance", VictoryDanceNames.class);
    }

    public void setDance(VictoryDanceNames names) {
        this.dance = names;

        save("dance", dance);
    }

    public VictoryDanceNames getDance() {
        return dance;
    }
}
