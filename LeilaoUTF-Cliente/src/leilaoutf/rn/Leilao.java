/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leilaoutf.rn;

import java.time.LocalDate;
import leilaoutf.model.LeilaoModel;

/**
 *
 * @author Lucas
 */
public class Leilao {
    
    LeilaoModel leilao;
    
    public void criarLeilao(String codigoLivro, String nomeLivro, String descricaoLivro, Double precoInicial, LocalDate expiracaoLeilao){
        Livro livro = new Livro(codigoLivro, nomeLivro, descricaoLivro);
        this.leilao = new LeilaoModel(livro, precoInicial, expiracaoLeilao);
        System.out.println("Leilão criado com sucesso!");
    }
    
    public void novoLance(double lance){
        
    }
    
    public boolean verificaLance(double lance){
        return false;
    }
    
}
