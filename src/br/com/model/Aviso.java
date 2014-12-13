/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

import br.com.model.abstracts.AbstractAviso;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Table;

/**
 *
 * @author israel
 */
@Table(name = "aviso")
public class Aviso extends AbstractAviso {

    public Aviso(BigDecimal valorTotal, Date data) {
        super(valorTotal, data);
    }

    @Override
    public String toString() {
        return ""+this.getValorTotal()+this.getValores();
    }    
    public static BigDecimal getTotal(List<Comparable> list){
        BigDecimal total = new BigDecimal(0);
        for(Comparable b:list){
            total = total.add((BigDecimal)b);
        }
        return total;
    }
}
