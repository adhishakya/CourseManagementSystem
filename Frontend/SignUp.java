package courseMngmtSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SpringLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Cursor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class SignUp {

	private JFrame signupPanel;
	private JTextField usernameTextField;
	private JTextField uniIdTextField;
	private JPasswordField passwordField;
	private JPasswordField confirmPasswordField;
	private JLabel passwordsNotMatchingError;
	private JLabel usernameCantBeEmpty;
	private JLabel universityIdCantBeEmpty;
	private JLabel passwordCantBeEmpty;
	private String courseFromComboBox;

	public JFrame getSignupPanel() {
		return signupPanel;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp();
					window.signupPanel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		signupPanel = new JFrame();
		signupPanel.setTitle("Sign Up | Course Management System");
		signupPanel.setBounds(100, 50, 850, 738);
		signupPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		signupPanel.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(0);
		panel.add(splitPane, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SignUp.class.getResource("/images/signup.png")));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		splitPane.setLeftComponent(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		splitPane.setRightComponent(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);

		JLabel lblNewLabel_1 = new JLabel("Student Sign Up");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 33, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_1, 81, SpringLayout.WEST, panel_1);
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Poppins", Font.BOLD, 28));
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Username");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 35, SpringLayout.SOUTH, lblNewLabel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_2, -277, SpringLayout.EAST, panel_1);
		lblNewLabel_2.setFont(new Font("Poppins", Font.BOLD, 18));
		panel_1.add(lblNewLabel_2);

		usernameTextField = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, usernameTextField, 6, SpringLayout.SOUTH, lblNewLabel_2);
		sl_panel_1.putConstraint(SpringLayout.EAST, usernameTextField, -29, SpringLayout.EAST, panel_1);
		usernameTextField.setSelectionColor(new Color(128, 128, 255));
		usernameTextField.setSelectedTextColor(Color.WHITE);
		usernameTextField.setForeground(new Color(104, 104, 104));
		usernameTextField.setFont(new Font("Poppins", Font.PLAIN, 16));
		usernameTextField.setColumns(10);
		usernameTextField.setCaretColor(new Color(128, 128, 255));
		usernameTextField.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 255),

				new Color(128, 128, 255), new Color(255, 255, 255), new Color(255, 255, 255)));
		panel_1.add(usernameTextField);

		JLabel lblNewLabel_2_1 = new JLabel("");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1, 131, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_2_1, 46, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_2_1, -387, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, usernameTextField, 3, SpringLayout.EAST, lblNewLabel_2_1);
		lblNewLabel_2_1.setIcon(new ImageIcon(SignUp.class.getResource("/images/user.png")));
		panel_1.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("University Id");
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_2_2, -256, SpringLayout.EAST, panel_1);
		lblNewLabel_2_2.setFont(new Font("Poppins", Font.BOLD, 18));
		panel_1.add(lblNewLabel_2_2);

		uniIdTextField = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, uniIdTextField, 170, SpringLayout.SOUTH, lblNewLabel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, uniIdTextField, -29, SpringLayout.EAST, panel_1);
		uniIdTextField.setSelectionColor(new Color(128, 128, 255));
		uniIdTextField.setSelectedTextColor(Color.WHITE);
		uniIdTextField.setForeground(new Color(104, 104, 104));
		uniIdTextField.setFont(new Font("Poppins", Font.PLAIN, 16));
		uniIdTextField.setColumns(10);
		uniIdTextField.setCaretColor(new Color(128, 128, 255));
		uniIdTextField.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 255),

				new Color(128, 128, 255), new Color(255, 255, 255), new Color(255, 255, 255)));
		panel_1.add(uniIdTextField);

		JLabel lblNewLabel_2_2_1 = new JLabel("Password");
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_2_2_1, -284, SpringLayout.EAST, panel_1);
		lblNewLabel_2_2_1.setFont(new Font("Poppins", Font.BOLD, 18));
		panel_1.add(lblNewLabel_2_2_1);

		passwordField = new JPasswordField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, passwordField, 6, SpringLayout.SOUTH, lblNewLabel_2_2_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, passwordField, -29, SpringLayout.EAST, panel_1);
		passwordField.setSelectionColor(new Color(128, 128, 255));
		passwordField.setSelectedTextColor(Color.WHITE);
		passwordField.setFont(new Font("Poppins", Font.PLAIN, 16));
		passwordField.setEchoChar('*');
		passwordField.setCaretColor(new Color(128, 128, 255));
		passwordField.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 255), new Color(128, 128, 255),

				new Color(255, 255, 255), new Color(255, 255, 255)));
		panel_1.add(passwordField);

		JLabel lblNewLabel_2_1_1 = new JLabel("");
		sl_panel_1.putConstraint(SpringLayout.WEST, passwordField, 11, SpringLayout.EAST, lblNewLabel_2_1_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_2_2_1, 13, SpringLayout.EAST, lblNewLabel_2_1_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_2_1_1, 46, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_2_1_1, 0, SpringLayout.EAST, lblNewLabel_2_1);
		lblNewLabel_2_1_1.setIcon(new ImageIcon(SignUp.class.getResource("/images/password.png")));
		panel_1.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_2_1_1 = new JLabel("Confirm Password");
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_2_2_1_1, -204, SpringLayout.EAST, panel_1);
		lblNewLabel_2_2_1_1.setFont(new Font("Poppins", Font.BOLD, 18));
		panel_1.add(lblNewLabel_2_2_1_1);

		confirmPasswordField = new JPasswordField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, confirmPasswordField, 6, SpringLayout.SOUTH, lblNewLabel_2_2_1_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, confirmPasswordField, -29, SpringLayout.EAST, panel_1);
		confirmPasswordField.setSelectionColor(new Color(128, 128, 255));
		confirmPasswordField.setSelectedTextColor(Color.WHITE);
		confirmPasswordField.setFont(new Font("Poppins", Font.PLAIN, 16));
		confirmPasswordField.setEchoChar('*');
		confirmPasswordField.setCaretColor(new Color(128, 128, 255));
		confirmPasswordField
				.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 255), new Color(128, 128, 255),

						new Color(255, 255, 255), new Color(255, 255, 255)));
		panel_1.add(confirmPasswordField);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("");
		sl_panel_1.putConstraint(SpringLayout.WEST, confirmPasswordField, 11, SpringLayout.EAST, lblNewLabel_2_1_1_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_2_2_1_1, 13, SpringLayout.EAST, lblNewLabel_2_1_1_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_2_1_1, -43, SpringLayout.NORTH, lblNewLabel_2_1_1_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1_1_1, 12, SpringLayout.NORTH, lblNewLabel_2_2_1_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_2_1_1_1, 0, SpringLayout.WEST, lblNewLabel_2_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_2_1_1_1, -237, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_2_1_1_1, -387, SpringLayout.EAST, panel_1);
		lblNewLabel_2_1_1_1.setIcon(new ImageIcon(SignUp.class.getResource("/images/password.png")));
		panel_1.add(lblNewLabel_2_1_1_1);

		JButton btnSignUp = new JButton("Sign Up");
		sl_panel_1.putConstraint(SpringLayout.WEST, btnSignUp, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, btnSignUp, -69, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnSignUp, -28, SpringLayout.EAST, panel_1);
		
		btnSignUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setFont(new Font("Poppins", Font.BOLD, 18));
		btnSignUp.setBorder(null);
		btnSignUp.setBackground(new Color(128, 128, 255));
		panel_1.add(btnSignUp);

		JLabel lblNewLabel_6 = new JLabel("Already have an account? ");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 17, SpringLayout.SOUTH, btnSignUp);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_6, 81, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_6, -214, SpringLayout.EAST, panel_1);
		lblNewLabel_6.setFont(new Font("Poppins", Font.BOLD, 12));
		panel_1.add(lblNewLabel_6);

		JButton btnNewButton_1 = new JButton("Login");
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, lblNewLabel_6);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnNewButton_1, 6, SpringLayout.EAST, lblNewLabel_6);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnNewButton_1, -168, SpringLayout.EAST, panel_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login window = new Login();
				window.getFrmLogin().setVisible(true);
				signupPanel.dispose();
			}
		});
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setForeground(new Color(128, 128, 255));
		btnNewButton_1.setFont(new Font("Poppins", Font.BOLD, 12));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(Color.WHITE);
		panel_1.add(btnNewButton_1);

		JLabel lblNewLabel_2_1_2 = new JLabel("");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1_1, 51, SpringLayout.SOUTH, lblNewLabel_2_1_2);
		sl_panel_1.putConstraint(SpringLayout.WEST, uniIdTextField, 13, SpringLayout.EAST, lblNewLabel_2_1_2);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_2_1, -65, SpringLayout.NORTH, lblNewLabel_2_1_2);
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1_2, 161, SpringLayout.SOUTH, lblNewLabel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_2_1_2, 46, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_2_1_2, 0, SpringLayout.SOUTH, uniIdTextField);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_2_1_2, 0, SpringLayout.EAST, lblNewLabel_2_1);
		lblNewLabel_2_1_2.setIcon(new ImageIcon(SignUp.class.getResource("/images/mail.png")));
		panel_1.add(lblNewLabel_2_1_2);

		passwordsNotMatchingError = new JLabel("Passwords do not match");
		sl_panel_1.putConstraint(SpringLayout.WEST, passwordsNotMatchingError, 91, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, passwordsNotMatchingError, -211, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, passwordsNotMatchingError, -198, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, passwordsNotMatchingError, 6, SpringLayout.SOUTH, confirmPasswordField);
		passwordsNotMatchingError.setVisible(false);
		passwordsNotMatchingError.setForeground(new Color(255, 0, 0));
		passwordsNotMatchingError.setFont(new Font("Poppins", Font.BOLD, 12));
		panel_1.add(passwordsNotMatchingError);

		usernameCantBeEmpty = new JLabel("Field can't be empty");
		sl_panel_1.putConstraint(SpringLayout.NORTH, usernameCantBeEmpty, 6, SpringLayout.SOUTH, usernameTextField);
		sl_panel_1.putConstraint(SpringLayout.WEST, usernameCantBeEmpty, 0, SpringLayout.WEST, lblNewLabel_2);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, usernameCantBeEmpty, -506, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, usernameCantBeEmpty, -242, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_2_2, 19, SpringLayout.SOUTH, usernameCantBeEmpty);
		usernameCantBeEmpty.setVisible(false);
		usernameCantBeEmpty.setForeground(new Color(255, 0, 0));
		usernameCantBeEmpty.setFont(new Font("Poppins", Font.BOLD, 12));
		panel_1.add(usernameCantBeEmpty);

		universityIdCantBeEmpty = new JLabel("Field can't be empty");
		sl_panel_1.putConstraint(SpringLayout.NORTH, universityIdCantBeEmpty, 205, SpringLayout.SOUTH, lblNewLabel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, universityIdCantBeEmpty, 91, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, universityIdCantBeEmpty, -237, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, uniIdTextField, -6, SpringLayout.NORTH, universityIdCantBeEmpty);
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_2_2_1, 6, SpringLayout.SOUTH, universityIdCantBeEmpty);
		universityIdCantBeEmpty.setVisible(false);
		universityIdCantBeEmpty.setForeground(Color.RED);
		universityIdCantBeEmpty.setFont(new Font("Poppins", Font.BOLD, 12));
		panel_1.add(universityIdCantBeEmpty);

		passwordCantBeEmpty = new JLabel("Field can't be empty");
		sl_panel_1.putConstraint(SpringLayout.WEST, passwordCantBeEmpty, 91, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, passwordCantBeEmpty, -242, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_2_2_1_1, 6, SpringLayout.SOUTH, passwordCantBeEmpty);
		sl_panel_1.putConstraint(SpringLayout.NORTH, passwordCantBeEmpty, 6, SpringLayout.SOUTH, passwordField);
		passwordCantBeEmpty.setVisible(false);
		passwordCantBeEmpty.setForeground(Color.RED);
		passwordCantBeEmpty.setFont(new Font("Poppins", Font.BOLD, 12));
		panel_1.add(passwordCantBeEmpty);
		
		JLabel lblNewLabel_2_2_1_1_1 = new JLabel("Course");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_2_2_1_1_1, 7, SpringLayout.SOUTH, passwordsNotMatchingError);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_2_2_1_1_1, -308, SpringLayout.EAST, panel_1);
		lblNewLabel_2_2_1_1_1.setFont(new Font("Poppins", Font.BOLD, 18));
		panel_1.add(lblNewLabel_2_2_1_1_1);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("");
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnSignUp, 23, SpringLayout.SOUTH, lblNewLabel_2_1_2_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1_2_1, 66, SpringLayout.SOUTH, lblNewLabel_2_1_1_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_2_1_2_1, -142, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_2_1_2_1, 57, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_2_1_2_1, -2, SpringLayout.WEST, lblNewLabel_2_2_1_1_1);
		lblNewLabel_2_1_2_1.setIcon(new ImageIcon(SignUp.class.getResource("/images/courseee.png")));
		panel_1.add(lblNewLabel_2_1_2_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("");
		panel_1.add(lblNewLabel_2_1_1_1_1);
		
		JComboBox courseComboBox = new JComboBox();
		courseComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				courseFromComboBox = (String) e.getItem();
			}
		});
		
		sl_panel_1.putConstraint(SpringLayout.NORTH, courseComboBox, 6, SpringLayout.SOUTH, lblNewLabel_2_2_1_1_1);
		courseComboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Course"}));
		String fetchCoursesQuery = "SELECT courseName FROM `coursedetails`";
		String[] coursesArray = new String[5];
		int i = 0;
		try {
			Statement statement = DatabaseConnection.getStatement();
			ResultSet resultSet = statement.executeQuery(fetchCoursesQuery);

			while (resultSet.next()) {
				coursesArray[i] = resultSet.getString("CourseName");
				courseComboBox.addItem(coursesArray[i]);
				i++;
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		sl_panel_1.putConstraint(SpringLayout.WEST, courseComboBox, 2, SpringLayout.EAST, lblNewLabel_2_1_2_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, courseComboBox, 0, SpringLayout.SOUTH, lblNewLabel_2_1_2_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, courseComboBox, -39, SpringLayout.EAST, panel_1);
		courseComboBox.setFont(new Font("Poppins", Font.PLAIN, 16));
		courseComboBox.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 255), new Color(128, 128, 255),

						new Color(255, 255, 255), new Color(255, 255, 255)));
		courseComboBox.setBackground(Color.WHITE);
		panel_1.add(courseComboBox);
		splitPane.setDividerLocation(370);
		
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usernameCantBeEmpty.setVisible(false);
				universityIdCantBeEmpty.setVisible(false);
				passwordCantBeEmpty.setVisible(false);
				passwordsNotMatchingError.setVisible(false);
				String username = usernameTextField.getText().trim();
				String uniId = uniIdTextField.getText().trim();
				String password = String.valueOf(passwordField.getPassword());
				String confirmPassword = String.valueOf(confirmPasswordField.getPassword());
				if (username.isEmpty()) {
					usernameCantBeEmpty.setVisible(true);
				} else if (uniId.isEmpty()) {
					universityIdCantBeEmpty.setVisible(true);
				} else if (password.isEmpty()) {
					passwordCantBeEmpty.setVisible(true);

				} else if (!password.equals(confirmPassword)) {
					passwordsNotMatchingError.setVisible(true);
				} else {

					Statement statement = DatabaseConnection.getStatement();
					String insertQuery = "INSERT INTO `userdetails` (`username`, `uniId`, `password`, `usertype`)"
							+ " VALUES ('" + username + "', '" + uniId + "', '" + password + "', 'Student');";

					try {
						int insertSuccess = statement.executeUpdate(insertQuery);
						if (insertSuccess == 1) {
							JOptionPane.showMessageDialog(null, "Successfully Signed Up!");
							String insertStudentQuery = "INSERT INTO `studentdetails` "
							+ "(`Id`, `studentName`, `level`, `semester`, `studentgroup`, `studentAddress`,"
							+ " `studentCourse`, `studentAge`, `studentPhone`)"
							+ " VALUES ("+uniId+", '"+username+"', '4', '1',"
									+ " 'L4CG1', 'Nepal', '"+courseFromComboBox+"', '18',"
											+ " '9800000000');";
							statement.executeUpdate(insertStudentQuery);
							Login window = new Login();
							window.getFrmLogin().setVisible(true);
							signupPanel.dispose();
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
	}

}
