package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.CustomerRepo;
import listener.DataListener;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DialogPelanggan extends JDialog {
	private DataListener listener;
	CustomerRepo usr=new CustomerRepo();
	List<Customer>ls;
	public String id;

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tablePelanggan;
	
	public DialogPelanggan(DataListener listener) {
		this.listener = listener;
		setModal(true);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setSize(450,249);
		setLocationRelativeTo(null);
		setTitle("Data Pelanggan");
		getContentPane().setLayout(null);
		
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogPelanggan dialog = new DialogPelanggan();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogPelanggan() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPane.setBounds(10, 11, 414, 121);
		contentPanel.add(scrollPane);
		
		tablePelanggan = new JTable();
		tablePelanggan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listener.onDataReceived(tablePelanggan.getValueAt(tablePelanggan.getSelectedRow(), 0).toString(),tablePelanggan.getValueAt(tablePelanggan.getSelectedRow(), 1).toString() );
				getData();
				dispose();
			}
		});
		scrollPane.setViewportView(tablePelanggan);
		loadTable();
		tablePelanggan.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"ID", "Nama", "Alamat", "Hp"
			}
		));
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			public void loadTable() {
				ls=usr.show();
				TableCustomer tu = new TableCustomer(ls);
				tablePelanggan.setModel(tu);
				tablePelanggan.getTableHeader().setVisible(true);
			}
		}
	}
}
