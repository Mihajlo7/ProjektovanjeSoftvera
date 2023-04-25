/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Bibliotekar;
import domain.Clan;
import domain.Dobavljac;
import domain.Grad;
import domain.Izdavac;
import domain.Knjiga;
import domain.Narudzbenica;
import domain.Rezervacija;
import exception.ServerskiException;
import java.util.HashMap;
import java.util.List;
import so.SOAktivirajClanstvo;
import so.SODeaktivirajClanstvo;
import so.SOKreirajClana;
import so.SOKreirajKnjigu;
import so.SOKreirajNarudzbenicu;
import so.SOKreirajRezervaciju;
import so.SONadjiClanove;
import so.SONadjiPrimerke;
import so.SONadjiSlobodnePrimerke;
import so.SOObrisiClana;
import so.SOObrisiKnjigu;
import so.SOObrisiNarudzbinu;
import so.SOObrisiRezervaciju;
import so.SOPotvrdaRezervacije;
import so.SOPrijavaBibliotekara;
import so.SOPrijaviClana;
import so.SOProveriEmail;
import so.SOUcitajClana;
import so.SOUcitajClanove;
import so.SOUcitajDobavljace;
import so.SOUcitajGradove;
import so.SOUcitajIzdavace;
import so.SOUcitajKnjige;
import so.SOUcitajKnjigu;
import so.SOUcitajPrimerke;
import so.SOUcitajRezervacije;
import so.SOUcitajVrsteClanskihKarata;
import so.SOUcitajZanrove;
import so.SOZapamtiClana;
import so.SOZapamtiKnjigu;
import so.SOZapamtiNarudzbenicu;
import so.SOZapamtiRezervaciju;

/**
 *
 * @author Mihajlo
 */
public class Controller {
    private static Controller instance;
    
    private Controller(){
        
    }
    public static Controller getInstance(){
        if(instance==null){
            instance=new Controller();
        }
        return instance;
    }
    public Bibliotekar prijaviBibliotekara(Bibliotekar parametar) throws ServerskiException{
        SOPrijavaBibliotekara sopb=new SOPrijavaBibliotekara();
        sopb.setParametar(parametar);
        sopb.izvrsiOperaciju();
        //System.out.println("1");
        return sopb.getBibliotekar();
    }
    public Clan prijaviClana (Clan clan) throws ServerskiException{
        SOPrijaviClana sopc=new SOPrijaviClana();
        sopc.setParametar(clan);
        sopc.izvrsiOperaciju();
        return sopc.getClan();
    }
    public List<Grad> ucitajGradove() throws ServerskiException{
        SOUcitajGradove soug=new SOUcitajGradove();
        soug.izvrsiOperaciju();
        System.out.println("2");
        return soug.getGradovi();
    }
    public List<String> ucitajVrsteClanskihKarata() throws ServerskiException{
        SOUcitajVrsteClanskihKarata souvck=new SOUcitajVrsteClanskihKarata();
        souvck.izvrsiOperaciju();
        return souvck.getVrsteClanskihKarata();
    }
    public Clan kreirajClana(Clan clan) throws ServerskiException{
        SOKreirajClana sokc=new SOKreirajClana();
        sokc.setClan(clan);
        sokc.izvrsiOperaciju();
        return sokc.getClan();
    }
    public boolean zapamtiClana(Clan clan) throws ServerskiException{
        SOZapamtiClana sozc=new SOZapamtiClana();
        sozc.setClan(clan);
        sozc.izvrsiOperaciju();
        return sozc.isUspesno();
    }
    public List<Clan> ucitajSveClanove() throws ServerskiException{
        SOUcitajClanove souc=new SOUcitajClanove();
        souc.izvrsiOperaciju();
        return souc.getClanovi();
    }
    public List<Clan> nadjiClanove(HashMap<String,String> kriterijum)throws ServerskiException{
        SONadjiClanove sonc=new SONadjiClanove();
        sonc.setKriterijum(kriterijum);
        sonc.izvrsiOperaciju();
        return sonc.getNadjeniClanovi();
    }
    public boolean aktivirajClanstvo(Clan clan) throws ServerskiException{
        SOAktivirajClanstvo soac=new SOAktivirajClanstvo();
        soac.setClan(clan);
        soac.izvrsiOperaciju();
        return soac.isUspesnost();
    }
    public boolean deaktivirajClanstvo(Clan clan) throws ServerskiException{
        SODeaktivirajClanstvo sodc=new SODeaktivirajClanstvo();
        sodc.setClan(clan);
        sodc.izvrsiOperaciju();
        return sodc.isUspesnost();
    }
    public boolean obrisiClana(Clan clan)throws ServerskiException{
        SOObrisiClana sooc=new SOObrisiClana();
        sooc.setClan(clan);
        sooc.izvrsiOperaciju();
        return sooc.isUspesno();
    }
    public List<String> ucitajZanrove() throws ServerskiException{
        SOUcitajZanrove souz=new SOUcitajZanrove();
        souz.izvrsiOperaciju();
        return souz.getZanrovi();  
    }
    public List<Izdavac> ucitajIzdavaci() throws ServerskiException{
        SOUcitajIzdavace soui=new SOUcitajIzdavace();
        soui.izvrsiOperaciju();
        return soui.getIzdavaci();
    }
    public Knjiga kreirajKnjigu(Knjiga knjiga) throws ServerskiException{
        SOKreirajKnjigu sokk=new SOKreirajKnjigu();
        sokk.izvrsiOperaciju();
        return sokk.getKnjiga();
    }
    public boolean zapamtiKnjigu(Knjiga knjiga) throws ServerskiException{
        SOZapamtiKnjigu sozk=new SOZapamtiKnjigu();
        sozk.setKnjiga(knjiga);
        sozk.izvrsiOperaciju();
        return sozk.isUspesno();
    }
    public boolean obrisiKnjigu(Knjiga knjiga) throws ServerskiException{
        SOObrisiKnjigu sook=new SOObrisiKnjigu();
        sook.setKnjiga(knjiga);
        sook.izvrsiOperaciju();
        return sook.isUspesno();
    }
    public List<Knjiga> ucitajPrimerke() throws ServerskiException{
        SOUcitajPrimerke soup=new SOUcitajPrimerke();
        soup.izvrsiOperaciju();
        return soup.getPrimerci();
    }
    public List<Knjiga> ucitajKnjige() throws ServerskiException{
        SOUcitajKnjige souk=new SOUcitajKnjige();
        souk.izvrsiOperaciju();
        return souk.getKnjige();
    }
    public Knjiga ucitajKnjigu(Knjiga parametar) throws ServerskiException{
        SOUcitajKnjigu souk=new SOUcitajKnjigu();
        souk.setParametar(parametar);
        souk.izvrsiOperaciju();
        return souk.getKnjiga();
    }
    public Clan ucitajClana(Clan parametar) throws ServerskiException{
        SOUcitajClana souc=new SOUcitajClana();
        souc.setParametar(parametar);
        souc.izvrsiOperaciju();
        return souc.getClan();
    }
    public List<Knjiga> nadjiPrimerke(HashMap<String,String> kriterijum) throws ServerskiException{
        SONadjiPrimerke sonp=new SONadjiPrimerke();
        sonp.setKriterijum(kriterijum);
        sonp.izvrsiOperaciju();
        return sonp.getPrimerci();
    }
    public List<Knjiga> nadjiSlobodnePrimerke(HashMap<String,String> kriterijum) throws ServerskiException{
        SONadjiSlobodnePrimerke sonsp=new SONadjiSlobodnePrimerke();
        sonsp.setKriterijum(kriterijum);
        sonsp.izvrsiOperaciju();
        return sonsp.getPrimerci();
    }
    public Rezervacija kreirajRezervaciju(Rezervacija rezervacija) throws ServerskiException{
        SOKreirajRezervaciju sokr=new SOKreirajRezervaciju();
        sokr.izvrsiOperaciju();
        return sokr.getRezervacija();
    }
    public boolean zapamtiRezervaciju(Rezervacija rezervacija) throws ServerskiException{
        SOZapamtiRezervaciju sozr =new SOZapamtiRezervaciju();
        sozr.setRezervacija(rezervacija);
        sozr.izvrsiOperaciju();
        return sozr.isUspesno();
    }
    public boolean obrisiRezervaciju(Rezervacija rezervacija) throws ServerskiException{
        SOObrisiRezervaciju soor=new SOObrisiRezervaciju();
        soor.setRezervacija(rezervacija);
        soor.izvrsiOperaciju();
        return soor.isUspesno();
    }
    public List<Rezervacija> vratiRezervacijePoClanu(Rezervacija rezervacija) throws ServerskiException{
        SOUcitajRezervacije sour=new SOUcitajRezervacije();
        sour.setParametar(rezervacija);
        sour.izvrsiOperaciju();
        return sour.getRezervacije();
    }
    public boolean potvrdiRezervaciju(Rezervacija rezervacija) throws ServerskiException{
        SOPotvrdaRezervacije sopr=new SOPotvrdaRezervacije();
        sopr.setRezervacija(rezervacija);
        sopr.izvrsiOperaciju();
        return sopr.isUspesno();
    }
    public List<Dobavljac> ucitajDobavljace() throws ServerskiException{
        SOUcitajDobavljace soud=new SOUcitajDobavljace();
        soud.izvrsiOperaciju();
        return soud.getDobavljaci();
    }
    public Narudzbenica kreirajNarudzbenicu(Narudzbenica narudzbenica) throws ServerskiException{
        SOKreirajNarudzbenicu sokn=new SOKreirajNarudzbenicu();
        sokn.setNarudzbenica(narudzbenica);
        sokn.izvrsiOperaciju();
        return sokn.getNarudzbenica();
    }
    public boolean zapamtiNarudzbenicu(Narudzbenica narudzbenica) throws ServerskiException{
        SOZapamtiNarudzbenicu sozn=new SOZapamtiNarudzbenicu();
        sozn.setNarudzbenica(narudzbenica);
        sozn.izvrsiOperaciju();
        return sozn.isUspesno();
    }
    public boolean obrisiNarudzbenicu(Narudzbenica narudzbenica) throws ServerskiException{
        SOObrisiNarudzbinu soon=new SOObrisiNarudzbinu();
        soon.setNarudzbenica(narudzbenica);
        soon.izvrsiOperaciju();
        return soon.isUspesno();
    }
    ///////////////
    public boolean proveriEmail(String email) throws ServerskiException{
        SOProveriEmail sope=new SOProveriEmail();
        sope.setParametar(email);
        sope.izvrsiOperaciju();
        return sope.isUspesno();
    }
}
