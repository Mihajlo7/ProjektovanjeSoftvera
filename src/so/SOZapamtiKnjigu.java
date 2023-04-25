/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Knjiga;
import exception.ServerskiException;

/**
 *
 * @author Mihajlo
 */
public class SOZapamtiKnjigu extends OpstaSistemskaOperacija {
    private Knjiga knjiga;
    private boolean uspesno;

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    public boolean isUspesno() {
        return uspesno;
    }

    public void setUspesno(boolean uspesno) {
        this.uspesno = uspesno;
    }

    @Override
    public void izvrsiKonkretnuOperaciju() throws ServerskiException {
        knjiga=(Knjiga) broker.izmeniObjekat(knjiga);
        uspesno=knjiga==null?false:true;
    }
    
}
