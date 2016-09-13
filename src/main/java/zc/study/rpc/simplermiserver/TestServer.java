package zc.study.rpc.simplermiserver;

import java.rmi.RemoteException;

import zc.study.rpc.simplermiserver.registry.RmiRegistry;
import zc.study.rpc.simplermiserver.service.GreetingServiceImpl;


/**
 * The main class that instanciate the service classes, bind them into the RMI registry
 * and start the Server.
 *
 * @author Zart Colwing
 */
public class TestServer {
	public static void main(String args[]) throws RemoteException {
		RmiRegistry rmiRegistry = new RmiRegistry(ServiceNames.PORT);
		rmiRegistry.bindService(ServiceNames.GREETING_SERVICE_NAME, new GreetingServiceImpl());
	}
}
