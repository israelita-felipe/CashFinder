/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

import br.com.model.abstracts.AbstractAviso;
import java.util.ArrayList;

/**
 *
 * @author israel
 */
public class Relatorio extends AbstractAviso {

    private final ArrayList<Aviso> removidos = new ArrayList<>();
    private Float totalRemovido;

    public Relatorio() {
    }

    public Float valorRestante() {
        return this.getValorTotal() - this.totalRemovido;
    }

    /**
     * Adiciona os removidos de avisos
     *
     * @param aviso
     * @return boolean
     */
    public boolean addAviso(Aviso aviso) {
        this.totalRemovido = this.totalRemovido + aviso.getValorTotal();
        if (this.totalRemovido < 0) {
            this.totalRemovido = this.totalRemovido - aviso.getValorTotal();
            throw new UnsupportedOperationException("Valor do aviso é maior que o esperado");
        } else if (totalRemovido.equals(this.getValorTotal())) {
            this.removidos.add(aviso);
            return true;
        }
        return false;
    }

    public Aviso buscar(Float valor) {
        return null;
    }
}
