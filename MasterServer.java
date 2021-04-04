import java.rmi.*;
import java.rmi.registry.*;

class MasterServer {
    String name;
	// Implement the constructor of the class 
	public MasterServer()
	{ 
        try { 
			LocateRegistry.createRegistry(1099);
            System.out.println("1");
            LoadBalancingInterface lb = new LoadBalancingImplementation();
			// Bind the localhost with the service 
			Naming.rebind("rmi://localhost/LoadBalancing", lb);
            System.out.println("2");
            // Naming.rebind("rmi://localhost/MasterServer", ); 
		} 
		catch (Exception e) { 
			// If any error occur 
			System.out.println("ERR: " + e); 
		} 
		
	} 

	public static void main(String[] args) 
	{ 
		// Create an object 
		new MasterServer(); 
	} 
}