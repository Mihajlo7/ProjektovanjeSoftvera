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
public class Bibliotekar extends OpstiDomenskiObjekat {
    private int sifra;
    private String ime;
    private String prezime;
    private String email;
    private String lozinka;
    private Grad grad;

    public Bibliotekar(int sifra, String ime, String prezime, String email, String lozinka, Grad grad) {
        this.sifra = sifra;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.lozinka = lozinka;
        this.grad = grad;
    }

    public Bibliotekar(int sifra, String ime, String prezime) {
        this.sifra = sifra;
        this.ime = ime;
        this.prezime = prezime;
    }
    

    public Bibliotekar() {
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
        return "bibliotekar";
    }

    @Override
    public String getColumnValues() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String setColumnValues() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public OpstiDomenskiObjekat getObjectFromResultSet(ResultSet rs) {
        OpstiDomenskiObjekat odo=null;
        try {
            if(rs.next()){
            int sifra=rs.getInt("sifraBibliotekara");
            String ime=rs.getString("imeBibliotekara");
            String prezime=rs.getString("prezimeBibliotekara");
            String email=rs.getString("emailBibliotekara");
            String lozinka=rs.getString("lozinkaBibliotekara");
            int sifraG=rs.getInt("sifraGrada");
            Grad grad=new Grad(sifraG);
            odo=new Bibliotekar(sifra, ime, prezime, email, lozinka, grad);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("GRESKA: Neuspesno prebacivanje ResultSet u Object");
        }
        return odo;
    }

    @Override
    public String getPrimaryKeyName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getPrimaryKeyValue() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(obj==null){
            return false;
        }
        if(getClass()!=obj.getClass()){
            return false;
        }
        final Bibliotekar pom=(Bibliotekar) obj;
        if(!pom.email.equals(this.email)){
            return false;
        }
        if(!pom.lozinka.equals(this.lozinka)){
            return false;
        }
        return true;
    }
    public String getLogin(){
        return String.format(" emailBibliotekara='%s' AND lozinkaBibliotekara='%s'",email,lozinka);
    }
    
}
