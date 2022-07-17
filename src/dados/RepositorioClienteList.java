package dados;

import java.util.ArrayList;
import java.util.List;

import negocio.entity.Cliente;

public class RepositorioClienteList {
	private List<Cliente> clientes = new ArrayList<Cliente>();
	static int id;
	
	public int gerarId() {
		id++;
		return id;
	}
	
	public boolean novo(Cliente c) {
		if (c != null) {
			if(this.verificarExistenciaCliente(c)) {
				return true;
			}else {
				return clientes.add(c);
			}
		}
		return false;
	}

	public Cliente buscar(int id) {
		for (int i = 0; i < clientes.size(); i++) {
			if(clientes.get(i) != null && clientes.get(i).getId() == id)
				return clientes.get(i);
		}
		return null;
	}

	public boolean deletar(Cliente c) {
		for (int i = 0; i < clientes.size(); i++) {
			if(clientes.get(i) != null && clientes.get(i).getCpf().equals(c.getCpf()))
				return clientes.remove(clientes.get(i));
		}
		return false;
	}

	public List<Cliente> listar() {
		List<Cliente> aux = new ArrayList<Cliente>();
		for (Cliente c : clientes) {
			aux.add(new Cliente(c));
		}
		return aux;
	}
	
	public boolean verificarExistenciaCliente(Cliente c) {
		if(c!=null) {
			for (int i = 0; i < clientes.size(); i++) {
				if (clientes.get(i).getId() == c.getId()) {
					clientes.set(i, c);
					return true;
				}
			}
		}
		return false;
	}
	
}
