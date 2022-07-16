package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import negocio.entity.Cliente;

public class JanelaEvento extends JDialog implements ActionListener{

	private JLabel lbTitulo;
	private JLabel lbCliente;
	private JLabel lbTipoEvento;
	private Component lbNumConvidados;
	private JTextField tfNumConvidados;
	private JLabel lbData;
	private JFormattedTextField tfData;
	private JLabel lbHorario;
	private JFormattedTextField tfHorario;
	private JLabel lbDuracao;
	private JFormattedTextField tfDuracao;
	private JButton btNovoTipo;
	private JLabel lbObrigatorio;
	private JLabel lbFormaPagto;
	private JComboBox<String> cbFormaPagto;
	private JComboBox<String> cbCliente;
	private JComboBox<String> cbTipoEvento;
	private JLabel lbQtdParcelas;
	private JComboBox<String> cbQtdParcelas;
	private JLabel lbTipoPagto;
	private JComboBox<String> cbTipoPagto;
	private JButton btSalvar;
	private UICliente uiCliente;
	private List<Cliente> clientes;

	public JanelaEvento() {
		// sistema = Sistema.getInstance();
		initGUI();
	}

	private void initGUI() {
		setModal(true);

		setTitle("Evento");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		setSize(890, 520);
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
		evento.setEnabled(false);
		JMenu tiposDeEvento = new JMenu("Tipo de evento");

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
		lbTitulo = new JLabel("EVENTO");
		lbTitulo.setBounds(420, 15, 200, 25);
		lbTitulo.setFont(new Font(null, Font.BOLD, 20));
		panel.add(lbTitulo);

		// SUBPANEL
		JPanel panelEvento = new JPanel();
		TitledBorder tb = BorderFactory.createTitledBorder("Dados do evento");
		tb.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		panelEvento.setBorder(tb);
		panelEvento.setBounds(10, 50, 420, 180);
		panelEvento.setLayout(null);
		panel.add(panelEvento);

		// LABEL E TF CLIENTE
		lbCliente = new JLabel("Cliente: *");
		lbCliente.setBounds(15, 15, 305, 25);
		panelEvento.add(lbCliente);

		cbCliente = new JComboBox<String>();
		// add items to the combo box
		uiCliente =  new UICliente();
		clientes = uiCliente.listar();
		for (int i = 0; i < clientes.size(); i++) {
			cbCliente.addItem(clientes.get(i).toString());
		}
		cbCliente.addItem("English");
		cbCliente.addItem("French");
		cbCliente.addItem("Spanish");
		cbCliente.addItem("Japanese");
		cbCliente.addItem("Chinese");
		cbCliente.setBounds(15, 35, 200, 25);
		panelEvento.add(cbCliente);

		// LABEL E TF TIPO EVENTO
		lbTipoEvento = new JLabel("Tipo de evento: *");
		lbTipoEvento.setBounds(15, 65, 305, 25);
		panelEvento.add(lbTipoEvento);

		cbTipoEvento = new JComboBox<String>();
		// add items to the combo box
		cbTipoEvento.addItem("English");
		cbTipoEvento.addItem("French");
		cbTipoEvento.addItem("Spanish");
		cbTipoEvento.addItem("Japanese");
		cbTipoEvento.addItem("Chinese");
		cbTipoEvento.setBounds(15, 85, 200, 25);
		cbTipoEvento.setEditable(true);
		panelEvento.add(cbTipoEvento);

		// BOTAO NOVO TIPO
		btNovoTipo = new JButton("");
		btNovoTipo.setBounds(220, 85, 25, 25);
		btNovoTipo.addActionListener(this); // this = Janela que eh a ouvidora
		panelEvento.add(btNovoTipo);

		// LABEL E TF CONVIDADOS
		lbNumConvidados = new JLabel("N° de convidados: *");
		lbNumConvidados.setBounds(15, 115, 135, 25);
		panelEvento.add(lbNumConvidados);

		tfNumConvidados = new JTextField();
		tfNumConvidados.setBounds(15, 135, 200, 25);
		panelEvento.add(tfNumConvidados);

		// LABEL E TF DATA
		lbData = new JLabel("Data nascimento: *");
		lbData.setBounds(270, 15, 135, 25);
		panelEvento.add(lbData);

		try {
			MaskFormatter mascara = new MaskFormatter("##/##/####");
			tfData = new JFormattedTextField(mascara);
			tfData.setBounds(270, 35, 135, 25);
			panelEvento.add(tfData);
		} catch (ParseException e) {
		}

		// LABEL E TF HORARIO
		lbHorario = new JLabel("Horario: *");
		lbHorario.setBounds(270, 65, 135, 25);
		panelEvento.add(lbHorario);

		try {
			MaskFormatter mascara = new MaskFormatter("##:##");
			tfHorario = new JFormattedTextField(mascara);
			tfHorario.setBounds(270, 85, 135, 25);
			panelEvento.add(tfHorario);
		} catch (ParseException e) {
		}

		// LABEL E TF DURACAO
		lbDuracao = new JLabel("Duracao: *");
		lbDuracao.setBounds(270, 115, 135, 25);
		panelEvento.add(lbDuracao);

		try {
			MaskFormatter mascara = new MaskFormatter("##:##");
			tfDuracao = new JFormattedTextField(mascara);
			tfDuracao.setBounds(270, 135, 135, 25);
			panelEvento.add(tfDuracao);
		} catch (ParseException e) {
		}

		// PREENCHIMENTO ONRUGATORIO
		lbObrigatorio = new JLabel("* Campos de preenchimento obrigatorio.");
		lbObrigatorio.setBounds(195, 225, 270, 25);
		panel.add(lbObrigatorio);

		// SUBPANEL
		JPanel panelPagamento = new JPanel();
		TitledBorder tb2 = BorderFactory.createTitledBorder("Dados do pagamento");
		tb2.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		panelPagamento.setBorder(tb2);
		panelPagamento.setBounds(10, 255, 420, 130);
		panelPagamento.setLayout(null);
		panel.add(panelPagamento);

		// LABEL E TF FORMA PAGTO
		lbFormaPagto = new JLabel("Forma de pagamento: *");
		lbFormaPagto.setBounds(15, 15, 305, 25);
		panelPagamento.add(lbFormaPagto);

		cbFormaPagto = new JComboBox<String>();
		// add items to the combo box
		cbFormaPagto.addItem("English");
		cbFormaPagto.addItem("French");
		cbFormaPagto.addItem("Spanish");
		cbFormaPagto.addItem("Japanese");
		cbFormaPagto.addItem("Chinese");
		cbFormaPagto.setBounds(15, 35, 180, 25);
		panelPagamento.add(cbFormaPagto);

		// LABEL E TF Qtd de parcelas
		lbQtdParcelas = new JLabel("Qtd de parcelas: ");
		lbQtdParcelas.setBounds(15, 65, 305, 25);
		panelPagamento.add(lbQtdParcelas);

		cbQtdParcelas = new JComboBox<String>();
		// add items to the combo box
		cbQtdParcelas.addItem("English");
		cbQtdParcelas.addItem("French");
		cbQtdParcelas.addItem("Spanish");
		cbQtdParcelas.addItem("Japanese");
		cbQtdParcelas.addItem("Chinese");
		cbQtdParcelas.setBounds(15, 85, 180, 25);
		panelPagamento.add(cbQtdParcelas);

		// LABEL E TF TIPO PAGTO
		lbTipoPagto = new JLabel("Tipo de pagamento: *");
		lbTipoPagto.setBounds(225, 15, 135, 25);
		panelPagamento.add(lbTipoPagto);

		cbTipoPagto = new JComboBox<String>();
		// add items to the combo box
		cbTipoPagto.addItem("English");
		cbTipoPagto.addItem("French");
		cbTipoPagto.addItem("Spanish");
		cbTipoPagto.addItem("Japanese");
		cbTipoPagto.addItem("Chinese");
		cbTipoPagto.setBounds(225, 35, 180, 25);
		panelPagamento.add(cbTipoPagto);

		// PREENCHIMENTO ONRUGATORIO
		lbObrigatorio = new JLabel("* Campos de preenchimento obrigatorio.");
		lbObrigatorio.setBounds(195, 380, 270, 25);
		panel.add(lbObrigatorio);

		// BOTAO SALVAR
		btSalvar = new JButton("Salvar");
		btSalvar.setBounds(350, 415, 80, 25);
		btSalvar.addActionListener(this); // this = Janela que eh a ouvidora
		panel.add(btSalvar);

		setVisible(true);
	}

	public static void main(String[] args) {
		JanelaEvento j = new JanelaEvento();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
