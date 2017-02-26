/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppl_assignment;

/**
 *This class contains all the attributes and constructor of girl class
 * @author hp
 */
public class girl {

    public String name;
    public int attractiveness;
    public int intelligence;
    String type;
    public double happiness;
    boolean comm_or_not = false;
    public int maintainence_cost;

    girl(String n, int a, int mc, int i, String t) {
        name = n;
        attractiveness = a;
        maintainence_cost = mc;
        intelligence = i;
        type = t;
    }

}
