package net.daboross.bukkitdev.banreport.bukkit;

import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author daboross
 */
public class BanReportBukkitMain extends JavaPlugin {

    private BanReportCommandHandler commandHandler;

    @Override
    public void onEnable() {
        commandHandler = new BanReportCommandHandler();
        commandHandler.registerCommand(this);
    }

    @Override
    public void onDisable() {
    }
}
