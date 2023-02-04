package courseMngmtSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
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

    private static DefaultTableModel teacherAndModulesDefaultTableModel = new DefaultTableModel(
            new Object[][] {
                    { null, null },
                    { null, null },
                    { null, null },
            },
            new String[] {
                    "Teacher", "Module"
            });

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
        welcomeStudentMessage.setText("Welcome back, " + name);
        sl_dashboardCardPanelStudentTop.putConstraint(SpringLayout.NORTH, welcomeStudentMessage, 25, SpringLayout.NORTH,
                dashboardCardPanelStudentTop);
        sl_dashboardCardPanelStudentTop.putConstraint(SpringLayout.WEST, welcomeStudentMessage, 31, SpringLayout.WEST,
                dashboardCardPanelStudentTop);
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
        sl_teachersCardPanelStudentTop.putConstraint(SpringLayout.WEST, welcomeStudentMessage_1, 49, SpringLayout.WEST,
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
        modulesTitle.setText("Modules");
        modulesTitle.setFont(new Font("Poppins", Font.BOLD, 24));
        modulesCardPanelStudentTop.add(modulesTitle);

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
        modulesCardPanelStudent.setLayout(sl_modulesCardPanelStudent);

        JLabel lblNewLabel_3 = new JLabel("Your Modules:");
        lblNewLabel_3.setFont(new Font("Poppins", Font.BOLD, 20));
        sl_modulesCardPanelStudent.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 35, SpringLayout.NORTH,
                modulesCardPanelStudent);
        sl_modulesCardPanelStudent.putConstraint(SpringLayout.WEST, lblNewLabel_3, 35, SpringLayout.WEST,
                modulesCardPanelStudent);
        sl_modulesCardPanelStudent.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, 84, SpringLayout.NORTH,
                modulesCardPanelStudent);
        sl_modulesCardPanelStudent.putConstraint(SpringLayout.EAST, lblNewLabel_3, 188, SpringLayout.WEST,
                modulesCardPanelStudent);
        modulesCardPanelStudent.add(lblNewLabel_3);

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

        sl_modulesCardPanelStudent.putConstraint(SpringLayout.NORTH, studentModulesDisplay, 6, SpringLayout.SOUTH,
                lblNewLabel_3);
        sl_modulesCardPanelStudent.putConstraint(SpringLayout.WEST, studentModulesDisplay, 0, SpringLayout.WEST,
                lblNewLabel_3);
        sl_modulesCardPanelStudent.putConstraint(SpringLayout.SOUTH, studentModulesDisplay, 328, SpringLayout.SOUTH,
                lblNewLabel_3);
        sl_modulesCardPanelStudent.putConstraint(SpringLayout.EAST, studentModulesDisplay, 572, SpringLayout.WEST,
                lblNewLabel_3);
        studentModulesDisplay.setFont(new Font("Poppins", Font.BOLD, 24));
        studentModulesDisplay.setBorder(new MatteBorder(1, 1, 5, 5, (Color) new Color(128, 128, 255)));
        studentModulesDisplay.setBackground(Color.WHITE);
        modulesCardPanelStudent.add(studentModulesDisplay);
        splitPane_1.setDividerLocation(100);
        splitPane.setDividerLocation(200);

        StudentPanel.getStudentNameFromLogin();
    }
}