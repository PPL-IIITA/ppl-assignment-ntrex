/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppl;

import static ppl.Pplq3.couples;
import static ppl.Pplq3.gift_array;

/**
 *gift class
 * @author hp
 */
public class gift {
    /**
     * price of gift
     */
    public double price;
    /**
     * value of gift
     */
    public double value;
    /**
     * type of gift
     */
    public String type;
     /**
     * gift_id of gift
     */
    public String gift_id;

    /**
     * 
     * @param g gift_id of gift
     * @param p price of gift
     * @param v value of gift
     */
    public gift(String g, double p, double v) {
        gift_id = g;
        price = p;
        value = v;

    }
/**
 * function to implement gift exxhange
 */
    public static void gifting() {
         int i;
        for (i = 0; i < couples.size(); i++) {
            if (couples.get(i).bobj instanceof Miser) {
                int mc = couples.get(i).gobj.maintainence_cost;
                int j = 0;
                int x = 0;
                while (j < mc) {
                    j += gift_array.get(x).price;
                    couples.get(i).gift_array.add(gift_array.get(x));

                    x++;
                }
            } else if (couples.get(i).bobj instanceof Generous) {
                int mc = couples.get(i).bobj.budget;
                int j = 0;
                int x = 0;
                while (j < mc) {
                    j += gift_array.get(x).price;
                    couples.get(i).gift_array.add(gift_array.get(x));

                    x++;
                }
            } else {
                int mc = couples.get(i).gobj.maintainence_cost;
                int j = 0;
                int x = 0;
                while (j < mc) {
                    j += gift_array.get(x).price;
                    couples.get(i).gift_array.add(gift_array.get(x));

                    x++;
                }
                int y = couples.get(i).bobj.budget - j;
                for (j = 0; j < gift_array.size(); j++) {
                    if (gift_array.get(j) instanceof Luxury && y >= gift_array.get(j).price) {
                        couples.get(i).gift_array.add(gift_array.get(x));

                    }
                }
            }
        }
    
    }

   
}
