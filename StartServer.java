import java.rmi.Naming; 
import java.io.*;
public class StartServer { 

    String name;
	// Implement the constructor of the class 
	public StartServer() throws IOException
	{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter Server Name: ");
        this.name = br.readLine();
		try { 
			// Create a object reference for the interface 
			ServerInterface s = new ServerImplementation(); 
            LoadBalancingInterface lb = (LoadBalancingInterface) Naming.lookup("rmi://10.0.2.9/LoadBalancing");
            System.out.println("4");
			lb.register(s, this.name); 

		} 
		catch (Exception e) { 
			// If any error occur 
			System.out.println("ERR: " + e); 
		} 
	} 

	public static void main(String[] args) throws IOException
	{ 
		// Create an object 
		new StartServer(); 
	} 
} 


// java -Djava.rmi.server.hostname=3.22.222.201 AdderServer