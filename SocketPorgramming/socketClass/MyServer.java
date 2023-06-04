package SocketPorgramming.socketClass;

 
import java.net.*; 


public class MyServer {  
    public static void main(String[] args){

            try{  

                String serverAddress = "127.0.0.3"; // Specify the desired IP address
                int serverPort=6666;

                //ServerSocket ss=new ServerSocket(6666); 
                ServerSocket serverSocket = new ServerSocket(serverPort, 10, InetAddress.getByName(serverAddress));

                while(true){

                    Socket connSocket=serverSocket.accept();//establishes connection  (return the connnection socket if client try to connect)

                    //return server socker ip
                    InetAddress serverIP=serverSocket.getInetAddress();
                    System.out.println("server Host Name is "+serverIP.getHostName());
                    System.out.println("server address is "+serverIP.getHostAddress());
                    //return the port that server socket is listening
                    System.out.println("server Port is "+serverSocket.getLocalPort());
                    

                    //client socket===  connecion socket
                    //return the port that connection socket 
                    InetAddress connSocketIP=connSocket.getInetAddress();
                    System.out.println("client Host Name is "+ connSocketIP.getHostName());
                    System.out.println("client adress is "+ connSocketIP.getHostAddress());
                    System.out.println("clientr port is "+ connSocket.getPort());

               
                }
                // DataInputStream dis=new DataInputStream(s.getInputStream());  

                // String  str=(String)dis.readUTF();  

                // System.out.println("message= "+str); 

                //ss.close();  
            }catch(Exception e){
                System.out.println(e);
            }  
            }  
}  


//output

// server Host Name is 127.0.0.3
// server address is 127.0.0.3
// server Port is 6666
// client Host Name is 127.0.0.4
// client adress is 127.0.0.4
// clientr port is 7000
// server Host Name is 127.0.0.3
// server address is 127.0.0.3
// server Port is 6666