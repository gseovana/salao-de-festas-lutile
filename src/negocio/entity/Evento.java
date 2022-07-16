package negocio.entity;


public class Evento {
	private int codigo;
	private String nome;
	private String data;
	private String horario;
	private TipoEvento tipoEvento;
	private int numConvidados;
	private double duracao;
	private Cliente cliente;
	private int formaPagto;
	private int qtdParcelas;

	
	private Evento(String nome, String data, String horario, TipoEvento tipoEvento, int numConvidados, double duracao, Cliente cliente, int formaPagto, int qtdParcelas) {
		setNome(nome);
		setData(data);
		setHorario(horario);
		setTipoEvento(tipoEvento);
		setNumConvidados(numConvidados);
		setDuracao(duracao);
		setCliente(cliente);
		setFormaPagto(formaPagto);
		setQtdParcelas(qtdParcelas);
	}
	
	public Evento(Evento evento) {
		this.codigo = evento.codigo;
		this.nome = evento.nome;
		this.data = evento.data;
		this.horario = evento.horario;
		this.tipoEvento = evento.tipoEvento;
		this.numConvidados = evento.numConvidados;
		this.duracao = evento.duracao;
		this.cliente = evento.cliente;
		this.formaPagto = evento.formaPagto;
		this.qtdParcelas = evento.qtdParcelas;
		
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public int getNumConvidados() {
		return numConvidados;
	}

	public void setNumConvidados(int numConvidados) {
		this.numConvidados = numConvidados;
	}

	public double getDuracao() {
		return duracao;
	}

	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getFormaPagto() {
		return formaPagto;
	}

	public void setFormaPagto(int formaPagto) {
		this.formaPagto = formaPagto;
	}

	public int getQtdParcelas() {
		return qtdParcelas;
	}

	public void setQtdParcelas(int qtdParcelas) {
		this.qtdParcelas = qtdParcelas;
	}
	
	public static Evento getInstance(String nome, String data, String horario, TipoEvento tipoEvento, int numConvidados, double duracao, Cliente cliente, int formaPagto, int qtdParcelas) {
		if (nome != null && data != null && horario != null && tipoEvento != null && numConvidados != 0 && duracao != 0.0 && cliente != null && formaPagto > 0) {
			return new Evento(nome, data, horario, tipoEvento, numConvidados, duracao, cliente, formaPagto, qtdParcelas);
		} else {
			return null;
		}
	}

}
