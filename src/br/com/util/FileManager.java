/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Cliente
 */
public class FileManager {

    private static FileWriter writer;

    public static boolean write(int sequence, List<Comparable> toWrite) throws IOException {
        System.out.println(toWrite);
        writer = new FileWriter(String.valueOf(sequence));
        String toFile = "";
        for (int i = 0;i<toWrite.size();i++) {
            if(i<toWrite.size()-1){
                toFile = toFile+String.valueOf((float)toWrite.get(i))+"#";
            }else{
                toFile = toFile+String.valueOf((float)toWrite.get(i));
            }
        }
        writer.write(toFile);
        writer.close();
        return false;
    }
}
