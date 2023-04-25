/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Dobavljac;
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
public class SOUcitajDobavljace extends OpstaSistemskaOperacija {
    private List<Dobavljac> dobavljaci;

    public SOUcitajDobavljace() {
        dobavljaci=new LinkedList<>();
    }

    public List<Dobavljac> getDobavljaci() {
        return dobavljaci;
    }

    public void setDobavljaci(List<Dobavljac> dobavljaci) {
        this.dobavljaci = dobavljaci;
    }

    @Override
    public void izvrsiKonkretnuOperaciju() throws ServerskiException {
        try {
            List<OpstiDomenskiObjekat> lista=broker.vratiObjekte("Dobavljac");
            for(OpstiDomenskiObjekat odo:lista){
                if(odo!=null){
                    dobavljaci.add((Dobavljac) odo);
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SOUcitajDobavljace.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(SOUcitajDobavljace.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(SOUcitajDobavljace.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SOUcitajDobavljace.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(SOUcitajDobavljace.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(SOUcitajDobavljace.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
