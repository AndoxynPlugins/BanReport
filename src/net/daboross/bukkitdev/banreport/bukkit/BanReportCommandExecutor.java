package net.daboross.bukkitdev.banreport.bukkit;

import net.daboross.bukkitdev.commandexecutorbase.CommandExecutorBase;

/**
 *
 * @author daboross
 */
public class BanReportCommandExecutor extends CommandExecutorBase {

    public BanReportCommandExecutor() {
    }

    @Override
    protected String getCommandName() {
        return "br";
    }

    @Override
    protected String getMainCmdPermission() {
        return "banreport.help";
    }
}
