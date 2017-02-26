/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppl_assignment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import static java.time.Clock.system;

/**
 *It does the required work of Question 1
 * @author hp
 */
public class q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Ppl_assignment.data();
        matcher m = new matcher();
        m.cal();
        
         Timestamp timestamp = new Timestamp(System.currentTimeMillis());
         File f;
        f = new File("q1_TimeStamp.txt");
        boolean g = f.createNewFile();
        BufferedWriter bw = null;
        FileWriter fw = null;
        fw = new FileWriter("q1_TimeStamp.txt");
        bw = new BufferedWriter(fw);
        
        int i;
        bw.write("Couples are forming");
        bw.newLine();
        bw.write(Ppl_assignment.couples.size() + " formed couples are: ");
        bw.newLine();
        bw.write("-Timestamp-                   "+"       -Couple_Id-");
        bw.newLine();
        for (i = 0; i < Ppl_assignment.couples.size(); i++) {
            bw.write("time is:" + timestamp.toString()+"   "+Ppl_assignment.couples.get(i).couple_id);
            bw.newLine();
        }
        bw.newLine();
        bw.close();
        fw.close();
        
    }
}
