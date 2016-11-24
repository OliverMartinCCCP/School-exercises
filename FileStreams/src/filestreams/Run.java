/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filestreams;

/**
 *
 * @author oliver
 */
public class Run {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileStreams f = new FileStreams("superhero.txt");
        f.saveFile("Spongebob", 1, 0);
        f.readFile();
    }
    
}
