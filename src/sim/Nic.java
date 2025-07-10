package sim;

public class Nic{
    private String interfaceName;
    private MacAddress macAddress;

    private PointToPointLink link;
    private Device owner;
    
    public Nic(String interfaceName){
        this.interfaceName = interfaceName;
        this.macAddress = new MacAddress();
    }

    /* Getters and Setters */
    public String getInterfaceName() {
        return interfaceName;
    }
    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }
    public MacAddress getMacAddress() {
        return macAddress;
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

    public void receive(EthernetFrame ethFrame){
        owner.handleFrame(ethFrame, this);
    }

    public void send(EthernetFrame ethFrame){
        link.transmit(ethFrame, this);
    }

    @Override
    public String toString() {
        /* TODO: include super string later */
        String out = "NIC name: " + this.interfaceName + " MAC: " + this.macAddress;
        if(link==null){
            out += " - disconnected\n";
        }else{
            if(link.getNic0().equals(this)){
                out += " - connected to " + link.getNic1().getMacAddress() + " on " + link.getNic1().getInterfaceName() + " at " + link.getNic1().getOwner().getName();
            }else{
                out += " - connected to " + link.getNic0().getMacAddress() + " on " + link.getNic0().getInterfaceName() + " at " + link.getNic0().getOwner().getName();
            }
        }
        return out;
    }

}