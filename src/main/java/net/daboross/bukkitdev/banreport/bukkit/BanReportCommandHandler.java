package net.daboross.bukkitdev.banreport.bukkit;

import net.daboross.bukkitdev.banreport.commandreactors.NewReportCommand;
import net.daboross.bukkitdev.commandexecutorbase.CommandExecutorBase;
import net.daboross.bukkitdev.commandexecutorbase.SubCommand;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author daboross
 */
public class BanReportCommandHandler {

    private CommandExecutorBase commandExecutorBase;

    public BanReportCommandHandler() {
        commandExecutorBase = new CommandExecutorBase("banreport.help");
        SubCommand newReportCommand = new SubCommand("newreport", new String[]{}, true, "banreport.newreport", "Creates a new report", new NewReportCommand(null));
        commandExecutorBase.addSubCommand(newReportCommand);
    }

    public void registerCommand(JavaPlugin plugin) {
        PluginCommand cmd = plugin.getCommand("banreport:banreport");
        if (cmd != null) {
            cmd.setExecutor(commandExecutorBase);
        }
    }
}
