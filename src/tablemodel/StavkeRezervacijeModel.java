/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemodel;

import domain.Stavka_Rezervacije;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mihajlo
 */
public class StavkeRezervacijeModel extends AbstractTableModel {
    private List<Stavka_Rezervacije> stavke_rezervacije;
    private String[] kolone={"Sifra Stavke","Sifra Knjige","Naziv knjige"};

    public StavkeRezervacijeModel() {
        this.stavke_rezervacije=new LinkedList<>();
    }

    @Override
    public int getRowCount() {
        return stavke_rezervacije.size();
    }

    @Override
    public int getColumnCount() {
       return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(stavke_rezervacije==null){
            return "neucitano";
        }
        Stavka_Rezervacije stavka=stavke_rezervacije.get(rowIndex);
        switch(columnIndex){
            case 0:
                return stavka.getSifra();
            case 1:
                return stavka.getKnjiga().getSifra();
            case 2:
                return stavka.getKnjiga().getNaziv();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public List<Stavka_Rezervacije> getStavke_rezervacije() {
        return stavke_rezervacije;
    }

    public void setStavke_rezervacije(List<Stavka_Rezervacije> stavke_rezervacije) {
        this.stavke_rezervacije = stavke_rezervacije;
        fireTableDataChanged();
    }
    
}
