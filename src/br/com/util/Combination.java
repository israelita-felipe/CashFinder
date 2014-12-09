/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.util;

import br.com.model.Relatorio;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author Cliente
 */
public class Combination {

    public static SortedSet<SortedSet<Comparable>> getAllCombinations(Relatorio relatorio) {

        SortedSet<SortedSet<Comparable>> allCombList = new TreeSet<>(new Comparator<SortedSet<Comparable>>() {

            @Override
            public int compare(SortedSet<Comparable> o1, SortedSet<Comparable> o2) {
                int sizeComp = o1.size() - o2.size();
                if (sizeComp == 0) {
                    Iterator<Comparable> o1iIterator = o1.iterator();
                    Iterator<Comparable> o2iIterator = o2.iterator();
                    while (sizeComp == 0 && o1iIterator.hasNext()) {
                        sizeComp = o1iIterator.next().compareTo(o2iIterator.next());
                    }
                }
                return sizeComp;

            }
        });

        for (Float nstatus : relatorio.getValores()) {
            allCombList.add(new TreeSet<>(Arrays.asList(nstatus)));
        }

        for (int nivel = 1; nivel < relatorio.getValores().size(); nivel++) {
            List<SortedSet<Comparable>> statusAntes = new ArrayList<>(allCombList);
            for (Set<Comparable> antes : statusAntes) {
                SortedSet<Comparable> novo = new TreeSet<>(antes);
                novo.add(relatorio.getValores().get(nivel));
                allCombList.add(novo);
            }
        }
        return allCombList;
    }
}
