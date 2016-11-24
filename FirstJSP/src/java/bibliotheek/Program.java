/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotheek;

import java.util.*;

/**
 *
 * @author frederic
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List boeken = new ArrayList();
        
        Boek b1 = new Boek("978-0134034089", "The Java Tutorial: A Short Course on the Basics",
                "Raymond Gallardo");
        
        Boek b2 = new Boek("9780133761313", "Intro to Java Programming, Comprehensive Version",
                "Y Daniel Liang");
        
        boeken.add(b1);
        boeken.add(b2);
        
        for (Object o : boeken)
        {
            System.out.println(o);
        }
        
    }
    
}
