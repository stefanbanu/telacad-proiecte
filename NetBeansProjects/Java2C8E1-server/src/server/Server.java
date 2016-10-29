package server;

import java.net.ServerSocket;
import server.proxy.ProxyClientThread;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(4321);
            while(true) {
                new ProxyClientThread(ss.accept()).start();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}
