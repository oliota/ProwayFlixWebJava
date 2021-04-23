package model;


import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import business.SessionUtils;
import dao.LoginDao; 

@ManagedBean
@SessionScoped
public class Login implements Serializable {

	private static final long serialVersionUID = 1094801825228386363L;
	
	private String logon;
	private String msg;
	private String senha;

 

	public String getLogon() {
		return logon;
	}

	public void setLogon(String logon) {
		this.logon = logon;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
 
	//validate login
	public String validateUsernamePassword() {
		LoginDao loginDao=new LoginDao();
		Usuario usuario = loginDao.entrar(logon, senha);
		if (usuario!=null) {
			HttpSession session = SessionUtils.getSession();
			//session.setAttribute("username", logon);
			session.setAttribute("usuario", usuario);
			return "admin";
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Logon ou senha incorretos",
							"Tente novamente"));
			return "login";
		}
	}

	//logout event, invalidate session
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login";
	}
}