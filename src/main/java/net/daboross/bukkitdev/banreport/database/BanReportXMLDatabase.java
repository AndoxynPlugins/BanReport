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
package net.daboross.bukkitdev.banreport.database;

import java.io.File;
import java.io.IOException;
import net.daboross.bukkitdev.banreport.bukkit.BanReportBukkitMain;
import net.daboross.dxml.DXMLException;
import net.daboross.dxml.DXMLHelper;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 *
 * @author daboross
 */
public class BanReportXMLDatabase {

    private final File databaseFile;
    private final Document rootDocument;
    private final Node rootNode;
    private int nextAvalibleNumber = 0;

    public BanReportXMLDatabase(BanReportBukkitMain brbm) throws DXMLException {
        File databaseFolder = brbm.getDataFolder();
        if (!databaseFolder.exists()) {
            boolean done = databaseFolder.mkdirs();
            if (!done) {
                throw new DXMLException("Failed to create Database folder");
            }
        } else if (!databaseFolder.isDirectory()) {
            throw new DXMLException("Database folder is a file!");
        }
        databaseFile = new File(databaseFolder, "database.xml");
        boolean alreadyExisted = false;
        if (!databaseFile.exists()) {
            try {
                boolean done = databaseFile.createNewFile();
                if (!done) {
                    throw new DXMLException("Failed to create new database file!");
                }
            } catch (IOException ioe) {
                throw new DXMLException("Exception creating new database file!", ioe);
            }
        } else if (!databaseFile.isFile()) {
            throw new DXMLException("Database file is a folder!");
        } else {
            alreadyExisted = true;
        }
        if (alreadyExisted) {
            rootDocument = DXMLHelper.readDocument(databaseFile);
        } else {
            rootDocument = DXMLHelper.newDocument();
        }
        rootNode = rootDocument.createElement("banreportroot");
        rootDocument.appendChild(rootNode);
    }

    public int getNextAvalibleNumber() {
        return nextAvalibleNumber++;
    }
}
