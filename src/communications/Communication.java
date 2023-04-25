/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communications;

import java.net.Socket;
import transfer.Receiver;
import transfer.Sender;

/**
 *
 * @author Mihajlo
 */
public class Communication {
    
    private Socket socket;
    private Receiver receiver;
    private Sender sender;
    
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
        this.sender=new Sender(socket);
        this.receiver=new Receiver(socket);
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
        this.receiver=new Receiver(socket);
        this.sender=new Sender(socket);
    }
    
}
