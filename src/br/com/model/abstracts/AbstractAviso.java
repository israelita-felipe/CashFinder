/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.abstracts;

import br.com.model.interfaces.InterfaceAviso;
import java.util.Date;
import java.util.List;

/**
 *
 * @author israel
 */
public class AbstractAviso implements InterfaceAviso {

    private Date data;
    private Float valorTotal;
    private List<Float> valores;
    private Float somatorio;

    @Override
    public boolean addValor(Float valor) throws UnsupportedOperationException{
        this.somatorio = this.somatorio + valor;        
        if (this.somatorio > this.valorTotal) {
            this.somatorio = this.somatorio - valor;        
            throw new UnsupportedOperationException("Valor superior ao valor total");
        } else if (this.valorTotal.equals(this.somatorio)) {
            this.valores.add(valor);
            return SOMATORIO;
        }
        return !SOMATORIO;
    }

    @Override
    public boolean removeValor(Float valor) throws UnsupportedOperationException{
        if (this.valores.isEmpty()) {
            throw new UnsupportedOperationException("Não há valores a serem retirados do aviso");
        }
        return true;
    }

    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Float> getValores() {
        return valores;
    }

    public void setValores(List<Float> valores) {
        this.valores = valores;
    }

}
