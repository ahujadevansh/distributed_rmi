import java.rmi.*; 
import java.rmi.server.*;
import java.util.HashMap;

class LoadBalancingImplementation extends UnicastRemoteObject implements LoadBalancingInterface {

    // HashMap<String, ServerInterface> servers;
    String server;
    LoadBalancingImplementation()throws RemoteException{  
		super();

	}  
    public void register(ServerInterface server, String serverName) throws RemoteException {
        System.out.println("3");
        try { 
			// Bind the localhost with the service
            this.server = serverName;
            Naming.rebind("rmi://localhost/" + serverName, server); 
            System.out.println("Addition: " + server.add(5,4));
		} 
		catch (Exception e) { 
			// If any error occur 
			System.out.println("ERR: " + e); 
		} 
    }
    public void unregister(ServerInterface slave, String serverName) throws RemoteException {
        return;
    }

    public String getActiveServer() throws RemoteException {
        return this.server;
    }


}