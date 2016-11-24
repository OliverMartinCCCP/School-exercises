package be.howest.ti.pokedex.comm;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;




public class MessageIO {

    ObjectInputStream in;    
    ObjectOutputStream out;
    
    public MessageIO(Socket s){
        try {
            // OUTPUTSTREAM nodig om INPUTSTREAM aan te maken, dus in deze volgorde:
            out = new ObjectOutputStream( s.getOutputStream() );
            in = new ObjectInputStream( s.getInputStream() );
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void send(Message msg){
        try {
            out.writeObject(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public Message receive() {
        try {
            
            return (Message) in.readObject();
            
        } catch (IOException ex) {
            //Logger.getLogger(MessageIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(MessageIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
