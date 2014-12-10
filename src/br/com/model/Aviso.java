/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

import br.com.model.abstracts.AbstractAviso;
import java.util.Date;
import javax.persistence.Table;

/**
 *
 * @author israel
 */
@Table(name = "aviso")
public class Aviso extends AbstractAviso {

    public Aviso(Float valorTotal, Date data) {
        super(valorTotal, data);
    }

    @Override
    public String toString() {
        return ""+this.getValorTotal();
    }    
    
}
