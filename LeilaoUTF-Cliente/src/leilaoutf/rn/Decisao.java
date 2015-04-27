package leilaoutf.rn;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe de Decisão.
 * Responsável por verificar se deve ou não lançar nova eleição de servidor.
 * @author Lucas
 */
public class Decisao implements Runnable{
    
    InetAddress group;
    MulticastSocket multicastSock;
    byte[ ] buffer = new byte[1000];
    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
    
    public Decisao(InetAddress g, MulticastSocket m){
        try{
            group = g;
            multicastSock = m;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * A ideia dessa função seria verificar se está recebendo resposta do server
     * e tomar as decisões necessárias para caso o servidor estivesse desativado.
     * O tempo de espera de resposta do servidor deveria ser de 5seg.
     */
    @Override
    public void run() {
        //True apenas para testes, resultado deverá receber por multicast
        boolean servidorAtivo = true;   
        String msg;
        do{
            try{
                System.out.println("Esperando resposta do servidor...");
                //CODIGO PARA CASO A ESPERA DEMORE MAIS QUE 5SEG., SAIR DESSE TRY E DO-WHILE.
                
                multicastSock.receive(packet);
                System.out.println("Socket Addres: " + packet.getSocketAddress());
                
                msg = new String(buffer);
                System.out.println(msg);
                
            } catch (IOException ex) {
                Logger.getLogger(Decisao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }while(servidorAtivo);
        
        //Caso nenhuma mensagem seja recebida, é informado que server caiu e lança nova eleição.
        System.out.println("O servidor não está ativo, iniciando nova eleição.");
        Eleicao.novaEleicao(group, multicastSock);  

    }
    
}
