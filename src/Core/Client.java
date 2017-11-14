package Core;

import GUI.frmClient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.net.Socket;
import java.net.UnknownHostException;


//import java.util.Scanner;



/**
 *
 * Client core of the app
 */
public class Client {
   
  private  String userInput;
  private  PrintWriter output;
  private  BufferedReader input;
  
 frmClient   window;
 
   public void SetsendChat(String msgSent)
   {
       userInput=msgSent;
       output.println(userInput);
   }        
   
  private String getChatMessage() throws IOException{//from server
      String receiveMessage="";

            receiveMessage = input.readLine();
         
        
        
   return receiveMessage;     
  }
   
  public void start()
  {
           boolean work=true;
                    
             while (work) { 
                 
                 try {
                   window.updateChatWindow(getChatMessage());
                   
                 } catch (IOException ex) {
                     work=false;
                       System.out.println("Receive message "+ex.getMessage());
                 }
 
    }
  }
  
   public Client(frmClient   window){
      
     this.window=window;  
        try {
            Socket  socket=new Socket("localhost", 5000);
            //Socket  socket=new Socket("192.168.1.3", 5000);
           // Socket  socket=new Socket("192.168.1.3", 5000);
            
            System.out.println("connected to server at " +socket.getInetAddress());
       
            output = new PrintWriter(socket.getOutputStream(), true);//to server
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));//from server
             
            //This will wait for the server to send the string to the client saying a connection
            //has been made.
            
            String inputString = input.readLine();
            System.out.println(inputString);
            
            //Again, here is the code that will run the client, this will continue looking for
            //input from the user then it will send that info to the server.
            
            
           //while(true) {
                //Here we look for input from the user
          // String userInput ="client 1 "+ scanner.nextLine();
                
                //Now we write it to the server
         //  output.println(userInput);
              
           
               
                 
                 
          
 
               
               
           // }
            
        } catch (UnknownHostException ex) {
            System.out.println("host Exception "+ex);
        } catch (IOException ex) {
            System.out.println("io exception "+ex);
        }
        
    
    }
   
 
}