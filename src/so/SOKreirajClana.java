/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Clan;
import exception.ServerskiException;

/**
 *
 * @author Mihajlo
 */
public class SOKreirajClana extends OpstaSistemskaOperacija {
    private Clan clan;

    public Clan getClan() {
        return clan;
    }

    public SOKreirajClana() {
        
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    @Override
    public void izvrsiKonkretnuOperaciju() throws ServerskiException {
        clan=new Clan();
        int sifra=broker.vratiPrviSlobodanKljuc(clan);
        System.out.println(sifra);
        clan=new Clan(sifra);
        clan=(Clan)broker.sacuvajObjekat(clan);
    }
    
}
