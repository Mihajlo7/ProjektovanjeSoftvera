/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemodel;

import domain.Knjiga;
import domain.Stavka_Narudzbenice;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mihajlo
 */
public class StavkeNarudzbineTableModel extends AbstractTableModel {
    private List<Stavka_Narudzbenice> stavke;
    private String[] kolone={"Sifra knjige","Naziv Knjige","Kolicina"};

    public StavkeNarudzbineTableModel() {
        stavke=new LinkedList<>();
    }

    public List<Stavka_Narudzbenice> getStavke() {
        return stavke;
    }

    public void setStavke(List<Stavka_Narudzbenice> stavke) {
        this.stavke = stavke;
    }
    
    @Override
    public int getRowCount() {
        return stavke.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(stavke==null){
            return "neucitano";
        }
        Stavka_Narudzbenice stavka=stavke.get(rowIndex);
        switch(columnIndex){
            case 0:
                return stavka.getKnjiga().getSifra();
            case 1:
                return stavka.getKnjiga().getNaziv();
            case 2:
                return stavka.getKolicina();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    public void dodajStavku(Stavka_Narudzbenice parametar,int selected){
        Stavka_Narudzbenice stavka=postojiStavka(parametar);
        if(stavka==null){
            stavke.add(parametar);
            fireTableRowsInserted(selected, selected);
        }else{
            stavka.setKolicina(stavka.getKolicina()+parametar.getKolicina());
            //stavka.setKolicina(stavka.getKolicina()+parametar.getKolicina());
            fireTableRowsUpdated(selected, selected);
        }
    }
    public void obrisiStavku(int selected){
        if(selected>-1){
            stavke.remove(selected);
            fireTableRowsDeleted(selected, selected);
        }
    }
    private Stavka_Narudzbenice postojiStavka(Stavka_Narudzbenice stavka){
        for(Stavka_Narudzbenice pom:stavke){
            if(pom.getKnjiga().getSifra()==stavka.getKnjiga().getSifra()){
                return pom;
            }
        }
        return null;
    }

   
    
}
