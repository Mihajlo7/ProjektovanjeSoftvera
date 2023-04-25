/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Clan;
import domain.OpstiDomenskiObjekat;
import exception.ServerskiException;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mihajlo
 */
public class SOUcitajClanove extends OpstaSistemskaOperacija {

    private List<Clan> clanovi;
    
    public SOUcitajClanove(){
        clanovi=new LinkedList<>();
    }
    @Override
    public void izvrsiKonkretnuOperaciju() throws ServerskiException {
        try {
            List<OpstiDomenskiObjekat> pom=broker.vratiObjekte("Clan");
            for(OpstiDomenskiObjekat odo:pom){
                if(odo!=null)
                    clanovi.add((Clan)odo);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SOUcitajClanove.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(SOUcitajClanove.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(SOUcitajClanove.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SOUcitajClanove.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(SOUcitajClanove.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(SOUcitajClanove.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Clan> getClanovi() {
        return clanovi;
    }

    public void setClanovi(List<Clan> clanovi) {
        this.clanovi = clanovi;
    }
    
}
