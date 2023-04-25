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
public class Clan extends OpstiDomenskiObjekat {
    private int sifra;
    private String ime;
    private String prezime;
    private String telefon;
    private String vrstaClanskeKarte;
    private boolean aktivan;
    private String email;
    private String lozinka;
    private Grad grad;

    public Clan(int sifra, String ime, String prezime, String telefon, String vrstaClanskeKarte, boolean aktivan, String email, String lozinka, Grad grad) {
        this.sifra = sifra;
        this.ime = ime;
        this.prezime = prezime;
        this.telefon = telefon;
        this.vrstaClanskeKarte = vrstaClanskeKarte;
        this.aktivan = aktivan;
        this.email = email;
        this.lozinka = lozinka;
        this.grad = grad;
    }

    public Clan() {
    }

    public Clan(int sifra) {
        this.sifra = sifra;
        this.ime="";
        this.prezime="";
        this.telefon="";
        this.vrstaClanskeKarte="";
        this.aktivan=false;
        this.email="";
        this.lozinka="";
        this.grad=new Grad(1);
    }

    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getVrstaClanskeKarte() {
        return vrstaClanskeKarte;
    }

    public void setVrstaClanskeKarte(String vrstaClanskeKarte) {
        this.vrstaClanskeKarte = vrstaClanskeKarte;
    }

    public boolean isAktivan() {
        return aktivan;
    }

    public void setAktivan(boolean aktivan) {
        this.aktivan = aktivan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public Grad getGrad() {
        return grad;
    }

    public void setGrad(Grad grad) {
        this.grad = grad;
    }

    @Override
    public String getClassName() {
        return "clan";
    }

    @Override
    public String getPrimaryKeyName() {
        return "sifraClana";
    }

    @Override
    public String getColumnValues() {
       return String.format("%d,'%s','%s','%s','%s',%d,'%s','%s',%d",sifra,ime,prezime,telefon,vrstaClanskeKarte,aktivan?1:0,email,lozinka,grad.getSifra());
    }

    @Override
    public String setColumnValues() {
       return String.format("imeClana='%s',prezimeClana='%s',telefonClana='%s',vrstaClanskeKarte='%s',aktivnostClanstva=%d,emailClana='%s',lozinkaClana='%s',sifraGrada=%d",
               ime,prezime,telefon,vrstaClanskeKarte,aktivan?1:0,email,lozinka,grad.getSifra());
    }

    @Override
    public OpstiDomenskiObjekat getObjectFromResultSet(ResultSet rs) {
        OpstiDomenskiObjekat odo=null;
        
        try {
            int sifra=rs.getInt("sifraClana");
                String ime=rs.getString("imeClana");
                String prezime=rs.getString("prezimeClana");
                String telefon=rs.getString("telefonClana");
                String vrstaClanskeKarte=rs.getString("vrstaClanskeKarte");
                boolean aktivan=false;
                if(rs.getInt("aktivnostClanstva")==1){
                    aktivan=true;
                }
                String email=rs.getString("emailClana");
                String lozinka=rs.getString("lozinkaClana");
                
                Grad grad=new Grad(rs.getInt("sifraGrada"), rs.getString("nazivGrada"));
                odo=new Clan(sifra, ime, prezime, telefon, vrstaClanskeKarte, aktivan, email, lozinka, grad);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("GRESKA: Ne moze da prebaci RS u Objekat Clan");
        }
        return odo;
    }

    @Override
    public int getPrimaryKeyValue() {
        return sifra;
    }
    
    public String getLogin(){
        return String.format(" emailClana='%s' AND lozinkaClana='%s'", email,lozinka);
    }
}
