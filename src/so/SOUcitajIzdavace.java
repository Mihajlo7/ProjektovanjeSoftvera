/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Izdavac;
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
public class SOUcitajIzdavace extends OpstaSistemskaOperacija {
    private List<Izdavac> izdavaci;

    public SOUcitajIzdavace() {
        izdavaci=new LinkedList<>();
    }
    

    public List<Izdavac> getIzdavaci() {
        return izdavaci;
    }
    
    public void setIzdavaci(List<Izdavac> izdavaci) {
        this.izdavaci = izdavaci;
    }

    @Override
    public void izvrsiKonkretnuOperaciju() throws ServerskiException {
        try {
            List<OpstiDomenskiObjekat> pom=broker.vratiObjekte("Izdavac");
            for(OpstiDomenskiObjekat odo:pom){
                if(odo!=null)
                    izdavaci.add((Izdavac) odo);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SOUcitajIzdavace.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(SOUcitajIzdavace.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(SOUcitajIzdavace.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SOUcitajIzdavace.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(SOUcitajIzdavace.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(SOUcitajIzdavace.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
