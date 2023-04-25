/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Clan;
import domain.OpstiDomenskiObjekat;
import exception.ServerskiException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mihajlo
 */
public class SOProveriEmail extends OpstaSistemskaOperacija {

    private String parametar;
    private boolean uspesno;

    public String getParametar() {
        return parametar;
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
    }

    public boolean isUspesno() {
        return uspesno;
    }

    public void setUspesno(boolean uspesno) {
        this.uspesno = uspesno;
    }
    
    @Override
    public void izvrsiKonkretnuOperaciju() throws ServerskiException {
        try {
            List<OpstiDomenskiObjekat> lista=broker.vratiObjekte("Clan");
            for(OpstiDomenskiObjekat odo:lista){
                Clan clan=(Clan) odo;
                if(clan.getEmail().equals(parametar)){
                    uspesno=false;
                    return;
                }
            }
            uspesno=true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SOProveriEmail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(SOProveriEmail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(SOProveriEmail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SOProveriEmail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(SOProveriEmail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(SOProveriEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
