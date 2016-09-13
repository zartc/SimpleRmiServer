package zc.study.rpc.simplermiserver.service;

import java.rmi.Remote;
import java.rmi.RemoteException;


/**
 * The interface of the Greeting service.
 * <p>
 * The interface extends Remote and every method in the interface must declare
 * RemoteException in their throws clause.
 * <p>
 * As you will see in the GreetingServiceImpl class, implementation classes are not
 * obsolutely required to declare the RemoteException in their signature.
 *
 * @author Zart Colwing
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
