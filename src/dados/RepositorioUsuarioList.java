package dados;

import java.util.ArrayList;
import java.util.List;

import negocio.entity.Usuario;

public class RepositorioUsuarioList {
	private List<Usuario> usuarios = new ArrayList<Usuario>();

	public boolean logar(String login, String senha) {
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i) != null && usuarios.get(i).getLogin().equals(login)
					&& usuarios.get(i).getSenha().equals(senha))
				return true;
		}
		return false;
	}
	
	public boolean novo(Usuario u) {
		if (u != null) {
			return usuarios.add(u);
		}
		return false;
	}

	public Usuario buscar(String login) {
		for (int i = 0; i < usuarios.size(); i++) {
			if(usuarios.get(i) != null && usuarios.get(i).getLogin().equals(login))
				return usuarios.get(i);
		}
		return null;
	}
}
