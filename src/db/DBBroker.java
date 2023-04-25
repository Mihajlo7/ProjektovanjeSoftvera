/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

/**
 *
 * @author Mihajlo
 */
import domain.Bibliotekar;
import domain.Clan;
import domain.Dobavljac;
import domain.Grad;
import domain.Izdavac;
import domain.Knjiga;
import domain.Narudzbenica;
import domain.OpstiDomenskiObjekat;
import domain.Rezervacija;
import domain.Stavka_Narudzbenice;
import domain.Stavka_Rezervacije;
import exception.ServerskiException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import so.OpstaSistemskaOperacija;
public class DBBroker {
    private Connection connection;
    
    public void uspostaviKonekciju() throws ServerskiException{
        try {
            String url=Util.getInstance().getUrl();
            String username=Util.getInstance().getUsername();
            String password=Util.getInstance().getPassword();
            connection=DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
            System.out.println("Uspesna konekcija sa bazom!!");
        } catch (IOException ex) {
            throw new ServerskiException("Greska prilikom citanja Properties file");
        } catch (SQLException ex) {
            throw new ServerskiException("Greska prilikom pokretanja konekcije");
        }
    }
    public void zatvoriKonekciju() throws ServerskiException{
        try {
            connection.close();
        } catch (SQLException ex) {
            throw new ServerskiException("Neuspesno zatvaranje konekcije!");
        }
    }
    public void potvrdiTransakciju() throws ServerskiException{
        try {
            connection.commit();
        } catch (SQLException ex) {
            throw new ServerskiException("Nespesna potvrda transakcije!");
        }
    }
    public void ponistiTransakciju() throws ServerskiException{
        try {
            connection.rollback();
        } catch (SQLException ex) {
            throw new ServerskiException("Neuspesna ponistenje transakcije!");
        }
    }
    
    public OpstiDomenskiObjekat prijavi(OpstiDomenskiObjekat parametar) throws ServerskiException{
        OpstiDomenskiObjekat odo=null;
        try {
            String upit="SELECT * FROM "+parametar.getClassName();
            if(parametar instanceof Bibliotekar){
                upit+=" WHERE";
                Bibliotekar bibliotekar=(Bibliotekar) parametar;
                upit+=bibliotekar.getLogin();
               
            }
            if(parametar instanceof Clan){
                 upit+=" INNER JOIN grad ON clan.sifraGrada=grad.sifraGrada";
                upit+=" WHERE";
                Clan clan=(Clan) parametar;
                upit+=clan.getLogin();
               
            }
            System.out.println(upit);
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery(upit);
           // rs.beforeFirst();
           if(parametar instanceof Bibliotekar){
              odo=parametar.getObjectFromResultSet(rs);
           }else{
               if(rs.next()){
                  odo=parametar.getObjectFromResultSet(rs); 
               }
           }
            
            
            if(odo==null){
                System.out.println("1");
            }
            //System.out.println("Uspesno ucitan bibliotekar sa sifrom:"+bibliotekar.getSifra());
            return odo;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ServerskiException("Neuspesna prijava !");
        }
        
    }
    public List<OpstiDomenskiObjekat> vratiObjekte(String nazivKlase) throws ServerskiException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        List<OpstiDomenskiObjekat> objekti=new LinkedList<>();
        boolean primerak=false;
        if(nazivKlase.equals("Primerak")){
            primerak=true;
            nazivKlase="Knjiga";
        }
        try {
            Class<?> loadClass=Class.forName("domain."+nazivKlase);
            Constructor<?> cons=loadClass.getDeclaredConstructor();
            OpstiDomenskiObjekat odo=(OpstiDomenskiObjekat)cons.newInstance();
            //OpstiDomenskiObjekat odo=Class.forName("domain."+nazivKlase).;
            
            //System.out.println("Naziv klase:"+odo.getClassName());
            
            
            String upit="SELECT * FROM "+odo.getClassName();
            if(odo instanceof Izdavac){
                upit+=" INNER JOIN grad ON izdavac.sifraGrada=grad.sifraGrada";
            }
            if(odo instanceof Dobavljac){
                upit+=" INNER JOIN grad ON dobavljac.sifraGrada=grad.sifraGrada";
            }
            if(odo instanceof Clan){
               upit+=" INNER JOIN grad ON clan.sifraGrada=grad.sifraGrada ORDER BY sifraClana ASC"; 
            }
            if(odo instanceof Knjiga && !primerak){
               upit+=" INNER JOIN izdavac ON knjiga.sifraIzdavaca=izdavac.sifraIzdavaca GROUP BY nazivKnjige"; 
            }
            if( odo instanceof Knjiga && primerak){
                //upit="SELECT DISTINCT * FROM knjiga";
                upit+=" INNER JOIN izdavac ON knjiga.sifraIzdavaca=izdavac.sifraIzdavaca";
            }
            System.out.println(upit);
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery(upit);
            while(rs.next()){
               OpstiDomenskiObjekat pom=odo.getObjectFromResultSet(rs);
               objekti.add(pom);
            }
            System.out.println("1");
            return objekti;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ServerskiException("Neuspesno vracanje liste objekata:");
        }
    }
    
    public int vratiPrviSlobodanKljuc(OpstiDomenskiObjekat odo) throws ServerskiException{
        try {
            String upit="SELECT MAX("+odo.getPrimaryKeyName()+") as kljuc FROM "+odo.getClassName()+" WHERE TRUE";
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery(upit);
            if(rs.next()){
               return rs.getInt("kljuc")+1;
            }
            return 1;
        } catch (SQLException ex) {
            throw new ServerskiException("Neuspesno vracanje novog primarnog kljuca!");
        }
    }
    public OpstiDomenskiObjekat ucitajObjekat(OpstiDomenskiObjekat odo) throws ServerskiException{
        OpstiDomenskiObjekat rez=null;
        String upit="SELECT * FROM "+odo.getClassName();
        if(odo instanceof Clan){
            upit+=" INNER JOIN grad ON clan.sifraGrada=grad.sifraGrada";
        }
        if(odo instanceof Knjiga){
            upit+=" INNER JOIN izdavac ON knjiga.sifraIzdavaca=izdavac.sifraIzdavaca";
        }
        upit+=" WHERE "+odo.getPrimaryKeyName()+"="+odo.getPrimaryKeyValue();
        System.out.println(upit);
        try {
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery(upit);
            if(rs.next()){
                rez=odo.getObjectFromResultSet(rs);
            }
            return rez;
        } catch (SQLException ex) {
            throw new ServerskiException("Neuspesna opcija ucitavanja objekata");
        }
    }
    public OpstiDomenskiObjekat sacuvajObjekat(OpstiDomenskiObjekat o) throws ServerskiException{
        try {
            String upit="INSERT INTO "+o.getClassName()+" VALUES("+o.getColumnValues()+")";
            System.out.println(upit);
            Statement st=connection.createStatement();
            int result=st.executeUpdate(upit);
            //st.close();
            if(result>0){
                //st.close();
                return o;
            }
            return null;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ServerskiException("Neuspesna operacija cuvanja objekta");
        }
    }
    public OpstiDomenskiObjekat izmeniObjekat(OpstiDomenskiObjekat odo)throws ServerskiException{
        try {
            String upit=String.format("UPDATE %s SET %s WHERE %s=%d",odo.getClassName(),odo.setColumnValues(),odo.getPrimaryKeyName(),odo.getPrimaryKeyValue());
            //System.out.println(upit);
            if(odo instanceof Rezervacija){
                //List<Stavka_Rezervacije> stavke=(List<Stavka_Rezervacije>)(Rezervacija)((Rezervacija) odo).getStavkeRezervacije();
                Rezervacija rezervacija=(Rezervacija) odo;
                List<Stavka_Rezervacije> stavke=rezervacija.getStavkeRezervacije();
                int sifra=1;
                for(Stavka_Rezervacije stavka:stavke){
                    stavka.setSifra(sifra);
                    stavka=(Stavka_Rezervacije) sacuvajObjekat(stavka);
                    if(stavka==null){
                        return null;
                    }
                    sifra++;
                }
            }
            System.out.println(upit);
            if(odo instanceof Narudzbenica){
                Narudzbenica narudzbenica=(Narudzbenica) odo;
                List<Stavka_Narudzbenice> stavke=narudzbenica.getStavkeNarudzbenice();
                int sifra=1;
                for(Stavka_Narudzbenice stavka:stavke){
                    stavka.setSifra(sifra);
                    stavka=(Stavka_Narudzbenice) sacuvajObjekat(stavka);
                    if(stavka==null){
                        return null;
                    }
                    sifra++;
                }
            }
            Statement st=connection.createStatement();
            int result=st.executeUpdate(upit);
            if(result>0){
                return odo;
            }
            return null;
        } catch (SQLException ex) {
            System.out.println("1");
            ex.printStackTrace();
            throw new ServerskiException("Neuspesna opcija izmene podataka objekta");
        }
    }
    public OpstiDomenskiObjekat obrisiObjekat(OpstiDomenskiObjekat odo) throws ServerskiException{
        String upit="DELETE FROM "+odo.getClassName()+" WHERE "+odo.getPrimaryKeyName()+"="+odo.getPrimaryKeyValue();
        try {
            Statement st=connection.createStatement();
            int result=st.executeUpdate(upit);
            if(result>0){
                return odo;
            }
            return null;
        } catch (SQLException ex) {
            throw new ServerskiException("Neuspesna opcija brisanja podataka");
        }
    }
    public List<OpstiDomenskiObjekat> vratiSveClanove() throws ServerskiException{
        String upit="SELECT *"
                + "FROM Clan c "
                + "INNER JOIN Grad g ON c.sifraGrada=g.sifraGrada ORDER BY sifraClana ASC";
        //String pom="c.sifraClana,c.imeClana,c.prezimeClana,c.telefonClana,c.vrstaClanskeKarte,c.aktivnostClanstva,c.emailClana,c.lozinkaClana,c.sifraGrada,g.nazivGrada";
        List<OpstiDomenskiObjekat> clanovi=new LinkedList<>();
        
        try {
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery(upit);
            while(rs.next()){
                Clan clan=(Clan) new Clan().getObjectFromResultSet(rs);
                //System.out.println(clan.getSifra());
                clanovi.add(clan);
            }
            return clanovi;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ServerskiException("Neuspesna opcija vracanja svih clanova");
        }
       // return null;
    }
    public List<OpstiDomenskiObjekat> nadjiClanove(HashMap<String,String> kriterijum)throws ServerskiException{
        String upit="SELECT * FROM clan INNER JOIN grad ON clan.sifraGrada=grad.sifraGrada";
        if(kriterijum.size()>0){
            upit+=" WHERE";
            if(kriterijum.get("sifraClana")!=null){
                upit+=" sifraClana="+kriterijum.get("sifraClana")+" AND";
            }
            if(kriterijum.get("imeClana")!=null){
                upit+=" imeClana LIKE '"+kriterijum.get("imeClana")+"%' AND";
            }
            if(kriterijum.get("prezimeClana")!=null){
                upit+=" prezimeClana LIKE '"+kriterijum.get("prezimeClana")+"%' AND";
            }
            if(kriterijum.get("telefonClana")!=null){
                upit+=" telefonClana LIKE '"+kriterijum.get("telefonClana")+"%' AND";
            }
            if(kriterijum.get("aktivnostClanstva")!=null){
                upit+=" aktivnostClanstva="+kriterijum.get("aktivnostClanstva")+" AND";
            }
            upit=upit.substring(0, upit.length()-4);
        }
        System.out.println(upit);
        List<OpstiDomenskiObjekat> clanovi=new LinkedList<>();
        try {
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery(upit);
            while(rs.next()){
                Clan clan=(Clan) new Clan().getObjectFromResultSet(rs);
                clanovi.add(clan);
            }
            return clanovi;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ServerskiException("Neuspesna opcija pronalazenja clanova po kriterijumu");
        }
    }
    public Clan aktivirajClanstvo(Clan clan)throws ServerskiException{
        String upit="UPDATE "+clan.getClassName()+" SET aktivnostClanstva=1 WHERE "+clan.getPrimaryKeyName()+"="+clan.getPrimaryKeyValue();
        try {
            Statement st=connection.createStatement();
            int result=st.executeUpdate(upit);
            if(result>0){
                return clan;
            }
            return null;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ServerskiException("Neuspesna opcija aktiviranja clanstva");
        }
    }
    public Clan deaktivirajClanstvo(Clan clan)throws ServerskiException{
        String upit="UPDATE "+clan.getClassName()+" SET aktivnostClanstva=0 WHERE "+clan.getPrimaryKeyName()+"="+clan.getPrimaryKeyValue();
        try {
            Statement st=connection.createStatement();
            int result=st.executeUpdate(upit);
            if(result>0){
                return clan;
            }
            return null;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ServerskiException("Neuspesna opcija aktiviranja clanstva");
        }
    }
    public List<String> ucitajZanrove() throws ServerskiException{
        List<String> zanrovi=new LinkedList<>();
        String upit="SELECT DISTINCT zanrKnjige FROM knjiga";
        try {
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery(upit);
            while(rs.next()){
                String zanr=rs.getString("zanrKnjige");
                zanrovi.add(zanr);
            }
            return zanrovi;
        } catch (SQLException ex) {
            throw new ServerskiException("Neuspesna opcija vracanja zanrova");
        }
        
    }
    public List<OpstiDomenskiObjekat> ucitajPrimerke()throws ServerskiException{
        List<OpstiDomenskiObjekat> lista=new LinkedList<>();
        String upit="SELECT * FROM knjiga INNER JOIN izdavac ON knjiga.sifraIzdavaca=izdavac.sifraIzdavaca";
        try {
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery(upit);
            while(rs.next()){
                Knjiga knjiga=(Knjiga)new Knjiga().getObjectFromResultSet(rs);
                lista.add(knjiga);
            }
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ServerskiException("Neuspesna opcija vracanja svih primeraka");
        }
        
    }
    public List<OpstiDomenskiObjekat> ucitajKnjige() throws ServerskiException{
        List<OpstiDomenskiObjekat> knjige=new LinkedList<>();
        String upit="SELECT * FROM knjiga INNER JOIN izdavac ON knjiga.sifraIzdavaca=izdavac.sifraIzdavaca GROUP BY nazivKnjige";
        try {
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery(upit);
            while(rs.next()){
                Knjiga knjiga=new Knjiga();
                knjiga=(Knjiga) knjiga.getObjectFromResultSet(rs);
                System.out.println(knjiga.getSifra());
                knjige.add(knjiga);
            }
            return knjige;
        } catch (SQLException ex) {
            throw new ServerskiException("Neuspesna opcija vracanja svih knjiga");
        }
        
    }
    public List<OpstiDomenskiObjekat> nadjiPrimerke(HashMap<String,String> kriterijum) throws ServerskiException{
        String upit="SELECT * FROM knjiga INNER JOIN izdavac ON knjiga.sifraIzdavaca=izdavac.sifraIzdavaca";
        if(kriterijum.size()>0){
            upit+=" WHERE";
            if(kriterijum.get("sifraKnjige")!=null){
                upit+=" sifraKnjige="+kriterijum.get("sifraKnjige")+" AND";
            }
            if(kriterijum.get("nazivKnjige")!=null){
                upit+=" nazivKnjige LIKE '"+kriterijum.get("nazivKnjige")+"%' AND";
            }
            if(kriterijum.get("autorKnjige")!=null){
                upit+=" autorKnjige LIKE '"+kriterijum.get("autorKnjige")+"%' AND";
            }
            if(kriterijum.get("zanrKnjige")!=null){
                upit+=" zanrKnjige='"+kriterijum.get("zanrKnjige")+"' AND";
            }
            upit=upit.substring(0, upit.length()-4);
        }
        System.out.println(upit);
        List<OpstiDomenskiObjekat>lista=new LinkedList<>();
        try {
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery(upit);
            while(rs.next()){
                Knjiga primerak=(Knjiga) new Knjiga().getObjectFromResultSet(rs);
                lista.add(primerak);
            }
            return lista;
        } catch (SQLException ex) {
            throw new ServerskiException("Neuspesna opcija pronalazanje knjiga");
        }
    }
    public List<OpstiDomenskiObjekat> nadjiSlobodnePrimerke(HashMap<String,String> kriterijum) throws ServerskiException{
        String upit="SELECT * FROM knjiga INNER JOIN izdavac ON knjiga.sifraIzdavaca=izdavac.sifraIzdavaca";
         upit+=" WHERE";
        if(kriterijum.size()>0){
            if(kriterijum.get("sifraKnjige")!=null){
                upit+=" sifraKnjige="+kriterijum.get("sifraKnjige")+" AND ";
            }
            if(kriterijum.get("nazivKnjige")!=null){
                upit+=" nazivKnjige LIKE '"+kriterijum.get("nazivKnjige")+"%' AND ";
            }
            if(kriterijum.get("autorKnjige")!=null){
                upit+=" autorKnjige LIKE '"+kriterijum.get("autorKnjige")+"%' AND ";
            }
            if(kriterijum.get("zanrKnjige")!=null){
                upit+=" zanrKnjige='"+kriterijum.get("zanrKnjige")+"' AND ";
            }
            //upit=upit.substring(0, upit.length()-4);
        }
        upit+=" sifraKnjige NOT IN(SELECT sifraKnjige FROM stavka_rezervacije WHERE sifraRezervacije IN(SELECT sifraRezervacije FROM rezervacija WHERE aktivnostRezervacije=1))";
        System.out.println(upit);
        List<OpstiDomenskiObjekat> knjige=new LinkedList<>();
        try {
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery(upit);
            while(rs.next()){
                Knjiga primerak=(Knjiga) new Knjiga().getObjectFromResultSet(rs);
                knjige.add(primerak);
            }
            return knjige;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ServerskiException("Neuspesna opcija pronalazenja slobodnih knjige");
        }
    }
    public List<OpstiDomenskiObjekat> vratiRezervacijeClana(Rezervacija rezervacija) throws ServerskiException{
        String upit="SELECT * FROM rezervacija INNER JOIN clan ON(rezervacija.sifraClana=clan.sifraClana) INNER JOIN bibliotekar ON(rezervacija.sifraBibliotekara=bibliotekar.sifraBibliotekara)";
        upit+=" WHERE clan.sifraClana="+rezervacija.getClan().getSifra();
        System.out.println(upit);
        List<OpstiDomenskiObjekat> rezervacije=new LinkedList<>();
        try {
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery(upit);
            while(rs.next()){
                Rezervacija r=(Rezervacija) new Rezervacija().getObjectFromResultSet(rs);
                List<OpstiDomenskiObjekat> stavke=ucitajStavkeRezervacije(r);
                List<Stavka_Rezervacije> lista=new LinkedList<>();
                for(OpstiDomenskiObjekat odo:stavke){
                    if(odo!=null){
                        lista.add((Stavka_Rezervacije) odo);
                    }
                }
                r.setStavkeRezervacije(lista);
                rezervacije.add(r);
            }
            return rezervacije;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ServerskiException("Neuspesna opcija pronalazenja rezervacija");
        }
    }
    public OpstiDomenskiObjekat potvrdiRezervaciju(Rezervacija rezervacija) throws ServerskiException{
        String upit="UPDATE "+rezervacija.getClassName()+"  SET aktivnostRezervacije=0 WHERE sifraRezervacije="+rezervacija.getPrimaryKeyValue();
        System.out.println(upit);
        try {
            Statement st=connection.createStatement();
            int result=st.executeUpdate(upit);
            if(result>0){
                return rezervacija;
            }
            return null;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ServerskiException("Neuspesna opcija potvrde rezervacije");
        }
    }
    public List<OpstiDomenskiObjekat> ucitajStavkeRezervacije(Rezervacija rezervacija) throws ServerskiException{
        String upit="SELECT * FROM stavka_rezervacije INNER JOIN knjiga ON(stavka_rezervacije.sifraKnjige=knjiga.sifraKnjige) WHERE sifraRezervacije="+rezervacija.getPrimaryKeyValue();
        List<OpstiDomenskiObjekat> stavke=new LinkedList<>();
        System.out.println(upit);
        try {
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery(upit);
            while(rs.next()){
                Stavka_Rezervacije stavka=(Stavka_Rezervacije) new Stavka_Rezervacije(rezervacija.getPrimaryKeyValue()).getObjectFromResultSet(rs);
                stavke.add(stavka);
            }
            return stavke;
        } catch (SQLException ex) {
           throw new ServerskiException("Neuspesna opcija ucitavanja stavki");
        }
    }
}
