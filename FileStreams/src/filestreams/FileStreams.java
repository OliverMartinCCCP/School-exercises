/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filestreams;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author oliver
 */
public class FileStreams {

    String superhero;
    int kills;
    int lives;
    String filename;
    
    
    public FileStreams(String filename){
        this.filename = filename;
    }
    
    public void saveFile(String superhero, int kills, int lives){
        this.superhero = superhero;
        this.kills = kills;
        this.lives = lives;
        
        try{
            File f = new File(filename);
            FileOutputStream fos = new FileOutputStream(f, true);
            PrintStream out = new PrintStream(fos);
            
            out.print("\r\n" + superhero + " " +  kills +  " " +  lives);
            out.close();
        } 
        catch(FileNotFoundException ex) {
            /* handle exception*/
        }
    }
    
    public void readFile(){
        try{
            Scanner s = new Scanner(new File(filename));
            while(s.hasNextLine()){
                System.out.println(s.nextLine());
            }  
        }catch(FileNotFoundException ex){
            /* handle exception*/
        }
           
    }
    
    
    
}
