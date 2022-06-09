package by.kazakevich.university.Client;

import by.kazakevich.university.Server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader br = null;
        try {
            socket = new Socket(InetAddress.getLocalHost(), 8071);
            PrintStream ps = new PrintStream(socket.getOutputStream());
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println(br.readLine());
            System.out.println(br.readLine());
            while (true) {
                System.out.println("Write command...");
                BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
                String input = br2.readLine();
                switch (input) {
                    case("/topic"): {
                        ps.println("/topic");
                        System.out.println(br.readLine());
                        break;
                    }
                    case("Java"): {
                        ps.println("Java");
                        System.out.println(br.readLine());
                        break;
                    }
                    case("OOP"): {
                        ps.println("OOP");
                        System.out.println(br.readLine());
                        break;
                    }
                    case(".NET"): {
                        ps.println(".NET");
                        System.out.println(br.readLine());
                        break;
                    }
                    case ("JavaScript"): {
                        ps.println("JavaScript");
                        System.out.println(br.readLine());
                        break;
                    }
                    case ("C++"): {
                        ps.println("C++");
                        System.out.println(br.readLine());
                        break;
                    }
                    case ("C#"): {
                        ps.println("C#");
                        System.out.println(br.readLine());
                        break;
                    }
                    case ("Python"): {
                        ps.println("Python");
                        System.out.println(br.readLine());
                        break;
                    }
                    case ("Ruby"): {
                        ps.println("Ruby");
                        System.out.println(br.readLine());
                        break;
                    }
                    case ("PHP"): {
                        ps.println("PHP");
                        System.out.println(br.readLine());
                        break;
                    }
                    default: System.out.println("Unknown command");
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("адрес недоступен" + e);
        } catch (IOException e) {
            System.err.println("ошибка I/О потока" + e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket!= null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
