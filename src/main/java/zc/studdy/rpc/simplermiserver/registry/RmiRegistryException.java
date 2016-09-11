package zc.studdy.rpc.simplermiserver.registry;

import org.apache.commons.lang3.exception.ContextedRuntimeException;
import org.apache.commons.lang3.exception.ExceptionContext;


/**
 * Exception thrown by the RmiRegistry class. As this exception class is derived from
 * {@link ContextedRuntimeException} it convoy a context that you can examine to decide
 * how to handle the exception or what to display to the user.
 * <p>
 * The keys in the context depends on the RmiRegistry implementation; The standard
 * implementation put the following key in the context:
 * <ul>
 * <li>the "<code style="color:red">baseUrl</code>" key representing the url to the Rmi
 * serveur
 * <li>the "<code style="color:red">name</code>" key representing the lookup name of the
 * service that the RmiRegistry failed to register or lookup.
 * </ul>
 *
 * @author Zart Colwing
 */
public class RmiRegistryException extends ContextedRuntimeException {
	private static final long serialVersionUID = 1L;

	public RmiRegistryException() {
		super();
	}

	public RmiRegistryException(String message, Throwable cause, ExceptionContext context) {
		super(message, cause, context);
	}

	public RmiRegistryException(String message, Throwable cause) {
		super(message, cause);
	}

	public RmiRegistryException(String message) {
		super(message);
	}

	public RmiRegistryException(Throwable cause) {
		super(cause);
	}
}
