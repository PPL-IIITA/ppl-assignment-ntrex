/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q7;

import ppl.couple;
import ppl.Pplq3;
import java.util.ArrayList;
import java.util.Collections;

/**
 *class to perform sorted_array implementation to store couples information
 * @author hp
 */
public class q7_sorted_array extends q7_utility{
    
      ArrayList<couple> couples = Pplq3.couples;
      
      q7_sorted_array(){
        Collections.sort(couples, (couple b1, couple b2) -> {
            //To change body of generated methods, choose Tools | Templates.
            if (b1.bobj.name.compareTo(b2.bobj.name)>0) {
                return 1;
            }
           
             else {
                return -1;
            }
        });
                  
                  
      }
      /**
       * 
       * @param str array containing names of boys
       */
        public void find_girlfriend(String [] str){
            for(String s: str){
                int n = couples.size();
                int low=0;
                int high = n-1;
                int mid;
                int flag = 0;
                while(high>=low){
                    mid = (low+high)/2;
                    
                    if(couples.get(mid).bobj.name.compareTo(s)==0){
                        System.out.println("girlfriend of "+s+" is "+couples.get(mid).gobj.name);
                        flag = 1;
                        break;
                    }
                    else if(couples.get(mid).bobj.name.compareTo(s)<0){
                        low = mid+1;
                        
                    }
                    else 
                        high = mid-1;
                    
                }
                if(flag == 0){
                     System.out.println(s+" -girlfriend not found");
                }
                
            }
            
        } 
    
    
}
