package table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Layanan;

public class TableLayanan extends AbstractTableModel {
	List<Layanan> ls;
	private String[] columNames = {"ID", "Jenis", "Satuan", "Status", "Harga"};
	public TableLayanan(List<Layanan> ls) {
		this.ls=ls;
}
	@Override
	public int getRowCount() {
		return ls.size();
	}
	@Override
	public int getColumnCount() {
		return 5;
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return ls.get(rowIndex).getId();
		case 1:
			return ls.get(rowIndex).getJenis();
		case 2:
			return ls.get(rowIndex).getSatuan();
		case 3:
			return ls.get(rowIndex).getStatus();
		case 4:
			return ls.get(rowIndex).getHarga();
		default:
			return null;
		}
	}
	@Override
    public String getColumnName(int column) {
        return columNames[column];
    }

}
