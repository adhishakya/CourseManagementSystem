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

public class Login {

	private JFrame frame;
	private JTextField enteredUsername;
	private JPasswordField passwordField;
	static String valueFromComboBox = "";
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setTitle("Login | Course Management System");
		frame.getContentPane().setBackground(new Color(255, 255, 255));

		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(0);
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		splitPane.setRightComponent(panel);

		enteredUsername = new JTextField();
		enteredUsername.setForeground(new Color(104, 104, 104));
		enteredUsername.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 255),
				new Color(128, 128, 255), new Color(255, 255, 255), new Color(255, 255, 255)));
		enteredUsername.setCaretColor(new Color(128, 128, 255));
		enteredUsername.setFont(new Font("Poppins", Font.PLAIN, 16));
		enteredUsername.setColumns(10);

		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1) {
					valueFromComboBox = (String) e.getItem();
				}
			}
		});
		comboBox.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 255), new Color(128, 128, 255),
				new Color(255, 255, 255), new Color(255, 255, 255)));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Poppins", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "", "Admin", "Teacher", "Student" }));

		JButton btnNewButton = new JButton("Login");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(128, 128, 255));
		btnNewButton.setBorder(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (enteredUsername.getText().equals("admin")
						&& Arrays.equals(passwordField.getPassword(), new char[] { 'a', 'd', 'm', 'i', 'n' })
						&& valueFromComboBox.equals("Admin")) {
					System.out.println("Logged in as admin successfully!");
					frame.dispose();
					AdminPanel window = new AdminPanel();
					window.getFrmAdminPanel().setVisible(true);
				}
			}
		});
		btnNewButton.setFont(new Font("Poppins", Font.BOLD, 18));

		passwordField = new JPasswordField();
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
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\shaky\\Downloads\\user-svgrepo-com (3).png"));

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\shaky\\Downloads\\key-svgrepo-com (2).png"));

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\shaky\\Downloads\\users (1).png"));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_panel.createSequentialGroup().addGap(37)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addComponent(enteredUsername, GroupLayout.PREFERRED_SIZE, 367,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUserType, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(comboBox, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(passwordField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 365,
												Short.MAX_VALUE)))
						.addContainerGap(74, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(60)
				.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE).addGap(47)
				.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(enteredUsername,
										GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_2))
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addGap(18)
								.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(lblUserType, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup().addGap(55).addComponent(lblNewLabel_3,
								GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
				.addGap(39).addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
				.addGap(54)));
		panel.setLayout(gl_panel);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(
				"D:\\College Stuffs\\Level 5\\Object-Oriented Design and Programming\\hello\\Images\\reading.png"));
		splitPane.setLeftComponent(lblNewLabel_5);
		splitPane.setDividerLocation(370);
		frame.setBounds(100, 100, 911, 598);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
