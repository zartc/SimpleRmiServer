package zc.study.rpc.simplermiserver;

/**
 * This interface is shared between the server and the client so that they both share the
 * same information/configuration.
 *
 * @author Zart Colwing
 */
public interface ServiceNames {
	public static final int PORT = 1299;
	public static final String GREETING_SERVICE_NAME = "zc.study.rpc.simplermiserver.greetingService";
}
