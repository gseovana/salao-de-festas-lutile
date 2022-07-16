package ui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import negocio.entity.Cliente;

@SuppressWarnings("serial")
public class ClienteTableModel extends AbstractTableModel {

	private List<Cliente> linhas;
	private String[] colunas = new String[] {"ID", "NOME", "CPF", "NASC", "TELEFONE", "EMAIL"};

	private final int ID = 0;
	private final int NOME = 1;
	private final int CPF = 2;
	private final int NASC = 3;
	private final int TELEFONE = 4;
	private final int EMAIL = 5;

	public ClienteTableModel(List<Cliente> linhas) {
		this.linhas = linhas;

	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return colunas[columnIndex];
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return linhas.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Cliente c = linhas.get(rowIndex);
		
		switch (columnIndex) {
		case ID:
			return c.getId();
		case NOME:
			return c.getNome();
		case CPF:
			return c.getCpf();
		case NASC:
			return c.getDataNasc();
		case TELEFONE:
			return c.getTelefone();
		case EMAIL:
			return c.getEmail();
			default:
				break;
		}
		return null;
	}
}
