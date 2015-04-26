/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leilaoutf.rn;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Lucas
 */
public class MapLeilao {
    
    public Map<String, Leilao> leiloes; //HashMap que possuirá todos os leilões
  
    public MapLeilao(){
        leiloes = new HashMap<String, Leilao>();
    }
    
    /**
     * Inserir Leilão.
     * Insere um novo leilão no hashMap de leilões.
     * @param codigo Código do leilão.
     * @param leilao Objeto leilão.
     */
    public void inserirLeilao(String codigo, Leilao leilao){
        leiloes.put(codigo, leilao);
    }
    
    /**
     * Recuperar Leilão.
     * Recupa um leilão do mapa hash.
     * @param codigo Código do leilão.
     * @return Leilao Um objeto Leilão.
     */
    public Leilao recuperarLeilao(String codigo){
        Leilao leilao = leiloes.get(codigo);
        return leilao;
    } 
    
    /**
     * Count Leilões.
     * Conta o número de leilões salvos na hashMap.
     * @return numLeiloes Número total de Leilões.
     */
    public int countLeiloes(){
        int numLeiloes = leiloes.size();
        return numLeiloes;
    }
    
}
