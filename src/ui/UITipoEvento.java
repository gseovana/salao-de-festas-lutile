package ui;

import java.util.List;
import java.util.Scanner;
import negocio.Sistema;
import negocio.entity.TipoEvento;

public class UITipoEvento {
	private Scanner scn;
	private Sistema sistema;
	private JanelaTipoEvento janelaTipoEvento;

	public UITipoEvento() {
		scn = new Scanner(System.in);
		sistema = Sistema.getInstance();
	}
	
	public void menu() {
		janelaTipoEvento = new JanelaTipoEvento();
		janelaTipoEvento.setVisible(true);
	}

	public void novo() {
		System.out.println("");
		System.out.println("---Novo tipo de evento---");

		System.out.print("Nome: ");
		String nome = scn.next();

		TipoEvento tipoEvento = TipoEvento.getInstance(nome);

		if (!sistema.novoTipoEvento(tipoEvento)) {
			System.out.println("\nErro ao cadastrar novo tipo de evento.");
		} else {
			System.out.println("\nNovo tipo de evento cadastrado com sucesso!");
			System.out.println("Codigo: " + tipoEvento.getCodigo());
			System.out.println("Nome: " + tipoEvento.getNome());
		}
	}

	public void deletar() {
		System.out.println("");
		System.out.println("---Deletar tipo de evento---");
		System.out.print("Codigo: ");
		int codigo = scn.nextInt();

		if (sistema.confirmarTipoEvento(codigo)) {
			System.out.println("Nao e possivel remover um tipo de evento em uso.");
		} else {
			if (sistema.deletarTipoEvento(codigo))
				System.out.println("\nTipo de evento deletado com sucesso!");
			else
				System.out.println("\nErro ao deletar tipo de evento.");
		}
	}

	public void listar() {
		System.out.println("");
		System.out.println("---Listar tipos de eventos---");

		List<TipoEvento> tiposEvento = sistema.listarTiposDeEvento();

		System.out.println("COD\tNOME");
		if (tiposEvento != null) {
			for (int i = 0; i < tiposEvento.size(); i++) {
				if (tiposEvento.get(i) != null) {
					System.out.println(tiposEvento.get(i).getCodigo() + "\t" + tiposEvento.get(i).getNome());
				}
			}
		}
	}

	public TipoEvento buscarTipoEvento(int codigo) {
		if (codigo > 0)
			return sistema.buscarTipoEvento(codigo);
		else
			return null;
	}

	public boolean procurarTipoEvento(int codigo) {
		if(codigo > 0) {
			return sistema.procurarTipoEvento(codigo);
		}
		return false;
	}

}
