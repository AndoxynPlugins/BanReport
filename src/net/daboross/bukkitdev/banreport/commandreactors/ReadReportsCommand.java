package net.daboross.bukkitdev.banreport.commandreactors;

import net.daboross.bukkitdev.banreport.database.BanReportXMLDatabase;
import net.daboross.bukkitdev.commandexecutorbase.SubCommand;
import net.daboross.bukkitdev.commandexecutorbase.SubCommandHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/**
 *
 * @author daboross
 */
public class ReadReportsCommand implements SubCommandHandler {

    private final BanReportXMLDatabase database;

    public ReadReportsCommand(BanReportXMLDatabase database) {
        this.database = database;
    }

    @Override
    public void runCommand(CommandSender sender, Command baseCommand, String baseCommandLabel, SubCommand subCommand, String subCommandLabel, String[] subCommandArgs) {
    }
}
