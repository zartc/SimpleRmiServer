package zc.study.rpc.simplermiserver.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * The implementation of the Greeting service.
 * <p>
 * Albeit the GreetingService extends Remote, the implementation class is not absolutely
 * "required" to declare RemoteException in their method signature. This subtelty allow
 * POJOs to serve as implementation of Remote interface.
 *
 * @author Pascal
 */
public class GreetingServiceImpl implements GreetingService {
	private static final Logger log = LoggerFactory.getLogger(GreetingServiceImpl.class);

	private int callerCount = 1;

	@Override
	public String computeGreetingMessage(String personName) {
		log.info("computeGreetingMessage called with personName = {}", personName);

		try {
			// simulate "significant amount of time to compute the greetin message"
			Thread.sleep(1 * 1000);

			return "hello " + personName + ", you are caller #" + callerCount++;
		}
		catch (InterruptedException e) {
			log.debug("interrupted");
			return e.getLocalizedMessage();
		}
	}
}
