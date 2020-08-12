package Servidor;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class Biblioteca implements IBiblioteca {
	
	ArrayList<Livro> livros;
	ArrayList<Usuario> usuarios;
	
	public Biblioteca(){
		livros = new ArrayList<Livro>();
		usuarios = new ArrayList<Usuario>();
	}

	@Override
	public synchronized boolean adicionarLivro(Livro l, Usuario u) throws RemoteException {
		if(u == null){
			System.out.println("Usu�rio n�o existe");
			return false;
		} else {
			if(u.isAdmin){
				if(getLivro(l) == null){
					livros.add(l);
					return true;
				} else {
					System.out.println("J� existe um livro com o mesmo c�digo.");
					return false;
				}
			} else {
				System.out.println("Usu�rio n�o possui privil�gios");
				return false;
			}
		}
	}

	@Override
	public synchronized boolean removerLivro(Livro l, Usuario u) throws RemoteException, InterruptedException {
		if(u == null){
			System.out.println("Usu�rio n�o existe");
			return false;
		} else {
			if(u.isAdmin){
				Livro livro = getLivro(l);
				if(livro == null){
					System.out.println("Livro n�o existe");
					return false;
				} else {
					while(livro.isEmprestado){
						System.out.println("Livro emprestado. Favor aguardar");
						wait();
					}
					livros.remove(livro);
					System.out.println("Livro removido");
					notify();
					return true;
				}
			} else {
				System.out.println("Usu�rio atual n�o possui privil�gios");
				return false;
			}
		}
	}

	@Override
	public synchronized boolean consultarLivros() throws RemoteException {
		if(livros.size() == 0){
			System.out.println("N�o h� livros cadastrados");
			return false;
		} else {
			for(int i = 0; i < livros.size(); i++){
				Livro temp = livros.get(i);
				System.out.println((i + 1) + ".\n");
				System.out.println("T�tulo: " + temp.titulo);
				System.out.println("\nAno: " + temp.anoPublicacao);
				System.out.println("\nC�digo: " + temp.codLivro);
				if(!temp.isEmprestado){
					System.out.println("\nEmprestado: N�o");
				} else {
					System.out.println("\nEmprestado: Sim");
				}	
			}
			return true;
		}
	}

	@Override
	public synchronized boolean emprestarLivro(Livro l, Usuario u) throws RemoteException, InterruptedException {
		Livro livro = getLivro(l);
		if(livro == null){
			System.out.println("Livro n�o existe");
			return false;
		} else {
			if(livro.codLivro == l.codLivro){
				while(livro.isEmprestado){
					System.out.println("Livro emprestado. Favor aguardar");
					wait();
				}
				livro.isEmprestado = true;
				livro.codUsuarioEmpr = u.codUsuario;
				notify();
				return true;
			}
			return false;
		}
	}

	@Override
	public synchronized boolean devolverLivro(Livro l) throws RemoteException {
		Livro livro = getLivro(l);
		if(livro == null){
			System.out.println("Livro n�o existe");
			return false;
		} else {
			if(livro.codLivro == l.codLivro){
				livro.isEmprestado = false;
				livro.codUsuarioEmpr = 0;
				System.out.println("Livro devolvido");
				notify();
				return true;
			}
			return false;
		}
	}

	@Override
	public Livro getLivro(Livro l) throws RemoteException {
		for(int i = 0; i < livros.size(); i++){
			Livro temp = livros.get(i);
			if(temp.codLivro == l.codLivro){
				return temp;
			}
		}
		return null;
	}

	@Override
	public Usuario getUsuario(Usuario u) throws RemoteException {
		for(int i = 0; i < usuarios.size(); i++){
			Usuario temp = usuarios.get(i);
			if(temp.codUsuario == u.codUsuario){
				return temp;
			}
		}
		return null;
	}

	@Override
	public synchronized boolean adicionarUsuario(Usuario u) throws RemoteException {
		Usuario usuario = getUsuario(u);
		if(usuario != null){
			if(usuario.codUsuario == u.codUsuario){
				System.out.println("C�digo de usu�rio j� � utilizado.");
				return false;
			}
		}
		usuarios.add(u);
		return true;
	}
	
}
