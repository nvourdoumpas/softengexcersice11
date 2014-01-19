package Vourdoumpas_Samios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Employee extends JFrame {

	private JPanel contentPane;
	private JTextField order;
	private JTextField setcourier;
	boolean sented=false;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee frame = new Employee();
					frame.setVisible(false);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				try { 
					if (rs != null) rs.close(); } 
				catch (SQLException e) {
					e.printStackTrace(); }
					
					try { 
						if (stmt != null) stmt.close(); }
					catch (SQLException e) {
					e.printStackTrace(); }
					try { 
						if (conn != null) conn.close(); } 
					catch (SQLException e){
					e.printStackTrace(); }
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Employee() {
		setTitle("Welcome Employee!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 389, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0394\u03B9\u03AC\u03BB\u03B5\u03BE\u03B5 \u03A0\u03B1\u03C1\u03B1\u03B3\u03B3\u03B5\u03BB\u03AF\u03B1");
		lblNewLabel.setBounds(10, 102, 100, 20);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\u038C\u03C1\u03B9\u03C3\u03B5 \u039C\u03B5\u03C4\u03B1\u03C6\u03BF\u03C1\u03AD\u03B1");
		label.setBounds(10, 133, 100, 20);
		contentPane.add(label);
		
		order = new JTextField();
		order.setBounds(120, 102, 86, 20);
		contentPane.add(order);
		order.setColumns(10);
		
		setcourier = new JTextField();
		setcourier.setBounds(120, 133, 86, 20);
		contentPane.add(setcourier);
		setcourier.setColumns(10);
		
		//������� ��� ��������� ��� ��� ��������.
		JButton sent = new JButton("\u0391\u03C0\u03BF\u03C3\u03C4\u03BF\u03BB\u03AE");
		sent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				
				int o =Integer.parseInt(order.getText()) ;
				int c =Integer.parseInt(setcourier.getText()) ;
				
					
					try
					{
						
						
						Class.forName("com.mysql.jdbc.Driver").newInstance();
						String connectionUrl = "jdbc:mysql://localhost:3307/softeng";
						String connectionUser = "root";
						String connectionPassword = "softeng";
						conn = DriverManager.getConnection(connectionUrl, connectionUser,
						connectionPassword);
						stmt = conn.createStatement();
						rs = stmt.executeQuery("SELECT * FROM transfer;");
						
						
							String sql = "UPDATE transfer SET courrier='"+c+"' WHERE at='"+o+"'"; 
								stmt.executeUpdate(sql);
								stmt.close();
								System.out.println("Update Complete!");
								JOptionPane.showMessageDialog(null, "� �������� ����� �� ��������!", "��������� ����������!", JOptionPane.INFORMATION_MESSAGE);
								sented=false;//Junit test ��� ��� �������� ��� �����������

					}
					catch (Exception e2)
					{
					e2.printStackTrace();
					}
					finally
					{
						// ������������ �� resources (�� �� ��� JDBC)
						// ��� ������������ rs (Result Set)
						try { if (rs != null) rs.close(); } catch (SQLException e2) {
						e2.printStackTrace(); }
						// ������������ �� resources (�� �� ��� JDBC)
						// ��� ������������ stmt (Statement)
						try { if (stmt != null) stmt.close(); } catch (SQLException e2) {
						e2.printStackTrace(); }
						// ������������ �� resources (�� �� ��� JDBC)
						// ��� ������������ conn (Connection)
						try { if (conn != null) conn.close(); } catch (SQLException e2) {
						e2.printStackTrace(); }
					}
					
					
					
					
				
			}
		});
		sent.setBounds(10, 187, 89, 23);
		contentPane.add(sent);
		
		JButton clear = new JButton("\u039A\u03B1\u03B8\u03B1\u03C1\u03B9\u03C3\u03BC\u03CC\u03C2");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				order.setText("");
				setcourier.setText("");
			}
		});
		clear.setBounds(117, 187, 89, 23);
		contentPane.add(clear);
		
		
		//Exit Button
		JButton exit = new JButton("\u0388\u03BE\u03BF\u03B4\u03BF\u03C2");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		exit.setBounds(216, 187, 89, 23);
		contentPane.add(exit);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\nvour_000\\Desktop\\Transport-logo-7C41B3A7A0-seeklogo.com.gif"));
		label_1.setBounds(173, 11, 200, 63);
		contentPane.add(label_1);
	}
}
