/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppl_assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author hp
 */
public class Ppl_assignment {

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
        girl g;
        for (i = 1; i <= ng; i++) {
            s = br.readLine();
            StringTokenizer st = new StringTokenizer(s, ",");
            String name = st.nextToken();
            attr = Integer.parseInt(st.nextToken());
            intl = Integer.parseInt(st.nextToken());
            budget = Integer.parseInt(st.nextToken());
            String type = st.nextToken();
            g = new girl(name, attr, budget, intl, type);
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
            b = new boy(name, attr, mar, intl, budget, type);
            b_array.add(b);
        }
        fr.close();
        br.close();

        int ngi;
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
            gift gi = new gift(gid, cs, vl, ty);
            gift_array.add(gi);
        }
        fr.close();
        br.close();

    }

    public static void main(String[] args) throws FileNotFoundException, IOException {

        Scanner sca = new Scanner(System.in);
        int choice;
        System.out.println("-First generate the test cases-");
        System.out.println();
        do{

            System.out.println("enter choice\n1: Question 1\n2: Question 2\n3: test_case_generator\n4: Exit");

            choice = sca.nextInt();

            switch (choice) {
                case 1:
                    q1.main(args);
                    break;
                case 2:
                    q2.main(args);
                    break;
                case 3:
                    case_gen.main(args);
                    break;

                default:
                    break;
            }

        }while(choice!=4);

    }
}
