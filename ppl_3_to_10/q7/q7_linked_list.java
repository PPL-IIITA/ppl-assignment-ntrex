/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q7;

import ppl.couple;
import ppl.Pplq3;
import ppl.girl;
import ppl.boy;
import java.util.ArrayList;

/**
 *class to perform linked_list implementation to store couples information
 * @author hp
 */
public class q7_linked_list extends q7_utility{
    int i;
    class node{
        
        boy b;
        girl g;
        node next;
        node()
        {
            next=null;
        }
    
    }

     ArrayList<couple> couples = Pplq3.couples;
     node first,last = null;
     
     q7_linked_list(){
         for(i=0;i<couples.size();i++){
             node n = new node();
            
             
             n.b = couples.get(i).bobj;
             n.g = couples.get(i).gobj;
             
             if(last == null){
                 first = n;
                 last = n;
             }
             
             else {
                 last.next = n;
                 last = last.next;
             }
             
         }
     }
     /**
      * @param str array containing names of boys
      */
      public void find_girlfriend(String [] str){
          int i;
         
          for(String s: str){
               node n = first;
              while(n!=null && n.b.name.compareTo(s)!=0){
                  n = n.next;   
              }
              if(n!=null){
                  System.out.println("girlfriend of "+s+" is "+n.g.name);
              }
              else
                  System.out.println(s+" -girlfriend not found");
              
          }
    
    }
}
