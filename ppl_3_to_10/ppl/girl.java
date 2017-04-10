/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppl;

/**
 *girl class
 * @author hp
 */
public  class girl {
    /**
     * name of girl
     */
    public String name;
    /**
     * attractiveness of girl
     */
    public int attractiveness;
    /**
     * intelligence of girl
     */
    public int intelligence;
   /**
     * happiness of girl
     */
    public double happiness;
    /**
     * committed status of girl
     */
    public boolean comm_or_not = false;
    /**
     * maintenance_cost of girl
     */
    public int maintainence_cost;
    String exb;
    /**
     * 
     * @param n name of girl
     * @param a attractiveness of girl
     * @param mc maintenance_cost of girl
     * @param i intelligence of girl
     */
    girl(String n, int a, int mc, int i) {
        name = n;
        attractiveness = a;
        maintainence_cost = mc;
        intelligence = i;
       
    }

}