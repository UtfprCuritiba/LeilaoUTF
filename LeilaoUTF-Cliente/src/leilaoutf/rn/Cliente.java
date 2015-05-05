package leilaoutf.rn;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import static leilaoutf.rn.Decisao.multicastSock;
import leilaoutf.view.ClienteView;

/**
 * Classe de Cliente.
 * Classe com as ações pertinentes de cliente.
 * @author Lucas
 */
public class Cliente implements Runnable{
    
    static long identificador;
    byte[ ] buffer;
    DatagramPacket packet;
    
    public Cliente(){
        //Inicia a interface gráfica
        new ClienteView().setVisible(true);
        identificador = System.currentTimeMillis();
    }
    
    @Override
    /**
     * Run.
     * Ficará ouvindo novos clientes.
     */
    public void run() {
        buffer = new byte[1000];
        packet = new DatagramPacket(buffer, buffer.length);
        try {
            Decisao.multicastSock.receive(packet);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        String msg = new String(packet.getData());
        if(msg.startsWith("novoCliente")){
            Decisao.verificaCliente(msg.split(String.valueOf('-'))[1]);
        }
    }
    
    /**
     * Novo Leilão.
     * Esta função deve enviar o novo leilão ao servidor.
     * @param leilao 
     */
    public void novoLeilao(Leilao leilao){
        String msg = "novoLeilao-";
        String codigoLivro = leilao.leilao.getLivro().livro.getCodigo();
        String nomeLivro = leilao.leilao.getLivro().livro.getNome(); 
        String descricaoLivro = leilao.leilao.getLivro().livro.getDescricao(); 
        Double precoInicial = leilao.leilao.getPrecoInicial(); 
        LocalDate expiracaoLeilao = leilao.leilao.getTempoLimite();
        msg = msg + codigoLivro + nomeLivro + descricaoLivro + String.valueOf(precoInicial) + String.valueOf(expiracaoLeilao);
        String result = udpCliente(msg);
        System.out.println(result);
    }
    
    /**
     * Participar Leilão.
     * Essa função deve ser responsável por enviar ao server a requisição de participar de um leilão.
     * @param codigo codigo do livro/leilao.
     */
    public void participaLeilao(String codigo){
        String msg = "participaLeilao-" + codigo;
        String recebeDadosLivro = udpCliente(msg);
        
        Leilao leilao = new Leilao();
        String codigoLivro = recebeDadosLivro.split(String.valueOf('-'))[1];
        String nomeLivro = recebeDadosLivro.split(String.valueOf('-'))[2]; 
        String descricaoLivro = recebeDadosLivro.split(String.valueOf('-'))[3]; 
        Double precoInicial = Double.parseDouble(recebeDadosLivro.split(String.valueOf('-'))[4]);
        Double ultimoLance = Double.parseDouble(recebeDadosLivro.split(String.valueOf('-'))[5]);
        leilao.participaLeilao(codigoLivro, nomeLivro, descricaoLivro, precoInicial, ultimoLance);
        //CHAMAR AQUI A TELA DE LEILÃO.
    }
    
    /**
     * Novo Lance.
     * Essa função deve enviar um novo lance ao servidor.
     * @param codigo Código do livro.
     * @param valorLance Valor do lance.
     */
    public void novoLance(String codigo, double valorLance){
        String novoLance = codigo + String.valueOf(valorLance);
        String msg = "novoLance-" + novoLance;
        String result = udpCliente(msg);
        System.out.println(result);
    }
    
    /**
     * Finalizar leilão.
     * Essa função deve enviar ao servidor o comando de finalizar um leilão.
     * Apenas o criador do respectivo leilão deverá finalizá-lo.
     * @param codigo
     */
    public void finalizarLeilao(String codigo){
        String msg = "finalizarLeilao-" + codigo;
        String result = udpCliente(msg);
        System.out.println(result);
    }
    
    /**
     * UDP Cliente.
     * Função responsável por enviar os pacotes via UDP.
     * Pode enviar novos leilões, lances e pedidos de finalizar leilão.
     * @param msg Mensagem a ser enviada para o servidor.
     * @return Resposta do servidor.
     */
    public String udpCliente(String msg){
        DatagramSocket aSocket = null;
        String respostaServer = null;
        
        try {
            
            //Envia pacote para o servidor.
            aSocket = new DatagramSocket();
            DatagramPacket request
                    = new DatagramPacket(msg.getBytes(), msg.length(), Decisao.Server, Decisao.ServerPort);
            aSocket.send(request);
            
            //Espera resposta do servidor
            byte[] bf = new byte[1000];
            DatagramPacket reply = new DatagramPacket(bf, bf.length);
            aSocket.receive(reply);
            respostaServer = new String(reply.getData());
            System.out.println("Recebido do servidor: " + respostaServer);
            
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (aSocket != null) {
                aSocket.close();
            }
        }
        
        return respostaServer;
    }
    
}
