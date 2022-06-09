package by.kazakevich.university.Server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Server {

    private static LinkedList<ServerThread> serverList = new LinkedList();
    private static Map<String, String> map = new HashMap<>();

    public static Map<String, String> getMap() {
        return map;
    }

    public static void main(String[] args) {
        try {
            map.put("Java", "is the #1 programming language and development platform");
            map.put("OOP", "is a programming paradigm fundamental to many programming languages, including Java and C++");
            map.put(".NET", "is a developer platform with tools and libraries for building any type of app, including web, mobile, desktop, games");
            map.put("JavaScript", "simple, but detailed explanations with examples and tasks, including: closures, document and events, object oriented programming and more");
            map.put("C++", "is a general-purpose programming language, with classes and objects, and is designed to have a low learning curve");
            map.put("C#", "is a general-purpose, object-oriented programming language");
            map.put("Python", "is an interpreted, high-level, general-purpose programming language");
            map.put("Ruby", "is an interpreted, general-purpose, object-oriented programming language");
            map.put("PHP", "is a general-purpose scripting language");

            ServerSocket server = new ServerSocket(8071);
            System.out.println("initialized");
            while (true) {
                Socket socket = server.accept();
                PrintStream os = new PrintStream(socket.getOutputStream());
                os.println("Wait please...");
                System.out.println(socket.getInetAddress().getHostName() + " connected");
                os.println("Go!");
                ServerThread thread = new ServerThread(socket);
                serverList.add(thread);
                thread.start();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
