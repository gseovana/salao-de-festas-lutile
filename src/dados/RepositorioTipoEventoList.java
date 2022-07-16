package dados;

import java.util.ArrayList;
import java.util.List;
import negocio.entity.TipoEvento;

public class RepositorioTipoEventoList {
	private List<TipoEvento> tiposEvento = new ArrayList<TipoEvento>();
	private static int codigo = 1;


	public boolean novo(TipoEvento te) {
		if (te != null) {
			te.setCodigo(codigo);
			incrementarCodigo();
			return tiposEvento.add(te);
		}
		return false;
	}
	
	private void incrementarCodigo() {
		codigo++;	
	}

	public TipoEvento validar(String nome) {
		for (int i = 0; i < this.tiposEvento.size(); i++) {
			if (this.tiposEvento.get(i) != null) {
				if (this.tiposEvento.get(i).getNome().equals(nome)) {
					return new TipoEvento(tiposEvento.get(i));
				}
			}
		}
		return null;
	}

	public boolean deletar(int codigo) {
		for (int i = 0; i < tiposEvento.size(); i++) {
			if (tiposEvento.get(i) != null && tiposEvento.get(i).getCodigo() == codigo)
				return tiposEvento.remove(tiposEvento.get(i));
			}
		return false;
		}

	public List<TipoEvento> listar() {
		List<TipoEvento> aux = new ArrayList<TipoEvento>();
		for (TipoEvento te : tiposEvento) {
			aux.add(new TipoEvento(te));
		}
		return aux;
	}

	public TipoEvento buscar(int codigo) {
		for (int i = 0; i < tiposEvento.size(); i++) {
			if(tiposEvento.get(i).getCodigo() == codigo)
				return new TipoEvento(tiposEvento.get(i));
		}
		return null;
	}
}
