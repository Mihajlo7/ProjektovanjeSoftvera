/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.OpstiDomenskiObjekat;
import domain.Rezervacija;
import exception.ServerskiException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Mihajlo
 */
public class SOUcitajRezervacije extends OpstaSistemskaOperacija {
    private Rezervacija parametar;
    private List<Rezervacija> rezervacije;

    public SOUcitajRezervacije() {
        rezervacije=new LinkedList<>();
    }

    public Rezervacija getParametar() {
        return parametar;
    }

    public void setParametar(Rezervacija parametar) {
        this.parametar = parametar;
    }

    public List<Rezervacija> getRezervacije() {
        return rezervacije;
    }

    public void setRezervacije(List<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }

    @Override
    public void izvrsiKonkretnuOperaciju() throws ServerskiException {
        List<OpstiDomenskiObjekat> lista=broker.vratiRezervacijeClana(parametar);
        for(OpstiDomenskiObjekat odo:lista){
            if(odo!=null){
                rezervacije.add((Rezervacija) odo);
            }
        }
    }
    
}
