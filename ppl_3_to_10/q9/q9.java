/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q9;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collections;
import ppl.Pplq3;
import static ppl.Pplq3.couples;
import static ppl.Pplq3.data;
import static ppl.Pplq3.gift_array;
import ppl.case_gen;
import ppl.couple;
import ppl.gift;
import ppl.gifting;
import ppl.giftselector1;
import ppl.matcher;

/**
 *main class to implement q9
 * @author hp
 */
public class q9 extends Pplq3{

    /**
     * 
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
         /**
         * to generate random test cases
         */
        case_gen.main(args);
        
        pplq9 ob = new pplq9();
         /**
         * to read randomly generated data from the  files
         */
        ob.data();
         /**
         * form couples
         */
        ob.make_couples();
         /**
         * gift distribution function
         */
        ob.give_gifts();
         /**
         * happiness and compatibility calculator
         */
        ob.calculate_happiness();
         /**
         * display data
         */
        ob.disp_data();

}
}