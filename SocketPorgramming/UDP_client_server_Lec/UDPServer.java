package SocketPorgramming.UDP_client_server_Lec;

import java.io.*;
import java.net.*;

public class UDPServer {
    public static void main(String[] args) throws Exception {

        DatagramSocket serverSocket= new DatagramSocket(9876);


        byte[] receiveData= new byte[1024];
        byte[]  sendData= new byte[1024];

        while(true){
            
            //creating a receiving packet to receive data from client
            DatagramPacket receivePacket= new DatagramPacket(receiveData, receiveData.length);
            //receiving data using server socket
            serverSocket.receive(receivePacket);

            String clientText= new String(receivePacket.getData());

            System.out.println("client sent- "+clientText);

            //getting the client destination address and port number
            InetAddress IPAdress= receivePacket.getAddress();
            int port            = receivePacket.getPort();

            //client IP and port
            System.out.println(port+"  "+IPAdress.getHostAddress());

            String modifiedText= clientText.toUpperCase();
            sendData= modifiedText.getBytes();

            //cereating a Datagram Packet to sent to the clietn
            DatagramPacket sendpacket = new DatagramPacket(sendData, sendData.length, IPAdress, port);
            //seding from the server socket

            serverSocket.send(sendpacket);



        }
        

    }
    
}
