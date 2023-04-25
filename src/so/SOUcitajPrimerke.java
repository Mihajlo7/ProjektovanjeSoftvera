/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Knjiga;
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
public class SOUcitajPrimerke extends OpstaSistemskaOperacija {
    private List<Knjiga> primerci;

    public SOUcitajPrimerke() {
        primerci=new LinkedList<>();
    }

    public List<Knjiga> getPrimerci() {
        return primerci;
    }

    public void setPrimerci(List<Knjiga> primerci) {
        this.primerci = primerci;
    }

    @Override
    public void izvrsiKonkretnuOperaciju() throws ServerskiException {
        try {
            List<OpstiDomenskiObjekat> lista=broker.vratiObjekte("Primerak");
            for(OpstiDomenskiObjekat odo:lista){
                if(odo!=null){
                    primerci.add((Knjiga) odo);
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SOUcitajPrimerke.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(SOUcitajPrimerke.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(SOUcitajPrimerke.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SOUcitajPrimerke.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(SOUcitajPrimerke.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(SOUcitajPrimerke.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
