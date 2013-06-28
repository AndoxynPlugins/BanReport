package net.daboross.bukkitdev.banreport.database;

import net.daboross.dxml.DXMLException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author daboross
 */
public class BanReportData {

    public final int reportNumber;
    public final String reporterName;
    public final String reportText;
    public final BanReportLocation location;
    public final long reportTime;

    public BanReportData(String reportText, BanReportLocation location, long reportTime, String reporterName, int reportNumber) {
        if (reportText == null || location == null || reporterName == null) {
            throw new IllegalArgumentException("One or more null arguments in constructor");
        }
        this.reportText = reportText;
        this.location = location;
        this.reportTime = reportTime;
        this.reporterName = reporterName;
        this.reportNumber = reportNumber;
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
        Node reportNumberNode = attributeMap.getNamedItem("reportnumber");
        Node reporterNameNode = attributeMap.getNamedItem("reportername");
        if (reportTextNode == null || reportTimeNode == null || reportNumberNode == null || reporterNameNode == null) {
            throw new DXMLException("Report Time, Report Text, Reporter Name and/or Report Number not found!");
        }
        String reportTimeString = reportTimeNode.getNodeValue();
        String reportTextString = reportTextNode.getNodeValue();
        String reportNumberString = reportNumberNode.getNodeValue();
        String reporterNameString = reporterNameNode.getNodeValue();
        if (reportTimeString == null || reportTextString == null || reportNumberString == null || reporterNameString == null) {
            throw new DXMLException("Report Time node, Report Text node, Reporter Name node and/or Report Number node has given null String value.");
        }
        reportText = reportTextString;
        reporterName = reporterNameString;
        int reportNumberTemp = 0;
        long reportTimeTemp = 0;
        try {
            reportTimeTemp = Long.parseLong(reportNumberString);
        } catch (NumberFormatException nfe) {
            throw new DXMLException("Report Time numberformatexception!", nfe);
        }
        try {
            reportNumberTemp = Integer.parseInt(reportNumberString);
        } catch (NumberFormatException nfe) {
            throw new DXMLException("Report Number numberformatexception!", nfe);
        }
        reportNumber = reportNumberTemp;
        reportTime = reportTimeTemp;
        NodeList children = node.getChildNodes();
        Node child = null;
        for (int i = 0; i < children.getLength(); i++) {
            Node current = children.item(i);
            if (current.getNodeName().equalsIgnoreCase("#text")) {
                continue;
            }
            if (current.getNodeName().equals("banreportlocation")) {
                child = current;
            }
        }
        if (child == null) {
            throw new DXMLException("Location Child not found!");
        }
        NodeList childChildren = child.getChildNodes();
        Node locationNode = null;
        for (int i = 0; i < childChildren.getLength(); i++) {
            Node current = childChildren.item(i);
            if (current.getNodeName().equalsIgnoreCase("#text")) {
                continue;
            }
            if (current.getNodeName().equals("banreportlocation")) {
                locationNode = current;
            }
        }
        if (locationNode == null) {
            throw new DXMLException("Location Child's child not found!");
        }
        try {
            location = new BanReportLocation(locationNode);
        } catch (DXMLException dxmle) {
            throw new DXMLException("Exception while creating location from location node!", dxmle);
        }
    }

    public Element putOnElement(Document d) {
        Element e = d.createElement("banreport");
        e.setAttribute("reporttext", reportText);
        e.setAttribute("reporttime", String.valueOf(reportTime));
        e.setAttribute("reportername", reporterName);
        e.setAttribute("reportnumber", String.valueOf(reportNumber));
        Element child = d.createElement("banreportlocation");
        Element locationElement = location.toElement(d);
        child.appendChild(locationElement);
        e.appendChild(child);
        return null;
    }
}
