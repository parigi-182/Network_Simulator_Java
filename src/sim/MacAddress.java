package sim;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MacAddress {
    
    private static final Random r = new Random();
    private static final Set<String> allocated = new HashSet<>();
    private String address;
    
    public MacAddress(){
        this.address = generateRandomMac();
    }

    
    public static synchronized String generateRandomMac() {
        byte[] macBytes = new byte[6];
        StringBuilder sb;
        do { 
            sb = new StringBuilder();
            r.nextBytes(macBytes);
            for (int i = 0; i < macBytes.length; i++) {
                sb.append(String.format("%02X", macBytes[i]));
                if (i < macBytes.length - 1) sb.append(":");
            }
        } while (allocated.contains(sb.toString()));
        allocated.add(sb.toString());
        return sb.toString();
    }
    
    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MacAddress)) return false;
        MacAddress other = (MacAddress) o;
        return this.address.equals(other.address);
    }

    @Override
    public int hashCode() {
        return address.hashCode();
    }
    
}
