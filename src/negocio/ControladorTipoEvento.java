package negocio;

import java.util.List;

import dados.RepositorioTipoEventoList;
import negocio.entity.TipoEvento;

public class ControladorTipoEvento {
	private RepositorioTipoEventoList repoTipoEvento;

	public ControladorTipoEvento() {
		repoTipoEvento = new RepositorioTipoEventoList();
	}

	public boolean novo(TipoEvento te) {
		if (validar(te)) {
			return repoTipoEvento.novo(te);
		}
		return false;
	}

	private boolean validar(TipoEvento te) {
		if (te != null) {
			TipoEvento tipoEvento = repoTipoEvento.validar(te.getNome());
			if (tipoEvento != null && tipoEvento.getNome().equals(te.getNome()))
				return false;
			else
				return true;
		}
		return false;
	}

	public boolean deletar(int codigo) {
		if (codigo > 0)
			
			return repoTipoEvento.deletar(codigo);
		return false;
	}

	public List<TipoEvento> listar() {
		return repoTipoEvento.listar();
	}

	public TipoEvento buscar(int codigo) {
		if(codigo > 0) {
			return repoTipoEvento.buscar(codigo);
		}
		return null;
	}

}
