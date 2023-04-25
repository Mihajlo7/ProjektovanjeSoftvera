/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Narudzbenica;
import domain.Stavka_Narudzbenice;
import exception.ServerskiException;
import java.util.List;

/**
 *
 * @author Mihajlo
 */
public class SOZapamtiNarudzbenicu extends OpstaSistemskaOperacija {
  private boolean uspesno;
  private Narudzbenica narudzbenica;

    public boolean isUspesno() {
        return uspesno;
    }

    public void setUspesno(boolean uspesno) {
        this.uspesno = uspesno;
    }

    public Narudzbenica getNarudzbenica() {
        return narudzbenica;
    }

    public void setNarudzbenica(Narudzbenica narudzbenica) {
        this.narudzbenica = narudzbenica;
    }

    @Override
    public void izvrsiKonkretnuOperaciju() throws ServerskiException {
        narudzbenica=(Narudzbenica) broker.izmeniObjekat(narudzbenica);
       // List<Stavka_Narudzbenice> stavke=narudzbenica.getStavkeNarudzbenice();
       // int sifra=1;
        //for(Stavka_Narudzbenice stavka:stavke){
         //   stavka.setSifra(sifra);
          //  sifra++;
          //  stavka=(Stavka_Narudzbenice) broker.sacuvajObjekat(stavka);
          //  if(stavka==null){
          //      uspesno=false;
          //  }
       // }
        uspesno=narudzbenica!=null?true:false;
    }
  
}
