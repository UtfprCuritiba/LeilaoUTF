package leilaoutf.rn;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

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
            e.printStackTrace();
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
            e.printStackTrace();
        }
        //CÓDIGO PARA NOVA ELEIÇÃO.
    }
    
    /**
     * Enviar Identificador.
     * Quando uma nova eleição é lançada, esse função envia o seu identificador
     * para ser avaliado na eleição, para saber quem será o novo servidor.
     * @return 
     */
    public int enviarIdentificador(){
        //CODIGO PARA ENVIO DO IDENTIFICADOR.
        return 1;
    }
    
    /**
     * Notificar Novo Servidor.
     * Após novos servidor ser escolhido, é avisado a todo o grupo Multicast, 
     * quem é o novo servidor.
     */
    public void notifNovoServer(){
        //CODIGO PARA ENVIO DA MENSAGEM DE NOVO SERVIDOR.
    }
    
}
