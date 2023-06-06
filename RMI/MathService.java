package RMI;

import java.math.BigInteger;
import java.rmi.*;


public interface MathService extends Remote {


    public long factorial  (int number) throws RemoteException;

    public boolean checkPrime(int number) throws RemoteException;

    public BigInteger square( int number) throws RemoteException;
    
}
