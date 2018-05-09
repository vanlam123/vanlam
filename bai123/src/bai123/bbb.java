package bai123;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class bbb extends JFrame {

	private JPanel contentPane;
	private JTextField l1;
	private JTextField l2;
	private JTextField l3;
	
	private Socket socketClient;
	private DataInputStream dis;
	private DataOutputStream dos;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bbb frame = new bbb();
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
	public bbb() {
		setTitle("Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 354, 170);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstNumber = new JLabel("First Number");
		lblFirstNumber.setBounds(10, 11, 113, 14);
		contentPane.add(lblFirstNumber);
		
		JLabel lblSecondNumber = new JLabel("Second Number");
		lblSecondNumber.setBounds(10, 44, 113, 14);
		contentPane.add(lblSecondNumber);
		
		JLabel lblResultFromServer = new JLabel("Result From Server");
		lblResultFromServer.setBounds(10, 82, 113, 14);
		contentPane.add(lblResultFromServer);
		
		l1 = new JTextField();
		l1.setBounds(133, 8, 86, 20);
		contentPane.add(l1);
		l1.setColumns(10);
		
		l2 = new JTextField();
		l2.setBounds(133, 41, 86, 20);
		contentPane.add(l2);
		l2.setColumns(10);
		
		l3 = new JTextField();
		l3.setBounds(133, 79, 86, 20);
		contentPane.add(l3);
		l3.setColumns(10);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					socketClient = new Socket("localhost", 1234);
					JOptionPane.showMessageDialog(null, "Kết nối thành công");
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnConnect.setBounds(239, 7, 89, 23);
		contentPane.add(btnConnect);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String vt1 = l1.getText();
					String vt2 = l2.getText();
					int a = Integer.parseInt(vt1);
					int b = Integer.parseInt(vt2);
					int c = a+b;
					String result = String.valueOf(c);
					l3.setText(result);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Lỗi nhập vào sai định dạng, vui lòng nhập bằng số ");
				}
			}
		});
		btnSend.setBounds(239, 40, 89, 23);
		contentPane.add(btnSend);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(239, 78, 89, 23);
		contentPane.add(btnExit);
	}
}
