/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Math.exp;
import java.sql.Timestamp;

import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;
import ppl.Pplq3;
import ppl.couple;
import ppl.gift;
import ppl.gifting;
import ppl.giftselector1;
import ppl.matcher;
import static jdk.nashorn.internal.objects.Global.Infinity;
import static ppl.Pplq3.gift_array;
import ppl.case_gen;

/**
 * It does the required work of Question 4
 *
 * @author hp
 */
public class q4 extends Pplq3 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        int a;
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
        Random rand = new Random();
       
       
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        /*Collections.sort(gift_array, (gift g1, gift g2) -> {
            //To change body of generated methods, choose Tools | Templates.
            if (g1.price > g2.price) {
                return 1;
            } else if (g1.price < g2.price) {
                return -1;
            } else if (g1.value < g2.value) {
                return 1;
            } else if (g1.value > g2.value) {
                return -1;
            } else {
                return 0;
            }
        });*/
         Collections.sort(gift_array, new cmpgift());
        File f;
        f = new File("q4_TimeStamp.txt");
        boolean g = f.createNewFile();
        BufferedWriter bw = null;
        FileWriter fw = null;
        fw = new FileWriter("q4_TimeStamp.txt");
        bw = new BufferedWriter(fw);

        int i, j, x, y, mc = 0;

        bw.write("Couples are forming");
        bw.newLine();
        bw.write(" formed couples are: ");
        bw.newLine();
        bw.write("-Timestamp-                   " + "       -Couple_Id-");
        bw.newLine();
        for (i = 0; i < couples.size(); i++) {
            bw.write("time is:" + timestamp.toString() + "   " + couples.get(i).couple_id);
            bw.newLine();
        }
        bw.newLine();
        bw.write("Exchanging gifts:");
        bw.newLine();
        bw.newLine();
        /**
         * gifting session
         */
       gift.gifting();
      
         for (i = 0; i < couples.size(); i++) {
             for(x=0;x<couples.get(i).gift_array.size();x++){
            bw.write("time is :" + timestamp.toString() + " couples: " + couples.get(i).couple_id + " exchanged gift :" + gift_array.get(x).gift_id);
            bw.newLine();
             }
             bw.newLine();
        }
         /**
          * happiness calculation
          */
        couple.calculate_happiness();

        bw.close();
        fw.close();

        f = new File("q4_answer.txt");
        g = f.createNewFile();

        fw = new FileWriter("q4_answer.txt");
        bw = new BufferedWriter(fw);
        Collections.sort(couples, (couple g1, couple g2) -> {
            //To change body of generated methods, choose Tools | Templates.
            if (g1.happiness > g2.happiness) {
                return 1;
            } else if (g1.happiness < g2.happiness) {
                return -1;
            } else {
                return 0;
            }
        });

        bw.write("Exchanged gifts data:");
        bw.newLine();
        bw.newLine();
        for (i = 0; i < couples.size(); i++) {

            x = 0;
            y = 0;

            for (j = 0; j < couples.get(i).gift_array.size(); j++) {
                x += couples.get(i).gift_array.get(j).price;
                y += couples.get(i).gift_array.get(j).value;
            }
            bw.write("couples :" + couples.get(i).couple_id + "  exchanged  gifts:" + couples.get(i).gift_array.size() + "  worth Price :" + x + "  and Value :" + y);
            bw.newLine();
        }
        bw.newLine();
        bw.write(couples.size() + " most least happiest couples");
        bw.newLine();

        System.out.println();
        System.out.println(couples.size() + " most least happiest couples");
        System.out.println();
        bw.write("-Timestamp-                             " + "-Couple_Id-             " + "-Happiness-");
        bw.newLine();
        for (i = 0; i < couples.size(); i++) {
            bw.write("time is:" + timestamp.toString() + "  " + couples.get(i).couple_id + "    " + "happiness is: " + couples.get(i).happiness);
            bw.newLine();
            System.out.println("time is: " + timestamp.toString() + "  " + couples.get(i).couple_id + "    " + "happiness is: " + couples.get(i).happiness);
        }
      
        System.out.println();
        
       
        
       
      
        a = rand.nextInt(couples.size()/2);
        if(a<=couples.size()){
        for (i = 0; i <a; i++){
        /**
         * function to perform breakup of couples
         */    
        m.breakup(i);
        
        }
        bw.newLine();
         bw.newLine();
        System.out.println("----Breakup of "+a+" couples happened----");
        bw.write("----Breakup of "+a+" couples happened----");
        System.out.println();
        bw.newLine();
        System.out.println(" after breakup newly formed couples are");
        bw.write(" after breakup newly formed couples are");
        bw.newLine();
        m.cal();
        for (i = 0; i < couples.size(); i++) {
            bw.write("time is:" + timestamp.toString() + "   " + couples.get(i).couple_id);
            bw.newLine();
        }
        }
         else{
            System.out.println("invalid input");
           bw.write(" invalid input ");
        }
          bw.close();
        fw.close();
    }
    
}
