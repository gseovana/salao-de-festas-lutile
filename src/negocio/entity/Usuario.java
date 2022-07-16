package negocio.entity;

public class Usuario {
	private String nome;
	private String cpf;
	private String login;
	private String senha;

	private Usuario(String nome, String cpf, String login, String senha) {
		setNome(nome);
		setCpf(cpf);
		setLogin(login);
		setSenha(senha);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		if (login != null) {
			this.login = login;
		}
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		if (senha != null) {
			this.senha = senha;
		}
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public static Usuario getInstance(String nome,String cpf, String login, String senha) {
		if (nome != null && cpf != null && login != null && senha != null) {
			return new Usuario(nome, cpf, login, senha);
		} else {
			return null;
		}
	}
}
