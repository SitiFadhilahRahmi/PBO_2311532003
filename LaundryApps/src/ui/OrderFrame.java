package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class OrderFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderFrame frame = new OrderFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OrderFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DATA ORDERAN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 153, 39);
		contentPane.add(lblNewLabel);
		
		JButton btnOrder = new JButton("Buat Orderan");
		btnOrder.setBounds(10, 61, 115, 23);
		contentPane.add(btnOrder);
		
		JButton btnHapus = new JButton("Hapus");
		btnHapus.setBounds(289, 61, 115, 23);
		contentPane.add(btnHapus);
		
		JButton btnEditdetail = new JButton("Edit/Detail");
		btnEditdetail.setBounds(412, 61, 115, 23);
		contentPane.add(btnEditdetail);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 107, 517, 272);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
