package leilaoutf.rn;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import leilaoutf.util.MyNumber;
import leilaoutf.view.AguardandoClientes;
import leilaoutf.view.AguardandoServidor;
import leilaoutf.view.ClienteView;

/**
 * Classe de Decisão.
 * Responsável por verificar se deve ou não lançar nova eleição de servidor.
 * @author Lucas
 */
public class Decisao implements Runnable{
    
    public static InetAddress Server;
    public static int ServerPort;
    public static int selfPort;
    public static InetAddress group;
    public static MulticastSocket multicastSock;
    public static int[ ] clientes = new int[6];
    public static boolean clientesProntos = false;
    byte[ ] buffer = new byte[1000];
    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
    
    public Decisao(InetAddress g, MulticastSocket m){
        try{
            group = g;
            multicastSock = m;
            Random rand = new Random();
            selfPort = rand.nextInt(8000) + 999;
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
        //Colocar True apenas para testes, resultado deverá receber por multicast
        boolean servidorAtivo = false;
        String msg;
        aguardaCliente();
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
        //NOVA ELEICAO
        //Caso nenhuma mensagem seja recebida, é informado que server caiu ou não exite e lança nova eleição.
        System.out.println("O servidor não está ativo, iniciando nova eleição.");
        Eleicao.novaEleicao(group, multicastSock);  

    }
    
    /**
     * Aguarda Cliente.
     * Aguarda receber o número das portas de pelos meno 6 clientes.
     */
    public void aguardaCliente(){
        String msg;
        AguardandoClientes viewCliente = new AguardandoClientes();
        viewCliente.setVisible(true);
        enviaPortaPropria();
        do{
            try{
                System.out.println("Esperando novos clientes entrarem...");

                multicastSock.receive(packet);
                
                msg = new String(buffer);
                if(msg.startsWith("novoCliente")){
                    System.out.println("Porta de cliente recebida: " + msg.split(String.valueOf('-'))[1]);
                    System.out.println("testePort: " + msg.split(String.valueOf('-'))[1]);
                    verificaCliente(msg.split(String.valueOf('-'))[1]);
                }

            } catch (IOException ex) {
                Logger.getLogger(Decisao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }while(!clientesProntos);
        viewCliente.setVisible(false);
        viewCliente.dispose();
        AguardandoServidor viewServer = new AguardandoServidor();
        viewServer.setVisible(true);
        Eleicao.novaEleicao(group, multicastSock);
        viewServer.setVisible(false);
        viewServer.dispose();
        new Cliente();
    }
    
    /**
     * Verifica Cliente.
     * Verifica se todos os clientes estão prontos e entraram no grupo.
     * Para os clientes estarem prontos, é necessário que pelo menos 6 clientes estejam no grupo.
     * @param porta
     */
    public static void verificaCliente(String porta){
        int nClientes = 0;
        
        //ERRO AQUII!! TRANSFORMAR PARA STRING
        System.out.println("verificaCliente: " + porta);
        int portaCli = Integer.parseInt(porta.trim());
        System.out.println("PosTrans: " + portaCli);
        //FIM DO ERRO
        
        //Verifica numero de clientes no array
        //Verifica se a porta recebida já está no array, se nao estiver, cliente[] recebe a porta.
        //Se o cliente já for conhecido, sai do loop.
        for(int i=0; i < 6; i++){
            if(clientes[i] > 0){
                nClientes += 1;
            }else if(clientes[i] == portaCli){
                i = 7;
            }else{
                clientes[i] = Integer.parseInt(porta.trim());
                enviaPortaPropria();
            }
        }
        //Se houver 6 clientes, clientesProntos recebe true.
        if(nClientes == 6){
            clientesProntos = true;
        }
    }
    
    /**
     * Envia porta Própria.
     * Envia a porta via multicast.
     */
    public static void enviaPortaPropria(){
        String p = "novoCliente-" + 1150;
        try {
            DatagramPacket packetWithPort = new DatagramPacket(p.getBytes(), p.length(), group, 5757);
            multicastSock.send(packetWithPort);
        } catch (IOException ex) {
            Logger.getLogger(Decisao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the Server
     */
    public static InetAddress getServer() {
        return Server;
    }

    /**
     * @return the ServerPort
     */
    public static int getServerPort() {
        return ServerPort;
    }
    
}
