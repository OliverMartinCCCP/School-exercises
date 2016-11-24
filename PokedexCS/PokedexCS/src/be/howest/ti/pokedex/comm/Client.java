package be.howest.ti.pokedex.comm;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;





public class Client {
    
    MessageIO io;
    
    
    public static void main(String[] args) {
        Client c = new Client();
        c.run();
    }
    
    public void run(){
        System.out.println("Client starting");
        
        io.send( new Text("hello"));
        System.out.println( io.receive() );
        
        io.send( new Text("lol"));
        System.out.println( io.receive() );
        
        io.send( new Product(2, 3) );
        System.out.println( io.receive() );
        
        io.send( new Sum(2, 3) );
        System.out.println( io.receive() );
        
        io.send( new Result(2) );
        System.out.println( io.receive() );
        
    }
    
    public Client() {
        try {
            Socket s =  new Socket("localhost", 1234);
            
            io = new MessageIO(s);
            
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
