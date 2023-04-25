/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Knjiga;
import domain.OpstiDomenskiObjekat;
import exception.ServerskiException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Mihajlo
 */
public class SONadjiPrimerke extends OpstaSistemskaOperacija {
   private List<Knjiga> primerci;
   private HashMap<String,String> kriterijum;

    public SONadjiPrimerke() {
        primerci=new LinkedList<>();
    }

    public List<Knjiga> getPrimerci() {
        return primerci;
    }

    public void setPrimerci(List<Knjiga> primerci) {
        this.primerci = primerci;
    }

    public HashMap<String, String> getKriterijum() {
        return kriterijum;
    }

    public void setKriterijum(HashMap<String, String> kriterijum) {
        this.kriterijum = kriterijum;
    }

    @Override
    public void izvrsiKonkretnuOperaciju() throws ServerskiException {
        List<OpstiDomenskiObjekat> lista=broker.nadjiPrimerke(kriterijum);
        for(OpstiDomenskiObjekat odo: lista){
            if(odo!=null){
                primerci.add((Knjiga) odo);
            }
        }
    }
   
   
}
