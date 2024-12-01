package ui;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CheckArray extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tfData;
    private JTextField tfCheck;
    private ArrayList<Integer> dataList;
    private JLabel lblDataKe;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CheckArray frame = new CheckArray();
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
    public CheckArray() {
        dataList = new ArrayList<>(); 
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 434, 283);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblInput = new JLabel("Masukkan Data");
        lblInput.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblInput.setBounds(26, 35, 99, 23);
        contentPane.add(lblInput);

        tfData = new JTextField();
        tfData.setBounds(52, 68, 227, 20);
        contentPane.add(tfData);
        tfData.setColumns(10);

        JButton btnSimpan = new JButton("Simpan");
        btnSimpan.setBounds(295, 67, 89, 23);
        contentPane.add(btnSimpan);

        JLabel lblData = new JLabel("Data:");
        lblData.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblData.setBounds(26, 103, 99, 23);
        contentPane.add(lblData);

        
        lblDataKe = new JLabel(""); 
        lblDataKe.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblDataKe.setBounds(79, 103, 300, 23); 
        contentPane.add(lblDataKe); 

        JLabel lblCheckArrayKe = new JLabel("Check Array ke-");
        lblCheckArrayKe.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblCheckArrayKe.setBounds(26, 146, 120, 23);
        contentPane.add(lblCheckArrayKe);

        tfCheck = new JTextField();
        tfCheck.setColumns(10);
        tfCheck.setBounds(135, 148, 144, 20);
        contentPane.add(tfCheck);

        JButton btnCheck = new JButton("Check");
        btnCheck.setBounds(295, 147, 89, 23);
        contentPane.add(btnCheck);
        
        JLabel lblHasil = new JLabel("");
        lblHasil.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblHasil.setBounds(26, 180, 300, 23);
        contentPane.add(lblHasil);

        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = tfData.getText();
                try {
                    String[] numberStrings = input.split(",");
                    for (String numStr : numberStrings) {
                        dataList.add(Integer.parseInt(numStr.trim()));
                    }
                    tfData.setText("");
                    updateLabel(lblDataKe);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                        CheckArray.this,
                        "Harap masukkan angka yang valid, dipisahkan dengan koma.",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        btnCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String indexInput = tfCheck.getText();
                try {
                    int index = Integer.parseInt(indexInput.trim());
                    if (index >= 0 && index < dataList.size()) {
                        lblHasil.setText("Hasil: Index ke-" + index + " adalah " + dataList.get(index));
                    } else {
                        lblHasil.setText("Error: Index di luar jangkauan!");
                    }
                } catch (NumberFormatException ex) {
                    lblHasil.setText("Error: Masukkan index yang valid.");
                }
            }
        });
    }

    private void updateLabel(JLabel lblDataKe) {
        StringBuilder dataText = new StringBuilder();
        for (int i = 0; i < dataList.size(); i++) {
            dataText.append(dataList.get(i));
            if (i < dataList.size() - 1) {
                dataText.append(", ");
            }
        }
        lblDataKe.setText(dataText.toString());
    }
}
