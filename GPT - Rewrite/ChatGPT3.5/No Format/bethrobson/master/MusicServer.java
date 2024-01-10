package AppendixA;

import java.io.*;
import java.net.*;
import java.util.*;

public class MusicServer {
    private ArrayList<ObjectOutputStream> clientOutputStreams;

    public static void main(String[] args) {
        new MusicServer().startServer();
    }

    public class ClientHandler implements Runnable {
        private ObjectInputStream inputStream;
        private Socket clientSocket;

        public ClientHandler(Socket clientSocket) {
            try {
                this.clientSocket = clientSocket;
                inputStream = new ObjectInputStream(clientSocket.getInputStream());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        public void run() {
            try {
                while (true) {
                    Object object1 = inputStream.readObject();
                    Object object2 = inputStream.readObject();
                    System.out.println("Read two objects");
                    broadcast(object1, object2);
                }
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void startServer() {
        clientOutputStreams = new ArrayList<>();
        try (ServerSocket serverSocket = new ServerSocket(4242)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
                clientOutputStreams.add(outputStream);

                Thread handlerThread = new Thread(new ClientHandler(clientSocket));
                handlerThread.start();
                System.out.println("Got a connection");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void broadcast(Object one, Object two) {
        Iterator<ObjectOutputStream> iterator = clientOutputStreams.iterator();
        while (iterator.hasNext()) {
            try {
                ObjectOutputStream outputStream = iterator.next();
                outputStream.writeObject(one);
                outputStream.writeObject(two);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
