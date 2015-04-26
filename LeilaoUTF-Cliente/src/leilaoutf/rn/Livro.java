/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leilaoutf.rn;

import leilaoutf.model.LivroModel;

/**
 *
 * @author Lucas
 */
public class Livro {
    
    LivroModel livro;
    
    public Livro(String codigo, String nome, String descricao){
        this.livro = new LivroModel(codigo, nome, descricao);
    }
    
    public LivroModel getLivro(){
        return livro;
    }
    
}
