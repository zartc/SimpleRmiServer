package zc.study.rpc.simplermiserver;

import java.rmi.RemoteException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import zc.study.rpc.simplermiserver.registry.RmiRegistry;
import zc.study.rpc.simplermiserver.service.GreetingService;


/**
 * The main client class. It lookup the greeting service in the RmiRegistry then call the
 * service.
 * 
 * @author Zart Colwing
 */
public class TestClient {
	private static final Logger log = LoggerFactory.getLogger(TestClient.class);

	public static void main(String args[]) throws RemoteException, InterruptedException {
		RmiRegistry rmiRegistry = new RmiRegistry(ServiceNames.PORT);
		GreetingService greetingService = rmiRegistry.lookupService(ServiceNames.GREETING_SERVICE_NAME);

		log.debug("GreetingService found : {}", greetingService);

		// make a synchronous call
		String message = greetingService.computeGreetingMessage("Pascal JACOB");
		log.info("Server says: {}", message);
	}
}
