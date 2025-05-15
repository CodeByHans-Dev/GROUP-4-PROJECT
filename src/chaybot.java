/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.io.*;
import java.net.*;
import javax.net.ssl.HttpsURLConnection;
import javax.swing.JTextArea;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import org.json.JSONObject;
import org.json.JSONArray;
import javax.swing.JComboBox;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;



/**
 *
 * @author xx
 */
public class chaybot extends JFrame {

    private JPopupMenu popupMenu;
    private DefaultListModel<String> listModel;
    private JList<String> suggestionList;
    private String[] suggestions = {
            
             "What is the alumni registration process?",
    "How can I update my profile?",
    "Where is Caybiga High School located?",
    "How do I reset my password?",
    "Who do I contact for support?",
    "Show my previous chats",
    "Clear chat history",
    "Hello",
    "Hi",
    "Goodbye",
    "What are the benefits of being an alumni?",
    "How do I join the alumni network?",
    "Can I access old exam papers?",
    "How do I donate to the school?",
    "What events are happening for alumni?",
    "How do I change my email address?"
    };

    

    public chaybot() {
         initComponents();
        initSuggestionPopup();
    }

 public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chaybot().setVisible(true);
            }
        });
    }
    /**
     * Creates new form chaybot
     */
    private void initSuggestionPopup() {
    popupMenu = new JPopupMenu();
    listModel = new DefaultListModel<>();
    suggestionList = new JList<>(listModel);

    suggestionList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    suggestionList.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 1) {
                // Set the text to the selected suggestion
                 String selectedSuggestion = suggestionList.getSelectedValue();
                chatArea.setText(suggestionList.getSelectedValue());
                popupMenu.setVisible(false); // Hide the popup after selection
                chatArea.requestFocusInWindow(); // Keep focus on the text field
            }
        }
    });

    JScrollPane scrollPane = new JScrollPane(suggestionList);
    scrollPane.setBorder(null);
    popupMenu.add(scrollPane);

    // Handle key events for showing/hiding popup and filtering suggestions
    chatArea.addKeyListener(new KeyAdapter() {
        public void keyReleased(KeyEvent e) {
            String text = chatArea.getText().toLowerCase();
            listModel.clear();

            if (!text.isEmpty()) {
                // Filter suggestions based on the typed text
                for (String suggestion : suggestions) {
                    if (suggestion.toLowerCase().startsWith(text)) {
                        listModel.addElement(suggestion);
                    }
                }

                // Show the popup if there are matching suggestions
                if (!listModel.isEmpty()) {
                    // Only show the popup if it's not visible
                    if (!popupMenu.isVisible()) {
                        popupMenu.show(chatArea, 0, chatArea.getHeight());
                    }
                    popupMenu.setPopupSize(chatArea.getWidth(), 100);
                } else {
                    popupMenu.setVisible(false); // Hide if no suggestions
                }
            } else {
                popupMenu.setVisible(false); // Hide if the text is empty
            }
        }
    });

    // Ensuring the popup doesn't steal focus
    popupMenu.addPopupMenuListener(new PopupMenuListener() {
        public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
            // Request focus back to the chatArea, ensuring it stays active
            SwingUtilities.invokeLater(() -> chatArea.requestFocusInWindow());
        }

        public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
            // No need for any additional behavior here
        }

        public void popupMenuCanceled(PopupMenuEvent e) {
            // Same as invisible, no additional behavior needed
        }
    });



    
}
  private String getBotResponse(String input) {
    input = input.toLowerCase();
 input = input.toLowerCase();

      if (input.equals("hello")) {
        return "Hello there! How can I help you today?";
    } else if (input.equals("hi")) {
        return "Hello there! How can I help you today?";
    } else if (input.equals("goodbye")) {
        return "Goodbye! Have a great day!";
    } else if (input.equals("what is the alumni registration process?")) {
        return "The alumni registration process involves filling out a form with your personal details and batch information. After submission, you'll gain access to alumni services.";
    } else if (input.equals("how can i update my profile?")) {
        return "To update your profile, go to your account settings and click 'Edit Profile'. You can change your personal details there.";
    } else if (input.equals("where is caybiga high school located?")) {
        return "Caybiga High School is located in Caybiga, North Caloocan, Metro Manila, Philippines.";
    } else if (input.equals("how do i reset my password?")) {
        return "To reset your password, click on 'Forgot Password' on the login page and follow the instructions sent to your registered email.";
    } else if (input.equals("who do i contact for support?")) {
        return "You can contact support by emailing support@caybigahs.edu.ph or calling our hotline at 1-800-ALUMNI.";
    } else if (input.equals("show my previous chats")) {
        return "Sorry, I currently don't have access to your previous chats. But feel free to ask me anything!";
    } else if (input.equals("clear chat history")) {
        return "Your chat history has been cleared.";
    } else if (input.equals("what are the benefits of being an alumni?")) {
        return "As an alumni, you get access to networking opportunities, career support, school events, and discounts on certain services.";
    } else if (input.equals("how do i join the alumni network?")) {
        return "You can join the alumni network by signing up on our alumni portal, where you can fill out your details and become a member.";
    } else if (input.equals("can i access old exam papers?")) {
        return "Old exam papers can be accessed through the alumni portal after registration. Log in and visit the 'Resources' section.";
    } else if (input.equals("how do i donate to the school?")) {
        return "You can donate to the school through our website's donation page. Your support helps improve our facilities and provide scholarships for students.";
    } else if (input.equals("what events are happening for alumni?")) {
        return "Check the alumni portal for upcoming events such as reunions, networking gatherings, and fundraising activities.";
    } else if (input.equals("how do i change my email address?")) {
        return "To change your email address, go to your account settings and update the email field. Make sure to verify your new email address.";
    } else {
        return "I'm not sure how to respond to that. Try asking something else!";
    }
}
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        chatArea = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(255, 102, 0));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Chatbot");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(318, 318, 318)
                .addComponent(jLabel4)
                .addContainerGap(322, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel4)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        chatArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chatAreaActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(255, 102, 0));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton6.setText("Profile");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton7.setText("User Mangement");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton8.setText("Chatbot\n");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton10.setText("Home\n\n");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
            .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel3)
                .addGap(54, 54, 54)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(252, Short.MAX_VALUE))
        );

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("ENTER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chatArea, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chatArea, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
         NewJFrame profilePage = new NewJFrame(); // Create Profile window
    profilePage.setVisible(true); // Show Profile window
    this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        NewJFrame2 profilePage = new NewJFrame2(); // Create Profile window
    profilePage.setVisible(true); // Show Profile window
    this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        NewJFrame1 profilePage = new NewJFrame1(); // Create Profile window
    profilePage.setVisible(true); // Show Profile window
    this.dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void chatAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chatAreaActionPerformed
        // TODO add your handling code here:
        
         
    }//GEN-LAST:event_chatAreaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    String userInput = chatArea.getText();
        String botResponse = getBotResponse(userInput);
        jTextArea1.append("You: " + userInput + "\n");
        jTextArea1.append("Bot: " + botResponse + "\n");
        chatArea.setText(""); // Clear text after input
    
    
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField chatArea;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
