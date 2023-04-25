/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forms;

import controller.OpstiKontrolerKI;
import domain.Bibliotekar;
import domain.Dobavljac;
import domain.Knjiga;
import domain.Narudzbenica;
import domain.Stavka_Narudzbenice;
import exception.ServerskiException;
import java.awt.Font;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import tablemodel.KnjigeTableModel;
import tablemodel.StavkeNarudzbineTableModel;

/**
 *
 * @author Mihajlo
 */
public class FrmOrder extends javax.swing.JDialog {

    /**
     * Creates new form FrmOrder
     */
    private Bibliotekar bibliotekar;
    private Narudzbenica narudzbenica;

    public Bibliotekar getBibliotekar() {
        return bibliotekar;
    }

    public void setBibliotekar(Bibliotekar bibliotekar) {
        this.bibliotekar = bibliotekar;
    }
    public FrmOrder(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Kreiranje narudzbenice");
        namestiPolja();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtSifraNarudzbenice = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDatumNarucuvanja = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableKnjige = new javax.swing.JTable();
        btnDodajStavku = new javax.swing.JButton();
        btnOduzmiStavku = new javax.swing.JButton();
        btnZapamtiNarudzbinu = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableStavkeNarudzbenice = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        comboDobavljaci = new javax.swing.JComboBox<>();
        btnKreirajRez = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBack.setText("Nazad");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Sifra narudzbine:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Datum narucuvanja:");

        tableKnjige.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableKnjige);

        btnDodajStavku.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDodajStavku.setText("Dodaj stavku");
        btnDodajStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajStavkuActionPerformed(evt);
            }
        });

        btnOduzmiStavku.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnOduzmiStavku.setText("Oduzmi stavku");
        btnOduzmiStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOduzmiStavkuActionPerformed(evt);
            }
        });

        btnZapamtiNarudzbinu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnZapamtiNarudzbinu.setText("Zapamti narudzbinu");
        btnZapamtiNarudzbinu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZapamtiNarudzbinuActionPerformed(evt);
            }
        });

        tableStavkeNarudzbenice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tableStavkeNarudzbenice);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Dobavljac:");

        comboDobavljaci.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboDobavljaci.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnKreirajRez.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnKreirajRez.setText("Kreiraj narudzbinu");
        btnKreirajRez.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKreirajRezActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(55, 55, 55)
                                        .addComponent(txtSifraNarudzbenice, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(33, 33, 33)
                                .addComponent(txtDatumNarucuvanja, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 865, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboDobavljaci, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDodajStavku, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnOduzmiStavku, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnZapamtiNarudzbinu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnKreirajRez, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(75, 75, 75)))
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtSifraNarudzbenice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDatumNarucuvanja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDodajStavku, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOduzmiStavku, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(btnKreirajRez, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnZapamtiNarudzbinu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(comboDobavljaci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        if(narudzbenica==null){
            dispose();
        }else{
        int option=JOptionPane.showConfirmDialog(this,"Da li ste sigurni da hocete da izadjete!","Izlazak",JOptionPane.WARNING_MESSAGE);
        if(option==0){
            try {
                obrisiNarudzbenicu();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex,"GRESKA",JOptionPane.ERROR_MESSAGE);
            }
        }
        dispose();
        }
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnDodajStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajStavkuActionPerformed
        // TODO add your handling code here:
       try{
          int selected=tableKnjige.getSelectedRow();
          if(selected>-1){
              KnjigeTableModel modelKnjige=(KnjigeTableModel) tableKnjige.getModel();
              StavkeNarudzbineTableModel modelStavke=(StavkeNarudzbineTableModel) tableStavkeNarudzbenice.getModel();
              Knjiga knjiga=modelKnjige.getKnjige().get(selected);
              String kol=JOptionPane.showInputDialog(this, "Unesite kolicinu za knjigu:"+knjiga.getNaziv());
              int kolicina=Integer.parseInt(kol);
              if(kolicina>0){
              Stavka_Narudzbenice stavka=new Stavka_Narudzbenice(narudzbenica.getSifra(), kolicina, knjiga);
              modelStavke.dodajStavku(stavka, selected);
              }else{
                  JOptionPane.showMessageDialog(this, "Ne sme biti dodato 0 knjiga!","Upozorenje",JOptionPane.WARNING_MESSAGE);
              }
          }else{
              JOptionPane.showMessageDialog(this, "Morate selektovati knjigu","Selektujte knjigu",JOptionPane.WARNING_MESSAGE);
          }
       } catch(NumberFormatException ex){
           JOptionPane.showMessageDialog(this,"Morate uneti cifru","GRESKA",JOptionPane.ERROR_MESSAGE);
       }
        
    }//GEN-LAST:event_btnDodajStavkuActionPerformed

    private void btnOduzmiStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOduzmiStavkuActionPerformed
        // TODO add your handling code here:
        int selected=tableStavkeNarudzbenice.getSelectedRow();
        if(selected>-1){
          StavkeNarudzbineTableModel modelStavke=(StavkeNarudzbineTableModel) tableStavkeNarudzbenice.getModel();
          modelStavke.obrisiStavku(selected);
        }else{
            JOptionPane.showMessageDialog(this,"Morate selektovati stavku narudzbenice","Selektujte stavku",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnOduzmiStavkuActionPerformed

    private void btnZapamtiNarudzbinuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZapamtiNarudzbinuActionPerformed
        // TODO add your handling code here:
        if(proveriPolja()){
            LocalDate datumNarucivanja=vratiDatumVracanja();
            narudzbenica.setDatum(datumNarucivanja);
            narudzbenica.setAdmin(bibliotekar);
            narudzbenica.setDobavljac((Dobavljac) comboDobavljaci.getSelectedItem());
            StavkeNarudzbineTableModel model=(StavkeNarudzbineTableModel) tableStavkeNarudzbenice.getModel();
            narudzbenica.setStavkeNarudzbenice(model.getStavke());
            try {
                zapamtiNaruzbenicu();
                int option=JOptionPane.showConfirmDialog(this, "Da li hocete da kreirate jos narudzbina?","Kreiraj narudzbinu",JOptionPane.YES_NO_OPTION);
                if(option==0){
                    kreirajNarudzbenicu();
                    refresujPolja();
                }else{
                    dispose();
                }
            } catch (ServerskiException ex) {
                JOptionPane.showMessageDialog(this, ex,"GRESKA",JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex){
                JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti narudzbenicu","GRESKA",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnZapamtiNarudzbinuActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if(narudzbenica==null){
           dispose(); 
        }else{
        JOptionPane.showMessageDialog(this, "Podaci ce biti obrisani","Izlazak",JOptionPane.WARNING_MESSAGE);
        try {
            obrisiNarudzbenicu();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex,"GRESKA",JOptionPane.ERROR_MESSAGE);
        }
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnKreirajRezActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKreirajRezActionPerformed
        try {
            // TODO add your handling code here:
            kreirajNarudzbenicu();
            podesiPolja(true);
            setNarudzbenica();
            KnjigeTableModel model=new KnjigeTableModel();
        model.setKnjige(OpstiKontrolerKI.getInstance().ucitajKnjige());
        tableKnjige.setFont(new Font("Serif",Font.PLAIN,14));
        tableKnjige.setModel(model);
        StavkeNarudzbineTableModel modelStavke=new StavkeNarudzbineTableModel();
        tableStavkeNarudzbenice.setFont(new Font("Serif",Font.PLAIN,14));
        tableStavkeNarudzbenice.setModel(modelStavke);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da kreira narudzbenicu");
        }
    }//GEN-LAST:event_btnKreirajRezActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDodajStavku;
    private javax.swing.JButton btnKreirajRez;
    private javax.swing.JButton btnOduzmiStavku;
    private javax.swing.JButton btnZapamtiNarudzbinu;
    private javax.swing.JComboBox<String> comboDobavljaci;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableKnjige;
    private javax.swing.JTable tableStavkeNarudzbenice;
    private javax.swing.JTextField txtDatumNarucuvanja;
    private javax.swing.JTextField txtSifraNarudzbenice;
    // End of variables declaration//GEN-END:variables

    private void namestiPolja() {
        try {
            txtSifraNarudzbenice.setEnabled(false);
            //LocalDate datum=LocalDate.now();
           // txtDatumNarucuvanja.setText(datum.toString());
            namestiTabelu();
            namestiCombo();
            comboDobavljaci.setSelectedIndex(-1);
            podesiPolja(false);
            //kreirajNarudzbenicu();
            //setNarudzbenica();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex,"GRESKA",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void namestiCombo() throws Exception {
        DefaultComboBoxModel model=new DefaultComboBoxModel(OpstiKontrolerKI.getInstance().ucitajDobavljace().toArray());
        comboDobavljaci.setModel(model);
    }

    private void namestiTabelu() throws Exception {
        KnjigeTableModel model=new KnjigeTableModel();
        ///modeletKnjige(OpstiKontrolerKI.getInstance().ucitajKnjige());
        tableKnjige.setFont(new Font("Serif",Font.PLAIN,14));
        tableKnjige.setModel(model);
        StavkeNarudzbineTableModel modelStavke=new StavkeNarudzbineTableModel();
        tableStavkeNarudzbenice.setFont(new Font("Serif",Font.PLAIN,14));
        tableStavkeNarudzbenice.setModel(modelStavke);
    }
    private void napuniTabelu() throws Exception{
        KnjigeTableModel model=(KnjigeTableModel) tableKnjige.getModel();
        model.setKnjige(OpstiKontrolerKI.getInstance().ucitajKnjige());
    }

    private void kreirajNarudzbenicu() throws Exception {
        narudzbenica=new Narudzbenica();
        narudzbenica=OpstiKontrolerKI.getInstance().kreirajNarudzbenicu(narudzbenica);
        if(narudzbenica!=null){
            JOptionPane.showMessageDialog(this,"Uspesno je kreirana narudzbenica sa sifrom:"+narudzbenica.getSifra());
        }
        LocalDate datum=LocalDate.now();
        txtDatumNarucuvanja.setText(datum.toString());
    }

    private void setNarudzbenica() {
        txtSifraNarudzbenice.setText(String.valueOf(narudzbenica.getSifra()));
    }

    private void obrisiNarudzbenicu() throws Exception {
        boolean uspesno=OpstiKontrolerKI.getInstance().obrisiNarudzbenicu(narudzbenica);
        if(uspesno){
            JOptionPane.showMessageDialog(this, "Uspesno su obrisani podaci o narudzbenici");
        }
    }
    private LocalDate vratiDatumVracanja()throws NumberFormatException,DateTimeException{
        LocalDate datum=null;
        String[] datumString=txtDatumNarucuvanja.getText().split("-");
        if(datumString.length==3){
            datum=LocalDate.of(Integer.parseInt(datumString[0]), Integer.parseInt(datumString[1]), Integer.parseInt(datumString[2]));
        }
        return datum;
    }
    private boolean proveriPolja(){
        boolean uspesno=true;
        if(txtDatumNarucuvanja.getText().isEmpty()){
            uspesno=false;
            JOptionPane.showMessageDialog(this, "Morate popuniti polje za datum!","Datum Narucivanja",JOptionPane.WARNING_MESSAGE);
        }else{
            try{
            LocalDate datum=vratiDatumVracanja();
            if(datum==null){
                uspesno=false;
               JOptionPane.showMessageDialog(this, "Morate uneti datum u formatu gggg-mm-yy !","Unosenje datuma",JOptionPane.WARNING_MESSAGE);
            }
            } catch(NumberFormatException | DateTimeException ex){
                uspesno=false;
               JOptionPane.showMessageDialog(this, ex,"GRESKA",JOptionPane.ERROR_MESSAGE);
            }
        }
        int selected=comboDobavljaci.getSelectedIndex();
        if(selected==-1){
            uspesno=false;
            JOptionPane.showMessageDialog(this, "Morate izabrati dobavljaca","Odabir dobavljaca",JOptionPane.WARNING_MESSAGE);
        }
        StavkeNarudzbineTableModel model=(StavkeNarudzbineTableModel) tableStavkeNarudzbenice.getModel();
        if(model.getStavke().isEmpty()){
            uspesno=false;
            JOptionPane.showMessageDialog(this, "Morate imati bar jednu stavku narudzbenice","Stavke Narudzbenice",JOptionPane.WARNING_MESSAGE);
        }
        return uspesno;
    }

    private void zapamtiNaruzbenicu() throws Exception {
        boolean uspesno=OpstiKontrolerKI.getInstance().zapamtiNarudzbenicu(narudzbenica);
        if(uspesno){
            JOptionPane.showMessageDialog(this,"Uspesno su zapamceni podaci o narudzbenici!");
        }
    }

    private void podesiPolja(boolean b) {
        //txtSifraNarudzbenice.setEditable(b);
        txtDatumNarucuvanja.setEditable(b);
        //namestiPolja();
        btnKreirajRez.setEnabled(!b);
        btnZapamtiNarudzbinu.setEnabled(b);
        btnDodajStavku.setEnabled(b);
        btnOduzmiStavku.setEnabled(b);
        comboDobavljaci.setEnabled(b);
        
    }

    private void refresujPolja() throws Exception {
        //namestiPolja();
        LocalDate datum=LocalDate.now();
        txtDatumNarucuvanja.setText(datum.toString());
        namestiTabelu();
        napuniTabelu();
        comboDobavljaci.setSelectedIndex(-1);
        
    }
}