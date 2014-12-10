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
import java.util.List;
import java.util.SortedSet;
import javax.persistence.Column;
import javax.persistence.Table;

/**
 *
 * @author israel
 */
@Table(name = "relatorio")
public class Relatorio extends AbstractAviso {

    @Column(name = "removidos")
    private final ArrayList<Aviso> removidos = new ArrayList<>();
    @Column(name = "total_removido")
    private Float totalRemovido = (float) 0;

    public Relatorio(Float valorTotal, Date data) {
        super(valorTotal, data);
    }

    public Float valorRestante() {
        return this.getValorTotal() - this.totalRemovido;
    }

    public ArrayList<Aviso> getRemovidos() {
        return removidos;
    }

    /**
     * Adiciona os removidos de avisos
     *
     * @param aviso
     * @return boolean
     */
    public boolean addAviso(Aviso aviso) throws UnsupportedOperationException {
        // ADICIONA AO VALOR TOTAL DE REMOVIDOS
        this.totalRemovido = this.totalRemovido + aviso.getValorTotal();
        // VERIFICA SE O VALOR REMOVER É MAIOR QUE O PERMITIDO
        if (this.totalRemovido > this.getValorTotal()) {
            // SE SIM RESTAURA O VALOR ORIGINAL E LANÇA EXCESSÃO
            this.totalRemovido = this.totalRemovido - aviso.getValorTotal();
            throw new UnsupportedOperationException("Valor do aviso é maior que o esperado");
        } else if (totalRemovido.equals(this.getValorTotal())) {
            // SE NÃO E O VALOR TOTAL FOR IQUAL AO REMOVIDO
            // ADICIONA AOS REMOVIDOS
            this.removidos.add(aviso);
            // REMOVE DO TOTAL
            this.removeAviso(aviso);
            //  RETORNA TRUE
            return true;
        } else {
            // ADICIONA AOS REMOVIDOS
            this.removidos.add(aviso);
            // REMOVE DO TOTAL
            this.removeAviso(aviso);
        }
        return false;
    }

    /**
     * Remove um aviso dos valores totais do relatório
     *
     * @param aviso
     * @return
     */
    public boolean removeAviso(Aviso aviso) {
        // PARA CADA VALOR DO AVISO
        for (Float f : aviso.getValores()) {
            // REMOVE O VALOR DO RELATÓRIO ATUAL
            if (!removeValor(f)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Busca um aviso no relatório no qual a soma dos possíveis valores é igual
     * a <code>Float valor</code> passado como parâmetro
     *
     * @param valor
     * @return
     */
    public Aviso buscar(Float valor) {
        // RETORNA TODAS AS POSSIBILIDADES DE COMBINAÇÕES DO RELATÓRIO ATUAL
        SortedSet<List<Comparable>> possibilidades = Combination.getAllCombinations(this);
        // CRIA UM NOVO AVISO COM O VALOR PROCURADO E A DATA DO RELATÓRIO
        Aviso aviso = new Aviso(valor, getData());
        for (List<Comparable> c : possibilidades) {
            // PARA CADA POSSÍVEL COMBINAÇÃO
            for (Comparable comp : c) {
                try {
                    // SE FOR POSSÍVEL ADICIONAR E RETORNO FOR TRUE, O QUE
                    // INDICA QUE O VALOR TOTAL FOI ENCONTRADO
                    if (aviso.addValor((Float) comp)) {
                        // ADICIONE O AVISO AOS REMOVIDOS
                        this.addAviso(aviso);
                        // RETORNE O AVISO ENCONTRADO
                        return aviso;
                    }
                } catch (UnsupportedOperationException ex) {
                    // CASO O VALOR ULTRAPASSE, PARE A EXECUÇÃO DO FOR INTERNO
                    break;
                }
            }
            // SE NÃO FOI ENCONTRADO AVISO ATÉ O MOMENTO ATRIBUA UM NOVO AVISO
            // AO AVISO ATUAL PARA A PRÓXIMA INTERAÇÃO
            aviso = new Aviso(valor, getData());
        }
        return null;
    }

    @Override
    public String toString() {
        return "Relatorio{" + "Data=" + getData() + ", Valor total=" + getValorTotal() + ", Impostos=" + getValores() + '}';
    }

}
