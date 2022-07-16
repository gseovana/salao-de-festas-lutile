package ui;

import java.util.List;
import java.util.Scanner;
import negocio.Sistema;
import negocio.entity.Cliente;
import negocio.entity.Evento;
import negocio.entity.TipoEvento;

public class UIEvento {
	private Scanner scn;
	private Sistema sistema;

	public UIEvento() {
		scn = new Scanner(System.in);
		sistema = Sistema.getInstance();
		// uiCliente = new UICliente();
	}

	public void menu() {
		int opcao = 0;

		do {
			System.out.println("");
			System.out.println("---Evento---");
			System.out.println("0-Voltar");
			System.out.println("1-Novo");
			System.out.println("2-Deletar");
			System.out.println("3-Editar");
			System.out.println("4-Detalhar");
			System.out.println("5-Listar");

			opcao = scn.nextInt();

			switch (opcao) {
			case 0:
				break;
			case 1:
				novo();
				break;
			case 2:
				deletar();
				break;
			case 3:
				editar();
				break;
			case 4:
				detalhar();
				break;
			case 5:
				listar();
				break;
			default:
				System.out.println("\nOpcao invalida.");
				break;
			}
		} while (opcao != 0);
	}

	public void novo() {

		int qtdParcelas = 0;

		System.out.println("");
		System.out.println("---Novo evento---");

		System.out.print("Nome: ");
		String nome = scn.next();
		System.out.print("Data: ");
		String data = scn.next();
		System.out.print("Horario: ");
		String horario = scn.next();
		System.out.print("Numero de convidados: ");
		int numConvidados = scn.nextInt();
		System.out.print("Duracao: ");
		double duracao = scn.nextDouble();
		System.out.println("");
		System.out.println("*** Forma de pagamento ***");
		System.out.println("1-A vista");
		System.out.println("2-Parcelado");
		System.out.print("Sua escolha: ");
		int formaPagto = scn.nextInt();
		if (formaPagto == 2) {
			System.out.print("Quantidade de parcelas: ");
			qtdParcelas = scn.nextInt();
		}

		System.out.print("");
		List<TipoEvento> tipos = sistema.listarTiposDeEvento();
		System.out.println("\nCOD\tNOME");
		if (tipos != null) {
			for (int i = 0; i < tipos.size(); i++) {
				if (tipos.get(i) != null) {
					System.out.println(tipos.get(i).getCodigo() + "\t" + tipos.get(i).getNome());
				}
			}
		}

		System.out.print("\nCodigo do tipo de evento: ");
		int codigo = scn.nextInt();

		if (sistema.buscarTipoEvento(codigo) != null) {
			System.out.println("");
			List<Cliente> clientes = sistema.listarClientes();

			System.out.println("NOME\t\tNASC\t\tCPF\t\tTELEFONE\tEMAIL");
			if (clientes != null) {
				for (int i = 0; i < clientes.size(); i++) {
					if (clientes.get(i) != null) {
						System.out.println(clientes.get(i).getNome() + "\t\t" + clientes.get(i).getDataNasc() + "\t"
								+ clientes.get(i).getCpf() + "\t" + clientes.get(i).getTelefone() + "\t"
								+ clientes.get(i).getEmail());
					}
				}
			}
			System.out.println("\nCPF do Cliente: ");
			String cpf = scn.next();

			if (sistema.buscarCliente(cpf) != null) {
				Evento evento = Evento.getInstance(nome, data, horario, sistema.buscarTipoEvento(codigo), numConvidados,
						duracao, sistema.buscarCliente(cpf), formaPagto, qtdParcelas);

				if (!sistema.novoEvento(evento)) {
					System.out.println("\nErro ao cadastrar evento.");
				} else {
					System.out.println("\nEvento cadastrado com sucesso!");
				}
			} else {
				System.out.println("Cliente nao encontrado.");
			}
		} else {
			System.out.println("Tipo de evento nao encontrado.");
		}
	}

	private void deletar() {
		System.out.println("");
		System.out.println("---Deletar---");
		System.out.print("Informe o codigo do evento: ");
		int codigo = scn.nextInt();

		Evento e = sistema.buscarEvento(codigo);

		if (e != null) {
			System.out.println("Nome: " + e.getNome());
			System.out.println("Data: " + e.getData());
			System.out.println("Horario: " + e.getHorario());
			System.out.println("Convidados: " + e.getNumConvidados());
			System.out.println("Cliente: " + e.getCliente().getNome());
			System.out.println("Tipo de evento: " + e.getTipoEvento().getNome());

			System.out.println("\nTem certeza que deseja deletar esse evento? ");
			System.out.println("1-Sim");
			System.out.println("2-Nao");
			int opcao = scn.nextInt();

			switch (opcao) {
			case 1:
				if (sistema.deletarEvento(e))
					System.out.println("Evento deletado com sucesso!");
				else
					System.out.println("Erro ao deletar evento.");
				break;
			case 2:
				break;
			default:
				System.out.println("Opcao invalida.");
				break;
			}
		}
	}

	public void editar() {
		System.out.println("");
		System.out.println("---Editar evento---");
		System.out.println("Informe o codigo: ");
		int codigo = scn.nextInt();

		Evento e = sistema.buscarEvento(codigo);
		if (e != null) {
			System.out.println("Nome: " + e.getNome());
			System.out.println("Data: " + e.getData());
			System.out.println("Horario: " + e.getHorario());
			System.out.println("Convidados: " + e.getNumConvidados());
			System.out.println("Duracao: " + e.getDuracao());
			System.out.println("Cliente: " + e.getCliente().getNome());
			System.out.println("Tipo de evento: " + e.getTipoEvento().getNome());

			System.out.println("");
			System.out.println("---Editar---");
			System.out.println("1-Nome");
			System.out.println("2-Data");
			System.out.println("3-Horario");
			System.out.println("4-Quantidade de convidados");
			System.out.println("5-Duracao");
			System.out.println("6-Tipo de evento");
			System.out.println("7-Cliente");

			int opcao = scn.nextInt();

			if (opcao > 0 && opcao < 4) {
				System.out.print("Novo: ");
				String novo = scn.next();

				if (sistema.editarEvento(e, novo, opcao)) {
					System.out.println("Evento editado com sucesso!");
				} else {
					System.out.println("Erro ao editar evento.");
				}
			}
			if(opcao == 4) {
				System.out.println("Novo: ");
				int novo = scn.nextInt();
				if(sistema.editarNumConvidados(e, novo, opcao)){
					System.out.println("Evento editado com sucesso!");
				}else {
					System.out.println("Erro ao editar evento.");
				}
			}
			if (opcao == 6) {
				System.out.print("");
				List<TipoEvento> tipos = sistema.listarTiposDeEvento();
				System.out.println("\nCOD\tNOME");
				if (tipos != null) {
					for (int i = 0; i < tipos.size(); i++) {
						if (tipos.get(i) != null) {
							System.out.println(tipos.get(i).getCodigo() + "\t" + tipos.get(i).getNome());
						}
					}
				}
				System.out.print("\nCodigo do novo tipo: ");
				int codigoTipo = scn.nextInt();
				if (sistema.buscarEvento(codigoTipo) != null) {
					TipoEvento te = sistema.buscarTipoEvento(codigoTipo);
					if (sistema.editarEventoTipoEvento(e, te, opcao)) {
						System.out.println("Evento editado com sucesso!");
					} else {
						System.out.println("Erro ao editar evento.");
					}
				} else {
					System.out.println("Tipo de evento nao encontrado.");
				}
			}
			if (opcao == 7) {
				System.out.println("");
				List<Cliente> clientes = sistema.listarClientes();

				System.out.println("NOME\t\tNASC\t\tCPF\t\tTELEFONE\tEMAIL");
				if (clientes != null) {
					for (int i = 0; i < clientes.size(); i++) {
						if (clientes.get(i) != null) {
							System.out.println(clientes.get(i).getNome() + "\t\t" + clientes.get(i).getDataNasc() + "\t"
									+ clientes.get(i).getCpf() + "\t" + clientes.get(i).getTelefone() + "\t"
									+ clientes.get(i).getEmail());
						}
					}
				}
				System.out.print("\nCPF do novo cliente: ");
				String cpf = scn.next();

				if (sistema.buscarCliente(cpf) != null) {
					Cliente c = sistema.buscarCliente(cpf);
					if (sistema.editarEventoCliente(e, c, opcao)) {
						System.out.println("Evento editado com sucesso!");
					}else {
						System.out.println("Erro ao editar evento.");
					}
				} else {
					System.out.println("Cliente nao encontrado.");
				}
			}
		}

	}

	public void detalhar() {
		System.out.println("");
		System.out.println("---Detalhar evento---");
		System.out.print("Informe o codigo: ");
		int codigo = scn.nextInt();

		Evento e = sistema.buscarEvento(codigo);

		if (e != null) {
			System.out.println("Nome: " + e.getNome());
			System.out.println("Data: " + e.getData());
			System.out.println("Horario: " + e.getHorario());
			System.out.println("Tipo de evento: " + e.getTipoEvento().getNome());
			System.out.println("Convidados: " + e.getNumConvidados());
			System.out.println("Duracao: " + e.getDuracao());
			System.out.println("Cliente: " + e.getCliente().getNome());
		} else {
			System.out.println("Erro ao detalhar cliente.");
		}
	}

	private void listar() {
		System.out.println("");
		System.out.println("---Listar eventos---");

		List<Evento> eventos = sistema.listarEventos();
		System.out.println("COD\tNOME\t\tDATA\t\tHORARIO\t\tTIPO\t\tCONVI.\tDURACAO\t\tCLIENTE");
		if (eventos != null) {
			for (int i = 0; i < eventos.size(); i++) {
				if (eventos.get(i) != null) {
					System.out.println(eventos.get(i).getCodigo() + "\t" + eventos.get(i).getNome() + "\t\t"
							+ eventos.get(i).getData() + "\t" + eventos.get(i).getHorario() + "\t\t"
							+ eventos.get(i).getTipoEvento().getNome() + "\t" + eventos.get(i).getNumConvidados() + "\t"
							+ eventos.get(i).getDuracao() + "\t\t" + eventos.get(i).getCliente().getNome());
				}
			}
		}

	}

}
