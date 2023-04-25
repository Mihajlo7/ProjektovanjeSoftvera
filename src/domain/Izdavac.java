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
public class Izdavac extends OpstiDomenskiObjekat {
    private int sifra;
    private String naziv;
    private Grad grad;

    public Izdavac(int sifra, String naziv, Grad grad) {
        this.sifra = sifra;
        this.naziv = naziv;
        this.grad = grad;
    }

    public Izdavac(int sifra, String naziv) {
        this.sifra = sifra;
        this.naziv = naziv;
        this.grad=null;
    }

    public Izdavac(int sifra) {
        this.sifra = sifra;
    }

    
    
    public Izdavac() {
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

    public Grad getGrad() {
        return grad;
    }

    public void setGrad(Grad grad) {
        this.grad = grad;
    }

    @Override
    public String getClassName() {
        return "izdavac";
    }

    @Override
    public String getPrimaryKeyName() {
        return "sifraIzdavaca";
    }

    @Override
    public int getPrimaryKeyValue() {
        return sifra;
    }

    @Override
    public String getColumnValues() {
        throw new UnsupportedOperationException("Nije implementirana."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String setColumnValues() {
        throw new UnsupportedOperationException("Nije implementirana."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public OpstiDomenskiObjekat getObjectFromResultSet(ResultSet rs) {
        OpstiDomenskiObjekat odo=null;
        
        try {
            int sifra=rs.getInt("sifraIzdavaca");
            String naziv=rs.getString("nazivIzdavaca");
            int sifraG=rs.getInt("sifraGrada");
            String nazivG=rs.getString("nazivGrada");
            Grad grad=new Grad(sifraG, nazivG);
            odo=new Izdavac(sifra, naziv, grad);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("GRESKA: Ne moze da prebaci RS u Objekat Izdavac");
        }
        return odo;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
}
