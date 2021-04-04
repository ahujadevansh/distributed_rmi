import java.rmi.*;  
import java.io.IOException;

public interface ServerInterface extends Remote
{
    /** @return the number of files now uploaded to this slave. */
    int add(int a, int b) throws RemoteException;
    // int getFileCount() throws RemoteException;
}