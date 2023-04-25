/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import domain.Bibliotekar;
import domain.Clan;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mihajlo
 */
public class PokretanjeServeraNit extends Thread {
    private ServerSocket serverSocket;
    private List<ObradaKlijentskihZahtevaNit> klijenti;
    
    public PokretanjeServeraNit(){
        try {
            serverSocket=new ServerSocket(9000);
            klijenti=new LinkedList<>();
        } catch (IOException ex) {
            Logger.getLogger(PokretanjeServeraNit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run(){ 
       System.out.println("Server ceka...");
       try { 
       while(true){
           Socket socket=serverSocket.accept();
           ObradaKlijentskihZahtevaNit klijent=new ObradaKlijentskihZahtevaNit(socket, this);
           klijenti.add(klijent);
           klijent.start();
           System.out.println("Klijent se povezao!");
       }        
           } catch (SocketException ex) {
               System.err.println("Doslo je do prekidanja socketa");
           }catch (IOException ex){
               System.err.println("Neuspesno povezivanje klijenta na server!!");
           } 
    }
    
    public void zaustaviNiti(){
        try {
            serverSocket.close();
            for(ObradaKlijentskihZahtevaNit o:klijenti){
                o.getSocket().close();
            }
            
        } catch (IOException ex) {
            System.err.println("Zaustavio se rad servera!");
        }
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public List<ObradaKlijentskihZahtevaNit> getKlijenti() {
        return klijenti;
    }

    public void setKlijenti(List<ObradaKlijentskihZahtevaNit> klijenti) {
        this.klijenti = klijenti;
    }

    boolean proveriUlogovane(Bibliotekar bibliotekar,ObradaKlijentskihZahtevaNit parametar) {
        for(ObradaKlijentskihZahtevaNit klijent:klijenti){
            if(klijent!=parametar){
                if(klijent.getBibliotekar()!=null){
                if(klijent.getBibliotekar().equals(bibliotekar)){
                    return true;
                }
            }
            }
        }
        return false;
    }

    void raskiniKonekciju(ObradaKlijentskihZahtevaNit parametar) throws IOException {
        for(ObradaKlijentskihZahtevaNit klijent:klijenti){
            if(parametar==klijent){
                //parametar.raskiniKonekciju();
                klijent.raskiniKonekciju();
                //klijent=null;
                //klijent.setBibliotekar(null);
                //return true;
            }
        }
        //return false;
    }

    boolean proveriUlogovanePosetioce(Clan korisnik, ObradaKlijentskihZahtevaNit parametar) {
        for(ObradaKlijentskihZahtevaNit klijent:klijenti){
            if(klijent!=parametar){
                if(klijent.getPosetilac()!=null){
                    if(klijent.getPosetilac().getSifra()==korisnik.getSifra()){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    
    
}
