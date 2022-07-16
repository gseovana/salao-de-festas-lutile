package ui;

import negocio.ISistema;
import negocio.Sistema;
import negocio.entity.Usuario;

public class UIUsuario {

	private ISistema iSistema;

	public UIUsuario() {
		iSistema = Sistema.getInstance();
	}

	public void menu() {
		JanelaMenuUsuario janelaMenuUsuario = new JanelaMenuUsuario();
	}

	protected boolean novo(Usuario usuario) {
		if (usuario != null) {
			if (iSistema.novoUsuario(usuario)) {
				return true;
			}
		}
		return false;
	}

	protected boolean logar(String login, String senha) {
		if (login != null && senha != null) {
			if (iSistema.logar(login, senha)) {
				return true;
			}
		}
		return false;
	}
}
