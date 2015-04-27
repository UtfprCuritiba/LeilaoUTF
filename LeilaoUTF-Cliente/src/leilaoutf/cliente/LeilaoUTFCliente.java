/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leilaoutf.cliente;

import java.net.InetAddress;
import java.net.MulticastSocket;
import leilaoutf.rn.Cliente;
import leilaoutf.rn.Decisao;
import leilaoutf.rn.Servidor;

/**
 * O endereço de grupo multicast será: 237.236.35.34
 * Porta: 5757
 * @author lucasmelocvl
 */
public class LeilaoUTFCliente {

    public static void main(String[] args) throws InterruptedException {

        InetAddress group = null;
        MulticastSocket multicastSock = null;
        
        //Recebe o endereço, a porta e participa do grupo.
        try{
            group = InetAddress.getByName("237.236.35.34");
            multicastSock = new MulticastSocket(5757);
            multicastSock.joinGroup(group);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        //Classe de Servidor - Está aqui apenas para testes.
        //Quem deve acioná-la é a classe de Decisão.
        Servidor serv = new Servidor(group, multicastSock);
        Thread servThread = new Thread(serv);
        servThread.start();
        
        
        //Classe de decisões
        Decisao dec = new Decisao(group, multicastSock);
        Thread decThread = new Thread(dec);
        decThread.start();
        
        //Classe de Cliente
        Cliente cli = new Cliente();

    }

}
