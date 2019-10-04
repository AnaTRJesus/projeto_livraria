package br.uninove.model;

public class Livro {

	private int codigoLivro;
	private String tituloLivro;
	private String anoEdicao;
	private Autor autor;

	public int getCodigoLivro() {
		return codigoLivro;
	}

	public void setCodigoLivro(int codigoLivro) {
		this.codigoLivro = codigoLivro;
	}

	public String getTituloLivro() {
		return tituloLivro;
	}

	public void setTituloLivro(String tituloLivro) {
		this.tituloLivro = tituloLivro;
	}

	public String getAnoEdicao() {
		return anoEdicao;
	}

	public void setAnoEdicao(String anoEdicao) {
		this.anoEdicao = anoEdicao;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

}
