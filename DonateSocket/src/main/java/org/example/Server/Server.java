package org.example.Server;


import org.example.Phone.Phone;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class Server {
    
    // Запускаем сначала сервер , потом клиентов вызывая main на классе Client несколько раз(если нельзя , то в edit configurations настройте) . Клиент может написать в консоль сообщение вида "-НомерКлиентаЦифрой Сообщение" (прим. "-1 Привет) , в случае нарушения правил прога крашнется. Сервер никому писать не может.Номера клиентов начинаются с 0, нумеруются в порядке подключения к серверу. Больше 3-х клиентов не подключайте . Удачи.
    
    public static ArrayList<Phone> phones = new ArrayList<>();

    
    public static void main(String[] args) {
        
        try (ServerSocket server = new ServerSocket(8000)) {
            System.out.println("Server is running");
            
            while  (true) {
                Phone phone = new Phone(server);
                phones.add(phone);
                System.out.println(Server.phones.size());
                phone.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}