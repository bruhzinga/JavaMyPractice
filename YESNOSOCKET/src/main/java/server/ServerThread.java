package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerThread extends Thread {
    private BufferedReader in;
    private PrintStream out;

   private  static  int Yes;
   private  static  int No;

    public ServerThread(Socket socket) throws IOException {
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintStream(socket.getOutputStream());
    }

    public void run() {
        String str;
        try {
            while ((str = in.readLine()) != null) {
                    switch (str) {
                        case "/No":
                            No++;
                            break;
                        case "/Yes":
                            Yes++;
                            break;
                        case "/getall":
                            out.println("Yes: " + Yes + " No: " + No);
                            break;
                        case "help":
                            out.println("/Yes - add Yes");
                            out.println("/No - add No");
                            out.println("/getall - get all");
                            break;
                        default:
                            out.println("No such command");
                            break;
                    }
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
