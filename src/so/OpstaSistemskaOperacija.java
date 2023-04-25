/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import exception.ServerskiException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mihajlo
 */
public abstract class OpstaSistemskaOperacija {
    DBBroker broker;

    public OpstaSistemskaOperacija() {
        this.broker=new DBBroker();
    }
    
    public void izvrsiOperaciju() throws ServerskiException{
        try {
            uspostaviKonekciju();
            izvrsiKonkretnuOperaciju();
            potvrdiTransakciju();
        } catch (ServerskiException ex) {
            ponistiTransakciju();
            throw ex;
        }finally{
            zatvoriKonekciju();
        }
        
    }

    private void uspostaviKonekciju()throws ServerskiException {
        broker.uspostaviKonekciju();
    }

    public abstract void izvrsiKonkretnuOperaciju() throws ServerskiException; 

    private void potvrdiTransakciju() throws ServerskiException {
        broker.potvrdiTransakciju();
    }

    private void ponistiTransakciju() throws ServerskiException {
        broker.ponistiTransakciju();
    }

    private void zatvoriKonekciju() throws ServerskiException {
        broker.zatvoriKonekciju();
    }
}
