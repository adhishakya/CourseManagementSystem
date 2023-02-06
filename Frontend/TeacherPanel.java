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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

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
	private JTable yourStudentsTable;
	private static String teacherModuleFromDB;
	private static String studentIdFromComboBox;
	static JComboBox studentIdComboBox = new JComboBox();

	private static JLabel firstQuestionLabel = new JLabel();
	private static JLabel secondQuestionLabel = new JLabel();

	JLabel studentNameForReport = new JLabel();

	public static String getTeacherModuleFromDB() {
		return teacherModuleFromDB;
	}

	public static void getAssignmentFromDatabase() {
		String questions = "SELECT * FROM `assignmentdetails` WHERE course = '" + teacherModuleFromDB + "'";
		Statement statement = DatabaseConnection.getStatement();
		try {
			ResultSet resultSet = statement.executeQuery(questions);
			while (resultSet.next()) {
				String firstQuestion = resultSet.getString("question_1");
				String secondQuestion = resultSet.getString("question_2");
				firstQuestionLabel.setText(firstQuestion);
				secondQuestionLabel.setText(secondQuestion);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private static DefaultTableModel yourStudentsDefaultTableModel = new DefaultTableModel(
			new Object[][] { { null, null, null }, }, new String[] { "Id", "Name", "Group" });

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
		fromTeacherPanel.setBounds(100, 100, 803, 552);
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
		btnNewButton.setIcon(new ImageIcon(TeacherPanel.class.getResource("/images/dashboard.png")));
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
		btnNewButton_1_1.setIcon(new ImageIcon(TeacherPanel.class.getResource("/images/student.png")));
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

		JButton btnNewButton_1_1_2_1 = new JButton("Marking");
		btnNewButton_1_1_2_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cardPanelTeacher.show(cardPanelTeacher, "name_6013106739300");
				cl_cardPanelTopTeacher.show(cardPanelTopTeacher, "name_6010082895300");
			}
		});
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1_1_2_1, 28, SpringLayout.SOUTH, btnNewButton_1_1_2);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1_1_2_1, 0, SpringLayout.WEST, btnNewButton);
		btnNewButton_1_1_2_1.setIcon(new ImageIcon(TeacherPanel.class.getResource("/images/mark.png")));
		btnNewButton_1_1_2_1.setIconTextGap(15);
		btnNewButton_1_1_2_1.setForeground(Color.WHITE);
		btnNewButton_1_1_2_1.setFont(new Font("Poppins", Font.BOLD, 18));
		btnNewButton_1_1_2_1.setBorderPainted(false);
		btnNewButton_1_1_2_1.setBorder(null);
		btnNewButton_1_1_2_1.setBackground(new Color(128, 128, 255));
		panel.add(btnNewButton_1_1_2_1);

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
		sl_dashboardCardPanelTeacherTop.putConstraint(SpringLayout.NORTH, welcomeMessageTeacher, 22, SpringLayout.NORTH,
				dashboardCardPanelTeacherTop);
		sl_dashboardCardPanelTeacherTop.putConstraint(SpringLayout.WEST, welcomeMessageTeacher, 22, SpringLayout.WEST,
				dashboardCardPanelTeacherTop);
		sl_dashboardCardPanelTeacherTop.putConstraint(SpringLayout.SOUTH, welcomeMessageTeacher, -25,
				SpringLayout.SOUTH, dashboardCardPanelTeacherTop);
		sl_dashboardCardPanelTeacherTop.putConstraint(SpringLayout.EAST, welcomeMessageTeacher, 374, SpringLayout.WEST,
				dashboardCardPanelTeacherTop);
		welcomeMessageTeacher.setText("Welcome back, " + teacherNameFromLogin);
		welcomeMessageTeacher.setFont(new Font("Poppins", Font.BOLD, 22));
		dashboardCardPanelTeacherTop.add(welcomeMessageTeacher);

		JPanel studentCardPanelTeacherTop = new JPanel();
		studentCardPanelTeacherTop.setBackground(new Color(255, 255, 255));
		cardPanelTopTeacher.add(studentCardPanelTeacherTop, "name_112387896874700");
		SpringLayout sl_studentCardPanelTeacherTop = new SpringLayout();
		studentCardPanelTeacherTop.setLayout(sl_studentCardPanelTeacherTop);

		JLabel lblNewLabel = new JLabel("Your Students");
		sl_studentCardPanelTeacherTop.putConstraint(SpringLayout.NORTH, lblNewLabel, 22, SpringLayout.NORTH,
				studentCardPanelTeacherTop);
		sl_studentCardPanelTeacherTop.putConstraint(SpringLayout.WEST, lblNewLabel, 29, SpringLayout.WEST,
				studentCardPanelTeacherTop);
		sl_studentCardPanelTeacherTop.putConstraint(SpringLayout.SOUTH, lblNewLabel, -26, SpringLayout.SOUTH,
				studentCardPanelTeacherTop);
		sl_studentCardPanelTeacherTop.putConstraint(SpringLayout.EAST, lblNewLabel, 222, SpringLayout.WEST,
				studentCardPanelTeacherTop);
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 22));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		studentCardPanelTeacherTop.add(lblNewLabel);

		JPanel assignmentCardPanelTeacherTop = new JPanel();
		assignmentCardPanelTeacherTop.setBackground(new Color(255, 255, 255));
		cardPanelTopTeacher.add(assignmentCardPanelTeacherTop, "name_112389746503700");
		SpringLayout sl_assignmentCardPanelTeacherTop = new SpringLayout();
		assignmentCardPanelTeacherTop.setLayout(sl_assignmentCardPanelTeacherTop);

		JLabel lblNewLabel_1 = new JLabel("Manage Assignment");
		sl_assignmentCardPanelTeacherTop.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 23, SpringLayout.NORTH,
				assignmentCardPanelTeacherTop);
		sl_assignmentCardPanelTeacherTop.putConstraint(SpringLayout.WEST, lblNewLabel_1, 25, SpringLayout.WEST,
				assignmentCardPanelTeacherTop);
		sl_assignmentCardPanelTeacherTop.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 64, SpringLayout.NORTH,
				assignmentCardPanelTeacherTop);
		sl_assignmentCardPanelTeacherTop.putConstraint(SpringLayout.EAST, lblNewLabel_1, 285, SpringLayout.WEST,
				assignmentCardPanelTeacherTop);
		lblNewLabel_1.setFont(new Font("Poppins", Font.BOLD, 22));
		assignmentCardPanelTeacherTop.add(lblNewLabel_1);

		JPanel markingCardPanelTeacherTop = new JPanel();
		markingCardPanelTeacherTop.setBackground(new Color(255, 255, 255));
		cardPanelTopTeacher.add(markingCardPanelTeacherTop, "name_6010082895300");
		SpringLayout sl_markingCardPanelTeacherTop = new SpringLayout();
		markingCardPanelTeacherTop.setLayout(sl_markingCardPanelTeacherTop);

		JLabel lblNewLabel_1_1 = new JLabel("Issue Marks");
		sl_markingCardPanelTeacherTop.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1, 30, SpringLayout.NORTH,
				markingCardPanelTeacherTop);
		sl_markingCardPanelTeacherTop.putConstraint(SpringLayout.WEST, lblNewLabel_1_1, 40, SpringLayout.WEST,
				markingCardPanelTeacherTop);
		lblNewLabel_1_1.setFont(new Font("Poppins", Font.BOLD, 22));
		markingCardPanelTeacherTop.add(lblNewLabel_1_1);

		cardPanelTeacher = new JPanel();
		cardPanelTeacher.setBackground(new Color(255, 255, 255));
		splitPane_1.setRightComponent(cardPanelTeacher);
		cardPanelTeacher.setLayout(cl_cardPanelTeacher);

		JPanel dashboardCardPanelTeacher = new JPanel();
		dashboardCardPanelTeacher.setBackground(new Color(255, 255, 255));
		cardPanelTeacher.add(dashboardCardPanelTeacher, "name_79330044922200");
		SpringLayout sl_dashboardCardPanelTeacher = new SpringLayout();
		dashboardCardPanelTeacher.setLayout(sl_dashboardCardPanelTeacher);

		String teacherPhoneFromDB = "SELECT teacherPhoneNo FROM `teacherdetails` WHERE teacherName = '"
				+ teacherNameFromLogin + "'";
		try {
			Statement statement = DatabaseConnection.getStatement();
			ResultSet resultSet = statement.executeQuery(teacherPhoneFromDB);

			while (resultSet.next()) {
				teacherPhoneFromDB = resultSet.getString("teacherPhoneNo");
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		teacherModuleFromDB = "SELECT assignedModule FROM `teacherdetails` WHERE teacherName = '" + teacherNameFromLogin
				+ "'";
		try {
			Statement statement = DatabaseConnection.getStatement();
			ResultSet resultSet = statement.executeQuery(teacherModuleFromDB);

			while (resultSet.next()) {
				teacherModuleFromDB = resultSet.getString("assignedModule");
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		JLabel teacherDetailsDisplay = new JLabel(
				"<html>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Name: "
						+ teacherNameFromLogin
						+ "<br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Phone Number: "
						+ teacherPhoneFromDB
						+ "<br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ "Your Module: " + teacherModuleFromDB + "</html>\r\n\r\n\r\n");
		sl_dashboardCardPanelTeacher.putConstraint(SpringLayout.NORTH, teacherDetailsDisplay, 83, SpringLayout.NORTH,
				dashboardCardPanelTeacher);
		sl_dashboardCardPanelTeacher.putConstraint(SpringLayout.WEST, teacherDetailsDisplay, 31, SpringLayout.WEST,
				dashboardCardPanelTeacher);
		sl_dashboardCardPanelTeacher.putConstraint(SpringLayout.SOUTH, teacherDetailsDisplay, 307, SpringLayout.NORTH,
				dashboardCardPanelTeacher);
		sl_dashboardCardPanelTeacher.putConstraint(SpringLayout.EAST, teacherDetailsDisplay, -34, SpringLayout.EAST,
				dashboardCardPanelTeacher);
		teacherDetailsDisplay.setFont(new Font("Poppins", Font.BOLD, 24));
		teacherDetailsDisplay.setBorder(new MatteBorder(1, 1, 5, 5, (Color) new Color(128, 128, 255)));
		teacherDetailsDisplay.setBackground(Color.WHITE);
		dashboardCardPanelTeacher.add(teacherDetailsDisplay);

		JLabel yourDetails = new JLabel();
		sl_dashboardCardPanelTeacher.putConstraint(SpringLayout.WEST, yourDetails, 31, SpringLayout.WEST,
				dashboardCardPanelTeacher);
		sl_dashboardCardPanelTeacher.putConstraint(SpringLayout.SOUTH, yourDetails, -19, SpringLayout.NORTH,
				teacherDetailsDisplay);
		yourDetails.setText("Your Details:");
		yourDetails.setFont(new Font("Poppins", Font.BOLD, 22));
		dashboardCardPanelTeacher.add(yourDetails);

		JPanel studentCardPanelTeacher = new JPanel();
		studentCardPanelTeacher.setBackground(new Color(255, 255, 255));
		cardPanelTeacher.add(studentCardPanelTeacher, "name_79342838523500");
		SpringLayout sl_studentCardPanelTeacher = new SpringLayout();
		studentCardPanelTeacher.setLayout(sl_studentCardPanelTeacher);

		JScrollPane scrollPane = new JScrollPane();
		sl_studentCardPanelTeacher.putConstraint(SpringLayout.NORTH, scrollPane, 32, SpringLayout.NORTH,
				studentCardPanelTeacher);
		sl_studentCardPanelTeacher.putConstraint(SpringLayout.WEST, scrollPane, 32, SpringLayout.WEST,
				studentCardPanelTeacher);
		sl_studentCardPanelTeacher.putConstraint(SpringLayout.SOUTH, scrollPane, 348, SpringLayout.NORTH,
				studentCardPanelTeacher);
		sl_studentCardPanelTeacher.putConstraint(SpringLayout.EAST, scrollPane, -32, SpringLayout.EAST,
				studentCardPanelTeacher);
		studentCardPanelTeacher.add(scrollPane);

		String teacherLevelFromDB = "SELECT inLevel FROM `moduledetails` WHERE moduleLeader = '" + teacherNameFromLogin
				+ "'";
		int teacherLevelFromDBInt = 0;
		try {
			Statement statement = DatabaseConnection.getStatement();
			ResultSet resultSet = statement.executeQuery(teacherLevelFromDB);

			while (resultSet.next()) {
				teacherLevelFromDB = resultSet.getString("inLevel");
				teacherLevelFromDBInt = Integer.parseInt(teacherLevelFromDB);
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		yourStudentsTable = new JTable();
		yourStudentsTable.setDefaultEditor(Object.class, null);
		yourStudentsTable.getTableHeader().setFont(new Font("Poppins", Font.BOLD, 12));
		yourStudentsTable.setModel(yourStudentsDefaultTableModel);
		scrollPane.setViewportView(yourStudentsTable);

		String studentNameOfLevelX = "SELECT Id, studentName, studentGroup From `studentdetails` WHERE level = "
				+ teacherLevelFromDBInt + "";
		try {
			yourStudentsDefaultTableModel.setRowCount(0);
			Statement statement = DatabaseConnection.getStatement();
			ResultSet resultSet = statement.executeQuery(studentNameOfLevelX);

			while (resultSet.next()) {
				int studentIdFromDB = resultSet.getInt("Id");
				String studentNameFromDB = resultSet.getString("studentName");
				String studentGroupFromDB = resultSet.getString("studentGroup");

				yourStudentsDefaultTableModel
						.addRow(new Object[] { studentIdFromDB, studentNameFromDB, studentGroupFromDB });
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		JPanel assignmentCardPanelTeacher = new JPanel();
		assignmentCardPanelTeacher.setBackground(new Color(255, 255, 255));
		cardPanelTeacher.add(assignmentCardPanelTeacher, "name_79349991822800");
		SpringLayout sl_assignmentCardPanelTeacher = new SpringLayout();
		assignmentCardPanelTeacher.setLayout(sl_assignmentCardPanelTeacher);

		JLabel lblNewLabel_2 = new JLabel("Question 1:");
		sl_assignmentCardPanelTeacher.putConstraint(SpringLayout.WEST, lblNewLabel_2, 32, SpringLayout.WEST,
				assignmentCardPanelTeacher);
		sl_assignmentCardPanelTeacher.putConstraint(SpringLayout.EAST, lblNewLabel_2, 144, SpringLayout.WEST,
				assignmentCardPanelTeacher);
		lblNewLabel_2.setFont(new Font("Poppins", Font.BOLD, 18));
		assignmentCardPanelTeacher.add(lblNewLabel_2);

		JLabel issuingAssignmentForLabel = new JLabel();
		sl_assignmentCardPanelTeacher.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 16, SpringLayout.SOUTH,
				issuingAssignmentForLabel);
		sl_assignmentCardPanelTeacher.putConstraint(SpringLayout.EAST, issuingAssignmentForLabel, 466,
				SpringLayout.WEST, assignmentCardPanelTeacher);

		issuingAssignmentForLabel.setText("Issuing Assignment For: " + teacherModuleFromDB);
		sl_assignmentCardPanelTeacher.putConstraint(SpringLayout.NORTH, issuingAssignmentForLabel, 0,
				SpringLayout.NORTH, assignmentCardPanelTeacher);
		sl_assignmentCardPanelTeacher.putConstraint(SpringLayout.WEST, issuingAssignmentForLabel, 0, SpringLayout.WEST,
				lblNewLabel_2);
		sl_assignmentCardPanelTeacher.putConstraint(SpringLayout.SOUTH, issuingAssignmentForLabel, -335,
				SpringLayout.SOUTH, assignmentCardPanelTeacher);
		issuingAssignmentForLabel.setFont(new Font("Poppins", Font.BOLD, 20));
		assignmentCardPanelTeacher.add(issuingAssignmentForLabel);

		sl_assignmentCardPanelTeacher.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -6, SpringLayout.NORTH,
				firstQuestionLabel);
		sl_assignmentCardPanelTeacher.putConstraint(SpringLayout.SOUTH, firstQuestionLabel, -215, SpringLayout.SOUTH,
				assignmentCardPanelTeacher);
		sl_assignmentCardPanelTeacher.putConstraint(SpringLayout.NORTH, firstQuestionLabel, 114, SpringLayout.NORTH,
				assignmentCardPanelTeacher);
		sl_assignmentCardPanelTeacher.putConstraint(SpringLayout.WEST, firstQuestionLabel, 0, SpringLayout.WEST,
				lblNewLabel_2);
		firstQuestionLabel.setFont(new Font("Poppins", Font.PLAIN, 14));
		assignmentCardPanelTeacher.add(firstQuestionLabel);

		JLabel lblNewLabel_2_2 = new JLabel("Question 2:");
		sl_assignmentCardPanelTeacher.putConstraint(SpringLayout.NORTH, lblNewLabel_2_2, 6, SpringLayout.SOUTH,
				firstQuestionLabel);
		sl_assignmentCardPanelTeacher.putConstraint(SpringLayout.WEST, lblNewLabel_2_2, 0, SpringLayout.WEST,
				lblNewLabel_2);
		lblNewLabel_2_2.setFont(new Font("Poppins", Font.BOLD, 18));
		assignmentCardPanelTeacher.add(lblNewLabel_2_2);

		sl_assignmentCardPanelTeacher.putConstraint(SpringLayout.NORTH, secondQuestionLabel, 40, SpringLayout.SOUTH,
				firstQuestionLabel);
		sl_assignmentCardPanelTeacher.putConstraint(SpringLayout.SOUTH, secondQuestionLabel, -95, SpringLayout.SOUTH,
				assignmentCardPanelTeacher);
		sl_assignmentCardPanelTeacher.putConstraint(SpringLayout.EAST, firstQuestionLabel, 0, SpringLayout.EAST,
				secondQuestionLabel);
		sl_assignmentCardPanelTeacher.putConstraint(SpringLayout.WEST, secondQuestionLabel, 0, SpringLayout.WEST,
				lblNewLabel_2);
		sl_assignmentCardPanelTeacher.putConstraint(SpringLayout.EAST, secondQuestionLabel, 565, SpringLayout.WEST,
				assignmentCardPanelTeacher);
		secondQuestionLabel.setFont(new Font("Poppins", Font.PLAIN, 14));
		assignmentCardPanelTeacher.add(secondQuestionLabel);

		JButton btnUploadAssignment = new JButton("Upload Assignment");
		sl_assignmentCardPanelTeacher.putConstraint(SpringLayout.NORTH, btnUploadAssignment, 6, SpringLayout.SOUTH,
				secondQuestionLabel);
		sl_assignmentCardPanelTeacher.putConstraint(SpringLayout.WEST, btnUploadAssignment, 0, SpringLayout.WEST,
				lblNewLabel_2);
		sl_assignmentCardPanelTeacher.putConstraint(SpringLayout.SOUTH, btnUploadAssignment, 61, SpringLayout.SOUTH,
				secondQuestionLabel);
		sl_assignmentCardPanelTeacher.putConstraint(SpringLayout.EAST, btnUploadAssignment, -333, SpringLayout.EAST,
				assignmentCardPanelTeacher);
		btnUploadAssignment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddAssignment addAssignment = new AddAssignment(teacherNameFromLogin);
				addAssignment.setVisible(true);
			}
		});
		btnUploadAssignment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUploadAssignment.setIcon(new ImageIcon(TeacherPanel.class.getResource("/images/create.png")));
		btnUploadAssignment.setOpaque(false);
		btnUploadAssignment.setIconTextGap(17);
		btnUploadAssignment.setFont(new Font("Poppins", Font.BOLD, 14));
		btnUploadAssignment.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(128, 128, 255)));
		btnUploadAssignment.setBackground(Color.WHITE);
		assignmentCardPanelTeacher.add(btnUploadAssignment);

		JButton btnClosePortal = new JButton("Close Portal");
		btnClosePortal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClosePortal.setIcon(new ImageIcon(TeacherPanel.class.getResource("/images/close.png")));
		sl_assignmentCardPanelTeacher.putConstraint(SpringLayout.NORTH, btnClosePortal, 6, SpringLayout.SOUTH,
				secondQuestionLabel);
		sl_assignmentCardPanelTeacher.putConstraint(SpringLayout.WEST, btnClosePortal, -266, SpringLayout.EAST,
				assignmentCardPanelTeacher);
		sl_assignmentCardPanelTeacher.putConstraint(SpringLayout.SOUTH, btnClosePortal, 0, SpringLayout.SOUTH,
				btnUploadAssignment);
		sl_assignmentCardPanelTeacher.putConstraint(SpringLayout.EAST, btnClosePortal, -45, SpringLayout.EAST,
				assignmentCardPanelTeacher);
		btnClosePortal.setOpaque(false);
		btnClosePortal.setIconTextGap(17);
		btnClosePortal.setFont(new Font("Poppins", Font.BOLD, 14));
		btnClosePortal.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(128, 128, 255)));
		btnClosePortal.setBackground(Color.WHITE);
		assignmentCardPanelTeacher.add(btnClosePortal);

		JPanel markingCardPanelTeacher = new JPanel();
		markingCardPanelTeacher.setBackground(new Color(255, 255, 255));
		cardPanelTeacher.add(markingCardPanelTeacher, "name_6013106739300");
		SpringLayout sl_markingCardPanelTeacher = new SpringLayout();
		markingCardPanelTeacher.setLayout(sl_markingCardPanelTeacher);

		JLabel lblIssuingMarksFor = new JLabel();
		sl_markingCardPanelTeacher.putConstraint(SpringLayout.NORTH, lblIssuingMarksFor, 10, SpringLayout.NORTH,
				markingCardPanelTeacher);
		sl_markingCardPanelTeacher.putConstraint(SpringLayout.WEST, lblIssuingMarksFor, 41, SpringLayout.WEST,
				markingCardPanelTeacher);
		lblIssuingMarksFor.setText("Issuing Marks For: " + teacherModuleFromDB);
		lblIssuingMarksFor.setFont(new Font("Poppins", Font.BOLD, 20));
		markingCardPanelTeacher.add(lblIssuingMarksFor);

		JLabel lblNewLabel_1_2 = new JLabel("Student Id:");
		sl_markingCardPanelTeacher.putConstraint(SpringLayout.NORTH, lblNewLabel_1_2, 23, SpringLayout.SOUTH,
				lblIssuingMarksFor);
		sl_markingCardPanelTeacher.putConstraint(SpringLayout.WEST, lblNewLabel_1_2, 0, SpringLayout.WEST,
				lblIssuingMarksFor);
		sl_markingCardPanelTeacher.putConstraint(SpringLayout.EAST, lblNewLabel_1_2, 95, SpringLayout.WEST,
				lblIssuingMarksFor);
		lblNewLabel_1_2.setFont(new Font("Poppins", Font.BOLD, 16));
		lblNewLabel_1_2.setBackground(Color.WHITE);
		markingCardPanelTeacher.add(lblNewLabel_1_2);

		sl_markingCardPanelTeacher.putConstraint(SpringLayout.NORTH, studentIdComboBox, -3, SpringLayout.NORTH,
				lblNewLabel_1_2);
		sl_markingCardPanelTeacher.putConstraint(SpringLayout.WEST, studentIdComboBox, 16, SpringLayout.EAST,
				lblNewLabel_1_2);
		sl_markingCardPanelTeacher.putConstraint(SpringLayout.SOUTH, studentIdComboBox, 50, SpringLayout.SOUTH,
				lblIssuingMarksFor);
		sl_markingCardPanelTeacher.putConstraint(SpringLayout.EAST, studentIdComboBox, 389, SpringLayout.EAST,
				lblNewLabel_1_2);
		studentIdComboBox.setFont(new Font("Poppins", Font.PLAIN, 16));
		studentIdComboBox
				.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 255), new Color(128, 128, 255),

						new Color(255, 255, 255), new Color(255, 255, 255)));
		studentIdComboBox.setBackground(Color.WHITE);
		markingCardPanelTeacher.add(studentIdComboBox);

		String teacherCourseFromDB = "SELECT course FROM `moduledetails` WHERE moduleLeader = '" + teacherNameFromLogin
				+ "'";
		try {
			Statement statement = DatabaseConnection.getStatement();
			ResultSet resultSet = statement.executeQuery(teacherCourseFromDB);

			while (resultSet.next()) {
				teacherCourseFromDB = resultSet.getString("course");
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		String fetchStudentIdQuery = "SELECT Id FROM `studentdetails` WHERE level = " + teacherLevelFromDBInt
				+ " AND studentCourse = '" + teacherCourseFromDB + "'";
		studentIdComboBox.setModel(new DefaultComboBoxModel(new String[] { "Select University Id" }));
		String[] studentIdArray = new String[10];
		int i = 0;
		try {
			Statement statement = DatabaseConnection.getStatement();
			ResultSet resultSet = statement.executeQuery(fetchStudentIdQuery);

			while (resultSet.next()) {
				studentIdArray[i] = resultSet.getString("Id");
				studentIdComboBox.addItem(studentIdArray[i]);
				i++;
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		studentIdComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				studentIdFromComboBox = (String) e.getItem();
				if(studentIdFromComboBox.equals("Select University Id")) {
					
				}
				else {
				
				String fetchSelectedStudentName = "SELECT studentName FROM `studentdetails` WHERE Id = "
						+ studentIdFromComboBox + "";
				Statement statement = DatabaseConnection.getStatement();
				try {
					ResultSet resultSet = statement.executeQuery(fetchSelectedStudentName);
					while (resultSet.next()) {
						String fetchedStudentNameForReport = resultSet.getString("studentName");
						studentNameForReport.setText(fetchedStudentNameForReport);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
		});

		JLabel lblNewLabel_1_1_1 = new JLabel("Student Name:");
		sl_markingCardPanelTeacher.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1, 31, SpringLayout.SOUTH,
				studentIdComboBox);
		sl_markingCardPanelTeacher.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1, 0, SpringLayout.WEST,
				lblIssuingMarksFor);
		sl_markingCardPanelTeacher.putConstraint(SpringLayout.EAST, lblNewLabel_1_1_1, 130, SpringLayout.WEST,
				lblIssuingMarksFor);
		lblNewLabel_1_1_1.setFont(new Font("Poppins", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBackground(Color.WHITE);
		markingCardPanelTeacher.add(lblNewLabel_1_1_1);

		studentNameForReport = new JLabel();
		sl_markingCardPanelTeacher.putConstraint(SpringLayout.NORTH, studentNameForReport, 31, SpringLayout.SOUTH,
				studentIdComboBox);
		sl_markingCardPanelTeacher.putConstraint(SpringLayout.WEST, studentNameForReport, 184, SpringLayout.WEST,
				markingCardPanelTeacher);
		studentNameForReport.setFont(new Font("Poppins", Font.BOLD, 16));
		studentNameForReport.setBackground(Color.WHITE);
		markingCardPanelTeacher.add(studentNameForReport);
		splitPane_1.setDividerLocation(100);
		splitPane.setDividerLocation(200);
		TeacherPanel.getAssignmentFromDatabase();
	}
}
