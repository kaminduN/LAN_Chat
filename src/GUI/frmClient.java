/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Core.Client;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;


/**
 *
 * @author LaptopUser
 */
public class frmClient extends javax.swing.JFrame {
    
   private static Client clientside;
  // private frmClient window;
    /**
     * Creates new form frmClient
     */
    public frmClient() {
        initComponents();
        clientside=new Client(this);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtChats = new javax.swing.JTextArea();
        txtChatType = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LAN Chat client");

        txtChats.setColumns(20);
        txtChats.setEditable(false);
        txtChats.setLineWrap(true);
        txtChats.setRows(5);
        jScrollPane1.setViewportView(txtChats);

        txtChatType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtChatTypeKeyPressed(evt);
            }
        });

        btnSend.setText("Send");
        btnSend.setToolTipText("Click to send text");
        btnSend.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtChatType, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtChatType)
                    .addComponent(btnSend, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        
        
     sendChat();
           
         
        
        
    }//GEN-LAST:event_btnSendActionPerformed

    private void txtChatTypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChatTypeKeyPressed
        
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
               sendChat(); 
                
                
            
             
            
        }
        
        
    }//GEN-LAST:event_txtChatTypeKeyPressed

    private void sendChat()
    { 
        
            if (txtChatType.getText().length()>0) {
        String userInput ="client 1 : "+ txtChatType.getText();
        clientside.SetsendChat(userInput);
     
        updateChatWindow(userInput);
     
            }
    
     
    }        
    
    public void updateChatWindow(String receivedMsg)
     {String newLine="\n";
         
         txtChats.append(receivedMsg+newLine);
     txtChats.setCaretPosition(txtChats.getDocument().getLength());
        
     
     
     
     }
    
   
    
    
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
           frmClient   window= new frmClient();
           
                window.setVisible(true);
              //  new frmClient().setVisible(true);
                
            }
        });
       clientside.start();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSend;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtChatType;
    private javax.swing.JTextArea txtChats;
    // End of variables declaration//GEN-END:variables
}
