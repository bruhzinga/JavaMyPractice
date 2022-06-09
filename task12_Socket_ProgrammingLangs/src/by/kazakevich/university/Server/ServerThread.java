package by.kazakevich.university.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

public class ServerThread extends Thread {

    private PrintStream os;
    private BufferedReader is;
    private InetAddress addr;

    public ServerThread(Socket socket) throws IOException {
        os = new PrintStream(socket.getOutputStream());
        is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        addr = socket.getInetAddress();
    }

    @Override
    public void run() {
        int i = 0;
        String str;
        try {
            while ((str = is.readLine()) != null) {
                if ("/topic".equals(str)) {
                    os.println(Server.getMap().keySet());
                    System.out.println("/topic command from " + addr.getHostName());
                }
                if ("Java".equals(str)) {
                    Server.getMap().forEach((key, value) -> {
                        if (key.equals("Java")) {
                            os.println(value);
                        }
                    });
                }
                if ("OOP".equals(str)) {
                    Server.getMap().forEach((key, value) -> {
                        if (key.equals("OOP")) {
                            os.println(value);
                        }
                    });
                }
                if (".NET".equals(str)) {
                    Server.getMap().forEach((key, value) -> {
                        if (key.equals(".NET")) {
                            os.println(value);
                        }
                    });
                }
                if ("JavaScript".equals(str)) {
                    Server.getMap().forEach((key, value) -> {
                        if (key.equals("JavaScript")) {
                            os.println(value);
                        }
                    });
                }
                if ("C++".equals(str)) {
                    Server.getMap().forEach((key, value) -> {
                        if (key.equals("C++")) {
                            os.println(value);
                        }
                    });
                }
                if ("C#".equals(str)) {
                    Server.getMap().forEach((key, value) -> {
                        if (key.equals("C#")) {
                            os.println(value);
                        }
                    });
                }
                if ("Python".equals(str)) {
                    Server.getMap().forEach((key, value) -> {
                        if (key.equals("Python")) {
                            os.println(value);
                        }
                    });
                }
                if ("Ruby".equals(str)) {
                    Server.getMap().forEach((key, value) -> {
                        if (key.equals("Ruby")) {
                            os.println(value);
                        }
                    });
                }
                if ("PHP".equals(str)) {
                    Server.getMap().forEach((key, value) -> {
                        if (key.equals("PHP")) {
                            os.println(value);
                        }
                    });
                }
            }
        } catch (IOException e) {
            System.err.println("Disconnect");
        } finally {
            disconnect();
        }
    }

    public void disconnect() {
        try {
            if (os != null) {
                os.close();
            }
            if (is != null) {
                is.close();
            }
            System.out.println(addr.getHostName() + " disconnecting");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            this.interrupt();
        }
    }
}
