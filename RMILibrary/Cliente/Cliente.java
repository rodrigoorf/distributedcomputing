package Cliente;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Servidor.IBiblioteca;
import Servidor.Livro;
import Servidor.Usuario;

public class Cliente {

	public static void main(String[] args) throws RemoteException, NotBoundException {
		Registry r = LocateRegistry.getRegistry(8090);
		IBiblioteca stub = (IBiblioteca)r.lookup("Biblioteca");
		Usuario teste = new Usuario("teste", 2, "teste", false);
		Livro principe = new Livro(1, "Pequeno Príncipe", 2018);
		System.out.println("Devolver livro: " + stub.devolverLivro(principe));
	}

}
