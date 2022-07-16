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

	public boolean editar(Cliente c, String novo, int opcao) {
		for (int i = 0; i < clientes.size(); i++) {
			if(clientes.get(i) != null && clientes.get(i).getCpf().equals(c.getCpf()) ) {
				switch (opcao) {
				case 1:
					clientes.get(i).setNome(novo);
					return true;
				case 2:
					clientes.get(i).setDataNasc(novo);
					return true;
				case 3:
					for (int j = 0; j < clientes.size(); j++) {
						if(clientes.get(j).getCpf().equals(novo)) {
							return false;
						}
					}
					clientes.get(i).setCpf(novo);
					return true;
				case 4:
					clientes.get(i).setTelefone(novo);
					return true;
				case 5:
					clientes.get(i).setEmail(novo);
					return true;
				default:
					break;
				}
			}
		}
		return false;
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
