package Cliente;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import Servidor.IBiblioteca;
import Servidor.Livro;
import Servidor.Usuario;

public class BibliotecaCli {
	// Administrador
	public static void main(String[] args) throws RemoteException, NotBoundException, InterruptedException {
		Registry r = LocateRegistry.getRegistry(8090);
		IBiblioteca stub = (IBiblioteca)r.lookup("Biblioteca");
		Usuario admin = new Usuario("admin", 1, "admin", true);
		Usuario teste = new Usuario("teste", 2, "teste", false);
		Livro principe = new Livro(1, "Pequeno Príncipe", 2018);
		System.out.println("Adicionar usuário (admin): " + stub.adicionarUsuario(admin));
		System.out.println("Adicionar livro: " + stub.adicionarLivro(principe, admin));
		System.out.println("Consultar livros: " + stub.consultarLivros());
		System.out.println("Adicionar usuário (teste): " + stub.adicionarUsuario(teste));
		System.out.println("Emprestar livro: " + stub.emprestarLivro(principe, teste));
		System.out.println("Consultar livro: " + stub.consultarLivros());
		System.out.println("Remover livro: " + stub.removerLivro(principe, admin));
		System.out.println("Consultar livro: " + stub.consultarLivros());
		
	}

}
