package org.example.Client;


import org.example.Phone.Phone;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    


    
    public static void main(String[] args) {
        try (Phone phone = new Phone(InetAddress.getLocalHost(), 8000)) {
            try {
                new Thread(() -> {
                    Scanner sc = new Scanner(System.in);
                    while (!phone.isClosed()) {
                        String message = sc.nextLine();
                        phone.writeLine(message);
                    }
                }).start();

                new Thread(() -> {
                    while (!phone.isClosed()) {
                            String message = phone.readLine();
                            System.out.println(message);
                    }
                    System.out.println("Connection closed");
                }).start();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            
          while (true) {
          }
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
