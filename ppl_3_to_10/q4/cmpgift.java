/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q4;

import q3.*;
import q8.*;
import java.util.Comparator;
import ppl.gift;

/**
 *
 * @author hp
 */
public class cmpgift implements Comparator{
     public int compare(Object o1, Object o2) {
         gift g1,g2;
         g1 = (gift)o1;
         g2 = (gift)o2;
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
     }
    
}
