package sim;

public class EthernetFrame {
    private MacAddress source;
    private MacAddress destination;
    private PacketType type;

    public EthernetFrame(MacAddress source, MacAddress destination, PacketType type) {
        this.source = source;
        this.destination = destination;
        this.type = type;
    }

    
    public MacAddress getSource() {
        return source;
    }

    public void setSource(MacAddress source) {
        this.source = source;
    }

    public MacAddress getDestination() {
        return destination;
    }

    public void setDestination(MacAddress destination) {
        this.destination = destination;
    }
    
    public String getType() {
        return type.toString();
    }
}
