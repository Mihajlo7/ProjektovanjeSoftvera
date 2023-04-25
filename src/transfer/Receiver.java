/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transfer;

import exception.ServerskiException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mihajlo
 */
public class Receiver {
    private final Socket socket;
    private ObjectInputStream in;
    public Receiver(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }
    
    public Object receiveObject() throws IOException{
        try {
            in=new ObjectInputStream(socket.getInputStream());
            return in.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            throw new IOException("Doslo je do greske prilikom prijema objekta");
        }
    }
    public void closeReceiver() throws IOException{
        in.close();
    }
}
