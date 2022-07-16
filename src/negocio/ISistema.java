package negocio;

import java.util.List;

import negocio.entity.Cliente;
import negocio.entity.Evento;
import negocio.entity.TipoEvento;
import negocio.entity.Usuario;

public interface ISistema {
	int gerarId(); 
	public boolean novoUsuario(Usuario u);
	public boolean logar(String login, String senha);
	public boolean novoEvento(Evento e);
	public boolean deletarEvento(Evento e);
	public List<Evento> listarEventos();
	public boolean novoCliente(Cliente c);
	public boolean deletarCliente(Cliente c);
	public List<Cliente> listarClientes();
	public boolean confirmarCliente(int id);
	public boolean novoTipoEvento(TipoEvento te);
	public boolean deletarTipoEvento(int codigo);
	public List<TipoEvento> listarTiposDeEvento();
	public boolean procurarTipoEvento(int codigo);
	public boolean confirmarTipoEvento(int codigo);
	public void init();
	public boolean editarCliente(Cliente c, String novo, int opcao);
	public Cliente buscarCliente(int id);
	
}
