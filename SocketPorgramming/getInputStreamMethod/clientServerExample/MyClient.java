package SocketPorgramming.getInputStreamMethod.clientServerExample;

import java.io.*;  
import java.net.*;  
public class MyClient {  
        public static void main(String[] args) { 
             
                    try{      
                    Socket clientSocket=new Socket("localhost",6666);

                    //return a output stream assosate with the socket
                    DataOutputStream dout=new DataOutputStream(clientSocket.getOutputStream()); 

                    dout.writeUTF("Hello Server "); 

                    //flush() method flushes this output stream and forces any buffered output bytes to be written out 
                    //flush forces thing we can use with out flush also
                    dout.flush(); 
                    System.out.println("message sent");

                    dout.close(); 
                    clientSocket.close();  

                    System.out.println("socket closed");
                }catch(Exception e){
                    System.out.println(e);
                }  
                }  
        }  