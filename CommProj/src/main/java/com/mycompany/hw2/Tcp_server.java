/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hw2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
/**
 *
 * @author Ameer
 */
public class Tcp_server extends Thread{

    public String get_file_content() throws IOException{
        //File mf = new File("OnlineUsers.txt");
        byte [] string = Files.readAllBytes(Paths.get("OnlineUsers.txt"));
        //byte [] string = FileUtils.readFileToByteArray(mf);
        String filecontent = new String(string);
        return filecontent ;
    }
    
    void display_online_users(File mf ){
        FileReader mfr;
        BufferedReader mbr;
        String line ;
        if(mf.exists()){
            try{  
                mfr = new FileReader(mf);
                mbr = new BufferedReader(mfr);
                TCP_serverF.loginUsers.setText("");
                while((line = mbr.readLine()) != null){
                    String []st = line.split(" , ");
                     TCP_serverF.loginUsers.append(st[0] + " , " + st[1] + " , " + st[2] + "\n");
                }
                mfr.close();
                mbr.close();

            }catch (IOException e) {
                System.out.println("An error occurred.");
            }
        }
    }
      
    @Override
public void run(){

   super.run();
   
      File LoginFile = new File("Login.txt");
      File OnlineFile=new File("OnlineUsers.txt");
      
      FileReader mfr;
      BufferedReader mbr;
      
      FileWriter fw;
      BufferedWriter bw;
      
      LinkedList <String> SaveDD; 
      LinkedList <String> PortAll;
      String clientSentence; 
      ServerSocket welcomeSocket;
      String line,St_status="";
      boolean t1=false;
   try{   
      welcomeSocket = new ServerSocket(8888);
      while(true){
          
          Socket connSocket =welcomeSocket.accept();
          DataOutputStream outToClient = new DataOutputStream(connSocket.getOutputStream());
          BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connSocket.getInputStream()));

          clientSentence = inFromClient.readLine();
          String [] sentence = clientSentence.split(String.valueOf(','));
          
        if("Login".equals(sentence[0])){
            mfr =new FileReader(LoginFile);
            mbr = new BufferedReader(mfr);
              
            while ((line = mbr.readLine()) != null){
                String []st = line.split(" ");
                if (st[0].equals(sentence[1]) && st[1].equals(sentence[2])){
                    
                  fw =new FileWriter(OnlineFile,true);
                  bw = new BufferedWriter(fw);
                  
                  bw.write(sentence[1]);
                  bw.write(" , ");
                  bw.write(sentence[3]);
                  bw.write(" , ");
                  bw.write(sentence[4]);
                  bw.write(" , ");
                  bw.write(sentence[5]);
                  bw.write(" , ");
                  bw.write(sentence[6]+"\n");
                  
                  bw.close();
                  fw.close();
                  
                  St_status = "Logged in Successful";
                   break;
                }
                else{
                 St_status = "invalid login information, either user name or password";
                }
            }  
            File mf = new File("OnlineUsers.txt");
            display_online_users(mf);
            outToClient.writeBytes(St_status + "\n");
             // display_online_users(mf);
          }
        else if("Logout".equals(sentence[0])) {
            SaveDD = new LinkedList<String>(); 
            mfr = new FileReader(OnlineFile);
            mbr = new BufferedReader(mfr);

            while((line = mbr.readLine()) != null){
                String []Old = line.split(" , ");                       

                if( Old[3].equals(sentence[5])){ 
                    t1 = !(Old[0].equals(sentence[1]) &&  Old[1].equals(sentence[3]) && Old[2].equals(sentence[4]));
                }
                else{t1=true;}

                if(t1){
                    SaveDD.add(Old[0]);
                    SaveDD.add(" , ");
                    SaveDD.add(Old[1]);
                    SaveDD.add(" , ");
                    SaveDD.add(Old[2]);
                    SaveDD.add(" , ");
                    SaveDD.add(Old[3]);
                    SaveDD.add(" , ");
                    SaveDD.add(Old[4]);
                    SaveDD.add("\n");
                }
            }
            fw = new FileWriter(OnlineFile,false);//declar buffer writer
            bw = new BufferedWriter(fw);

             for(String s:SaveDD){//add linkedlist data to file
                    bw.write(s);
            }
            bw.close();
            fw.close();
            File mf = new File("OnlineUsers.txt");
            display_online_users(mf);

            outToClient.writeBytes("Logout Successfully" + "\n");
        }
        else if("SendAll".equals(sentence[0])) {   
            PortAll = new LinkedList<String>();
            File AllU=new File("OnlineUsers.txt");
            StringBuilder string = new StringBuilder();
            
            FileReader fr;
            BufferedReader br;
            
            fr =new FileReader(AllU);
            br = new BufferedReader(fr);
            
            
            while ((line = br.readLine()) != null){
                String []st = line.split(" , ");
                if (st[3].equals(sentence[5])){
                   PortAll.add(st[1]);
                   PortAll.add(",");
                   PortAll.add(st[2]);
                   PortAll.add(",");
                }
            }
            
            Iterator<?> it = PortAll.descendingIterator();
            while (it.hasNext()) {
                string.append(it.next());
            }
            
            outToClient.writeBytes( string + "\n");
            
        }else{
           String s = get_file_content();
           outToClient.writeBytes(s);
            }
        }
    } catch (IOException ex) {
            Logger.getLogger(com.mycompany.udp.UDP_client.class.getName()).log(Level.SEVERE, null, ex);
        }
 
}
    
}       
