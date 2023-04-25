/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;

/**
 *
 * @author Mihajlo
 */
public class Stavka_Narudzbenice extends OpstiDomenskiObjekat {
    private final int sifraNarudzbine;
    private int sifra;
    private int kolicina;
    private Knjiga knjiga;

    public Stavka_Narudzbenice(int sifraNarudzbine, int sifra, int kolicina, Knjiga knjiga) {
        this.sifraNarudzbine = sifraNarudzbine;
        this.sifra = sifra;
        this.kolicina = kolicina;
        this.knjiga = knjiga;
    }

    public Stavka_Narudzbenice(int sifraNarudzbine) {
        this.sifraNarudzbine = sifraNarudzbine;
    }

    public Stavka_Narudzbenice(int sifraNarudzbine, int kolicina, Knjiga knjiga) {
        this.sifraNarudzbine = sifraNarudzbine;
        this.kolicina = kolicina;
        this.knjiga = knjiga;
    }

    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    @Override
    public String getClassName() {
        return "stavka_narudzbenice";
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
        return String.format("%d,%d,%d,%d",sifraNarudzbine,sifra,kolicina,knjiga.getSifra());
    }

    @Override
    public String setColumnValues() {
        return String.format("sifraNarudzbenice=%d, sifraStavke=%d, kolicina=%d, sifraKnjige=%d",sifraNarudzbine,sifra,kolicina,knjiga.getSifra());
    }

    @Override
    public OpstiDomenskiObjekat getObjectFromResultSet(ResultSet rs) {
        throw new UnsupportedOperationException("Nije implementirano!"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    
}
