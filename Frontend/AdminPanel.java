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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

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
	private static JTable teacherTable;
	private static JTable studentTable;
	private boolean isTeacherUpdate;
	private boolean isTeacherDelete;
	private boolean isStudentUpdate;
	private boolean isStudentDelete;
	private boolean isCourseUpdate;
	private boolean isCourseDelete;
	private boolean isModuleUpdate;
	private boolean isModuleDelete;
	private static JTable courseTable;
	private static int teacherCount = 0;
	private static int studentCount = 0;
	private static int courseCount = 0;
	private JTable moduleTable;

	private static String studentIdFromComboBox;
	static JComboBox studentIdComboBox = new JComboBox();
	private static JLabel teacherCountDisplay;
	private static JLabel studentCountDisplay;
	private static JLabel courseCountDisplay;
	private static JLabel studentNameForReport = new JLabel();
	private static JLabel studentLevelForReport = new JLabel();
	private static JLabel studentCourseForReport = new JLabel();

	private String selectedStudentNameForReport;
	private String selectedStudentLevelForReport;
	private String selectedStudentCourseForReport;
	private static String isPassFirst;
	private static String isPassSecond;
	private static String isPassThird;
	private static String isPassOverall;

	private static List<String> modulesForReportArray = new ArrayList<String>();
	
	private static JLabel firstModule = new JLabel();
	private static JLabel secondModule = new JLabel();
	private static JLabel thirdModule = new JLabel();
	
	private static int overallMarks;
	private static JLabel overallMarksLabel = new JLabel();
	private static JLabel status = new JLabel();
	
	static JButton publishButton = new JButton("Publish Result");
	
	

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

	private static DefaultTableModel courseDefaultTableModel = new DefaultTableModel(
			new Object[][] { { null, null }, { null, null }, }, new String[] { "Course ID", "Course Name" });

	private static DefaultTableModel moduleDefaultTableModel = new DefaultTableModel(
			new Object[][] { { null, null, null, null }, { null, null, null, null }, },
			new String[] { "Id", "Name", "Module Leader", "Course" });

	public static void getStudentIdForComboBox() {
		String fetchStudentIdQuery = "SELECT Id FROM `studentdetails`";
		String[] studentIdArray = new String[5];
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
				if (e.getStateChange() == 1) {
					studentIdFromComboBox = (String) e.getItem();
					int studentIdFromComboBoxInt = Integer.parseInt(studentIdFromComboBox);
					String fetchSelectedStudentName = "SELECT studentName FROM `studentdetails` WHERE Id = "
							+ studentIdFromComboBoxInt + "";
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
					
					String fetchedStudentLevelForReport="";
					String fetchSelectedStudentLevel = "SELECT level FROM `studentdetails` WHERE Id = "+studentIdFromComboBoxInt+"";
					try {
						ResultSet resultSet2 = statement.executeQuery(fetchSelectedStudentLevel);
						while(resultSet2.next()) {
							fetchedStudentLevelForReport = resultSet2.getString("level");
							studentLevelForReport.setText(fetchedStudentLevelForReport);
							
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					String fetchedStudentCourseForReport="";
					String fetchSelectedStudentCourse = "SELECT studentCourse FROM `studentdetails` WHERE Id = "+studentIdFromComboBoxInt+"";
					try {
						ResultSet resultSet3 = statement.executeQuery(fetchSelectedStudentCourse);
						while(resultSet3.next()) {
							fetchedStudentCourseForReport = resultSet3.getString("studentCourse");
							studentCourseForReport.setText(fetchedStudentCourseForReport);
							
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					String fetchSelectedStudentModules = "SELECT moduleName FROM `moduledetails` WHERE course = '"+fetchedStudentCourseForReport+"' AND inLevel = "+fetchedStudentLevelForReport+"";
					try {
						ResultSet resultSet4 = statement.executeQuery(fetchSelectedStudentModules);
						while(resultSet4.next()) {
							fetchSelectedStudentModules = resultSet4.getString("moduleName");
							modulesForReportArray.add(fetchSelectedStudentModules);
						}
						
						String fetchMarksOfFirstModule = "SELECT marks FROM `marksdetails` WHERE module = '"+modulesForReportArray.get(0)+"' AND Id = "+studentIdFromComboBoxInt+"";
						ResultSet resultSetFirstModule = statement.executeQuery(fetchMarksOfFirstModule);
						while(resultSetFirstModule.next()) {
							fetchMarksOfFirstModule = resultSetFirstModule.getString("marks");
						}
						
						String fetchMarksOfSecondModule = "SELECT marks FROM `marksdetails` WHERE module = '"+modulesForReportArray.get(1)+"' AND Id = "+studentIdFromComboBoxInt+"";
						ResultSet resultSetSecondModule = statement.executeQuery(fetchMarksOfSecondModule);
						while(resultSetSecondModule.next()) {
							fetchMarksOfSecondModule = resultSetSecondModule.getString("marks");
						}
						
						String fetchMarksOfThirdModule = "SELECT marks FROM `marksdetails` WHERE module = '"+modulesForReportArray.get(2)+"' AND Id = "+studentIdFromComboBoxInt+"";
						ResultSet resultSetThirdModule = statement.executeQuery(fetchMarksOfThirdModule);
						while(resultSetThirdModule.next()) {
							fetchMarksOfThirdModule = resultSetThirdModule.getString("marks");
						}
						firstModule.setText(modulesForReportArray.get(0)+":                          "+fetchMarksOfFirstModule+" marks");
						secondModule.setText(modulesForReportArray.get(1)+":                                "+fetchMarksOfSecondModule+" marks");
						thirdModule.setText(modulesForReportArray.get(2)+":                                   "+fetchMarksOfThirdModule+" marks");
						int fetchMarksOfFirstModuleInt = Integer.parseInt(fetchMarksOfFirstModule);
						int fetchMarksOfSecondModuleInt = Integer.parseInt(fetchMarksOfSecondModule);
						int fetchMarksOfThirdModuleInt = Integer.parseInt(fetchMarksOfThirdModule);
						String firstModuleName = modulesForReportArray.get(0);
						String secondModuleName = modulesForReportArray.get(1);
						String thirdModuleName = modulesForReportArray.get(2);
						overallMarks = (fetchMarksOfFirstModuleInt+fetchMarksOfSecondModuleInt+fetchMarksOfThirdModuleInt)*100/300;
						overallMarksLabel.setText("Percentage:           "+overallMarks+"%");
						if(fetchMarksOfFirstModuleInt>=40 && fetchMarksOfSecondModuleInt>=40 && fetchMarksOfThirdModuleInt>=40 && overallMarks>=40) {
							status.setText("Status:                        Passed");
							isPassOverall="Pass";
						}
						else {
							status.setText("Status:                        Failed");
							isPassOverall="Fail";
						}
						if(fetchMarksOfFirstModuleInt>=40) {
							isPassFirst="Pass";
						}
						else {
							isPassFirst="Fail";
						}
						if(fetchMarksOfSecondModuleInt>=40) {
							isPassSecond="Pass";
						}
						else {
							isPassSecond="Fail";
						}
						if(fetchMarksOfThirdModuleInt>=40) {
							isPassThird="Pass";
						}
						else {
							isPassThird="Fail";
						}
						modulesForReportArray.clear();
						publishButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String studentNameForMarks = studentNameForReport.getText();
								Statement firstStatement = DatabaseConnection.getStatement();
								String publishResult1 = "INSERT INTO `studentmarksdetails` (`Id`, `studentName`, `marks`, `module`,`isPass`,`overallMarks`,`isPassOverall`) "
										+ "VALUES ("+studentIdFromComboBoxInt+", '"+studentNameForMarks+"', "+fetchMarksOfFirstModuleInt+", '"+firstModuleName+"','"+isPassFirst+"',"+overallMarks+",'"+isPassOverall+"')";
								try {
									firstStatement.executeUpdate(publishResult1);
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								Statement secondStatement = DatabaseConnection.getStatement();
								String publishResult2 = "INSERT INTO `studentmarksdetails` (`Id`, `studentName`, `marks`, `module`,`isPass`,`overallMarks`,`isPassOverall`) "
										+ "VALUES ("+studentIdFromComboBoxInt+", '"+studentNameForMarks+"', "+fetchMarksOfSecondModuleInt+", '"+secondModuleName+"','"+isPassSecond+"',"+overallMarks+",'"+isPassOverall+"')";
								try {
									secondStatement.executeUpdate(publishResult2);
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								Statement thirdStatement = DatabaseConnection.getStatement();
								String publishResult3 = "INSERT INTO `studentmarksdetails` (`Id`, `studentName`, `marks`, `module`,`isPass`,`overallMarks`,`isPassOverall`) "
										+ "VALUES ("+studentIdFromComboBoxInt+", '"+studentNameForMarks+"', "+fetchMarksOfThirdModuleInt+", '"+thirdModuleName+"','"+isPassThird+"',"+overallMarks+",'"+isPassOverall+"')";
								try {
									int executeUpdate = thirdStatement.executeUpdate(publishResult3);
									if(executeUpdate==1) {
										JOptionPane.showMessageDialog(null, "Marks of '"+studentNameForMarks+"' published successfully!");
									}
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						});
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

	}

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
						studentAgeFromDB, studentPhoneFromDB });

				studentCount = studentTable.getRowCount();
			}
			studentCountDisplay.setText(
					"<html>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
							+ studentCount
							+ "<br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Students\r\n</html>\r\n\r\n\r\n");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void showModuleDataFromDatabase() {
		Statement statement = DatabaseConnection.getStatement();

		String selectQuery = "SELECT * FROM `moduledetails`";

		try {
			ResultSet resultSet = statement.executeQuery(selectQuery);
			moduleDefaultTableModel.setRowCount(0);
			while (resultSet.next()) {
				String moduleIdFromDB = resultSet.getString("moduleId");
				String moduleNameFromDB = resultSet.getString("moduleName");
				String moduleLeaderFromDB = resultSet.getString("moduleLeader");
				String courseFromDB = resultSet.getString("course");

				moduleDefaultTableModel
						.addRow(new Object[] { moduleIdFromDB, moduleNameFromDB, moduleLeaderFromDB, courseFromDB });
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void showCourseDataFromDatabase() {
		Statement statement = DatabaseConnection.getStatement();

		String selectQuery = "SELECT * FROM `coursedetails`";

		try {
			ResultSet resultSet = statement.executeQuery(selectQuery);
			courseDefaultTableModel.setRowCount(0);
			while (resultSet.next()) {
				String courseIdFromDB = resultSet.getString("courseId");
				String courseNameFromDB = resultSet.getString("courseName");

				courseDefaultTableModel.addRow(new Object[] { courseIdFromDB, courseNameFromDB });
				courseCount = courseTable.getRowCount();
			}
			courseCountDisplay.setText(
					"<html>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
							+ courseCount
							+ "<br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Courses\r\n</html>\r\n\r\n\r\n");
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
				teacherCount = teacherTable.getRowCount();
			}
			teacherCountDisplay.setText(
					"<html>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
							+ teacherCount
							+ "<br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Teachers\r\n</html>\r\n\r\n\r\n");
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
		fromAdminPanel.setBounds(330, 100, 822, 619);
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
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1, 27, SpringLayout.WEST, panel);
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
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1_1, 23, SpringLayout.SOUTH, btnNewButton_1);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1_1, 0, SpringLayout.WEST, btnNewButton);
		btnNewButton_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cardPanel.show(cardPanel, "name_74591453117300");
				cl_cardPanelTop.show(cardPanelTop, "name_90731635969300");
			}
		});
		btnNewButton_1_1.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/student.png")));
		btnNewButton_1_1.setIconTextGap(15);
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Poppins", Font.BOLD, 18));
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.setBorder(null);
		btnNewButton_1_1.setBackground(new Color(128, 128, 255));
		panel.add(btnNewButton_1_1);

		JButton logOutButton = new JButton("Log Out");
		sl_panel.putConstraint(SpringLayout.WEST, logOutButton, 0, SpringLayout.WEST, btnNewButton);
		sl_panel.putConstraint(SpringLayout.SOUTH, logOutButton, -10, SpringLayout.SOUTH, panel);
		logOutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogoutPromptAdmin logoutPrompt = new LogoutPromptAdmin();
				logoutPrompt.setVisible(true);
			}
		});
		logOutButton.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/logout.png")));
		logOutButton.setIconTextGap(16);
		logOutButton.setForeground(Color.WHITE);
		logOutButton.setFont(new Font("Poppins", Font.BOLD, 18));
		logOutButton.setBorderPainted(false);
		logOutButton.setBorder(null);
		logOutButton.setBackground(new Color(128, 128, 255));
		panel.add(logOutButton);

		JButton btnNewButton_1_1_2 = new JButton("Courses");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1_1_2, 19, SpringLayout.SOUTH, btnNewButton_1_1);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1_1_2, 0, SpringLayout.WEST, btnNewButton);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_1_1_2, -37, SpringLayout.EAST, panel);
		btnNewButton_1_1_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cardPanel.show(cardPanel, "name_74601242877200");
				cl_cardPanelTop.show(cardPanelTop, "name_90733662284300");
			}
		});
		btnNewButton_1_1_2.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/books.png")));
		btnNewButton_1_1_2.setIconTextGap(14);
		btnNewButton_1_1_2.setForeground(Color.WHITE);
		btnNewButton_1_1_2.setFont(new Font("Poppins", Font.BOLD, 18));
		btnNewButton_1_1_2.setBorderPainted(false);
		btnNewButton_1_1_2.setBorder(null);
		btnNewButton_1_1_2.setBackground(new Color(128, 128, 255));
		panel.add(btnNewButton_1_1_2);

		JButton btnNewButton_1_1_2_1 = new JButton("Report");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1_1_2_1, 22, SpringLayout.SOUTH, btnNewButton_1_1_2);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1_1_2_1, 0, SpringLayout.WEST, btnNewButton);
		btnNewButton_1_1_2_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cardPanel.show(cardPanel, "name_76380701101000");
				cl_cardPanelTop.show(cardPanelTop, "name_90735734126900");
			}
		});
		btnNewButton_1_1_2_1.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/report.png")));
		btnNewButton_1_1_2_1.setIconTextGap(18);
		btnNewButton_1_1_2_1.setForeground(Color.WHITE);
		btnNewButton_1_1_2_1.setFont(new Font("Poppins", Font.BOLD, 18));
		btnNewButton_1_1_2_1.setBorderPainted(false);
		btnNewButton_1_1_2_1.setBorder(null);
		btnNewButton_1_1_2_1.setBackground(new Color(128, 128, 255));
		panel.add(btnNewButton_1_1_2_1);

		JButton btnNewButton_1_1_2_1_1 = new JButton("Modules");
		btnNewButton_1_1_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cardPanel.show(cardPanel, "name_614472859809800");
				cl_cardPanelTop.show(cardPanelTop, "name_614518926784100");
			}
		});
		btnNewButton_1_1_2_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1_1_2_1_1, 25, SpringLayout.SOUTH,
				btnNewButton_1_1_2_1);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_1_1_2_1_1, 0, SpringLayout.EAST, btnNewButton_1);
		btnNewButton_1_1_2_1_1.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/books.png")));
		btnNewButton_1_1_2_1_1.setIconTextGap(18);
		btnNewButton_1_1_2_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_2_1_1.setFont(new Font("Poppins", Font.BOLD, 18));
		btnNewButton_1_1_2_1_1.setBorderPainted(false);
		btnNewButton_1_1_2_1_1.setBorder(null);
		btnNewButton_1_1_2_1_1.setBackground(new Color(128, 128, 255));
		panel.add(btnNewButton_1_1_2_1_1);

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

		JLabel lblManageReport = new JLabel("Generate Report");
		sl_reportCardPanelTop.putConstraint(SpringLayout.NORTH, lblManageReport, 23, SpringLayout.NORTH,
				reportCardPanelTop);
		sl_reportCardPanelTop.putConstraint(SpringLayout.WEST, lblManageReport, 51, SpringLayout.WEST,
				reportCardPanelTop);
		lblManageReport.setFont(new Font("Poppins", Font.BOLD, 30));
		reportCardPanelTop.add(lblManageReport);

		JPanel moduleCardPanelTop = new JPanel();
		moduleCardPanelTop.setBackground(new Color(255, 255, 255));
		cardPanelTop.add(moduleCardPanelTop, "name_614518926784100");
		SpringLayout sl_moduleCardPanelTop = new SpringLayout();
		moduleCardPanelTop.setLayout(sl_moduleCardPanelTop);

		JLabel lblManageModules = new JLabel("Manage Modules");
		sl_moduleCardPanelTop.putConstraint(SpringLayout.NORTH, lblManageModules, 24, SpringLayout.NORTH,
				moduleCardPanelTop);
		sl_moduleCardPanelTop.putConstraint(SpringLayout.WEST, lblManageModules, 52, SpringLayout.WEST,
				moduleCardPanelTop);
		lblManageModules.setFont(new Font("Poppins", Font.BOLD, 30));
		moduleCardPanelTop.add(lblManageModules);

		cardPanel = new JPanel();
		cardPanel.setBackground(new Color(255, 255, 255));
		splitPane_1.setRightComponent(cardPanel);
		cardPanel.setLayout(cl_cardPanel);

		JPanel dashboardCardPanel = new JPanel();
		dashboardCardPanel.setBackground(new Color(255, 255, 255));
		cardPanel.add(dashboardCardPanel, "name_74576525649000");
		SpringLayout sl_dashboardCardPanel = new SpringLayout();
		dashboardCardPanel.setLayout(sl_dashboardCardPanel);

		studentCountDisplay = new JLabel();
		sl_dashboardCardPanel.putConstraint(SpringLayout.NORTH, studentCountDisplay, 44, SpringLayout.NORTH,
				dashboardCardPanel);
		sl_dashboardCardPanel.putConstraint(SpringLayout.WEST, studentCountDisplay, 38, SpringLayout.WEST, dashboardCardPanel);
		sl_dashboardCardPanel.putConstraint(SpringLayout.SOUTH, studentCountDisplay, -275, SpringLayout.SOUTH,
				dashboardCardPanel);
		studentCountDisplay.setFont(new Font("Poppins", Font.BOLD, 24));
		studentCountDisplay.setBorder(new MatteBorder(1, 1, 5, 5, (Color) new Color(128, 128, 255)));
		studentCountDisplay.setBackground(Color.WHITE);
		dashboardCardPanel.add(studentCountDisplay);

		JPanel teachersCardPanel = new JPanel();
		teachersCardPanel.setBackground(new Color(255, 255, 255));
		cardPanel.add(teachersCardPanel, "name_74583098469500");
		SpringLayout sl_teachersCardPanel = new SpringLayout();
		teachersCardPanel.setLayout(sl_teachersCardPanel);

		JScrollPane scrollPane = new JScrollPane();
		sl_teachersCardPanel.putConstraint(SpringLayout.NORTH, scrollPane, -291, SpringLayout.SOUTH, teachersCardPanel);
		sl_teachersCardPanel.putConstraint(SpringLayout.WEST, scrollPane, -576, SpringLayout.EAST, teachersCardPanel);
		sl_teachersCardPanel.putConstraint(SpringLayout.EAST, scrollPane, -23, SpringLayout.EAST, teachersCardPanel);
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

		teacherCountDisplay = new JLabel();
		sl_dashboardCardPanel.putConstraint(SpringLayout.NORTH, teacherCountDisplay, 44, SpringLayout.NORTH, dashboardCardPanel);
		sl_dashboardCardPanel.putConstraint(SpringLayout.EAST, studentCountDisplay, -60, SpringLayout.WEST, teacherCountDisplay);
		sl_dashboardCardPanel.putConstraint(SpringLayout.WEST, teacherCountDisplay, -267, SpringLayout.EAST,
				dashboardCardPanel);
		sl_dashboardCardPanel.putConstraint(SpringLayout.EAST, teacherCountDisplay, -27, SpringLayout.EAST, dashboardCardPanel);
		teacherCountDisplay.setFont(new Font("Poppins", Font.BOLD, 24));
		teacherCountDisplay.setBorder(new MatteBorder(1, 1, 5, 5, (Color) new Color(128, 128, 255)));
		teacherCountDisplay.setBackground(Color.WHITE);
		dashboardCardPanel.add(teacherCountDisplay);

		courseCountDisplay = new JLabel();
		sl_dashboardCardPanel.putConstraint(SpringLayout.SOUTH, teacherCountDisplay, -55, SpringLayout.NORTH, courseCountDisplay);
		sl_dashboardCardPanel.putConstraint(SpringLayout.NORTH, courseCountDisplay, 55, SpringLayout.SOUTH, studentCountDisplay);
		sl_dashboardCardPanel.putConstraint(SpringLayout.WEST, courseCountDisplay, 190, SpringLayout.WEST, dashboardCardPanel);
		sl_dashboardCardPanel.putConstraint(SpringLayout.SOUTH, courseCountDisplay, -74, SpringLayout.SOUTH, dashboardCardPanel);
		sl_dashboardCardPanel.putConstraint(SpringLayout.EAST, courseCountDisplay, -175, SpringLayout.EAST, dashboardCardPanel);
		courseCountDisplay.setFont(new Font("Poppins", Font.BOLD, 24));
		courseCountDisplay.setBorder(new MatteBorder(1, 1, 5, 5, (Color) new Color(128, 128, 255)));
		courseCountDisplay.setBackground(Color.WHITE);
		dashboardCardPanel.add(courseCountDisplay);

		JButton addButton = new JButton("Add");
		sl_teachersCardPanel.putConstraint(SpringLayout.NORTH, addButton, 20, SpringLayout.NORTH, teachersCardPanel);
		sl_teachersCardPanel.putConstraint(SpringLayout.EAST, addButton, -341, SpringLayout.EAST, teachersCardPanel);
		addButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		sl_teachersCardPanel.putConstraint(SpringLayout.WEST, addButton, 60, SpringLayout.WEST, teachersCardPanel);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTeacher createTeacher = new AddTeacher();
				createTeacher.setVisible(true);
			}
		});
		addButton.setIconTextGap(12);
		addButton.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/create.png")));
		addButton.setBackground(new Color(255, 255, 255));
		addButton.setOpaque(false);
		addButton.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(128, 128, 255)));
		addButton.setFont(new Font("Poppins", Font.BOLD, 14));
		teachersCardPanel.add(addButton);
		JButton deleteButton = new JButton("Delete");
		sl_teachersCardPanel.putConstraint(SpringLayout.SOUTH, deleteButton, -33, SpringLayout.NORTH, scrollPane);
		sl_teachersCardPanel.putConstraint(SpringLayout.EAST, deleteButton, -61, SpringLayout.EAST, teachersCardPanel);
		JButton updateButtonBox = new JButton("Update");
		sl_teachersCardPanel.putConstraint(SpringLayout.NORTH, updateButtonBox, 92, SpringLayout.NORTH, teachersCardPanel);
		sl_teachersCardPanel.putConstraint(SpringLayout.SOUTH, updateButtonBox, -33, SpringLayout.NORTH, scrollPane);
		sl_teachersCardPanel.putConstraint(SpringLayout.WEST, deleteButton, 74, SpringLayout.EAST, updateButtonBox);
		sl_teachersCardPanel.putConstraint(SpringLayout.SOUTH, addButton, -23, SpringLayout.NORTH, updateButtonBox);
		sl_teachersCardPanel.putConstraint(SpringLayout.EAST, updateButtonBox, -339, SpringLayout.EAST,
				teachersCardPanel);
		JButton stopButton = new JButton("Stop");
		sl_teachersCardPanel.putConstraint(SpringLayout.NORTH, deleteButton, 23, SpringLayout.SOUTH, stopButton);
		sl_teachersCardPanel.putConstraint(SpringLayout.SOUTH, stopButton, -396, SpringLayout.SOUTH, teachersCardPanel);
		sl_teachersCardPanel.putConstraint(SpringLayout.NORTH, stopButton, 20, SpringLayout.NORTH, teachersCardPanel);
		sl_teachersCardPanel.putConstraint(SpringLayout.WEST, stopButton, 76, SpringLayout.EAST, addButton);
		sl_teachersCardPanel.putConstraint(SpringLayout.EAST, stopButton, -61, SpringLayout.EAST, teachersCardPanel);

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

//							for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons
//									.hasMoreElements();) {
//								AbstractButton button = buttons.nextElement();
//								if (isPartTime.equals(button.getText())) {
//									button.setText("0");
//								}
//							}
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
		updateButtonBox.setIconTextGap(14);
		updateButtonBox.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/update.png")));
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
		sl_studentsCardPanel.putConstraint(SpringLayout.SOUTH, addButton2, -393, SpringLayout.SOUTH, studentsCardPanel);
		sl_studentsCardPanel.putConstraint(SpringLayout.EAST, addButton2, 264, SpringLayout.WEST, studentsCardPanel);
		addButton2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				AddStudent addStudent = new AddStudent();
				addStudent.setVisible(true);
			}
		});
		addButton2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		sl_studentsCardPanel.putConstraint(SpringLayout.NORTH, addButton2, 21, SpringLayout.NORTH, studentsCardPanel);
		sl_studentsCardPanel.putConstraint(SpringLayout.WEST, addButton2, 58, SpringLayout.WEST, studentsCardPanel);
		addButton2.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/create.png")));
		addButton2.setOpaque(false);
		addButton2.setIconTextGap(12);
		addButton2.setFont(new Font("Poppins", Font.BOLD, 14));
		addButton2.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(128, 128, 255)));
		addButton2.setBackground(Color.WHITE);
		studentsCardPanel.add(addButton2);
		studentTable = new JTable();

		JButton stopButton2 = new JButton("Stop");
		sl_studentsCardPanel.putConstraint(SpringLayout.NORTH, stopButton2, 21, SpringLayout.NORTH, studentsCardPanel);
		sl_studentsCardPanel.putConstraint(SpringLayout.WEST, stopButton2, -270, SpringLayout.EAST, studentsCardPanel);
		JButton deleteButton2 = new JButton("Delete");
		sl_studentsCardPanel.putConstraint(SpringLayout.SOUTH, stopButton2, -21, SpringLayout.NORTH, deleteButton2);
		sl_studentsCardPanel.putConstraint(SpringLayout.NORTH, deleteButton2, 93, SpringLayout.NORTH, studentsCardPanel);
		sl_studentsCardPanel.putConstraint(SpringLayout.EAST, deleteButton2, -64, SpringLayout.EAST, studentsCardPanel);
		JButton updateButtonBox2 = new JButton("Update");
		sl_studentsCardPanel.putConstraint(SpringLayout.WEST, deleteButton2, 71, SpringLayout.EAST, updateButtonBox2);
		sl_studentsCardPanel.putConstraint(SpringLayout.NORTH, updateButtonBox2, 21, SpringLayout.SOUTH, addButton2);
		sl_studentsCardPanel.putConstraint(SpringLayout.WEST, updateButtonBox2, 58, SpringLayout.WEST, studentsCardPanel);
		sl_studentsCardPanel.putConstraint(SpringLayout.EAST, updateButtonBox2, 0, SpringLayout.EAST, addButton2);
		sl_studentsCardPanel.putConstraint(SpringLayout.EAST, stopButton2, -64, SpringLayout.EAST, studentsCardPanel);
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
				int n = JOptionPane.showOptionDialog(null, "Do you want to enter update mode?", "Update Student",
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				if (n == 0) {
					isStudentUpdate = true;
					isStudentDelete = false;
					JOptionPane.showMessageDialog(null, "Entered Update Mode!");
					addButton2.setVisible(false);
					deleteButton2.setVisible(false);
					stopButton2.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/stop.png")));
					stopButton2.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(255, 0, 0)));
					studentTable.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if (isStudentUpdate == true && isStudentDelete == false) {
								AddStudent updateStudent = new AddStudent();
								updateStudent.setVisible(true);
								updateStudent.setTitle("Update Student | Course Management System");
								JLabel heading = updateStudent.getAddStudentHeading();
								heading.setText("Update Student");
								JButton updateButton = updateStudent.getAddStudentButton();
								updateButton.setText("Update");
								String studentName = "";
								int studentLevel = 0;
								int studentSemester = 0;
								String studentGroup = "";
								String studentAddress = "";
								String studentCourse = "";
								int studentAge = 0;
								int uniId = 0;
								BigDecimal studentPhone = new BigDecimal(0);
								for (int columnIndex = 0; columnIndex < studentTable.getColumnCount(); columnIndex++) {
									if (uniId == 0) {
										uniId = (int) studentTable.getValueAt(studentTable.getSelectedRow(),
												columnIndex);
									} else if (studentName.isEmpty()) {
										studentName = (String) studentTable.getValueAt(studentTable.getSelectedRow(),
												columnIndex);
									} else if (studentLevel == 0) {
										studentLevel = (int) studentTable.getValueAt(studentTable.getSelectedRow(),
												columnIndex);
									} else if (studentSemester == 0) {
										studentSemester = (int) studentTable.getValueAt(studentTable.getSelectedRow(),
												columnIndex);
									} else if (studentGroup.isEmpty()) {
										studentGroup = (String) studentTable.getValueAt(studentTable.getSelectedRow(),
												columnIndex);
									} else if (studentAddress.isEmpty()) {
										studentAddress = (String) studentTable.getValueAt(studentTable.getSelectedRow(),
												columnIndex);
									} else if (studentCourse.isEmpty()) {
										studentCourse = (String) studentTable.getValueAt(studentTable.getSelectedRow(),
												columnIndex);
									} else if (studentAge == 0) {
										studentAge = (int) studentTable.getValueAt(studentTable.getSelectedRow(),
												columnIndex);
									} else {
										studentPhone = (BigDecimal) studentTable
												.getValueAt(studentTable.getSelectedRow(), columnIndex);
									}
								}
								updateStudent.getUniIdtextField().setText(String.valueOf(uniId));
								updateStudent.getStudentFullNameTextField().setText(studentName);
								updateStudent.getStudentGroupTextField().setText(studentGroup);
								updateStudent.getStudentAddressTextField().setText(studentAddress);
								updateStudent.getStudentAgeTextField().setText(String.valueOf(studentAge));
								updateStudent.getStudentPhoneTextField().setText(studentPhone.toString());

								updateButton.setActionCommand("Update");
								updateButton.addActionListener(new ActionListener() {

									@Override
									public void actionPerformed(ActionEvent e) {
										// TODO Auto-generated method stub
										if (e.getActionCommand().equals("Update")) {
											JTextField uniIdTextField = updateStudent.getUniIdtextField();
											JTextField studentFullNameTextField = updateStudent
													.getStudentFullNameTextField();
											String studentLevel = updateStudent.getStudentLevel();
											String studentSemester = updateStudent.getStudentSemester();
											JTextField studentGroupTextField = updateStudent.getStudentGroupTextField();
											JTextField studentAddressField = updateStudent.getStudentAddressTextField();
											JTextField studentAgeField = updateStudent.getStudentAgeTextField();
											JTextField studentPhoneTextField = updateStudent.getStudentPhoneTextField();

											String updatedUniId = uniIdTextField.getText().trim();
											String updatedStudentName = studentFullNameTextField.getText().trim();
											String updatedStudentLevel = studentLevel.trim();
											String updatedStudentSemester = studentSemester.trim();
											String updatedStudentGroup = studentGroupTextField.getText().trim();
											String updatedStudentAddress = studentAddressField.getText().trim();
											String updatedStudentCourse = updateStudent.getCourseFromComboBox();
											String updatedStudentAge = studentAgeField.getText().trim();
											String updatedStudentPhone = studentPhoneTextField.getText().trim();

											int updateId = (int) studentTable.getValueAt(studentTable.getSelectedRow(),
													0);

											int updatedUniIdInt = Integer.parseInt(updatedUniId);

											String updateQuery = "UPDATE `studentdetails` SET " + "`Id` = '"
													+ updatedUniIdInt + "', " + "`studentName` = '" + updatedStudentName
													+ "', " + "`level` = '" + updatedStudentLevel + "', "
													+ "`semester` = '" + updatedStudentSemester + "', "
													+ "`studentGroup` = '" + updatedStudentGroup + "', "
													+ "`studentAddress` = '" + updatedStudentAddress + "', "
													+ "`studentCourse` = '" + updatedStudentCourse + "', "
													+ "`studentAge` = '" + updatedStudentAge + "', "
													+ "`studentPhone` = '" + updatedStudentPhone + "' "
													+ "WHERE `studentdetails`.`Id` = " + updateId + "";
											Statement statement = DatabaseConnection.getStatement();
											try {
												int updateSuccess = statement.executeUpdate(updateQuery);
												if (updateSuccess == 1) {
													JOptionPane.showMessageDialog(null, "Student Data Updated");
													updateStudent.dispose();
													AdminPanel.showStudentDataFromDatabase();
													AdminPanel.getStudentIdForComboBox();
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
					studentTable.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if (isStudentUpdate == false && isStudentDelete == true) {
								int deleteId = (int) studentTable.getValueAt(studentTable.getSelectedRow(), 0);
								int confirmation = JOptionPane.showOptionDialog(null,
										"Delete student with Id: " + deleteId + "?", "Delete Student",
										JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options,
										options[0]);
								if (confirmation == 0) {
									Statement statement = DatabaseConnection.getStatement();
									String deleteQuery = "DELETE FROM `studentdetails` WHERE `studentdetails`.`Id` = "
											+ deleteId + "";
									try {
										int deleteSuccess = statement.executeUpdate(deleteQuery);
										
										if (deleteSuccess == 1) {
											JOptionPane.showMessageDialog(null, "Student Data Deleted");
										}
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									AdminPanel.showStudentDataFromDatabase();
								}
							}
						}
					});

				}

			}
		});
		deleteButton2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		deleteButton2.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/delete.png")));
		deleteButton2.setOpaque(false);
		deleteButton2.setIconTextGap(14);
		deleteButton2.setFont(new Font("Poppins", Font.BOLD, 14));
		deleteButton2.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(128, 128, 255)));
		deleteButton2.setBackground(Color.WHITE);
		studentsCardPanel.add(deleteButton2);

		JScrollPane scrollPane_1 = new JScrollPane();
		sl_studentsCardPanel.putConstraint(SpringLayout.SOUTH, deleteButton2, -18, SpringLayout.NORTH, scrollPane_1);
		sl_studentsCardPanel.putConstraint(SpringLayout.SOUTH, updateButtonBox2, -18, SpringLayout.NORTH, scrollPane_1);
		sl_studentsCardPanel.putConstraint(SpringLayout.EAST, scrollPane_1, 595, SpringLayout.WEST, studentsCardPanel);
		sl_studentsCardPanel.putConstraint(SpringLayout.NORTH, scrollPane_1, 161, SpringLayout.NORTH,
				studentsCardPanel);
		sl_studentsCardPanel.putConstraint(SpringLayout.SOUTH, scrollPane_1, -22, SpringLayout.SOUTH,
				studentsCardPanel);
		sl_studentsCardPanel.putConstraint(SpringLayout.WEST, scrollPane_1, 10, SpringLayout.WEST, studentsCardPanel);
		studentsCardPanel.add(scrollPane_1);

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

		JButton addButton3 = new JButton("Add");
		sl_courseCardPanel.putConstraint(SpringLayout.EAST, addButton3, 260, SpringLayout.WEST, courseCardPanel);
		addButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCourse addCourse = new AddCourse();
				addCourse.setVisible(true);
			}
		});
		addButton3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addButton3.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/create.png")));
		sl_courseCardPanel.putConstraint(SpringLayout.NORTH, addButton3, 25, SpringLayout.NORTH, courseCardPanel);
		sl_courseCardPanel.putConstraint(SpringLayout.WEST, addButton3, 59, SpringLayout.WEST, courseCardPanel);
		sl_courseCardPanel.putConstraint(SpringLayout.SOUTH, addButton3, 75, SpringLayout.NORTH, courseCardPanel);
		addButton3.setOpaque(false);
		addButton3.setIconTextGap(17);
		addButton3.setFont(new Font("Poppins", Font.BOLD, 14));
		addButton3.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(128, 128, 255)));
		addButton3.setBackground(Color.WHITE);
		courseCardPanel.add(addButton3);

		JButton stopButton3 = new JButton("Stop");
		sl_courseCardPanel.putConstraint(SpringLayout.NORTH, stopButton3, 25, SpringLayout.NORTH, courseCardPanel);
		JButton updateBoxButton3 = new JButton("Update");
		sl_courseCardPanel.putConstraint(SpringLayout.NORTH, updateBoxButton3, 21, SpringLayout.SOUTH, addButton3);
		sl_courseCardPanel.putConstraint(SpringLayout.WEST, updateBoxButton3, 59, SpringLayout.WEST, courseCardPanel);
		sl_courseCardPanel.putConstraint(SpringLayout.EAST, updateBoxButton3, 0, SpringLayout.EAST, addButton3);
		JButton deleteButton3 = new JButton("Delete");
		sl_courseCardPanel.putConstraint(SpringLayout.NORTH, deleteButton3, 96, SpringLayout.NORTH, courseCardPanel);
		sl_courseCardPanel.putConstraint(SpringLayout.WEST, deleteButton3, 78, SpringLayout.EAST, updateBoxButton3);
		sl_courseCardPanel.putConstraint(SpringLayout.EAST, deleteButton3, -66, SpringLayout.EAST, courseCardPanel);
		sl_courseCardPanel.putConstraint(SpringLayout.WEST, stopButton3, 0, SpringLayout.WEST, deleteButton3);
		sl_courseCardPanel.putConstraint(SpringLayout.SOUTH, stopButton3, -21, SpringLayout.NORTH, deleteButton3);
		sl_courseCardPanel.putConstraint(SpringLayout.EAST, stopButton3, 0, SpringLayout.EAST, deleteButton3);
		deleteButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = { "Yes", "No" };
				int n = JOptionPane.showOptionDialog(null, "Do you want to enter delete mode?", "Delete Course",
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				if (n == 0) {
					isCourseUpdate = false;
					isCourseDelete = true;
					JOptionPane.showMessageDialog(null, "Entered Delete Mode!");
					addButton3.setVisible(false);
					updateBoxButton3.setVisible(false);
					stopButton3.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/stop.png")));
					stopButton3.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(255, 0, 0)));
					courseTable.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if (isCourseUpdate == false && isCourseDelete == true) {
								String deleteId = (String) courseTable.getValueAt(courseTable.getSelectedRow(), 0);
								int confirmation = JOptionPane.showOptionDialog(null,
										"Delete Course with Id: " + deleteId + "?", "Delete Course",
										JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options,
										options[0]);
								if (confirmation == 0) {
									Statement statement = DatabaseConnection.getStatement();
									String deleteQuery = "DELETE FROM `coursedetails` WHERE `coursedetails`.`courseId` = '"
											+ deleteId + "'";
									try {
										int deleteSuccess = statement.executeUpdate(deleteQuery);
										if (deleteSuccess == 1) {
											JOptionPane.showMessageDialog(null, "Data Deleted");
										}
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									AdminPanel.showCourseDataFromDatabase();
								}
							}
						}
					});
				}
			}
		});
		stopButton3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		stopButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isCourseUpdate = false;
				isCourseDelete = false;
				addButton3.setVisible(true);
				deleteButton3.setVisible(true);
				updateBoxButton3.setVisible(true);
				stopButton3.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/stop_inactive.png")));
				stopButton3.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(128, 128, 128)));
			}
		});
		stopButton3.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/stop_inactive.png")));
		stopButton3.setOpaque(false);
		stopButton3.setIconTextGap(10);
		stopButton3.setFont(new Font("Poppins", Font.BOLD, 14));
		stopButton3.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(128, 128, 128)));
		stopButton3.setBackground(Color.WHITE);
		courseCardPanel.add(stopButton3);

		updateBoxButton3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		updateBoxButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = { "Yes", "No" };
				int n = JOptionPane.showOptionDialog(null, "Do you want to enter update mode?", "Update Course",
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				if (n == 0) {
					isCourseUpdate = true;
					isCourseDelete = false;
					JOptionPane.showMessageDialog(null, "Entered Update Mode!");
					addButton3.setVisible(false);
					deleteButton3.setVisible(false);
					stopButton3.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/stop.png")));
					stopButton3.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(255, 0, 0)));
					courseTable.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if (isCourseUpdate == true && isCourseDelete == false) {
								AddCourse updateCourse = new AddCourse();
								updateCourse.setVisible(true);
								updateCourse.setTitle("Update Course | Course Management System");
								JLabel heading = updateCourse.getCourseHeading();
								heading.setText("Update Course");
								JButton updateButton = updateCourse.getAddButton();
								updateButton.setText("Update");

								String courseId = "";
								String courseName = "";
								for (int columnIndex = 0; columnIndex < courseTable.getColumnCount(); columnIndex++) {
									if (courseId.isEmpty()) {
										courseId = (String) courseTable.getValueAt(courseTable.getSelectedRow(),
												columnIndex);
									} else {
										courseName = (String) courseTable.getValueAt(courseTable.getSelectedRow(),
												columnIndex);
									}
								}
								updateCourse.getCourseIdTextField().setText(courseId);
								updateCourse.getCourseNameTextField().setText(courseName);

								updateButton.setActionCommand("Update");
								updateButton.addActionListener(new ActionListener() {

									@Override
									public void actionPerformed(ActionEvent e) {
										// TODO Auto-generated method stub
										if (e.getActionCommand().equals("Update")) {
											JTextField courseIdTextField = updateCourse.getCourseIdTextField();
											JTextField courseNameTextField = updateCourse.getCourseNameTextField();

											String updatedCourseId = courseIdTextField.getText().trim();
											String updatedCourseName = courseNameTextField.getText().trim();

											String updateId = (String) courseTable
													.getValueAt(courseTable.getSelectedRow(), 0);

											String updateQuery = "UPDATE `coursedetails` SET `" + "courseId` = '"
													+ updatedCourseId + "', " + "`courseName` = '" + updatedCourseName
													+ "' " + "WHERE `coursedetails`.`courseId` = '" + updateId + "'";
											Statement statement = DatabaseConnection.getStatement();
											try {
												int updateSuccess = statement.executeUpdate(updateQuery);
												if (updateSuccess == 1) {
													JOptionPane.showMessageDialog(null, "Data Updated");
													updateCourse.dispose();
													AdminPanel.showCourseDataFromDatabase();
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
		updateBoxButton3.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/update.png")));
		updateBoxButton3.setOpaque(false);
		updateBoxButton3.setIconTextGap(14);
		updateBoxButton3.setFont(new Font("Poppins", Font.BOLD, 14));
		updateBoxButton3.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(128, 128, 255)));
		updateBoxButton3.setBackground(Color.WHITE);
		courseCardPanel.add(updateBoxButton3);

		deleteButton3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		deleteButton3.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/delete.png")));
		deleteButton3.setOpaque(false);
		deleteButton3.setIconTextGap(14);
		deleteButton3.setFont(new Font("Poppins", Font.BOLD, 14));
		deleteButton3.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(128, 128, 255)));
		deleteButton3.setBackground(Color.WHITE);
		courseCardPanel.add(deleteButton3);

		JScrollPane scrollPane_2 = new JScrollPane();
		sl_courseCardPanel.putConstraint(SpringLayout.SOUTH, deleteButton3, -24, SpringLayout.NORTH, scrollPane_2);
		sl_courseCardPanel.putConstraint(SpringLayout.SOUTH, updateBoxButton3, -30, SpringLayout.NORTH, scrollPane_2);
		sl_courseCardPanel.putConstraint(SpringLayout.NORTH, scrollPane_2, 176, SpringLayout.NORTH, courseCardPanel);
		sl_courseCardPanel.putConstraint(SpringLayout.WEST, scrollPane_2, 59, SpringLayout.WEST, courseCardPanel);
		sl_courseCardPanel.putConstraint(SpringLayout.EAST, scrollPane_2, -66, SpringLayout.EAST, courseCardPanel);
		sl_courseCardPanel.putConstraint(SpringLayout.SOUTH, scrollPane_2, -46, SpringLayout.SOUTH, courseCardPanel);
		courseCardPanel.add(scrollPane_2);

		courseTable = new JTable();
		courseTable.setDefaultEditor(Object.class, null);
		courseTable.setModel(courseDefaultTableModel);
		courseTable.setFont(new Font("Poppins", Font.PLAIN, 10));
		courseTable.getTableHeader().setFont(new Font("Poppins", Font.BOLD, 12));
		scrollPane_2.setViewportView(courseTable);

		JPanel reportCardPanel = new JPanel();
		reportCardPanel.setBackground(new Color(255, 255, 255));
		cardPanel.add(reportCardPanel, "name_76380701101000");
		SpringLayout sl_reportCardPanel = new SpringLayout();
		sl_reportCardPanel.putConstraint(SpringLayout.NORTH, overallMarksLabel, 6, SpringLayout.SOUTH, thirdModule);
		
				sl_reportCardPanel.putConstraint(SpringLayout.NORTH, publishButton, -65, SpringLayout.SOUTH, reportCardPanel);
		sl_reportCardPanel.putConstraint(SpringLayout.WEST, publishButton, 275, SpringLayout.WEST, reportCardPanel);
		sl_reportCardPanel.putConstraint(SpringLayout.SOUTH, publishButton, -10, SpringLayout.SOUTH, reportCardPanel);
		sl_reportCardPanel.putConstraint(SpringLayout.EAST, publishButton, -30, SpringLayout.EAST, reportCardPanel);
		sl_reportCardPanel.putConstraint(SpringLayout.NORTH, thirdModule, 6, SpringLayout.SOUTH, secondModule);
		sl_reportCardPanel.putConstraint(SpringLayout.NORTH, secondModule, 6, SpringLayout.SOUTH, firstModule);
		reportCardPanel.setLayout(sl_reportCardPanel);

		JLabel lblNewLabel_1 = new JLabel("Student Id:");
		sl_reportCardPanel.putConstraint(SpringLayout.EAST, status, 255, SpringLayout.WEST, lblNewLabel_1);
		sl_reportCardPanel.putConstraint(SpringLayout.WEST, overallMarksLabel, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_reportCardPanel.putConstraint(SpringLayout.WEST, thirdModule, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_reportCardPanel.putConstraint(SpringLayout.WEST, secondModule, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_reportCardPanel.putConstraint(SpringLayout.WEST, firstModule, 0, SpringLayout.WEST, lblNewLabel_1);
		studentIdComboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		studentIdComboBox.setModel(new DefaultComboBoxModel(new String[] { "Select University Id" }));
		sl_reportCardPanel.putConstraint(SpringLayout.NORTH, studentIdComboBox, 2, SpringLayout.NORTH, lblNewLabel_1);
		sl_reportCardPanel.putConstraint(SpringLayout.WEST, studentIdComboBox, 33, SpringLayout.EAST, lblNewLabel_1);
		sl_reportCardPanel.putConstraint(SpringLayout.SOUTH, studentIdComboBox, 32, SpringLayout.NORTH, lblNewLabel_1);
		sl_reportCardPanel.putConstraint(SpringLayout.EAST, studentIdComboBox, 320, SpringLayout.EAST, lblNewLabel_1);
		sl_reportCardPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 28, SpringLayout.NORTH, reportCardPanel);
		sl_reportCardPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 54, SpringLayout.WEST, reportCardPanel);
		sl_reportCardPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 63, SpringLayout.NORTH, reportCardPanel);
		sl_reportCardPanel.putConstraint(SpringLayout.EAST, lblNewLabel_1, 155, SpringLayout.WEST, reportCardPanel);
		lblNewLabel_1.setFont(new Font("Poppins", Font.BOLD, 16));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		reportCardPanel.add(lblNewLabel_1);
		studentIdComboBox.setFont(new Font("Poppins", Font.PLAIN, 16));
		studentIdComboBox
				.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 255), new Color(128, 128, 255),

						new Color(255, 255, 255), new Color(255, 255, 255)));
		studentIdComboBox.setBackground(Color.WHITE);
		reportCardPanel.add(studentIdComboBox);

		JLabel lblNewLabel_1_1 = new JLabel("Student Name:");
		sl_reportCardPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_reportCardPanel.putConstraint(SpringLayout.EAST, lblNewLabel_1_1, 130, SpringLayout.WEST, lblNewLabel_1);
		lblNewLabel_1_1.setFont(new Font("Poppins", Font.BOLD, 16));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		reportCardPanel.add(lblNewLabel_1_1);

		studentNameForReport = new JLabel();
		sl_reportCardPanel.putConstraint(SpringLayout.NORTH, studentNameForReport, 86, SpringLayout.NORTH, reportCardPanel);
		sl_reportCardPanel.putConstraint(SpringLayout.WEST, studentNameForReport, 0, SpringLayout.WEST, studentIdComboBox);
		studentNameForReport.setFont(new Font("Poppins", Font.BOLD, 16));
		studentNameForReport.setBackground(Color.WHITE);
		reportCardPanel.add(studentNameForReport);

		JLabel lblNewLabel_1_1_1 = new JLabel("Level:");
		sl_reportCardPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1, 133, SpringLayout.NORTH, reportCardPanel);
		sl_reportCardPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_1, -22, SpringLayout.NORTH, lblNewLabel_1_1_1);
		sl_reportCardPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1, 0, SpringLayout.WEST, lblNewLabel_1);
		lblNewLabel_1_1_1.setFont(new Font("Poppins", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBackground(Color.WHITE);
		reportCardPanel.add(lblNewLabel_1_1_1);

		studentLevelForReport = new JLabel();
		sl_reportCardPanel.putConstraint(SpringLayout.NORTH, studentLevelForReport, 128, SpringLayout.NORTH, reportCardPanel);
		sl_reportCardPanel.putConstraint(SpringLayout.WEST, studentLevelForReport, 0, SpringLayout.WEST,
				studentIdComboBox);
		studentLevelForReport.setFont(new Font("Poppins", Font.BOLD, 16));
		studentLevelForReport.setBackground(Color.WHITE);
		reportCardPanel.add(studentLevelForReport);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Course:");
		sl_reportCardPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1_1, 0, SpringLayout.WEST, lblNewLabel_1);
		lblNewLabel_1_1_1_1.setFont(new Font("Poppins", Font.BOLD, 16));
		lblNewLabel_1_1_1_1.setBackground(Color.WHITE);
		reportCardPanel.add(lblNewLabel_1_1_1_1);

		studentCourseForReport = new JLabel();
		sl_reportCardPanel.putConstraint(SpringLayout.NORTH, studentCourseForReport, 173, SpringLayout.NORTH, reportCardPanel);
		sl_reportCardPanel.putConstraint(SpringLayout.WEST, studentCourseForReport, 0, SpringLayout.WEST, studentIdComboBox);
		studentCourseForReport.setFont(new Font("Poppins", Font.BOLD, 16));
		studentCourseForReport.setBackground(Color.WHITE);
		reportCardPanel.add(studentCourseForReport);
		publishButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		publishButton.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/create.png")));
		publishButton.setOpaque(false);
		publishButton.setIconTextGap(17);
		publishButton.setFont(new Font("Poppins", Font.BOLD, 18));
		publishButton.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(128, 128, 255)));
		publishButton.setBackground(Color.WHITE);
		reportCardPanel.add(publishButton);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Marks:");
		sl_reportCardPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1_1_1, 204, SpringLayout.NORTH, reportCardPanel);
		sl_reportCardPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_1_1_1, -6, SpringLayout.NORTH, lblNewLabel_1_1_1_1_1);
		sl_reportCardPanel.putConstraint(SpringLayout.NORTH, firstModule, 6, SpringLayout.SOUTH, lblNewLabel_1_1_1_1_1);
		sl_reportCardPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1_1_1, 0, SpringLayout.WEST, lblNewLabel_1);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Poppins", Font.BOLD, 16));
		lblNewLabel_1_1_1_1_1.setBackground(Color.WHITE);
		reportCardPanel.add(lblNewLabel_1_1_1_1_1);
		firstModule.setFont(new Font("Poppins", Font.BOLD, 16));
		firstModule.setBackground(Color.WHITE);
		reportCardPanel.add(firstModule);
		secondModule.setFont(new Font("Poppins", Font.BOLD, 16));
		secondModule.setBackground(Color.WHITE);
		reportCardPanel.add(secondModule);
		thirdModule.setFont(new Font("Poppins", Font.BOLD, 16));
		thirdModule.setBackground(Color.WHITE);
		reportCardPanel.add(thirdModule);
		overallMarksLabel.setFont(new Font("Poppins", Font.BOLD, 16));
		overallMarksLabel.setBackground(Color.WHITE);
		reportCardPanel.add(overallMarksLabel);
		
		
		sl_reportCardPanel.putConstraint(SpringLayout.NORTH, status, 6, SpringLayout.SOUTH, overallMarksLabel);
		sl_reportCardPanel.putConstraint(SpringLayout.WEST, status, 0, SpringLayout.WEST, lblNewLabel_1);
		status.setFont(new Font("Poppins", Font.BOLD, 16));
		status.setBackground(Color.WHITE);
		reportCardPanel.add(status);

		JPanel moduleCardPanel = new JPanel();
		moduleCardPanel.setBackground(new Color(255, 255, 255));
		cardPanel.add(moduleCardPanel, "name_614472859809800");
		SpringLayout sl_moduleCardPanel = new SpringLayout();
		moduleCardPanel.setLayout(sl_moduleCardPanel);

		JButton addButton4 = new JButton("Add");
		sl_moduleCardPanel.putConstraint(SpringLayout.EAST, addButton4, 252, SpringLayout.WEST, moduleCardPanel);
		addButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddModule addModule = new AddModule();
				addModule.setVisible(true);
			}
		});
		addButton4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addButton4.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/create.png")));
		sl_moduleCardPanel.putConstraint(SpringLayout.NORTH, addButton4, 35, SpringLayout.NORTH, moduleCardPanel);
		sl_moduleCardPanel.putConstraint(SpringLayout.WEST, addButton4, 51, SpringLayout.WEST, moduleCardPanel);
		sl_moduleCardPanel.putConstraint(SpringLayout.SOUTH, addButton4, 86, SpringLayout.NORTH, moduleCardPanel);
		addButton4.setOpaque(false);
		addButton4.setIconTextGap(17);
		addButton4.setFont(new Font("Poppins", Font.BOLD, 14));
		addButton4.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(128, 128, 255)));
		addButton4.setBackground(Color.WHITE);
		moduleCardPanel.add(addButton4);

		JButton updateBoxButton4 = new JButton("Update");
		sl_moduleCardPanel.putConstraint(SpringLayout.NORTH, updateBoxButton4, 32, SpringLayout.SOUTH, addButton4);
		sl_moduleCardPanel.putConstraint(SpringLayout.WEST, updateBoxButton4, 51, SpringLayout.WEST, moduleCardPanel);
		JButton stopButton4 = new JButton("Stop");
		sl_moduleCardPanel.putConstraint(SpringLayout.NORTH, stopButton4, 35, SpringLayout.NORTH, moduleCardPanel);
		sl_moduleCardPanel.putConstraint(SpringLayout.WEST, stopButton4, -268, SpringLayout.EAST, moduleCardPanel);
		JButton deleteButton4 = new JButton("Delete");
		sl_moduleCardPanel.putConstraint(SpringLayout.NORTH, deleteButton4, 118, SpringLayout.NORTH, moduleCardPanel);
		sl_moduleCardPanel.putConstraint(SpringLayout.EAST, updateBoxButton4, -85, SpringLayout.WEST, deleteButton4);
		sl_moduleCardPanel.putConstraint(SpringLayout.SOUTH, stopButton4, -32, SpringLayout.NORTH, deleteButton4);
		sl_moduleCardPanel.putConstraint(SpringLayout.WEST, deleteButton4, 0, SpringLayout.WEST, stopButton4);
		sl_moduleCardPanel.putConstraint(SpringLayout.EAST, deleteButton4, -67, SpringLayout.EAST, moduleCardPanel);
		deleteButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = { "Yes", "No" };
				int n = JOptionPane.showOptionDialog(null, "Do you want to enter delete mode?", "Delete Module",
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				if (n == 0) {
					isModuleUpdate = false;
					isModuleDelete = true;
					JOptionPane.showMessageDialog(null, "Entered Delete Mode!");
					addButton4.setVisible(false);
					updateBoxButton4.setVisible(false);
					stopButton4.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/stop.png")));
					stopButton4.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(255, 0, 0)));
					moduleTable.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if (isModuleUpdate == false && isModuleDelete == true) {
								String deleteId = (String) moduleTable.getValueAt(moduleTable.getSelectedRow(), 0);
								int confirmation = JOptionPane.showOptionDialog(null,
										"Delete Module with Id: " + deleteId + "?", "Delete Course",
										JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options,
										options[0]);
								if (confirmation == 0) {
									Statement statement = DatabaseConnection.getStatement();
									String deleteQuery = "DELETE FROM `moduledetails` WHERE `moduledetails`.`moduleId` = '"
											+ deleteId + "'";
									try {
										int deleteSuccess = statement.executeUpdate(deleteQuery);
										if (deleteSuccess == 1) {
											JOptionPane.showMessageDialog(null, "Data Deleted");
										}
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									AdminPanel.showModuleDataFromDatabase();
								}
							}
						}
					});
				}
			}
		});

		stopButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isModuleUpdate = false;
				isModuleDelete = false;
				addButton4.setVisible(true);
				deleteButton4.setVisible(true);
				updateBoxButton4.setVisible(true);
				stopButton4.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/stop_inactive.png")));
				stopButton4.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(128, 128, 128)));
			}
		});
		stopButton4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		stopButton4.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/stop_inactive.png")));
		sl_moduleCardPanel.putConstraint(SpringLayout.EAST, stopButton4, -67, SpringLayout.EAST, moduleCardPanel);
		stopButton4.setOpaque(false);
		stopButton4.setIconTextGap(10);
		stopButton4.setFont(new Font("Poppins", Font.BOLD, 14));
		stopButton4.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(128, 128, 128)));
		stopButton4.setBackground(Color.WHITE);
		moduleCardPanel.add(stopButton4);

		updateBoxButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = { "Yes", "No" };
				int n = JOptionPane.showOptionDialog(null, "Do you want to enter update mode?", "Update Module",
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				if (n == 0) {
					isModuleUpdate = true;
					isModuleDelete = false;
					JOptionPane.showMessageDialog(null, "Entered Update Mode!");
					addButton4.setVisible(false);
					deleteButton4.setVisible(false);
					stopButton4.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/stop.png")));
					stopButton4.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(255, 0, 0)));
					moduleTable.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if (isModuleUpdate == true && isModuleDelete == false) {
								AddModule updateModule = new AddModule();
								updateModule.setVisible(true);
								updateModule.setTitle("Update Module | Course Management System");
								JLabel heading = updateModule.getModuleHeading();
								heading.setText("Update Module");
								JButton updateButton = updateModule.getAddButton();
								updateButton.setText("Update");

								String moduleId = "";
								String moduleName = "";
								String moduleLeader = "";
								for (int columnIndex = 0; columnIndex < moduleTable.getColumnCount(); columnIndex++) {
									if (moduleId.isEmpty()) {
										moduleId = (String) moduleTable.getValueAt(moduleTable.getSelectedRow(),
												columnIndex);
									} else if (moduleName.isEmpty()) {
										moduleName = (String) moduleTable.getValueAt(moduleTable.getSelectedRow(),
												columnIndex);
									} else {
										moduleLeader = (String) moduleTable.getValueAt(moduleTable.getSelectedRow(),
												columnIndex);
									}
								}
								updateModule.getModuleIdTextField().setText(moduleId);
								updateModule.getModuleNameTextField().setText(moduleName);

								updateButton.setActionCommand("Update");
								updateButton.addActionListener(new ActionListener() {

									@Override
									public void actionPerformed(ActionEvent e) {
										// TODO Auto-generated method stub
										if (e.getActionCommand().equals("Update")) {
											JTextField moduleIdTextField = updateModule.getModuleIdTextField();
											JTextField moduleNameTextField = updateModule.getModuleNameTextField();

											String updatedModuleId = moduleIdTextField.getText().trim();
											String updatedModuleName = moduleNameTextField.getText().trim();
											String updatedModuleLeader = updateModule.getModuleLeaderFromComboBox()
													.trim();
											String updatedCourse = updateModule.getCourseFromComboBox().trim();
											String updatedLevel = updateModule.getValueFromLevelComboBox().trim();	
											int updatedLevelInt = Integer.parseInt(updatedLevel);

											String updateId = (String) moduleTable
													.getValueAt(moduleTable.getSelectedRow(), 0);

											String updateQuery = "UPDATE `moduledetails` SET " + "`moduleId` = '"
													+ updatedModuleId + "', " + "`moduleName` = '" + updatedModuleName
													+ "', " + "`moduleLeader` = '" + updatedModuleLeader + "', "
													+ "`course` = '" + updatedCourse+"', `inLevel` = "+updatedLevelInt+" WHERE `moduledetails`.`moduleId` = '" + updateId + "';";
											Statement statement = DatabaseConnection.getStatement();
											try {
												int updateSuccess = statement.executeUpdate(updateQuery);
												if (updateSuccess == 1) {
													JOptionPane.showMessageDialog(null, "Data Updated");
													updateModule.dispose();
													AdminPanel.showModuleDataFromDatabase();
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
		updateBoxButton4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		updateBoxButton4.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/update.png")));
		updateBoxButton4.setOpaque(false);
		updateBoxButton4.setIconTextGap(14);
		updateBoxButton4.setFont(new Font("Poppins", Font.BOLD, 14));
		updateBoxButton4.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(128, 128, 255)));
		updateBoxButton4.setBackground(Color.WHITE);
		moduleCardPanel.add(updateBoxButton4);

		deleteButton4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		deleteButton4.setIcon(new ImageIcon(AdminPanel.class.getResource("/images/delete.png")));
		deleteButton4.setOpaque(false);
		deleteButton4.setIconTextGap(14);
		deleteButton4.setFont(new Font("Poppins", Font.BOLD, 14));
		deleteButton4.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(128, 128, 255)));
		deleteButton4.setBackground(Color.WHITE);
		moduleCardPanel.add(deleteButton4);

		JScrollPane scrollPane_3 = new JScrollPane();
		sl_moduleCardPanel.putConstraint(SpringLayout.SOUTH, deleteButton4, -25, SpringLayout.NORTH, scrollPane_3);
		sl_moduleCardPanel.putConstraint(SpringLayout.SOUTH, updateBoxButton4, -25, SpringLayout.NORTH, scrollPane_3);
		sl_moduleCardPanel.putConstraint(SpringLayout.EAST, scrollPane_3, 583, SpringLayout.WEST, moduleCardPanel);
		sl_moduleCardPanel.putConstraint(SpringLayout.NORTH, scrollPane_3, 194, SpringLayout.NORTH, moduleCardPanel);
		sl_moduleCardPanel.putConstraint(SpringLayout.WEST, scrollPane_3, 33, SpringLayout.WEST, moduleCardPanel);
		sl_moduleCardPanel.putConstraint(SpringLayout.SOUTH, scrollPane_3, -31, SpringLayout.SOUTH, moduleCardPanel);
		moduleCardPanel.add(scrollPane_3);

		moduleTable = new JTable();
		moduleTable.setDefaultEditor(Object.class, null);
		moduleTable.getTableHeader().setFont(new Font("Poppins", Font.BOLD, 12));
		moduleTable.setModel(moduleDefaultTableModel);
		moduleTable.getColumnModel().getColumn(2).setPreferredWidth(97);
		scrollPane_3.setViewportView(moduleTable);
		splitPane_1.setDividerLocation(100);
		splitPane.setDividerLocation(200);

		AdminPanel.showTeacherDataFromDatabase();
		AdminPanel.showStudentDataFromDatabase();
		AdminPanel.showCourseDataFromDatabase();
		AdminPanel.showModuleDataFromDatabase();
		AdminPanel.getStudentIdForComboBox();
	}
}
