/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppl_assignment;

import java.util.ArrayList;

/**
 *This class contains all the attributes and constructor of couple class
 * @author hp
 */

public class couple {

    String couple_id;
    boy bobj;

    public double compatibility;
    public double happiness;
    girl gobj;
    gift g;
    
    public ArrayList<gift> gift_array=new ArrayList<>();
    couple(boy b,girl g){
        couple_id = b.name+"_"+g.name;
          bobj=b;
          gobj=g;
           happiness=0;
        compatibility=0;
    }
    
    
}
