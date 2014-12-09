/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

import br.com.model.abstracts.AbstractAviso;
import br.com.util.Combination;
import java.util.ArrayList;
import java.util.Date;
import java.util.SortedSet;

/**
 *
 * @author israel
 */
public class Relatorio extends AbstractAviso {

    private final ArrayList<Aviso> removidos = new ArrayList<>();
    private Float totalRemovido;

    public Relatorio(Float valorTotal, Date data) {
        super(valorTotal, data);
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
    public boolean addAviso(Aviso aviso) throws UnsupportedOperationException {
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
        SortedSet<SortedSet<Comparable>> possibilidades = Combination.getAllCombinations(this);
        System.out.println(possibilidades);
        Aviso aviso = new Aviso(valor, getData());
        for (SortedSet<Comparable> c : possibilidades) {
            for (Comparable comp : c) {
                try {
                    if (aviso.addValor((Float) comp)) {
                        this.addAviso(aviso);
                        return aviso;
                    }
                } catch (UnsupportedOperationException ex) {
                    break;
                }
            }
            aviso = new Aviso(valor, getData());
        }
        return null;
    }
}
