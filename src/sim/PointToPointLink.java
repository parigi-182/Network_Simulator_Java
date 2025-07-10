package sim;
public class PointToPointLink {
    private final Nic nic0;
    private final Nic nic1;
    
    private PointToPointLink(Nic nic0, Nic nic1) {
        this.nic0 = nic0;
        this.nic1 = nic1;
    }
    
    public static PointToPointLink connect(Nic nic0, Nic nic1){
        PointToPointLink link = new PointToPointLink(nic0, nic1);
        nic0.setLink(link);
        nic1.setLink(link);
        return link;
    }
    
    public Nic getOther(Nic nic){
        return nic == nic0 ? nic1 : nic == nic1 ? nic0 : null;
    }

    public Nic getNic0() {
        return nic0;
    }
    
    public Nic getNic1() {
        return nic1;
    }

    public void transmit(EthernetFrame ethFrame, Nic sender) {
        /* TODO: broadcasts */

        if(nic0.equals(sender)){nic1.receive(ethFrame);}
        if(nic1.equals(sender)){nic0.receive(ethFrame);}
    }

}
