package app;
import sim.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Network Simulator");
        /*
         * PTP TEST
         Device a = new Device("Alice_PC");
         Device b = new Device("Bob_PC");
         a.addNic("eth0");
         b.addNic("eth1");
         PointToPointLink.connect(a.getNic("eth0"), b.getNic("eth1"));
         System.out.println(a.toString());
         System.out.println(b.toString());
         System.out.println();System.out.println();System.out.println();
         
         a.sendFrame("eth0", new EthernetFrame(a.getNic("eth0").getMacAddress(), b.getNic("eth1").getMacAddress(), PacketType.DATA));
         
         */

         /* 
          * Switch test
         */
        Device a = new Device("Alice_PC");
        Device b = new Device("Bob_PC");
        Switch switch01 = new Switch("Switch_01");
        a.addNic("eth0");
        b.addNic("eth1");
        switch01.addNic("swt00");
        switch01.addNic("swt01");
        PointToPointLink.connect(a.getNic("eth0"), switch01.getNic("swt00"));
        PointToPointLink.connect(b.getNic("eth1"), switch01.getNic("swt01"));
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(switch01.toString());
        System.out.println();System.out.println();System.out.println();
        
        a.sendFrame("eth0", new EthernetFrame(a.getNic("eth0").getMacAddress(), b.getNic("eth1").getMacAddress(), PacketType.DATA));
    }
}
