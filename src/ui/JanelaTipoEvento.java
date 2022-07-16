package ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class JanelaTipoEvento extends JDialog implements ActionListener {

	private JLabel lbTitulo;
	private JLabel lbNome;
	private JTextField tfNome;
	private JButton btSalvar ;

	public JanelaTipoEvento() {
		// sistema = Sistema.getInstance();
		initGUI();
	}

	private void initGUI() {
		setModal(true);

		setTitle("Tipo de evento");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		setSize(500, 450);
		setLocationRelativeTo(null);
		setResizable(false);

		// MENU
		JPanel panel = new JPanel();
		panel.setLayout(null);
		getContentPane().add(panel, BorderLayout.CENTER);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu principal = new JMenu("Principal");
		JMenu cliente = new JMenu("Cliente");
		JMenu evento = new JMenu("Evento");
		JMenu tiposDeEvento = new JMenu("Tipo de evento");
		tiposDeEvento.setEnabled(false);

		menuBar.add(principal);
		menuBar.add(cliente);
		menuBar.add(evento);
		menuBar.add(tiposDeEvento);

//		cliente.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				dispose();
//			}
//		});
//
//		evento.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				dispose();
//			}
//		});
//
//		tiposDeEvento.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				dispose();
//			}
//		});

		// TITULO
		lbTitulo = new JLabel("Tipos de evento");
		lbTitulo.setBounds(150, 10, 200, 25);
		lbTitulo.setFont(new Font(null, Font.BOLD, 20));
		panel.add(lbTitulo);
		
		lbNome = new JLabel("Nome: *");
		lbNome.setBounds(15, 45, 100, 25);
		panel.add(lbNome);
		
		tfNome = new JTextField();
		tfNome.setBounds(15, 65, 225, 25);
		panel.add(tfNome);
		
		btSalvar = new JButton("Salvar");
		btSalvar.setBounds(245, 65, 80, 25);
		btSalvar.addActionListener(this); // this = Janela que eh a ouvidora
		panel.add(btSalvar);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}
