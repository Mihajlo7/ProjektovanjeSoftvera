/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Narudzbenica;
import exception.ServerskiException;

/**
 *
 * @author Mihajlo
 */
public class SOObrisiNarudzbinu extends OpstaSistemskaOperacija {
    private Narudzbenica narudzbenica;
    private boolean uspesno;

    public Narudzbenica getNarudzbenica() {
        return narudzbenica;
    }

    public void setNarudzbenica(Narudzbenica narudzbenica) {
        this.narudzbenica = narudzbenica;
    }

    public boolean isUspesno() {
        return uspesno;
    }

    public void setUspesno(boolean uspesno) {
        this.uspesno = uspesno;
    }

    @Override
    public void izvrsiKonkretnuOperaciju() throws ServerskiException {
        narudzbenica=(Narudzbenica) broker.obrisiObjekat(narudzbenica);
        uspesno=narudzbenica!=null?true:false;
    }
    
}
