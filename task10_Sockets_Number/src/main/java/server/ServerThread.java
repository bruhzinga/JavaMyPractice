package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerThread extends Thread {
    private BufferedReader in;
    private PrintStream out;

    private int count;
    private static int countStatic;

    public ServerThread(Socket socket) throws IOException {
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintStream(socket.getOutputStream());

        count = ++countStatic;
    }

    public void run() {
        try {
            String str;
            while ((str = in.readLine()) != null) {
                    out.println(count);
                System.out.println(str);
            }
        } catch (Exception e) {

        } finally {
            disconnect();
        }
    }

    public void disconnect() {
        try {
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
