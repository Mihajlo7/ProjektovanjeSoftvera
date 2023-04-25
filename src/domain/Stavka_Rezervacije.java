/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mihajlo
 */
public class Stavka_Rezervacije extends OpstiDomenskiObjekat {
    private final int rezervacija;
    private int sifra;
    private Knjiga knjiga;

    public Stavka_Rezervacije(int rezervacija,int sifra, Knjiga knjiga) {
        this.rezervacija=rezervacija;
        this.sifra = sifra;
        this.knjiga = knjiga;
    }

    public Stavka_Rezervacije(int rezervacija) {
        this.rezervacija=rezervacija;
    }

    public Stavka_Rezervacije(int rezervacija, Knjiga knjiga) {
        this.rezervacija = rezervacija;
        this.knjiga = knjiga;
    }

    

    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    @Override
    public String getClassName() {
        return "stavka_rezervacije";
    }

    @Override
    public String getPrimaryKeyName() {
        return "sifraStavke";
    }

    @Override
    public int getPrimaryKeyValue() {
        return sifra;
    }

    @Override
    public String getColumnValues() {
        return String.format("%d,%d,%d",rezervacija,sifra,knjiga.getSifra());
    }

    @Override
    public String setColumnValues() {
        throw new UnsupportedOperationException("Nije implementirano."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public OpstiDomenskiObjekat getObjectFromResultSet(ResultSet rs) {
        OpstiDomenskiObjekat odo=null;
        try {
            int rezervacija=rs.getInt("sifraRezervacije");
            int sifra=rs.getInt("sifraStavke");
            int sifraK=rs.getInt("sifraKnjige");
            String nazivK=rs.getString("nazivKnjige");
            Knjiga knjiga=new Knjiga(sifraK, nazivK);
            odo=new Stavka_Rezervacije(rezervacija, sifra, knjiga);
        } catch (SQLException ex) {
            //Logger.getLogger(Stavka_Rezervacije.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            System.out.println("Greska prilikom prebacivanja RS u Stavku rezervacije");
        }
        return odo;
    }
    
}
