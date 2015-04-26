/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leilaoutf.rn;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import leilaoutf.model.Leilao;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class Servidor implements Runnable{
    
    private MulticastSocket s;
    private InetAddress group;
    private boolean serverAtivo = true;
    
    public Servidor(MulticastSocket multiSocket, InetAddress adressGroup){
        s = multiSocket;
        group = adressGroup;
    }
    
    @Override
    public void run(){
        while(serverAtivo){
            infoServerAtivo();
        }
    }
    
    public void infoServerAtivo(){
        String m = "Servidor ativo!";
        DatagramPacket messageOut = new DatagramPacket(m.getBytes(), m.length(), group, 6789);
        try {
            s.send(messageOut);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    public String enviarChaves(){
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
