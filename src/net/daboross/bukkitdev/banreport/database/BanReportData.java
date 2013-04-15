package net.daboross.bukkitdev.banreport.database;

import net.daboross.dxml.DXMLException;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/**
 *
 * @author daboross
 */
public class BanReportData {

    public final String reportText;
    public final BanReportLocation location;
    public final long reportTime;

    public BanReportData(String reportText, BanReportLocation location, long reportTime) {
        this.reportText = reportText;
        this.location = location;
        this.reportTime = reportTime;
    }

    public BanReportData(Node node) throws DXMLException {
        if (node == null) {
            throw new IllegalArgumentException("Null Node");
        }
        if (!(node.getNodeName().equalsIgnoreCase("banreport") && node.hasChildNodes() && node.hasAttributes())) {
            throw new DXMLException("Not BanReport Node!");
        }
        NamedNodeMap attributeMap = node.getAttributes();
        throw new DXMLException();
    }
}
