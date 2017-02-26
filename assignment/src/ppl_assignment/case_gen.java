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
import java.util.Random;

/**
 *It generates random test cases
 * @author hp
 */
public class case_gen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Random rand = new Random();
        File f;
        BufferedWriter bw = null;
        FileWriter fw = null;

        int nb, ng, attr, mar, intl, budget, type;

        ng = 5 + rand.nextInt(10);
        nb = ng + 50+rand.nextInt(100);

        f = new File("girl.txt");
        boolean g = f.createNewFile();
        fw = new FileWriter("girl.txt");
        bw = new BufferedWriter(fw);
        bw.write(Integer.toString(ng));
        bw.newLine();
        int i;
        for (i = 1; i <= ng; i++) {
            String s;
            s = "girl_" + Integer.toString(i);
            /* attr=10+rand.nextInt(91);
                intl=10+rand.nextInt(91);
                budget=100+rand.nextInt(1000);*/
            type = rand.nextInt(3);
            bw.write(s);
            bw.write(",");
            bw.write(Integer.toString(20 + rand.nextInt(81)));
            bw.write(",");
            bw.write(Integer.toString(20 + rand.nextInt(81)));
            bw.write(",");
            bw.write(Integer.toString(100 + rand.nextInt(900)));
            bw.write(",");
            if (type == 0) {
                bw.write("Normal");
            } else if (type == 1) {
                bw.write("Desperate");
            } else {
                bw.write("Choosy");
            }
            bw.newLine();
            //System.out.println(at+" "+intl+" "+bud);
        }
        bw.close();
        fw.close();

        System.out.println(nb +"  Boys generated");
        System.out.println(ng +"  girls generated");
        f = new File("boy.txt");
        boolean b = f.createNewFile();
        fw = new FileWriter("boy.txt");
        bw = new BufferedWriter(fw);
        bw.write(Integer.toString(nb));
        bw.newLine();

        for (i = 1; i <= nb; i++) {
            String s;
            s = "boy_" + Integer.toString(i);
            /* type=rand.nextInt(3);
            attr=20+rand.nextInt(81);
            intl=20+rand.nextInt(81);
            mar = 20+rand.nextInt(81);
            budget=100+rand.nextInt(900);*/
            bw.write(s);
            bw.write(",");
            bw.write(Integer.toString(20 + rand.nextInt(81)));
            bw.write(",");
            bw.write(Integer.toString(20 + rand.nextInt(81)));
            bw.write(",");
            bw.write(Integer.toString(20 + rand.nextInt(81)));
            bw.write(",");
            bw.write(Integer.toString(100 + rand.nextInt(900)));
            bw.write(",");
            type = rand.nextInt(3);
            if (type == 0) {
                bw.write("Generous");
            } else if (type == 1) {
                bw.write("Geek");
            } else {
                bw.write("Miser");
            }

            bw.newLine();
        }
        bw.close();
        fw.close();
        try {
            f = new File("gift.txt");
            b = f.createNewFile();
            fw = new FileWriter("gift.txt");
            bw = new BufferedWriter(fw);

            int x, vl, cs, ngi, ty;
            ng = 500 + rand.nextInt(501);
            
            bw.write(Integer.toString(ng));
            bw.newLine();
            for (i = 1; i <= ng; i++) {
                String s = "gift_id_" + Integer.toString(i);
                bw.write(s);
                bw.write(",");
                cs = 50 + rand.nextInt(250);
                bw.write(Integer.toString(cs));
                bw.write(",");
                x = rand.nextInt(2);
                if (x == 0) {
                    vl = cs + rand.nextInt(100);
                } else {
                    vl = cs - rand.nextInt(50);
                }
                bw.write(Integer.toString(vl));
                bw.write(",");
                ty = rand.nextInt(3);
                if (ty == 0) {
                    bw.write("Essential");
                } else if (ty == 1) {
                    bw.write("Luxury");
                } else {
                    bw.write("Utility");
                }
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        }

    }
}
