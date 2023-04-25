/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Grad;
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
public class SOUcitajGradove extends OpstaSistemskaOperacija {
   
    private List<Grad> gradovi;

    public List<Grad> getGradovi() {
        return gradovi;
    }

    public SOUcitajGradove() {
        this.gradovi=new LinkedList<>();
    }

    public void setGradovi(List<Grad> gradovi) {
        this.gradovi = gradovi;
    }

    @Override
    public void izvrsiKonkretnuOperaciju() throws ServerskiException {
        try {
            //Grad grad=new Grad();
            List<OpstiDomenskiObjekat> pomocni=broker.vratiObjekte("Grad");
            for(OpstiDomenskiObjekat odo:pomocni){
                if(odo!=null){
                    Grad pom=(Grad)odo;
                    gradovi.add(pom);
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SOUcitajGradove.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(SOUcitajGradove.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(SOUcitajGradove.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SOUcitajGradove.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(SOUcitajGradove.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(SOUcitajGradove.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
