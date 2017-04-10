/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppl;

/**
 *
 * @author hp
 */
import java.util.ArrayList;
import static ppl.Pplq3.couples;

/**
 * It forms the couples according to their attributes and also performs breakup
 *
 * @author hp
 */
public class matcher extends Pplq3 {

    ArrayList<boy> b_array = Pplq3.b_array;
    ArrayList<girl> g_array = Pplq3.g_array;
    ArrayList<couple> couples = Pplq3.couples;

    /**
     *
     * @param n number of couples to break up
     */
    public void breakup(int n) {

        couples.get(n).bobj.exg = couples.get(n).gobj.name;
        couples.get(n).gobj.exb = couples.get(n).bobj.name;
        couples.get(n).bobj.comm_or_not = false;
        couples.get(n).gobj.comm_or_not = false;

        couples.remove(couples.get(n));
    }

    /**
     * function to form couples
     */
    public void cal() {

        int i = 0, j = 0;
        for (i = 0; i < g_array.size(); i++) {
            for (j = 0; j < b_array.size(); j++) {
                try {
                    if (g_array.get(i).maintainence_cost < b_array.get(j).budget && b_array.get(j).min_attraction_required <= g_array.get(i).attractiveness && b_array.get(j).comm_or_not == false && b_array.get(j).exg != g_array.get(i).name && g_array.get(i).comm_or_not == false) {
                        g_array.get(i).comm_or_not = true;
                        b_array.get(j).comm_or_not = true;
                        couple cp = new couple(b_array.get(j), g_array.get(i));
                        couples.add(cp);
                        break;
                    }
                } catch (NullPointerException e) {
                    System.out.println(i + " " + j);
                }
            }
        }
        System.out.println("Couples are:");
        System.out.println();
        for (i = 0; i < couples.size(); i++) {
            System.out.println("couple_id " + couples.get(i).couple_id);
        }

    }

    /**
     * alternate function to form couples
     */
    public void alter_cal() {
        int i, j, k, flag = 0, m, d, g;
        for (d = 0; d < g_array.size(); d++) {

            if (flag == 0) {
                for (i = 0; i < g_array.size(); i++) {
                    for (j = 0; j < b_array.size(); j++) {

                        try {
                            if (g_array.get(i).maintainence_cost < b_array.get(j).budget && b_array.get(j).min_attraction_required <= g_array.get(i).attractiveness && b_array.get(j).comm_or_not == false && g_array.get(i).comm_or_not == false/* && b_array.get(j).exg != g_array.get(i).name*/) {
                                g_array.get(i).comm_or_not = true;
                                b_array.get(j).comm_or_not = true;
                                couple cp = new couple(b_array.get(j), g_array.get(i));
                                couples.add(cp);
                                break;
                            }
                        } catch (NullPointerException e) {
                            System.out.println(i + " " + j);
                        }
                    }
                }
                flag = 1;
            } else if (flag == 1) {

                for (m = 0; m < b_array.size(); m++) {
                    if (b_array.get(m).comm_or_not == false) {
                        break;
                    }
                }

                int max = 0, maxindex = 0, flag2 = 0;
                for (k = 0; k < g_array.size(); k++) {
                    if (g_array.get(k).attractiveness > max && g_array.get(k).comm_or_not == false) {
                        max = g_array.get(k).attractiveness;
                        maxindex = k;
                        flag2 = 1;
                    }
                }
                if (flag2 == 1) {
                    g_array.get(maxindex).comm_or_not = true;
                    b_array.get(m).comm_or_not = true;
                    couple cp = new couple(b_array.get(m), g_array.get(maxindex));
                    couples.add(cp);
                }
                flag = 0;

            }
        }
        System.out.println("Couples are:");
        System.out.println();
        for (g = 0; g < couples.size(); g++) {
            System.out.println("couple_id " + couples.get(g).couple_id);
        }
    }

}
