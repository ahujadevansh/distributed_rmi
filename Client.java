import java.net.MalformedURLException; 
import java.rmi.Naming; 
import java.rmi.NotBoundException; 
import java.rmi.RemoteException; 
import java.io.*;

public class Client {

    public static void main(String args[]) throws RemoteException, MalformedURLException, NotBoundException{

        LoadBalancingInterface lb = (LoadBalancingInterface) Naming.lookup("rmi://10.0.2.9/LoadBalancing");

        String serverName = lb.getActiveServer();

        ServerInterface s = (ServerInterface) Naming.lookup("rmi://10.0.2.9/" + serverName);

        System.out.println(s.add(9, 10000));
    }
}