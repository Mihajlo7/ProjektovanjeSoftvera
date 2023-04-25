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
public class SOZapamtiClana extends OpstaSistemskaOperacija {
    
    private Clan clan;
    private boolean uspesno;

    @Override
    public void izvrsiKonkretnuOperaciju() throws ServerskiException {
        clan=(Clan)broker.izmeniObjekat(clan);
        if(clan==null){
            uspesno=false;
        }else{
            uspesno=true;
        }
    }

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
    
}
