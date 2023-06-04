package SocketPorgramming.UDPSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MyUDPExample {
    public static void main(String[] args) {

        try {

            // Create a DatagramSocket
            DatagramSocket socket = new DatagramSocket();

            // Connect to a specific destinaion(default) address and port
            InetAddress serverAddress = InetAddress.getByName("example.com");
            int serverPort = 12345;
            //socket.connect(serverAddress, serverPort);

            // Send data

            String message = "Hello, server!";
            byte[] sendData = message.getBytes();
            //sending packet
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,serverAddress,serverPort);
            socket.send(sendPacket);

            
            // Receive data

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);
            String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received message: " + receivedMessage);

            // Close the socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
