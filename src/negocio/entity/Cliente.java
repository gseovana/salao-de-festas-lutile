package negocio.entity;

public class Cliente {
	private int id;
	private String nome;
	private String dataNasc;
	private String cpf;
	private String telefone;
	private String email;

	public Cliente(int id, String nome, String cpf, String dataNasc, String telefone, String email) {
		setId(id);
		setNome(nome);
		setDataNasc(dataNasc);
		setCpf(cpf);
		setTelefone(telefone);
		setEmail(email);
	}
	
	public Cliente(Cliente c) {
		this.id = c.id;
		this.nome = c.nome;
		this.dataNasc = c.dataNasc;
		this.cpf = c.cpf;
		this.telefone = c.telefone;
		this.email = c.email;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return this.nome + " - " + this.cpf;
	}

	public static Cliente getInstance(int id, String nome, String dataNasc, String cpf, String telefone, String email) {
		if (nome != null && dataNasc != null && cpf != null && telefone != null) {
			return new Cliente(id, nome, dataNasc, cpf, telefone, email);
		} else {
			return null;
		}
	}
}
