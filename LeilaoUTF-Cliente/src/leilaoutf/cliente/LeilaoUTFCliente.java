/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leilaoutf.cliente;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import leilaoutf.rn.Servidor;

/**
 *
 * @author a1305093
 */
public class LeilaoUTFCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Olá mundo");
        
        //Inicia o multicast
        InetAddress group = null;
        MulticastSocket s = null;
        try {
            group = InetAddress.getByName("224.0.0.2");
            s = new MulticastSocket(6789);
            s.joinGroup(group);
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
        
        //Envia mensagem
        Servidor serv = new Servidor();
        serv.infoServerAtivo(s, group);
        
        //Recebe mensagem
        byte[] buffer = new byte[1000];
        for(int i=0; i< 3;i++) {		// get messages from others in group
            DatagramPacket messageIn = new DatagramPacket(buffer, buffer.length);
            try {
                s.receive(messageIn);
            } catch (IOException ex) {
                Logger.getLogger(LeilaoUTFCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Received: " + new String(messageIn.getData()));
        }
        

    }

}
