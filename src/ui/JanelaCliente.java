package ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import negocio.entity.Cliente;
import negocio.entity.Evento;

@SuppressWarnings("serial")
public class JanelaCliente extends JDialog implements ActionListener {

	private List<Cliente> clientes;
	private List<Evento> eventos;
	private Cliente c;
	private UICliente uiCliente = new UICliente();
	private JanelaEvento janelaEvento;
	private JanelaTipoEvento janelaTipoEvento;
	private JanelaPrincipal janelaPrincipal;

	private JLabel lbTitulo;
	private JTable tbClientes;
	private JPanel panel = new JPanel();

	// DECLARACAO BOTOES
	private JButton btVisualizar;
	private JButton btEditar;
	private JButton btExcluir;
	private JButton btNovo;

	public JanelaCliente(List<Cliente> clientes) {
		this.clientes = clientes;
		setTitle("Cliente");
		initGUI();
	}

	private void initGUI() {
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		setSize(500, 400);
		setLocationRelativeTo(null);
		setResizable(true);

		// ----------------------- MENU ---------------------------------

		panel.setLayout(null);
		getContentPane().add(panel, BorderLayout.CENTER);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu principal = new JMenu("Principal");
		JMenu cliente = new JMenu("Cliente");
		cliente.setEnabled(false); // cliente selecionado
		JMenu evento = new JMenu("Evento");
		JMenu tipoEvento = new JMenu("Tipo de evento");

		menuBar.add(principal);
		menuBar.add(cliente);
		menuBar.add(evento);
		menuBar.add(tipoEvento);

		principal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				janelaPrincipal = new JanelaPrincipal(clientes, eventos);
				janelaPrincipal.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				principal.setArmed(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				principal.setArmed(false);

			}
		});

		evento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				janelaEvento = new JanelaEvento(eventos);
				janelaEvento.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				evento.setArmed(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				evento.setArmed(false);
			}
		});

		tipoEvento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				janelaTipoEvento = new JanelaTipoEvento();
				janelaTipoEvento.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				tipoEvento.setArmed(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				tipoEvento.setArmed(false);
			}
		});

		// ---------------------------- TITULO -------------------------------------

		lbTitulo = new JLabel("CLIENTE");
		lbTitulo.setBounds(205, 15, 200, 25);
		lbTitulo.setFont(new Font(null, Font.BOLD, 20));
		panel.add(lbTitulo);

		// --------------------------- BOTAO VISUALIZAR -----------------------------

		btVisualizar = new JButton("Visualizar");
		btVisualizar.setBounds(17, 55, 100, 25);

		// ACTION LISTENER PARA PEGAR O OBJETO DA LINHA

		btVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tbClientes.getSelectedRow() != -1) {
					Object o = tbClientes.getValueAt(tbClientes.getSelectedRow(), 0);
					int id = Integer.parseInt(o.toString());
					
					c = uiCliente.buscarCliente(id);
					
					dispose();
					JanelaVisualizarCliente janelaVisualizarCliente = new JanelaVisualizarCliente(c);
				}
			}
		});

		panel.add(btVisualizar);

		// ----------------------------- BOTAO EDITAR ---------------------------------

		btEditar = new JButton("Editar");
		btEditar.setBounds(147, 55, 85, 25);
		
		btEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tbClientes.getSelectedRow() != -1) {
					Object o = tbClientes.getValueAt(tbClientes.getSelectedRow(), 0);
					int id = Integer.parseInt(o.toString());
					
					c = uiCliente.buscarCliente(id);
					
					dispose();
					JanelaCadastrarCliente janelaCadastrarCliente = new JanelaCadastrarCliente(c);
				}
			}
		});
		panel.add(btEditar);

		// ----------------------------- BOTAO NOVO ----------------------------------

		btNovo = new JButton("Novo");
		btNovo.setBounds(262, 55, 85, 25);
		btNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JanelaCadastrarCliente janelaCadastrarCliente = new JanelaCadastrarCliente();
			}
		});

		panel.add(btNovo);

		// ------------------------------- BOTAO EXCLUIR ------------------------------

		btExcluir = new JButton("Excluir");
		btExcluir.setBounds(375, 55, 90, 25);
		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tbClientes.getSelectedRow() != -1) {
					Object o = tbClientes.getValueAt(tbClientes.getSelectedRow(), 0);
					int id = Integer.parseInt(o.toString());
					
					c = uiCliente.buscarCliente(id);
					
					if(confirmarExclusao()) {
						if(uiCliente.deletar(c.getId())) {
							informar(0);
						}else {
							informar(1);
						}
						dispose();
						clientes = uiCliente.listar();
						JanelaCliente janelaCliente = new JanelaCliente(clientes);					
					}
				}
			}
		});

		panel.add(btExcluir);

		// -------------------------------- TABELA CLIENTE
		// -------------------------------

		setSize(500, 400);
		getContentPane().setLayout(new BorderLayout());
		this.panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		getContentPane().add(this.panel, BorderLayout.CENTER);
		panel.setLayout(null);
		tabela(clientes);

		tbClientes.getTableHeader().setReorderingAllowed(false);
	}

	// ---------------------------- DEFININDO TABELA CLIENTE
	// --------------------------------

	private void tabela(List<Cliente> c) {
		ClienteTableModel tmclientes = new ClienteTableModel(c);
		tbClientes = new JTable(tmclientes);
		tbClientes.setBounds(200, 250, 550, 200);
		panel.add(tbClientes);

		tbClientes.getColumnModel().getColumn(0).setPreferredWidth(25); //ID
		tbClientes.getColumnModel().getColumn(0).setResizable(false);

		tbClientes.getColumnModel().getColumn(1).setPreferredWidth(100); //NOME
		tbClientes.getColumnModel().getColumn(1).setResizable(false);

		tbClientes.getColumnModel().getColumn(2).setPreferredWidth(150); //CPF
		tbClientes.getColumnModel().getColumn(2).setResizable(false);

		tbClientes.getColumnModel().getColumn(3).setPreferredWidth(115); //DATA NASC
		tbClientes.getColumnModel().getColumn(3).setResizable(false);

		tbClientes.getColumnModel().getColumn(4).setPreferredWidth(150); //TELEFONE
		tbClientes.getColumnModel().getColumn(4).setResizable(false);

		tbClientes.getColumnModel().getColumn(5).setPreferredWidth(150); // EMAIL
		tbClientes.getColumnModel().getColumn(5).setResizable(false);

		JScrollPane scPane = new JScrollPane(tbClientes, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scPane.setBounds(17, 100, 450, 200);
		panel.add(scPane);

		setVisible(true);
	}

	// ----------------------------- VALIDAR DADOS -------------------------
	
	public boolean confirmarExclusao() {
		Object[] opcoes = {"Excluir", "Cancelar"};
		int n = JOptionPane.showOptionDialog(this,
		                "Tem certeza que deseja excluir o cliente selecionado?",
		                "Confirmar exclusão",
		                JOptionPane.OK_CANCEL_OPTION,
		                JOptionPane.QUESTION_MESSAGE,
		                null,
		                opcoes,
		                opcoes[0]);
		if (n == JOptionPane.OK_OPTION) {
			return true;
		} else {
			return false;
		}
	}
	
	public void informar(int num) {
		if(num == 0)
		JOptionPane.showMessageDialog(this, "Cliente excluído com sucesso!", "Sucesso",
				JOptionPane.INFORMATION_MESSAGE);
		else {
			JOptionPane.showMessageDialog(this, "Falha ao excluir cliente", "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
