package leilaoutf.rn;

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
    public void participaLeilao(Leilao leilao){
        //CODIGO DE ENVIO DE NOTIFICAÇÃO E PEDIDO DE PARTICIPAO DE UM LEILÃO.
        leilao.getLivro().getLivro().getCodigo();
        
        
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
