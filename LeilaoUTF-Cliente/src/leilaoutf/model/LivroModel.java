/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leilaoutf.model;

/**
 * Atenção: Essa classe não deve ser acessada diretamente por outras classes, além da classe livro.
 * Todas as outras classes, só devem manipular o LivroModel através da classe Livro.
 * @author Lucas
 */
public class LivroModel {
    
    private String codigo;
    private String nome;
    private String descricao;

    public LivroModel(String cod, String n, String desc){
        codigo = cod;
        nome = n;
        descricao = desc;
    }
    
    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
            
}
