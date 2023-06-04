package SocketPorgramming.InetAdress;

import java.net.*;


public class InetAddressTest {

    public static void main(String[] args) {
        
        try{

            //getByname()
            InetAddress ip=InetAddress.getByName("courseweb.sliit.lk");
            System.out.println("Host Name: "+ip.getHostName());
            System.out.println("IP Address: "+ip.getHostAddress());

            System.out.println();

            //getAllByName()
            InetAddress ip1[] = InetAddress.getAllByName("www.javatpoint.com");  
            System.out.println(ip1);

            System.out.println();

            //getLocalHost()
            InetAddress ia = InetAddress.getLocalHost();  
            String str = ia.getHostAddress();  
            System.out.println(str);  

        }catch(UnknownHostException e)
        {
            System.out.println("No address found for the hostName");
        }
    }   

    
    
}
