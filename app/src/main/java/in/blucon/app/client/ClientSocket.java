package in.blucon.app.client;

import java.net.Socket;


public class ClientSocket {
    private static Socket clientSocket_;

    public static void setClientSocket_(Socket clientSocket_) {
        ClientSocket.clientSocket_ = clientSocket_;
    }

    public static Socket getClientSocket_() {
        return clientSocket_;
    }
}
