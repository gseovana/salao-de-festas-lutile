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

	// fazer um validar q percorre o list e verifica se existe um cpf igual, se
	// existir, verifica se o id n é o mesmo pq s for n tem prolema, é uma edicao

	/*
	 * private boolean validar(Cliente cliente) { Cliente c =
	 * repoCliente.buscar(cliente.getId()); if (c != null && c.getId() ==
	 * cliente.getId()) return false; else return true; }
	 */

	public boolean editar(Cliente c, String novo, int opcao) {
		if (c != null && novo != null && opcao == 6) {
			return repoCliente.editar(c, novo, opcao);
		}
		return false;
	}

	public int gerarId() {
		return repoCliente.gerarId();
	}
}
