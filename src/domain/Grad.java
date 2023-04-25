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
public class Grad extends OpstiDomenskiObjekat {
    private int sifra;
    private String naziv;

    public Grad(int sifra, String naziv) {
        this.sifra = sifra;
        this.naziv = naziv;
    }

    public Grad(int sifra) {
        this.sifra = sifra;
        this.naziv="Nebitno";
    }

    public Grad() {
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

    @Override
    public String getClassName() {
        return "grad";
    }

    @Override
    public String getColumnValues() {
        throw new UnsupportedOperationException("Nije implementirana!"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String setColumnValues() {
        throw new UnsupportedOperationException("Nije implementirana!"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public OpstiDomenskiObjekat getObjectFromResultSet(ResultSet rs) {
        OpstiDomenskiObjekat odo=null;
        try {
            int sifra=rs.getInt("sifraGrada");
            String naziv=rs.getString("nazivGrada");
            odo=new Grad(sifra, naziv);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("GRESKA: Neuspesno prebacivanje ResultSet u Object");
        }
        return odo;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String getPrimaryKeyName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getPrimaryKeyValue() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
