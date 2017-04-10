/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Integer.min;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
import static jdk.nashorn.internal.objects.Global.Infinity;
import ppl.Choosy;
import ppl.Cmp;
import ppl.Cmpp;
import ppl.Desperate;
import ppl.Essential;
import ppl.Geek;
import ppl.Generous;
import ppl.Luxury;
import ppl.Miser;
import ppl.Normal;
import ppl.Pplq3;
import static ppl.Pplq3.couples;
import ppl.Utility;
import ppl.boy;
import ppl.couple;
import ppl.gift;
import ppl.girl;

/**
 * class to perform random best k picking for question 9
 *
 * @author hp
 */
public class pplq9 {

    public static Template_best_k<boy> b_array = new Template_best_k<>();
    public static Template_best_k<girl> g_array = new Template_best_k<>();
    public static Template_best_k<couple> couples = new Template_best_k<>();
    public static Template_best_k<gift> gift_array = new Template_best_k<>();

    /**
     * Reads the input from generated input files
     *
     * @throws java.io.FileNotFoundException
     */
    public static void data() throws IOException {

        FileReader fr;
        BufferedReader br;

        fr = new FileReader("girl.txt");
        br = new BufferedReader(fr);

        String s;
        boy b;
        int nb, ng, i, attr, mar, intl, budget;

        ng = Integer.parseInt(br.readLine());
        girl g;
        for (i = 1; i <= ng; i++) {

            s = br.readLine();
            StringTokenizer st = new StringTokenizer(s, ",");
            String name = st.nextToken();
            attr = Integer.parseInt(st.nextToken());
            intl = Integer.parseInt(st.nextToken());
            budget = Integer.parseInt(st.nextToken());
            String type = st.nextToken();
            if (type == "Choosy") {
                g = new Choosy(name, attr, budget, intl);
            } else if (type == "Desperate") {
                g = new Desperate(name, attr, budget, intl);
            } else {
                g = new Normal(name, attr, budget, intl);
            }
            //  System.out.println(g.name);
            g_array.add(g);
        }

        fr.close();
        br.close();
        fr = new FileReader("boy.txt");
        br = new BufferedReader(fr);

        nb = Integer.parseInt(br.readLine());
        for (i = 1; i <= nb; i++) {
            s = br.readLine();
            StringTokenizer st = new StringTokenizer(s, ",");
            String name = st.nextToken();
            attr = Integer.parseInt(st.nextToken());
            mar = Integer.parseInt(st.nextToken());
            intl = Integer.parseInt(st.nextToken());
            budget = Integer.parseInt(st.nextToken());
            String type = st.nextToken();

            if (type.compareTo("Miser") == 0) {
                b = new Miser(name, attr, mar, intl, budget);
            } else if (type.compareTo("Geek") == 0) {
                b = new Geek(name, attr, mar, intl, budget);
            } else {
                b = new Generous(name, attr, mar, intl, budget);
            }
            b_array.add(b);
        }
        fr.close();
        br.close();

        int ngi;
        gift gi;
        fr = new FileReader("gift.txt");
        br = new BufferedReader(fr);
        ngi = Integer.parseInt(br.readLine());
        String gid, ty;
        double cs, vl;
        for (i = 1; i <= ngi; i++) {

            s = br.readLine();
            StringTokenizer st = new StringTokenizer(s, ",");
            gid = st.nextToken();
            cs = Integer.parseInt(st.nextToken());
            vl = Integer.parseInt(st.nextToken());
            ty = st.nextToken();

            if (ty.compareTo("Essential") == 0) {
                gi = new Essential(gid, cs, vl);
            } else if (ty == "Luxury") {
                gi = new Luxury(gid, cs, vl);
            } else {
                gi = new Utility(gid, cs, vl);
            }
            gift_array.add(gi);
        }
        fr.close();
        br.close();

    }

    /**
     * function to form couples
     *
     * @throws IOException
     */
    public void make_couples() throws IOException {
        int ng, nb;
        ng = g_array.size();
        nb = b_array.size();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        File f = new File("q9_TimeStamp.txt");
        Boolean b = f.createNewFile();
        FileWriter fw;
        BufferedWriter rw;
        fw = new FileWriter("q9_TimeStamp.txt");
        rw = new BufferedWriter(fw);
        rw.write("Event               " + "couple_id     " + "Timestamp");
        rw.newLine();
        int kb = ng;
        Template_best_k<boy> b_array_k = b_array.best_k(new Cmpboy(), kb);
        int kg;
        if (kb < 10) {
            kg = kb;
        } else {
            kg = 10;
        }
        Template_best_k<girl> g_array_k = g_array.best_k(new Cmpgirl(), kg);
        int j, i, flag = 0, cnt = 0;
        while (cnt < ng) {
            if (flag == 0) {
                for (j = 0; j < ng; j++) {
                    int p = -1, mx = 0;
                    if (g_array.get(j).comm_or_not == false) {
                        flag = 0;
                        for (i = 0; i < kb; i++) {
                            if (mx < b_array.get(i).budget && b_array.get(i).budget >= g_array.get(j).maintainence_cost && b_array.get(i).comm_or_not == false) {
                                p = i;
                                mx = b_array.get(i).budget;
                            }
                        }
                        if (p != -1) {
                            g_array.get(j).comm_or_not = true;
                            b_array.get(p).comm_or_not = true;
                            couple cp = new couple(b_array.get(p), g_array.get(j));
                            couples.add(cp);
                            timestamp = new Timestamp(System.currentTimeMillis());
                            // System.out.println(cp.couple_id+" is formed between "+b_array.get(i).get_boy_id()+" and "+g_array.get(j).get_girl_id()+" at timestamp: "+timestamp);
                            rw.write("couple formation   " + cp.couple_id + "   " + timestamp);
                            rw.newLine();
                        }
                    }
                    if (p != -1) {
                        break;
                    }
                }
                flag = 1;
                cnt++;
            } else if (flag == 1) {
                for (i = 0; i < nb; i++) {
                    int mn = 10000, p = -1;
                    if (b_array.get(i).comm_or_not == false) {
                        for (j = 0; j < kg; j++) {
                            if (mn > g_array.get(j).maintainence_cost && g_array.get(j).comm_or_not == false && b_array.get(i).budget >= g_array.get(j).maintainence_cost) {
                                p = j;
                                mn = g_array.get(j).maintainence_cost;
                            }
                        }
                        j = p;
                        if (j != -1) {
                            g_array.get(j).comm_or_not = true;
                            b_array.get(i).comm_or_not = true;
                            couple cp = new couple(b_array.get(i), g_array.get(j));
                            couples.add(cp);
                            timestamp = new Timestamp(System.currentTimeMillis());
                            //System.out.println(cp.couple_id+" is formed between "+b_array.get(i).get_boy_id()+" and "+g_array.get(j).get_maintainence_cost());
                            rw.write("couple formation   " + cp.couple_id + "   " + timestamp);
                            rw.newLine();
                        }
                    }
                    if (p != -1) {
                        break;
                    }
                }
                flag = 0;
            }
        }
        rw.close();
        fw.close();

    }

    /**
     * function to give gifts
     *
     * @throws IOException
     */
    public void give_gifts() throws IOException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        FileWriter fw;
        BufferedWriter rw;
        fw = new FileWriter("q9_TimeStamp.txt", true);
        rw = new BufferedWriter(fw);
        rw.newLine();
        rw.newLine();
        rw.write("Event               " + "Couple_id     " + "gift_id     " + "Timestamp");
        rw.newLine();
        int i, j, x, y, mc = 0;
        int kg = min(300, gift_array.size());
        Template_best_k<gift> gift_array_k_t = gift_array.best_k(new Cmpgift(), kg);
        Template_best_k<gift> gift_array_k = gift_array_k_t.best_k(new Cmpgiftval(), kg);
        for (i = 0; i < couples.size(); i++) {
            if (couples.get(i).bobj instanceof Miser) {
                mc = couples.get(i).gobj.maintainence_cost;
                j = 0;
                x = 0;
                while (j < mc && x < kg) {
                    j += gift_array.get(x).price;
                    timestamp = new Timestamp(System.currentTimeMillis());
                    rw.write("gift Distribution   " + couples.get(i).couple_id + "   " + gift_array_k.get(x).gift_id + "    " + timestamp);
                    rw.newLine();
                    couples.get(i).gift_array.add(gift_array_k.get(x));
                    x++;
                }
            } else if (couples.get(i).bobj instanceof Generous) {
                mc = couples.get(i).bobj.budget;
                j = 0;
                x = 0;
                while (j < mc && x < kg) {
                    j += gift_array_k.get(x).price;
                    timestamp = new Timestamp(System.currentTimeMillis());
                    rw.write("gift Distribution   " + couples.get(i).couple_id + "   " + gift_array_k.get(x).gift_id + "    " + timestamp);
                    rw.newLine();
                    couples.get(i).gift_array.add(gift_array_k.get(x));
                    x++;
                }
            } else {
                mc = couples.get(i).gobj.maintainence_cost;
                j = 0;
                x = 0;
                while (j < mc && x < kg) {
                    j += gift_array_k.get(x).price;
                    timestamp = new Timestamp(System.currentTimeMillis());
                    rw.write("gift Distribution   " + couples.get(i).couple_id + "   " + gift_array_k.get(x).gift_id + "    " + timestamp);
                    rw.newLine();
                    couples.get(i).gift_array.add(gift_array_k.get(x));
                    x++;
                }
                // System.out.println(couples.get(i).couple_id+"   "+j+" "+mc);
                y = couples.get(i).bobj.budget - j;
                for (j = 0; j < gift_array_k.size(); j++) {
                    if (gift_array_k.get(j) instanceof Luxury && y >= gift_array_k.get(j).price) {
                        timestamp = new Timestamp(System.currentTimeMillis());
                        rw.write("gift Distribution   " + couples.get(i).couple_id + "   " + gift_array_k.get(j).gift_id + "    " + timestamp);
                        rw.newLine();
                        couples.get(i).gift_array.add(gift_array_k.get(j));
                    }
                }
            }
        }
        rw.close();
        fw.close();
    }

    /**
     * function to display data
     *
     * @throws IOException
     */
    public void disp_data() throws IOException {
        File f = new File("q9_answer.txt");
        Boolean b = f.createNewFile();
        //System.out.println(b);
        FileWriter fw;
        BufferedWriter rw;
        fw = new FileWriter("q9_answer.txt");
        rw = new BufferedWriter(fw);
        int i;
        couples.sort(new Cmp());
        rw.write("Best couples according to happiness:");
        rw.newLine();
        for (i = 0; i < couples.size(); i++) {
            rw.write("Couple id : " + couples.get(i).couple_id + " happiness : " + couples.get(i).happiness);
            rw.newLine();
        }
        couples.sort(new Cmpp());

        rw.newLine();
        rw.write("Best couples according to compatability:");
        rw.newLine();
        //System.out.println();
        for (i = 0; i < couples.size(); i++) {
            rw.write("Couple id : " + couples.get(i).couple_id + " compatability : " + couples.get(i).compatibility);
            rw.newLine();
        }
        rw.close();
        fw.close();
    }

    void calculate_happiness() {
        int i;
        for (i = 0; i < couples.size(); i++) {

            int x = 0;
            int y = 0;
            double hapg = 0, hapb = 0;
            int j;
            for (j = 0; j < couples.get(i).gift_array.size(); j++) {
                x += couples.get(i).gift_array.get(j).price;
                y += couples.get(i).gift_array.get(j).value;
            }

            int mc = couples.get(i).gobj.maintainence_cost;
            if (couples.get(i).gobj instanceof Choosy) {
                hapg += Math.abs(Math.log10(x - mc + 2 * y));

            } else if (couples.get(i).gobj instanceof Desperate) {
                int r = (x - mc);

                while (Math.exp(r) == Infinity) {
                    r -= 500;
                }

                hapg += Math.abs(Math.exp((r)));

            } else {
                hapg += Math.abs(x - mc + y);

            }
            if (couples.get(i).bobj instanceof Miser) {
                hapb += Math.abs(couples.get(i).bobj.budget - x);
            } else if (couples.get(i).bobj instanceof Generous) {
                hapb = hapg;
            } else {
                hapb = couples.get(i).gobj.intelligence;
            }

            couples.get(i).bobj.happiness = hapb;
            couples.get(i).gobj.happiness = hapg;
            couples.get(i).happiness = hapb + hapg;
            couples.get(i).compatibility = couples.get(i).bobj.budget - mc + Math.abs(couples.get(i).gobj.attractiveness - couples.get(i).bobj.attractiveness) + Math.abs(couples.get(i).gobj.intelligence - couples.get(i).bobj.intelligence);
        }
    }
}
