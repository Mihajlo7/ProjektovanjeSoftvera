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
public class SOKreirajNarudzbenicu extends OpstaSistemskaOperacija {
    private Narudzbenica narudzbenica;

    public Narudzbenica getNarudzbenica() {
        return narudzbenica;
    }

    public void setNarudzbenica(Narudzbenica narudzbenica) {
        this.narudzbenica = narudzbenica;
    }

    @Override
    public void izvrsiKonkretnuOperaciju() throws ServerskiException {
        int sifra=broker.vratiPrviSlobodanKljuc(narudzbenica);
        System.out.println(sifra);
        narudzbenica=new Narudzbenica(sifra);
        narudzbenica=(Narudzbenica) broker.sacuvajObjekat(narudzbenica);
    }
    
}
