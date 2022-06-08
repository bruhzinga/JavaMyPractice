package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class NetClient {
    private static BufferedReader in;
    private static PrintStream out;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 7070);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintStream(socket.getOutputStream());

            getMessages();

            String str;
            Scanner scanner = new Scanner(System.in);
            while((str = scanner.nextLine()) != null) {
                out.println(str);
            }
        } catch (Exception e) {

        } finally {
            disconnect();
        }
    }

    public static void getMessages() {
        new Thread() {
            public void run() {
                while (true) {
                    try {
                        System.out.println(in.readLine());
                    } catch (IOException e) {

                    }
                }
            }
        }.start();
    }

    public static void disconnect() {
        try {
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
