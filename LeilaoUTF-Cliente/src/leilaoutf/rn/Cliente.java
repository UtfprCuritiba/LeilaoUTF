package leilaoutf.rn;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.time.LocalDate;
import leilaoutf.view.ClienteView;

/**
 * Classe de Cliente.
 * Classe com as ações pertinentes de cliente.
 * @author Lucas
 */
public class Cliente{
    
    static long identificador;
    
    public Cliente(){
        //Inicia a interface gráfica
        new ClienteView().setVisible(true);
        identificador = System.currentTimeMillis();
    }
    
    /**
     * Novo Leilão.
     * Esta função deve enviar o novo leilão ao servidor.
     * @param leilao 
     */
    public void novoLeilao(Leilao leilao){
        String codigoLivro = leilao.leilao.getLivro().livro.getCodigo();
        String nomeLivro = leilao.leilao.getLivro().livro.getNome(); 
        String descricaoLivro = leilao.leilao.getLivro().livro.getDescricao(); 
        Double precoInicial = leilao.leilao.getPrecoInicial(); 
        LocalDate expiracaoLeilao = leilao.leilao.getTempoLimite();
        
        //CODIGO DE ENVIO DOS DADOS PARA O SERVIDOR.
        
    }
    
    /**
     * Participar Leilão.
     * Essa função deve ser responsável por enviar ao server a requisição de participar de um leilão.
     */
    public void participaLeilao(){
        //CODIGO DE ENVIO DE NOTIFICAÇÃO E PEDIDO DE PARTICIPAO DE UM LEILÃO.
    }
    
    /**
     * Novo Lance.
     * Essa função deve enviar um novo lance ao servidor.
     */
    public void novoLance(){
        //CODIGO DE ENVIO DO LANCE AO SERVIDOR.
    }
    
    /**
     * Finalizar leilão.
     * Essa função deve enviar ao servidor o comando de finalizar um leilão.
     * Apenas o criador do respectivo leilão deverá finalizá-lo.
     */
    public void finalizarLeilao(){
        //CODIGO DE FINALIZAÇÃO DO LEILÃO.
    }
    
    /**
     * UDP Cliente.
     * Função responsável por enviar os pacotes via UDP.
     * Pode enviar novos leilões, lances e pedidos de finalizar leilão.
     */
    public void udpCliente(){
        //CÓDIGO DEVE SER MODIFICADO, ESTÁ EM ESTADO BRUTO!
        DatagramSocket aSocket = null;
        try {
            //Envia pacote para o servidor.
            aSocket = new DatagramSocket();
            String m = "Hello world";
            InetAddress aHost = InetAddress.getByName("127.0.0.1");
            int serverPort = 6789;
            DatagramPacket request
                    = new DatagramPacket(m.getBytes(), m.length(), aHost, serverPort);
            aSocket.send(request);
            
            //Espera resposta do servidor
            byte[] buffer = new byte[1000];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            aSocket.receive(reply);
            System.out.println("Reply: " + new String(reply.getData()));
            
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
    
}
