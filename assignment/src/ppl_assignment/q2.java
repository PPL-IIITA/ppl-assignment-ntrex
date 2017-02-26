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
import static java.lang.Math.exp;
import java.sql.Timestamp;

import java.util.Collections;
import java.util.Comparator;
import static jdk.nashorn.internal.objects.Global.Infinity;
import static ppl_assignment.Ppl_assignment.gift_array;

/**
 *It does the required work of Question 2
 * @author hp
 */
public class q2 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Ppl_assignment.data();
        matcher m = new matcher();
        m.cal();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Collections.sort(Ppl_assignment.gift_array, (gift g1, gift g2) -> {
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
        });

        File f;
        f = new File("q2_TimeStamp.txt");
        boolean g = f.createNewFile();
        BufferedWriter bw = null;
        FileWriter fw = null;
        fw = new FileWriter("q2_TimeStamp.txt");
        bw = new BufferedWriter(fw);

        int i, j, x, y, mc = 0;
       
        bw.write("Couples are forming");
        bw.newLine();
        bw.write(" formed couples are: ");
        bw.newLine();
        bw.write("-Timestamp-                   " + "       -Couple_Id-");
        bw.newLine();
        for (i = 0; i < Ppl_assignment.couples.size(); i++) {
            bw.write("time is:" + timestamp.toString() + "   " + Ppl_assignment.couples.get(i).couple_id);
            bw.newLine();
        }
        bw.newLine();

        bw.write("Exchanging gifts:");
        bw.newLine();
        bw.newLine();

        for (i = 0; i < Ppl_assignment.couples.size(); i++) {
            if (Ppl_assignment.couples.get(i).bobj.type.equals("Miser")) {
                mc = Ppl_assignment.couples.get(i).gobj.maintainence_cost;
                j = 0;
                x = 0;
                while (j < mc) {
                    j += Ppl_assignment.gift_array.get(x).price;
                    Ppl_assignment.couples.get(i).gift_array.add(gift_array.get(x));
                    bw.write("time is :" + timestamp.toString() + " couples: " + Ppl_assignment.couples.get(i).couple_id + " exchanged gift :" + gift_array.get(x).gift_id);
                    bw.newLine();
                    x++;
                }
            } else if (Ppl_assignment.couples.get(i).bobj.type.equals("Generous")) {
                mc = Ppl_assignment.couples.get(i).bobj.budget;
                j = 0;
                x = 0;
                while (j < mc) {
                    j += Ppl_assignment.gift_array.get(x).price;
                    Ppl_assignment.couples.get(i).gift_array.add(gift_array.get(x));
                    bw.write("time is :" + timestamp.toString() + " couples: " + Ppl_assignment.couples.get(i).couple_id + " exchanged gift :" + gift_array.get(x).gift_id);
                    bw.newLine();
                    x++;
                }
            } else {
                mc = Ppl_assignment.couples.get(i).gobj.maintainence_cost;
                j = 0;
                x = 0;
                while (j < mc) {
                    j += Ppl_assignment.gift_array.get(x).price;
                    Ppl_assignment.couples.get(i).gift_array.add(gift_array.get(x));
                    bw.write("time is :" + timestamp.toString() + " couples: " + Ppl_assignment.couples.get(i).couple_id + " exchanged gift :" + gift_array.get(x).gift_id);
                    bw.newLine();
                    x++;
                }
                y = Ppl_assignment.couples.get(i).bobj.budget - j;
                for (j = 0; j < gift_array.size(); j++) {
                    if (Ppl_assignment.gift_array.get(j).type.equals("Luxury") && y >= gift_array.get(j).price) {
                        Ppl_assignment.couples.get(i).gift_array.add(gift_array.get(x));
                        bw.write("time is :" + timestamp.toString() + " couples: " + Ppl_assignment.couples.get(i).couple_id + " exchanged gift :" + gift_array.get(x).gift_id);
                        bw.newLine();
                    }
                }
            }
        }
        for (i = 0; i < Ppl_assignment.couples.size(); i++) {
           
            x = 0;
            y = 0;
            double hapg = 0, hapb = 0;
            for (j = 0; j < Ppl_assignment.couples.get(i).gift_array.size(); j++) {
                x += Ppl_assignment.couples.get(i).gift_array.get(j).price;
                y += Ppl_assignment.couples.get(i).gift_array.get(j).value;
            }

            mc = Ppl_assignment.couples.get(i).gobj.maintainence_cost;
            if (Ppl_assignment.couples.get(i).gobj.type.equals("Choosy")) {
                hapg += Math.abs(Math.log10(x - mc + 2 * y));
              
            } else if (Ppl_assignment.couples.get(i).gobj.type.equals("Desperate")) {
                int r = (x - mc);
               
                while (Math.exp(r) == Infinity) {
                    r -= 500;
                }
              
                hapg += Math.abs(Math.exp((r)));
              
            } else {
                hapg += Math.abs(x - mc + y);
                
            }
            if (Ppl_assignment.couples.get(i).bobj.type.equals("Miser")) {
                hapb += Math.abs(Ppl_assignment.couples.get(i).bobj.budget - x);
            } else if (Ppl_assignment.couples.get(i).bobj.type.equals("Generous")) {
                hapb = hapg;
            } else {
                hapb = Ppl_assignment.couples.get(i).gobj.intelligence;
            }
           
            Ppl_assignment.couples.get(i).bobj.happiness = hapb;
            Ppl_assignment.couples.get(i).gobj.happiness = hapg;
            Ppl_assignment.couples.get(i).happiness = hapb + hapg;
            Ppl_assignment.couples.get(i).compatibility = Ppl_assignment.couples.get(i).bobj.budget - mc + Math.abs(Ppl_assignment.couples.get(i).gobj.attractiveness - Ppl_assignment.couples.get(i).bobj.attractiveness) + Math.abs(Ppl_assignment.couples.get(i).gobj.intelligence - Ppl_assignment.couples.get(i).bobj.intelligence);
        }

        bw.close();
        fw.close();

        f = new File("q2_log.txt");
        g = f.createNewFile();

        fw = new FileWriter("q2_log.txt");
        bw = new BufferedWriter(fw);
        Collections.sort(Ppl_assignment.couples, (couple g1, couple g2) -> {
            //To change body of generated methods, choose Tools | Templates.
            if (g1.happiness > g2.happiness) {
                return -1;
            } else if (g1.happiness < g2.happiness) {
                return 1;
            } else {
                return 0;
            }
        });

        bw.write("Exchanged gifts data:");
        bw.newLine();
        bw.newLine();
        for (i = 0; i < Ppl_assignment.couples.size(); i++) {
           
            x = 0;
            y = 0;
            
            for (j = 0; j < Ppl_assignment.couples.get(i).gift_array.size(); j++) {
                x += Ppl_assignment.couples.get(i).gift_array.get(j).price;
                y += Ppl_assignment.couples.get(i).gift_array.get(j).value;
            }
            bw.write("couples :" + Ppl_assignment.couples.get(i).couple_id + "  exchanged  gifts:" + Ppl_assignment.couples.get(i).gift_array.size() + "  worth Price :" + x + "  and Value :" + y);
            bw.newLine();
        }
        bw.newLine();
        bw.write(Ppl_assignment.couples.size() + " most happiest couples");
        bw.newLine();

        System.out.println();
        System.out.println(Ppl_assignment.couples.size() + " most happiest couples");
        System.out.println();
        bw.write("-Timestamp-                             " + "-Couple_Id-             " + "-Happiness-");
        bw.newLine();
        for (i = 0; i < Ppl_assignment.couples.size(); i++) {
            bw.write("time is:" + timestamp.toString() + "  " + Ppl_assignment.couples.get(i).couple_id + "    " + "happiness is: " + Ppl_assignment.couples.get(i).happiness);
            bw.newLine();
            System.out.println("time is: " + timestamp.toString() + "  " + Ppl_assignment.couples.get(i).couple_id + "    " + "happiness is: " + Ppl_assignment.couples.get(i).happiness);
        }

        Collections.sort(Ppl_assignment.couples, (couple g1, couple g2) -> {
            //To change body of generated methods, choose Tools | Templates.
            if (g1.compatibility > g2.compatibility) {
                return -11;
            } else if (g1.compatibility < g2.compatibility) {
                return 1;
            } else {
                return 0;
            }
        });

        bw.newLine();
        bw.write(Ppl_assignment.couples.size() + " most compatible couples");
        bw.newLine();
        System.out.println();
        System.out.println(Ppl_assignment.couples.size() + " most compatible couples");
        System.out.println();

        bw.write("-Timestamp-                             " + "-Couple_Id-             " + "-compatibility-");
        bw.newLine();
        for (i = 0; i < Ppl_assignment.couples.size(); i++) {
            bw.write("time is:" + timestamp.toString() + "  " + Ppl_assignment.couples.get(i).couple_id + "      compatibility is:" + Ppl_assignment.couples.get(i).compatibility);
            System.out.println("time is:" + timestamp.toString() + "  " + Ppl_assignment.couples.get(i).couple_id + "      compatibility is:" + Ppl_assignment.couples.get(i).compatibility);
            bw.newLine();
        }

        bw.close();
        fw.close();
    }

}
