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
public class Knjiga extends OpstiDomenskiObjekat {
    private int sifra;
    private String naziv;
    private int godinaIzdavanja;
    private String zanr;
    private String autor;
    private Izdavac izdavac;

    public Knjiga(int sifra, String naziv, int godinaIzdavanja, String zanr, String autor, Izdavac izdavac) {
        this.sifra = sifra;
        this.naziv = naziv;
        this.godinaIzdavanja = godinaIzdavanja;
        this.zanr = zanr;
        this.autor = autor;
        this.izdavac = izdavac;
    }

    public Knjiga(int sifra) {
        this.sifra = sifra;
        this.naziv="";
        this.godinaIzdavanja=1111;
        this.autor="";
        this.zanr="";
        this.izdavac=new Izdavac(1);
    }
    public Knjiga(int sifra,String naziv){
        this.sifra=sifra;
        this.naziv=naziv;
    }

    public Knjiga() {
    }

    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getGodinaIzdavanja() {
        return godinaIzdavanja;
    }

    public void setGodinaIzdavanja(int godinaIzdavanja) {
        this.godinaIzdavanja = godinaIzdavanja;
    }

    public String getZanr() {
        return zanr;
    }

    public void setZanr(String zanr) {
        this.zanr = zanr;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Izdavac getIzdavac() {
        return izdavac;
    }

    public void setIzdavac(Izdavac izdavac) {
        this.izdavac = izdavac;
    }

    @Override
    public String getClassName() {
        return "knjiga";
    }

    @Override
    public String getPrimaryKeyName() {
        return "sifraKnjige";
    }

    @Override
    public int getPrimaryKeyValue() {
        return sifra;
    }

    @Override
    public String getColumnValues() {
        return String.format("%d,'%s',%d,'%s',%d,'%s'",sifra,naziv,godinaIzdavanja,zanr,izdavac.getSifra(),autor);
    }

    @Override
    public String setColumnValues() {
        return String.format("nazivKnjige='%s',godinaIzdavanja=%d,zanrKnjige='%s',autorKnjige='%s',sifraIzdavaca=%d",naziv,godinaIzdavanja,zanr,autor,izdavac.getSifra());
    }

    @Override
    public OpstiDomenskiObjekat getObjectFromResultSet(ResultSet rs) {
        OpstiDomenskiObjekat odo=null;
        try {
            int sifra=rs.getInt("sifraKnjige");
            String naziv=rs.getString("nazivKnjige");
            int godina=rs.getInt("godinaIzdavanja");
            String zanr=rs.getString("zanrKnjige");
            String autor=rs.getString("autorKnjige");
            int sifraI=rs.getInt("sifraIzdavaca");
            String nazivI=rs.getString("nazivIzdavaca");
            Izdavac izdavac=new Izdavac(sifraI, nazivI);
            odo=new Knjiga(sifra, naziv, godina, zanr, autor, izdavac);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("GRESKA: Ne moze da prebaci RS u Objekat Knjiga");
        }
        return odo;
    }
    
    
}
