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
import java.awt.Window.Type;
import java.awt.Toolkit;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	public int frameset;
	private JPasswordField password;
	boolean login=false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
					Login frame = new Login();
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
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\\u039D\u03AF\u03BA\u03BF\u03C2\\Desktop\\transport-logo-vector-371143.jpg"));
		setType(Type.POPUP);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(80, 80, 60, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(80, 120, 60, 30);
		contentPane.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setFont(new Font("Arial", username.getFont().getStyle() | Font.ITALIC, username.getFont().getSize() + 1));
		username.setBounds(180, 80, 120, 30);
		contentPane.add(username);
		username.setColumns(10);
		
		JButton LoginButton = new JButton("Login");
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					String connectionUrl = "jdbc:mysql://localhost:3307/softeng";
					String connectionUser = "root";
					String connectionPassword = "softeng";
					conn = DriverManager.getConnection(connectionUrl, connectionUser,
					connectionPassword);
					stmt = conn.createStatement();
					rs = stmt.executeQuery("SELECT * FROM login;");
					
					
	
					while (rs.next()) {
						String dbUsername = rs.getString("username");
		                String dbPassword = rs.getString("password");
		                String dbaa = rs.getString("aa");
		                
						if (dbUsername.equals(username.getText()) && dbPassword.equals(password.getText()) ) {
								login = true;//Junit test ��� ����� login
								System.out.println("Login Success!!");
								
						
								if (Integer.parseInt(dbaa)<=50) {
									new Administrator().setVisible(true);
								}
								else if (Integer.parseInt(dbaa)>=51 && Integer.parseInt(dbaa)<=100) {
									new Employee().setVisible(true);
								}
								else {
									new Courier().setVisible(true);
								}
								
						}
					}
						
						if (login == false) {
							JOptionPane.showMessageDialog(null, "���������� ����� ������ / �������", "��������� ����!", JOptionPane.WARNING_MESSAGE);
							username.setText("");
							password.setText("");
						}
						
					
					
														
					
				}
				catch (Exception e)
				{
				e.printStackTrace();
				}
				finally
				{
					// ������������ �� resources (�� �� ��� JDBC)
					// ��� ������������ rs (Result Set)
					try { if (rs != null) rs.close(); } catch (SQLException e) {
					e.printStackTrace(); }
					// ������������ �� resources (�� �� ��� JDBC)
					// ��� ������������ stmt (Statement)
					try { if (stmt != null) stmt.close(); } catch (SQLException e) {
					e.printStackTrace(); }
					// ������������ �� resources (�� �� ��� JDBC)
					// ��� ������������ conn (Connection)
					try { if (conn != null) conn.close(); } catch (SQLException e) {
					e.printStackTrace(); }
				}
				
				
				
				
			}
		});
		
		
		
		LoginButton.setBounds(80, 190, 90, 30);
		contentPane.add(LoginButton);
		
		JButton ExitButton = new JButton("Exit");
		ExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		ExitButton.setBounds(200, 190, 90, 30);
		contentPane.add(ExitButton);
		
		password = new JPasswordField();
		password.setBounds(180, 120, 120, 30);
		contentPane.add(password);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\nvour_000\\Desktop\\Transport-logo-7C41B3A7A0-seeklogo.com.gif"));
		lblNewLabel_2.setBounds(223, 6, 200, 63);
		contentPane.add(lblNewLabel_2);
	}

	
}
