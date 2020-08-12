
public class Livro {
	int codLivro;
	String titulo;
	int anoPublicacao;
	boolean isEmprestado;
	int codUsuarioEmpr;
	
	public Livro(int codLivro, String titulo, int anoPublicacao){
		this.codLivro = codLivro;
		this.titulo = titulo;
		this.anoPublicacao = anoPublicacao;
		this.isEmprestado = false;
	}
}
