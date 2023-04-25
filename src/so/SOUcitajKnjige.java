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
public class SOUcitajKnjige extends OpstaSistemskaOperacija {
    private List<Knjiga> knjige;

    public SOUcitajKnjige() {
        knjige=new LinkedList<>();
    }

    public List<Knjiga> getKnjige() {
        return knjige;
    }

    public void setKnjige(List<Knjiga> knjige) {
        this.knjige = knjige;
    }

    @Override
    public void izvrsiKonkretnuOperaciju() throws ServerskiException {
        try {
            List<OpstiDomenskiObjekat> lista=broker.vratiObjekte("Knjiga");
            for(OpstiDomenskiObjekat odo:lista){
                if(odo!=null){
                    System.out.println(odo.getPrimaryKeyName()+":"+odo.getPrimaryKeyValue());
                    knjige.add((Knjiga)odo);
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SOUcitajKnjige.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(SOUcitajKnjige.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(SOUcitajKnjige.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SOUcitajKnjige.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(SOUcitajKnjige.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(SOUcitajKnjige.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
