/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author LaptopUser
 */
public class SysTrayChat {
    
   private TrayIcon trayIcon;
   private String message="Server Status" ;
   
    void SysTrayChat(){
        
        
         
        if (SystemTray.isSupported()) {

            SystemTray tray = SystemTray.getSystemTray();
             Image image = Toolkit.getDefaultToolkit().getImage("chat.gif");
            
             trayIcon = new TrayIcon(image, "Chat Server");
            
         MouseListener mouseListener = new MouseListener() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    trayIcon.displayMessage("Server",
                            message,
                            TrayIcon.MessageType.INFO);   
                }

              

                @Override
                public void mouseEntered(MouseEvent e) {
                    trayIcon.displayMessage("Server",
                            message,
                            TrayIcon.MessageType.INFO);   
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                   
                }

                @Override
                public void mouseExited(MouseEvent e) {
                   
                }

              
         };     
             
         
         
          trayIcon.setImageAutoSize(true);
           trayIcon.addMouseListener(mouseListener);
          
          try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                System.err.println("TrayIcon could not be added.");
            }

            
        } 
    
}

    public void setMessage(String message)
    {
        this.message=message;
    }
    
    
    
}