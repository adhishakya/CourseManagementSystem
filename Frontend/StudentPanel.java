package courseMngmtSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Cursor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class StudentPanel {

	private CardLayout cl_cardPanelStudent = new CardLayout(0, 0);
	private CardLayout cl_cardPanelStudentTop = new CardLayout(0, 0);
	static JLabel welcomeStudentMessage;
	JLabel studentModulesDisplay = new JLabel();

	public static JFrame getFrmStudentPanel() {
		return fromStudentPanel;
	}

	private static JFrame fromStudentPanel;
	private JPanel cardPanelStudent;
	private JPanel cardPanelStudentTop;

	private String studentNameFromDB;
	private JTable teacherAndModulesTable;

	private String moduleForAssignmentFromComboBox;
	JLabel lblNewLabel_2 = new JLabel();

	private static String moduleForMarksFromComboBox;
	JLabel marksLabel = new JLabel();

	JButton btnPickElective = new JButton("Pick Elective");
	JLabel chosenElectiveLabel = new JLabel();
	
	static JLabel percentLabel = new JLabel("Percent:");
	static JLabel statusLabel = new JLabel("Status:");
	
	private static int studentIdFromDBInt;

	private static DefaultTableModel teacherAndModulesDefaultTableModel = new DefaultTableModel(
			new Object[][] { { null, null }, { null, null }, { null, null }, }, new String[] { "Teacher", "Module" });	
	
	public static void getStudentNameFromLogin() {
		Login login = new Login();
		String studentNameFromLogin = login.getUsername();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentPanel window = new StudentPanel("");
					window.fromStudentPanel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentPanel(String name) {
		initialize(name);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String name) {
		studentNameFromDB = name;
		fromStudentPanel = new JFrame();
		fromStudentPanel.setResizable(false);
		fromStudentPanel.setTitle("Student Panel | Course Management System");
		fromStudentPanel.setBounds(100, 100, 849, 587);
		fromStudentPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(0);
		fromStudentPanel.getContentPane().add(splitPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		splitPane.setLeftComponent(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JButton btnNewButton = new JButton("Dashboard");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cardPanelStudent.show(cardPanelStudent, "name_78982683888600");
				cl_cardPanelStudentTop.show(cardPanelStudentTop, "name_110887659857400");
			}
		});
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, 33, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton, 22, SpringLayout.WEST, panel);
		btnNewButton.setIcon(new ImageIcon(StudentPanel.class.getResource("/images/dashboard.png")));
		btnNewButton.setIconTextGap(16);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Poppins", Font.BOLD, 18));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(128, 128, 255));
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Teachers");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cardPanelStudent.show(cardPanelStudent, "name_78985517477200");
				cl_cardPanelStudentTop.show(cardPanelStudentTop, "name_110889775858700");
			}
		});
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1, 29, SpringLayout.SOUTH, btnNewButton);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1, 0, SpringLayout.WEST, btnNewButton);
		btnNewButton_1.setIcon(new ImageIcon(StudentPanel.class.getResource("/images/teacher.png")));
		btnNewButton_1.setIconTextGap(15);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Poppins", Font.BOLD, 18));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(new Color(128, 128, 255));
		panel.add(btnNewButton_1);

		JButton btnNewButton_1_1_2 = new JButton("Modules");
		btnNewButton_1_1_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cardPanelStudent.show(cardPanelStudent, "name_78987815364700");
				cl_cardPanelStudentTop.show(cardPanelStudentTop, "name_110891736583900");
			}
		});
		btnNewButton_1_1_2.setIcon(new ImageIcon(StudentPanel.class.getResource("/images/books.png")));
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1_1_2, 30, SpringLayout.SOUTH, btnNewButton_1);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1_1_2, 0, SpringLayout.WEST, btnNewButton);
		btnNewButton_1_1_2.setIconTextGap(14);
		btnNewButton_1_1_2.setForeground(Color.WHITE);
		btnNewButton_1_1_2.setFont(new Font("Poppins", Font.BOLD, 18));
		btnNewButton_1_1_2.setBorderPainted(false);
		btnNewButton_1_1_2.setBorder(null);
		btnNewButton_1_1_2.setBackground(new Color(128, 128, 255));
		panel.add(btnNewButton_1_1_2);

		JButton btnNewButton_1_1_1 = new JButton("Log Out");
		btnNewButton_1_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1_1_1, 0, SpringLayout.WEST, btnNewButton);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton_1_1_1, -22, SpringLayout.SOUTH, panel);
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogoutPromptStudent logoutPrompt = new LogoutPromptStudent();
				logoutPrompt.setVisible(true);
			}
		});
		btnNewButton_1_1_1.setIcon(new ImageIcon(StudentPanel.class.getResource("/images/logout.png")));
		btnNewButton_1_1_1.setIconTextGap(16);
		btnNewButton_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1.setFont(new Font("Poppins", Font.BOLD, 18));
		btnNewButton_1_1_1.setBorderPainted(false);
		btnNewButton_1_1_1.setBorder(null);
		btnNewButton_1_1_1.setBackground(new Color(128, 128, 255));
		panel.add(btnNewButton_1_1_1);

		JButton btnNewButton_1_1_2_1 = new JButton("Assignment");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1_1_2_1, 28, SpringLayout.SOUTH, btnNewButton_1_1_2);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1_1_2_1, 0, SpringLayout.WEST, btnNewButton);
		btnNewButton_1_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cardPanelStudent.show(cardPanelStudent, "name_259197036500");
				cl_cardPanelStudentTop.show(cardPanelStudentTop, "name_287638290700");
			}
		});
		btnNewButton_1_1_2_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1_1_2_1.setIcon(new ImageIcon(StudentPanel.class.getResource("/images/assignment.png")));
		btnNewButton_1_1_2_1.setIconTextGap(12);
		btnNewButton_1_1_2_1.setForeground(Color.WHITE);
		btnNewButton_1_1_2_1.setFont(new Font("Poppins", Font.BOLD, 18));
		btnNewButton_1_1_2_1.setBorderPainted(false);
		btnNewButton_1_1_2_1.setBorder(null);
		btnNewButton_1_1_2_1.setBackground(new Color(128, 128, 255));
		panel.add(btnNewButton_1_1_2_1);

		JButton btnNewButton_1_1_2_2 = new JButton("Elective");

		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1_1_2_2, 0, SpringLayout.WEST, btnNewButton);
		btnNewButton_1_1_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cardPanelStudent.show(cardPanelStudent, "name_3401648832600");
				cl_cardPanelStudentTop.show(cardPanelStudentTop, "name_3405038275800");
			}
		});
		btnNewButton_1_1_2_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1_1_2_2.setIcon(new ImageIcon(StudentPanel.class.getResource("/images/books.png")));
		btnNewButton_1_1_2_2.setIconTextGap(14);
		btnNewButton_1_1_2_2.setForeground(Color.WHITE);
		btnNewButton_1_1_2_2.setFont(new Font("Poppins", Font.BOLD, 18));
		btnNewButton_1_1_2_2.setBorderPainted(false);
		btnNewButton_1_1_2_2.setBorder(null);
		btnNewButton_1_1_2_2.setBackground(new Color(128, 128, 255));
		panel.add(btnNewButton_1_1_2_2);

		JButton btnNewButton_1_1_2_2_1 = new JButton("Marks");
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1_1_2_2_1, 22, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1_1_2_2, 23, SpringLayout.SOUTH,
				btnNewButton_1_1_2_2_1);
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1_1_2_2_1, 24, SpringLayout.SOUTH,
				btnNewButton_1_1_2_1);
		btnNewButton_1_1_2_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cardPanelStudent.show(cardPanelStudent, "name_36790997887600");
				cl_cardPanelStudentTop.show(cardPanelStudentTop, "name_36821380256700");
			}
		});
		btnNewButton_1_1_2_2_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1_1_2_2_1.setIcon(new ImageIcon(StudentPanel.class.getResource("/images/mark.png")));
		btnNewButton_1_1_2_2_1.setIconTextGap(26);
		btnNewButton_1_1_2_2_1.setForeground(Color.WHITE);
		btnNewButton_1_1_2_2_1.setFont(new Font("Poppins", Font.BOLD, 18));
		btnNewButton_1_1_2_2_1.setBorderPainted(false);
		btnNewButton_1_1_2_2_1.setBorder(null);
		btnNewButton_1_1_2_2_1.setBackground(new Color(128, 128, 255));
		panel.add(btnNewButton_1_1_2_2_1);

		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setDividerSize(3);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPane_1);

		cardPanelStudentTop = new JPanel();
		cardPanelStudentTop.setBackground(new Color(255, 255, 255));
		splitPane_1.setLeftComponent(cardPanelStudentTop);
		cardPanelStudentTop.setLayout(cl_cardPanelStudentTop);

		JPanel dashboardCardPanelStudentTop = new JPanel();
		dashboardCardPanelStudentTop.setBackground(new Color(255, 255, 255));
		cardPanelStudentTop.add(dashboardCardPanelStudentTop, "name_110887659857400");
		SpringLayout sl_dashboardCardPanelStudentTop = new SpringLayout();
		dashboardCardPanelStudentTop.setLayout(sl_dashboardCardPanelStudentTop);

		welcomeStudentMessage = new JLabel();
		sl_dashboardCardPanelStudentTop.putConstraint(SpringLayout.NORTH, welcomeStudentMessage, 31, SpringLayout.NORTH,
				dashboardCardPanelStudentTop);
		sl_dashboardCardPanelStudentTop.putConstraint(SpringLayout.WEST, welcomeStudentMessage, 30, SpringLayout.WEST,
				dashboardCardPanelStudentTop);
		welcomeStudentMessage.setText("Welcome back, " + name);
		welcomeStudentMessage.setFont(new Font("Poppins", Font.BOLD, 24));
		dashboardCardPanelStudentTop.add(welcomeStudentMessage);

		JPanel teachersCardPanelStudentTop = new JPanel();
		teachersCardPanelStudentTop.setBackground(new Color(255, 255, 255));
		cardPanelStudentTop.add(teachersCardPanelStudentTop, "name_110889775858700");
		SpringLayout sl_teachersCardPanelStudentTop = new SpringLayout();
		teachersCardPanelStudentTop.setLayout(sl_teachersCardPanelStudentTop);

		JLabel welcomeStudentMessage_1 = new JLabel();
		sl_teachersCardPanelStudentTop.putConstraint(SpringLayout.NORTH, welcomeStudentMessage_1, 29,
				SpringLayout.NORTH, teachersCardPanelStudentTop);
		sl_teachersCardPanelStudentTop.putConstraint(SpringLayout.WEST, welcomeStudentMessage_1, 40, SpringLayout.WEST,
				teachersCardPanelStudentTop);
		welcomeStudentMessage_1.setText("Teachers");
		welcomeStudentMessage_1.setFont(new Font("Poppins", Font.BOLD, 24));
		teachersCardPanelStudentTop.add(welcomeStudentMessage_1);

		JPanel modulesCardPanelStudentTop = new JPanel();
		modulesCardPanelStudentTop.setBackground(new Color(255, 255, 255));
		cardPanelStudentTop.add(modulesCardPanelStudentTop, "name_110891736583900");
		SpringLayout sl_modulesCardPanelStudentTop = new SpringLayout();
		modulesCardPanelStudentTop.setLayout(sl_modulesCardPanelStudentTop);

		JLabel modulesTitle = new JLabel();
		sl_modulesCardPanelStudentTop.putConstraint(SpringLayout.WEST, modulesTitle, 59, SpringLayout.WEST,
				modulesCardPanelStudentTop);
		sl_modulesCardPanelStudentTop.putConstraint(SpringLayout.SOUTH, modulesTitle, -30, SpringLayout.SOUTH,
				modulesCardPanelStudentTop);
		modulesTitle.setText("Your Modules");
		modulesTitle.setFont(new Font("Poppins", Font.BOLD, 24));
		modulesCardPanelStudentTop.add(modulesTitle);

		JPanel assignmentCardPanelStudentTop = new JPanel();
		assignmentCardPanelStudentTop.setBackground(new Color(255, 255, 255));
		cardPanelStudentTop.add(assignmentCardPanelStudentTop, "name_287638290700");
		SpringLayout sl_assignmentCardPanelStudentTop = new SpringLayout();
		assignmentCardPanelStudentTop.setLayout(sl_assignmentCardPanelStudentTop);

		JLabel lblAssignments = new JLabel();
		sl_assignmentCardPanelStudentTop.putConstraint(SpringLayout.NORTH, lblAssignments, 31, SpringLayout.NORTH,
				assignmentCardPanelStudentTop);
		sl_assignmentCardPanelStudentTop.putConstraint(SpringLayout.WEST, lblAssignments, 30, SpringLayout.WEST,
				assignmentCardPanelStudentTop);
		lblAssignments.setText("Assignments");
		lblAssignments.setFont(new Font("Poppins", Font.BOLD, 24));
		assignmentCardPanelStudentTop.add(lblAssignments);

		JPanel marksCardPanelStudentTop = new JPanel();
		marksCardPanelStudentTop.setBackground(new Color(255, 255, 255));
		cardPanelStudentTop.add(marksCardPanelStudentTop, "name_36821380256700");
		SpringLayout sl_marksCardPanelStudentTop = new SpringLayout();
		marksCardPanelStudentTop.setLayout(sl_marksCardPanelStudentTop);

		JLabel lblYourMarks = new JLabel();
		sl_marksCardPanelStudentTop.putConstraint(SpringLayout.NORTH, lblYourMarks, 29, SpringLayout.NORTH,
				marksCardPanelStudentTop);
		sl_marksCardPanelStudentTop.putConstraint(SpringLayout.WEST, lblYourMarks, 40, SpringLayout.WEST,
				marksCardPanelStudentTop);
		lblYourMarks.setText("Your Marks");
		lblYourMarks.setFont(new Font("Poppins", Font.BOLD, 24));
		marksCardPanelStudentTop.add(lblYourMarks);

		JPanel electiveCardPanelStudentTop = new JPanel();
		electiveCardPanelStudentTop.setBackground(new Color(255, 255, 255));
		cardPanelStudentTop.add(electiveCardPanelStudentTop, "name_3405038275800");
		SpringLayout sl_electiveCardPanelStudentTop = new SpringLayout();
		electiveCardPanelStudentTop.setLayout(sl_electiveCardPanelStudentTop);

		JLabel lblNewLabel_3 = new JLabel("Pick Electives");
		sl_electiveCardPanelStudentTop.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 31, SpringLayout.NORTH,
				electiveCardPanelStudentTop);
		sl_electiveCardPanelStudentTop.putConstraint(SpringLayout.WEST, lblNewLabel_3, 32, SpringLayout.WEST,
				electiveCardPanelStudentTop);
		lblNewLabel_3.setFont(new Font("Poppins", Font.BOLD, 22));
		electiveCardPanelStudentTop.add(lblNewLabel_3);

		cardPanelStudent = new JPanel();
		splitPane_1.setRightComponent(cardPanelStudent);
		cardPanelStudent.setLayout(cl_cardPanelStudent);

		JPanel dashboardCardPanelStudent = new JPanel();
		dashboardCardPanelStudent.setBackground(new Color(255, 255, 255));
		cardPanelStudent.add(dashboardCardPanelStudent, "name_78982683888600");
		SpringLayout sl_dashboardCardPanelStudent = new SpringLayout();
		dashboardCardPanelStudent.setLayout(sl_dashboardCardPanelStudent);

		String studentIdFromDB = "SELECT Id FROM `studentdetails` WHERE studentName = '" + studentNameFromDB + "'";
		try {
			Statement statement = DatabaseConnection.getStatement();
			ResultSet resultSet = statement.executeQuery(studentIdFromDB);

			while (resultSet.next()) {
				studentIdFromDB = resultSet.getString("Id");
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		String studentGroupFromDB = "SELECT studentGroup FROM `studentdetails` WHERE Id = " + studentIdFromDB + "";
		try {
			Statement statement = DatabaseConnection.getStatement();
			ResultSet resultSet = statement.executeQuery(studentGroupFromDB);

			while (resultSet.next()) {
				studentGroupFromDB = resultSet.getString("studentGroup");
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		String studentPhoneFromDB = "SELECT studentPhone FROM `studentdetails` WHERE Id = " + studentIdFromDB + "";
		try {
			Statement statement = DatabaseConnection.getStatement();
			ResultSet resultSet = statement.executeQuery(studentPhoneFromDB);

			while (resultSet.next()) {
				studentPhoneFromDB = resultSet.getString("studentPhone");
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		String studentLevelFromDB = "SELECT level FROM `studentdetails` WHERE Id = " + studentIdFromDB + "";
		try {
			Statement statement = DatabaseConnection.getStatement();
			ResultSet resultSet = statement.executeQuery(studentLevelFromDB);

			while (resultSet.next()) {
				studentLevelFromDB = resultSet.getString("level");
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		JLabel lblNewLabel_1 = new JLabel(
				"<html>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Student ID: "
						+ studentIdFromDB
						+ "<br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Student Name: "
						+ studentNameFromDB
						+ "<br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Student Group: "
						+ studentGroupFromDB
						+ "<br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ "Phone Number: " + studentPhoneFromDB + "</html>\r\n\r\n\r\n");
		sl_dashboardCardPanelStudent.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 99, SpringLayout.NORTH,
				dashboardCardPanelStudent);
		sl_dashboardCardPanelStudent.putConstraint(SpringLayout.WEST, lblNewLabel_1, 25, SpringLayout.WEST,
				dashboardCardPanelStudent);
		sl_dashboardCardPanelStudent.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -38, SpringLayout.SOUTH,
				dashboardCardPanelStudent);
		sl_dashboardCardPanelStudent.putConstraint(SpringLayout.EAST, lblNewLabel_1, -30, SpringLayout.EAST,
				dashboardCardPanelStudent);
		lblNewLabel_1.setFont(new Font("Poppins", Font.BOLD, 24));
		lblNewLabel_1.setBorder(new MatteBorder(1, 1, 5, 5, (Color) new Color(128, 128, 255)));
		lblNewLabel_1.setBackground(Color.WHITE);
		dashboardCardPanelStudent.add(lblNewLabel_1);
		if (studentLevelFromDB.equals("6")) {
			btnNewButton_1_1_2_2.setVisible(true);
		} else {
			btnNewButton_1_1_2_2.setVisible(false);
		}

		JLabel lblNewLabel = new JLabel("Your Details:");
		sl_dashboardCardPanelStudent.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_dashboardCardPanelStudent.putConstraint(SpringLayout.SOUTH, lblNewLabel, -26, SpringLayout.NORTH,
				lblNewLabel_1);
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 24));
		dashboardCardPanelStudent.add(lblNewLabel);

		JPanel teachersCardPanelStudent = new JPanel();
		teachersCardPanelStudent.setBackground(new Color(255, 255, 255));
		cardPanelStudent.add(teachersCardPanelStudent, "name_78985517477200");
		SpringLayout sl_teachersCardPanelStudent = new SpringLayout();
		teachersCardPanelStudent.setLayout(sl_teachersCardPanelStudent);

		JScrollPane scrollPane = new JScrollPane();
		sl_teachersCardPanelStudent.putConstraint(SpringLayout.NORTH, scrollPane, 70, SpringLayout.NORTH,
				teachersCardPanelStudent);
		sl_teachersCardPanelStudent.putConstraint(SpringLayout.WEST, scrollPane, 55, SpringLayout.WEST,
				teachersCardPanelStudent);
		sl_teachersCardPanelStudent.putConstraint(SpringLayout.SOUTH, scrollPane, 331, SpringLayout.NORTH,
				teachersCardPanelStudent);
		sl_teachersCardPanelStudent.putConstraint(SpringLayout.EAST, scrollPane, -41, SpringLayout.EAST,
				teachersCardPanelStudent);
		teachersCardPanelStudent.add(scrollPane);

		teacherAndModulesTable = new JTable();
		teacherAndModulesTable.setFont(new Font("Poppins", Font.PLAIN, 12));
		teacherAndModulesTable.setDefaultEditor(Object.class, null);
		teacherAndModulesTable.getTableHeader().setFont(new Font("Poppins", Font.BOLD, 12));
		teacherAndModulesTable.setModel(teacherAndModulesDefaultTableModel);
		scrollPane.setViewportView(teacherAndModulesTable);

		JLabel lblYourTeachers = new JLabel();
		sl_teachersCardPanelStudent.putConstraint(SpringLayout.NORTH, lblYourTeachers, 20, SpringLayout.NORTH,
				teachersCardPanelStudent);
		sl_teachersCardPanelStudent.putConstraint(SpringLayout.WEST, lblYourTeachers, 51, SpringLayout.WEST,
				teachersCardPanelStudent);
		lblYourTeachers.setText("Your Teachers:");
		lblYourTeachers.setFont(new Font("Poppins", Font.BOLD, 18));
		teachersCardPanelStudent.add(lblYourTeachers);

		JPanel modulesCardPanelStudent = new JPanel();
		modulesCardPanelStudent.setBackground(new Color(255, 255, 255));
		cardPanelStudent.add(modulesCardPanelStudent, "name_78987815364700");
		SpringLayout sl_modulesCardPanelStudent = new SpringLayout();
		sl_modulesCardPanelStudent.putConstraint(SpringLayout.NORTH, studentModulesDisplay, 83, SpringLayout.NORTH,
				modulesCardPanelStudent);
		sl_modulesCardPanelStudent.putConstraint(SpringLayout.WEST, studentModulesDisplay, 31, SpringLayout.WEST,
				modulesCardPanelStudent);
		sl_modulesCardPanelStudent.putConstraint(SpringLayout.SOUTH, studentModulesDisplay, -83, SpringLayout.SOUTH,
				modulesCardPanelStudent);
		sl_modulesCardPanelStudent.putConstraint(SpringLayout.EAST, studentModulesDisplay, -34, SpringLayout.EAST,
				modulesCardPanelStudent);
		modulesCardPanelStudent.setLayout(sl_modulesCardPanelStudent);

		String studentCourseFromDB = "SELECT studentCourse FROM `studentdetails` WHERE Id = " + studentIdFromDB + "";
		try {
			Statement statement = DatabaseConnection.getStatement();
			ResultSet resultSet = statement.executeQuery(studentCourseFromDB);

			while (resultSet.next()) {
				studentCourseFromDB = resultSet.getString("studentCourse");
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		int relevantLevel = Integer.parseInt(studentLevelFromDB);
		String fetchRelevantModulesQuery = "SELECT moduleName FROM `moduledetails` WHERE inLevel = " + relevantLevel
				+ " AND course = '" + studentCourseFromDB + "'";
		String[] relevantModules = new String[3];
		int i = 0;
		int j = 0;
		teacherAndModulesDefaultTableModel.setRowCount(0);
		try {
			Statement statement = DatabaseConnection.getStatement();
			ResultSet resultSet = statement.executeQuery(fetchRelevantModulesQuery);

			while (resultSet.next()) {
				relevantModules[i] = resultSet.getString("moduleName");
				if (relevantModules[2] == null) {
					relevantModules[2] = "Elective";
					studentModulesDisplay = new JLabel(
							"<html>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
									+ relevantModules[0]
									+ "<br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
									+ relevantModules[1]
									+ "<br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
									+ relevantModules[2] + "<br></html>");
				} else {
					studentModulesDisplay = new JLabel(
							"<html>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
									+ relevantModules[0]
									+ "<br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
									+ relevantModules[1]
									+ "<br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
									+ relevantModules[2] + "<br></html>");
				}
				String fetchTeacherUsingModule = "SELECT moduleLeader FROM `moduledetails` WHERE moduleName ='"
						+ relevantModules[i] + "'";
				String[] relevantTeachers = new String[3];
				try {
					Statement statement2 = DatabaseConnection.getStatement();
					ResultSet resultSet2 = statement2.executeQuery(fetchTeacherUsingModule);

					while (resultSet2.next()) {
						relevantTeachers[j] = resultSet2.getString("moduleLeader");
						teacherAndModulesDefaultTableModel
								.addRow(new Object[] { relevantTeachers[j], relevantModules[i] });
						j++;
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				i++;

			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		studentModulesDisplay.setFont(new Font("Poppins", Font.BOLD, 24));
		studentModulesDisplay.setBorder(null);
		studentModulesDisplay.setBackground(Color.WHITE);
		modulesCardPanelStudent.add(studentModulesDisplay);
		
		JComboBox moduleForElectivesComboBox = new JComboBox();
		moduleForElectivesComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String pickedElective = (String) e.getItem();
				if (pickedElective.equals("Select Elective")) {

				} else {
					btnPickElective.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Object[] options = { "Yes", "No" };
							int confirmation = JOptionPane.showOptionDialog(null, "Pick elective?", "Pick Elective",
									JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
							if (confirmation == 0) {
								JOptionPane.showMessageDialog(null,
										"Picked '" + pickedElective + "' as your elective!");
								chosenElectiveLabel.setText("Your Elective: "+pickedElective);
								btnPickElective.setVisible(false);
								relevantModules[2]=pickedElective;
								studentModulesDisplay.setText(
										"<html>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
												+ relevantModules[0]
												+ "<br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
												+ relevantModules[1]
												+ "<br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
												+ relevantModules[2] + "<br></html>");
							}
						}
					});
				}
			}
		});

		JPanel assignmentCardPanelStudent = new JPanel();
		assignmentCardPanelStudent.setBackground(new Color(255, 255, 255));
		cardPanelStudent.add(assignmentCardPanelStudent, "name_259197036500");
		SpringLayout sl_assignmentCardPanelStudent = new SpringLayout();
		assignmentCardPanelStudent.setLayout(sl_assignmentCardPanelStudent);

		JLabel lblViewAssignmentsOf = new JLabel();
		sl_assignmentCardPanelStudent.putConstraint(SpringLayout.NORTH, lblViewAssignmentsOf, 23, SpringLayout.NORTH,
				assignmentCardPanelStudent);
		sl_assignmentCardPanelStudent.putConstraint(SpringLayout.WEST, lblViewAssignmentsOf, 32, SpringLayout.WEST,
				assignmentCardPanelStudent);
		lblViewAssignmentsOf.setText("View assignment of:");
		lblViewAssignmentsOf.setFont(new Font("Poppins", Font.BOLD, 20));
		assignmentCardPanelStudent.add(lblViewAssignmentsOf);

		JComboBox moduleForAssignmentComboBox = new JComboBox();
		moduleForAssignmentComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				moduleForAssignmentFromComboBox = (String) e.getItem();
				String questionsForSelectedModule = "SELECT * FROM `assignmentdetails` WHERE course = '"
						+ moduleForAssignmentFromComboBox + "'";
				try {
					Statement statement = DatabaseConnection.getStatement();
					ResultSet resultSet = statement.executeQuery(questionsForSelectedModule);
					while (resultSet.next()) {
						String firstQuestion = resultSet.getString("question_1");
						String secondQuestion = resultSet.getString("question_2");
						lblNewLabel_2.setText("<html>\r\nQuestion 1:\r\n<br>\r\n" + firstQuestion
								+ "\r\n<br>\r\nQuestion 2:\r\n<br>\r\n" + secondQuestion + "\r\n<br>\r\n</html>");
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		moduleForAssignmentComboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		moduleForAssignmentComboBox.setModel(new DefaultComboBoxModel(new String[] { "Select Module" }));
		sl_assignmentCardPanelStudent.putConstraint(SpringLayout.NORTH, moduleForAssignmentComboBox, 0,
				SpringLayout.NORTH, lblViewAssignmentsOf);
		sl_assignmentCardPanelStudent.putConstraint(SpringLayout.WEST, moduleForAssignmentComboBox, 22,
				SpringLayout.EAST, lblViewAssignmentsOf);
		sl_assignmentCardPanelStudent.putConstraint(SpringLayout.EAST, moduleForAssignmentComboBox, 361,
				SpringLayout.EAST, lblViewAssignmentsOf);
		moduleForAssignmentComboBox.setFont(new Font("Poppins", Font.PLAIN, 16));
		moduleForAssignmentComboBox
				.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 255), new Color(128, 128, 255),

						new Color(255, 255, 255), new Color(255, 255, 255)));
		moduleForAssignmentComboBox.setBackground(Color.WHITE);
		assignmentCardPanelStudent.add(moduleForAssignmentComboBox);

		String fetchModulesForAssignmentQuery = "SELECT moduleName FROM `moduledetails` WHERE inLevel = "
				+ studentLevelFromDB + " AND course = '" + studentCourseFromDB + "'";
		String[] modulesForAssignmentArray = new String[3];
		int k = 0;
		try {
			Statement statement = DatabaseConnection.getStatement();
			ResultSet resultSet = statement.executeQuery(fetchModulesForAssignmentQuery);

			while (resultSet.next()) {
				modulesForAssignmentArray[k] = resultSet.getString("moduleName");
				moduleForAssignmentComboBox.addItem(modulesForAssignmentArray[k]);
				k++;
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		lblNewLabel_2.setFont(new Font("Poppins", Font.PLAIN, 20));
		sl_assignmentCardPanelStudent.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 31, SpringLayout.SOUTH,
				moduleForAssignmentComboBox);
		sl_assignmentCardPanelStudent.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST,
				lblViewAssignmentsOf);
		sl_assignmentCardPanelStudent.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, 271, SpringLayout.SOUTH,
				moduleForAssignmentComboBox);
		sl_assignmentCardPanelStudent.putConstraint(SpringLayout.EAST, lblNewLabel_2, -29, SpringLayout.EAST,
				assignmentCardPanelStudent);
		assignmentCardPanelStudent.add(lblNewLabel_2);

		JPanel panel_1 = new JPanel();
		sl_assignmentCardPanelStudent.putConstraint(SpringLayout.NORTH, panel_1, -81, SpringLayout.SOUTH,
				assignmentCardPanelStudent);
		sl_assignmentCardPanelStudent.putConstraint(SpringLayout.SOUTH, panel_1, 0, SpringLayout.SOUTH,
				assignmentCardPanelStudent);
		panel_1.setBackground(new Color(128, 128, 255));
		sl_assignmentCardPanelStudent.putConstraint(SpringLayout.WEST, panel_1, -632, SpringLayout.EAST,
				assignmentCardPanelStudent);
		sl_assignmentCardPanelStudent.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST,
				assignmentCardPanelStudent);
		assignmentCardPanelStudent.add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);

		JLabel lblNoteAssignmentTo = new JLabel();
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNoteAssignmentTo, 595, SpringLayout.WEST, panel_1);
		lblNoteAssignmentTo.setForeground(new Color(255, 255, 255));
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNoteAssignmentTo, 36, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNoteAssignmentTo, -21, SpringLayout.SOUTH, panel_1);
		lblNoteAssignmentTo.setText("Note: Assignments to be submitted via mail.");
		lblNoteAssignmentTo.setFont(new Font("Poppins", Font.BOLD, 24));
		panel_1.add(lblNoteAssignmentTo);

		JPanel marksCardPanelStudent = new JPanel();
		marksCardPanelStudent.setBackground(new Color(255, 255, 255));
		cardPanelStudent.add(marksCardPanelStudent, "name_36790997887600");
		SpringLayout sl_marksCardPanelStudent = new SpringLayout();
		marksCardPanelStudent.setLayout(sl_marksCardPanelStudent);

		JComboBox moduleForMarks = new JComboBox();
		moduleForMarks.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		moduleForMarks.setModel(new DefaultComboBoxModel(new String[] { "Select Module" }));

		sl_marksCardPanelStudent.putConstraint(SpringLayout.EAST, moduleForMarks, -52, SpringLayout.EAST,
				marksCardPanelStudent);
		moduleForMarks.setFont(new Font("Poppins", Font.PLAIN, 16));
		moduleForMarks
				.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 255), new Color(128, 128, 255),

						new Color(255, 255, 255), new Color(255, 255, 255)));
		moduleForMarks.setBackground(Color.WHITE);
		marksCardPanelStudent.add(moduleForMarks);
		String fetchModulesForMarksQuery = "SELECT moduleName FROM `moduledetails` WHERE inLevel = "
				+ studentLevelFromDB + " AND course = '" + studentCourseFromDB + "'";
		String[] modulesForMarksArray = new String[3];
		int l = 0;
		try {
			Statement statement = DatabaseConnection.getStatement();
			ResultSet resultSet = statement.executeQuery(fetchModulesForMarksQuery);

			while (resultSet.next()) {
				modulesForMarksArray[l] = resultSet.getString("moduleName");
				moduleForMarks.addItem(modulesForMarksArray[l]);
				l++;
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		studentIdFromDBInt = Integer.parseInt(studentIdFromDB);

		moduleForMarks.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				moduleForMarksFromComboBox = (String) e.getItem();
				String fetchMarks = "SELECT marks FROM `studentmarksdetails` WHERE module = '"
						+ moduleForMarksFromComboBox + "' AND Id = " + studentIdFromDBInt + "";
				try {
					Statement statement = DatabaseConnection.getStatement();
					ResultSet resultSet = statement.executeQuery(fetchMarks);

					while (resultSet.next()) {
						fetchMarks = resultSet.getString("marks");
						marksLabel.setText("Marks: " + fetchMarks);
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel lblViewMarksOf = new JLabel();
		sl_marksCardPanelStudent.putConstraint(SpringLayout.EAST, lblViewMarksOf, -443, SpringLayout.EAST,
				marksCardPanelStudent);
		sl_marksCardPanelStudent.putConstraint(SpringLayout.WEST, moduleForMarks, 18, SpringLayout.EAST,
				lblViewMarksOf);
		sl_marksCardPanelStudent.putConstraint(SpringLayout.SOUTH, moduleForMarks, 0, SpringLayout.SOUTH,
				lblViewMarksOf);
		sl_marksCardPanelStudent.putConstraint(SpringLayout.NORTH, lblViewMarksOf, 44, SpringLayout.NORTH,
				marksCardPanelStudent);
		lblViewMarksOf.setText("View marks of:");
		lblViewMarksOf.setFont(new Font("Poppins", Font.BOLD, 20));
		marksCardPanelStudent.add(lblViewMarksOf);

		marksLabel.setFont(new Font("Poppins", Font.BOLD, 20));
		sl_marksCardPanelStudent.putConstraint(SpringLayout.NORTH, marksLabel, 39, SpringLayout.SOUTH, moduleForMarks);
		sl_marksCardPanelStudent.putConstraint(SpringLayout.WEST, marksLabel, 207, SpringLayout.WEST,
				marksCardPanelStudent);
		sl_marksCardPanelStudent.putConstraint(SpringLayout.SOUTH, marksLabel, 102, SpringLayout.SOUTH, moduleForMarks);
		sl_marksCardPanelStudent.putConstraint(SpringLayout.EAST, marksLabel, 337, SpringLayout.WEST,
				marksCardPanelStudent);
		marksCardPanelStudent.add(marksLabel);
		
		
		sl_marksCardPanelStudent.putConstraint(SpringLayout.NORTH, percentLabel, 111, SpringLayout.SOUTH, marksLabel);
		sl_marksCardPanelStudent.putConstraint(SpringLayout.WEST, percentLabel, 39, SpringLayout.WEST, marksCardPanelStudent);
		sl_marksCardPanelStudent.putConstraint(SpringLayout.EAST, percentLabel, -337, SpringLayout.EAST, marksCardPanelStudent);
		percentLabel.setFont(new Font("Poppins", Font.BOLD, 20));
		marksCardPanelStudent.add(percentLabel);
		
		String fetchOverallMarks = "SELECT overallMarks FROM `studentmarksdetails` WHERE Id = " + studentIdFromDBInt + "";
		try {
			Statement statement = DatabaseConnection.getStatement();
			ResultSet resultSet = statement.executeQuery(fetchOverallMarks);

			while (resultSet.next()) {
				fetchOverallMarks = resultSet.getString("overallMarks");
				percentLabel.setText("Percent: " + fetchOverallMarks);
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		String fetchOverallStatus= "SELECT isPassOverall FROM `studentmarksdetails` WHERE Id = " + studentIdFromDBInt + "";
		try {
			Statement statement = DatabaseConnection.getStatement();
			ResultSet resultSet = statement.executeQuery(fetchOverallStatus);

			while (resultSet.next()) {
				fetchOverallStatus = resultSet.getString("isPassOverall");
				statusLabel.setText("Status: " + fetchOverallStatus);
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		sl_marksCardPanelStudent.putConstraint(SpringLayout.NORTH, statusLabel, 342, SpringLayout.NORTH, marksCardPanelStudent);
		sl_marksCardPanelStudent.putConstraint(SpringLayout.SOUTH, percentLabel, -4, SpringLayout.NORTH, statusLabel);
		sl_marksCardPanelStudent.putConstraint(SpringLayout.WEST, statusLabel, 0, SpringLayout.WEST, lblViewMarksOf);
		statusLabel.setFont(new Font("Poppins", Font.BOLD, 20));
		marksCardPanelStudent.add(statusLabel);

		JPanel electiveCardPanelStudent = new JPanel();
		electiveCardPanelStudent.setBackground(new Color(255, 255, 255));
		cardPanelStudent.add(electiveCardPanelStudent, "name_3401648832600");
		SpringLayout sl_electiveCardPanelStudent = new SpringLayout();
		electiveCardPanelStudent.setLayout(sl_electiveCardPanelStudent);

		JLabel lblListOfElectives = new JLabel();
		sl_electiveCardPanelStudent.putConstraint(SpringLayout.NORTH, lblListOfElectives, 39, SpringLayout.NORTH,
				electiveCardPanelStudent);
		sl_electiveCardPanelStudent.putConstraint(SpringLayout.WEST, lblListOfElectives, 27, SpringLayout.WEST,
				electiveCardPanelStudent);
		lblListOfElectives.setText("List Of Electives:");
		lblListOfElectives.setFont(new Font("Poppins", Font.BOLD, 20));
		electiveCardPanelStudent.add(lblListOfElectives);

		
		moduleForElectivesComboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		sl_electiveCardPanelStudent.putConstraint(SpringLayout.NORTH, moduleForElectivesComboBox, -1,
				SpringLayout.NORTH, lblListOfElectives);
		sl_electiveCardPanelStudent.putConstraint(SpringLayout.WEST, moduleForElectivesComboBox, 25, SpringLayout.EAST,
				lblListOfElectives);
		sl_electiveCardPanelStudent.putConstraint(SpringLayout.SOUTH, moduleForElectivesComboBox, 34,
				SpringLayout.NORTH, lblListOfElectives);
		sl_electiveCardPanelStudent.putConstraint(SpringLayout.EAST, moduleForElectivesComboBox, 390, SpringLayout.EAST,
				lblListOfElectives);
		moduleForElectivesComboBox.setFont(new Font("Poppins", Font.PLAIN, 16));
		moduleForElectivesComboBox
				.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 255), new Color(128, 128, 255),

						new Color(255, 255, 255), new Color(255, 255, 255)));
		moduleForElectivesComboBox.setBackground(Color.WHITE);
		electiveCardPanelStudent.add(moduleForElectivesComboBox);

		moduleForElectivesComboBox.setModel(new DefaultComboBoxModel(new String[] { "Select Elective" }));
		String fetchElectives = "SELECT electiveName FROM `electivedetails`";
		String[] modulesForElectivesArray = new String[3];
		int m = 0;
		try {
			Statement statement = DatabaseConnection.getStatement();
			ResultSet resultSet = statement.executeQuery(fetchElectives);

			while (resultSet.next()) {
				modulesForElectivesArray[m] = resultSet.getString("electiveName");
				moduleForElectivesComboBox.addItem(modulesForElectivesArray[m]);
				m++;
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		sl_electiveCardPanelStudent.putConstraint(SpringLayout.NORTH, btnPickElective, -91, SpringLayout.SOUTH,
				electiveCardPanelStudent);
		sl_electiveCardPanelStudent.putConstraint(SpringLayout.WEST, btnPickElective, -259, SpringLayout.EAST,
				electiveCardPanelStudent);
		sl_electiveCardPanelStudent.putConstraint(SpringLayout.SOUTH, btnPickElective, -32, SpringLayout.SOUTH,
				electiveCardPanelStudent);
		sl_electiveCardPanelStudent.putConstraint(SpringLayout.EAST, btnPickElective, -54, SpringLayout.EAST,
				electiveCardPanelStudent);
		btnPickElective.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPickElective.setForeground(Color.WHITE);
		btnPickElective.setFont(new Font("Poppins", Font.BOLD, 20));
		btnPickElective.setBorder(null);
		btnPickElective.setBackground(new Color(128, 128, 255));
		electiveCardPanelStudent.add(btnPickElective);
		
		
		sl_electiveCardPanelStudent.putConstraint(SpringLayout.NORTH, chosenElectiveLabel, 52, SpringLayout.SOUTH, moduleForElectivesComboBox);
		sl_electiveCardPanelStudent.putConstraint(SpringLayout.WEST, chosenElectiveLabel, 0, SpringLayout.WEST, lblListOfElectives);
		sl_electiveCardPanelStudent.putConstraint(SpringLayout.SOUTH, chosenElectiveLabel, 119, SpringLayout.SOUTH, moduleForElectivesComboBox);
		sl_electiveCardPanelStudent.putConstraint(SpringLayout.EAST, chosenElectiveLabel, 365, SpringLayout.WEST, electiveCardPanelStudent);
		chosenElectiveLabel.setFont(new Font("Poppins", Font.BOLD, 22));
		electiveCardPanelStudent.add(chosenElectiveLabel);
		splitPane_1.setDividerLocation(100);
		splitPane.setDividerLocation(200);

		StudentPanel.getStudentNameFromLogin();
	}
}