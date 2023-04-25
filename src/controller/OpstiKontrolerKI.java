/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import communcitions.Communication;
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
import java.util.HashMap;
import java.util.List;
import operations.Operation;
import transfer.Request;
import transfer.Response;

/**
 *
 * @author Mihajlo
 */
public class OpstiKontrolerKI {
    private static OpstiKontrolerKI instance;
    
    private OpstiKontrolerKI(){
        
    }
    public static OpstiKontrolerKI getInstance(){
        if(instance==null){
            instance=new OpstiKontrolerKI();
        }
        return instance;
    }
    public void uspostaviKonekciju() throws IOException{
        if(Communication.getInstance().getSocket()==null){
            Socket socket=new Socket("localhost", 9000);
            Communication.getInstance().setSocket(socket);
            System.out.println("Klijent se povezao!");
        }
    }
    public void raskiniKonekciju() throws IOException, Exception{
        if(Communication.getInstance().getSocket()!=null){
            obradiZahtev(null, Operation.TERMINATE);
            Communication.getInstance().getSocket().close();
        }
    }
    public Object obradiZahtev(Object parametar,Operation op) throws IOException,Exception{
        Request request=new Request(parametar, op);
        Communication.getInstance().getSender().sendObject(request);
        Response response=(Response)Communication.getInstance().getReceiver().receiveObject();
        if(response==null){
            return null;
        }
        if(response.getException()!=null){
            throw response.getException();
        }
        if(response.getResult() instanceof Bibliotekar && !response.isUspesnost()){
            throw new ServerskiException("Bibliotekar sa ovim podacima je vec ulogovan!");
        }
        return response.getResult();
    }
    public Object prijaviBibliotekara(String email,String lozinka) throws ServerskiException, Exception{
        Bibliotekar bibliotekar=new Bibliotekar();
        bibliotekar.setEmail(email);
        bibliotekar.setLozinka(lozinka);
        bibliotekar=(Bibliotekar)obradiZahtev(bibliotekar, Operation.PRIJAVI_BIBLIOTEKARA);
        return bibliotekar;
    }
    public List<Grad> ucitajGradove() throws ServerskiException, Exception{
        List<Grad> gradovi=(List<Grad>)obradiZahtev(null, Operation.UCITAJ_GRADOVE);
        return gradovi;
        
    }
    public List<String> ucitajVrsteClanskihKarata() throws Exception{
        List<String> vck=(List<String>)obradiZahtev(null, Operation.UCITAJ_VRSTE_CLANSKIH_KARATA);
        return vck;
    }
    public Clan kreirajClana(Clan parametar) throws Exception{
        Clan clan=(Clan)obradiZahtev(parametar, Operation.KREIRAJ_CLANA);
        return clan;
    }
    public boolean zapamtiClana(Clan parametar) throws Exception{
        boolean uspesno=(Boolean)obradiZahtev(parametar, Operation.ZAPAMTI_CLANA);
        return uspesno;  
    }
    public List<Clan> ucitajSveClanove() throws ServerskiException, Exception{
        List<Clan> clanovi=(List<Clan>)obradiZahtev(null, Operation.UCITAJ_SVE_CLANOVE);
        return clanovi;
    }
    public List<Clan> nadjiClanove(HashMap<String,String> kriterijum) throws ServerskiException, Exception{
        List<Clan> nadjenjiClanovi=(List<Clan>) obradiZahtev(kriterijum, Operation.NADJI_CLANOVE);
        return nadjenjiClanovi;
    }
    public boolean aktivirajClanstvo(Clan clan)throws ServerskiException,Exception{
        boolean uspesno=(boolean) obradiZahtev(clan, Operation.AKTIVIRAJ_CLANSTVO);
        return uspesno;
    }
    public boolean deaktivirajClanstvo(Clan clan) throws ServerskiException,Exception{
        boolean uspesno=(boolean)obradiZahtev(clan, Operation.DEAKTIVIRAJ_CLANSTVO);
        return uspesno;
    }
    public boolean obrisiClana(Clan clan) throws ServerskiException,Exception{
        boolean uspesno=(boolean)obradiZahtev(clan, Operation.OBRISI_CLANA);
        return uspesno;
    }
    public List<Izdavac> ucitajIzdavace()throws ServerskiException,Exception{
        List<Izdavac> izdavaci=(List<Izdavac>) obradiZahtev(null, Operation.UCITAJ_IZDAVACE);
        return izdavaci;
    }
    public List<String> ucitajZanrove() throws ServerskiException,Exception{
        List<String> zanrovi=(List<String>) obradiZahtev(null, Operation.UCITAJ_ZANROVE);
        return zanrovi;
    }
    public Knjiga kreirajKnjigu(Knjiga parametar) throws ServerskiException,Exception{
        Knjiga knjiga=(Knjiga) obradiZahtev(parametar, Operation.KREIRAJ_KNJIGU);
        return knjiga;
    }
    public boolean zapamtiKnjigu(Knjiga knjiga) throws ServerskiException,Exception{
        boolean uspesno=(boolean) obradiZahtev(knjiga, Operation.ZAPAMTI_KNJIGU);
        return uspesno;
    }
    public boolean obrisiKnjigu(Knjiga knjiga) throws ServerskiException,Exception{
        boolean uspesno=(boolean) obradiZahtev(knjiga, Operation.OBRISI_KNJIGU);
        return uspesno;
    }
    public List<Knjiga> ucitajKnjige()throws ServerskiException,Exception{
        List<Knjiga> knjige=(List<Knjiga>) obradiZahtev(null, Operation.UCITAJ_KNJIGE);
        return knjige;
    }
    public Knjiga ucitajKnjigu(int sifra) throws Exception{
        Knjiga knjiga=new Knjiga();
        knjiga.setSifra(sifra);
        knjiga=(Knjiga) obradiZahtev(knjiga, Operation.UCITAJ_KNJIGU);
        return knjiga;
    }
    public Clan ucitajClana(int sifra) throws Exception{
        Clan clan=new Clan();
        clan.setSifra(sifra);
        clan=(Clan) obradiZahtev(clan, Operation.UCITAJ_CLANA);
        return clan;
    }
    public List<Knjiga> ucitajPrimerke() throws ServerskiException,Exception{
        List<Knjiga> primerci=(List<Knjiga>) obradiZahtev(null, Operation.UCITAJ_PRIMERKE);
        return primerci;
    }
    public List<Knjiga> nadjiPrimerke(HashMap<String,String> kriterijum) throws ServerskiException,Exception{
        List<Knjiga> nadjeniPrimerci=(List<Knjiga>) obradiZahtev(kriterijum, Operation.NADJI_PRIMERKE);
        return nadjeniPrimerci;
    }
    public List<Knjiga> nadjiSlobodnePrimerke(HashMap<String,String> kriterijum) throws ServerskiException,Exception{
        List<Knjiga> nadjeniPrimerci=(List<Knjiga>) obradiZahtev(kriterijum, Operation.NADJI_SLOBODNE_PRIMERKE);
        return nadjeniPrimerci;
    }
    public Rezervacija kreirajRezervaciju(Rezervacija parametar)throws ServerskiException,Exception{
        Rezervacija rezervacija=(Rezervacija) obradiZahtev(parametar, Operation.KREIRAJ_REZERVACIJU);
        return rezervacija;
    }
    public boolean zapamtiRezervaciju(Rezervacija rezervacija) throws ServerskiException,Exception{
        boolean uspesno=(boolean) obradiZahtev(rezervacija, Operation.ZAPAMTI_REZERVACIJU);
        return uspesno;
    }
    public boolean obrisiRezervaciju(Rezervacija rezervacija) throws ServerskiException,Exception{
        boolean uspesno=(boolean) obradiZahtev(rezervacija, Operation.OBRISI_REZERVACIJU);
        return uspesno;
    }
    public List<Rezervacija> ucitajRezervacijePoClanu(Rezervacija rezervacija) throws ServerskiException,Exception{
        List<Rezervacija> rezervacije=(List<Rezervacija>) obradiZahtev(rezervacija, Operation.UCITAJ_REZERVACIJE_PO_CLANU);
        return rezervacije;
    }
    public boolean potvrdiRezervaciju(Rezervacija rezervacija)throws ServerskiException,Exception{
        boolean uspesno=(boolean) obradiZahtev(rezervacija, Operation.POTVRDI_REZERVACIJU);
        return uspesno;
    }
    public List<Dobavljac> ucitajDobavljace()throws Exception{
        List<Dobavljac> dobavljaci=(List<Dobavljac>) obradiZahtev(null, Operation.UCITAJ_DOBAVLJACE);
        return dobavljaci;
    }
    public Narudzbenica kreirajNarudzbenicu(Narudzbenica narudzbenica)throws Exception{
        narudzbenica=(Narudzbenica) obradiZahtev(narudzbenica, Operation.KREIRAJ_NARUDZBENICU);
        return narudzbenica;
    }
    public boolean zapamtiNarudzbenicu(Narudzbenica narudzbenica) throws Exception{
        boolean uspesno=(boolean) obradiZahtev(narudzbenica, Operation.ZAPAMTI_NARUZBENICU);
        return uspesno;
    }
    public boolean obrisiNarudzbenicu(Narudzbenica narudzbenica) throws Exception{
        boolean uspesno=(boolean) obradiZahtev(narudzbenica, Operation.OBRISI_NARUDZBENICU);
        return uspesno;
    }
    public boolean izlogujSe(Bibliotekar admin) throws Exception{
        boolean uspesno=(boolean) obradiZahtev(admin, Operation.IZLOGUJ_SE);
        return uspesno;
    }
    public boolean proveriEmail(String email) throws Exception{
        boolean uspesno=(boolean) obradiZahtev(email, Operation.PROVERA_EMAIL);
        return uspesno;
    }
 }
