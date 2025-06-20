package app;

import sim.Device;
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
        
    }
}
