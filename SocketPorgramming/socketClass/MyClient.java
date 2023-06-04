package SocketPorgramming.socketClass;

import java.io.*;  
import java.net.*;  
public class MyClient {  
    public static void main(String[] args) {  
        try{      
            String serverAddress = "127.0.0.3"; // Specify the desired IP address
            String clientAddress = "127.0.0.4";
            int serverPort = 6666;
            int clientPort = 7000;
           

            //constructors

            //Socket clienSocket= new Socket(InetAddress.getByName(serverAddress),6666);
            Socket clienSocket=new Socket(InetAddress.getByName(serverAddress),serverPort,InetAddress.getByName(clientAddress), clientPort);
            //if we use "localhost" here that means we are connecting to 127.0.0.1(server)--so server must be connected using 127.0.0.1
            //Socket clienSocket= new Socket("localhost",6666);
            

            //return the ip of the server that is connectes
            InetAddress serverIP=clienSocket.getInetAddress();

            System.out.println("server Host Name is "+serverIP.getHostName());
            System.out.println("server adress is "+serverIP.getHostAddress());
            System.out.println("server port is "+clienSocket.getPort());
          ;  
            clienSocket.close();  
        }catch(Exception e){
            System.out.println(e);
        }  
        }  
}  


//output
// server Host Name is 127.0.0.3
// server adress is 127.0.0.3
// server port is 6666