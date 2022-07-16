package dados;

import java.util.ArrayList;
import java.util.List;

import negocio.entity.Cliente;
import negocio.entity.Evento;
import negocio.entity.TipoEvento;


public class RepositorioEventoList {

	private List<Evento> eventos = new ArrayList<Evento>();
	private static int codigo = 1;

	public boolean novo(Evento e) {
		if (e != null) {
			e.setCodigo(codigo);
			incrementarCodigo();
			return eventos.add(e);
		}
		return false;
	}

	private void incrementarCodigo() {
		codigo++;
	}

	public Evento buscar(int codigo) {
		for (int i = 0; i < eventos.size(); i++) {
			if (eventos.get(i) != null && eventos.get(i).getCodigo() == codigo)
				return new Evento(eventos.get(i));
		}
		return null;
	}

	public boolean deletar(Evento e) {
		for (int i = 0; i < eventos.size(); i++) {
			if (eventos.get(i) != null && eventos.get(i).getCodigo() == e.getCodigo()) {
				return eventos.remove(eventos.get(i));
			}
		}
		return false;
	}

	public List<Evento> listar() {
		List<Evento> aux = new ArrayList<Evento>();
		for (Evento e : eventos) {
			aux.add(new Evento(e));
		}
		return aux;
	}

	public boolean confirmarTipoEvento(int codigo) {
		for (int i = 0; i < eventos.size(); i++) {
			if (eventos.get(i) != null && eventos.get(i).getTipoEvento().getCodigo() == codigo) {
				return true;
			}
		}
		return false;
	}

	public boolean confirmarCliente(int id) {
		for (int i = 0; i < eventos.size(); i++) {
			if (eventos.get(i) != null && eventos.get(i).getCliente().getId() == id) {
				return true;
			}
		}
		return false;
	}

	public boolean procurarTipoEvento(int codigo) {
		for (int i = 0; i < eventos.size(); i++) {
			if (eventos.get(i) != null && eventos.get(i).getTipoEvento().getCodigo() == codigo)
				return true;
		}
		return false;
	}

	public boolean procurarCliente(String cpf) {
		for (int i = 0; i < eventos.size(); i++) {
			if (eventos.get(i) != null && eventos.get(i).getCliente().getCpf().equals(cpf))
				return true;
		}
		return false;
	}

	public boolean editar(Evento e, String novo, int opcao) {
		for (int i = 0; i < eventos.size(); i++) {
			if (eventos.get(i) != null && eventos.get(i).getCodigo() == e.getCodigo()) {
				switch (opcao) {
				case 1:
					eventos.get(i).setNome(novo);
					return true;
				case 2:
					eventos.get(i).setData(novo);
					return true;
				case 3:
					eventos.get(i).setHorario(novo);
					return true;
				default:
					break;
				}
			}
		}
		return false;
	}

	public boolean editarEventoTipoEvento(Evento e, TipoEvento te, int opcao) {
		for (int i = 0; i < eventos.size(); i++) {
			if(eventos.get(i) != null && eventos.get(i).getCodigo() == e.getCodigo()) {
				eventos.get(i).setTipoEvento(te);
				return true;
			}
		}
		return false;
	}
	
	public boolean editarEventoCliente(Evento e, Cliente c, int opcao) {
		for (int i = 0; i < eventos.size(); i++) {
			if(eventos.get(i) != null && eventos.get(i).getCodigo() == e.getCodigo()) {
				eventos.get(i).setCliente(c);
				return true;
			}
		}
		return false;
	}

	public boolean editarConvidados(Evento e, int novo, int opcao) {
		for (int i = 0; i < eventos.size(); i++) {
			if(eventos.get(i) != null && eventos.get(i).getCodigo() == e.getCodigo()) {
				eventos.get(i).setNumConvidados(novo);
				return true;
			}
		}
		return false;
	}
	
	public boolean editarDuracao(Evento e, double novo, int opcao) {
		for (int i = 0; i < eventos.size(); i++) {
			if(eventos.get(i) != null && eventos.get(i).getCodigo() == e.getCodigo()) {
				eventos.get(i).setDuracao(novo);
				return true;
			}
		}
		return false;
	}
}
