/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppl_assignment;

/**
 *This class contains all the attributes and constructor of boy class
 * @author hp
 */
public class boy {

    public String name;
    public int attractiveness;
    public int min_attraction_required;
    public int intelligence;
    public int budget;
    boolean comm_or_not = false;
    public double happiness;
    String type;

    boy(String n, int a, int mar, int i, int b, String t) {
        name = n;
        attractiveness = a;
        min_attraction_required = mar;
        intelligence = i;
        budget = b;
        type = t;

    }

}
