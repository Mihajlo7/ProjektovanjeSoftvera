/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Rezervacija;
import domain.Stavka_Rezervacije;
import exception.ServerskiException;
import java.util.List;

/**
 *
 * @author Mihajlo
 */
public class SOZapamtiRezervaciju extends OpstaSistemskaOperacija {
    private Rezervacija rezervacija;
    private boolean uspesno;

    public Rezervacija getRezervacija() {
        return rezervacija;
    }

    public void setRezervacija(Rezervacija rezervacija) {
        this.rezervacija = rezervacija;
    }

    public boolean isUspesno() {
        return uspesno;
    }

    public void setUspesno(boolean uspesno) {
        this.uspesno = uspesno;
    }

    @Override
    public void izvrsiKonkretnuOperaciju() throws ServerskiException {
        rezervacija=(Rezervacija) broker.izmeniObjekat(rezervacija);
       // List<Stavka_Rezervacije> stavke=rezervacija.getStavkeRezervacije();
       // int sifra=1;
       // for(Stavka_Rezervacije stavka:stavke){
        //  stavka.setSifra(sifra);
        //  sifra++;
         // stavka=(Stavka_Rezervacije) broker.sacuvajObjekat(stavka);
         // if(stavka==null){
          //    uspesno=false;
         // }
       // }
        uspesno=rezervacija==null?false:true;
    }
    
}
