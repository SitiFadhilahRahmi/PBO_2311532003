package table;

import javax.swing.table.AbstractTableModel;
import model.Customer;
import java.util.*;

public class TableCustomer extends AbstractTableModel {
	List<Customer> ls;
	private String[] columNames = {"ID", "Nama", "Email", "Alamat","Hp"};
	public TableCustomer(List<Customer> ls) {
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
			return ls.get(rowIndex).getNama();
		case 2:
			return ls.get(rowIndex).getEmail();
		case 3:
			return ls.get(rowIndex).getAlamat();
		case 4:
			return ls.get(rowIndex).getHp();
		default:
			return null;
		}
	}
	
	
    @Override
    public String getColumnName(int column) {
        return columNames[column];
    }
	
	
	

}
