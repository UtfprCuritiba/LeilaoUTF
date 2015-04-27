package leilaoutf.rn;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import leilaoutf.view.ServidorView;

/**
 * Classe de Servidor.
 * Classe responsável pelas funções pertinentes do servidor.
 * @author Lucas
 */
public class Servidor implements Runnable{
    
    private final MulticastSocket s;
    private final InetAddress group;
    private boolean serverAtivo;
    
    public Servidor(InetAddress adressGroup, MulticastSocket multiSocket){
        s = multiSocket;
        group = adressGroup;
        ativarServidor();
        new ServidorView(this).setVisible(true);
    }
    
    /**
     * Run.
     * Informa que o servidor está ativo, a cada 3seg.
     */
    @Override
    public void run(){
        while(serverAtivo){
            try{
                Thread.sleep(3 * 1000);
            }catch(InterruptedException e){}
            infoServerAtivo();
        }
        Thread.currentThread().interrupt();
    }
    
    /**
     * Informar Servidor Ativo.
     * Informa que o servidor está ativo.
     */
    public void infoServerAtivo(){
        String m = "Servidor ativo!";
        DatagramPacket messageOut = new DatagramPacket(m.getBytes(), m.length(), group, 5757);
        try {
            s.send(messageOut);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Enviar Informação do Leilão
     * Serializa o objeto leilão e envia para o interessado.
     * @return 
     */
    public Leilao enviarInfoLeilao(){
        Leilao leilao = new Leilao();
        //CODIGO PARA SERIALIZAR A CLASSE LEILÃO.
        return leilao;
    }
    
    /**
     * Notificar novo lance.
     * Notifica a todos os interessados que houve um novo lance em certo leilão.
     * @return 
     */
    public double notifNovoLance(){
        //CODIGO PARA ENVIO DO NOVO LANCE.
        return 0.0;
    }
    
    /**
     * Registrar Interesse.
     * Registra o interesse em determinado leilão.
     */
    public void regInteresse(){
        //CODIGO PARA REGISTRAR O INTERESSE NO LEILÃO.
    }
    
    /**
     * Enviar Chaves.
     * Envia as chaves públicas e privadas.
     * @return 
     */
    public String enviarChaves(){
        return "ChaveRSA";
    }
    
    /**
     * Enviar Lista Leilão.
     * Envia a lista de leilões disponíveis para participação.
     * @return 
     */
    public ArrayList enviarListaLeilao(){
        ArrayList listaLeilao = new ArrayList();
        //CODIGO PARA ENVIAR A LISTA DE LEILÕES PARA UM CLIENTE.
        return listaLeilao;
    }
    
    //Tipo de retorno a definir.
    public void udpServidor(){
        
    }
    
    /**
     * Ativar Servidor.
     * Responsável por ativar o servidor.
     */
    public void ativarServidor(){
        serverAtivo = true;
    }
    
    /**
     * Desativar Servidor.
     * Responsável por desativar o servidor.
     */
    public void desativarServidor(){
        serverAtivo = false;
    }
    
}
