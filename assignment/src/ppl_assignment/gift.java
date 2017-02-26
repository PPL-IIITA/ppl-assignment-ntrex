/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppl_assignment;

/**
 *This class contains all the attributes and constructor of gift class
 * @author hp
 */
public class gift {

    public double price;
    public double value;
    public String type;
    public String gift_id;

    public gift(String g, double p, double v, String t) {
        gift_id = g;
        price = p;
        value = v;
        type = t;
    }
}
