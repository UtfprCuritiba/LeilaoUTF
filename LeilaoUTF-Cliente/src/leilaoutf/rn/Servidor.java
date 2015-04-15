/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leilaoutf.rn;

import leilaoutf.model.Leilao;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class Servidor {
    
    public Servidor(){
        
    }
    
    public void infoServerAtivo(){
        
    }
    
    public Leilao enviarInfoLeilao(){
        Leilao leilao = new Leilao();
        return leilao;
    }
    
    public double notifNovoLance(){
        return 0.0;
    }
    
    public void regInteresse(){
        
    }
    
    public String enviarChaver(){
        return "ChaveRSA";
    }
    
    public ArrayList enviarListaLeilao(){
        ArrayList listaLeilao = new ArrayList();
        return listaLeilao;
    }
    
    //Tipo de retorno a definir.
    public void udpServidor(){
        
    }
    
    public boolean ativarServidor(){
        return false;
    }
    
}
