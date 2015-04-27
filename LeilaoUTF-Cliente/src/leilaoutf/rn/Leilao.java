package leilaoutf.rn;

import java.io.Serializable;
import java.time.LocalDate;
import leilaoutf.model.LeilaoModel;

/**
 * Classe de Leilão.
 * @author Lucas
 */
public class Leilao implements Serializable {
    
    LeilaoModel leilao;
    
    public Leilao(){
        super();
    }
    
    /**
     * Criar Leilão.
     * Classe responsável por criar um novo leilão.
     * @param codigoLivro
     * @param nomeLivro
     * @param descricaoLivro
     * @param precoInicial
     * @param expiracaoLeilao 
     */
    public void criarLeilao(String codigoLivro, String nomeLivro, String descricaoLivro, Double precoInicial, LocalDate expiracaoLeilao){
        Livro livro = new Livro(codigoLivro, nomeLivro, descricaoLivro);
        this.leilao = new LeilaoModel(livro, precoInicial, expiracaoLeilao);
        System.out.println("Leilão criado com sucesso!");
    }
    
    /**
     * Novo Lance.
     * Essa função deve enviar um novo lance ao servidor.
     * @param lance 
     */
    public void novoLance(double lance){
        //CODIGO DE ENVIO DO LANCE AO SERVIDOR.
    }
    
    /**
     * 
     * @param lance
     * @return 
     */
    public boolean verificaLance(double lance){
        //CODIGO DE VERIFICACAO DE LANCE VÁLIDO.
        return false;
    }
    
}
