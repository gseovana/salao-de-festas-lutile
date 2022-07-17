package ui;

import java.util.List;
import java.util.Scanner;

import negocio.ISistema;
import negocio.Sistema;
import negocio.entity.Cliente;

public class UICliente {
	private Scanner scn;
	private ISistema iSistema;

	public UICliente() {
		iSistema = Sistema.getInstance();
	}

	public boolean novo(Cliente cliente) {
		if (cliente != null) {
			if (iSistema.novoCliente(cliente)) {
				return true;
			}
		}
		return false;
	}

	public boolean deletar(int id) {

		Cliente c = iSistema.buscarCliente(id);

		if (!iSistema.confirmarCliente(id)) {
			if (c != null) {
				if (iSistema.deletarCliente(c))
					return true;
			}
		}
		return false;
	}

	public List<Cliente> listar() {
		return iSistema.listarClientes();
	}

	public Cliente buscarCliente(int id) {
		return iSistema.buscarCliente(id);
	}

}