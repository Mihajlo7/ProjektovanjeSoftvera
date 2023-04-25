/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Bibliotekar;
import exception.ServerskiException;

/**
 *
 * @author Mihajlo
 */
public class SOPrijavaBibliotekara extends OpstaSistemskaOperacija {
    
    private Bibliotekar parametar;
    private Bibliotekar bibliotekar;

    public SOPrijavaBibliotekara() {
    }

    public Bibliotekar getParametar() {
        return parametar;
    }

    public void setParametar(Bibliotekar parametar) {
        this.parametar = parametar;
    }

    public Bibliotekar getBibliotekar() {
        return bibliotekar;
    }

    public void setBibliotekar(Bibliotekar bibliotekar) {
        this.bibliotekar = bibliotekar;
    }

    @Override
    public void izvrsiKonkretnuOperaciju() throws ServerskiException {
        bibliotekar=(Bibliotekar) broker.prijavi(parametar);
    }
    
}
