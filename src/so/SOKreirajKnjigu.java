/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Knjiga;
import exception.ServerskiException;

/**
 *
 * @author Mihajlo
 */
public class SOKreirajKnjigu extends OpstaSistemskaOperacija {
   private Knjiga knjiga;
   public SOKreirajKnjigu(){
       knjiga=new Knjiga();
   }
    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    @Override
    public void izvrsiKonkretnuOperaciju() throws ServerskiException {
        int sifra=broker.vratiPrviSlobodanKljuc(knjiga);
        System.out.println(sifra);
        knjiga=new Knjiga(sifra);
        knjiga=(Knjiga) broker.sacuvajObjekat(knjiga);
    }
   
}
