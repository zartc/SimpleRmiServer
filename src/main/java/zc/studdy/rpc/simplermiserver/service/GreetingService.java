package zc.studdy.rpc.simplermiserver.service;

import java.rmi.Remote;
import java.rmi.RemoteException;


/**
 * The interface of the Greeting service.
 * <p>
 * The interface extends Remote and every method must declare RemoteException in their
 * throws clause.
 */
public interface GreetingService extends Remote {
	/**
	 * A service method that can be called by the client.
	 *
	 * @param personName the name of the person to greet
	 * @return the greeting message.
	 * @throws InterruptedException as the computation can take a significant amount of
	 *         time it can be interrupted.
	 * @throws RemoteException
	 */
	public String computeGreetingMessage(String personName) throws RemoteException;
}
