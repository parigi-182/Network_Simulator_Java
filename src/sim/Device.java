
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Device {
    protected final String name;
    protected final Map<String, Nic> nics = new HashMap<>();

    public Device(String name) {
        this.name = name;
    }

    public Nic addNic(String name, String macAddress){
         if (nics.containsKey(name))
            throw new IllegalArgumentException("Interface name already exists: " + name);
        Nic nic = new Nic(name, macAddress);
        nic.setOwner(this); 
        nics.put(name, nic);
        return nic;
    }

    public Nic getNic(String name){
        return nics.get(name);
    }

    public Collection<Nic> getAllNics() {
        return Collections.unmodifiableCollection(nics.values());
    }
}
