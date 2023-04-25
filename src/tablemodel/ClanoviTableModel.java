/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemodel;

import domain.Clan;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mihajlo
 */
public class ClanoviTableModel extends AbstractTableModel {
    private List<Clan> clanovi;
    private static String[] kolone={"Sifra","Ime i Prezime","Telefon","Vrsta Clanske karte","Aktivan"};

    public ClanoviTableModel(List<Clan> clanovi){
        this.clanovi=clanovi;
    }
    public ClanoviTableModel(){
        this.clanovi=new LinkedList<>();
    }
    @Override
    public int getRowCount() {
        return clanovi.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(clanovi==null){
            return "neucitano";
        }
        Clan clan=clanovi.get(rowIndex);
        switch(columnIndex){
            case 0:
                return clan.getSifra();
            case 1:
                return clan.getIme()+" "+clan.getPrezime();
            case 2:
                return clan.getTelefon();
            case 3:
                return clan.getVrstaClanskeKarte();
            case 4:
                if(clan.isAktivan()){
                    return "Aktivan";
                }else{
                    return "Neaktivan";
                }
            default:
                return "n/a";
        }
    }

    
    
    

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    
    public List<Clan> getClanovi() {
        return clanovi;
    }

    public void setClanovi(List<Clan> clanovi) {
        this.clanovi = clanovi;
        this.fireTableDataChanged();
    }

    public void azuriraj(int row,Clan clan) {
        int index=vratiIndex(clan);
        clanovi.set(index, clan);
        fireTableRowsUpdated(row, row);
      
    }

    private int vratiIndex(Clan clan){
        int index=0;
        for(Clan pom:clanovi){
            if(clan.getSifra()==pom.getSifra()){
                break;
            }
            index++;
        }
        return index;
    }

    public int vratiSifru(int selected) {
        return clanovi.get(selected).getSifra();
    }
    public Clan vratiClana(int selected){
        return clanovi.get(selected);
    }    
}
