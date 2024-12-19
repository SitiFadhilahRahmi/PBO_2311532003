package ui;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import DAO.LayananRepo;
import DAO.OrderDetailRepo;
import model.Layanan;
import model.OrderDetail;
import table.TableLayanan;
import table.TableOrderDetail;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class OrderDetailFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableService;
	private JTable tableOrderDetail;
	private JTextField txtHarga;
	private JTextField txtJumlah;
	private JTextField txtTotal;
	private JTextField txtTrx;
	private JTextField txtTanggal;
	private JTextField txtTanggalPengambilan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderDetailFrame frame = new OrderDetailFrame();
					frame.setVisible(true);
					frame.loadTable();
					frame.loadTableDetail();;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	OrderDetailRepo repo_od = new OrderDetailRepo();
	List<OrderDetail> ls_od;
	public String id_order_detail;

	LayananRepo cus = new LayananRepo();
	List<Layanan> lc;
	public String id_service;
	public static String txt_pelanggan="";
	private JTextField txtPelanggan;
	
	public void loadTable() {
	lc = cus.show();
	TableLayanan tc = new TableLayanan(lc);
	tableService.setModel(tc);
	tableService.getTableHeader().setVisible(true);
}
	public void loadTableDetail() {
		ls_od = repo_od.show(id_order_detail);
		TableOrderDetail tu = new TableOrderDetail(ls_od);
		tableOrderDetail.setModel(tu);
		tableOrderDetail.getTableHeader().setVisible(true);
	}
	
	
	public OrderDetailFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(230, 26, 370, 127);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 350, 105);
		panel.add(scrollPane);
		
		tableService = new JTable();
		tableService.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				id_service = tableService.getValueAt(tableService.getSelectedRow(),0).toString();
				txtHarga.setText(tableService.getValueAt(tableService.getSelectedRow(),4).toString());
				if(!txtJumlah.getText().isEmpty()) {
					txtTotal.setText(""+total(txtJumlah.getText()));
				}
			}
		});
		scrollPane.setViewportView(tableService);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 210, 441);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Order ID");
		lblNewLabel_1_1_1.setBounds(10, 11, 82, 14);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Pelanggan");
		lblNewLabel_1_1_2.setBounds(10, 56, 82, 14);
		panel_1.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Tanggal");
		lblNewLabel_1_1_3.setBounds(10, 106, 82, 14);
		panel_1.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Tanggal Pengambilan");
		lblNewLabel_1_1_4.setBounds(10, 159, 165, 14);
		panel_1.add(lblNewLabel_1_1_4);
		
		JLabel lblNewLabel_1_1_5 = new JLabel("Status");
		lblNewLabel_1_1_5.setBounds(10, 210, 82, 14);
		panel_1.add(lblNewLabel_1_1_5);
		
		JLabel lblNewLabel_1_1_6 = new JLabel("Total");
		lblNewLabel_1_1_6.setBounds(10, 259, 82, 14);
		panel_1.add(lblNewLabel_1_1_6);
		
		JLabel lblNewLabel_1_1_7 = new JLabel("Pembayaran");
		lblNewLabel_1_1_7.setBounds(10, 306, 82, 14);
		panel_1.add(lblNewLabel_1_1_7);
		
		JLabel lblNewLabel_1_1_8 = new JLabel("Status Pembayaran");
		lblNewLabel_1_1_8.setBounds(10, 353, 138, 14);
		panel_1.add(lblNewLabel_1_1_8);
		
		JButton btnSimpanOrder = new JButton("Simpan");
		btnSimpanOrder.setBounds(10, 407, 76, 23);
		panel_1.add(btnSimpanOrder);
		
		JButton btnBatalOrder = new JButton("Batal");
		btnBatalOrder.setBounds(109, 407, 76, 23);
		panel_1.add(btnBatalOrder);
		
		txtTrx = new JTextField();
		txtTrx.setBounds(6, 25, 194, 20);
		panel_1.add(txtTrx);
		txtTrx.setColumns(10);
		
		txtTanggal = new JTextField();
		txtTanggal.setColumns(10);
		txtTanggal.setBounds(6, 131, 194, 20);
		panel_1.add(txtTanggal);
		
		txtTanggalPengambilan = new JTextField();
		txtTanggalPengambilan.setColumns(10);
		txtTanggalPengambilan.setBounds(6, 179, 194, 20);
		panel_1.add(txtTanggalPengambilan);
		
		JComboBox cbStatus = new JComboBox();
		cbStatus.setModel(new DefaultComboBoxModel(new String[] {"Dipesan", "Diproses", "Siap Jemput", "Selesai"}));
		cbStatus.setBounds(6, 226, 194, 22);
		panel_1.add(cbStatus);
		
		JComboBox cbPembayaran = new JComboBox();
		cbPembayaran.setModel(new DefaultComboBoxModel(new String[] {"Cash", "Transfer", "QRIS"}));
		cbPembayaran.setBounds(6, 320, 194, 22);
		panel_1.add(cbPembayaran);
		
		JComboBox cbStatusPembayaran = new JComboBox();
		cbStatusPembayaran.setModel(new DefaultComboBoxModel(new String[] {"Belum Bayar", "Sudah Bayar"}));
		cbStatusPembayaran.setBounds(6, 366, 194, 22);
		panel_1.add(cbStatusPembayaran);
		
		JLabel txtTotalOrder = new JLabel("0,00");
		txtTotalOrder.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtTotalOrder.setBounds(10, 281, 46, 14);
		panel_1.add(txtTotalOrder);
		
		txtPelanggan = new JTextField();
		txtPelanggan.setColumns(10);
		txtPelanggan.setBounds(6, 75, 194, 20);
		panel_1.add(txtPelanggan);
		
		JLabel lblNewLabel = new JLabel("Layanan");
		lblNewLabel.setBounds(230, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(230, 163, 370, 127);
		contentPane.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Harga/Satuan");
		lblNewLabel_1.setBounds(10, 11, 82, 14);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Jumlah");
		lblNewLabel_1_1.setBounds(10, 54, 82, 14);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Total");
		lblNewLabel_1_2.setBounds(175, 54, 82, 14);
		panel_2.add(lblNewLabel_1_2);
		
		txtHarga = new JTextField();
		txtHarga.setBounds(6, 28, 153, 20);
		panel_2.add(txtHarga);
		txtHarga.setColumns(10);
		
		JButton btnSimpanDetail = new JButton("Simpan");
		btnSimpanDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id_order_detail == null){
					OrderDetail od = new OrderDetail();
					od.setOrder_id(txtTrx.getText());
					od.setService_id(id_service);
					od.setHarga(txtHarga.getText());
					od.setJumlah(txtJumlah.getText());
					od.setTotal(txtTotal.getText());
					repo_od.save(od);
					JOptionPane.showMessageDialog(null, "berhasil disimpan");
					loadTableDetail();
					reset();
					txtTotalOrder.setText(""+repo_od.total(txtTrx.getText()));
				}
			}
		});
		btnSimpanDetail.setBounds(10, 104, 76, 23);
		panel_2.add(btnSimpanDetail);
		
		JButton btnUbahDetail = new JButton("Ubah");
		btnUbahDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id_order_detail !=null) {
					OrderDetail od = new OrderDetail();
					od.setOrder_id(txtTrx.getText());
					od.setService_id(id_service);
					od.setHarga(txtHarga.getText());
					od.setJumlah(txtJumlah.getText());
					od.setTotal(txtTotal.getText());
					repo_od.save(od);
					JOptionPane.showMessageDialog(null, "berhasil disimpan");
					loadTableDetail();
					reset();
					txtTotalOrder.setText(""+repo_od.total(txtTrx.getText()));
				} else {
					JOptionPane.showMessageDialog(null, "Silahkan pilih order terlebih dahulu");
				}
			}
		});
		btnUbahDetail.setBounds(96, 104, 76, 23);
		panel_2.add(btnUbahDetail);
		
		JButton btnHapusDetail = new JButton("Hapus");
		btnHapusDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id_order_detail!=null) {
					repo_od.delete(id_order_detail);
					reset();
					loadTableDetail();
					txtTotalOrder.setText(""+repo_od.total(txtTrx.getText()));
				}else {
					JOptionPane.showMessageDialog(null, "Silahkan pilih data yang akan dihapus");
				}
			}
		});
		btnHapusDetail.setBounds(181, 104, 76, 23);
		panel_2.add(btnHapusDetail);
		
		txtJumlah = new JTextField();
		txtJumlah.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String value_jumlah = txtJumlah.getText().toString();
				txtTotal.setText(""+total(value_jumlah));
			}
		});
		txtJumlah.setColumns(10);
		txtJumlah.setBounds(6, 72, 153, 20);
		panel_2.add(txtJumlah);
		
		txtTotal = new JTextField();
		txtTotal.setColumns(10);
		txtTotal.setBounds(173, 72, 153, 20);
		panel_2.add(txtTotal);
		
		JButton btnBatalDetail = new JButton("Batal");
		btnBatalDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBatalDetail.setBounds(267, 104, 76, 23);
		panel_2.add(btnBatalDetail);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(230, 301, 420, 151);
		contentPane.add(panel_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 400, 129);
		panel_3.add(scrollPane_1);
		
		tableOrderDetail = new JTable();
		tableOrderDetail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				id_order_detail = tableOrderDetail.getValueAt(tableOrderDetail.getSelectedRow(), 0).toString();
				id_service = tableOrderDetail.getValueAt(tableOrderDetail.getSelectedRow(), 2).toString();
				txtHarga.setText(tableOrderDetail.getValueAt(tableOrderDetail.getSelectedRow(), 3).toString());
				txtTotal.setText(tableOrderDetail.getValueAt(tableOrderDetail.getSelectedRow(), 5).toString());
				txtJumlah.setText(tableOrderDetail.getValueAt(tableOrderDetail.getSelectedRow(), 4).toString());
			}
		});
		tableOrderDetail.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Order ID", "Service ID", "Harga", "Jumlah", "Total"
			}
		));
		scrollPane_1.setViewportView(tableOrderDetail);
		
		scrollPane.setViewportView(tableService);
		tableService.setToolTipText("");
		tableService.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Jenis", "Satuan", "Status", "Harga"
			}
		));
		

    }
	
	public double total(String jumlah) {
		double result=0;
		if(jumlah.isEmpty()) {
			result=0;
		}
		else {
			result = Double.parseDouble(jumlah)*Double.parseDouble(txtHarga.getText());
		}
		return result;
	}
	
	public void reset() {
		txtHarga.setText("");
		txtJumlah.setText("");
		txtTotal.setText("");
		id_service=null;
		id_order_detail=null;
	}


}
