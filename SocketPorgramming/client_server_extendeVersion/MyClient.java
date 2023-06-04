package SocketPorgramming.client_server_extendeVersion;

import java.net.*;  
import java.io.*;  
class MyClient{  
    public static void main(String args[])throws Exception{

            Socket clientSocket=new Socket("localhost",3333);

            //input stream 
            DataInputStream din=new DataInputStream(clientSocket.getInputStream());  

            //output stream
            DataOutputStream dout=new DataOutputStream(clientSocket.getOutputStream()); 

            //Bufferreader-read String from character input stream
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
            
            String str="",str2=""; 
            
            
            while(!str.equals("stop")){ 
                
                //sent msg to server(so in client first we sent outputs)
                str=br.readLine(); 
                //writes a string to the underlying output stream using modified UTF-8 encoding. 
                dout.writeUTF(str); 
                dout.flush(); 

                //read msg from server
                //read a string from the underlying input stream, decoding bytes according to the UTF-8 format
                str2=din.readUTF();  
                System.out.println("Server says: "+str2);  
            }  
            
            dout.close();  
            clientSocket.close();  
}
}  