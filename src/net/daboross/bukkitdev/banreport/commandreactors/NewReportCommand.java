package net.daboross.bukkitdev.banreport.commandreactors;

import net.daboross.bukkitdev.banreport.bukkit.BanReportBukkitMain;
import net.daboross.bukkitdev.banreport.database.BanReportXMLDatabase;
import net.daboross.bukkitdev.commandexecutorbase.CommandExecutorBase;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/**
 *
 * @author daboross
 */
public class NewReportCommand implements CommandExecutorBase.CommandReactor {

    private final BanReportXMLDatabase database;

    public NewReportCommand(BanReportXMLDatabase database) {
        this.database = database;
    }

    @Override
    public void runCommand(CommandSender sender, Command mainCommand, String mainCommandLabel, String subCommand, String subCommandLabel, String[] subCommandArgs, CommandExecutorBase.CommandExecutorBridge executorBridge) {
        throw new UnsupportedOperationException("NewReportCommand: Not Created Yet!: runCommand");
    }
}
