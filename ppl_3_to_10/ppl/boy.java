/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppl;

/**
 * boy class
 * @author hp
 */
public  class boy {
   
   /**
    * name of boy
    */
    public String name;
    /**
    * attractiveness of boy
    */
    public int attractiveness;
    /**
    * min_attraction_required of boy
    */
    public int min_attraction_required;
    /**
    * intelligence of boy
    */
    public int intelligence;
    /**
    * budget of boy
    */
    public int budget;
    /**
    * committed status of boy
    */
    public boolean comm_or_not = false;
     /**
    * happiness of boy
    */
    public double happiness;
    String exg;
   
    /**
     * 
     * @param n name of boy
     * @param a attractiveness of boy
     * @param mar min_attraction_required of boy
     * @param i intelligence of boy
     * @param b happiness of boy
     */
    boy(String n, int a, int mar, int i, int b) {
        name = n;
        attractiveness = a;
        min_attraction_required = mar;
        intelligence = i;
        budget = b;
       

    }
  

}
