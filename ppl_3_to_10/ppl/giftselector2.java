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
 *child class to implement gifting according to question 8
 * @author hp
 */
public class giftselector2 extends gifting{
    
   
     public static void gifting() {
        int i;
        for (i = 0; i < couples.size(); i++) {
            if (couples.get(i).bobj instanceof Miser) {
                int mc = couples.get(i).gobj.maintainence_cost;
                int j = 0;
                int x = 0;
                int k = 0, luxury = 0, essential = 0, utility = 0;
                int a = 0, b = 0, c = 0;
                int l;
                
                    for (l = 0; l < gift_array.size() && k<3; l++) {
                        if (gift_array.get(l) instanceof Luxury && luxury == 0) {
                          //  System.out.println("1");
                            j += gift_array.get(l).price;
                            couples.get(i).gift_array.add(gift_array.get(l));
                            a = l;
                            luxury = 1;
                            k++;
                        } else if (gift_array.get(l) instanceof Essential && essential == 0) {
                           //  System.out.println("2");
                            j += gift_array.get(l).price;
                            couples.get(i).gift_array.add(gift_array.get(l));
                            b = l;
                            essential = 1;
                            k++;
                        } else if (gift_array.get(l) instanceof Utility && utility == 0) {
                          //   System.out.println("3");
                            j += gift_array.get(l).price;
                            couples.get(i).gift_array.add(gift_array.get(l));
                            c = l;
                            utility = 1;
                            k++;
                        }
                    }
                
                while (j < mc) {
                    if (x != a && x != b && x != c) {
                        // System.out.println("4");
                        j += gift_array.get(x).price;
                        couples.get(i).gift_array.add(gift_array.get(x));
                    }

                    x++;
                }
            } else if (couples.get(i).bobj instanceof Generous) {
                int mc = couples.get(i).bobj.budget;
                int j = 0;
                int x = 0;
                int k = 0, luxury = 0, essential = 0, utility = 0;
                int a = 0, b = 0, c = 0;
                int l;
               
                    for (l = 0; l < gift_array.size() && k<3; l++) {
                        if (gift_array.get(l) instanceof Luxury && luxury == 0) {
                           // System.out.println("5");
                            j += gift_array.get(l).price;
                            couples.get(i).gift_array.add(gift_array.get(l));
                            a = l;
                            luxury = 1;
                            k++;
                        } else if (gift_array.get(l) instanceof Essential && essential == 0) {
                           // System.out.println("6");
                            j += gift_array.get(l).price;
                            
                            couples.get(i).gift_array.add(gift_array.get(l));
                            b = l;
                            essential = 1;
                            k++;
                        } else if (gift_array.get(l) instanceof Utility && utility == 0) {
                          //  System.out.println("7");
                            j += gift_array.get(l).price;
                            couples.get(i).gift_array.add(gift_array.get(l));
                            c = l;
                            utility = 1;
                            k++;
                        }
                    }
                
                while (j < mc) {
                    if (x != a && x != b && x != c) {
                      //  System.out.println("8");
                        j += gift_array.get(x).price;
                        couples.get(i).gift_array.add(gift_array.get(x));
                    }

                    x++;
                }
            } else {
                int mc = couples.get(i).gobj.maintainence_cost;
                int j = 0;
                int x = 0;
                int k = 0, luxury = 0, essential = 0, utility = 0;
                int a = 0, b = 0, c = 0;
                int l;
                
                    for (l = 0; l < gift_array.size() && k<3; l++) {
                        if (gift_array.get(l) instanceof Luxury && luxury == 0) {
                            j += gift_array.get(l).price;
                            couples.get(i).gift_array.add(gift_array.get(l));
                            a = l;
                            luxury = 1;
                            k++;
                        } else if (gift_array.get(l) instanceof Essential && essential == 0) {
                            j += gift_array.get(l).price;
                            couples.get(i).gift_array.add(gift_array.get(l));
                            b = l;
                            essential = 1;
                            k++;
                        } else if (gift_array.get(l) instanceof Utility && utility == 0) {
                            j += gift_array.get(l).price;
                            couples.get(i).gift_array.add(gift_array.get(l));
                            c = l;
                            utility = 1;
                            k++;
                        }
                    }
                
                while (j < mc) {
                    if (x != a && x != b && x != c) {
                        j += gift_array.get(x).price;
                        couples.get(i).gift_array.add(gift_array.get(x));
                    }

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
