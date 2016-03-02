package com.cb.leo;

import com.cb.leo.common.MessageUtils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by god0725 on 2015/5/13.
 */
public class Server implements Runnable{
    ServerSocket serverSocket;
    volatile boolean keeepProcessing = true;

    public Server(int port, int millisecondsTimeout) throws IOException{
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(millisecondsTimeout);
    }

    @Override
    public void run() {
        System.out.println("Server Starting");

        while (keeepProcessing){
            try {
                System.out.println("accepting client");
                Socket socket = serverSocket.accept();
                System.out.println("got client");
                process(socket);
            } catch (Exception e) {
                handle(e);
            }
        }

    }

    private void handle(Exception e) {
        if(!(e instanceof SocketException)){
            e.printStackTrace();
        }
    }

    public void stopProcessing(){
        keeepProcessing = false;
        closeIgnoringException(serverSocket);
    }

    private void process(Socket socket) {
        if(socket == null){
            return;
        }

        try {
            System.out.println("Server: getting message");
            String message = MessageUtils.getMessage(socket);
            System.out.printf("Server: got message: %s\n", message);
            Thread.sleep(1000);
            System.out.printf("Server: sending reply: %s\n", message);
            MessageUtils.sendMessage(socket, "Processed: " + message);
            System.out.println("Server: sent");
            closeIgnoringException(socket);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void closeIgnoringException(Socket socket) {
        if(socket != null){
            try{
                socket.close();
            } catch (IOException ignore) {
                //do...
            }
        }
    }

    private void closeIgnoringException(ServerSocket serverSocket) {
        if(serverSocket != null){
            try{
                serverSocket.close();
            } catch (IOException ignore) {
                //do...
            }
        }
    }


}
