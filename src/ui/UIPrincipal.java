package ui;

import java.util.Scanner;

public class UIPrincipal {
	private Scanner scn = new Scanner(System.in);
	private UICliente uiCliente;
	private UIEvento uiEvento;
	private UITipoEvento uiTipoEvento;
	
	public UIPrincipal() {
		uiCliente = new UICliente();
		uiEvento = new UIEvento();
		uiTipoEvento = new UITipoEvento();
	}
	
	public void iniciar() {
		int opcao = 0;

		do {
			System.out.println("");
			System.out.println("---SALAO DE FESTAS LUTILE---");
			System.out.println("0-Deslogar"); 
			System.out.println("1-Eventos"); 
			System.out.println("2-Clientes"); 
			System.out.println("3-Tipos de Eventos"); 

			opcao = scn.nextInt();

			switch (opcao) {
			case 0:
				System.out.println("Deslogando...");
				break;
			case 1:
				uiEvento.menu();
				break;
			case 2:
				//uiCliente.menu();
				break;
			case 3:
				uiTipoEvento.menu();
				break;
			default:
				System.out.println("Opcao invalida.");
				break;
			}
		} while (opcao != 0);
	}
}
