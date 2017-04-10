/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q9;

import java.util.Comparator;
import ppl.girl;

/**
 * Comparator class to sort girls according to attractiveness
 *
 * @author hp
 */
public class Cmpgirl implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        girl g1 = (girl) o1;
        girl g2 = (girl) o2;
        if (g1.attractiveness > g2.attractiveness) {
            return -1;
        } else if (g1.attractiveness < g2.attractiveness) {
            return 1;
        } else {
            return 0;
        }
    }

}
