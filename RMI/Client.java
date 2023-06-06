package RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
//import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

public class Client {

        public static void main(String[] args) {

        // if(System.getSecurityManager()==null){
        //     System.setSecurityManager(new RMISecurityManager());
        // }

      System.setProperty("java.security.policy", "file:allowall.policy");

        String hostName="localhost";

        try {
            MathService service=(MathService) Naming.lookup("//"+hostName+"/MathService");
                
            long number=service.factorial(5);
            System.out.println("factorial is - " + number  );

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {       
            e.printStackTrace();
        }
        
    }
    
}
