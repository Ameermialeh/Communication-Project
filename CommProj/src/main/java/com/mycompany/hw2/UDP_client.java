
package com.mycompany.hw2;


import java.awt.Color;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class UDP_client extends javax.swing.JFrame {

     static void displayInterfaceInformation(NetworkInterface netint) throws SocketException {
        Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
        int i=0;
        InetAddress req=null;
        for (InetAddress inetAddress : Collections.list(inetAddresses)) {       
            if (i == 0)
                 req = inetAddress;  
            i++;
        }
       if ( i == 2){
          jComboBox1.addItem(netint.getName()+":"+req.toString().substring(1, req.toString().length()));
        }
     }
     
    public UDP_client() {
       try {
            initComponents();
            Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
            for (NetworkInterface netint : Collections.list(nets))
                displayInterfaceInformation(netint);
            LocalIP.setText(jComboBox1.getSelectedItem().toString().split(":")[1]);
            LocalIP.setEditable(false);
        } catch (SocketException ex) {
            Logger.getLogger(UDP_client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Username = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        login = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        udpserver = new javax.swing.JTextPane();
        EnterText = new javax.swing.JTextField();
        Lstatus = new javax.swing.JLabel();
        status = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TCP_IP = new javax.swing.JTextField();
        TCP_Port = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        LocalIP = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        LocalPort = new javax.swing.JTextField();
        RemoteIP = new javax.swing.JTextField();
        RemotePort = new javax.swing.JTextField();
        Send = new javax.swing.JButton();
        SendAll = new javax.swing.JButton();
        OnlineUsers = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        Password = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        TPonlineusers = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        Username.setText("Username :");

        login.setForeground(new java.awt.Color(255, 0, 0));
        login.setText("Login");
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginMouseClicked(evt);
            }
        });

        Logout.setText("Logout");
        Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutMouseClicked(evt);
            }
        });

        jScrollPane1.setViewportView(udpserver);

        EnterText.setForeground(new java.awt.Color(153, 153, 153));
        EnterText.setText("Enter Text here");
        EnterText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EnterTextMouseClicked(evt);
            }
        });

        Lstatus.setText("Status :");

        jLabel1.setText("TCP Server IP :");

        jLabel2.setText("TCP server Port :");

        jLabel3.setText("Available Interfaces :");

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jLabel4.setText("Local IP :");

        jLabel5.setText("Local port :");

        jLabel6.setText("Remote IP : ");

        jLabel7.setText("Remote Port : ");

        Send.setText("Send");
        Send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendActionPerformed(evt);
            }
        });

        SendAll.setText("Send All");
        SendAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendAllActionPerformed(evt);
            }
        });

        OnlineUsers.setText("Online Users");
        OnlineUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnlineUsersActionPerformed(evt);
            }
        });

        jLabel8.setText("Password :");

        TPonlineusers.setColumns(20);
        TPonlineusers.setRows(5);
        jScrollPane3.setViewportView(TPonlineusers);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(Lstatus)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
                        .addComponent(jScrollPane1)
                        .addComponent(EnterText))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Username)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(username)
                            .addComponent(Password, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(login)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Logout)))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TCP_IP, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(TCP_Port)))
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LocalIP)
                            .addComponent(LocalPort)
                            .addComponent(RemoteIP)
                            .addComponent(RemotePort, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Send, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(SendAll, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(OnlineUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(TCP_IP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OnlineUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TCP_Port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(LocalIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(LocalPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(RemoteIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(RemotePort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Send, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SendAll, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Username))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(EnterText, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Lstatus)
                            .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseClicked
        // TODO add your handling code here:
        UDP_server udps = new UDP_server();  
        udps.portR(Integer.parseInt(LocalPort.getText()));
        udps.start();
        String us = username.getText();
        String ps = Password.getText();
        String sentence;
        String modifiedSentence;
        try {
            try (Socket clientSocket = new Socket(LocalIP.getText() ,Integer.parseInt(TCP_Port.getText()))) {
                DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
                BufferedReader inFromServer =new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                sentence ="Login"+','+ us +','+ ps + ',' + LocalIP.getText() +','+ LocalPort.getText() +','+ TCP_Port.getText() +','+TCP_IP.getText()+ "\n";
                outToServer.writeBytes(sentence);
                modifiedSentence = inFromServer.readLine();
                status.setText(" ");
                status.setText(modifiedSentence);
                clientSocket.close();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(com.mycompany.udp.UDP_client.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(status.getText().equals("Logged in Successful")){
            login.setEnabled(false); 
            Logout.setEnabled(true);
            username.setEnabled(false);
            Password.setEnabled(false);
        }

    }//GEN-LAST:event_loginMouseClicked

    private void LogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutMouseClicked
        // TODO add your handling code here:
        String us = username.getText();
        String ps = Password.getText();
        String sentence;
        String modifiedSentence;
        try {
            try (Socket clientSocket = new Socket(LocalIP.getText() ,Integer.parseInt(TCP_Port.getText()))) {
                DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
                BufferedReader inFromServer =new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                sentence ="Logout"+','+ us +','+ ps + ',' + LocalIP.getText() +','+ LocalPort.getText() +','+TCP_Port.getText()+"\n";
                outToServer.writeBytes(sentence);
                modifiedSentence = inFromServer.readLine();
                status.setText(" ");
                status.setText(modifiedSentence);
                clientSocket.close();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(com.mycompany.udp.UDP_client.class.getName()).log(Level.SEVERE, null, ex);
        }
        login.setEnabled(true);  
        Logout.setEnabled(false);
        username.setEnabled(true);
        Password.setEnabled(true);
        username.setText("");
        Password.setText("");
        LocalPort.setText("");
        TCP_Port.setText("");
        TCP_IP.setText("");
        //udps.stop();
    }//GEN-LAST:event_LogoutMouseClicked

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        LocalIP.setText(jComboBox1.getSelectedItem().toString().split(":")[1]);
        TCP_IP.setText(jComboBox1.getSelectedItem().toString().split(":")[1]);
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void SendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendActionPerformed
        // TODO add your handling code here:
       
        String patern = "MM/dd/yyyy HH:mm:ss";
        DateFormat df = new SimpleDateFormat(patern);
        Date the_time = Calendar.getInstance().getTime();
        String todayAsString = df.format(the_time);
        
        SimpleAttributeSet keyWord = new SimpleAttributeSet();    // color for text pane
        StyleConstants.setForeground(keyWord, Color.RED);
        StyleConstants.setBackground(keyWord, Color.WHITE);
        StyleConstants.setBold(keyWord, true);
        try{
          
              DatagramSocket clientSocket = new DatagramSocket() ;//create client socket
          
              InetAddress IPAddress = InetAddress.getByName(RemoteIP.getText());   //local host IP address
              byte[] sendData = new byte[1024];
              int port = Integer.parseInt(RemotePort.getText());
              
              String a,b,c;
              a=LocalIP.getText();
              b=LocalPort.getText();
              c=username.getText();
              String sentence = EnterText.getText()+ ',' +a+ ','+b + ','+c;
              
              sendData = sentence.getBytes();                                 // convert string to bytes to transmit it bu UDP
              DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress,port ); // initialize packet to send
             
              clientSocket.send(sendPacket);
              
              String []msg = sentence.split(String.valueOf(','));
              udpserver.getStyledDocument().insertString(udpserver.getStyledDocument().getLength() ,"Me :"+msg[0] +"              "+ todayAsString   +"\n" ,keyWord);
              EnterText.setText("Enter text here");
              EnterText.setForeground(new Color(153,153,153));
              
              
          //local host IP address
        } catch (IOException ex) {
            Logger.getLogger(com.mycompany.udp.UDP_client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadLocationException ex) {
             Logger.getLogger(UDP_client.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }//GEN-LAST:event_SendActionPerformed

    private void EnterTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EnterTextMouseClicked
        // TODO add your handling code here:
        EnterText.setText("");
        EnterText.setForeground(Color.black);
    }//GEN-LAST:event_EnterTextMouseClicked

    private void SendAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendAllActionPerformed
        // TODO add your handling code here:
         String patern = "MM/dd/yyyy HH:mm:ss";
        DateFormat df = new SimpleDateFormat(patern);
        Date the_time = Calendar.getInstance().getTime();
        String todayAsString = df.format(the_time);
        
        SimpleAttributeSet keyWord = new SimpleAttributeSet();    // color for text pane
        StyleConstants.setForeground(keyWord, Color.RED);
        StyleConstants.setBackground(keyWord, Color.WHITE);
        StyleConstants.setBold(keyWord, true);
            
        String us = username.getText();
        String ps = Password.getText();
        String sentence;
        String modifiedSentence;
        
        try {
            DatagramSocket clientSocket1 = new DatagramSocket() ;//create client socket
            Socket clientSocket = new Socket(LocalIP.getText() ,Integer.parseInt(TCP_Port.getText())); 
            
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer =new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            sentence ="SendAll"+','+ us +','+ ps + ',' + LocalIP.getText() +','+ LocalPort.getText() +','+TCP_Port.getText()+"\n";
            
            outToServer.writeBytes(sentence);

            modifiedSentence = inFromServer.readLine();
                
            String []pall = modifiedSentence.split(",");
            
           
            
            for(int i=1 ; i < pall.length  ; i=i+2 ){
                if( !pall[i].equals(LocalPort.getText()) ){
                    InetAddress IPAddress = InetAddress.getByName(pall[i+1]);   //local host IP address
                    byte[] sendData = new byte[1024];
                    int port = Integer.parseInt(pall[i]);

                    String a,b,c;
                    a = LocalIP.getText();
                    b = LocalPort.getText();
                    c = username.getText();
                    String sentence1 = EnterText.getText()+ ',' +a+ ','+b + ','+c;

                    sendData = sentence1.getBytes();                                 // convert string to bytes to transmit it bu UDP
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress,port ); // initialize packet to send

                    clientSocket1.send(sendPacket);
                }    
            }
            
            
            udpserver.getStyledDocument().insertString(udpserver.getStyledDocument().getLength() ,"Me to All :"+EnterText.getText() +"              "+ todayAsString   +"\n" ,keyWord);
            EnterText.setText("Enter text here");
            EnterText.setForeground(new Color(153,153,153));
            clientSocket.close();
            
        } catch (IOException ex) {
            Logger.getLogger(com.mycompany.udp.UDP_client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadLocationException ex) {
             Logger.getLogger(UDP_client.class.getName()).log(Level.SEVERE, null, ex);
         }
       
        
    }//GEN-LAST:event_SendAllActionPerformed

    private void OnlineUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnlineUsersActionPerformed
        // TODO add your handling code here:
        String us = username.getText();
        String ps = Password.getText();
        String sentence;
        String modifiedSentence;
        try {
            try (Socket clientSocket = new Socket(LocalIP.getText() ,Integer.parseInt(TCP_Port.getText()))) {
                DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
                BufferedReader inFromServer =new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                sentence ="SendAll"+','+ us +','+ ps + ',' + LocalIP.getText() +','+ LocalPort.getText() +','+ TCP_Port.getText() + "\n";
                outToServer.writeBytes(sentence);
                modifiedSentence = inFromServer.readLine();
                
                TPonlineusers.setText("");
                String []on = modifiedSentence.split(",");
                
                for (int i = 1 ; i < on.length ; i=i+2) {
                    if( !on[i].equals(LocalPort.getText()) ){
                            TPonlineusers.append(on[i+1] + " , "+on[i] +"\n");
                    }
                }
                clientSocket.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(com.mycompany.udp.UDP_client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_OnlineUsersActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UDP_client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UDP_client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UDP_client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UDP_client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UDP_client().setVisible(true);
                //udps = new UDP_server();                
            }
        });
    }
    //public static UDP_server udps;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField EnterText;
    public static javax.swing.JTextField LocalIP;
    public static javax.swing.JTextField LocalPort;
    private javax.swing.JButton Logout;
    private javax.swing.JLabel Lstatus;
    private javax.swing.JButton OnlineUsers;
    private javax.swing.JTextField Password;
    private javax.swing.JTextField RemoteIP;
    private javax.swing.JTextField RemotePort;
    private javax.swing.JButton Send;
    private javax.swing.JButton SendAll;
    private javax.swing.JTextField TCP_IP;
    private javax.swing.JTextField TCP_Port;
    public static javax.swing.JTextArea TPonlineusers;
    private javax.swing.JLabel Username;
    public static javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton login;
    public static javax.swing.JTextField status;
    public static javax.swing.JTextPane udpserver;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
