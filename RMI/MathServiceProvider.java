package RMI;

import java.math.BigInteger;
// import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.net.MalformedURLException;
import java.lang.SecurityManager;

public class MathServiceProvider extends UnicastRemoteObject implements MathService{

    public MathServiceProvider() throws RemoteException{
        super();
    }

    @Override
    public long factorial(int number) throws RemoteException {
        if(number==1){
            return 1;
        }
        return number*factorial(number - 1 );
    }


    @Override
    public boolean checkPrime(int number) throws RemoteException {
        if (number <= 1) {
            return false;
        }
        
        if (number <= 3) {
            return true;
        }
        
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        
        return true;
    }

    @Override
    public BigInteger square(int number) throws RemoteException {
        return BigInteger.valueOf(number).pow(2);
    }

  
    public static void main(String[] args) {
        try{
        
            // set the policy file as the system securuty policy
            // if(System.getSecurityManager()==null){
            //     System.setSecurityManager(new RMISecurityManager());
            // }

      System.setProperty("java.security.policy", "file:allowall.policy");

                MathServiceProvider provider= new MathServiceProvider();

                LocateRegistry.getRegistry().bind("MathService",provider);

                System.out.println("Service is bound to RMI registry");
            
        }catch(Exception e){
            System.out.println("can'bind service : "+e.getMessage());
            e.printStackTrace();
        }
    }
    
    
}
