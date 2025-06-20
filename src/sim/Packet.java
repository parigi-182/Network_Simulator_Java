package sim;
public class Packet {
    String macSource;
    String macDestination;

    String ipSource;
    String ipDestination;

    String payload;
    PacketType type;

    
    public Packet(String macSource, String macDestination, String ipSource, String ipDestination, String payload, PacketType type) {
        this.macSource = macSource;
        this.macDestination = macDestination;
        this.ipSource = ipSource;
        this.ipDestination = ipDestination;
        this.payload = payload;
        this.type = type;
    }
    
    /* Getters and Setters */
    public String getMacSource() {
        return macSource;
    }

    public void setMacSource(String macSource) {
        this.macSource = macSource;
    }

    public String getMacDestination() {
        return macDestination;
    }

    public void setMacDestination(String macDestination) {
        this.macDestination = macDestination;
    }

    public String getIpSource() {
        return ipSource;
    }

    public void setIpSource(String ipSource) {
        this.ipSource = ipSource;
    }

    public String getIpDestination() {
        return ipDestination;
    }

    public void setIpDestination(String ipDestination) {
        this.ipDestination = ipDestination;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public PacketType getType() {
        return type;
    }

    public void setType(PacketType type) {
        this.type = type;
    }
    

}
