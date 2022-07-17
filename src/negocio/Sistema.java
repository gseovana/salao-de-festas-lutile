package negocio;

import java.util.List;

import negocio.entity.Cliente;
import negocio.entity.Evento;
import negocio.entity.TipoEvento;
import negocio.entity.Usuario;

public class Sistema implements ISistema {
	private ControladorUsuario cUsuario;
	private ControladorCliente cCliente;
	private ControladorTipoEvento cTipoEvento;
	private ControladorEvento cEvento;

	private static Sistema instance;
	
	public Sistema() {
		cUsuario = new ControladorUsuario();
		cCliente = new ControladorCliente();
		cTipoEvento = new ControladorTipoEvento();
		cEvento = new ControladorEvento();
	}

	public static Sistema getInstance() {
		if (instance == null) {
			instance = new Sistema();
		}
		return instance;
	}

	@Override
	public boolean novoUsuario(Usuario u) {
		return cUsuario.novo(u);
	}

	@Override
	public boolean logar(String login, String senha) {
		return cUsuario.logar(login, senha);
	}

	@Override
	public boolean novoEvento(Evento e) {
		return cEvento.novo(e);
	}
	
	public Evento buscarEvento(int codigo) {
		return cEvento.buscar(codigo);
	}

	@Override
	public boolean deletarEvento(Evento e) {
		return cEvento.deletar(e);
	}

	@Override
	public List<Evento> listarEventos() {
		return cEvento.listar();
	}

	public boolean editarEvento(Evento e, String novo, int opcao) {
		return cEvento.editar(e, novo, opcao);		
	}
	public boolean editarEventoTipoEvento(Evento e, TipoEvento te, int opcao) {
		return cEvento.editarEventoTipoEvento(e, te, opcao);
	}
	
	public boolean editarEventoCliente(Evento e, Cliente c, int opcao) {
		return cEvento.editarEventoCliente(e, c, opcao);
	}
	
	public boolean editarDuracao(Evento e, double novo, int opcao) {
		return cEvento.editarDuracao(e, novo, opcao);
	}
	
	public boolean editarNumConvidados(Evento e, int novo, int opcao) {
		return cEvento.editarConvidados(e, novo, opcao);
	}
	
	//----------------CLIENTE--------------------
	@Override
	public boolean novoCliente(Cliente c) {
		return cCliente.novo(c);
	}

	public Cliente buscarCliente(int id) {
		return cCliente.buscar(id);
	}
	
	@Override
	public boolean deletarCliente(Cliente c) {
		return cCliente.deletar(c);
	}

	@Override
	public List<Cliente> listarClientes() {
		return cCliente.listar();
	}

	public boolean procurarCliente(String cpf) {
		return cEvento.procurarCliente(cpf);
	}
	
	@Override
	public boolean confirmarCliente(int id) {
		return cEvento.confirmarCliente(id);
	}

	
	//--------------TIPOS DE EVENTO--------------
	@Override
	public boolean novoTipoEvento(TipoEvento te) {
		return cTipoEvento.novo(te);
	}

	@Override
	public boolean deletarTipoEvento(int codigo) {
		return cTipoEvento.deletar(codigo);
	}

	@Override
	public List<TipoEvento> listarTiposDeEvento() {
		return cTipoEvento.listar();
	}

	public TipoEvento buscarTipoEvento(int codigo) {
		return cTipoEvento.buscar(codigo);
	}
	
	@Override
	public boolean procurarTipoEvento(int codigo) {
		return cEvento.procurarTipoEvento(codigo);
	}

	@Override
	public boolean confirmarTipoEvento(int codigo) {
		return cEvento.confirmarTipoEvento(codigo);
	}

	@Override
	public void init() {
		Usuario usuario = Usuario.getInstance("Lutile", "123.456.789-10", "lutile", "123");
		novoUsuario(usuario);

		TipoEvento tipoEvento = TipoEvento.getInstance("Acampamento");
		novoTipoEvento(tipoEvento);
		Cliente cliente = Cliente.getInstance(cCliente.gerarId(), "Geovana", "123.456.789-20", "24/06/2003", "(31)922222222", "geovana@gmail");
		novoCliente(cliente);
		Evento evento = Evento.getInstance(cEvento.gerarId(), "GRDS", "22/03/2021", "21:30", tipoEvento, 07, 12.0, cliente, 1, 0);
		novoEvento(evento);	
		
		tipoEvento = TipoEvento.getInstance("Cha de bebe");
		novoTipoEvento(tipoEvento);
		cliente = Cliente.getInstance(cCliente.gerarId(), "Raul", "123.456.789-30", "04/10/2004", "(31)933333333", "raul@gmail");
		novoCliente(cliente);
		evento = Evento.getInstance(cEvento.gerarId(), "BBoy", "19/08/2022", "15:00", tipoEvento, 50, 4.0, cliente, 2, 3);
		novoEvento(evento);	
		
		tipoEvento = TipoEvento.getInstance("Acampamento");
		novoTipoEvento(tipoEvento);		
		cliente = Cliente.getInstance(cCliente.gerarId(), "Nicolas", "123.456.789-50", "30/12/1995", "(31)955555555", "nicolas@gmail");
		novoCliente(cliente);
		evento = Evento.getInstance(cEvento.gerarId(),"Acampus", "17/09/2018", "23:50", tipoEvento, 12, 24.0, cliente, 1, 0);
		novoEvento(evento);	


		tipoEvento = TipoEvento.getInstance("Festa de 15 anos");
		novoTipoEvento(tipoEvento);
		
	}

	public int gerarId() {
		return cCliente.gerarId();
	}
	
	public int gerarIdEvento() {
		return cEvento.gerarId();
	}
	
}