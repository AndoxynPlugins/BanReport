package net.daboross.bukkitdev.banreport;

import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author daboross
 */
public class BanReport extends JavaPlugin {

    @Override
    public void onEnable() {
        System.err.println("BanReport: Overridden Method Body Called: onEnable");
    }

    @Override
    public void onDisable() {
        System.err.println("BanReport: Overridden Method Body Called: onDisable");
    }
}
