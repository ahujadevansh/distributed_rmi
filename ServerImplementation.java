import java.rmi.*;
import java.rmi.server.*;
class ServerImplementation extends UnicastRemoteObject implements ServerInterface {

    ServerImplementation()throws RemoteException{  
		super();
	}  
    public int add(int a, int b) throws RemoteException {
        return a+b;
    }

}