/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leilaoutf.model;

import java.util.Date;

/**
 *
 * @author Lucas
 */
public class Leilao {
    
    private Livro livro;
    private double precoInicial;
    private Date tempoLimite;
    private boolean finalizado;
    private String nomeVencedor;
    private double precoFinal;

    /**
     * @return the livro
     */
    public Livro getLivro() {
        return livro;
    }

    /**
     * @param livro the livro to set
     */
    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    /**
     * @return the precoInicial
     */
    public double getPrecoInicial() {
        return precoInicial;
    }

    /**
     * @param precoInicial the precoInicial to set
     */
    public void setPrecoInicial(double precoInicial) {
        this.precoInicial = precoInicial;
    }

    /**
     * @return the tempoLimite
     */
    public Date getTempoLimite() {
        return tempoLimite;
    }

    /**
     * @param tempoLimite the tempoLimite to set
     */
    public void setTempoLimite(Date tempoLimite) {
        this.tempoLimite = tempoLimite;
    }

    /**
     * @return the finalizado
     */
    public boolean isFinalizado() {
        return finalizado;
    }

    /**
     * @param finalizado the finalizado to set
     */
    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    /**
     * @return the nomeVencedor
     */
    public String getNomeVencedor() {
        return nomeVencedor;
    }

    /**
     * @param nomeVencedor the nomeVencedor to set
     */
    public void setNomeVencedor(String nomeVencedor) {
        this.nomeVencedor = nomeVencedor;
    }

    /**
     * @return the precoFinal
     */
    public double getPrecoFinal() {
        return precoFinal;
    }

    /**
     * @param precoFinal the precoFinal to set
     */
    public void setPrecoFinal(double precoFinal) {
        this.precoFinal = precoFinal;
    }
    
}
