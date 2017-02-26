/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppl_assignment;

import java.util.ArrayList;

/**
 *It forms the couples according to their attributes
 * @author hp
 */
public class matcher {

    public void cal() {
        ArrayList<boy> b_array = Ppl_assignment.b_array;
        ArrayList<girl> g_array = Ppl_assignment.g_array;
        ArrayList<couple> couples = Ppl_assignment.couples;
        int i = 0, j = 0;
        for (i = 0; i < g_array.size(); i++) {
            for (j = 0; j < b_array.size(); j++) {
                if (g_array.get(i).maintainence_cost < b_array.get(j).budget && b_array.get(j).min_attraction_required <= g_array.get(i).attractiveness && b_array.get(j).comm_or_not == false) {
                    g_array.get(i).comm_or_not = true;
                    b_array.get(j).comm_or_not = true;
                    couple cp = new couple(b_array.get(j), g_array.get(i));
                    couples.add(cp);
                    break;
                }

            }
        }
        System.out.println("Couples are:");
        System.out.println();
        for (i = 0; i < couples.size(); i++) {
            System.out.println("couple_id " + couples.get(i).couple_id);
        }

    }

}
