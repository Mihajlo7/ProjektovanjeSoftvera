/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Rezervacija;
import exception.ServerskiException;

/**
 *
 * @author Mihajlo
 */
public class SOKreirajRezervaciju extends OpstaSistemskaOperacija {
   private Rezervacija rezervacija;

    public SOKreirajRezervaciju() {
        
    }
   

    public Rezervacija getRezervacija() {
        return rezervacija;
    }

    public void setRezervacija(Rezervacija rezervacija) {
        this.rezervacija = rezervacija;
    }

    @Override
    public void izvrsiKonkretnuOperaciju() throws ServerskiException {
        int sifra=broker.vratiPrviSlobodanKljuc(new Rezervacija());
        System.out.println(sifra);
        rezervacija=new Rezervacija(sifra);
        rezervacija=(Rezervacija) broker.sacuvajObjekat(rezervacija);
    }
   
}
