/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import communications.Communication;
import domain.Clan;
import domain.Knjiga;
import exception.ServerskiException;
import java.util.List;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import operations.Operation;
import transfer.Request;
import transfer.Response;

/**
 *
 * @author Mihajlo
 */
public class OpstiKontrolerClanaKI {
    private static OpstiKontrolerClanaKI instance;
    
    private OpstiKontrolerClanaKI(){
        
    }
    public static OpstiKontrolerClanaKI getInstance(){
        if(instance==null){
            instance=new OpstiKontrolerClanaKI();
        }
        return instance;
    }
    public void uspostaviKonekciju() throws IOException{
        if(Communication.getInstance().getSocket()==null){
            Socket socket=new Socket("localhost", 9000);
            Communication.getInstance().setSocket(socket);
            System.out.println("Clan se povezao");
        }
    }
    public Object obradiZahtev(Object parametar,Operation op) throws IOException, Exception{
        Request request=new Request(parametar, op);
        Communication.getInstance().getSender().sendObject(request);
        Response response=(Response) Communication.getInstance().getReceiver().receiveObject();
        if(response==null){
            return null;
        }
        if(response.getException()!=null){
            throw response.getException();
        }
        if(response.getResult() instanceof Clan && !response.isUspesnost()){
            throw new ServerskiException("Clan sa ovim podacima se vec ulgovao");
        }
        return response.getResult();
        
    }
    public Clan prijaviClana(String email,String lozinka) throws Exception{
        Clan clan=new Clan();
        clan.setEmail(email);
        clan.setLozinka(lozinka);
        Clan prijavljeni=(Clan) obradiZahtev(clan, Operation.PRIJAVA_CLANA);
        return prijavljeni;
    }
    public boolean izlogujSe() throws Exception{
        boolean uspeno=(boolean) obradiZahtev(null, Operation.IZLOGUJ_SE);
        return uspeno;
    }
     public void raskiniKonekciju() throws IOException, Exception{
        if(Communication.getInstance().getSocket()!=null){
            obradiZahtev(null, Operation.TERMINATE);
            Communication.getInstance().getSocket().close();
        }
    }
    public List<String> ucitajZanrove() throws Exception{
        List<String> zanrovi=(List<String>) obradiZahtev(null, Operation.UCITAJ_ZANROVE);
        return zanrovi;
    }

    public List<Knjiga> nadjiPrimerke(HashMap<String, String> kriterijum) throws Exception {
        List<Knjiga> nadjeneKnjige=(List<Knjiga>) obradiZahtev(kriterijum, Operation.NADJI_PRIMERKE);
        return nadjeneKnjige;
    }
    public Knjiga ucitajKnjigu(int sifra) throws Exception{
        Knjiga parametar=new Knjiga(sifra);
        Knjiga knjiga=(Knjiga) obradiZahtev(parametar, Operation.UCITAJ_KNJIGU);
        return knjiga;
    }
    public boolean proveraKnjige(Knjiga knjiga) throws Exception{
        List<Knjiga> knjige=(List<Knjiga>) obradiZahtev(new HashMap<String,String>(), Operation.NADJI_SLOBODNE_PRIMERKE);
        for(Knjiga pom:knjige){
            if(pom.getSifra()==knjiga.getSifra()){
                return true;
            }
        }
        return false;
    }
}
