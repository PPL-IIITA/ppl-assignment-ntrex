/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q9;

import java.util.Comparator;
import ppl.boy;

/**
 * Comparator class to sort boys according to attractiveness
 *
 * @author hp
 */
public class Cmpboy implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        boy b1 = (boy) o1;
        boy b2 = (boy) o2;
        if (b1.attractiveness > b2.attractiveness) {
            return -1;
        } else if (b1.attractiveness < b2.attractiveness) {
            return 1;
        } else {
            return 0;
        }
    }

}
