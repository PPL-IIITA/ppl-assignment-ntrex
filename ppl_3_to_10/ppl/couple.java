/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppl;

import java.util.ArrayList;
import static jdk.nashorn.internal.objects.Global.Infinity;
import static ppl.Pplq3.couples;

/**
 *couple class
 * @author hp
 */
public class couple extends Pplq3{
    /**
     * couple_id of couple
     */
    public String couple_id;
     /**
     * boy object of couple
     */
    public boy bobj;
     /**
     * compatibility object of couple
     */
    public double compatibility;
   /**
     * happiness object of couple
     */
    public double happiness;
     /**
     * girl object object of couple
     */
    public girl gobj;
    /**
     * gift object object of couple
     */
    public gift g;
    
    public ArrayList<gift> gift_array=new ArrayList<>();
    
    /**
     * 
     * @param b boy object
     * @param g girl object
     */
    public couple(boy b,girl g){
        couple_id = b.name+"_"+g.name;
          bobj=b;
          gobj=g;
           happiness=0;
        compatibility=0;
    }
    /**
     * calculate happiness and compatibility of couples
     */
    public static void calculate_happiness(){
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
