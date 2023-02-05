package courseMngmtSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Cursor;
import javax.swing.border.MatteBorder;

public class TeacherPanel {
	
	private CardLayout cl_cardPanelTeacher = new CardLayout(0, 0);
	private CardLayout cl_cardPanelTopTeacher = new CardLayout(0, 0);

	public static JFrame getFrmTeacherPanel() {
		return fromTeacherPanel;
	}

	private static JFrame fromTeacherPanel;
	private JPanel cardPanelTeacher;
	private JPanel cardPanelTopTeacher;
	private String teacherNameFromLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherPanel window = new TeacherPanel("");
					window.fromTeacherPanel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TeacherPanel(String name) {
		initialize(name);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String name) {
		teacherNameFromLogin = name;
		fromTeacherPanel = new JFrame();
		fromTeacherPanel.setResizable(false);
		fromTeacherPanel.setTitle("Teacher Panel | Course Management System");
		fromTeacherPanel.setBounds(100, 100, 803, 525);
		fromTeacherPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(0);
		fromTeacherPanel.getContentPane().add(splitPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		splitPane.setLeftComponent(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JButton btnNewButton = new JButton("Dashboard");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cardPanelTeacher.show(cardPanelTeacher, "name_79330044922200");
				cl_cardPanelTopTeacher.show(cardPanelTopTeacher, "name_112385867187000");
			}
		});
		btnNewButton.setIcon(new ImageIcon(
				"D:\\College Stuffs\\Level 5\\Object-Oriented Design and Programming\\hello\\Images\\dashboard.png"));
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, 33, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton, 22, SpringLayout.WEST, panel);
		btnNewButton.setIconTextGap(16);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Poppins", Font.BOLD, 18));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(128, 128, 255));
		panel.add(btnNewButton);

		JButton btnNewButton_1_1 = new JButton("Student");
		btnNewButton_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cardPanelTeacher.show(cardPanelTeacher, "name_79342838523500");
				cl_cardPanelTopTeacher.show(cardPanelTopTeacher, "name_112387896874700");
			}
		});
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1_1, 29, SpringLayout.SOUTH, btnNewButton);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1_1, 22, SpringLayout.WEST, panel);
		btnNewButton_1_1.setIcon(new ImageIcon(
				"D:\\College Stuffs\\Level 5\\Object-Oriented Design and Programming\\hello\\Images\\student.png"));
		btnNewButton_1_1.setIconTextGap(15);
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Poppins", Font.BOLD, 18));
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.setBorder(null);
		btnNewButton_1_1.setBackground(new Color(128, 128, 255));
		panel.add(btnNewButton_1_1);

		JButton btnNewButton_1_1_2 = new JButton("Assignment");
		btnNewButton_1_1_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cardPanelTeacher.show(cardPanelTeacher, "name_79349991822800");
				cl_cardPanelTopTeacher.show(cardPanelTopTeacher, "name_112389746503700");
			}
		});
		btnNewButton_1_1_2.setIcon(new ImageIcon(TeacherPanel.class.getResource("/images/assignment.png")));
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1_1_2, 29, SpringLayout.SOUTH, btnNewButton_1_1);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1_1_2, 0, SpringLayout.WEST, btnNewButton);
		btnNewButton_1_1_2.setIconTextGap(12);
		btnNewButton_1_1_2.setForeground(Color.WHITE);
		btnNewButton_1_1_2.setFont(new Font("Poppins", Font.BOLD, 18));
		btnNewButton_1_1_2.setBorderPainted(false);
		btnNewButton_1_1_2.setBorder(null);
		btnNewButton_1_1_2.setBackground(new Color(128, 128, 255));
		panel.add(btnNewButton_1_1_2);

		JButton btnNewButton_1_1_1 = new JButton("Log Out");
		btnNewButton_1_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogoutPromptTeacher logoutPrompt = new LogoutPromptTeacher();
				logoutPrompt.setVisible(true);
			}
		});
		btnNewButton_1_1_1.setIcon(new ImageIcon(
				"D:\\College Stuffs\\Level 5\\Object-Oriented Design and Programming\\hello\\Images\\logout.png"));
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1_1_1, 0, SpringLayout.WEST, btnNewButton);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton_1_1_1, -22, SpringLayout.SOUTH, panel);
		btnNewButton_1_1_1.setIconTextGap(16);
		btnNewButton_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1.setFont(new Font("Poppins", Font.BOLD, 18));
		btnNewButton_1_1_1.setBorderPainted(false);
		btnNewButton_1_1_1.setBorder(null);
		btnNewButton_1_1_1.setBackground(new Color(128, 128, 255));
		panel.add(btnNewButton_1_1_1);

		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setDividerSize(3);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPane_1);

		cardPanelTopTeacher = new JPanel();
		cardPanelTopTeacher.setBackground(new Color(255, 255, 255));
		splitPane_1.setLeftComponent(cardPanelTopTeacher);
		cardPanelTopTeacher.setLayout(cl_cardPanelTopTeacher);
		
		JPanel dashboardCardPanelTeacherTop = new JPanel();
		dashboardCardPanelTeacherTop.setBackground(new Color(255, 255, 255));
		cardPanelTopTeacher.add(dashboardCardPanelTeacherTop, "name_112385867187000");
		SpringLayout sl_dashboardCardPanelTeacherTop = new SpringLayout();
		dashboardCardPanelTeacherTop.setLayout(sl_dashboardCardPanelTeacherTop);
		
		JLabel welcomeMessageTeacher = new JLabel();
		sl_dashboardCardPanelTeacherTop.putConstraint(SpringLayout.NORTH, welcomeMessageTeacher, 22, SpringLayout.NORTH, dashboardCardPanelTeacherTop);
		sl_dashboardCardPanelTeacherTop.putConstraint(SpringLayout.WEST, welcomeMessageTeacher, 22, SpringLayout.WEST, dashboardCardPanelTeacherTop);
		sl_dashboardCardPanelTeacherTop.putConstraint(SpringLayout.SOUTH, welcomeMessageTeacher, -25, SpringLayout.SOUTH, dashboardCardPanelTeacherTop);
		sl_dashboardCardPanelTeacherTop.putConstraint(SpringLayout.EAST, welcomeMessageTeacher, 374, SpringLayout.WEST, dashboardCardPanelTeacherTop);
		welcomeMessageTeacher.setText("Welcome back, "+teacherNameFromLogin);
		welcomeMessageTeacher.setFont(new Font("Poppins", Font.BOLD, 22));
		dashboardCardPanelTeacherTop.add(welcomeMessageTeacher);
		
		JPanel studentCardPanelTeacherTop = new JPanel();
		cardPanelTopTeacher.add(studentCardPanelTeacherTop, "name_112387896874700");
		SpringLayout sl_studentCardPanelTeacherTop = new SpringLayout();
		studentCardPanelTeacherTop.setLayout(sl_studentCardPanelTeacherTop);
		
		JLabel lblNewLabel = new JLabel("New label");
		sl_studentCardPanelTeacherTop.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, studentCardPanelTeacherTop);
		sl_studentCardPanelTeacherTop.putConstraint(SpringLayout.WEST, lblNewLabel, 22, SpringLayout.WEST, studentCardPanelTeacherTop);
		sl_studentCardPanelTeacherTop.putConstraint(SpringLayout.SOUTH, lblNewLabel, 45, SpringLayout.NORTH, studentCardPanelTeacherTop);
		sl_studentCardPanelTeacherTop.putConstraint(SpringLayout.EAST, lblNewLabel, 100, SpringLayout.WEST, studentCardPanelTeacherTop);
		studentCardPanelTeacherTop.add(lblNewLabel);
		
		JPanel assignmentCardPanelTeacherTop = new JPanel();
		cardPanelTopTeacher.add(assignmentCardPanelTeacherTop, "name_112389746503700");
		SpringLayout sl_assignmentCardPanelTeacherTop = new SpringLayout();
		assignmentCardPanelTeacherTop.setLayout(sl_assignmentCardPanelTeacherTop);
		
		JLabel lblNewLabel_1 = new JLabel("Modules");
		sl_assignmentCardPanelTeacherTop.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 27, SpringLayout.NORTH, assignmentCardPanelTeacherTop);
		sl_assignmentCardPanelTeacherTop.putConstraint(SpringLayout.WEST, lblNewLabel_1, 53, SpringLayout.WEST, assignmentCardPanelTeacherTop);
		sl_assignmentCardPanelTeacherTop.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 68, SpringLayout.NORTH, assignmentCardPanelTeacherTop);
		sl_assignmentCardPanelTeacherTop.putConstraint(SpringLayout.EAST, lblNewLabel_1, 174, SpringLayout.WEST, assignmentCardPanelTeacherTop);
		assignmentCardPanelTeacherTop.add(lblNewLabel_1);

		cardPanelTeacher = new JPanel();
		cardPanelTeacher.setBackground(new Color(255, 255, 255));
		splitPane_1.setRightComponent(cardPanelTeacher);
		cardPanelTeacher.setLayout(cl_cardPanelTeacher);

		JPanel dashboardCardPanelTeacher = new JPanel();
		dashboardCardPanelTeacher.setBackground(new Color(255, 255, 255));
		cardPanelTeacher.add(dashboardCardPanelTeacher, "name_79330044922200");
		SpringLayout sl_dashboardCardPanelTeacher = new SpringLayout();
		dashboardCardPanelTeacher.setLayout(sl_dashboardCardPanelTeacher);
		
		String teacherPhoneFromDB = "SELECT teacherPhoneNo FROM `teacherdetails` WHERE teacherName = '"+teacherNameFromLogin+"'";
		try {
			Statement statement = DatabaseConnection.getStatement();
			ResultSet resultSet = statement.executeQuery(teacherPhoneFromDB);

			while (resultSet.next()) {
				teacherPhoneFromDB = resultSet.getString("teacherPhoneNo");
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		String teacherModuleFromDB = "SELECT assignedModule FROM `teacherdetails` WHERE teacherName = '"+teacherNameFromLogin+"'";
		try {
			Statement statement = DatabaseConnection.getStatement();
			ResultSet resultSet = statement.executeQuery(teacherModuleFromDB);

			while (resultSet.next()) {
				teacherModuleFromDB = resultSet.getString("assignedModule");
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		JLabel studentCountDisplay = new JLabel("<html>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Name: "
				+ teacherNameFromLogin
				+ "<br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Phone Number: "
				+ teacherPhoneFromDB
				+ "<br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "Your Module: " + teacherModuleFromDB + "</html>\r\n\r\n\r\n");
		sl_dashboardCardPanelTeacher.putConstraint(SpringLayout.NORTH, studentCountDisplay, 83, SpringLayout.NORTH, dashboardCardPanelTeacher);
		sl_dashboardCardPanelTeacher.putConstraint(SpringLayout.WEST, studentCountDisplay, 31, SpringLayout.WEST, dashboardCardPanelTeacher);
		sl_dashboardCardPanelTeacher.putConstraint(SpringLayout.SOUTH, studentCountDisplay, 307, SpringLayout.NORTH, dashboardCardPanelTeacher);
		sl_dashboardCardPanelTeacher.putConstraint(SpringLayout.EAST, studentCountDisplay, -34, SpringLayout.EAST, dashboardCardPanelTeacher);
		studentCountDisplay.setFont(new Font("Poppins", Font.BOLD, 24));
		studentCountDisplay.setBorder(new MatteBorder(1, 1, 5, 5, (Color) new Color(128, 128, 255)));
		studentCountDisplay.setBackground(Color.WHITE);
		dashboardCardPanelTeacher.add(studentCountDisplay);
		
		JLabel yourDetails = new JLabel();
		sl_dashboardCardPanelTeacher.putConstraint(SpringLayout.WEST, yourDetails, 31, SpringLayout.WEST, dashboardCardPanelTeacher);
		sl_dashboardCardPanelTeacher.putConstraint(SpringLayout.SOUTH, yourDetails, -19, SpringLayout.NORTH, studentCountDisplay);
		yourDetails.setText("Your Details:");
		yourDetails.setFont(new Font("Poppins", Font.BOLD, 22));
		dashboardCardPanelTeacher.add(yourDetails);

		JPanel studentCardPanelTeacher = new JPanel();
		studentCardPanelTeacher.setBackground(new Color(192, 192, 192));
		cardPanelTeacher.add(studentCardPanelTeacher, "name_79342838523500");
		studentCardPanelTeacher.setLayout(new SpringLayout());

		JPanel assignmentCardPanelTeacher = new JPanel();
		assignmentCardPanelTeacher.setBackground(new Color(128, 64, 0));
		cardPanelTeacher.add(assignmentCardPanelTeacher, "name_79349991822800");
		assignmentCardPanelTeacher.setLayout(new SpringLayout());
		splitPane_1.setDividerLocation(100);
		splitPane.setDividerLocation(200);
	}

}
