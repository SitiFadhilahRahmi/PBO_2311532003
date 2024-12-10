package ui;

import java.awt.EventQueue;
import model.CustomerBuilder;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.CustomerRepo;
import DAO.UserRepo;
import model.Customer;
import model.User;
import table.TableCustomer;
import table.TableUser;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomerFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtAddress;
	private JTable tableCustomers;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerFrame frame = new CustomerFrame();
					frame.setVisible(true);
					frame.loadTable();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	CustomerRepo cus = new CustomerRepo();
	List<Customer> lc;
	public String id;
	private JTextField txtHp;
	
	public void loadTable() {
	lc = cus.show();
	TableCustomer tc = new TableCustomer(lc);
	tableCustomers.setModel(tc);
	tableCustomers.getTableHeader().setVisible(true);
}

	public CustomerFrame() {

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 470);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 475, 201);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("Nama");
		lblName.setBounds(32, 47, 46, 14);
		panel.add(lblName);
		
		JLabel lblPhone = new JLabel("Email");
		lblPhone.setBounds(32, 75, 83, 14);
		panel.add(lblPhone);
		
		JLabel lblAddress = new JLabel("Alamat");
		lblAddress.setBounds(32, 103, 83, 14);
		panel.add(lblAddress);
		
		txtName = new JTextField();
		txtName.setBounds(111, 44, 326, 20);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(111, 72, 326, 20);
		panel.add(txtEmail);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(111, 100, 326, 20);
		panel.add(txtAddress);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer customer = new CustomerBuilder()
				.setNama(txtName.getText())
				.setEmail(txtEmail.getText())
				.setAlamat(txtAddress.getText())
				.setHp(txtHp.getText())
				.build();
				cus.save(customer);
				reset();
				loadTable();
			}
		});
		btnSave.setBounds(111, 167, 74, 23);
		panel.add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer customer = new CustomerBuilder()
				.setNama(txtName.getText())
				.setEmail(txtEmail.getText())
				.setAlamat(txtAddress.getText())
				.setHp(txtHp.getText())
				.setId(id)
				.build();
				cus.update(customer);
				reset();
				loadTable();
			}});
		btnUpdate.setBounds(195, 167, 74, 23);
		panel.add(btnUpdate);	
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id != null) {
					cus.delete(id);
					reset();
					loadTable();
					}else {
					JOptionPane.showMessageDialog(null, "Silahkan pilih data yang akan di hapus");
					}}});
		btnDelete.setBounds(279, 167, 74, 23);
		panel.add(btnDelete);
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnCancel.setBounds(363, 167, 74, 23);
		panel.add(btnCancel);
		
		JLabel lblPhone_1 = new JLabel("No. Hp");
		lblPhone_1.setBounds(32, 132, 83, 14);
		panel.add(lblPhone_1);
		
		txtHp = new JTextField();
		txtHp.setColumns(10);
		txtHp.setBounds(111, 128, 326, 20);
		panel.add(txtHp);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 223, 475, 208);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 455, 175);
		panel_1.add(scrollPane);
		
		tableCustomers = new JTable();
		tableCustomers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				id = tableCustomers.getValueAt(tableCustomers.getSelectedRow(),0).toString();
				txtName.setText(tableCustomers.getValueAt(tableCustomers.getSelectedRow(), 1).toString()); 
				txtEmail.setText(tableCustomers.getValueAt(tableCustomers.getSelectedRow(),2).toString()); 
				txtAddress.setText(tableCustomers.getValueAt(tableCustomers.getSelectedRow(),3).toString());
				txtHp.setText(tableCustomers.getValueAt(tableCustomers.getSelectedRow(), 4).toString());
				
			}
		});
		scrollPane.setViewportView(tableCustomers);
		tableCustomers.setToolTipText("");
		tableCustomers.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nama", "Email", "Alamat", "Hp"
			}
		));
		
		
	}
	public void reset() {
		txtName.setText("");
		txtEmail.setText("");
		txtAddress.setText("");
		txtHp.setText("");}	
}

