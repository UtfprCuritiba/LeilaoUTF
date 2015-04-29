/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leilaoutf.criptografia;

import java.io.File;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 *
 * @Classes Retiradas de Fontes Externas
 */
public class GeraCriptografia {
    
    public static void main(String[] args) throws Exception {  
        //-- Gera o par de chaves, em dois arquivos (chave.publica e chave.privada)  
        GeradorParChaves gpc = new GeradorParChaves();  
        gpc.geraParChaves (new File ("chave.publica"), new File ("chave.privada"));  
  
        //-- Cifrando a mensagem "Hello, world!"  
        byte[] textoClaro = "Hello, world!".getBytes("ISO-8859-1");  
        CarregadorChavePublica ccp = new CarregadorChavePublica();  
        PublicKey pub = ccp.carregaChavePublica (new File ("chave.publica"));  
        Cifrador cf = new Cifrador();  
        byte[][] cifrado = cf.cifra (pub, textoClaro);  
        //printHex (cifrado[0]);  
        //printHex (cifrado[1]);  
          
        //-- Decifrando a mensagem   
        CarregadorChavePrivada ccpv = new CarregadorChavePrivada();  
        PrivateKey pvk = ccpv.carregaChavePrivada (new File ("chave.privada"));  
        Decifrador dcf = new Decifrador();  
        byte[] decifrado = dcf.decifra (pvk, cifrado[0], cifrado[1]);  
        System.out.println (new String (textoClaro, "ISO-8859-1"));  
    }  
    
}
