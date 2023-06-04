package SocketPorgramming.getInputStreamMethod.clientServerExample;

import java.io.*;  
import java.net.*;  

public class MyServer {  
    public static void main(String[] args){  

       
        try{  
            ServerSocket serverSocket=new ServerSocket(6666);
            
            while(true){
            Socket connectionSocket=serverSocket.accept();//establishes connection

            DataInputStream dis=new DataInputStream(connectionSocket.getInputStream());  

            String  string=(String)dis.readUTF();  

            System.out.println("message= "+ string);  
           // serverSocket.close(); 
            }
        }catch(Exception e){
            System.out.println(e);
        }  
         
    }
}  
