package ui;

import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Scanner;

import negocio.ISistema;
import negocio.Sistema;
import negocio.entity.Cliente;
import negocio.entity.Evento;
import negocio.entity.TipoEvento;

public class UIEvento {
	private Scanner scn;
	private ISistema iSistema;

	public UIEvento() {
		iSistema = Sistema.getInstance();
	}

	public boolean novo(Evento evento) {
		if (evento != null) {
			if (iSistema.novoEvento(evento)) {
				return true;
			}
		}
		return false;
	}

	public boolean deletar(int id) {
		Evento e = iSistema.buscarEvento(id);

		if (e != null) {
			if (iSistema.deletarEvento(e))
				return true;
		}
		return false;
	}

	public List<Evento> listar() {
		return iSistema.listarEventos();
	}

	public Evento buscarEvento(int id) {
		return iSistema.buscarEvento(id);
	}
}
