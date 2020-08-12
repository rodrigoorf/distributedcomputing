package Servidor;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CalculadoraServ {

	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		Calculadora c = new Calculadora();
		IClass stub = (IClass)UnicastRemoteObject.exportObject(c, 0);
		Registry r = LocateRegistry.getRegistry();
		r.bind("Calculadora", stub);
		System.out.println("Servidor online!");
	}

}
