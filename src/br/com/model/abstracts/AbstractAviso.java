/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.abstracts;

import br.com.model.interfaces.InterfaceAviso;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;

/**
 *
 * @author israel
 */
public abstract class AbstractAviso implements InterfaceAviso {

    @Column(name = "data")
    private Date data;
    @Column(name = "total")
    private Float valorTotal = (float) 0;
    @Column(name = "impostos")
    private List<Float> valores = new ArrayList<>();
    private Float somatorio = (float) 0;

    public AbstractAviso(Float valorTotal, Date data) {
        this.valorTotal = valorTotal;
        this.data = data;
    }

    @Override
    public boolean addValor(Float valor) throws UnsupportedOperationException {
        // ADICIONANDO VALOR AO SOMATÓRIO
        this.somatorio = this.somatorio + valor;
        // VERIFICANDO SE SOMATÓRIO ULTRAPASSA O VALOR TOTAL
        if (this.somatorio > this.valorTotal) {
            // SE SIM RESTAURE O VALOR ANTERIOR E LANCE EXCEÇÃO
            this.somatorio = this.somatorio - valor;
            throw new UnsupportedOperationException("Valor superior ao valor total");
        } else if (this.valorTotal.equals(this.somatorio)) {
            // SE NÃO E VALOR FOR IGUAL AO VALOR TOTAL ENTÃO RETORNE TRUE
            this.valores.add(valor);
            return SOMATORIO;
        } else {
            // CASO CONTRÁRIO SÓ ADICIONE
            this.valores.add(valor);
        }
        return !SOMATORIO;
    }

    @Override
    public boolean removeValor(Float valor) {
        // SE A LISTA NÃO FOR VAZIA
        if (!this.valores.isEmpty()) {
            // E SE O VALOR PODE SER REMOVIDO
            if (this.valores.remove(valor)) {
                // SUBTRAIA DO SOMATÓRIO
                this.somatorio = this.somatorio - valor;
            }
            return true;
        }
        return false;
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
