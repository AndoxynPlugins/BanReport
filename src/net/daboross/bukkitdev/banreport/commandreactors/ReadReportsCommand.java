package net.daboross.bukkitdev.banreport.commandreactors;

import net.daboross.bukkitdev.banreport.database.BanReportXMLDatabase;
import net.daboross.bukkitdev.commandexecutorbase.CommandExecutorBase;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/**
 *
 * @author daboross
 */
public class ReadReportsCommand implements CommandExecutorBase.CommandReactor {

    private final BanReportXMLDatabase database;

    public ReadReportsCommand(BanReportXMLDatabase database) {
        this.database = database;
    }

    @Override
    public void runCommand(CommandSender sender, Command mainCommand, String mainCommandLabel, String subCommand, String subCommandLabel, String[] subCommandArgs, CommandExecutorBase.CommandExecutorBridge executorBridge) {
        throw new UnsupportedOperationException("ReadReportsCommand: Not Created Yet!: runCommand");
    }
}
