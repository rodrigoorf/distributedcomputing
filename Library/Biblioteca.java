import java.util.ArrayList;

public class Biblioteca {
	ArrayList<Livro> livros;
	ArrayList<Usuario> usuarios;
	
	public Biblioteca(){
		livros = new ArrayList<Livro>();
		usuarios = new ArrayList<Usuario>();
	}
	
	public synchronized boolean adicionarLivro(Livro l, int codUsr){
		Usuario temp = getUsuario(codUsr);
		if(temp == null){
			System.out.println("Usu�rio n�o existe");
			return false;
		} else {
			if (temp.isAdmin){
				if(getLivro(l.codLivro) == null){
					livros.add(l);
					return true;
				} else {
					System.out.println("J� existe um livro com o mesmo c�digo.");
					return false;
				}
			} else {
				System.out.println("Usu�rio atual n�o possui privil�gios para essa a��o");
				return false;
			}
		}
	}
	
	public synchronized boolean removerLivro(int codLivro, int codUsr) throws InterruptedException{
		Usuario temp = getUsuario(codUsr);
		if(temp == null){
			System.out.println("Usu�rio n�o existe");
			return false;
		} else {
			if (temp.isAdmin){
				Livro livro = getLivro(codLivro);
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
				System.out.println("Usu�rio atual n�o possui privil�gios para essa a��o");
				return false;
			}
		}
	}
	
	public synchronized boolean consultarLivros(){
		if(livros.size() == 0){
			String msg = "N�o h� livros cadastrados.";
			System.out.println(msg);
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
	public synchronized boolean emprestarLivro(int codLivro, int codUsuario) throws InterruptedException{
		Livro temp = getLivro(codLivro);
		if(temp == null){
			System.out.println("Livro n�o existe");
			return false;
		} else {
			if(temp.codLivro == codLivro){
				while(temp.isEmprestado){
					System.out.println("Livro emprestado. Favor aguardar");
					wait();
				}
				temp.isEmprestado = true;
				temp.codUsuarioEmpr = codUsuario;
				notify();
				return true;
			}
			return false;
		}
	}
	
	public synchronized boolean devolverLivro(int codLivro) throws InterruptedException{
		Livro temp = getLivro(codLivro);
		if (temp == null){
			System.out.println("Livro n�o existe");
			return false;
		} else {
			if(temp.codLivro == codLivro){
				temp.isEmprestado = false;
				temp.codUsuarioEmpr = 0;
				System.out.println("Livro devolvido");
				notify();
				return true;
			}
			return false;
		}
	}
	
	public Livro getLivro(int codLivro){
		for(int i = 0; i < livros.size(); i++){
			Livro temp = livros.get(i);
			if(temp.codLivro == codLivro){
				return temp;
			}
		}
		return null;
	}
	
	public Usuario getUsuario(int codUsuario){
		for(int i = 0; i < usuarios.size(); i++){
			Usuario temp = usuarios.get(i);
			if (temp.codUsuario == codUsuario){
				return temp;
			}
		}
		return null;
	}
	
	public synchronized boolean adicionarUsuario(Usuario u){
		Usuario temp = getUsuario(u.codUsuario);
		if(temp != null){
			if(temp.codUsuario == u.codUsuario){
				System.out.println("C�digo de usu�rio j� � utilizado.");
				return false;
			}
		}
		usuarios.add(u);
		return true;
	}
	//TODO comunica��o usando map
	//TODO AdmCLiente.java
	//TODO UsrCliente.java
}
