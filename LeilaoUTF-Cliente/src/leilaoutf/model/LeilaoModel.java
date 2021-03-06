package leilaoutf.model;

import java.time.LocalDate;
import leilaoutf.rn.Livro;

/**
 * Classe de LeilaoModel.
 * Atenção: Essa classe não deve ser acessada diretamente por outras classes, além da classe Leilao.
 * Todas as outras classes, só podem manipular o LeilaoModel através da classe Leilao.
 * @author Lucas
 */
public class LeilaoModel {
    
    private Livro livro;
    private double precoInicial;
    private LocalDate tempoLimite;
    private boolean finalizado;
    private String nomeVencedor;
    private double precoFinal;
    
    public LeilaoModel(){
        
    }
    
    /**
     * Informação de Leilão próprio.
     * @param l
     * @param preco
     * @param date 
     */
    public LeilaoModel(Livro l, double preco, LocalDate date){
        livro = l;
        precoInicial = preco;
        tempoLimite = date;
        finalizado = false;
        nomeVencedor = null;
        precoFinal = 0;
    }
    
    /**
     * Informação de Leilões de terceiros.
     * @param l
     * @param preco
     * @param precoFinal 
     */
    public LeilaoModel(Livro l, double preco, double precoFinal){
        livro = l;
        precoInicial = preco;
        tempoLimite = null;
        finalizado = false;
        nomeVencedor = null;
        precoFinal = 0;
    }

    /**
     * @return the livro
     */
    public Livro getLivro() {
        return livro;
    }

    /**
     * @param livro
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
    public LocalDate getTempoLimite() {
        return tempoLimite;
    }

    /**
     * @param tempoLimite the tempoLimite to set
     */
    public void setTempoLimite(LocalDate tempoLimite) {
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
