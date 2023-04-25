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
public class SOUcitajKnjigu extends OpstaSistemskaOperacija {
    private Knjiga parametar;

    public Knjiga getParametar() {
        return parametar;
    }

    public void setParametar(Knjiga parametar) {
        this.parametar = parametar;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }
    private Knjiga knjiga;

    @Override
    public void izvrsiKonkretnuOperaciju() throws ServerskiException {
        knjiga=(Knjiga) broker.ucitajObjekat(parametar);
        
    }
}
