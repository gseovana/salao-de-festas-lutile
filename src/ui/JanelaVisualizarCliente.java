package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import negocio.entity.Cliente;

public class JanelaVisualizarCliente extends JDialog implements ActionListener{

	// LABELS
		private JLabel lbTitulo;
		private JLabel lbNome;
		private JLabel lbCpf;
		private JLabel lbDataNasc;
		private JLabel lbTelefone;
		private JLabel lbEmail;

		// TEXT FIELDS
		private JTextField tfNome;
		private JTextField tfCpf;
		private JTextField tfDataNasc;
		private JTextField tfTelefone;
		private JTextField tfEmail;

		// BOTOES
		private JButton btSalvar;
		private JButton btVoltar;
		
		// ENTIDADES E UIS
		private UICliente uiCliente = new UICliente();
		private List<Cliente> clientes;

		public JanelaVisualizarCliente(Cliente c) {
			initGUI(c);
			this.setTitle("Visualizar Cliente");
			tfNome.setText(c.getNome());
			tfCpf.setText(String.valueOf(c.getCpf()));
			tfDataNasc.setText(c.getDataNasc());
			tfTelefone.setText(String.valueOf(c.getTelefone()));
			tfEmail.setText(String.valueOf(c.getEmail()));

			this.setVisible(true);
		}

		private void initGUI(Object c) {

			this.setModal(true);
			this.setTitle("Novo cliente");
			this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			this.setSize(455, 270);
			this.setLocationRelativeTo(null);
			this.setResizable(false);

			JPanel panel = new JPanel();
			panel.setLayout(null);
			this.getContentPane().add(panel, BorderLayout.CENTER);

			// ------------------------------MENU-----------------------------------

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
					// janelaPrincipal = new JanelaPrincipal(clientes);
					// janelaPrincipal.setVisible(true);
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
					// janelaEvento = new JanelaEvento();
					// janelaEvento.setVisible(true);
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
					// janelaTipoEvento = new JanelaTipoEvento();
					// janelaTipoEvento.setVisible(true);
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

			// ------------------------------TITULO---------------------------------

			lbTitulo = new JLabel("VISUALIZAR CLIENTE");
			lbTitulo.setBounds(130, 15, 260, 25);
			lbTitulo.setFont(new Font(null, Font.BOLD, 20));
			panel.add(lbTitulo);

			// -------------------------- LABEL E TF NOME ---------------------------------

			lbNome = new JLabel("Nome: *");
			lbNome.setBounds(15, 45, 80, 25);
			panel.add(lbNome);

			tfNome = new JTextField();
			tfNome.setEditable(false);
			tfNome.setBounds(15, 65, 130, 25);
			panel.add(tfNome);

			// -------------------------- LABEL E TF CPF -----------------------------------

			lbCpf = new JLabel("CPF: *");
			lbCpf.setBounds(155, 45, 50, 25);
			panel.add(lbCpf);

			/* MASCARA */
			try {
				MaskFormatter mascara = new MaskFormatter("###.###.###-##");
				tfCpf = new JFormattedTextField(mascara);
				tfCpf.setEditable(false);
				tfCpf.setBounds(155, 65, 130, 25);
				panel.add(tfCpf);
			} catch (ParseException e) {
				//
			}

			// ------------------------ LABEL E TF DATA NASCIMENTO ------------------------

			lbDataNasc = new JLabel("Data nascimento: *");
			lbDataNasc.setBounds(295, 45, 130, 25);
			panel.add(lbDataNasc);

			try {
				MaskFormatter mascara = new MaskFormatter("##/##/####");
				tfDataNasc = new JFormattedTextField(mascara);
				tfDataNasc.setEditable(false);
				tfDataNasc.setBounds(295, 65, 130, 25);
				panel.add(tfDataNasc);
			} catch (ParseException e) {
				//
			}

			// ------------------------------ LABEL E TF TELEFONE
			// ----------------------------

			lbTelefone = new JLabel("Telefone: *");
			lbTelefone.setBounds(15, 95, 100, 25);
			panel.add(lbTelefone);

			/* MASCARA */
			try {
				MaskFormatter mascara = new MaskFormatter("(##)#####-####");
				tfTelefone = new JFormattedTextField(mascara);
				tfTelefone.setEditable(false);
				tfTelefone.setBounds(15, 115, 130, 25);
				panel.add(tfTelefone);
			} catch (ParseException e) {
				//
			}

			// -------------------------------- LABEL E TF EMAIL
			// -------------------------------

			lbEmail = new JLabel("Email: ");
			lbEmail.setBounds(155, 95, 100, 25);
			panel.add(lbEmail);

			tfEmail = new JTextField();
			tfEmail.setEditable(false);
			tfEmail.setBounds(155, 115, 130, 25);
			panel.add(tfEmail);

			// ---------------------------------- BOTAO SALVAR
			// ----------------------------------

			btVoltar = new JButton("Voltar");
			btVoltar.setBounds(345, 160, 80, 25);
			btVoltar.addActionListener(this); // this = Janela que eh a ouvidora
			panel.add(btVoltar);
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if (obj == btVoltar) {
				dispose();
				JanelaCliente janelaCliente = new JanelaCliente(uiCliente.listar());
			}
		}

	}
