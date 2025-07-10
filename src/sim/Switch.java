package sim;

import java.util.HashMap;
import java.util.Map;

public class Switch extends Device {

    private Map<MacAddress, Nic> switchTable = new HashMap<>();

    public Switch(String name) {
        super(name);
    }
    
    @Override
    public void handleFrame(EthernetFrame ethFrame, Nic receiving_nic) {

        MacAddress srcMac = ethFrame.getSource();
        MacAddress destMac = ethFrame.getDestination();

        switchTable.put(srcMac, receiving_nic);
        
        Nic desNic = switchTable.get(destMac);
        
        if(desNic != null){
            desNic.send(ethFrame);
        }else{
            for (Nic nic : nics.values()) {
                if(!nic.equals(receiving_nic)){
                    nic.send(ethFrame);
                }
            }
        }

    }
}
