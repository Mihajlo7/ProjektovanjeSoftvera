/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import exception.ServerskiException;
import java.util.List;

/**
 *
 * @author Mihajlo
 */
public class SOUcitajZanrove extends OpstaSistemskaOperacija {
    
    private List<String> zanrovi;

    public List<String> getZanrovi() {
        return zanrovi;
    }

    public void setZanrovi(List<String> zanrovi) {
        this.zanrovi = zanrovi;
    }

    @Override
    public void izvrsiKonkretnuOperaciju() throws ServerskiException {
        zanrovi=broker.ucitajZanrove();
    }
}
