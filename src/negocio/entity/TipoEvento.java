package negocio.entity;

public class TipoEvento {

	private int codigo;
	private String nome;
	
	private TipoEvento(String nome) {		
		setNome(nome); 
	} 
	
	public TipoEvento(TipoEvento tipoEvento) {
		this.codigo = tipoEvento.codigo;
		this.nome = tipoEvento.nome;
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
	
	public static TipoEvento getInstance(String nome) {
		if (nome != null ) 
			return new TipoEvento(nome);
		 else 
			return null;
	}
}
