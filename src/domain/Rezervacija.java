/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mihajlo
 */
public class Rezervacija extends OpstiDomenskiObjekat {
    private int sifra;
    private LocalDate datumIznamljivanja;
    private LocalDate datumVracanja;
    private boolean aktivnostRezervacije;
    private Clan clan;
    private Bibliotekar admin;
    private List<Stavka_Rezervacije> stavkeRezervacije;

    public Rezervacija(int sifra, LocalDate datumIznamljivanja, LocalDate datumVracanja, boolean aktivnostRezervacije, Clan clan, Bibliotekar admin, List<Stavka_Rezervacije> stavkeRezervacije) {
        this.sifra = sifra;
        this.datumIznamljivanja = datumIznamljivanja;
        this.datumVracanja = datumVracanja;
        this.aktivnostRezervacije = aktivnostRezervacije;
        this.clan = clan;
        this.admin = admin;
        this.stavkeRezervacije = stavkeRezervacije;
    }

    public Rezervacija(int sifra) {
        this.sifra = sifra;
        this.aktivnostRezervacije=true;
        this.clan=new Clan(1);
        this.datumIznamljivanja=LocalDate.of(1111,1,1);
        this.datumVracanja=LocalDate.of(9999, 9, 9);
        this.admin=new Bibliotekar();
        this.admin.setSifra(1);
    }

    public Rezervacija() {
    }

    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }

    public LocalDate getDatumIznamljivanja() {
        return datumIznamljivanja;
    }

    public void setDatumIznamljivanja(LocalDate datumIznamljivanja) {
        this.datumIznamljivanja = datumIznamljivanja;
    }

    public LocalDate getDatumVracanja() {
        return datumVracanja;
    }

    public void setDatumVracanja(LocalDate datumVracanja) {
        this.datumVracanja = datumVracanja;
    }

    public boolean isAktivnostRezervacije() {
        return aktivnostRezervacije;
    }

    public void setAktivnostRezervacije(boolean aktivnostRezervacije) {
        this.aktivnostRezervacije = aktivnostRezervacije;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public Bibliotekar getAdmin() {
        return admin;
    }

    public void setAdmin(Bibliotekar admin) {
        this.admin = admin;
    }

    public List<Stavka_Rezervacije> getStavkeRezervacije() {
        return stavkeRezervacije;
    }

    public void setStavkeRezervacije(List<Stavka_Rezervacije> stavkeRezervacije) {
        this.stavkeRezervacije = stavkeRezervacije;
    }

    @Override
    public String getClassName() {
        return "rezervacija";
    }

    @Override
    public String getPrimaryKeyName() {
        return "sifraRezervacije";
    }

    @Override
    public int getPrimaryKeyValue() {
        return sifra;
    }

    @Override
    public String getColumnValues() {
       return String.format("%d,'%s','%s',%d,%d,%d",sifra,Date.valueOf(datumIznamljivanja),Date.valueOf(datumVracanja),1,clan.getSifra(),admin.getSifra());
    }

    @Override
    public String setColumnValues() {
        return String.format("sifraRezervacije=%d,datumIznamljivanja='%s',datumVracanja='%s',aktivnostRezervacije=%d,sifraClana=%d,sifraBibliotekara=%d",
                sifra,Date.valueOf(datumIznamljivanja),Date.valueOf(datumVracanja),aktivnostRezervacije==true?1:0,clan.getSifra(),admin.getSifra());
    }

    @Override
    public OpstiDomenskiObjekat getObjectFromResultSet(ResultSet rs) {
        Rezervacija odo=null;
        try {
            int sifra=rs.getInt("sifraRezervacije");
            LocalDate datumI=(rs.getDate("datumIznamljivanja")).toLocalDate();
            LocalDate datumV=(rs.getDate("datumVracanja")).toLocalDate();
            boolean aktivnost=rs.getInt("aktivnostRezervacije") != 0;
            int sifraClana=rs.getInt("sifraClana");
            Clan clan=new Clan(sifraClana);
            int sifraAdmina=rs.getInt("sifraBibliotekara");
            String imeAdmina=rs.getString("imeBibliotekara");
            String prezimeAdmina=rs.getString("prezimeBibliotekara");
           // Bibliotekar admin=new Bibliotekar(sifraAdmina, imeAdmina, prezimeAdmina, emailAdmina, imeAdmina, grad)
           Bibliotekar admin=new Bibliotekar(sifraAdmina, imeAdmina, prezimeAdmina);
           odo=new Rezervacija();
           odo.setSifra(sifra);
           odo.setDatumIznamljivanja(datumI);
           odo.setDatumVracanja(datumV);
           odo.setAktivnostRezervacije(aktivnost);
           odo.setClan(clan);
           odo.setAdmin(admin);
        } catch (SQLException ex) {
            Logger.getLogger(Rezervacija.class.getName()).log(Level.SEVERE, null, ex);
        }
        return odo;
    }
    
}
