package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Pregled;

public class TableModelPrikaz extends AbstractTableModel{

	private List<Pregled> listaPregleda=null;
	private String[] naziviKolona= {"Datum", "Lekar", "Dijagnoza"};
	
	public TableModelPrikaz(List<Pregled> lista) {
		this.listaPregleda=lista;
	}
	
	@Override
	public int getRowCount() {
		return this.listaPregleda.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Pregled p=this.listaPregleda.get(rowIndex);
		switch(columnIndex) {
		case 0: return p.getDatum();
		case 1: return p.getLekar();
		case 2: return p.getDijagnoza();
		}
		return null;
	}
	
	public String getColumnName(int i) {
		return naziviKolona[i];
	}

}
