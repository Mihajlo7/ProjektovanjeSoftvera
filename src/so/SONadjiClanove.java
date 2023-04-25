/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Clan;
import domain.OpstiDomenskiObjekat;
import exception.ServerskiException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Mihajlo
 */
public class SONadjiClanove extends OpstaSistemskaOperacija {
   private HashMap<String,String> kriterijum;
   private List<Clan> nadjeniClanovi;
   public SONadjiClanove(){
       this.nadjeniClanovi=new LinkedList<>();
   }

    public HashMap<String, String> getKriterijum() {
        return kriterijum;
    }

    public void setKriterijum(HashMap<String, String> kriterijum) {
        this.kriterijum = kriterijum;
    }

    public List<Clan> getNadjeniClanovi() {
        return nadjeniClanovi;
    }

    public void setNadjeniClanovi(List<Clan> nadjeniClanovi) {
        this.nadjeniClanovi = nadjeniClanovi;
    }

    @Override
    public void izvrsiKonkretnuOperaciju() throws ServerskiException {
        List<OpstiDomenskiObjekat> pom=broker.nadjiClanove(kriterijum);
        for(OpstiDomenskiObjekat odo:pom){
            nadjeniClanovi.add((Clan) odo);
        }
    }
   
}
