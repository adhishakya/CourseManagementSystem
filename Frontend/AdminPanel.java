package courseMngmtSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SpringLayout;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Cursor;
import java.awt.CardLayout;
import javax.swing.border.MatteBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminPanel {

	private CardLayout cl_cardPanel = new CardLayout(0, 0);

	private CardLayout cl_cardPanelTop = new CardLayout(0, 0);

	public static JFrame getFrmAdminPanel() {
		return fromAdminPanel;
	}

	private static JFrame fromAdminPanel;
	private JPanel cardPanel;
	private JPanel dashboardCardPanelTop;
	private JPanel cardPanelTop;
	private JTable teacherTable;
	private boolean isTeacherUpdate;
	private boolean isTeacherDelete;
	private boolean isStudentUpdate;
	private boolean isStudentDelete;

	private static DefaultTableModel teacherDefaultTableModel = new DefaultTableModel(
			new Object[][] { { "", null, null, null, null, null }, { null, null, null, null, null, null },
					{ null, null, null, null, null, null }, },
			new String[] { "Id", "Name", "Phone No.", "Address", "Modules", "Part Time" });

	private static DefaultTableModel studentDefaultTableModel = new DefaultTableModel(
			new Object[][] { { null, null, null, null, null, null, null, null, null },
					{ null, null, null, null, null, null, null, null, null },
					{ null, null, null, null, null, null, null, null, null },
					{ null, null, null, null, null, null, null, null, null }, },
			new String[] { "Id", "Name", "Level", "Semester", "Group", "Address", "Course", "Age", "Phone No." });

	private JTable studentTable;

	public static void showStudentDataFromDatabase() {
		Statement statement = DatabaseConnection.getStatement();

		String selectQuery = "SELECT * FROM `studentdetails`";

		try {
			ResultSet resultSet = statement.executeQuery(selectQuery);
			studentDefaultTableModel.setRowCount(0);
			while (resultSet.next()) {
				int studentIdFromDB = resultSet.getInt("Id");
				String studentNameFromDB = resultSet.getString("studentName");
				int studentLevelFromDB = resultSet.getInt("level");
				int studentSemesterFromDB = resultSet.getInt("semester");
				String studentGroupFromDB = resultSet.getString("studentGroup");
				String studentAddressFromDB = resultSet.getString("studentAddress");
				String studentCourseFromDB = resultSet.getString("studentCourse");
				int studentAgeFromDB = resultSet.getInt("studentAge");
				BigDecimal studentPhoneFromDB = resultSet.getBigDecimal("studentPhone");

				studentDefaultTableModel.addRow(new Object[] { studentIdFromDB, studentNameFromDB, studentLevelFromDB,
						studentSemesterFromDB, studentGroupFromDB, studentAddressFromDB, studentCourseFromDB,
						studentAgeFromDB, studentPhoneFromDB
				});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void showTeacherDataFromDatabase() {
		Statement statement = DatabaseConnection.getStatement();

		String selectQuery = "SELECT * FROM `teacherdetails`";

		try {
			ResultSet resultSet = statement.executeQuery(selectQuery);
			teacherDefaultTableModel.setRowCount(0);
			while (resultSet.next()) {
				int teacherIdFromDB = resultSet.getInt("Id");
				String teacherNameFromDB = resultSet.getString("teacherName");
				BigDecimal teacherPhoneFromDB = resultSet.getBigDecimal("teacherPhoneNo");
				String teacherAddressFromDB = resultSet.getString("teacherAddress");
				String assignedModuleFromDB = resultSet.getString("assignedModule");
				boolean isPartTimeFromDB = resultSet.getBoolean("isPartTime");

				teacherDefaultTableModel.addRow(new Object[] { teacherIdFromDB, teacherNameFromDB, teacherPhoneFromDB,
						teacherAddressFromDB, assignedModuleFromDB, isPartTimeFromDB

				});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel window = new AdminPanel();
					window.fromAdminPanel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		fromAdminPanel = new JFrame();
		fromAdminPanel.setResizable(false);
		fromAdminPanel.setTitle("Admin Panel | Course Management System");
		fromAdminPanel.setBounds(330, 100, 744, 566);
		fromAdminPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(0);
		splitPane.setOpaque(false);
		fromAdminPanel.getContentPane().add(splitPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		splitPane.setLeftComponent(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JButton btnNewButton = new JButton("Dashboard\r\n");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, 20, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton, 26, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton, -10, SpringLayout.EAST, panel);
		btnNewButton.setIconTextGap(16);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/dashboard.png")));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorder(null);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(128, 128, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cardPanel.show(cardPanel, "name_74576525649000");
				cl_cardPanelTop.show(cardPanelTop, "name_90724710509300");
			}
		});
		btnNewButton.setFont(new Font("Poppins", Font.BOLD, 18));
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Teachers");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1, 100, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton, -16, SpringLayout.NORTH, btnNewButton_1);
		btnNewButton_1.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/teacher.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cardPanel.show(cardPanel, "name_74583098469500");
				cl_cardPanelTop.show(cardPanelTop, "name_90727370245900");
			}
		});
		btnNewButton_1.setIconTextGap(15);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Poppins", Font.BOLD, 18));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(new Color(128, 128, 255));
		panel.add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("Students");
		btnNewButton_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cardPanel.show(cardPanel, "name_74591453117300");
				cl_cardPanelTop.show(cardPanelTop, "name_90731635969300");
			}
		});
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1_1, 0, SpringLayout.WEST, btnNewButton_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton_1_1, -310, SpringLayout.SOUTH, panel);
		btnNewButton_1_1.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/student.png")));
		btnNewButton_1_1.setIconTextGap(15);
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Poppins", Font.BOLD, 18));
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.setBorder(null);
		btnNewButton_1_1.setBackground(new Color(128, 128, 255));
		panel.add(btnNewButton_1_1);

		JButton logOutButton = new JButton("Log Out");
		logOutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogoutPromptAdmin logoutPrompt = new LogoutPromptAdmin();
				logoutPrompt.setVisible(true);
			}
		});
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1, 0, SpringLayout.WEST, logOutButton);
		sl_panel.putConstraint(SpringLayout.WEST, logOutButton, 27, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, logOutButton, -22, SpringLayout.SOUTH, panel);
		logOutButton.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/logout.png")));
		logOutButton.setIconTextGap(16);
		logOutButton.setForeground(Color.WHITE);
		logOutButton.setFont(new Font("Poppins", Font.BOLD, 18));
		logOutButton.setBorderPainted(false);
		logOutButton.setBorder(null);
		logOutButton.setBackground(new Color(128, 128, 255));
		panel.add(logOutButton);

		JButton btnNewButton_1_1_2 = new JButton("Courses");
		btnNewButton_1_1_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cardPanel.show(cardPanel, "name_74601242877200");
				cl_cardPanelTop.show(cardPanelTop, "name_90733662284300");
			}
		});
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1_1_2, 26, SpringLayout.SOUTH, btnNewButton_1_1);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1_1_2, 27, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_1_1_2, -36, SpringLayout.EAST, panel);
		btnNewButton_1_1_2.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/books.png")));
		btnNewButton_1_1_2.setIconTextGap(14);
		btnNewButton_1_1_2.setForeground(Color.WHITE);
		btnNewButton_1_1_2.setFont(new Font("Poppins", Font.BOLD, 18));
		btnNewButton_1_1_2.setBorderPainted(false);
		btnNewButton_1_1_2.setBorder(null);
		btnNewButton_1_1_2.setBackground(new Color(128, 128, 255));
		panel.add(btnNewButton_1_1_2);

		JButton btnNewButton_1_1_2_1 = new JButton("Report");
		btnNewButton_1_1_2_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cardPanel.show(cardPanel, "name_76380701101000");
				cl_cardPanelTop.show(cardPanelTop, "name_90735734126900");
			}
		});
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1_1_2_1, 30, SpringLayout.SOUTH, btnNewButton_1_1_2);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1_1_2_1, 0, SpringLayout.WEST, btnNewButton_1);
		btnNewButton_1_1_2_1.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/report.png")));
		btnNewButton_1_1_2_1.setIconTextGap(18);
		btnNewButton_1_1_2_1.setForeground(Color.WHITE);
		btnNewButton_1_1_2_1.setFont(new Font("Poppins", Font.BOLD, 18));
		btnNewButton_1_1_2_1.setBorderPainted(false);
		btnNewButton_1_1_2_1.setBorder(null);
		btnNewButton_1_1_2_1.setBackground(new Color(128, 128, 255));
		panel.add(btnNewButton_1_1_2_1);

		JPanel panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));

		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setDividerSize(3);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel_1.add(splitPane_1, "name_113668200161300");

		cardPanelTop = new JPanel();
		cardPanelTop.setBackground(new Color(255, 255, 255));
		splitPane_1.setLeftComponent(cardPanelTop);
		cardPanelTop.setLayout(cl_cardPanelTop);

		dashboardCardPanelTop = new JPanel();
		dashboardCardPanelTop.setBackground(new Color(255, 255, 255));
		cardPanelTop.add(dashboardCardPanelTop, "name_90724710509300");
		SpringLayout sl_dashboardCardPanelTop = new SpringLayout();
		dashboardCardPanelTop.setLayout(sl_dashboardCardPanelTop);

		JLabel lblNewLabel = new JLabel("Welcome Back, Admin!");
		sl_dashboardCardPanelTop.putConstraint(SpringLayout.WEST, lblNewLabel, 59, SpringLayout.WEST,
				dashboardCardPanelTop);
		sl_dashboardCardPanelTop.putConstraint(SpringLayout.SOUTH, lblNewLabel, -26, SpringLayout.SOUTH,
				dashboardCardPanelTop);
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 30));
		dashboardCardPanelTop.add(lblNewLabel);

		JPanel teachersCardPanelTop = new JPanel();
		teachersCardPanelTop.setBackground(new Color(255, 255, 255));
		cardPanelTop.add(teachersCardPanelTop, "name_90727370245900");
		SpringLayout sl_teachersCardPanelTop = new SpringLayout();
		teachersCardPanelTop.setLayout(sl_teachersCardPanelTop);

		JLabel lblTeacherCrud = new JLabel("Manage Teachers");
		sl_teachersCardPanelTop.putConstraint(SpringLayout.NORTH, lblTeacherCrud, 26, SpringLayout.NORTH,
				teachersCardPanelTop);
		sl_teachersCardPanelTop.putConstraint(SpringLayout.WEST, lblTeacherCrud, 60, SpringLayout.WEST,
				teachersCardPanelTop);
		lblTeacherCrud.setFont(new Font("Poppins", Font.BOLD, 30));
		teachersCardPanelTop.add(lblTeacherCrud);

		JPanel studentsCardPanelTop = new JPanel();
		studentsCardPanelTop.setBackground(new Color(255, 255, 255));
		cardPanelTop.add(studentsCardPanelTop, "name_90731635969300");
		SpringLayout sl_studentsCardPanelTop = new SpringLayout();
		studentsCardPanelTop.setLayout(sl_studentsCardPanelTop);

		JLabel lblManageStudents = new JLabel("Manage Students");
		sl_studentsCardPanelTop.putConstraint(SpringLayout.WEST, lblManageStudents, 59, SpringLayout.WEST,
				studentsCardPanelTop);
		sl_studentsCardPanelTop.putConstraint(SpringLayout.SOUTH, lblManageStudents, -26, SpringLayout.SOUTH,
				studentsCardPanelTop);
		lblManageStudents.setFont(new Font("Poppins", Font.BOLD, 30));
		studentsCardPanelTop.add(lblManageStudents);

		JPanel coursesCardPanelTop = new JPanel();
		coursesCardPanelTop.setBackground(new Color(255, 255, 255));
		cardPanelTop.add(coursesCardPanelTop, "name_90733662284300");
		SpringLayout sl_coursesCardPanelTop = new SpringLayout();
		coursesCardPanelTop.setLayout(sl_coursesCardPanelTop);

		JLabel lblTeacherCrud_1 = new JLabel("Manage Courses");
		sl_coursesCardPanelTop.putConstraint(SpringLayout.WEST, lblTeacherCrud_1, 60, SpringLayout.WEST,
				coursesCardPanelTop);
		sl_coursesCardPanelTop.putConstraint(SpringLayout.SOUTH, lblTeacherCrud_1, -26, SpringLayout.SOUTH,
				coursesCardPanelTop);
		lblTeacherCrud_1.setFont(new Font("Poppins", Font.BOLD, 30));
		coursesCardPanelTop.add(lblTeacherCrud_1);

		JPanel reportCardPanelTop = new JPanel();
		reportCardPanelTop.setBackground(new Color(255, 255, 255));
		cardPanelTop.add(reportCardPanelTop, "name_90735734126900");
		SpringLayout sl_reportCardPanelTop = new SpringLayout();
		reportCardPanelTop.setLayout(sl_reportCardPanelTop);

		JLabel lblManageReport = new JLabel("Manage Report");
		sl_reportCardPanelTop.putConstraint(SpringLayout.NORTH, lblManageReport, 23, SpringLayout.NORTH,
				reportCardPanelTop);
		sl_reportCardPanelTop.putConstraint(SpringLayout.WEST, lblManageReport, 51, SpringLayout.WEST,
				reportCardPanelTop);
		lblManageReport.setFont(new Font("Poppins", Font.BOLD, 30));
		reportCardPanelTop.add(lblManageReport);

		cardPanel = new JPanel();
		cardPanel.setBackground(new Color(255, 255, 255));
		splitPane_1.setRightComponent(cardPanel);
		cardPanel.setLayout(cl_cardPanel);

		JPanel dashboardCardPanel = new JPanel();
		dashboardCardPanel.setBackground(new Color(255, 255, 255));
		cardPanel.add(dashboardCardPanel, "name_74576525649000");
		SpringLayout sl_dashboardCardPanel = new SpringLayout();
		dashboardCardPanel.setLayout(sl_dashboardCardPanel);

		JLabel lblNewLabel_1 = new JLabel(
				"<html>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1002<br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Students\r\n</html>\r\n\r\n\r\n");
		sl_dashboardCardPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 44, SpringLayout.NORTH,
				dashboardCardPanel);
		sl_dashboardCardPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 38, SpringLayout.WEST,
				dashboardCardPanel);
		sl_dashboardCardPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -252, SpringLayout.SOUTH,
				dashboardCardPanel);
		lblNewLabel_1.setFont(new Font("Poppins", Font.BOLD, 24));
		lblNewLabel_1.setBorder(new MatteBorder(1, 1, 5, 5, (Color) new Color(128, 128, 255)));
		lblNewLabel_1.setBackground(Color.WHITE);
		dashboardCardPanel.add(lblNewLabel_1);

		JPanel teachersCardPanel = new JPanel();
		teachersCardPanel.setBackground(new Color(255, 255, 255));
		cardPanel.add(teachersCardPanel, "name_74583098469500");
		SpringLayout sl_teachersCardPanel = new SpringLayout();
		teachersCardPanel.setLayout(sl_teachersCardPanel);

		JScrollPane scrollPane = new JScrollPane();
		sl_teachersCardPanel.putConstraint(SpringLayout.NORTH, scrollPane, -253, SpringLayout.SOUTH, teachersCardPanel);
		sl_teachersCardPanel.putConstraint(SpringLayout.WEST, scrollPane, -506, SpringLayout.EAST, teachersCardPanel);
		sl_teachersCardPanel.putConstraint(SpringLayout.EAST, scrollPane, -10, SpringLayout.EAST, teachersCardPanel);
		scrollPane.setBackground(new Color(255, 255, 255));
		sl_teachersCardPanel.putConstraint(SpringLayout.SOUTH, scrollPane, -43, SpringLayout.SOUTH, teachersCardPanel);
		teachersCardPanel.add(scrollPane);

		teacherTable = new JTable();
		teacherTable.setDefaultEditor(Object.class, null);
		teacherTable.getTableHeader().setFont(new Font("Poppins", Font.BOLD, 12));
		teacherTable.setFont(new Font("Poppins", Font.PLAIN, 10));
		teacherTable.setRowSelectionAllowed(false);
		teacherTable.setModel(teacherDefaultTableModel);
		teacherTable.getColumnModel().getColumn(0).setPreferredWidth(53);
		teacherTable.getColumnModel().getColumn(0).setMinWidth(16);
		teacherTable.getColumnModel().getColumn(1).setPreferredWidth(99);
		teacherTable.getColumnModel().getColumn(2).setPreferredWidth(91);
		teacherTable.getColumnModel().getColumn(3).setPreferredWidth(97);
		teacherTable.getColumnModel().getColumn(4).setPreferredWidth(97);
		scrollPane.setViewportView(teacherTable);

		int teacherCount = teacherTable.getRowCount();

		JLabel lblNewLabel_1_1 = new JLabel(
				"<html>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ teacherCount
						+ "<br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Teachers\r\n</html>\r\n\r\n\r\n");
		sl_dashboardCardPanel.putConstraint(SpringLayout.EAST, lblNewLabel_1, -46, SpringLayout.WEST, lblNewLabel_1_1);
		sl_dashboardCardPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_1, 0, SpringLayout.SOUTH, lblNewLabel_1);
		sl_dashboardCardPanel.putConstraint(SpringLayout.EAST, lblNewLabel_1_1, -23, SpringLayout.EAST,
				dashboardCardPanel);
		sl_dashboardCardPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1, 44, SpringLayout.NORTH,
				dashboardCardPanel);
		sl_dashboardCardPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1, -223, SpringLayout.EAST,
				dashboardCardPanel);
		lblNewLabel_1_1.setFont(new Font("Poppins", Font.BOLD, 24));
		lblNewLabel_1_1.setBorder(new MatteBorder(1, 1, 5, 5, (Color) new Color(128, 128, 255)));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		dashboardCardPanel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel(
				"<html>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2<br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Courses\r\n</html>\r\n\r\n\r\n");
		sl_dashboardCardPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_2, 53, SpringLayout.SOUTH, lblNewLabel_1);
		sl_dashboardCardPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_2, 160, SpringLayout.WEST,
				dashboardCardPanel);
		sl_dashboardCardPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_2, -73, SpringLayout.SOUTH,
				dashboardCardPanel);
		sl_dashboardCardPanel.putConstraint(SpringLayout.EAST, lblNewLabel_1_2, -147, SpringLayout.EAST,
				dashboardCardPanel);
		lblNewLabel_1_2.setFont(new Font("Poppins", Font.BOLD, 24));
		lblNewLabel_1_2.setBorder(new MatteBorder(1, 1, 5, 5, (Color) new Color(128, 128, 255)));
		lblNewLabel_1_2.setBackground(Color.WHITE);
		dashboardCardPanel.add(lblNewLabel_1_2);

		JButton addButton = new JButton("Add");
		addButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		sl_teachersCardPanel.putConstraint(SpringLayout.WEST, addButton, 60, SpringLayout.WEST, teachersCardPanel);
		sl_teachersCardPanel.putConstraint(SpringLayout.EAST, addButton, -308, SpringLayout.EAST, teachersCardPanel);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTeacher createTeacher = new AddTeacher();
				createTeacher.setVisible(true);
			}
		});
		sl_teachersCardPanel.putConstraint(SpringLayout.NORTH, addButton, 20, SpringLayout.NORTH, teachersCardPanel);
		addButton.setIconTextGap(12);
		addButton.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/create.png")));
		addButton.setBackground(new Color(255, 255, 255));
		addButton.setOpaque(false);
		addButton.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(128, 128, 255)));
		addButton.setFont(new Font("Poppins", Font.BOLD, 14));
		teachersCardPanel.add(addButton);
		JButton deleteButton = new JButton("Delete");
		JButton updateButtonBox = new JButton("Update");
		sl_teachersCardPanel.putConstraint(SpringLayout.NORTH, updateButtonBox, 92, SpringLayout.NORTH,
				teachersCardPanel);
		sl_teachersCardPanel.putConstraint(SpringLayout.SOUTH, updateButtonBox, -28, SpringLayout.NORTH, scrollPane);
		JButton stopButton = new JButton("Stop");
		sl_teachersCardPanel.putConstraint(SpringLayout.NORTH, stopButton, 20, SpringLayout.NORTH, teachersCardPanel);
		sl_teachersCardPanel.putConstraint(SpringLayout.WEST, stopButton, 96, SpringLayout.EAST, addButton);
		sl_teachersCardPanel.putConstraint(SpringLayout.SOUTH, stopButton, -23, SpringLayout.NORTH, deleteButton);
		sl_teachersCardPanel.putConstraint(SpringLayout.EAST, stopButton, -61, SpringLayout.EAST, teachersCardPanel);
		sl_teachersCardPanel.putConstraint(SpringLayout.EAST, deleteButton, 0, SpringLayout.EAST, stopButton);

		stopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isTeacherUpdate = false;
				isTeacherDelete = false;
				addButton.setVisible(true);
				deleteButton.setVisible(true);
				updateButtonBox.setVisible(true);
				stopButton.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/stop_inactive.png")));
				stopButton.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(128, 128, 128)));
			}
		});

		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = { "Yes", "No" };
				int n = JOptionPane.showOptionDialog(null, "Do you want to enter delete mode?", "Delete Teacher",
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				if (n == 0) {
					isTeacherUpdate = false;
					isTeacherDelete = true;
					JOptionPane.showMessageDialog(null, "Entered Delete Mode!");
					addButton.setVisible(false);
					updateButtonBox.setVisible(false);
					stopButton.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/stop.png")));
					stopButton.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(255, 0, 0)));

					teacherTable.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if (isTeacherUpdate == false && isTeacherDelete == true) {
								int deleteId = (int) teacherTable.getValueAt(teacherTable.getSelectedRow(), 0);
								int confirmation = JOptionPane.showOptionDialog(null,
										"Delete teacher with Id: " + deleteId + "?", "Delete Teacher",
										JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options,
										options[0]);
								if (confirmation == 0) {
									Statement statement = DatabaseConnection.getStatement();
									String deleteQuery = "DELETE FROM `teacherdetails` WHERE `teacherdetails`.`Id` = "
											+ deleteId + "";
									try {
										int deleteSuccess = statement.executeUpdate(deleteQuery);
										if (deleteSuccess == 1) {
											JOptionPane.showMessageDialog(null, "Data Deleted");
										}
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									AdminPanel.showTeacherDataFromDatabase();
								}
							}
						}
					});

				}
			}
		});
		deleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		deleteButton.setIconTextGap(14);
		deleteButton.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/delete.png")));
		sl_teachersCardPanel.putConstraint(SpringLayout.NORTH, deleteButton, 92, SpringLayout.NORTH, teachersCardPanel);
		deleteButton.setOpaque(false);
		deleteButton.setFont(new Font("Poppins", Font.BOLD, 14));
		deleteButton.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(128, 128, 255)));
		deleteButton.setBackground(Color.WHITE);
		teachersCardPanel.add(deleteButton);

		updateButtonBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = { "Yes", "No" };
				int n = JOptionPane.showOptionDialog(null, "Do you want to enter update mode?", "Update Teacher",
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				if (n == 0) {
					isTeacherUpdate = true;
					isTeacherDelete = false;
					JOptionPane.showMessageDialog(null, "Entered Update Mode!");
					addButton.setVisible(false);
					deleteButton.setVisible(false);
					stopButton.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/stop.png")));
					stopButton.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(255, 0, 0)));
					teacherTable.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if (isTeacherUpdate == true && isTeacherDelete == false) {
								AddTeacher updateTeacher = new AddTeacher();
								updateTeacher.setVisible(true);
								updateTeacher.setTitle("Update Teacher | Course Management System");
								JLabel heading = updateTeacher.getHeading();
								heading.setText("Update Teacher");
								JButton updateButton = updateTeacher.getAddButton();
								updateButton.setText("Update");
								String teacherName = "";
								BigDecimal teacherPhone = new BigDecimal(0);
								String teacherAddress = "";
								String assignedModule = "";
								String isPartTimeText = "";
								String isPartTime = "";
								ButtonGroup buttonGroup = updateTeacher.getButtonGroup();
								for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons
										.hasMoreElements();) {
									AbstractButton button = buttons.nextElement();
									if (button.isSelected()) {
										isPartTimeText = button.getText();
										if (isPartTimeText.equalsIgnoreCase("Part-Time")) {
											isPartTime = "1";
										} else {
											isPartTime = "0";
										}
									}
								}
								for (int columnIndex = 1; columnIndex < teacherTable.getColumnCount(); columnIndex++) {
									if (teacherName.isEmpty()) {
										teacherName = (String) teacherTable.getValueAt(teacherTable.getSelectedRow(),
												columnIndex);
									} else if (teacherPhone.compareTo(new BigDecimal(0)) == 0) {
										teacherPhone = (BigDecimal) teacherTable
												.getValueAt(teacherTable.getSelectedRow(), columnIndex);
									} else if (teacherAddress.isEmpty()) {
										teacherAddress = (String) teacherTable.getValueAt(teacherTable.getSelectedRow(),
												columnIndex);
									} else if (assignedModule.isEmpty()) {
										assignedModule = (String) teacherTable.getValueAt(teacherTable.getSelectedRow(),
												columnIndex);
									} else {
										if (teacherTable.getValueAt(teacherTable.getSelectedRow(), columnIndex)
												.equals(false)) {
											isPartTime = "0";
										} else {
											isPartTime = "1";
										}
									}
								}
								updateTeacher.getTeacherFullNameTextField().setText(teacherName);
								updateTeacher.getTeacherPhoneTextField().setText(teacherPhone.toString());
								updateTeacher.getTeacherAddressTextField().setText(teacherAddress);

								// for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons
								// .hasMoreElements();) {
								// AbstractButton button = buttons.nextElement();
								// if (isPartTime.equals(button.getText())) {
								// button.setText("0");
								// }
								// }
								updateButton.setActionCommand("Update");
								updateButton.addActionListener(new ActionListener() {

									@Override
									public void actionPerformed(ActionEvent e) {
										// TODO Auto-generated method stub
										if (e.getActionCommand().equals("Update")) {
											JTextField teacherFullNameTextField = updateTeacher
													.getTeacherFullNameTextField();
											JTextField teacherPhoneTextField = updateTeacher.getTeacherPhoneTextField();
											JTextField teacherAddressTextField = updateTeacher
													.getTeacherAddressTextField();
											String assignedModule2 = updateTeacher.getAssignedModule();

											String updatedTeacherName = teacherFullNameTextField.getText().trim();
											String updatedTeacherPhone = teacherPhoneTextField.getText().trim();
											String updatedTeacherAddress = teacherAddressTextField.getText().trim();
											String updatedAssignedModule = assignedModule2.trim();
											String updatedIsPartTimeText = "";
											String updatedIsPartTime = "";
											ButtonGroup buttonGroup = updateTeacher.getButtonGroup();
											for (Enumeration<AbstractButton> buttons = buttonGroup
													.getElements(); buttons.hasMoreElements();) {
												AbstractButton button = buttons.nextElement();
												if (button.isSelected()) {
													updatedIsPartTimeText = button.getText();
													if (updatedIsPartTimeText.equalsIgnoreCase("Part-Time")) {
														updatedIsPartTime = "1";
													} else {
														updatedIsPartTime = "0";
													}
												}
											}
											int updateId = (int) teacherTable.getValueAt(teacherTable.getSelectedRow(),
													0);

											String updateQuery = "UPDATE `teacherdetails` " + "SET `teacherName` = '"
													+ updatedTeacherName + "'," + " `teacherPhoneNo` = '"
													+ updatedTeacherPhone + "'," + " `teacherAddress` = '"
													+ updatedTeacherAddress + "'," + " `assignedModule` = '"
													+ updatedAssignedModule + "'," + " `isPartTime` = '"
													+ updatedIsPartTime + "'" + " WHERE `teacherdetails`.`Id` = "
													+ updateId + "";
											Statement statement = DatabaseConnection.getStatement();
											try {
												int updateSuccess = statement.executeUpdate(updateQuery);
												if (updateSuccess == 1) {
													JOptionPane.showMessageDialog(null, "Data Updated");
													updateTeacher.dispose();
													AdminPanel.showTeacherDataFromDatabase();
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
					});

				}
			}
		});
		updateButtonBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		sl_teachersCardPanel.putConstraint(SpringLayout.SOUTH, addButton, -23, SpringLayout.NORTH, updateButtonBox);
		updateButtonBox.setIconTextGap(14);
		updateButtonBox.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/update.png")));
		sl_teachersCardPanel.putConstraint(SpringLayout.WEST, deleteButton, 94, SpringLayout.EAST, updateButtonBox);
		sl_teachersCardPanel.putConstraint(SpringLayout.SOUTH, deleteButton, 0, SpringLayout.SOUTH, updateButtonBox);
		sl_teachersCardPanel.putConstraint(SpringLayout.EAST, updateButtonBox, -306, SpringLayout.EAST,
				teachersCardPanel);
		sl_teachersCardPanel.putConstraint(SpringLayout.WEST, updateButtonBox, 62, SpringLayout.WEST,
				teachersCardPanel);
		updateButtonBox.setOpaque(false);
		updateButtonBox.setFont(new Font("Poppins", Font.BOLD, 14));
		updateButtonBox.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(128, 128, 255)));
		updateButtonBox.setBackground(Color.WHITE);
		teachersCardPanel.add(updateButtonBox);

		stopButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		stopButton.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/stop_inactive.png")));
		stopButton.setOpaque(false);
		stopButton.setIconTextGap(10);
		stopButton.setFont(new Font("Poppins", Font.BOLD, 14));
		stopButton.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(128, 128, 128)));
		stopButton.setBackground(Color.WHITE);
		teachersCardPanel.add(stopButton);

		JPanel studentsCardPanel = new JPanel();
		studentsCardPanel.setBackground(new Color(255, 255, 255));
		cardPanel.add(studentsCardPanel, "name_74591453117300");
		SpringLayout sl_studentsCardPanel = new SpringLayout();
		studentsCardPanel.setLayout(sl_studentsCardPanel);

		JButton addButton2 = new JButton("Add");
		sl_studentsCardPanel.putConstraint(SpringLayout.EAST, addButton2, 209, SpringLayout.WEST,
				studentsCardPanel);
		addButton2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				AddStudent addStudent = new AddStudent();
				addStudent.setVisible(true);
			}
		});
		addButton2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		sl_studentsCardPanel.putConstraint(SpringLayout.NORTH, addButton2, 21, SpringLayout.NORTH,
				studentsCardPanel);
		sl_studentsCardPanel.putConstraint(SpringLayout.WEST, addButton2, 58, SpringLayout.WEST,
				studentsCardPanel);
		sl_studentsCardPanel.putConstraint(SpringLayout.SOUTH, addButton2, -351, SpringLayout.SOUTH,
				studentsCardPanel);
		addButton2.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/create.png")));
		addButton2.setOpaque(false);
		addButton2.setIconTextGap(12);
		addButton2.setFont(new Font("Poppins", Font.BOLD, 14));
		addButton2.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(128, 128, 255)));
		addButton2.setBackground(Color.WHITE);
		studentsCardPanel.add(addButton2);

		JButton stopButton2 = new JButton("Stop");
		JButton deleteButton2 = new JButton("Delete");
		JButton updateButtonBox2 = new JButton("Update");
		sl_studentsCardPanel.putConstraint(SpringLayout.NORTH, updateButtonBox2, 0, SpringLayout.NORTH, deleteButton2);
		sl_studentsCardPanel.putConstraint(SpringLayout.WEST, updateButtonBox2, 0, SpringLayout.WEST, addButton2);
		sl_studentsCardPanel.putConstraint(SpringLayout.EAST, updateButtonBox2, 0, SpringLayout.EAST,
				addButton2);
		sl_studentsCardPanel.putConstraint(SpringLayout.NORTH, stopButton2, 21, SpringLayout.NORTH,
				studentsCardPanel);
		sl_studentsCardPanel.putConstraint(SpringLayout.EAST, stopButton2, -64, SpringLayout.EAST,
				studentsCardPanel);
		stopButton2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		stopButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isStudentUpdate = false;
				isStudentDelete = false;
				addButton2.setVisible(true);
				deleteButton2.setVisible(true);
				updateButtonBox2.setVisible(true);
				stopButton2.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/stop_inactive.png")));
				stopButton2.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(128, 128, 128)));
			}
		});
		sl_studentsCardPanel.putConstraint(SpringLayout.WEST, stopButton2, -215, SpringLayout.EAST,
				studentsCardPanel);
		stopButton2.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/stop_inactive.png")));
		stopButton2.setOpaque(false);
		stopButton2.setIconTextGap(10);
		stopButton2.setFont(new Font("Poppins", Font.BOLD, 14));
		stopButton2.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(128, 128, 128)));
		stopButton2.setBackground(Color.WHITE);
		studentsCardPanel.add(stopButton2);

		updateButtonBox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = { "Yes", "No" };
				int n = JOptionPane.showOptionDialog(null, "Do you want to enter update mode?", "Update Teacher",
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				if (n == 0) {
					isStudentUpdate = true;
					isStudentDelete = false;
					JOptionPane.showMessageDialog(null, "Entered Update Mode!");
					addButton2.setVisible(false);
					deleteButton2.setVisible(false);
					stopButton2.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/stop.png")));
					stopButton2.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(255, 0, 0)));
				}

			}
		});
		updateButtonBox2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		updateButtonBox2.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/update.png")));
		updateButtonBox2.setOpaque(false);
		updateButtonBox2.setIconTextGap(14);
		updateButtonBox2.setFont(new Font("Poppins", Font.BOLD, 14));
		updateButtonBox2.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(128, 128, 255)));
		updateButtonBox2.setBackground(Color.WHITE);
		studentsCardPanel.add(updateButtonBox2);

		deleteButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = { "Yes", "No" };
				int n = JOptionPane.showOptionDialog(null, "Do you want to enter delete mode?", "Delete Teacher",
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				if (n == 0) {
					isStudentUpdate = false;
					isStudentDelete = true;
					JOptionPane.showMessageDialog(null, "Entered Delete Mode!");
					addButton2.setVisible(false);
					updateButtonBox2.setVisible(false);
					stopButton2.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/stop.png")));
					stopButton2.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(255, 0, 0)));

				}

			}
		});
		sl_studentsCardPanel.putConstraint(SpringLayout.SOUTH, stopButton2, -21, SpringLayout.NORTH,
				deleteButton2);
		sl_studentsCardPanel.putConstraint(SpringLayout.NORTH, deleteButton2, 93, SpringLayout.NORTH,
				studentsCardPanel);
		sl_studentsCardPanel.putConstraint(SpringLayout.WEST, deleteButton2, 312, SpringLayout.WEST,
				studentsCardPanel);
		sl_studentsCardPanel.putConstraint(SpringLayout.EAST, deleteButton2, 0, SpringLayout.EAST,
				stopButton2);
		deleteButton2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		deleteButton2.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/delete.png")));
		deleteButton2.setOpaque(false);
		deleteButton2.setIconTextGap(14);
		deleteButton2.setFont(new Font("Poppins", Font.BOLD, 14));
		deleteButton2.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(128, 128, 255)));
		deleteButton2.setBackground(Color.WHITE);
		studentsCardPanel.add(deleteButton2);

		JScrollPane scrollPane_1 = new JScrollPane();
		sl_studentsCardPanel.putConstraint(SpringLayout.SOUTH, updateButtonBox2, -18, SpringLayout.NORTH,
				scrollPane_1);
		sl_studentsCardPanel.putConstraint(SpringLayout.NORTH, scrollPane_1, 161, SpringLayout.NORTH,
				studentsCardPanel);
		sl_studentsCardPanel.putConstraint(SpringLayout.SOUTH, scrollPane_1, -22, SpringLayout.SOUTH,
				studentsCardPanel);
		sl_studentsCardPanel.putConstraint(SpringLayout.SOUTH, deleteButton2, -18, SpringLayout.NORTH,
				scrollPane_1);
		sl_studentsCardPanel.putConstraint(SpringLayout.WEST, scrollPane_1, 10, SpringLayout.WEST, studentsCardPanel);
		sl_studentsCardPanel.putConstraint(SpringLayout.EAST, scrollPane_1, 517, SpringLayout.WEST, studentsCardPanel);
		studentsCardPanel.add(scrollPane_1);

		studentTable = new JTable();
		studentTable.setModel(studentDefaultTableModel);
		studentTable.setDefaultEditor(Object.class, null);
		studentTable.getColumnModel().getColumn(0).setPreferredWidth(29);
		studentTable.getColumnModel().getColumn(2).setPreferredWidth(45);
		studentTable.getColumnModel().getColumn(3).setPreferredWidth(56);
		studentTable.getColumnModel().getColumn(6).setPreferredWidth(59);
		studentTable.getColumnModel().getColumn(7).setPreferredWidth(38);
		studentTable.setFont(new Font("Poppins", Font.PLAIN, 10));
		studentTable.getTableHeader().setFont(new Font("Poppins", Font.BOLD, 10));
		scrollPane_1.setViewportView(studentTable);

		JPanel courseCardPanel = new JPanel();
		courseCardPanel.setBackground(new Color(255, 255, 255));
		cardPanel.add(courseCardPanel, "name_74601242877200");
		SpringLayout sl_courseCardPanel = new SpringLayout();
		courseCardPanel.setLayout(sl_courseCardPanel);

		JButton btnNewButton_2_1_4_1 = new JButton("Create");
		btnNewButton_2_1_4_1.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/create.png")));
		sl_courseCardPanel.putConstraint(SpringLayout.NORTH, btnNewButton_2_1_4_1, 25, SpringLayout.NORTH,
				courseCardPanel);
		sl_courseCardPanel.putConstraint(SpringLayout.WEST, btnNewButton_2_1_4_1, 59, SpringLayout.WEST,
				courseCardPanel);
		sl_courseCardPanel.putConstraint(SpringLayout.SOUTH, btnNewButton_2_1_4_1, 75, SpringLayout.NORTH,
				courseCardPanel);
		sl_courseCardPanel.putConstraint(SpringLayout.EAST, btnNewButton_2_1_4_1, 199, SpringLayout.WEST,
				courseCardPanel);
		btnNewButton_2_1_4_1.setOpaque(false);
		btnNewButton_2_1_4_1.setIconTextGap(15);
		btnNewButton_2_1_4_1.setFont(new Font("Poppins", Font.BOLD, 14));
		btnNewButton_2_1_4_1.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(128, 128, 255)));
		btnNewButton_2_1_4_1.setBackground(Color.WHITE);
		courseCardPanel.add(btnNewButton_2_1_4_1);

		JButton btnNewButton_2_1_4_1_1 = new JButton("Replace");
		btnNewButton_2_1_4_1_1.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/replacee.png")));
		sl_courseCardPanel.putConstraint(SpringLayout.NORTH, btnNewButton_2_1_4_1_1, 0, SpringLayout.NORTH,
				btnNewButton_2_1_4_1);
		sl_courseCardPanel.putConstraint(SpringLayout.WEST, btnNewButton_2_1_4_1_1, 95, SpringLayout.EAST,
				btnNewButton_2_1_4_1);
		sl_courseCardPanel.putConstraint(SpringLayout.SOUTH, btnNewButton_2_1_4_1_1, 0, SpringLayout.SOUTH,
				btnNewButton_2_1_4_1);
		sl_courseCardPanel.putConstraint(SpringLayout.EAST, btnNewButton_2_1_4_1_1, -73, SpringLayout.EAST,
				courseCardPanel);
		btnNewButton_2_1_4_1_1.setOpaque(false);
		btnNewButton_2_1_4_1_1.setIconTextGap(10);
		btnNewButton_2_1_4_1_1.setFont(new Font("Poppins", Font.BOLD, 14));
		btnNewButton_2_1_4_1_1.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(128, 128, 255)));
		btnNewButton_2_1_4_1_1.setBackground(Color.WHITE);
		courseCardPanel.add(btnNewButton_2_1_4_1_1);

		JButton btnNewButton_2_1_4_1_2 = new JButton("Update");
		btnNewButton_2_1_4_1_2.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/update.png")));
		sl_courseCardPanel.putConstraint(SpringLayout.NORTH, btnNewButton_2_1_4_1_2, 21, SpringLayout.SOUTH,
				btnNewButton_2_1_4_1);
		sl_courseCardPanel.putConstraint(SpringLayout.WEST, btnNewButton_2_1_4_1_2, 0, SpringLayout.WEST,
				btnNewButton_2_1_4_1);
		sl_courseCardPanel.putConstraint(SpringLayout.SOUTH, btnNewButton_2_1_4_1_2, 71, SpringLayout.SOUTH,
				btnNewButton_2_1_4_1);
		sl_courseCardPanel.putConstraint(SpringLayout.EAST, btnNewButton_2_1_4_1_2, 0, SpringLayout.EAST,
				btnNewButton_2_1_4_1);
		btnNewButton_2_1_4_1_2.setOpaque(false);
		btnNewButton_2_1_4_1_2.setIconTextGap(14);
		btnNewButton_2_1_4_1_2.setFont(new Font("Poppins", Font.BOLD, 14));
		btnNewButton_2_1_4_1_2.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(128, 128, 255)));
		btnNewButton_2_1_4_1_2.setBackground(Color.WHITE);
		courseCardPanel.add(btnNewButton_2_1_4_1_2);

		JButton btnNewButton_2_1_4_1_2_1 = new JButton("Delete");
		btnNewButton_2_1_4_1_2_1.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/delete.png")));
		sl_courseCardPanel.putConstraint(SpringLayout.NORTH, btnNewButton_2_1_4_1_2_1, -50, SpringLayout.SOUTH,
				btnNewButton_2_1_4_1_2);
		sl_courseCardPanel.putConstraint(SpringLayout.WEST, btnNewButton_2_1_4_1_2_1, -140, SpringLayout.EAST,
				btnNewButton_2_1_4_1_1);
		sl_courseCardPanel.putConstraint(SpringLayout.SOUTH, btnNewButton_2_1_4_1_2_1, 0, SpringLayout.SOUTH,
				btnNewButton_2_1_4_1_2);
		sl_courseCardPanel.putConstraint(SpringLayout.EAST, btnNewButton_2_1_4_1_2_1, 0, SpringLayout.EAST,
				btnNewButton_2_1_4_1_1);
		btnNewButton_2_1_4_1_2_1.setOpaque(false);
		btnNewButton_2_1_4_1_2_1.setIconTextGap(14);
		btnNewButton_2_1_4_1_2_1.setFont(new Font("Poppins", Font.BOLD, 14));
		btnNewButton_2_1_4_1_2_1.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(128, 128, 255)));
		btnNewButton_2_1_4_1_2_1.setBackground(Color.WHITE);
		courseCardPanel.add(btnNewButton_2_1_4_1_2_1);

		JPanel reportCardPanel = new JPanel();
		cardPanel.add(reportCardPanel, "name_76380701101000");
		SpringLayout sl_reportCardPanel = new SpringLayout();
		reportCardPanel.setLayout(sl_reportCardPanel);

		JLabel lblNewLabel_5 = new JLabel("Report");
		sl_reportCardPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 85, SpringLayout.NORTH, reportCardPanel);
		sl_reportCardPanel.putConstraint(SpringLayout.WEST, lblNewLabel_5, 127, SpringLayout.WEST, reportCardPanel);
		sl_reportCardPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_5, 173, SpringLayout.NORTH, reportCardPanel);
		sl_reportCardPanel.putConstraint(SpringLayout.EAST, lblNewLabel_5, 300, SpringLayout.WEST, reportCardPanel);
		reportCardPanel.add(lblNewLabel_5);
		splitPane_1.setDividerLocation(100);
		splitPane.setDividerLocation(200);

		AdminPanel.showTeacherDataFromDatabase();
		AdminPanel.showStudentDataFromDatabase();
	}
}
