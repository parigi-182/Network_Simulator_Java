package app;

import sim.Device;
import sim.EthernetFrame;
import sim.PacketType;
import sim.PointToPointLink;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Network Simulator");

        Device a = new Device("Alice_PC");
        Device b = new Device("Bob_PC");
        a.addNic("eth0");
        b.addNic("eth1");
        PointToPointLink.connect(a.getNic("eth0"), b.getNic("eth1"));
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println();System.out.println();System.out.println();
        
        a.sendFrame("eth0", new EthernetFrame(a.getNic("eth0").getMacAddress(), b.getNic("eth1").getMacAddress(), PacketType.DATA));
        
    }
}
