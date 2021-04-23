package model;
 

public class Perfil     {
	private int IdPerfil;
	private String Nome;

	public Perfil() {
	}

	public Perfil(String nome) {
		setNome(nome);
	}
	public Perfil(int idPerfil, String nome) {
		setIdPerfil(idPerfil);
		setNome(nome);
	}

	public int getIdPerfil() {
		return IdPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		IdPerfil = idPerfil;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		this.Nome = nome;
	}

 

}
