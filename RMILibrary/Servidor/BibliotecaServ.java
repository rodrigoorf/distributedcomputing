package Servidor;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class BibliotecaServ {

	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		Biblioteca b = new Biblioteca();
		IBiblioteca stub = (IBiblioteca)UnicastRemoteObject.exportObject(b, 0);
		Registry r = LocateRegistry.createRegistry(8090);
		r.bind("Biblioteca", stub);
		System.out.println("Servidor online!");

	}

}
