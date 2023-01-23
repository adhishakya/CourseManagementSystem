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
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class StudentPanel {

    public JFrame getFrmStudentPanel() {
        return fromStudentPanel;
    }

    private JFrame fromStudentPanel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StudentPanel window = new StudentPanel();
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
    public StudentPanel() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        fromStudentPanel = new JFrame();
        fromStudentPanel.setResizable(false);
        fromStudentPanel.setTitle("Student Panel | Course Management System");
        fromStudentPanel.setBounds(100, 100, 677, 523);
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
        sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1_1_1, 0, SpringLayout.WEST, btnNewButton);
        sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton_1_1_1, -22, SpringLayout.SOUTH, panel);
        btnNewButton_1_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Student Logging out!");
                fromStudentPanel.dispose();
                Login window = new Login();
                window.getFrmLogin().setVisible(true);
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

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(255, 255, 255));
        splitPane_1.setLeftComponent(panel_2);
        SpringLayout sl_panel_2 = new SpringLayout();
        panel_2.setLayout(sl_panel_2);

        JLabel lblWelcomeBackStudent = new JLabel("Welcome Back, Mike!");
        sl_panel_2.putConstraint(SpringLayout.NORTH, lblWelcomeBackStudent, 25, SpringLayout.NORTH, panel_2);
        sl_panel_2.putConstraint(SpringLayout.WEST, lblWelcomeBackStudent, 25, SpringLayout.WEST, panel_2);
        lblWelcomeBackStudent.setFont(new Font("Poppins", Font.BOLD, 30));
        panel_2.add(lblWelcomeBackStudent);

        JPanel cardPanel = new JPanel();
        splitPane_1.setRightComponent(cardPanel);
        cardPanel.setLayout(new CardLayout(0, 0));

        JPanel dashboardCardPanelStudent = new JPanel();
        dashboardCardPanelStudent.setBackground(new Color(255, 255, 255));
        cardPanel.add(dashboardCardPanelStudent, "name_78982683888600");
        SpringLayout sl_dashboardCardPanelStudent = new SpringLayout();
        dashboardCardPanelStudent.setLayout(sl_dashboardCardPanelStudent);

        JLabel lblNewLabel_1 = new JLabel(
                "<html>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Student ID: 2223456<br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Student Name: Mike Bean<br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Student Group: L5CG20<br>\r\n</html>\r\n\r\n\r\n");
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

        JLabel lblNewLabel = new JLabel("Student Details:");
        sl_dashboardCardPanelStudent.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, lblNewLabel_1);
        sl_dashboardCardPanelStudent.putConstraint(SpringLayout.SOUTH, lblNewLabel, -26, SpringLayout.NORTH,
                lblNewLabel_1);
        lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        dashboardCardPanelStudent.add(lblNewLabel);

        JPanel teachersCardPanelStudent = new JPanel();
        cardPanel.add(teachersCardPanelStudent, "name_78985517477200");
        teachersCardPanelStudent.setLayout(new SpringLayout());

        JPanel ModulesCardPanelStudent = new JPanel();
        cardPanel.add(ModulesCardPanelStudent, "name_78987815364700");
        ModulesCardPanelStudent.setLayout(new SpringLayout());
        splitPane_1.setDividerLocation(100);
        splitPane.setDividerLocation(200);
    }

}
