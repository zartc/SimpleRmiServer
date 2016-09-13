package zc.study.rpc.simplermiserver.registry;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * A Helper class that offer a nice and easy interface to bind and lookup services into
 * the Rmi Registry.
 * <p>
 * It also nicely handle the case where the service class is a POJO that is not derived
 * from UnicastRemoteObject.
 *
 * @author Zart Colwing
 */
public class RmiRegistry {
	private static final Logger log = LoggerFactory.getLogger(RmiRegistry.class);

	private String baseUrl;

	/**
	 * Constructor.
	 *
	 * @throws RemoteException
	 */
	public RmiRegistry() throws RemoteException {
		this(1099);
	}

	/**
	 * Constructor.
	 *
	 * @param port
	 * @throws RemoteException
	 */
	public RmiRegistry(int port) throws RemoteException {
		this("localhost", port);
	}

	/**
	 * Constructor.
	 *
	 * @param host
	 * @param port
	 * @throws RemoteException
	 */
	public RmiRegistry(String host, int port) throws RemoteException {
		this.baseUrl = "//" + host + ":" + String.valueOf(port) + "/";

		if ("localhost".equalsIgnoreCase(host)) {
			try {
				// starts a RMI registry if none already exists at the specified port number.
				Registry registry = LocateRegistry.getRegistry(port);
				// This call will throw an exception if the registry does not already exist
				registry.list();
			}
			catch (RemoteException e) {
				// No registry at that port.
				LocateRegistry.createRegistry(port);
			}
		}
	}

	public void bindService(String name, Remote service) {
		String url = baseUrl + name;

		try {
			/*
			 * if the service class does not extends UnicastRemoteObject, we must create a
			 * proxy for it.
			 */
			if (!(service instanceof UnicastRemoteObject)) {
				service = UnicastRemoteObject.exportObject(service, 0);
			}

			Naming.rebind(url, service);
			log.info("Service registered on: '{}' as '{}'", url, service);
		}
		catch (MalformedURLException e) {
			throw new RmiRegistryException("unable to register service", e)
					.addContextValue("baseUrl", baseUrl)
					.addContextValue("name", name)
					.addContextValue("service", service);
		}
		catch (RemoteException e) {
			throw new RmiRegistryException("unable to register service", e.getCause())
					.addContextValue("baseUrl", baseUrl)
					.addContextValue("name", name)
					.addContextValue("service", service);
		}
	}

	public <T extends java.rmi.Remote> T lookupService(String name) throws RmiRegistryException {
		try {
			@SuppressWarnings("unchecked")
			T service = (T)Naming.lookup(baseUrl + name);
			log.info("Service '{}' found as '{}'", name, service);

			return service;
		}
		catch (MalformedURLException | NotBoundException e) {
			throw new RmiRegistryException("service not found", e)
					.addContextValue("baseUrl", baseUrl)
					.addContextValue("name", name);
		}
		catch (RemoteException e) {
			throw new RmiRegistryException("service not found", e.getCause())
					.addContextValue("baseUrl", baseUrl)
					.addContextValue("name", name);
		}
	}
}
