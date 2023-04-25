/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package forms;

import controller.OpstiKontrolerKI;
import domain.Clan;
import exception.ServerskiException;
import java.awt.Font;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import mods.MemberMod;
import tablemodel.ClanoviTableModel;

/**
 *
 * @author Mihajlo
 */
public class FrmMember extends javax.swing.JDialog {

    /**
     * Creates new form FrmMember
     */
    public FrmMember() {
        initComponents();
        setSize(1200, 1000);
        postaviClanove();
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
        btnCreateMember = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIndicator = new javax.swing.JTextField();
        txtFirstName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        txtTelNumber = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMember = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        checkAktivnost = new javax.swing.JCheckBox();
        btnDetailsMember = new javax.swing.JButton();
        btnGetMember = new javax.swing.JButton();
        btnActivateMemberShip = new javax.swing.JButton();

        btnBack.setText("Nazad na glavnu formu");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnCreateMember.setText("Kreiraj novog člana");
        btnCreateMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateMemberActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Odaberite kriterijum i vrednost pretrage članova:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Šifra člana: ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Ime:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Prezime: ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Telefon:");

        txtTelNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelNumberActionPerformed(evt);
            }
        });

        tableMember.setModel(new javax.swing.table.DefaultTableModel(
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
        tableMember.setRowHeight(30);
        jScrollPane1.setViewportView(tableMember);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Članstvo Aktivno: ");

        btnDetailsMember.setText("Detalji odabranog člana");
        btnDetailsMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailsMemberActionPerformed(evt);
            }
        });

        btnGetMember.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnGetMember.setText("Pretraži članove");
        btnGetMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetMemberActionPerformed(evt);
            }
        });

        btnActivateMemberShip.setText("Aktiviraj članstvo");
        btnActivateMemberShip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivateMemberShipActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIndicator)
                            .addComponent(txtFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtLastName)
                            .addComponent(txtTelNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(checkAktivnost)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGetMember, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDetailsMember, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActivateMemberShip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtTelNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetailsMember, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkAktivnost)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnGetMember, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActivateMemberShip, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCreateMember, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCreateMember, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnDetailsMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailsMemberActionPerformed
        // TODO add your handling code here:
        int selected=tableMember.getSelectedRow();
        if(selected==-1){
            JOptionPane.showMessageDialog(this, "Morate odabrati jednog clana!","Upozorenje",JOptionPane.CLOSED_OPTION);
        }else if(proveriAktivnost(selected)){
            try{
            Clan clan=ucitajClana(selected);
            FrmMemberDetails fmr=new FrmMemberDetails(clan, MemberMod.CHANGE_MOD,this);
            fmr.setVisible(true);
            dispose();
            JOptionPane.showMessageDialog(this,"Ucitan je clan sa sifrom:"+clan.getSifra());
            } catch(Exception ex){
                JOptionPane.showMessageDialog(this,"Sistem ne moze da ucita clana","GRESKA",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Da bi ste videli podatke clana, on mora biti aktivan clan","Aktivnost clana",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDetailsMemberActionPerformed

    private void txtTelNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelNumberActionPerformed

    private void btnGetMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetMemberActionPerformed
        // TODO add your handling code here:
        HashMap<String,String> kriterijum=new HashMap<>();
        if(!txtFirstName.getText().isEmpty()){
            kriterijum.put("imeClana",txtFirstName.getText());
        }
        if(!txtIndicator.getText().isEmpty()){
            kriterijum.put("sifraClana",txtIndicator.getText());
        }
        if(!txtLastName.getText().isEmpty()){
            kriterijum.put("prezimeClana",txtLastName.getText());
        }
        if(!txtTelNumber.getText().isEmpty()){
            kriterijum.put("telefonClana",txtTelNumber.getText());
        }
        if(checkAktivnost.isSelected()){
            kriterijum.put("aktivnostClanstva","1");
        }
        
        try {
            //((ClanoviTableModel)tableMember.getModel()).setClanovi(OpstiKontrolerKI.getInstance().nadjiClanove(kriterijum));
            ucitajClanove(kriterijum);
        } catch(ServerskiException ex){
            JOptionPane.showMessageDialog(this,ex,"GRESKA",JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            //Logger.getLogger(FrmMember.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"Sistem ne moze da nadji clanove po zadatom kriterijumu","GRESKA",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnGetMemberActionPerformed

    private void btnCreateMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateMemberActionPerformed
        // TODO add your handling code here:
        new FrmMemberDetails(null,MemberMod.CREATE_MOD,this).setVisible(true);
    }//GEN-LAST:event_btnCreateMemberActionPerformed

    private void btnActivateMemberShipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivateMemberShipActionPerformed
        // TODO add your handling code here:
        int selected=tableMember.getSelectedRow();
        if(selected==-1){
            JOptionPane.showMessageDialog(this, "Morate selektovati jednog clana","Izaberite igraca",JOptionPane.CANCEL_OPTION);
        }else{
            Clan clan=((ClanoviTableModel)tableMember.getModel()).getClanovi().get(selected);
            if(clan.isAktivan()){
                JOptionPane.showMessageDialog(this, "Ovaj clan je aktivan clan, ne mozete aktivirati clanstvo","Clanstvo",JOptionPane.CANCEL_OPTION);
            }else{
                try {
                    boolean uspesno=OpstiKontrolerKI.getInstance().aktivirajClanstvo(clan);
                    if(uspesno){
                        JOptionPane.showMessageDialog(this, "Clan "+clan.getIme()+" "+clan.getPrezime(),"Aktivno clanstvo",JOptionPane.INFORMATION_MESSAGE);
                        //azurirajTabelu(clan);
                        //postaviClanove();
                        ((ClanoviTableModel)tableMember.getModel()).azuriraj(selected,clan);
                    }
                } catch (ServerskiException ex) {
                    JOptionPane.showMessageDialog(this, ex,"GRESKA",JOptionPane.ERROR_MESSAGE);
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(this,"Prekid rada servera","GRESKA",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnActivateMemberShipActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActivateMemberShip;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreateMember;
    private javax.swing.JButton btnDetailsMember;
    private javax.swing.JButton btnGetMember;
    private javax.swing.JCheckBox checkAktivnost;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableMember;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtIndicator;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtTelNumber;
    // End of variables declaration//GEN-END:variables

    public void postaviClanove() {
        try {
            tableMember.setFont(new Font("Serif",Font.PLAIN,14));
            ClanoviTableModel tableClanovi=new ClanoviTableModel();
            tableClanovi.setClanovi(OpstiKontrolerKI.getInstance().ucitajSveClanove());
            tableMember.setModel(tableClanovi);
        }catch (ServerskiException ex){
            JOptionPane.showMessageDialog(this, ex,"GRESKA",JOptionPane.ERROR_MESSAGE);
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Doslo je do prekida rada servera!","GRESKA",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void ucitajClanove(HashMap<String, String> kriterijum) throws Exception {
        List<Clan> clanovi=OpstiKontrolerKI.getInstance().nadjiClanove(kriterijum);
        ((ClanoviTableModel)tableMember.getModel()).setClanovi(clanovi);
        JOptionPane.showMessageDialog(this, "Sistem je nasao "+clanovi.size()+" koji zadovoljavaju kriterijum");
    }

    private Clan ucitajClana(int selected) throws Exception {
        ClanoviTableModel model=(ClanoviTableModel)tableMember.getModel();
        int sifra=model.vratiSifru(selected);
        Clan clan=OpstiKontrolerKI.getInstance().ucitajClana(sifra);
        return clan;
    }

    private boolean proveriAktivnost(int selected) {
        ClanoviTableModel model=(ClanoviTableModel) tableMember.getModel();
        Clan clan=model.vratiClana(selected);
        return clan.isAktivan();
    }

    
}