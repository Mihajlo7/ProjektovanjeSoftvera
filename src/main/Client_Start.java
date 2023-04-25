/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import domain.Bibliotekar;
import domain.Grad;
import forms.FrmLogin;
import forms.FrmMeni;

/**
 *
 * @author Mihajlo
 */
public class Client_Start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new FrmLogin(null, true).setVisible(true);
        //Bibliotekar admin=new Bibliotekar(3,"Bojan","Kovacevic","bojan.biblio.com","bojan0",new Grad(3,"Beograd"));
        //new FrmMeni(admin).setVisible(true);
    }
    
}
