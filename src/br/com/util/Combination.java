/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.util;

import br.com.model.Relatorio;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author Cliente
 */
public class Combination {

    public static SortedSet<List<Comparable>> getAllCombinations(Relatorio relatorio) throws IOException {

        SortedSet<List<Comparable>> allCombList = new TreeSet<>(new Comparator<List<Comparable>>() {

            @Override
            public int compare(List<Comparable> o1, List<Comparable> o2) {
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
        int name = 0;
        for (Float nstatus : relatorio.getValores()) {
            allCombList.add(new ArrayList<>(Arrays.asList(nstatus)));
            ArchiveWriter.write(name++, new ArrayList<>(Arrays.asList(nstatus)));
        }

        for (int nivel = 1; nivel < relatorio.getValores().size(); nivel++) {
            List<List<Comparable>> statusAntes = new ArrayList<>(allCombList);
            for (List<Comparable> antes : statusAntes) {
                List<Comparable> novo = new ArrayList<>(antes);
                novo.add(relatorio.getValores().get(nivel));
                allCombList.add(novo);
                ArchiveWriter.write(name++, novo);
            }
        }
        return allCombList;
    }
}
