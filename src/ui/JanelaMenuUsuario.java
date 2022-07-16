package ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import negocio.ISistema;
import negocio.Sistema;
import negocio.entity.Cliente;
import ui.JanelaMenuUsuario;

@SuppressWarnings("serial")
public class JanelaMenuUsuario extends JFrame{

	private JTextField tfLogin;
	private JTextField tfSenha;
	private JButton btLogar;
	private JLabel lbTitulo;

	private List<Cliente> clientes;
	private ISistema iSistema;
	private UIUsuario uiUsuario;
	private JanelaPrincipal janelaPrincipal;
	private JanelaCadastrarUsuario janelaCadastrarUsuario;
	private String login;
	private String senha;
	
	public JanelaMenuUsuario() {
		iSistema = Sistema.getInstance();
		this.clientes = iSistema.listarClientes();
		initGUI();
	}

	// inicializar os componentes (objetos) graficos
	private void initGUI() {
		setTitle("Login");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // null = meio
		setResizable(false);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		add(panel);
		
		lbTitulo = new JLabel("LOGIN");
		lbTitulo.setBounds(163, 15, 200, 25);
		lbTitulo.setFont(new Font(null, Font.BOLD, 20));
		panel.add(lbTitulo);
		
		JLabel lbLogin = new JLabel("Login: *");
		lbLogin.setBounds(85, 60, 100, 25);
		panel.add(lbLogin);

		tfLogin = new JTextField();
		tfLogin.setBounds(85, 80, 200, 25);
		panel.add(tfLogin);

		JLabel lbSenha = new JLabel("Senha: *");
		lbSenha.setBounds(85, 110, 100, 25);
		panel.add(lbSenha);

		tfSenha = new JPasswordField();
		tfSenha.setBounds(85, 130, 200, 25);
		panel.add(tfSenha);

		JLabel link = new JLabel("Cadastre-se");
		link.setBounds(215, 150, 90, 25);
		link.setForeground(Color.BLUE.darker());
		link.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(link);

		link.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				janelaCadastrarUsuario = new JanelaCadastrarUsuario();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				link.setText("<html><u>Cadastre-se</u></html>");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				link.setText("Cadastre-se");
			}
		});

		btLogar = new JButton("Logar");
		btLogar.setBounds(150, 185, 80, 25);
		btLogar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				boolean ok = true;
				if (tfLogin.getText().equals("")) {
					tfLogin.setBackground(Color.PINK);
					ok = false;
				}
				if (tfSenha.getText().equals("")) {
					tfSenha.setBackground(Color.PINK);
					ok = false;
				}

				if (ok) {
					login = tfLogin.getText();
					senha = tfSenha.getText();

					uiUsuario = new UIUsuario();

					if (uiUsuario.logar(login, senha)) {
						dispose();
						janelaPrincipal = new JanelaPrincipal(clientes);
						janelaPrincipal.setVisible(true);
					} else {
						String titulo = "Mensagem";
						String alerta = "Login ou senha incorretos.";
						JOptionPane.showMessageDialog(null, alerta, titulo, JOptionPane.INFORMATION_MESSAGE);						}
				} else {
					String titulo = "Mensagem";
					String alerta = "Desculpe, algo deu errado.";
					JOptionPane.showMessageDialog(null, alerta, titulo, JOptionPane.INFORMATION_MESSAGE);				}
			}
			
		}); 
		panel.add(btLogar);

		setVisible(true);
	}
}
