/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q7;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import ppl.matcher;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import static ppl.Pplq3.b_array;
import static ppl.Pplq3.couples;
import static ppl.Pplq3.data;
import ppl.case_gen;

/**
 *main class to implement q7
 * @author hp
 */
public class q7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int i = 0;

         /**
         * test case generation
         */
        case_gen.main(args);
        /**
         * reading test cases from files
         */
        data();
        
        matcher m = new matcher();
        /**
         * function to form couples
         */
        m.cal();

        String[] str = new String[b_array.size()];
        for (i = 0; i < b_array.size(); i++) {
            str[i] = b_array.get(i).name;
        }
        File f;
        f = new File("q7_timestamp.txt");
        boolean g = f.createNewFile();
        BufferedWriter bw = null;
        FileWriter fw = null;
        fw = new FileWriter("q7_timestamp.txt");
        bw = new BufferedWriter(fw);
        bw.write("formed couples are");
        bw.newLine();
        for (i = 0; i < couples.size(); i++) {
            bw.write(couples.get(i).couple_id);
            bw.newLine();
        }

        q7_utility obj;

        System.out.println();
        System.out.println();
        System.out.println("--linked_list implementation-- ");
      
        System.out.println();
        obj = new q7_linked_list();
        /**
         * function to find girlfriend using linked_list implementation
         */
        obj.find_girlfriend(str);

        System.out.println();
        System.out.println();
        System.out.println("--sorted_array implementation-- ");
        System.out.println();
        obj = new q7_sorted_array();
        /**
         * function to find girlfriend using sorted_array implementation
         */
        obj.find_girlfriend(str);

        System.out.println();
        System.out.println();
        System.out.println("--hash_table implementation-- ");
        System.out.println();
        obj = new q7_hash_table();
         /**
         * function to find girlfriend using hash_table implementation
         */
        obj.find_girlfriend(str);

        bw.close();
        fw.close();
    }

}
