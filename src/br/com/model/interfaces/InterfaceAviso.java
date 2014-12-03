/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.interfaces;

import java.util.Date;
import java.util.List;

/**
 *
 * @author israel
 */
public interface InterfaceAviso {

    final boolean SOMATORIO = true;

    /**
     * Retorna true quando valor total iagual ao somatório dos valores
     *
     * @param valor
     * @return boolean
     */
    boolean addValor(Float valor) throws UnsupportedOperationException;

    /**
     * Retorna verdadeiro se o valor pode ser retirado
     *
     * @param valor
     * @return booelan
     */
    boolean removeValor(Float valor) throws UnsupportedOperationException;
}
