import java.util.Random;

public class Nic{
    private String interfaceName;
    private String macAddress;
    private String ipAddress;

    private PointToPointLink link;
    private Device owner;
    
    public Nic(String interfaceName, String macAddres){
        this.interfaceName = interfaceName;
        this.macAddress = generateRandomMac();
    }
 

    
    public static String generateRandomMac() {
        Random r = new Random();
        byte[] mac = new byte[6];
        r.nextBytes(mac);
        mac[0] = (byte)(mac[0] & (byte)0xFE); // unicast, locally administered
        return String.format("%02X:%02X:%02X:%02X:%02X:%02X", mac[0], mac[1], mac[2], mac[3], mac[4], mac[5]);
    }


 
    /* Getters and Setters */
    public String getInterfaceName() {
        return interfaceName;
    }
    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }
    public String getMacAddress() {
        return macAddress;
    }
    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }
    public String getIpAddress() {
        return ipAddress;
    }
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    public PointToPointLink getLink() {
        return link;
    }
    public void setLink(PointToPointLink link) {
        this.link = link;
    }
    public Device getOwner() {
        return owner;
    }
    public void setOwner(Device owner) {
        this.owner = owner;
    }

    

}