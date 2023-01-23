package courseMngmtSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SpringLayout;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Cursor;
import java.awt.CardLayout;
import javax.swing.border.MatteBorder;

public class AdminPanel {
	
	private CardLayout cl_cardPanel= new CardLayout(0, 0);

	public JFrame getFrmAdminPanel() {
		return fromAdminPanel;
	}

	private JFrame fromAdminPanel;
	private JPanel cardPanel;

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
		fromAdminPanel.setBounds(100, 100, 680, 564);
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
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Admin Logging out!");
				fromAdminPanel.dispose();
				Login window = new Login();
				window.getFrmLogin().setVisible(true);
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

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		splitPane_1.setLeftComponent(panel_3);
		SpringLayout sl_panel_3 = new SpringLayout();
		panel_3.setLayout(sl_panel_3);

		JLabel lblNewLabel = new JLabel("Welcome Back, Admin!");
		sl_panel_3.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.WEST, lblNewLabel, 31, SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, lblNewLabel, 89, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.EAST, lblNewLabel, -69, SpringLayout.EAST, panel_3);
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 30));
		panel_3.add(lblNewLabel);
		
		cardPanel = new JPanel();
		cardPanel.setBackground(new Color(255, 255, 255));
		splitPane_1.setRightComponent(cardPanel);
		cardPanel.setLayout(cl_cardPanel);
			
		JPanel dashboardCardPanel = new JPanel();
		dashboardCardPanel.setBackground(new Color(255, 255, 255));
		cardPanel.add(dashboardCardPanel, "name_74576525649000");
		SpringLayout sl_dashboardCardPanel = new SpringLayout();
		dashboardCardPanel.setLayout(sl_dashboardCardPanel);
		
		JLabel lblNewLabel_1 = new JLabel("<html>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1002<br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Students\r\n</html>\r\n\r\n\r\n");
		sl_dashboardCardPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 44, SpringLayout.NORTH, dashboardCardPanel);
		sl_dashboardCardPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 38, SpringLayout.WEST, dashboardCardPanel);
		sl_dashboardCardPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -252, SpringLayout.SOUTH, dashboardCardPanel);
		lblNewLabel_1.setFont(new Font("Poppins", Font.BOLD, 24));
		lblNewLabel_1.setBorder(new MatteBorder(1, 1, 5, 5, (Color) new Color(128, 128, 255)));
		lblNewLabel_1.setBackground(Color.WHITE);
		dashboardCardPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("<html>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;53<br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Teachers\r\n</html>\r\n\r\n\r\n");
		sl_dashboardCardPanel.putConstraint(SpringLayout.EAST, lblNewLabel_1, -36, SpringLayout.WEST, lblNewLabel_1_1);
		sl_dashboardCardPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1, 44, SpringLayout.NORTH, dashboardCardPanel);
		sl_dashboardCardPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1, -209, SpringLayout.EAST, dashboardCardPanel);
		sl_dashboardCardPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_1, 0, SpringLayout.SOUTH, lblNewLabel_1);
		sl_dashboardCardPanel.putConstraint(SpringLayout.EAST, lblNewLabel_1_1, -29, SpringLayout.EAST, dashboardCardPanel);
		lblNewLabel_1_1.setFont(new Font("Poppins", Font.BOLD, 24));
		lblNewLabel_1_1.setBorder(new MatteBorder(1, 1, 5, 5, (Color) new Color(128, 128, 255)));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		dashboardCardPanel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("<html>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2<br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Courses\r\n</html>\r\n\r\n\r\n");
		sl_dashboardCardPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_2, 42, SpringLayout.SOUTH, lblNewLabel_1);
		sl_dashboardCardPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_2, 145, SpringLayout.WEST, dashboardCardPanel);
		sl_dashboardCardPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_2, -85, SpringLayout.SOUTH, dashboardCardPanel);
		sl_dashboardCardPanel.putConstraint(SpringLayout.EAST, lblNewLabel_1_2, -138, SpringLayout.EAST, dashboardCardPanel);
		lblNewLabel_1_2.setFont(new Font("Poppins", Font.BOLD, 24));
		lblNewLabel_1_2.setBorder(new MatteBorder(1, 1, 5, 5, (Color) new Color(128, 128, 255)));
		lblNewLabel_1_2.setBackground(Color.WHITE);
		dashboardCardPanel.add(lblNewLabel_1_2);
		
		JPanel teachersCardPanel = new JPanel();
		cardPanel.add(teachersCardPanel, "name_74583098469500");
		SpringLayout sl_teachersCardPanel = new SpringLayout();
		teachersCardPanel.setLayout(sl_teachersCardPanel);
		
		JLabel lblNewLabel_2 = new JLabel("Teacher");
		sl_teachersCardPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 73, SpringLayout.NORTH, teachersCardPanel);
		sl_teachersCardPanel.putConstraint(SpringLayout.WEST, lblNewLabel_2, 92, SpringLayout.WEST, teachersCardPanel);
		sl_teachersCardPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, 151, SpringLayout.NORTH, teachersCardPanel);
		sl_teachersCardPanel.putConstraint(SpringLayout.EAST, lblNewLabel_2, 297, SpringLayout.WEST, teachersCardPanel);
		teachersCardPanel.add(lblNewLabel_2);
		
		JPanel studentsCardPanel = new JPanel();
		cardPanel.add(studentsCardPanel, "name_74591453117300");
		SpringLayout sl_studentsCardPanel = new SpringLayout();
		studentsCardPanel.setLayout(sl_studentsCardPanel);
		
		JLabel lblNewLabel_3 = new JLabel("Students");
		sl_studentsCardPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 105, SpringLayout.NORTH, studentsCardPanel);
		sl_studentsCardPanel.putConstraint(SpringLayout.WEST, lblNewLabel_3, 106, SpringLayout.WEST, studentsCardPanel);
		sl_studentsCardPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, 187, SpringLayout.NORTH, studentsCardPanel);
		sl_studentsCardPanel.putConstraint(SpringLayout.EAST, lblNewLabel_3, 267, SpringLayout.WEST, studentsCardPanel);
		studentsCardPanel.add(lblNewLabel_3);
		
		JPanel courseCardPanel = new JPanel();
		cardPanel.add(courseCardPanel, "name_74601242877200");
		SpringLayout sl_courseCardPanel = new SpringLayout();
		courseCardPanel.setLayout(sl_courseCardPanel);
		
		JLabel lblNewLabel_4 = new JLabel("Course");
		sl_courseCardPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 50, SpringLayout.NORTH, courseCardPanel);
		sl_courseCardPanel.putConstraint(SpringLayout.WEST, lblNewLabel_4, 67, SpringLayout.WEST, courseCardPanel);
		sl_courseCardPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, 123, SpringLayout.NORTH, courseCardPanel);
		sl_courseCardPanel.putConstraint(SpringLayout.EAST, lblNewLabel_4, 216, SpringLayout.WEST, courseCardPanel);
		courseCardPanel.add(lblNewLabel_4);
		
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
	}
}
