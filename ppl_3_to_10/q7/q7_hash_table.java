/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q7;

import ppl.couple;
import ppl.Pplq3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *class to perform hash table implementation to store couples information
 * @author hp
 */
public class q7_hash_table extends q7_utility{
    
     Map<String,String> hashtable = new HashMap<>();
     
     q7_hash_table(){
          ArrayList<couple> couples = Pplq3.couples;
          int i;
          for(i=0;i<couples.size();i++){
              hashtable.put(couples.get(i).bobj.name, couples.get(i).gobj.name);
          }
     }
     /**
      * 
      * @param str array containing names of boys
      */
      public void find_girlfriend(String [] str){
          
          for(String s : str){
              
            if(hashtable.containsKey(s))
           System.out.println("girlfriend of "+s+" is "+hashtable.get(s));
            else
                System.out.println(s+" -girlfriend not found");
          }
      }
    
}
