package negocio;

import dados.RepositorioUsuarioList;
import negocio.entity.Usuario;

public class ControladorUsuario {
	private RepositorioUsuarioList repoUsuario;

	public ControladorUsuario() {
		repoUsuario = new RepositorioUsuarioList();
	}

	public boolean logar(String login, String senha) {
		if (login != null && senha != null)
			return repoUsuario.logar(login, senha);
		else
			return false;
	}

	public boolean novo(Usuario u) {
		if (validar(u)) {
			return repoUsuario.novo(u);
		}
		return false;
	}

	private boolean validar(Usuario usuario) {
		Usuario u = repoUsuario.buscar(usuario.getLogin()); // retorna nulo se nao encontrar
		if (u != null && u.getLogin().equals(usuario.getLogin()))
			return false;
		else
			return true;
	}
}
