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
public class SODeaktivirajClanstvo extends OpstaSistemskaOperacija {

    private Clan clan;
    private boolean uspesnost;

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public boolean isUspesnost() {
        return uspesnost;
    }

    public void setUspesnost(boolean uspesnost) {
        this.uspesnost = uspesnost;
    }
    @Override
    public void izvrsiKonkretnuOperaciju() throws ServerskiException {
        clan=broker.deaktivirajClanstvo(clan);
        uspesnost=clan==null?false:true;
    }
    
}
