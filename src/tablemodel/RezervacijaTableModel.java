/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemodel;

import domain.Rezervacija;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mihajlo
 */
public class RezervacijaTableModel extends AbstractTableModel {
    private List<Rezervacija> rezervacije;
    private String[] kolone={"Sifra Rezervacije","Aktivnost"};

    public RezervacijaTableModel() {
        rezervacije=new LinkedList<>();
    }

    @Override
    public int getRowCount() {
        return rezervacije.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(rezervacije==null){
            return "neucitano";
        }
        Rezervacija rezervacija=rezervacije.get(rowIndex);
        switch(columnIndex){
            case 0:
                return rezervacija.getSifra();
            case 1:
                if(rezervacija.isAktivnostRezervacije()){
                    return "Aktivna";
                }else{
                    return "Neaktivna";
                }
            default:
                return "n/1";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public List<Rezervacija> getRezervacije() {
        return rezervacije;
    }

    public void setRezervacije(List<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
        fireTableDataChanged();
    }
    
    
}
