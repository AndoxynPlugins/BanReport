package net.daboross.bukkitdev.banreport.bukkit;

import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author daboross
 */
public class BanReportBukkitMain extends JavaPlugin {

    private BanReportCommandExecutor mainReportCommandExecutor;

    @Override
    public void onEnable() {
        mainReportCommandExecutor = new BanReportCommandExecutor();
    }

    @Override
    public void onDisable() {
    }
}
