package com.cb.leo.common;

import java.io.*;
import java.net.Socket;

/**
 * Created by god0725 on 2015/5/13.
 */
public class MessageUtils {
    public static void sendMessage(Socket socket, String message) throws IOException{
        OutputStream stream = socket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(stream);
        oos.writeUTF(message);
        oos.flush();
    }

    public static String getMessage(Socket socket) throws  IOException{
        InputStream stream = socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(stream);
        return ois.readUTF();
    }
}
