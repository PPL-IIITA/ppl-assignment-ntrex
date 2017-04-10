/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q8;

import java.util.Comparator;
import ppl.couple;

/**
 *
 * @author hp
 */
public class cmp implements Comparator{
      @Override
    public int compare(Object o1, Object o2) {
        couple g1, g2;
        g1 = (couple) o1;
        g2 = (couple) o2;
        if (g1.happiness > g2.happiness) {
            return -1;
        } else if (g1.happiness < g2.happiness) {
            return 1;
        } else {
            return 0;
        }
    }
    
}
