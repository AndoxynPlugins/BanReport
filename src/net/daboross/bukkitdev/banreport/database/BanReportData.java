package net.daboross.bukkitdev.banreport.database;

import net.daboross.dxml.DXMLException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/**
 *
 * @author daboross
 */
public class BanReportData {

    public final String reporterName;
    public final String reportText;
    public final BanReportLocation location;
    public final long reportTime;

    public BanReportData(String reportText, BanReportLocation location, long reportTime, String reporterName) {
        if (reportText == null || location == null || reporterName == null) {
            throw new IllegalArgumentException("One or more null arguments in constructor");
        }
        this.reportText = reportText;
        this.location = location;
        this.reportTime = reportTime;
        this.reporterName = reporterName;
    }

    public BanReportData(Node node) throws DXMLException {
        if (node == null) {
            throw new IllegalArgumentException("Null Node");
        }
        if (!(node.getNodeName().equalsIgnoreCase("banreport") && node.hasChildNodes() && node.hasAttributes())) {
            throw new DXMLException("Not BanReport Node!");
        }
        NamedNodeMap attributeMap = node.getAttributes();
        Node reportTimeNode = attributeMap.getNamedItem("reporttime");
        Node reportTextNode = attributeMap.getNamedItem("reporttext");
        if (reportTextNode == null || reportTimeNode == null) {
            throw new DXMLException("Time and/or Text not found!");
        }
        throw new DXMLException();
    }

    public Element putOnElement(Document d) {
        Element e = d.createElement("banreport");
        e.setAttribute("reporttext", reportText);
        e.setAttribute("reporttime", String.valueOf(reportTime));
        Element child = d.createElement("banreportlocation");
        Element locationElement = location.toElement(d);
        child.appendChild(locationElement);
        e.appendChild(child);
        return null;
    }
}
