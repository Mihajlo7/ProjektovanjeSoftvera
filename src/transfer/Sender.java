/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transfer;

import exception.ServerskiException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mihajlo
 */
public class Sender {
    
    private final Socket socket;
    private ObjectOutputStream out=null;
    public Sender(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }
    
    public void sendObject(Object data)throws IOException{
        try {
            out=new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(data);
            out.flush();
        } catch (IOException ex) {
            throw new IOException("SLANJE PODATAKA: Greska prilikom slanja podataka!");
        }
    }
    public void closeSender() throws IOException{
        out.close();
    }
}
