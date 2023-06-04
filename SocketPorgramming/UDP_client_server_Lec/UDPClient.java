package SocketPorgramming.UDP_client_server_Lec;

import java.io.*;
import java.net.*;

public class UDPClient {

    public static void main(String[] args) throws IOException {
        
        BufferedReader inFromUser= new BufferedReader(new InputStreamReader(System.in));

        DatagramSocket clientSocket= new DatagramSocket();

        InetAddress IPAddress= InetAddress.getByName("localhost");

        byte[] sendData= new byte[1024];
        byte[] recieveData= new byte[1024];

        System.out.print("enter a text-");
        String text= inFromUser.readLine();

        sendData=text.getBytes();

        //create a datagram packet to sent to the server
        DatagramPacket sendpacket= new DatagramPacket(sendData,  sendData.length, IPAddress, 9876);
        //sending the send Datagram Packet  to the server from client socket
        clientSocket.send(sendpacket);

        //create a datagram packet to recieve the data from the server
        DatagramPacket receivePacket= new  DatagramPacket(recieveData,recieveData.length);
        //reciving the data using the client socket
        clientSocket.receive(receivePacket);

        String modifiedtext= new String(receivePacket.getData());

        System.out.println("Modified text from the server- "+modifiedtext);

        clientSocket.close();
        
    }
    
}
