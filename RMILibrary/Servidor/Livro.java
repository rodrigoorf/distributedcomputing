package Servidor;

import java.io.Serializable;

public class Livro implements Serializable {
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
