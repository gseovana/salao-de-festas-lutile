package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import negocio.ISistema;
import negocio.Sistema;
import negocio.entity.Cliente;
import negocio.entity.Evento;
@SuppressWarnings("serial")
public class JanelaPrincipal extends JDialog{
	
	private JButton btSair;
	private List<Cliente> clientes;
	private List<Evento> eventos;


	public JanelaPrincipal(List<Cliente> clientes, List<Evento> eventos) {
		this.clientes = clientes;
		this.eventos = eventos;
		initGUI(clientes, eventos);
	}

	private void initGUI(List<Cliente> clientes, List<Evento> eventos) {
		setModal(true);

		setTitle("Principal");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		setSize(500, 300);
		setLocationRelativeTo(null);
		setResizable(false);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		getContentPane().add(panel, BorderLayout.CENTER);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu principal = new JMenu("Principal");
		principal.setEnabled(false);
		JMenu cliente = new JMenu("Cliente");
		JMenu evento = new JMenu("Evento");
		JMenu tipoEvento = new JMenu("Tipos Evento");

		menuBar.add(principal);
		menuBar.add(cliente);
		menuBar.add(evento);
		menuBar.add(tipoEvento);

		cliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JanelaCliente janelaCliente = new JanelaCliente(clientes);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				cliente.setArmed(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				cliente.setArmed(false);
			}
		});
		
		evento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JanelaEvento janelaEvento = new JanelaEvento(eventos);
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
				JanelaTipoEvento janelaTipoEvento = new JanelaTipoEvento();
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

		btSair = new JButton("Sair");
		btSair.setBounds(350, 0, 80, 25);
		btSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		}); 
		panel.add(btSair);

		setVisible(true);

	}
}
