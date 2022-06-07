package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class NetServerThread {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(7070);
            while (true) {
                Socket socket = server.accept();

                ServerThread thread = new ServerThread(socket);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
