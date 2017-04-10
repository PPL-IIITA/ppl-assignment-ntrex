/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import ppl.Pplq3;
import ppl.boy;
import ppl.case_gen;
import ppl.couple;
import ppl.girl;
import ppl.matcher;

/**
 *to perform q5 and form couples using different method
 * @author hp
 */
public class q5 extends Pplq3{

    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
    ArrayList<boy> b_array = Pplq3.b_array;
    ArrayList<girl> g_array = Pplq3.g_array;
    ArrayList<couple> couples = Pplq3.couples;
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
         * function to form couples using different method
         */
        m.alter_cal();
        
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        File f;
        f = new File("q5_TimeStamp_and_answer.txt");
        boolean g = f.createNewFile();
        BufferedWriter bw = null;
        FileWriter fw = null;
        fw = new FileWriter("q5_TimeStamp_and_answer.txt");
        bw = new BufferedWriter(fw);
          bw.write("Couples are forming");
        bw.newLine();
        bw.write(" formed couples are: ");
        bw.newLine();
        bw.write("-Timestamp-                   " + "       -Couple_Id-");
        bw.newLine();
        int i;
        for (i = 0; i < couples.size(); i++) {
            bw.write("time is:" + timestamp.toString() + "   " + couples.get(i).couple_id);
            bw.newLine();
        }
        bw.newLine();
        bw.close();
        fw.close();
        
    }
    
}
