package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DASHBOARD");
		lblNewLabel.setForeground(new Color(32, 51, 117));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblNewLabel.setBounds(306, 11, 93, 31);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("PESANAN");
		btnNewButton.setBounds(217, 65, 124, 77);
		contentPane.add(btnNewButton);
		
		JButton btnLayanan = new JButton("LAYANAN");
		btnLayanan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					new LayananFrame().setVisible(true);
					dispose();
			}
		});
		btnLayanan.setBounds(366, 65, 124, 77);
		contentPane.add(btnLayanan);
		
		JButton btnPelanggan = new JButton("PELANGGAN");
		btnPelanggan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					new CustomerFrame().setVisible(true);
					dispose();
			}
		});
		btnPelanggan.setBounds(534, 65, 124, 77);
		contentPane.add(btnPelanggan);
		
		JButton btnPengguna = new JButton("PENGGUNA");
		btnPengguna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					new UserFrame().setVisible(true);
					dispose();
			}
		});
		btnPengguna.setBounds(121, 161, 124, 77);
		contentPane.add(btnPengguna);
		
		JButton btnLaporan = new JButton("LAPORAN");
		btnLaporan.setBounds(287, 161, 124, 77);
		contentPane.add(btnLaporan);
		
		JButton btnProfil = new JButton("PROFIL");
		btnProfil.setBounds(448, 161, 124, 77);
		contentPane.add(btnProfil);
		
		JButton btnNewButton_1 = new JButton("LOGOUT");
		btnNewButton_1.setBounds(114, 316, 472, 40);
		contentPane.add(btnNewButton_1);
		
		JButton btnCheckArray = new JButton("CHECK ARRAY");
		btnCheckArray.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CheckArray().setVisible(true);
				dispose();
			}
		});
		btnCheckArray.setBounds(46, 65, 124, 77);
		contentPane.add(btnCheckArray);
	}
}
