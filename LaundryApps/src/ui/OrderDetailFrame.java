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
import model.Layanan;
import table.TableLayanan;

import javax.swing.JTable;
import javax.swing.JLabel;
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

public class OrderDetailFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableService;
	private JTable table_1;
	private JTextField txtHarga;
	private JTextField txtJumlah;
	private JTextField txtTotal;
	private JTextField txtTrx;
	private JTextField txtTanggal;
	private JTextField txtTanggalPengembalian;

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
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	LayananRepo cus = new LayananRepo();
	List<Layanan> lc;
	public String id;
	private JTextField txtPelanggan;
	
	public void loadTable() {
	lc = cus.show();
	TableLayanan tc = new TableLayanan(lc);
	tableService.setModel(tc);
	tableService.getTableHeader().setVisible(true);
}
	public OrderDetailFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 502);
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
				id = tableService.getValueAt(tableService.getSelectedRow(),0).toString();
				txtHarga.setText(tableService.getValueAt(tableService.getSelectedRow(),4).toString());
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
		
		JButton btnSimpan = new JButton("Simpan");
		btnSimpan.setBounds(10, 407, 76, 23);
		panel_1.add(btnSimpan);
		
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
		
		txtTanggalPengembalian = new JTextField();
		txtTanggalPengembalian.setColumns(10);
		txtTanggalPengembalian.setBounds(6, 179, 194, 20);
		panel_1.add(txtTanggalPengembalian);
		
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
		
		JLabel lblNewLabel_2 = new JLabel("0,00");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 281, 46, 14);
		panel_1.add(lblNewLabel_2);
		
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
			}
		});
		btnSimpanDetail.setBounds(10, 104, 76, 23);
		panel_2.add(btnSimpanDetail);
		
		JButton btnUbah = new JButton("Ubah");
		btnUbah.setBounds(96, 104, 76, 23);
		panel_2.add(btnUbah);
		
		JButton btnHapus = new JButton("Hapus");
		btnHapus.setBounds(181, 104, 76, 23);
		panel_2.add(btnHapus);
		
		txtJumlah = new JTextField();
		txtJumlah.setColumns(10);
		txtJumlah.setBounds(6, 72, 153, 20);
		panel_2.add(txtJumlah);
		
		txtTotal = new JTextField();
		txtTotal.setColumns(10);
		txtTotal.setBounds(173, 72, 153, 20);
		panel_2.add(txtTotal);
		
		JButton btnBatal = new JButton("Batal");
		btnBatal.setBounds(267, 104, 76, 23);
		panel_2.add(btnBatal);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(230, 301, 370, 151);
		contentPane.add(panel_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 350, 129);
		panel_3.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Detail Order", "id_layanan", "jumlah", "total"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		scrollPane.setViewportView(tableService);
		tableService.setToolTipText("");
		tableService.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Jenis", "Satuan", "Status", "Harga"
			}
		));
		
		txtJumlah.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateTotal();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                updateTotal();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                updateTotal();
            }
        });
		txtHarga.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateTotal();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                updateTotal();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                updateTotal();
            }
        });
    }

    private void updateTotal() {
        try {
            
            double harga = Double.parseDouble(txtHarga.getText().isEmpty() ? "0" : txtHarga.getText());
            int jumlah = Integer.parseInt(txtJumlah.getText().isEmpty() ? "0" : txtJumlah.getText());  
            double total = harga * jumlah;
            txtTotal.setText(String.valueOf(total));
        } catch (NumberFormatException e) {
            txtTotal.setText("0");
        }
	}
}
