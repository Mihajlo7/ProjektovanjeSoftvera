/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import exception.ServerskiException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Mihajlo
 */
public class SOUcitajVrsteClanskihKarata extends OpstaSistemskaOperacija {
    private List<String> vrsteClanskihKarata;

    public SOUcitajVrsteClanskihKarata() {
        vrsteClanskihKarata=new LinkedList<>();
    }

    public List<String> getVrsteClanskihKarata() {
        return vrsteClanskihKarata;
    }

    public void setVrsteClanskihKarata(List<String> vrsteClanskihKarata) {
        this.vrsteClanskihKarata = vrsteClanskihKarata;
    }

    @Override
    public void izvrsiKonkretnuOperaciju() throws ServerskiException {
        vrsteClanskihKarata.add("Zaposlen");
        vrsteClanskihKarata.add("Student");
        vrsteClanskihKarata.add("Penzioner");
    }
    
}
