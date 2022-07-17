package negocio;

import java.util.List;

import dados.RepositorioClienteList;
import negocio.entity.Cliente;

public class ControladorCliente {
	private RepositorioClienteList repoCliente;

	public ControladorCliente() {
		repoCliente = new RepositorioClienteList();
	}

	public boolean novo(Cliente c) {
		return repoCliente.novo(c);
	}

	public Cliente buscar(int id) {
		if (id > 0) {
			return repoCliente.buscar(id);
		}
		return null;
	}

	public boolean deletar(Cliente c) {
		if (c != null) {
			return repoCliente.deletar(c);
		}
		return false;
	}

	public List<Cliente> listar() {
		return repoCliente.listar();
	}

	public int gerarId() {
		return repoCliente.gerarId();
	}
}
