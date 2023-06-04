package SocketPorgramming.UDPPacket;
import java.net.DatagramPacket;
import java.net.InetAddress;

public class DatagramPacketMethodsExample {
    public static void main(String[] args) {
        try {

            byte[] sendData = "Hello".getBytes();

            //creating a recing packet
            DatagramPacket packet = new DatagramPacket(sendData, sendData.length);

            // Accessing packet's data
            byte[] receivedData = packet.getData();
            String receivedMessage = new String(receivedData);
            System.out.println("Received message: " + receivedMessage);



            // Modifying packet's data
            String modifiedMessage = "Hello, modified ";
            byte[] modifiedData = modifiedMessage.getBytes();

            //set Data to a packet
            packet.setData(modifiedData);

            // Setting packet's address and port
            InetAddress serverAddress = InetAddress.getByName("example.com");
            int serverPort = 12345;

            //set Adress and PORT
            packet.setAddress(serverAddress);
            packet.setPort(serverPort);

            // Retrieving packet's address and port
            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            
            System.out.println("Packet destination: " + address + ":" + port);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
