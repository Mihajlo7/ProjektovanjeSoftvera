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
public class SOObrisiClana extends OpstaSistemskaOperacija {
    private Clan clan;
    private boolean uspesno;

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public boolean isUspesno() {
        return uspesno;
    }

    public void setUspesno(boolean uspesno) {
        this.uspesno = uspesno;
    }
    
    @Override
    public void izvrsiKonkretnuOperaciju() throws ServerskiException {
        clan=(Clan) broker.obrisiObjekat(clan);
        uspesno=clan==null?false:true;
    }
    
}
