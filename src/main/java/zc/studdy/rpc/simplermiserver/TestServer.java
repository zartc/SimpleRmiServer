package zc.studdy.rpc.simplermiserver;

import java.rmi.RemoteException;

import zc.studdy.rpc.simplermiserver.registry.RmiRegistry;
import zc.studdy.rpc.simplermiserver.service.GreetingServiceImpl;


/**
 * The main class that instanciate the service classes, bind them into the RMI registry
 * and start the Server.
 *
 * @author Pascal
 * @See http://docs.spring.io/spring/docs/current/spring-framework-reference/html/scheduling.html
 * @see http://barakb.github.io/asyncrmi/
 */
public class TestServer {
	public static void main(String args[]) throws RemoteException {
		RmiRegistry rmiRegistry = new RmiRegistry(ServiceNames.PORT);
		rmiRegistry.bindService(ServiceNames.GREETING_SERVICE_NAME, new GreetingServiceImpl());
	}
}
