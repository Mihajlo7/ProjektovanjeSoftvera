/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import controller.Controller;
import domain.Bibliotekar;
import domain.Clan;
import domain.Dobavljac;
import domain.Grad;
import domain.Izdavac;
import domain.Knjiga;
import domain.Narudzbenica;
import domain.Rezervacija;
import exception.ServerskiException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.Receiver;
import transfer.Request;
import transfer.Response;
import transfer.Sender;

/**
 *
 * @author Mihajlo
 */
public class ObradaKlijentskihZahtevaNit extends Thread {
    private Socket socket;
    private PokretanjeServeraNit glavna;
    private Sender sender;
    private Receiver receiver;
    private Bibliotekar bibliotekar;
    private Clan posetilac;

    public ObradaKlijentskihZahtevaNit(Socket socket, PokretanjeServeraNit glavna) {
        this.socket = socket;
        this.glavna = glavna;
        
    }
    public void setBibliotekar(Bibliotekar bibliotekar){
       this.bibliotekar=bibliotekar; 
    }
    public Bibliotekar getBibliotekar(){
        return this.bibliotekar;
    }

    public Clan getPosetilac() {
        return posetilac;
    }

    public void setPosetilac(Clan posetilac) {
        this.posetilac = posetilac;
    }

    @Override
    public void run() {
        try{
        sender=new Sender(socket);
        receiver=new Receiver(socket);
        while(true){
            System.out.println("Cekam zahtev");
            Response response=null;
            Request request=(Request)receiver.receiveObject();
            System.out.println("Primljen zahtev");
            try{
            switch(request.getOperation()){
                case PRIJAVI_BIBLIOTEKARA:
                    System.out.println("PRIJAVA BIBLIOTEKARA");
                    Bibliotekar parametar=(Bibliotekar)request.getData();
                    Bibliotekar bibliotekar=Controller.getInstance().prijaviBibliotekara(parametar);
                    //System.out.println("Ime: "+bibliotekar.getIme()+"Prezime: "+bibliotekar.getPrezime());
                    //setBibliotekar(bibliotekar);
                    boolean ulogovan=glavna.proveriUlogovane(bibliotekar,this);
                    if(!ulogovan){
                        setBibliotekar(bibliotekar);
                    }
                    response=new Response(bibliotekar, null, !ulogovan);
                    break;
                case PRIJAVA_CLANA:
                    System.out.println("PRIJAVA CLANA");
                    Clan korisnik=(Clan) request.getData();
                    korisnik=Controller.getInstance().prijaviClana(korisnik);
                    ulogovan=glavna.proveriUlogovanePosetioce(korisnik,this);
                    if(!ulogovan){
                        setPosetilac(korisnik);
                    }
                    response=new Response(korisnik,null,!ulogovan);
                    break;
                case UCITAJ_GRADOVE:
                    System.out.println("UCITAJ LISTU GRADOVA");
                    List<Grad> gradovi=Controller.getInstance().ucitajGradove();
                    response=new Response(gradovi, null, true);
                    break;
                case UCITAJ_VRSTE_CLANSKIH_KARATA:
                    System.out.println("UCITAJ LISTU VRSTA CLANSKIH KARATA");
                    List<String> vck=Controller.getInstance().ucitajVrsteClanskihKarata();
                    response=new Response(vck, null, true);
                    break;
                case KREIRAJ_CLANA:
                    System.out.println("KREIRAJ CLANA");
                    Clan p=(Clan) request.getData();
                    Clan clan=Controller.getInstance().kreirajClana(p);
                    response=new Response(clan, null, true);
                    break;
                case ZAPAMTI_CLANA:
                    System.out.println("ZAPAMTI CLANA");
                    clan=(Clan)request.getData();
                    boolean uspesno=Controller.getInstance().zapamtiClana(clan);
                    response=new Response(uspesno, null, true);
                    break;
                case UCITAJ_CLANA:
                    System.out.println("UCITAJ CLANA");
                    clan=(Clan)request.getData();
                    clan=Controller.getInstance().ucitajClana(clan);
                    response=new Response(clan,null,true);
                    break;
                case UCITAJ_SVE_CLANOVE:
                    System.out.println("UCITAJ SVE CLANOVE");
                    List<Clan> clanovi=Controller.getInstance().ucitajSveClanove();
                    response=new Response(clanovi, null, true);
                    break;
                case NADJI_CLANOVE:
                    System.out.println("NADJI CLANOVE PO KRITERIJUMU");
                    HashMap<String,String> kriterijum=(HashMap<String,String>) request.getData();
                    List<Clan> nadjeniClanovi=Controller.getInstance().nadjiClanove(kriterijum);
                    response=new Response(nadjeniClanovi,null, true);
                    break;
                case AKTIVIRAJ_CLANSTVO:
                    System.out.println("AKTIVIRAJ CLANSTVO");
                    clan=(Clan)request.getData();
                    boolean uspesan=Controller.getInstance().aktivirajClanstvo(clan);
                    response=new Response(uspesan, null, true);
                    break;
                case DEAKTIVIRAJ_CLANSTVO:
                    System.out.println("DEAKTIVIRAJ CLANSTVO");
                    clan=(Clan)request.getData();
                     uspesan=Controller.getInstance().deaktivirajClanstvo(clan);
                     response=new Response(uspesan, null, true);
                     break;
                case OBRISI_CLANA:
                    System.out.println("OBRISI CLANA");
                    clan=(Clan)request.getData();
                    uspesan=Controller.getInstance().obrisiClana(clan);
                    response=new Response(uspesan, null, true);
                    break;
                case UCITAJ_ZANROVE:
                    System.out.println("UCITAJ ZANROVE");
                    List<String> zanrovi=Controller.getInstance().ucitajZanrove();
                    response=new Response(zanrovi, null, true);
                    break;
                case UCITAJ_IZDAVACE:
                    System.out.println("UCITAJ IZDAVACE");
                    List<Izdavac> izdavaci=Controller.getInstance().ucitajIzdavaci();
                    response=new Response(izdavaci, null, true);
                    break;
                case KREIRAJ_KNJIGU:
                    System.out.println("KREIRAJ KNJIGU");
                    Knjiga knjiga=(Knjiga) request.getData();
                    knjiga=Controller.getInstance().kreirajKnjigu(knjiga);
                    response=new Response(knjiga, null, true);
                    break;
                case ZAPAMTI_KNJIGU:
                    System.out.println("ZAPAMTI KNJIGU");
                    knjiga=(Knjiga) request.getData();
                    uspesno=Controller.getInstance().zapamtiKnjigu(knjiga);
                    response=new Response(uspesno,null,true);
                    break;
                case OBRISI_KNJIGU:
                    System.out.println("OBRISI KNJIGU");
                    knjiga=(Knjiga) request.getData();
                    uspesno=Controller.getInstance().obrisiKnjigu(knjiga);
                    response=new Response(uspesno,null, true);
                    break;
                case UCITAJ_KNJIGE:
                    System.out.println("UCITAJ KNJIGE");
                    List<Knjiga> knjige=Controller.getInstance().ucitajKnjige();
                    response=new Response(knjige,null, true);
                    break;
                case UCITAJ_KNJIGU:
                    System.out.println("UCITAJ KNJIGU");
                    knjiga=(Knjiga) request.getData();
                    knjiga=Controller.getInstance().ucitajKnjigu(knjiga);
                    response=new Response(knjiga,null,true);
                    break;
                case UCITAJ_PRIMERKE:
                    System.out.println("UCITAJ PRIMERKE");
                    List<Knjiga> primerci=Controller.getInstance().ucitajPrimerke();
                    response=new Response(primerci, null, true);
                    break;
                case NADJI_PRIMERKE:
                    System.out.println("NADJI PRIMERKE");
                    HashMap<String,String> kriterijumPri=(HashMap<String,String>) request.getData();
                    primerci=Controller.getInstance().nadjiPrimerke(kriterijumPri);
                    response=new Response(primerci,null,true);
                    break;
                case NADJI_SLOBODNE_PRIMERKE:
                    System.out.println("NADJI SLOBODNE PRIMERKE");
                    HashMap<String,String> kriterijumSlobPri=(HashMap<String,String>) request.getData();
                    primerci=Controller.getInstance().nadjiSlobodnePrimerke(kriterijumSlobPri);
                    response=new Response(primerci,null,true);
                    break;
                case KREIRAJ_REZERVACIJU:
                    System.out.println("KREIRAJ REZERVACIJU");
                    Rezervacija rezervacija=(Rezervacija) request.getData();
                    rezervacija=Controller.getInstance().kreirajRezervaciju(rezervacija);
                    response=new Response(rezervacija, null, true);
                    break;
                case ZAPAMTI_REZERVACIJU:
                    System.out.println("ZAPAMTI REZERVACIJU");
                    rezervacija=(Rezervacija) request.getData();
                    uspesno=Controller.getInstance().zapamtiRezervaciju(rezervacija);
                    response=new Response(uspesno,null,true);
                    break;
                case OBRISI_REZERVACIJU:
                    System.out.println("OBRISI REZERVACIJU");
                    rezervacija=(Rezervacija) request.getData();
                    uspesno=Controller.getInstance().obrisiRezervaciju(rezervacija);
                    response=new Response(uspesno,null,true);
                    break;
                case UCITAJ_REZERVACIJE_PO_CLANU:
                    System.out.println("UCITAJ REZERVACIJE PO CLANU");
                    rezervacija=(Rezervacija) request.getData();
                    List<Rezervacija> rezervacije=Controller.getInstance().vratiRezervacijePoClanu(rezervacija);
                    response=new Response(rezervacije,null,true);
                    break;
                case POTVRDI_REZERVACIJU:
                    System.out.println("POTVRDI REZERVACIJU");
                    rezervacija=(Rezervacija) request.getData();
                    uspesno=Controller.getInstance().potvrdiRezervaciju(rezervacija);
                    response=new Response(uspesno,null,true);
                    break;
                case UCITAJ_DOBAVLJACE:
                    System.out.println("UCITAJ DOBAVLJACE");
                    List<Dobavljac> dobavljaci=Controller.getInstance().ucitajDobavljace();
                    response=new Response(dobavljaci,null,true);
                    break;
                case KREIRAJ_NARUDZBENICU:
                    System.out.println("KREIRAJ NARUDZBENICU");
                    Narudzbenica narudzbenica=(Narudzbenica) request.getData();
                    narudzbenica=Controller.getInstance().kreirajNarudzbenicu(narudzbenica);
                    response=new Response(narudzbenica,null,true);
                    break;
                case ZAPAMTI_NARUZBENICU:
                    System.out.println("ZAPAMTI NARUDZBENICU");
                    narudzbenica=(Narudzbenica) request.getData();
                    uspesno=Controller.getInstance().zapamtiNarudzbenicu(narudzbenica);
                    response=new Response(uspesno, null, true);
                    break;
                case OBRISI_NARUDZBENICU:
                    System.out.println("OBRISI NARUDZBENICU");
                    narudzbenica=(Narudzbenica) request.getData();
                    uspesno=Controller.getInstance().obrisiNarudzbenicu(narudzbenica);
                    response=new Response(uspesno,null,true);
                    break;
                case IZLOGUJ_SE:
                    //bibliotekar=(Bibliotekar) request.getData();
                    uspesno=izlogujSe();
                    response=new Response(uspesno,null,true);
                    break;
                case PROVERA_EMAIL:
                    System.out.println("PROVERI EMAIL");
                    String email=(String) request.getData();
                    uspesno=Controller.getInstance().proveriEmail(email);
                    response=new Response(uspesno,null,true);
                    break;
                case TERMINATE:
                    System.out.println("GASENJE KLIJENTA");
                    glavna.raskiniKonekciju(this);
                    System.out.println("USPESNO UGASEN PROGRAM");
                    break;
            }
            }catch(ServerskiException ex){
                System.err.println("OPERACIJA: DOSLO JE DO NEKE GRESKE");
                response=new Response(null, ex, false);
            }
            sender.sendObject(response);
        }
        }catch(SocketException ex){
            try {
                sender.closeSender();
                receiver.closeReceiver();
                glavna.getKlijenti().remove(this);
                System.err.println("SOCKET: Nasilno prekidanja programa!");
            } catch (IOException ex1) {
                Logger.getLogger(ObradaKlijentskihZahtevaNit.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public PokretanjeServeraNit getGlavna() {
        return glavna;
    }

    public void setGlavna(PokretanjeServeraNit glavna) {
        this.glavna = glavna;
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }
    public void raskiniKonekciju() throws IOException{
        this.getSocket().close();
    }

    private boolean izlogujSe() {
        if(bibliotekar!=null){
            setBibliotekar(null);
            return true;
        }
        if(posetilac!=null){
            setPosetilac(null);
            return true;
        }
        return false;
    }
    
}
