package model;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
 

@ManagedBean
@SessionScoped
public class Usuario {
	private int IdUsuario;
	private Perfil Perfil;
	private String Nome, Email, Logon, Senha;

	public Usuario() {

	}

	public Usuario(String nome, String email, String logon, String senha) {
		setNome(nome);
		setEmail(email);
		setLogon(logon);
		setSenha(senha);
	}

	public Usuario(int idUsuario, Perfil perfil, String nome, String email, String logon, String senha) {
		setIdUsuario(idUsuario);
		setPerfil(perfil);
		setNome(nome);
		setEmail(email);
		setLogon(logon);
		setSenha(senha);
	}

	public int getIdUsuario() {
		return IdUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		IdUsuario = idUsuario;
	}

	public Perfil getPerfil() {
		return Perfil;
	}

	public void setPerfil(Perfil perfil) {
		Perfil = perfil;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getLogon() {
		return Logon;
	}

	public void setLogon(String logon) {
		Logon = logon;
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String senha) {
		Senha = senha;
	}
    
    public String logar(){
        if(getNome().equals("Julio") && getSenha().equals("Julio")){
            return "pag-sucesso";
        }
        FacesContext ctx = FacesContext.getCurrentInstance();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário inválido", "Usuário inválido");
        ctx.addMessage(null, msg);
        return "";              
    }
    
     
}