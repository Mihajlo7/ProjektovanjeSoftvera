/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Clan;
import exception.ServerskiException;

/**
 *
 * @author Mihajlo
 */
public class SOPrijaviClana extends OpstaSistemskaOperacija {
  private Clan clan;
  private Clan parametar;

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public Clan getParametar() {
        return parametar;
    }

    public void setParametar(Clan parametar) {
        this.parametar = parametar;
    }

    @Override
    public void izvrsiKonkretnuOperaciju() throws ServerskiException {
        clan=(Clan) broker.prijavi(parametar);
    }
  
}
