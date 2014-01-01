/*
 * Copyright (C) 2013-2014 Dabo Ross <http://www.daboross.net/>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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
