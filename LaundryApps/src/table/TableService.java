package table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Customer;
import model.Service;
import model.User;

import java.util.*;

public class TableService extends AbstractTableModel {
	List<Service> lv;
	private String[] columNames = {"ID", "Jenis", "Satuan", "Status", "Harga"};
	public TableService(List<Service> lv) {
		this.lv=lv;
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lv.size();
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex) {
		case 0:
			return lv.get(rowIndex).getId();
		case 1:
			return lv.get(rowIndex).getJenis();
		case 2:
			return lv.get(rowIndex).getSatuan();
		case 3:
			return lv.get(rowIndex).getStatus();
		case 4:
			return lv.get(rowIndex).getHarga();
		default:
			return null;
		}
	}
	
	
    @Override
    public String getColumnName(int column) {
        return columNames[column];
    }
	
	
	

}
