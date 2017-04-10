/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q8;

import ppl.couple;
import ppl.giftselector2;
import ppl.matcher;
import ppl.Pplq3;
import ppl.gifting;
import ppl.gift;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collections;
import ppl.Cmp;
import static ppl.Pplq3.couples;
import static ppl.Pplq3.data;
import static ppl.Pplq3.gift_array;
import ppl.case_gen;

/**
 *main class to implement q8
 * @author hp
 */
public class q8 extends Pplq3{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
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
        f = new File("q8_TimeStamp.txt");
        boolean g = f.createNewFile();
        BufferedWriter bw = null;
        FileWriter fw = null;
        fw = new FileWriter("q8_TimeStamp.txt");
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

      
       
      
        gifting gi = new giftselector2();
        /**
         * function to perform different typr of gifting specified in question 8
         */
        gi.gifting();
        
        gift.gifting();
         for (i = 0; i < couples.size(); i++) {
             for(x=0;x<couples.get(i).gift_array.size();x++){
            bw.write("time is :" + timestamp.toString() + " couples: " + couples.get(i).couple_id + " exchanged gift :" + gift_array.get(x).gift_id);
            bw.newLine();
             }
             bw.newLine();
        }
        /**
         * calculate happiness
         */
        couple.calculate_happiness();
   
        

        bw.close();
        fw.close();

        f = new File("q8_answer.txt");
        g = f.createNewFile();

        fw = new FileWriter("q8_answer.txt");
        bw = new BufferedWriter(fw);
       /* Collections.sort(couples, (couple g1, couple g2) -> {
            //To change body of generated methods, choose Tools | Templates.
            if (g1.happiness > g2.happiness) {
                return -1;
            } else if (g1.happiness < g2.happiness) {
                return 1;
            } else {
                return 0;
            }
        });*/
        Collections.sort(couples, new cmp());
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
        bw.write(couples.size() + " most happiest couples");
        bw.newLine();

        System.out.println();
        System.out.println(couples.size() + " most happiest couples");
        System.out.println();
        bw.write("-Timestamp-                             " + "-Couple_Id-             " + "-Happiness-");
        bw.newLine();
        for (i = 0; i < couples.size(); i++) {
            bw.write("time is:" + timestamp.toString() + "  " + couples.get(i).couple_id + "    " + "happiness is: " + couples.get(i).happiness);
            bw.newLine();
            System.out.println("time is: " + timestamp.toString() + "  " + couples.get(i).couple_id + "    " + "happiness is: " + couples.get(i).happiness);
      
        }
        bw.close();
        fw.close();
                
    }
    
}
