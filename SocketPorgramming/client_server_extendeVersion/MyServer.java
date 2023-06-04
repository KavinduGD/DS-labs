package SocketPorgramming.client_server_extendeVersion;

import java.net.*;  
import java.io.*;  
class MyServer{  
    public static void main(String args[])throws Exception{  

        ServerSocket serverSocket=new ServerSocket(3333);  
        Socket connectionSocket=serverSocket.accept();  

        //input stream
        DataInputStream din=new DataInputStream(connectionSocket.getInputStream());  

        //output stream
        DataOutputStream dout=new DataOutputStream(connectionSocket.getOutputStream());  

         //Bufferreader-read String from character input stream
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
        
        String str="",str2="";  

        while(!str.equals("stop")){  

            //read the msg that client sent(so in server first get the inputs from the  clieint)
            str=din.readUTF();  
            System.out.println("client says: "+str); 
            
            //sent msg to client
            str2=br.readLine();  
            dout.writeUTF(str2);  
            dout.flush(); 

            }  
            din.close();  
            serverSocket.close();  
            connectionSocket.close();  
    }
}  
