package leilaoutf.rn;

import leilaoutf.model.LivroModel;

/**
 * Classe de Livro.
 * Classe responsável por manipular um livro.
 * @author Lucas
 */
public class Livro {
    
    LivroModel livro;
    
    public Livro(String codigo, String nome, String descricao){
        this.livro = new LivroModel(codigo, nome, descricao);
    }
    
    /**
     * Get Livro.
     * Recupera um livro.
     * @return Livro livro.
     */
    public LivroModel getLivro(){
        return livro;
    }
    
}
