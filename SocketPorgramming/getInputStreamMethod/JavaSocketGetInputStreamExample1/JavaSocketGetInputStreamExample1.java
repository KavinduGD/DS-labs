package SocketPorgramming.getInputStreamMethod.JavaSocketGetInputStreamExample1;
 
import java.io.BufferedInputStream;  
import java.io.DataInputStream;  
import java.io.IOException;  
import java.net.*;  
public class JavaSocketGetInputStreamExample1  {  
    public static void main(String[] args) throws IOException {  
        Socket socket = new Socket();  
        InetAddress inetAddress=InetAddress.getByName("localhost");  
        int port=1085;  
        
        //calling the constructor of the SocketAddress class  
        SocketAddress socketAddress=new InetSocketAddress(inetAddress, port);  
        //binding the  socket with the inetAddress and port number  
        socket.bind(socketAddress);  
        //connect() method connects the specified socket to the server  
        socket.connect(socketAddress);  

        DataInputStream inputStream=new DataInputStream(  
                new BufferedInputStream(socket.getInputStream()));  
        System.out.println("Input Stream: "+inputStream);  
    }  
 }