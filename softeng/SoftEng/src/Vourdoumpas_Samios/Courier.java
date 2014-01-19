package Vourdoumpas_Samios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButtonMenuItem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Courier extends JFrame {

	private JPanel contentPane;
	private JTextField lastname;
	private JTextField firstname;
	private JTextField address;
	private JTextField state;
	private JTextField postcode;
	private JTextField value;
	private JTextField time;
	private JTextField order;
	boolean sented=false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Courier frame = new Courier();
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
	public Courier() {
		setTitle("Welcome Courier!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u039A\u03C9\u03B4\u03B9\u03BA\u03CC\u03C2 \u03A0\u03B1\u03C1\u03B1\u03B3\u03B3\u03B5\u03BB\u03AF\u03B1\u03C2");
		label.setBounds(60, 124, 110, 20);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("\u0395\u03C0\u03CE\u03BD\u03C5\u03BC\u03BF");
		lblNewLabel.setBounds(60, 155, 110, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1");
		lblNewLabel_1.setBounds(60, 186, 110, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel label_1 = new JLabel("\u0394\u03B9\u03B5\u03CD\u03B8\u03C5\u03BD\u03C3\u03B7");
		label_1.setBounds(60, 217, 110, 20);
		contentPane.add(label_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u03A0\u03CC\u03BB\u03B7");
		lblNewLabel_2.setBounds(60, 248, 110, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u03A4.\u039A.");
		lblNewLabel_3.setBounds(60, 279, 110, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("\u0391\u03BE\u03AF\u03B1");
		lblNewLabel_5.setBounds(60, 310, 110, 20);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u03A7\u03C1\u03CC\u03BD\u03BF\u03C2 \u03A0\u03B1\u03C1\u03AC\u03B4\u03BF\u03C3\u03B7\u03C2");
		lblNewLabel_6.setBounds(60, 341, 120, 20);
		contentPane.add(lblNewLabel_6);
		
		lastname = new JTextField();
		lastname.setEditable(false);
		lastname.setBounds(190, 155, 200, 20);
		contentPane.add(lastname);
		lastname.setColumns(10);
		
		firstname = new JTextField();
		firstname.setEditable(false);
		firstname.setBounds(190, 186, 200, 20);
		contentPane.add(firstname);
		firstname.setColumns(10);
		
		address = new JTextField();
		address.setEditable(false);
		address.setBounds(190, 217, 200, 20);
		contentPane.add(address);
		address.setColumns(10);
		
		state = new JTextField();
		state.setEditable(false);
		state.setBounds(190, 248, 200, 20);
		contentPane.add(state);
		state.setColumns(10);
		
		postcode = new JTextField();
		postcode.setEditable(false);
		postcode.setBounds(190, 279, 200, 20);
		contentPane.add(postcode);
		postcode.setColumns(10);
		
		value = new JTextField();
		value.setEditable(false);
		value.setBounds(190, 310, 200, 20);
		contentPane.add(value);
		value.setColumns(10);
		
		time = new JTextField();
		time.setBounds(190, 341, 200, 20);
		contentPane.add(time);
		time.setColumns(10);
		
		
		//Εμφάνιση της παραγγελίας
		JButton show = new JButton("\u0395\u03BC\u03C6\u03AC\u03BD\u03B9\u03C3\u03B7");
		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;

				String o = order.getText();
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
					
					
					
					while (rs.next()) {
						String dbo = rs.getString("at");
						String dbn = rs.getString("tname");
						String dbln = rs.getString("tlname");
						String dba = rs.getString("taddress");
						String dbs = rs.getString("tstate");
						String dbp = rs.getString("tpost");
						String dbv =rs.getString("tvalue") ;
	
	                
		                if (o.equals(dbo)) {
		                	firstname.setText(dbn);
		                	lastname.setText(dbln);
		                	address.setText(dba);
		                	state.setText(dbs);
		                	postcode.setText(dbp);
		                	value.setText(dbv);
		                	
						
						}
					}
			}catch (Exception e1)
			{
			e1.printStackTrace();
			}
			finally
			{
				// Απλευθερώνει τα resources (σε ΒΔ και JDBC)
				// του αντικειμένου rs (Result Set)
				try { if (rs != null) rs.close(); } catch (SQLException e1) {
				e1.printStackTrace(); }
				// Απλευθερώνει τα resources (σε ΒΔ και JDBC)
				// του αντικειμένου stmt (Statement)
				try { if (stmt != null) stmt.close(); } catch (SQLException e1) {
				e1.printStackTrace(); }
				// Απλευθερώνει τα resources (σε ΒΔ και JDBC)
				// του αντικειμένου conn (Connection)
				try { if (conn != null) conn.close(); } catch (SQLException e1) {
				e1.printStackTrace(); }
			}
			}
			
		});
		
		show.setBounds(35, 391, 100, 30);
		contentPane.add(show);
		
		
		//Αποστολή του χρόνου παράδοσης
		JButton sent = new JButton("\u0391\u03C0\u03BF\u03C3\u03C4\u03BF\u03BB\u03AE");
		sent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;

				int o =Integer.parseInt(order.getText()) ;
				int t =Integer.parseInt(time.getText()) ;
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

				
					String sql = "UPDATE transfer SET ttime='"+t+"' WHERE at='"+o+"'"; 
					stmt.executeUpdate(sql);
					stmt.close();
					System.out.println("Sent Complete!");
					JOptionPane.showMessageDialog(null, "Η αποστολή έγινε με επιτυχία!", "Επιτυχείς Καταχώρηση!", JOptionPane.INFORMATION_MESSAGE);
					sented=false;//Junit test για την αποστολή της παραγγελίας
					
					}
			catch (Exception e1)
			{
			e1.printStackTrace();
			}
			finally
			{
				// Απλευθερώνει τα resources (σε ΒΔ και JDBC)
				// του αντικειμένου rs (Result Set)
				try { if (rs != null) rs.close(); } catch (SQLException e1) {
				e1.printStackTrace(); }
				// Απλευθερώνει τα resources (σε ΒΔ και JDBC)
				// του αντικειμένου stmt (Statement)
				try { if (stmt != null) stmt.close(); } catch (SQLException e1) {
				e1.printStackTrace(); }
				// Απλευθερώνει τα resources (σε ΒΔ και JDBC)
				// του αντικειμένου conn (Connection)
				try { if (conn != null) conn.close(); } catch (SQLException e1) {
				e1.printStackTrace(); }
			}
				
			}
		});
		sent.setBounds(145, 391, 100, 30);
		contentPane.add(sent);
		
		
		//Καθαρισμός πεδίων
		JButton clear = new JButton("\u039A\u03B1\u03B8\u03B1\u03C1\u03B9\u03C3\u03BC\u03CC\u03C2");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order.setText("");
				firstname.setText("");
            	lastname.setText("");
            	address.setText("");
            	state.setText("");
            	postcode.setText("");
            	value.setText("");
            	time.setText("");
            	System.out.println("Clear Complete");
				
			}
		});
		clear.setBounds(255, 391, 100, 30);
		contentPane.add(clear);
		
		//Exit button
		JButton exit = new JButton("\u0388\u03BE\u03BF\u03B4\u03BF\u03C2");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exit.setBounds(365, 391, 100, 30);
		contentPane.add(exit);
		
		order = new JTextField();
		order.setBounds(190, 124, 200, 20);
		contentPane.add(order);
		order.setColumns(10);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\nvour_000\\Desktop\\Transport-logo-7C41B3A7A0-seeklogo.com.gif"));
		label_2.setBounds(314, 11, 200, 63);
		contentPane.add(label_2);
	}
}
