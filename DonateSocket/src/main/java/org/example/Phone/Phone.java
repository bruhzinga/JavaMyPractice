package org.example.Phone;


import org.example.Server.Server;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;



public class Phone  extends Thread implements Closeable {



    

    private final Socket socket;
    private final BufferedReader reader;
    private final BufferedWriter writer;

    public Phone(InetAddress ip, int port) {
        try {
            socket = new Socket(ip, port);
            reader = createReader();
            writer = createWriter();

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Phone(ServerSocket server) {
        try {
            socket = server.accept();
            System.out.println("user connected from " + socket.getInetAddress());
            reader = createReader();
            writer = createWriter();

            
       
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private BufferedWriter createWriter() throws IOException {
        return new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    private BufferedReader createReader() throws IOException {
        return new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void close() throws IOException {
            reader.close();
            writer.close();
            socket.close();
    }

    public String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeLine(String message) {
        try {
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isClosed() {
        return socket.isClosed();
    }


    @Override
    public void run() {
        try {
            while (!socket.isClosed()) {
                String message = reader.readLine();

                 


            }

        } catch (IOException e) {
            System.err.println("Disconnect");
        } finally {
            try {
                System.out.println("user disconnected from " + socket.getInetAddress());
                Server.phones.remove(socket);
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
