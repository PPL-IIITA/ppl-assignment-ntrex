/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q10;

import java.io.IOException;
import ppl.case_gen;



/**
 *main class for question 10
 * @author hp
 */
public class q10 {

    /**
     * 
     * @param args the command line arguments
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        /**
         * to generate random test cases
         */
        case_gen.main(args);
        pplq10 ob = new pplq10();
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
