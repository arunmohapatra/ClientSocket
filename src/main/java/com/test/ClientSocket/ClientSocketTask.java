package com.test.ClientSocket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.SocketHandler;

public class ClientSocketTask implements Runnable {

    int serverSocketToConnect;

    public ClientSocketTask(int serverSocketToConnect){
        this.serverSocketToConnect = serverSocketToConnect;
    }

    public void run(){
        Socket socket = null;
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            socket = new Socket("localhost",this.serverSocketToConnect);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());

            while(true){
                String message = "Hello";
                objectOutputStream.writeObject(message);

                String fromServer = (String)objectInputStream.readObject();
                processServerMessage(fromServer);
            }
        }
        catch (IOException | ClassNotFoundException exp){
            System.out.println("Unable to connect");
        }
    }

    private void processServerMessage(String message){
        System.out.println("Message from Server : "+message);
    }

}
