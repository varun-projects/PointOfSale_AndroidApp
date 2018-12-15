package in.blucon.app.object;


public class ServiceCard {

    private String ipAddress_;
    private int port_;

    public ServiceCard(String ipAddress, int port) {
        ipAddress_ = ipAddress;
        port_ = port;
    }

    public String getIpAddress() {
        return ipAddress_;
    }

    public int getPort() {
        return port_;
    }
}
