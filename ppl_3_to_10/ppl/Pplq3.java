/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *main class of the ppl project for questions from 3 to 10,named Pplq3
 * @author hp
 */
public class Pplq3 {

    public static ArrayList<boy> b_array = new ArrayList<>();
    public static ArrayList<girl> g_array = new ArrayList<>();
    public static ArrayList<couple> couples = new ArrayList<>();
    public static ArrayList<gift> gift_array = new ArrayList<>();

    /**
     * Reads the input from generated input files
     * @throws java.io.FileNotFoundException
     */
    public static void data() throws IOException {

        FileReader fr;
        BufferedReader br;

        fr = new FileReader("girl.txt");
        br = new BufferedReader(fr);

        String s;
        boy b;
        int nb, ng, i, attr, mar, intl, budget;

        ng = Integer.parseInt(br.readLine());
        girl g ;
        for (i = 1; i <= ng; i++) {
            
            s = br.readLine();
            StringTokenizer st = new StringTokenizer(s, ",");
            String name = st.nextToken();
            attr = Integer.parseInt(st.nextToken());
            intl = Integer.parseInt(st.nextToken());
            budget = Integer.parseInt(st.nextToken());
            String type = st.nextToken();
            if(type == "Choosy"){
            g = new Choosy(name, attr, budget, intl);
            }
            else if(type == "Desperate"){
                 g = new Desperate(name, attr, budget, intl);
            }
             else {
                 g = new Normal(name, attr, budget, intl);
            }
          //  System.out.println(g.name);
            g_array.add(g);
        }
      
        fr.close();
        br.close();
        fr = new FileReader("boy.txt");
        br = new BufferedReader(fr);

        nb = Integer.parseInt(br.readLine());
        for (i = 1; i <= nb; i++) {
            s = br.readLine();
            StringTokenizer st = new StringTokenizer(s, ",");
            String name = st.nextToken();
            attr = Integer.parseInt(st.nextToken());
            mar = Integer.parseInt(st.nextToken());
            intl = Integer.parseInt(st.nextToken());
            budget = Integer.parseInt(st.nextToken());
            String type = st.nextToken();
          
             if(type.compareTo("Miser")==0){
           b = new Miser(name, attr, mar, intl, budget);
            }
            else if(type.compareTo("Geek")==0){
                b = new Geek(name, attr, mar, intl, budget);
            }
             else {
                b = new Generous(name, attr, mar, intl, budget);
            }
            b_array.add(b);
        }
        fr.close();
        br.close();

        int ngi;
        gift gi;
        fr = new FileReader("gift.txt");
        br = new BufferedReader(fr);
        ngi = Integer.parseInt(br.readLine());
        String gid, ty;
        double cs, vl;
        for (i = 1; i <= ngi; i++) {

            s = br.readLine();
            StringTokenizer st = new StringTokenizer(s, ",");
            gid = st.nextToken();
            cs = Integer.parseInt(st.nextToken());
            vl = Integer.parseInt(st.nextToken());
            ty = st.nextToken();
           
             
            if(ty.compareTo("Essential")==0){
            gi = new Essential(gid, cs, vl);
            }
            else if(ty == "Luxury"){
                  gi = new Luxury(gid, cs, vl);
            }
             else{
                 gi = new Utility(gid, cs, vl);
            }
            gift_array.add(gi);
        }
        fr.close();
        br.close();

    }

    public static void main(String[] args) throws FileNotFoundException, IOException {

       
    }
}
