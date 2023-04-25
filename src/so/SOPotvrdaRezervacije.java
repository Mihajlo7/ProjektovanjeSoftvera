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
public class SOPotvrdaRezervacije extends OpstaSistemskaOperacija {
    private Rezervacija rezervacija;
    private boolean uspesno;

    public Rezervacija getRezervacija() {
        return rezervacija;
    }

    public void setRezervacija(Rezervacija rezervacija) {
        this.rezervacija = rezervacija;
    }

    public boolean isUspesno() {
        return uspesno;
    }

    public void setUspesno(boolean uspesno) {
        this.uspesno = uspesno;
    }

    @Override
    public void izvrsiKonkretnuOperaciju() throws ServerskiException {
        rezervacija=(Rezervacija) broker.potvrdiRezervaciju(rezervacija);
        uspesno=rezervacija!=null?true:false;
    }
    
}
