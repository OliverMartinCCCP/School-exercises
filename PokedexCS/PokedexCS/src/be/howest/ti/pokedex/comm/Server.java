package be.howest.ti.pokedex.comm;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Server implements Runnable, MessageHandler{

    MessageIO io;
    
    public static void main(String[] args) {
        Server s = new Server();
        s.run();
    }
    
    public Server() {
        try {
            
            ServerSocket serverSocket = new ServerSocket(1234);
            Socket socket = serverSocket.accept();
            
            io = new MessageIO(socket);
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void run(){
        System.out.println("Server starting...");
        
        
        while ( true ){
            Message msg = io.receive();
            if (msg == null ) break;
            System.out.printf("Server receive: ", msg);
            
            msg.accept(this);
        }
        
        System.out.println("Server stopped");
    }

    @Override
    public void handleResult(Result r) {
        io.send( new Text( "Ik doe ben degene die de resultaten berekent") );
    }

    @Override
    public void handleProduct(Product msg) {
        int prod = msg.a * msg.b;
        io.send(new Result(prod));
    }

    @Override
    public void handleSum(Sum msg) {
        int sum = msg.a + msg.b;
        io.send( new Result(sum) );
    }

    @Override
    public void handleText(Text msg) {
        io.send( new Text("Message: " + msg ));
    }
    
}
