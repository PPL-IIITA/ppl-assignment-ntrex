/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q9;

import java.util.Comparator;
import ppl.gift;

/**
 * Comparator class to sort gifts according to value
 *
 * @author hp
 */
public class Cmpgiftval implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        gift g1 = (gift) o1;
        gift g2 = (gift) o2;
        if (g1.value > g2.value) {
            return -1;
        } else if (g1.value < g2.value) {
            return 1;
        } else {
            return 0;
        }
    }

}
