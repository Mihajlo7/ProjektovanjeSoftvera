/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mihajlo
 */
public class Narudzbenica extends OpstiDomenskiObjekat {
   private int sifra;
   private LocalDate datum;
   private Bibliotekar admin;
   private Dobavljac dobavljac;
   private List<Stavka_Narudzbenice> stavkeNarudzbenice;

    public List<Stavka_Narudzbenice> getStavkeNarudzbenice() {
        return stavkeNarudzbenice;
    }

    public void setStavkeNarudzbenice(List<Stavka_Narudzbenice> stavkeNarudzbenice) {
        this.stavkeNarudzbenice = stavkeNarudzbenice;
    }

    public Narudzbenica() {
    }

    public Narudzbenica(int sifra, LocalDate datum, Bibliotekar admin, Dobavljac dobavljac) {
        this.sifra = sifra;
        this.datum = datum;
        this.admin = admin;
        this.dobavljac=dobavljac;
    }

    public Dobavljac getDobavljac() {
        return dobavljac;
    }

    public void setDobavljac(Dobavljac dobavljac) {
        this.dobavljac = dobavljac;
    }

    public Narudzbenica(int sifra) {
        this.sifra = sifra;
        this.datum=LocalDate.of(1111, 1, 1);
        this.admin=new Bibliotekar();
        this.admin.setSifra(1);
        this.dobavljac=new Dobavljac();
        this.dobavljac.setSifra(1);
    }

    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public Bibliotekar getAdmin() {
        return admin;
    }

    public void setAdmin(Bibliotekar admin) {
        this.admin = admin;
    }

    @Override
    public String getClassName() {
        return "narudzbenica";
    }

    @Override
    public String getPrimaryKeyName() {
        return "sifraNarudzbenice";
    }

    @Override
    public int getPrimaryKeyValue() {
        return sifra;
    }

    @Override
    public String getColumnValues() {
        return String.format("%d,'%s',%d,%d",sifra,datum,admin.getSifra(),dobavljac.getSifra());
    }

    @Override
    public String setColumnValues() {
        return String.format("sifraNarudzbenice=%d, datumNarucivanja='%s', sifraBibliotekara=%d, sifraDobavljaca=%d",sifra,datum,admin.getSifra(),dobavljac.getSifra());
    }

    @Override
    public OpstiDomenskiObjekat getObjectFromResultSet(ResultSet rs) {
        OpstiDomenskiObjekat odo=null;
       try {
           int sifra=rs.getInt("sifraNarudzbenice");
           LocalDate datum=(rs.getDate("datumNarucivanja")).toLocalDate();
           int sifraB=rs.getInt("sifraBibliotekara");
           String imeB=rs.getString("imeBibliotekara");
           String prezimeB=rs.getString("prezimeBibliotekara");
           Bibliotekar admin=new Bibliotekar(sifraB, imeB, prezimeB);
           int sifraD=rs.getInt("sifraDobavljaca");
           String nazivD=rs.getString("nazivDobavljaca");
           int sifraG=rs.getInt("sifraGrada");
           Dobavljac dobavljac=new Dobavljac(sifraD,nazivD ,new Grad(sifraG));
           odo=new Narudzbenica(sifra, datum, admin, dobavljac);
       } catch (SQLException ex) {
           System.err.println("Neuspesna opcija prebacivanja RS u objekat");
       }
       return odo;
    }
   
   
}
