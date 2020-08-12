package Servidor;
import java.rmi.*;

public interface IBiblioteca extends Remote {
	public boolean adicionarLivro(Livro l, Usuario u) throws RemoteException;
	public boolean removerLivro(Livro l, Usuario u) throws RemoteException, InterruptedException;
	public boolean consultarLivros() throws RemoteException;
	public boolean emprestarLivro(Livro l, Usuario u) throws RemoteException, InterruptedException;
	public boolean devolverLivro(Livro l) throws RemoteException;
	public Livro getLivro(Livro l) throws RemoteException;
	public Usuario getUsuario(Usuario u) throws RemoteException;
	public boolean adicionarUsuario(Usuario u) throws RemoteException;
	
}
