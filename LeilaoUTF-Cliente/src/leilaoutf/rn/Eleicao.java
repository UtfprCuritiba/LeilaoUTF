package leilaoutf.rn;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import leilaoutf.util.MyNumber;

/**
 * Eleição.
 * Essa classe é responsável por realizar uma nova eleição de servidor.
 * @author Lucas
 */
public class Eleicao {
    
    static InetAddress group;
    static MulticastSocket multicastSock;
    DatagramPacket packet;
    
    public Eleicao(InetAddress g, MulticastSocket m){
        try{
            group = g;
            multicastSock = m;
        }catch(Exception e){
            e.getMessage();
        }
    }        
    
    public void procuraServer(){
        //A classe Decisão já realizará essa operação.
        //Essa função talvez entre em desuso.
    }
    
    /**
     * Nova Eleição.
     * Envia mensagem para todos os partipantes do grupo realizando nova eleição.
     * @param g
     * @param m 
     */
    public static void novaEleicao(InetAddress g, MulticastSocket m){
        try{
            group = g;
            multicastSock = m;
        }catch(Exception e){ 
            e.getMessage(); 
        }
        int maiorPorta = 0;
        for(int i=0; i < 6; i++){
            if(Decisao.clientes[i] > maiorPorta){
                maiorPorta = Decisao.clientes[i];
            }
        }
        notifNovoServer(maiorPorta);
    }
    
    /**
     * Enviar Identificador.
     * Quando uma nova eleição é lançada, esse função envia o seu identificador
     * para ser avaliado na eleição, para saber quem será o novo servidor.
     */
    public static void enviarIdentificador(){
        long id = Cliente.identificador;
        String m = MyNumber.parseString(id);
        try {
            InetAddress g = InetAddress.getByName("237.236.35.34");
            MulticastSocket multiSock = new MulticastSocket(5757);
            DatagramPacket messageOut = new DatagramPacket(m.getBytes(), m.length(), g, 5757);
            multiSock.send(messageOut);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Notificar Novo Servidor.
     * Após novos servidor ser escolhido, é avisado a todo o grupo Multicast, 
     * quem é o novo servidor.
     * @param porta Porta do novo servidor
     */
    public static void notifNovoServer(int porta){
        String m = ("novoServer-" + String.valueOf(porta));
        try {
            InetAddress g = InetAddress.getByName("237.236.35.34");
            MulticastSocket multiSock = new MulticastSocket(5757);
            DatagramPacket messageOut = new DatagramPacket(m.getBytes(), m.length(), g, 5757);
            multiSock.send(messageOut);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
