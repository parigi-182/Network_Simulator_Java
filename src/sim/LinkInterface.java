package sim;
public interface LinkInterface {

    void transmit(Packet packet, Nic sender);
    void receive(Packet packet, Nic sender);
}
