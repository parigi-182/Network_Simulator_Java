package sim;
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
    
    public Nic addNic(String name){
        if (nics.containsKey(name))
            throw new IllegalArgumentException("Interface name already exists: " + name);
        Nic nic = new Nic(name);
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
    /* Getters and setters */
    public String getName() {
        return name;
    }

    public Map<String, Nic> getNics() {
        return nics;
    }
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder(this.name);
        nics.forEach((k, v) -> {
            out.append("\n\t").append(v.toString());
            });
        return out.toString();
    }
}
