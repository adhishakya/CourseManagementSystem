package courseMngmtSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SpringLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUp {

	private JFrame signupPanel;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	

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
		signupPanel.setBounds(100, 50, 850, 710);
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
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 38, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_1, 81, SpringLayout.WEST, panel_1);
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Poppins", Font.BOLD, 28));
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel_1);
		lblNewLabel_2.setFont(new Font("Poppins", Font.BOLD, 18));
		panel_1.add(lblNewLabel_2);
		
		textField = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, textField, 170, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -15, SpringLayout.NORTH, textField);
		sl_panel_1.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, textField, -29, SpringLayout.EAST, panel_1);
		textField.setSelectionColor(new Color(128, 128, 255));
		textField.setSelectedTextColor(Color.WHITE);
		textField.setForeground(new Color(104, 104, 104));
		textField.setFont(new Font("Poppins", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setCaretColor(new Color(128, 128, 255));
		textField.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 255),

						new Color(128, 128, 255), new Color(255, 255, 255), new Color(255, 255, 255)));
		panel_1.add(textField);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1, -43, SpringLayout.SOUTH, textField);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_2_1, 46, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_2_1, 0, SpringLayout.SOUTH, textField);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_2_1, -3, SpringLayout.WEST, textField);
		lblNewLabel_2_1.setIcon(new ImageIcon(SignUp.class.getResource("/images/user.png")));
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Email");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_2_2, 27, SpringLayout.SOUTH, textField);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_2_2, 0, SpringLayout.WEST, lblNewLabel_1);
		lblNewLabel_2_2.setFont(new Font("Poppins", Font.BOLD, 18));
		panel_1.add(lblNewLabel_2_2);
		
		textField_1 = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, textField_1, 13, SpringLayout.SOUTH, lblNewLabel_2_2);
		sl_panel_1.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, textField);
		textField_1.setSelectionColor(new Color(128, 128, 255));
		textField_1.setSelectedTextColor(Color.WHITE);
		textField_1.setForeground(new Color(104, 104, 104));
		textField_1.setFont(new Font("Poppins", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setCaretColor(new Color(128, 128, 255));
		textField_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 255),


								new Color(128, 128, 255), new Color(255, 255, 255), new Color(255, 255, 255)));
		panel_1.add(textField_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Password");
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_2_2_1, 0, SpringLayout.EAST, lblNewLabel_2);
		lblNewLabel_2_2_1.setFont(new Font("Poppins", Font.BOLD, 18));
		panel_1.add(lblNewLabel_2_2_1);
		
		passwordField = new JPasswordField();
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_2_2_1, -15, SpringLayout.NORTH, passwordField);
		sl_panel_1.putConstraint(SpringLayout.NORTH, passwordField, 362, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, passwordField, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, passwordField, 0, SpringLayout.EAST, textField);
		passwordField.setSelectionColor(new Color(128, 128, 255));
		passwordField.setSelectedTextColor(Color.WHITE);
		passwordField.setFont(new Font("Poppins", Font.PLAIN, 16));
		passwordField.setEchoChar('*');
		passwordField.setCaretColor(new Color(128, 128, 255));
		passwordField.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 255), new Color(128, 128, 255),

						new Color(255, 255, 255), new Color(255, 255, 255)));
		panel_1.add(passwordField);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1_1, -14, SpringLayout.NORTH, passwordField);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_2_1_1, 46, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_2_1_1, 0, SpringLayout.SOUTH, passwordField);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_2_1_1, -3, SpringLayout.WEST, passwordField);
		lblNewLabel_2_1_1.setIcon(new ImageIcon(SignUp.class.getResource("/images/password.png")));
		panel_1.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Confirm Password");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_2_2_1_1, 19, SpringLayout.SOUTH, passwordField);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_2_2_1_1, 0, SpringLayout.WEST, lblNewLabel_1);
		lblNewLabel_2_2_1_1.setFont(new Font("Poppins", Font.BOLD, 18));
		panel_1.add(lblNewLabel_2_2_1_1);
		
		passwordField_1 = new JPasswordField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, passwordField_1, 13, SpringLayout.SOUTH, lblNewLabel_2_2_1_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, passwordField_1, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, passwordField_1, 0, SpringLayout.EAST, textField);
		passwordField_1.setSelectionColor(new Color(128, 128, 255));
		passwordField_1.setSelectedTextColor(Color.WHITE);
		passwordField_1.setFont(new Font("Poppins", Font.PLAIN, 16));
		passwordField_1.setEchoChar('*');
		passwordField_1.setCaretColor(new Color(128, 128, 255));
		passwordField_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 255), new Color(128, 128, 255),


								new Color(255, 255, 255), new Color(255, 255, 255)));
		panel_1.add(passwordField_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1_1_1, 32, SpringLayout.SOUTH, lblNewLabel_2_1_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_2_1_1_1, 0, SpringLayout.WEST, lblNewLabel_2_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_2_1_1_1, -143, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_2_1_1_1, 0, SpringLayout.EAST, lblNewLabel_2_1);
		lblNewLabel_2_1_1_1.setIcon(new ImageIcon(SignUp.class.getResource("/images/password.png")));
		panel_1.add(lblNewLabel_2_1_1_1);
		
		JButton btnSignUp = new JButton("Sign Up");
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnSignUp, 55, SpringLayout.SOUTH, passwordField_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnSignUp, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, btnSignUp, -81, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnSignUp, 1, SpringLayout.EAST, textField);
		btnSignUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setFont(new Font("Poppins", Font.BOLD, 18));
		btnSignUp.setBorder(null);
		btnSignUp.setBackground(new Color(128, 128, 255));
		panel_1.add(btnSignUp);
		
		JLabel lblNewLabel_6 = new JLabel("Already have an account? ");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 23, SpringLayout.SOUTH, btnSignUp);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_6, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_6, 0, SpringLayout.EAST, lblNewLabel_2_2_1_1);
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
		splitPane.setDividerLocation(370);
	}

}
