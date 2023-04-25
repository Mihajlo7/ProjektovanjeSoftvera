/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communcitions;

import java.net.Socket;
import transfer.Receiver;
import transfer.Sender;

/**
 *
 * @author Mihajlo
 */
public class Communication {
    private Socket socket;
    private Sender sender;
    private Receiver receiver;
    
    private static Communication instance;
    
    private Communication(){
        
    }
    public static Communication getInstance(){
        if(instance==null){
            instance=new Communication();
        }
        return instance;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
        sender=new Sender(socket);
        receiver=new Receiver(socket);
    }

    public Sender getSender() {
        return sender;
    }

    public Receiver getReceiver() {
        return receiver;
    }
    
    
}
