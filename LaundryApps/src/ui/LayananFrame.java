package ui;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.LayananRepo;
import model.Layanan;
import table.TableLayanan;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;

public class LayananFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtJenis;
	private JTextField txtSatuan;
	private JComboBox cbStatus;
	private JTextField txtHarga;
	private JTable tableLayanan;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LayananFrame frame = new LayananFrame();
					frame.setVisible(true);
					frame.loadTable();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	LayananRepo cus = new LayananRepo();
	List<Layanan> lc;
	public String id;
	
	public void loadTable() {
	lc = cus.show();
	TableLayanan tc = new TableLayanan(lc);
	tableLayanan.setModel(tc);
	tableLayanan.getTableHeader().setVisible(true);
}

	public LayananFrame() {

		
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
		
		JLabel lblName = new JLabel("Jenis");
		lblName.setBounds(32, 47, 46, 14);
		panel.add(lblName);
		
		JLabel lblPhone = new JLabel("Satuan");
		lblPhone.setBounds(32, 75, 83, 14);
		panel.add(lblPhone);
		
		JLabel lblAddress = new JLabel("Harga");
		lblAddress.setBounds(32, 103, 83, 14);
		panel.add(lblAddress);
		
		txtJenis = new JTextField();
		txtJenis.setBounds(111, 44, 326, 20);
		panel.add(txtJenis);
		txtJenis.setColumns(10);
		
		txtSatuan = new JTextField();
		txtSatuan.setColumns(10);
		txtSatuan.setBounds(111, 72, 326, 20);
		panel.add(txtSatuan);
		
		txtHarga = new JTextField();
		txtHarga.setColumns(10);
		txtHarga.setBounds(111, 100, 326, 20);
		panel.add(txtHarga);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Layanan layanan = new Layanan();
				layanan.setJenis(txtJenis.getText());
				layanan.setSatuan(txtSatuan.getText());
				layanan.setStatus(cbStatus.getSelectedItem().toString());
				 try {
			            double harga = Double.parseDouble(txtHarga.getText());
			            layanan.setHarga(harga);
			        } catch (NumberFormatException ex) {
			            JOptionPane.showMessageDialog(null, "Input untuk harga tidak valid. "
			            		+ "Masukkan angka yang benar.");
			            return;
			        }
				cus.save(layanan);
				reset();
				loadTable();
			}
		});
		btnSave.setBounds(111, 167, 74, 23);
		panel.add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Layanan layanan = new Layanan();
				layanan.setJenis(txtJenis.getText());
				layanan.setSatuan(txtSatuan.getText());
				layanan.setStatus(cbStatus.getSelectedItem().toString());
				 try {
			            double harga = Double.parseDouble(txtHarga.getText());
			            layanan.setHarga(harga);
			        } catch (NumberFormatException ex) {
			            JOptionPane.showMessageDialog(null, "Input untuk harga tidak valid. "
			            		+ "Masukkan angka yang benar.");
			            return;
			        }
				layanan.setId(id);
				cus.update(layanan);
				reset();
				loadTable();
			}
		});
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
					}
			}
		});
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
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(32, 128, 83, 14);
		panel.add(lblStatus);
		
		cbStatus = new JComboBox();
		cbStatus.setModel(new DefaultComboBoxModel(new String[] {"Tersedia", "Tidak Tersedia"}));
		cbStatus.setBounds(111, 128, 173, 22);
		panel.add(cbStatus);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 223, 475, 208);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 455, 175);
		panel_1.add(scrollPane);
		
		tableLayanan = new JTable();
		tableLayanan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				id = tableLayanan.getValueAt(tableLayanan.getSelectedRow(),0).toString();
				txtJenis.setText(tableLayanan.getValueAt(tableLayanan.getSelectedRow(), 1).toString()); 
				txtSatuan.setText(tableLayanan.getValueAt(tableLayanan.getSelectedRow(),2).toString());
				cbStatus.setSelectedItem(tableLayanan.getValueAt(tableLayanan.getSelectedRow(), 3).toString());
				txtHarga.setText(tableLayanan.getValueAt(tableLayanan.getSelectedRow(),4).toString());
				
			}
		});
		scrollPane.setViewportView(tableLayanan);
		tableLayanan.setToolTipText("");
		tableLayanan.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Jenis", "Satuan", "Status", "Harga"
			}
		));
		
		
	}
	public void reset() {
		txtJenis.setText("");
		txtSatuan.setText("");
		cbStatus.setSelectedItem(0);
		txtHarga.setText("");}}

