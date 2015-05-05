package leilaoutf.rn;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import leilaoutf.util.MyNumber;
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
    private int porta;
    
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
        String m = "serverAtivo";
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
    public void enviarInfoLeilao(Leilao leilao){
        String Novoleilao[] = null;
        //Livro livro = leilao.getLivro();              
                
        Novoleilao [0] = leilao.getLivro().getLivro().getCodigo();
        Novoleilao [1] = leilao.getLivro().getLivro().getNome();
        Novoleilao [2] = leilao.getLivro().getLivro().getDescricao();
        Novoleilao [3] = MyNumber.parseString(leilao.getLeilao().getPrecoInicial());
        Novoleilao [4] = MyNumber.parseString(leilao.getLeilao().getPrecoFinal());
        
        String Mensagem = ("novoLeilao" + '-' + Novoleilao[0] + '-' + Novoleilao[1] + '-' + Novoleilao[2] + '-' + Novoleilao[3] + '-' + Novoleilao[4]);
        
        //Deverá enviar para o servido via UDP
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
    public void regInteresse(String codigoLivro){
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
    
    /**
     * UDP Servidor.
     * Função responsável por receber os pacotes enviados via UDP.
     * Pode receber novos leilões, lances e pedidos de finalizar leilão.
     */
    public void udpServidor(){
        //CÓDIGO DEVE SER MODIFICADO, ESTÁ EM ESTADO BRUTO!
        DatagramSocket aSocket = null;
        try {
            aSocket = new DatagramSocket(6789);
            // create socket at agreed port
            byte[] buffer = new byte[1000];
            while (true) {
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                aSocket.receive(request);
                DatagramPacket reply = new DatagramPacket(request.getData(), request.getLength(),
                        request.getAddress(), request.getPort());
                System.out.println("Endereço:" + request.getAddress() + "\n Porta:" + request.getPort());
                aSocket.send(reply);
            }
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (aSocket != null) {
                aSocket.close();
            }
        }
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
