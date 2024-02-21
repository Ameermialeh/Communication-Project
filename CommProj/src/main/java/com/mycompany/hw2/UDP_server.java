/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hw2;


import java.awt.Color;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 *
 * @author Ameer
 */
public class UDP_server extends Thread{
    public int port;
    public void portR(int portnum) {
        this.port = portnum;
    }

    @Override
    public void run ()
    {
        super.run (); 
        try {   
            String patern = "MM/dd/yyyy HH:mm:ss";
            DateFormat df = new SimpleDateFormat(patern);
            Date the_time = Calendar.getInstance().getTime();
            String todayAsString = df.format(the_time);

            SimpleAttributeSet keyWord = new SimpleAttributeSet();    // color for text pane
            StyleConstants.setForeground(keyWord, Color.BLUE);
            StyleConstants.setBackground(keyWord, Color.WHITE);
            StyleConstants.setBold(keyWord, true);
            DatagramSocket serverSocket = new DatagramSocket(port);
            byte[] receiveData = new byte[1024];
            while(true)
            {
                  DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                  serverSocket.receive(receivePacket); 

                  String sentence = new String(receivePacket.getData()); 
                  String []msg = sentence.split(String.valueOf(','));

                  UDP_client.udpserver.getStyledDocument().insertString( UDP_client.udpserver.getStyledDocument().getLength() , msg[3]+" :  " + msg[0] + "              "+todayAsString + "\n" , keyWord);
                  UDP_client.status.setText("recieve from IP : " + msg[1] + " port number :"+msg[2]);
            }
        } catch (SocketException ex) {
            Logger.getLogger(UDP_server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | BadLocationException ex) {
            Logger.getLogger(UDP_server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
