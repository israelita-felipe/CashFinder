/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

import br.com.model.abstracts.AbstractAviso;
import java.util.Date;

/**
 *
 * @author israel
 */
public class Aviso extends AbstractAviso {

    public Aviso(Float valorTotal, Date data) {
        super(valorTotal, data);
    }
    
}
