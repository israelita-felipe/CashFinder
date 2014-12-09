/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.util;

import br.com.model.Relatorio;
import java.util.Date;

/**
 *
 * @author Cliente
 */
public class Main {

    public static void main(String[] args) {
        Relatorio r = new Relatorio(new Float(50), new Date());
        r.addValor(new Float(10));
        r.addValor(new Float(10));
        r.addValor(new Float(30));
        System.out.println(r.getValores());
        System.out.println(r.buscar(new Float(40)).getValores());
    }
}
