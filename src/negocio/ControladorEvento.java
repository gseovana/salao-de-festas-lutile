package negocio;

import java.util.List;

import dados.RepositorioEventoList;
import negocio.entity.Cliente;
import negocio.entity.Evento;
import negocio.entity.TipoEvento;

public class ControladorEvento {
	private RepositorioEventoList repoEvento;

	public ControladorEvento() {
		repoEvento = new RepositorioEventoList();
	}

	public boolean novo(Evento e) {
		if (validar(e)) {
			return repoEvento.novo(e);
		}
		return false;
	}

	private boolean validar(Evento e) {
		if (e != null) {
			List<Evento> eventos = repoEvento.listar();
			for (int i = 0; i < eventos.size(); i++) {
				if (eventos.get(i).getData().equals(e.getData())
						&& eventos.get(i).getHorario().equals(e.getHorario())) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public Evento buscar(int codigo) {
		if (codigo > 0)
			return repoEvento.buscar(codigo);
		else
			return null;
	}

	public boolean deletar(Evento e) {
		if (e != null) {
			return repoEvento.deletar(e);
		}
		return false;
	}

	public List<Evento> listar() {
		return repoEvento.listar();
	}

	public boolean confirmarTipoEvento(int codigo) {
		if (codigo > 0) {
			return repoEvento.confirmarTipoEvento(codigo);
		}
		return false;
	}

	public boolean confirmarCliente(int id) {
		if (id > 0) {
			return repoEvento.confirmarCliente(id);
		}
		return false;
	}

	public boolean procurarTipoEvento(int codigo) {
		if (codigo > 0) {
			return repoEvento.procurarTipoEvento(codigo);
		}
		return false;
	}

	public boolean procurarCliente(String cpf) {
		if (cpf != null) {
			return repoEvento.procurarCliente(cpf);
		}
		return false;
	}

	public boolean editar(Evento e, String novo, int opcao) {
		if (e != null && novo != null && opcao > 0) {
			return repoEvento.editar(e, novo, opcao);
		}
		return false;
	}

	public boolean editarEventoTipoEvento(Evento e, TipoEvento te, int opcao) {
		if (e != null && te != null && opcao == 6) {
			return repoEvento.editarEventoTipoEvento(e, te, opcao);
		}
		return false;
	}

	public boolean editarEventoCliente(Evento e, Cliente c, int opcao) {
		if (e != null && c != null && opcao == 7) {
			return repoEvento.editarEventoCliente(e, c, opcao);
		}
		return false;
	}

	public boolean editarConvidados(Evento e, int novo, int opcao) {
		if (novo > 0 && opcao == 4) {
			return repoEvento.editarConvidados(e, novo, opcao);
		}
		return false;
	}

	public boolean editarDuracao(Evento e, double novo, int opcao) {
		if(novo > 0 && opcao == 5) {
			repoEvento.editarDuracao(e, novo, opcao);
		}
		return false;
	}
}
