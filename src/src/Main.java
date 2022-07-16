package src;

/*
 * @author Dirceu e Geovana
 * 
 * */

import negocio.Sistema;
import ui.UIUsuario;

public class Main {
	public static void main(String[] args) {
		Sistema sistema = Sistema.getInstance();
		sistema.init();
		UIUsuario uiUsuario = new UIUsuario();
		uiUsuario.menu();
	}
}