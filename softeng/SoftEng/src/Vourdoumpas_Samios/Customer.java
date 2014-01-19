package Vourdoumpas_Samios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;


public class Customer extends JFrame {

	private JPanel contentPane;
	private JTextField userc;
	private JPasswordField passc;
	private JTextField lastnamec;
	private JTextField firstnamec;
	private JTextField addressc;
	private JTextField statec;
	private JTextField postcodec;
	private JTextField lastname;
	private JTextField firstname;
	private JTextField address;
	private JTextField state;
	private JTextField postcode;
	private JTextField value;
	private JComboBox item;
	boolean sented=false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer frame = new Customer();
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
	public Customer() {
		setTitle("Welcome Transport Solutions");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 671);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//Button για δημιουργία του χρήστη!
		JButton create = new JButton("\u0394\u03B7\u03BC\u03B9\u03BF\u03C5\u03C1\u03B3\u03AF\u03B1");
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				
				
				if  (lastnamec.getText().length()==0 && firstnamec.getText().length()==0
							&& addressc.getText().length()==0 && statec.getText().length()==0 && postcodec.getText().length()==0){
					JOptionPane.showMessageDialog(null, "Παρακαλώ συμπληρώστε όλα τα στοιχεία σου για να κάνεις δημιουργία!", "Δοκιμάστε Ξανά!", JOptionPane.WARNING_MESSAGE);
					
				}

				else {
					
					try
					{
						String uc = userc.getText();
						String pc = passc.getText();
						String fc = firstnamec.getText();
						String lc = lastnamec.getText();
						String ac = addressc.getText();
						String sc = statec.getText();
						String poc = postcodec.getText();
						
						Class.forName("com.mysql.jdbc.Driver").newInstance();
						String connectionUrl = "jdbc:mysql://localhost:3307/softeng";
						String connectionUser = "root";
						String connectionPassword = "softeng";
						conn = DriverManager.getConnection(connectionUrl, connectionUser,
						connectionPassword);
						stmt = conn.createStatement();
						rs = stmt.executeQuery("SELECT * FROM customer;");
						
						System.out.println(uc+pc+fc+lc+ac+sc+poc);

								
						String sql = "INSERT INTO customer (cuser, cpass, cname, clname, caddress, cstate, cpost)" +
				                   "VALUES ('"+uc+"','"+pc+"','"+fc+"','"+lc+"','"+ac+"','"+sc+"','"+poc+"')";
						stmt.executeUpdate(sql);
						
						stmt.close();
						System.out.println("Registration Complete!");
						JOptionPane.showMessageDialog(null, "Ο χρήστης '"+uc+"' εγγράφηκε με επιτυχία!", "Επιτυχείς Εγγραφή!", JOptionPane.INFORMATION_MESSAGE);
						
						
					}
					catch (Exception e2)
					{
					e2.printStackTrace();
					}
					finally
					{
						// Απλευθερώνει τα resources (σε ΒΔ και JDBC)
						// του αντικειμένου rs (Result Set)
						try { if (rs != null) rs.close(); } catch (SQLException e2) {
						e2.printStackTrace(); }
						// Απλευθερώνει τα resources (σε ΒΔ και JDBC)
						// του αντικειμένου stmt (Statement)
						try { if (stmt != null) stmt.close(); } catch (SQLException e2) {
						e2.printStackTrace(); }
						// Απλευθερώνει τα resources (σε ΒΔ και JDBC)
						// του αντικειμένου conn (Connection)
						try { if (conn != null) conn.close(); } catch (SQLException e2) {
						e2.printStackTrace(); }
					}
					
					
					
					
				}
				
			}
		});
		create.setBounds(10, 98, 110, 23);
		contentPane.add(create);
		
		
		//Βutton για Log-in  του χρήστη!
		JButton login = new JButton("Log-in");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				Boolean login=false;
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					String connectionUrl = "jdbc:mysql://localhost:3307/softeng";
					String connectionUser = "root";
					String connectionPassword = "softeng";
					conn = DriverManager.getConnection(connectionUrl, connectionUser,
					connectionPassword);
					stmt = conn.createStatement();
					rs = stmt.executeQuery("SELECT * FROM customer;");
					
					
	
					while (rs.next()) {
						String dbUsername = rs.getString("cuser");
		                String dbPassword = rs.getString("cpass");
  
						if (dbUsername.equals(userc.getText()) && dbPassword.equals(passc.getText()) ) {
								login = true;
								System.out.println("Login Success!!");
								firstnamec.setText(rs.getString("cname"));
								lastnamec.setText(rs.getString("clname"));
								addressc.setText(rs.getString("caddress"));
								statec.setText(rs.getString("cstate"));
								postcodec.setText(rs.getString("cpost"));
								
								
						}
					}
						
						if (login.equals(false)) {
							JOptionPane.showMessageDialog(null, "Εσφαλμένος Όνομα Χρήση / Κωδικός", "Δοκιμάστε Ξανά!", JOptionPane.WARNING_MESSAGE);
							userc.setText("");
							passc.setText("");
							firstnamec.setText("");
							lastnamec.setText("");
							addressc.setText("");
							statec.setText("");
							postcodec.setText("");
						}
						
					
					
														
					
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
		login.setBounds(130, 98, 89, 23);
		contentPane.add(login);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 46, 85, 20);
		contentPane.add(lblUsername);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setBounds(10, 67, 85, 20);
		contentPane.add(lblNewLabel);
		
		userc = new JTextField();
		userc.setBounds(105, 46, 86, 20);
		contentPane.add(userc);
		userc.setColumns(10);
		
		passc = new JPasswordField();
		passc.setBounds(105, 67, 86, 20);
		contentPane.add(passc);
		passc.setColumns(10);
		
		lastnamec = new JTextField();
		lastnamec.setColumns(10);
		lastnamec.setBounds(153, 163, 200, 20);
		contentPane.add(lastnamec);
		
		JLabel label = new JLabel("\u0395\u03C0\u03CE\u03BD\u03C5\u03BC\u03BF");
		label.setBounds(10, 163, 110, 20);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1");
		label_1.setBounds(10, 194, 110, 20);
		contentPane.add(label_1);
		
		firstnamec = new JTextField();
		firstnamec.setColumns(10);
		firstnamec.setBounds(153, 194, 200, 20);
		contentPane.add(firstnamec);
		
		addressc = new JTextField();
		addressc.setColumns(10);
		addressc.setBounds(153, 225, 200, 20);
		contentPane.add(addressc);
		
		JLabel label_2 = new JLabel("\u0394\u03B9\u03B5\u03CD\u03B8\u03C5\u03BD\u03C3\u03B7");
		label_2.setBounds(10, 225, 110, 20);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u03A0\u03CC\u03BB\u03B7");
		label_3.setBounds(10, 256, 110, 20);
		contentPane.add(label_3);
		
		statec = new JTextField();
		statec.setColumns(10);
		statec.setBounds(153, 256, 200, 20);
		contentPane.add(statec);
		
		JLabel label_4 = new JLabel("\u03A4.\u039A.");
		label_4.setBounds(10, 287, 110, 20);
		contentPane.add(label_4);
		
		postcodec = new JTextField();
		postcodec.setColumns(10);
		postcodec.setBounds(153, 287, 200, 20);
		contentPane.add(postcodec);
		
		JLabel lblNewLabel_1 = new JLabel("\u039D\u03AD\u03B1 \u03A0\u03B1\u03C1\u03B1\u03B3\u03B3\u03B5\u03BB\u03AF\u03B1");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 331, 100, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel label_5 = new JLabel("\u03A4\u03CD\u03C0\u03BF\u03C2 \u0394\u03AD\u03BC\u03B1\u03C4\u03BF\u03C2");
		label_5.setBounds(10, 359, 110, 20);
		contentPane.add(label_5);
		
		JLabel label_7 = new JLabel("\u03A3\u03C4\u03BF\u03B9\u03C7\u03B5\u03AF\u03B1 \u03A0\u03B5\u03BB\u03AC\u03C4\u03B7");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_7.setBounds(10, 135, 100, 30);
		contentPane.add(label_7);
		
		lastname = new JTextField();
		lastname.setColumns(10);
		lastname.setBounds(153, 390, 200, 20);
		contentPane.add(lastname);
		
		JLabel label_6 = new JLabel("\u0395\u03C0\u03CE\u03BD\u03C5\u03BC\u03BF \u03A0\u03B1\u03C1\u03B1\u03BB\u03AE\u03C0\u03C4\u03B7");
		label_6.setBounds(10, 390, 133, 20);
		contentPane.add(label_6);
		
		JLabel label_8 = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1  \u03A0\u03B1\u03C1\u03B1\u03BB\u03AE\u03C0\u03C4\u03B7");
		label_8.setBounds(10, 421, 133, 20);
		contentPane.add(label_8);
		
		firstname = new JTextField();
		firstname.setColumns(10);
		firstname.setBounds(153, 421, 200, 20);
		contentPane.add(firstname);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(153, 452, 200, 20);
		contentPane.add(address);
		
		JLabel label_9 = new JLabel("\u0394\u03B9\u03B5\u03CD\u03B8\u03C5\u03BD\u03C3\u03B7 \u03A0\u03B1\u03C1\u03B1\u03BB\u03AE\u03C0\u03C4\u03B7");
		label_9.setBounds(10, 452, 133, 20);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("\u03A0\u03CC\u03BB\u03B7  \u03A0\u03B1\u03C1\u03B1\u03BB\u03AE\u03C0\u03C4\u03B7");
		label_10.setBounds(10, 483, 133, 20);
		contentPane.add(label_10);
		
		state = new JTextField();
		state.setColumns(10);
		state.setBounds(153, 483, 200, 20);
		contentPane.add(state);
		
		JLabel label_11 = new JLabel("\u03A4.\u039A.  \u03A0\u03B1\u03C1\u03B1\u03BB\u03AE\u03C0\u03C4\u03B7");
		label_11.setBounds(10, 514, 133, 20);
		contentPane.add(label_11);
		
		postcode = new JTextField();
		postcode.setColumns(10);
		postcode.setBounds(153, 514, 200, 20);
		contentPane.add(postcode);
		
		JLabel label_13 = new JLabel("\u0391\u03BE\u03AF\u03B1");
		label_13.setBounds(10, 560, 110, 20);
		contentPane.add(label_13);
		
		value = new JTextField();
		value.setEditable(false);
		value.setColumns(10);
		value.setBounds(153, 560, 200, 20);
		contentPane.add(value);
		
		final JComboBox jitem = new JComboBox();
		jitem.setMaximumRowCount(11);
		jitem.setModel(new DefaultComboBoxModel(new String[] {"Folder", "Item 2kg", "Item 4kg", "Item 6kg", "Item 8kg", "Item 10kg", "Item 12kg", "Item 14kg", "Item 16kg", "Item 18kg", "Item 20kg"}));
		jitem.setBounds(153, 359, 200, 20);
		contentPane.add(jitem);
		
		//Υπολογισμός της αξίας του πακέτου
		JButton calc = new JButton("\u03A5\u03C0\u03BF\u03BB\u03BF\u03B3\u03B9\u03C3\u03BC\u03CC\u03C2");
		calc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double val=0.0;
				int ch = jitem.getSelectedIndex();
				
				switch (ch) {
				case 0:
					val=2.0;
					value.setText(String.valueOf(val));
					break;
				case 1:
					val=3.0;
					value.setText(String.valueOf(val));
					break;
				case 2:
					val=3.2;
					value.setText(String.valueOf(val));
					break;
				case 3:
					val=3.4;
					value.setText(String.valueOf(val));
					break;
				case 4:
					val=3.6;
					value.setText(String.valueOf(val));
					break;
				case 5:
					val=3.8;
					value.setText(String.valueOf(val));
					break;
				case 6:
					val=4;
					value.setText(String.valueOf(val));
					break;
				case 7:
					val=4.2;
					value.setText(String.valueOf(val));
					break;
				case 8:
					val=4.4;
					value.setText(String.valueOf(val));
					break;
				case 9:
					val=4.6;
					value.setText(String.valueOf(val));
					break;
				case 10:
					val=4.8;
					value.setText(String.valueOf(val));
					break;
			    }
			    	
			    
			}
		});
		calc.setBounds(10, 591, 100, 30);
		contentPane.add(calc);
		
		//Αποστολή της νέας παραγγελίας
		JButton send = new JButton("\u0391\u03C0\u03BF\u03C3\u03C4\u03BF\u03BB\u03AE");
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				
				if(value.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Υπολογίστε πρώτα τα έξοδα της αποστολής!", "Error!", JOptionPane.ERROR_MESSAGE);
				}
				else if  (lastname.getText().length()==0 && firstname.getText().length()==0
							&& address.getText().length()==0 && state.getText().length()==0 && postcode.getText().length()==0){
					JOptionPane.showMessageDialog(null, "Παρακαλώ συμπληρώστε όλα τα στοιχεία του παραλήπτη!", "Δοκιμάστε Ξανά!", JOptionPane.WARNING_MESSAGE);
					
				}
				else if (lastnamec.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Πρέπει να κάνετε Log-in για να αποστείλετε την παραγγελίας σας!", "Error!", JOptionPane.ERROR_MESSAGE);
				}
				else {
					
					try
					{
						String f = firstname.getText();
						String l = lastname.getText();
						String a = address.getText();
						String s = state.getText();
						String p = postcode.getText();
						double val=Double.parseDouble(value.getText());
						
						Class.forName("com.mysql.jdbc.Driver").newInstance();
						String connectionUrl = "jdbc:mysql://localhost:3307/softeng";
						String connectionUser = "root";
						String connectionPassword = "softeng";
						conn = DriverManager.getConnection(connectionUrl, connectionUser,
						connectionPassword);
						stmt = conn.createStatement();
						rs = stmt.executeQuery("SELECT * FROM transfer;");
						
						System.out.println(f+l+a+s+p+val);
					
						
						String sql = "INSERT INTO transfer (tname, tlname, taddress, tstate, tpost, tvalue)" +
				                   "VALUES ('"+f+"','"+l+"','"+a+"','"+s+"','"+p+"',"+val+")";
						stmt.executeUpdate(sql);
						
						stmt.close();
						System.out.println("Registration Complete!");
						JOptionPane.showMessageDialog(null, "Η παραγγελία σας κατωχηρώθηκε με επιτυχία!", "Επιτυχείς Καταχώρηση!", JOptionPane.INFORMATION_MESSAGE);
						sented=false;//Junit test για την αποστολή της παραγγελίας
						
						
					}
					catch (Exception e2)
					{
					e2.printStackTrace();
					}
					finally
					{
						// Απλευθερώνει τα resources (σε ΒΔ και JDBC)
						// του αντικειμένου rs (Result Set)
						try { if (rs != null) rs.close(); } catch (SQLException e2) {
						e2.printStackTrace(); }
						// Απλευθερώνει τα resources (σε ΒΔ και JDBC)
						// του αντικειμένου stmt (Statement)
						try { if (stmt != null) stmt.close(); } catch (SQLException e2) {
						e2.printStackTrace(); }
						// Απλευθερώνει τα resources (σε ΒΔ και JDBC)
						// του αντικειμένου conn (Connection)
						try { if (conn != null) conn.close(); } catch (SQLException e2) {
						e2.printStackTrace(); }
					}
					
					
					
					
				}
			}
		});
		send.setBounds(120, 591, 100, 30);
		contentPane.add(send);
		
		
		//Button για καθαρισμό της φόρμας της παραγγελίας
		JButton clear = new JButton("\u039A\u03B1\u03B8\u03B1\u03C1\u03B9\u03C3\u03BC\u03CC\u03C2");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstname.setText("");
				lastname.setText("");
				address.setText("");
				state.setText("");
				postcode.setText("");
				value.setText("");
				System.out.println("Clear Complete!");
			}
		});
		clear.setBounds(230, 591, 100, 30);
		contentPane.add(clear);
		
		JButton exit = new JButton("\u0388\u03BE\u03BF\u03B4\u03BF\u03C2");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exit.setBounds(340, 591, 100, 30);
		contentPane.add(exit);
		
		//Button για Log-out!
		JButton logout = new JButton("Log-out");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userc.setText("");
				passc.setText("");
				firstnamec.setText("");
				lastnamec.setText("");
				addressc.setText("");
				statec.setText("");
				postcodec.setText("");
				System.out.println("Log out Success!");
			}
		});
		logout.setBounds(230, 98, 100, 23);
		contentPane.add(logout);
		
		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon("C:\\Users\\nvour_000\\Desktop\\Transport-logo-7C41B3A7A0-seeklogo.com.gif"));
		label_12.setBounds(315, 11, 200, 63);
		contentPane.add(label_12);
		
		
	}
}
