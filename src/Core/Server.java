/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

/**
 * 
 * Server core of the application
 * 
 */

public class Server {
    
    private PrintWriter output;
    
    public static void main(String[] args) {
       new Server();
    }
  
    
     public void sendMsg(String msg){//to client 1
          
         //String userInput="Server : "+ scanner.nextLine();
          String userInput="Server : "+msg;
                    output.println(userInput); 
          
          
      } 
            
    
    
      public Server()
    {
        
        //We need a try-catch because lots of errors can be thrown
        try {
            ServerSocket sSocket = new ServerSocket(5000);
            System.out.println("Server started at: " + new Date());
             
             InetAddress myIP= InetAddress.getLocalHost();
             System.out.println("server ip address is "+myIP.getHostAddress());
            
             new SysTrayChat().setMessage("server ip address is "+myIP.getHostAddress());
             //Systray("server ip address is "+myIP.getHostAddress());
             
             
            //Loop that runs server functions
            while(true) {
                //Wait for a client to connect
                Socket socket = sSocket.accept();
                System.out.println("Connected to client at : "+ socket.getInetAddress());
             
                 
                //Create a new custom thread to handle the connection
                ClientThread cT = new ClientThread(socket);
                 
                //Start the thread!
                new Thread(cT).start();
                 
            }
        } catch(IOException exception) {
            System.out.println("Error: " + exception);
        }
        
               
    }
    
      
      
      
      
      
      
      
      
      
      
      
    //Here we create the ClientThread inner class and have it implement Runnable
    //This means that it can be used as a thread
    class ClientThread implements Runnable
    {
        Scanner scanner = new Scanner(System.in);
        Socket threadSocket;
         
        //This constructor will be passed the socket
        public ClientThread(Socket socket)
        {
            //Here we set the socket to a local variable so we can use it later
            threadSocket = socket;
        }
         
        public void run()
        {
            //All this should look familiar
            try {
                //Create the streams
                output = new PrintWriter(threadSocket.getOutputStream(), true);
                BufferedReader input = new BufferedReader(new InputStreamReader(threadSocket.getInputStream()));
                 
                //Tell the client that he/she has connected
                output.println("You have connected at: " + new Date());
                 
                while (true) {
                    
                  
                    
                    //This will wait until a line of text has been sent
                    String chatInput = input.readLine();//read from client
                    System.out.println(chatInput);
                    
                   
                    
                }
                
                
                
            } catch(IOException exception) {
                System.out.println("Error: " + exception);
            }
        }
    }
    
}
