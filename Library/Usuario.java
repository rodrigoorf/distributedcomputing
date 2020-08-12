
public class Usuario {
	String nome;
	int codUsuario;
	String senha;
	boolean isAdmin;
	
	public Usuario(String nome, int codUsuario, String senha, boolean isAdmin){
		this.nome = nome;
		this.codUsuario = codUsuario;
		this.senha = senha;
		this.isAdmin = isAdmin;
	}
}
