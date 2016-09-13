package zc.study.rpc.simplermiserver;

import java.rmi.RemoteException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import zc.study.rpc.simplermiserver.registry.RmiRegistry;
import zc.study.rpc.simplermiserver.service.GreetingService;



// http://www.baeldung.com/2012/02/06/properties-with-spring/?utm_source=email-newsletter&utm_medium=email&utm_campaign=auto_7_spring

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
