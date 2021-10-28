package me.harsh.cosmeticaddon.Commands;

import me.harsh.cosmeticaddon.Menu.MainMenu;
import org.mineacademy.fo.command.SimpleCommand;

public class CosmeticCommand extends SimpleCommand {

    public CosmeticCommand() {
        super("gameMenu");
    }

    @Override
    protected void onCommand() {
        checkConsole();
        MainMenu menu = new MainMenu();
        menu.displayTo(getPlayer());
    }
}
