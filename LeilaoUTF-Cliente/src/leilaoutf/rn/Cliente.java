package leilaoutf.rn;

import leilaoutf.view.ClienteView;

/**
 * Classe de Cliente.
 * Classe com as ações pertinentes de cliente.
 * @author Lucas
 */
public class Cliente{
    
    public Cliente(){
        //Inicia a interface gráfica
        new ClienteView().setVisible(true);
    }
    
    /**
     * Novo Leilão.
     * Esta função deve serializar o objeto leilão e enviar ao servidor, notificando
     * que deseja realizar uma nova eleição.
     * @param leilao 
     */
    public void novoLeilao(Leilao leilao){
        
        //Serializa o objeto Leilao.  
        /*try {
            //Gera o arquivo para armazenar o objeto
            FileOutputStream leilaoArq = new FileOutputStream("leilao.dat");
            //Classe responsavel por inserir os objetos
            ObjectOutputStream leilaoObj = new ObjectOutputStream(leilaoArq);
            //Grava o objeto leilao no arquivo
            leilaoObj.writeObject(leilao);
            //Limpar memória
            leilaoObj.flush();
            //Fechar Stream.
            leilaoObj.close();
            //Limpar memória
            leilaoArq.flush();
            //Fechar Stream.
            leilaoArq.close();
            System.out.println("Leilão gravado com sucesso!");            
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        
        //CODIGO DE ENVIO DO OBJETO SERIALIZADO PARA O SERVIDOR.
        
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
     * Função a definir.
     */
    public void udpCliente(){
        
    }    
    
}
