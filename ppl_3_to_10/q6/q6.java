/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q6;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static java.sql.DriverManager.println;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import ppl.Pplq3;
import ppl.boy;
import ppl.couple;
import ppl.gift;
import ppl.girl;
import ppl.matcher;
import static ppl.Pplq3.couples;
import static ppl.Pplq3.data;
import static ppl.Pplq3.gift_array;
import ppl.case_gen;

/**
 *main class to implement q6
 * @author hp
 */
public class q6 extends Pplq3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ArrayList<boy> b_array = Pplq3.b_array;
        ArrayList<girl> g_array = Pplq3.g_array;
        ArrayList<couple> couples = Pplq3.couples;
        case_gen.main(args);
        int t, index, t1;
        Random rand = new Random();
        Scanner s = new Scanner(System.in);
        /**
         * reading test cases from files
         */
        data();
        
        matcher m = new matcher();
        /**
         * function to form couples
         */
        m.cal();
        
        
        t = rand.nextInt((couples.size()/2))+1;
        if(t>=(couples.size()/2)){
            t = couples.size()/2;
        }
          System.out.println();
        System.out.println(t+"  number of days in a month in which gifting should happen");
            File f1;
            f1 = new File("q6_answer.txt");
            boolean gg = f1.createNewFile();
            BufferedWriter bw1 = null;
            FileWriter fw1 = null;
            fw1 = new FileWriter("q6_answer.txt");
            bw1 = new BufferedWriter(fw1);
        for (index = 0; index < t; index++) {
              System.out.println();
              int c = index+1;
            System.out.println("Day  " + c);
           

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
          /*  Collections.sort(gift_array, (gift g1, gift g2) -> {
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
            f = new File("q6_TimeStamp.txt");
            boolean g = f.createNewFile();
            BufferedWriter bw = null;
            FileWriter fw = null;
            fw = new FileWriter("q6_TimeStamp.txt");
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
                for (x = 0; x < couples.get(i).gift_array.size(); x++) {
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

              
            if (t >= couples.size()) {
                t1 = couples.size();
            }
            t1 = t;
            for (i = 0; i < t1; i++) {
                /**
                 * function to perform breakup
                 */

                m.breakup(i);

            }
            
            bw1.write("Day  " + c);
            System.out.println("----Breakup happened----");
            bw1.write("----Breakup happened----");
            System.out.println();
            bw1.newLine();
            System.out.println(" after breakup newly formed ");
            bw1.write(" after breakup newly formed couples are");
            bw1.newLine();
            m.cal();
            
            for (i = 0; i < couples.size(); i++) {
            bw1.write("time is:" + timestamp.toString() + "   " + couples.get(i).couple_id);
            bw1.newLine();
            }
            bw1.newLine();
             bw1.newLine();
            System.out.println();
            System.out.println();
           
        }
            bw1.close();
            fw1.close();
    }

}
