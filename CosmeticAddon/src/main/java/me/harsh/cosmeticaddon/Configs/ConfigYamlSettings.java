package me.harsh.cosmeticaddon.Configs;

import org.mineacademy.fo.settings.SimpleSettings;
import org.mineacademy.fo.settings.YamlConfig;

public class ConfigYamlSettings extends SimpleSettings {
    public static String MODE;
    public static int DRAGON;
    public static int WITHER;
    public static int JOYSTICK;
    public static int LIGHTING;
    public static int PIGSPAWN;
    public static int FLAME;
    public static int ROCKET;
    public static int ZOMBIE;


    @Override
    protected int getConfigVersion() {
        return 1;
    }

    private static void init(){
        MODE = getString("mode");
        DRAGON = getInteger("dragon-summoner");
        WITHER = getInteger("wither-diployer");
        JOYSTICK = getInteger("joystick");
        LIGHTING = getInteger("lighting");
        ZOMBIE = getInteger("zombie-death");
        PIGSPAWN = getInteger("pig-spawn");
        FLAME = getInteger("flame");
        ROCKET = getInteger("rocket");
    }
}
