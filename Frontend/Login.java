package courseMngmtSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;

import frontend.AdminDashboard;

import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.SpringLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Cursor;

public class Login {

	public JFrame getFrmLogin() {
		return fromLogin;
	}

	private JFrame fromLogin;
	private JTextField enteredUsername;
	private JPasswordField passwordField;
	private JComboBox comboBox;
	private JLabel usernameFieldCantBeEmpty;
	private JLabel passwordFieldCantBeEmpty;
	private static String username;

	public static String getUsername() {
		return username;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.fromLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		fromLogin = new JFrame();
		fromLogin.setResizable(false);
		fromLogin.setTitle("Login | Course Management System");
		fromLogin.getContentPane().setBackground(new Color(255, 255, 255));

		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(0);
		fromLogin.getContentPane().add(splitPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		splitPane.setRightComponent(panel);

		enteredUsername = new JTextField();
		enteredUsername.setSelectedTextColor(new Color(255, 255, 255));
		enteredUsername.setSelectionColor(new Color(128, 128, 255));
		enteredUsername.setForeground(new Color(104, 104, 104));
		enteredUsername.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 255),
				new Color(128, 128, 255), new Color(255, 255, 255), new Color(255, 255, 255)));
		enteredUsername.setCaretColor(new Color(128, 128, 255));
		enteredUsername.setFont(new Font("Poppins", Font.PLAIN, 16));
		enteredUsername.setColumns(10);

		comboBox = new JComboBox();
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1) {

				}
			}
		});
		comboBox.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 255), new Color(128, 128, 255),
				new Color(255, 255, 255), new Color(255, 255, 255)));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Poppins", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Select User", "Admin", "Teacher", "Student" }));

		JButton btnNewButton = new JButton("Login");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(128, 128, 255));
		btnNewButton.setBorder(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usernameFieldCantBeEmpty.setVisible(false);
				passwordFieldCantBeEmpty.setVisible(false);
				String username = enteredUsername.getText().trim();
				String password = String.valueOf(passwordField.getPassword());
				String userType = comboBox.getSelectedItem().toString();
				if (username.isEmpty()) {
					usernameFieldCantBeEmpty.setVisible(true);
				} else if (password.isEmpty()) {
					passwordFieldCantBeEmpty.setVisible(true);
				} else if (username.equals("admin") && password.equals("admin") && userType.equals("Admin")) {
					fromLogin.dispose();
					AdminPanel window = new AdminPanel();
					window.getFrmAdminPanel().setVisible(true);
				} else if (enteredUsername.getText().equals("student") && password.equals("student")
						&& userType.equals("Student")) {
					fromLogin.dispose();
					StudentPanel window = new StudentPanel(enteredUsername.getText());
					window.getFrmStudentPanel().setVisible(true);
				} else if (enteredUsername.getText().equals("teacher") && password.equals("teacher")
						&& userType.equals("Teacher")) {
					fromLogin.dispose();
					TeacherPanel window = new TeacherPanel(enteredUsername.getText());
					window.getFrmTeacherPanel().setVisible(true);
				} else {
					if (userType.equals("Student")) {
						String checkQuery = "SELECT * FROM `userdetails` " + "WHERE username = '" + username + "' "
								+ "AND password = '" + password + "' " + "AND usertype='Student' ";
						Statement statement = DatabaseConnection.getStatement();
						try {
							ResultSet resultSet = statement.executeQuery(checkQuery);
							if (resultSet.next()) {
								StudentPanel studentPanel = new StudentPanel(enteredUsername.getText());
								studentPanel.getFrmStudentPanel().setVisible(true);
								fromLogin.setVisible(false);
							} else {
								JOptionPane.showMessageDialog(fromLogin, "Incorrect Username, Password or User Type.");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else if (userType.equals("Teacher")) {
						String checkQuery = "SELECT * FROM `userdetails` " + "WHERE username = '" + username + "' "
								+ "AND password = '" + password + "' " + "AND usertype='Teacher' ";
						Statement statement = DatabaseConnection.getStatement();
						try {
							ResultSet resultSet = statement.executeQuery(checkQuery);
							if (resultSet.next()) {
								TeacherPanel teacherPanel = new TeacherPanel(enteredUsername.getText());
								teacherPanel.getFrmTeacherPanel().setVisible(true);
								fromLogin.setVisible(false);
							} else {
								JOptionPane.showMessageDialog(fromLogin, "Incorrect Username, Password or User Type.");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Poppins", Font.BOLD, 18));

		passwordField = new JPasswordField();
		passwordField.setSelectionColor(new Color(128, 128, 255));
		passwordField.setSelectedTextColor(new Color(255, 255, 255));
		passwordField.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 255), new Color(128, 128, 255),
				new Color(255, 255, 255), new Color(255, 255, 255)));
		passwordField.setFont(new Font("Poppins", Font.PLAIN, 16));
		passwordField.setEchoChar('*');
		passwordField.setCaretColor(new Color(128, 128, 255));

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 18));

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Poppins", Font.BOLD, 18));

		JLabel lblUserType = new JLabel("User Type");
		lblUserType.setFont(new Font("Poppins", Font.BOLD, 18));

		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setFont(new Font("Poppins", Font.BOLD, 28));

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/images/user.png")));

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Login.class.getResource("/images/password.png")));

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Login.class.getResource("/images/users.png")));

		JLabel lblNewLabel_6 = new JLabel("Don't have an account? ");
		lblNewLabel_6.setFont(new Font("Poppins", Font.BOLD, 12));

		JButton btnNewButton_1 = new JButton("Sign Up");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp signup = new SignUp();
				signup.getSignupPanel().setVisible(true);
				fromLogin.dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(128, 128, 255));
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setFont(new Font("Poppins", Font.BOLD, 12));

		usernameFieldCantBeEmpty = new JLabel("Field can't be empty");
		usernameFieldCantBeEmpty.setVisible(false);
		usernameFieldCantBeEmpty.setForeground(new Color(255, 0, 0));
		usernameFieldCantBeEmpty.setFont(new Font("Poppins", Font.BOLD, 10));

		passwordFieldCantBeEmpty = new JLabel("Field can't be empty");
		passwordFieldCantBeEmpty.setVisible(false);
		passwordFieldCantBeEmpty.setForeground(Color.RED);
		passwordFieldCantBeEmpty.setFont(new Font("Poppins", Font.BOLD, 10));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(39)
				.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUserType, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordFieldCantBeEmpty, GroupLayout.PREFERRED_SIZE, 112,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup().addComponent(lblNewLabel_6)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnNewButton_1))
						.addComponent(enteredUsername, GroupLayout.PREFERRED_SIZE, 367, GroupLayout.PREFERRED_SIZE)
						.addComponent(usernameFieldCantBeEmpty, GroupLayout.PREFERRED_SIZE, 112,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(comboBox, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(passwordField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 365,
										Short.MAX_VALUE)))
				.addContainerGap(72, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(54)
				.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE).addGap(37)
				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_2)
						.addComponent(enteredUsername, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
				.addGap(10)
				.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup().addComponent(usernameFieldCantBeEmpty).addGap(18)
								.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addGap(3).addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 35,
										GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(passwordFieldCantBeEmpty, GroupLayout.PREFERRED_SIZE, 16,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lblUserType, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
								.addGap(36)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 27,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNewButton_1)))
						.addGroup(gl_panel.createSequentialGroup().addGap(47).addComponent(lblNewLabel_4,
								GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
				.addGap(13)));
		panel.setLayout(gl_panel);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Login.class.getResource("/images/reading.png")));
		splitPane.setLeftComponent(lblNewLabel_5);
		splitPane.setDividerLocation(370);
		fromLogin.setBounds(100, 100, 911, 651);
		fromLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
