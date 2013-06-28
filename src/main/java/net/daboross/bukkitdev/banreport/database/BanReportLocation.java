package net.daboross.bukkitdev.banreport.database;

import net.daboross.dxml.DXMLException;
import org.bukkit.Location;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/**
 *
 * @author daboross
 */
public class BanReportLocation {

    public final double x;
    public final double y;
    public final double z;
    public final double pitch;
    public final double yaw;
    public final String world;

    public BanReportLocation(double x, double y, double z, double pitch, double yaw, String world) {
        if (world == null) {
            throw new IllegalArgumentException("Null argument");
        }
        this.x = x;
        this.y = y;
        this.z = z;
        this.pitch = pitch;
        this.yaw = yaw;
        this.world = world;
    }

    public BanReportLocation(Location location) {
        this.x = location.getX();
        this.y = location.getY();
        this.z = location.getZ();
        this.pitch = location.getPitch();
        this.yaw = location.getYaw();
        this.world = location.getWorld().getName();
    }

    public BanReportLocation(Node node) throws DXMLException {
        if (node == null) {
            throw new IllegalArgumentException("Null Node");
        }
        if (!node.getNodeName().equalsIgnoreCase("banreportlocation") || !node.hasAttributes()) {
            throw new DXMLException("Not BanReportLocation Node!");
        }
        NamedNodeMap attributeMap = node.getAttributes();
        String tempStringX, tempStringY, tempStringZ, tempStringPitch, tempStringYaw;
        Node tempNodeX, tempNodeY, tempNodeZ, tempNodePitch, tempNodeYaw, tempNodeWorld;
        tempNodeX = attributeMap.getNamedItem("x");
        tempNodeY = attributeMap.getNamedItem("y");
        tempNodeZ = attributeMap.getNamedItem("z");
        tempNodePitch = attributeMap.getNamedItem("pitch");
        tempNodeYaw = attributeMap.getNamedItem("yaw");
        tempNodeWorld = attributeMap.getNamedItem("world");
        if (tempNodeX == null || tempNodeY == null || tempNodeZ == null || tempNodePitch == null || tempNodeYaw == null || tempNodeWorld == null) {
            throw new DXMLException("Not all values found");
        }
        tempStringX = tempNodeX.getNodeValue();
        tempStringY = tempNodeY.getNodeValue();
        tempStringZ = tempNodeZ.getNodeValue();
        tempStringYaw = tempNodeYaw.getNodeValue();
        tempStringPitch = tempNodePitch.getNodeValue();
        world = tempNodeWorld.getNodeValue();
        if (tempStringX == null || tempStringY == null || tempStringZ == null || tempStringYaw == null || tempStringPitch == null || world == null) {
            throw new DXMLException("Not all values have values");
        }
        try {
            x = Double.parseDouble(tempStringX);
            y = Double.parseDouble(tempStringY);
            z = Double.parseDouble(tempStringZ);
            pitch = Double.parseDouble(tempStringPitch);
            yaw = Double.parseDouble(tempStringYaw);
        } catch (NumberFormatException nfe) {
            throw new DXMLException("Not all number values are Numbers!", nfe);
        }
    }

    public Element toElement(Document d) {
        Element element = d.createElement("banreportlocation");
        element.setAttribute("x", String.valueOf(x));
        element.setAttribute("y", String.valueOf(y));
        element.setAttribute("z", String.valueOf(z));
        element.setAttribute("pitch", String.valueOf(pitch));
        element.setAttribute("yaw", String.valueOf(yaw));
        element.setAttribute("world", world);
        return element;
    }
}
