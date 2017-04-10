/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppl;

import q8.*;
import static ppl.Pplq3.couples;
import static ppl.Pplq3.gift_array;

/**
 *child class to implement default gifting
 * @author hp
 */
public class giftselector1 extends gifting{
    
   
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
