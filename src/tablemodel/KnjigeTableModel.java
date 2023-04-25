/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemodel;

import domain.Knjiga;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mihajlo
 */
public class KnjigeTableModel extends AbstractTableModel {
    
    private List<Knjiga> knjige;
    private final String[] kolone={"Sifra","Naziv Knjige","Zanr","Autor"};

    public KnjigeTableModel(List<Knjiga> knjige) {
        this.knjige = knjige;
    }

    public KnjigeTableModel() {
        knjige=new LinkedList<>();
    }

    public List<Knjiga> getKnjige() {
        return knjige;
    }

    public void setKnjige(List<Knjiga> knjige) {
        this.knjige = knjige;
        this.fireTableDataChanged();
    }
    
    

    @Override
    public int getRowCount() {
        return knjige.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Knjiga knjiga=knjige.get(rowIndex);
        if(knjiga==null){
            return "neuspesno";
        }
        switch(columnIndex){
            case 0:
                return knjiga.getSifra();
            case 1:
                return knjiga.getNaziv();
            case 2:
                return knjiga.getZanr();
            case 3:
                return knjiga.getAutor();
            default:
                return "n/a";
        }
    }
    public void obrisiRed(int row,Knjiga knjiga){
        int index=vrateIndeks(knjiga);
        knjige.remove(index);
        fireTableRowsDeleted(row, row);
        
    }
    public int vratiSifru(int selected){
        return knjige.get(selected).getSifra();
    }
    public void azurirajRed(int row,Knjiga knjiga){
        int index=vrateIndeks(knjiga);
        knjige.set(index, knjiga);
        fireTableRowsUpdated(row, row);
    }

    private int vrateIndeks(Knjiga knjiga) {
        int index=0;
        for(Knjiga pom:knjige){
            if(pom.getSifra()==knjiga.getSifra()){
                break;
            }
            index++;
        }
        return index;
    }
    public void dodajRed(Knjiga knjiga){
        knjige.add(knjiga);
        fireTableDataChanged();
    }
}
