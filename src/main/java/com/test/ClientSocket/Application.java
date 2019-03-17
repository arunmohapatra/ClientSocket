package com.test.ClientSocket;

public class Application {

    public static void main(String[] args) throws InterruptedException{
        ClientSocketTask clientSocketTask = new ClientSocketTask(55992);
        Thread clientThread = new Thread(clientSocketTask);
        clientThread.start();
        clientThread.join();
    }
}
