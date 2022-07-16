package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import negocio.entity.Usuario;

@SuppressWarnings("serial")
public class JanelaCadastrarUsuario extends JDialog{

	private Usuario usuario;
	private UIUsuario uiUsuario;

	private JLabel lbNome;
	private JTextField tfNome;
	private JLabel lbCpf;
	private JLabel lbLogin;
	private JTextField tfLogin;
	private JLabel lbSenha;
	private JTextField tfSenha;
	private JButton btSalvar;
	private JButton btCancelar;
	private JFormattedTextField tfCpf;
	private JLabel lbTitulo;

	public JanelaCadastrarUsuario() {
		initGUI();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	// inicializar os componentes (objetos) graficos
	private void initGUI() {
		setModal(true);

		setTitle("Cadastrar usuario");
		setSize(400, 265);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null); // null = meio
		setResizable(false);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		add(panel);

		lbTitulo = new JLabel("Cadastrar usuario");
		lbTitulo.setBounds(110, 0, 200, 85);
		lbTitulo.setFont(new Font(null, Font.BOLD, 20));
		panel.add(lbTitulo);

		lbNome = new JLabel("Nome: *");
		lbNome.setBounds(15, 60, 100, 25);
		panel.add(lbNome);

		tfNome = new JTextField();
		tfNome.setBounds(15, 80, 170, 25);
		panel.add(tfNome);

		lbCpf = new JLabel("CPF: *");
		lbCpf.setBounds(195, 60, 170, 25);
		panel.add(lbCpf);

		try {
			MaskFormatter mascara = new MaskFormatter("###.###.###-##");
			tfCpf = new JFormattedTextField(mascara);
			tfCpf.setBounds(195, 80, 170, 25);
			panel.add(tfCpf);
			} catch (ParseException e) {
				//
			}

		lbLogin = new JLabel("Login: *");
		lbLogin.setBounds(15, 115, 100, 25);
		panel.add(lbLogin);

		tfLogin = new JTextField();
		tfLogin.setBounds(15, 135, 170, 25);
		panel.add(tfLogin);

		lbSenha = new JLabel("Senha: *");
		lbSenha.setBounds(195, 115, 100, 25);
		panel.add(lbSenha);

		tfSenha = new JPasswordField();
		tfSenha.setBounds(195, 135, 170, 25);
		panel.add(tfSenha);

		btSalvar = new JButton("Salvar");
		btSalvar.setBounds(290, 180, 75, 25);
		btSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean ok = true;
				if (tfNome.getText().equals("")) {
					tfNome.setBackground(Color.PINK);
					ok = false;
				}
				if (tfCpf.getText().equals("   .   .   -  ")) {
					tfCpf.setBackground(Color.PINK);
					ok = false;
				}

				if (tfLogin.getText().equals("")) {
					tfLogin.setBackground(Color.PINK);
					ok = false;
				}

				if (tfSenha.getText().equals("")) {
					tfSenha.setBackground(Color.PINK);
					ok = false;
				}

				if (ok) {
					String nome = tfNome.getText();
					String cpf = tfCpf.getText();
					String login = tfLogin.getText();
					String senha = tfSenha.getText();

					if (nome != null && cpf != null & login != null && senha != null) {
						usuario = Usuario.getInstance(nome, cpf, login, senha);

						uiUsuario = new UIUsuario();
						if (uiUsuario.novo(usuario)) {
							String titulo = "Mensagem";
							String alerta = "Usuario cadastrado com sucesso!";
							JOptionPane.showMessageDialog(null, alerta, titulo, JOptionPane.INFORMATION_MESSAGE);
							dispose();
						} else {
							String titulo = "Mensagem";
							String alerta = "Desculpe, não foi possível cadastrar o usuário.";
							JOptionPane.showMessageDialog(null, alerta, titulo, JOptionPane.INFORMATION_MESSAGE);						}
					}
				} else {
					String titulo = "Mensagem";
					String alerta = "Preencha os campos destacados.";
					JOptionPane.showMessageDialog(null, alerta, titulo, JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		panel.add(btSalvar);

		btCancelar = new JButton("Cancelar");
		btCancelar.setBounds(195, 180, 85, 25); // Ignorado pelo FlowLayout
		btCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.add(btCancelar);

		setVisible(true);
	}
}
