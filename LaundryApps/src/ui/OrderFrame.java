package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.OrderRepo;
import model.Order;
import table.TableOrder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class OrderFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblOrder;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderFrame frame = new OrderFrame();
					frame.setVisible(true);
					frame.loadTableOrder();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}

	OrderRepo repo_od = new OrderRepo();
	List<Order> ls_od;
	String order_id="";
	
	public void loadTableOrder() {
		ls_od=repo_od.show();TableOrder tu=new TableOrder(ls_od);
		tblOrder.setModel(tu);
		tblOrder.getTableHeader().setVisible(true);
	}
	
	public OrderFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Data Orderan");
		lblNewLabel.setBounds(10, 24, 116, 26);
		contentPane.add(lblNewLabel);
		
		JButton btnOrder = new JButton("Buat Orderan");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderDetailFrame odf=new OrderDetailFrame();
				odf.setVisible(true);
				odf.loadTableDetail();
				odf.loadTable();
			}
		});
		btnOrder.setBounds(10, 61, 97, 23);
		contentPane.add(btnOrder);
		
		JButton btnHapus = new JButton("Hapus");
		btnHapus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(order_id !="") {
					repo_od.delete(order_id);
				}else {
					JOptionPane.showMessageDialog(null, "Pilih data yang akan dihapus");
				}
			}
		});
		btnHapus.setBounds(219, 61, 97, 23);
		contentPane.add(btnHapus);
		
		JButton btnEditDetail = new JButton("Edit/Detail");
		btnEditDetail.setBounds(327, 61, 97, 23);
		contentPane.add(btnEditDetail);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 112, 414, 183);
		contentPane.add(scrollPane);
		
		tblOrder = new JTable();
		scrollPane.setViewportView(tblOrder);
	}
}
