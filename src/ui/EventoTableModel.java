package ui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import negocio.entity.Evento;

@SuppressWarnings("serial")
public class EventoTableModel extends AbstractTableModel {

	private List<Evento> linhas;
	private String[] colunas = new String[] {"ID", "NOME", "DATA", "TIPO", "CLIENTE", "PAGTO"};

	private final int ID = 0;
	private final int NOME = 1;
	private final int DATA = 2;
	private final int TIPO = 3;
	private final int CLIENTE = 4;
	private final int PAGTO = 5;

	public EventoTableModel(List<Evento> linhas) {
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
		Evento e = linhas.get(rowIndex);
		
		switch (columnIndex) {
		case ID:
			return e.getId();
		case NOME:
			return e.getNome();
		case DATA:
			return e.getData();
		case TIPO:
			return e.getTipoEvento().getNome();
		case CLIENTE:
			return e.getCliente().getNome();
		case PAGTO:
			int pgto = e.getFormaPagto();
			if(pgto == 1) {
				return "A vista";
			}else{
				return "Parcelado";
			}
			default:
				break;
		}
		return null;
	}
}
