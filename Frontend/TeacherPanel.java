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
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Cursor;

public class TeacherPanel {

	private CardLayout cl_cardPanelTeacher = new CardLayout(0, 0);
	private CardLayout cl_cardPanelTopTeacher = new CardLayout(0, 0);

	public static JFrame getFrmTeacherPanel() {
		return fromTeacherPanel;
	}

	private static JFrame fromTeacherPanel;
	private JPanel cardPanelTeacher;
	private JPanel cardPanelTopTeacher;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherPanel window = new TeacherPanel();
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
	public TeacherPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		fromTeacherPanel = new JFrame();
		fromTeacherPanel.setResizable(false);
		fromTeacherPanel.setTitle("Teacher Panel | Course Management System");
		fromTeacherPanel.setBounds(100, 100, 634, 518);
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

		JButton btnNewButton_1_1_2 = new JButton("Modules");
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cardPanelTeacher.show(cardPanelTeacher, "name_79349991822800");
				cl_cardPanelTopTeacher.show(cardPanelTopTeacher, "name_112389746503700");
			}
		});
		btnNewButton_1_1_2.setIcon(new ImageIcon(
				"D:\\College Stuffs\\Level 5\\Object-Oriented Design and Programming\\hello\\Images\\books.png"));
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1_1_2, 29, SpringLayout.SOUTH, btnNewButton_1_1);
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
		cardPanelTopTeacher.add(dashboardCardPanelTeacherTop, "name_112385867187000");
		SpringLayout sl_dashboardCardPanelTeacherTop = new SpringLayout();
		dashboardCardPanelTeacherTop.setLayout(sl_dashboardCardPanelTeacherTop);

		JLabel lblNewLabel_2 = new JLabel("hi");
		sl_dashboardCardPanelTeacherTop.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 25, SpringLayout.NORTH,
				dashboardCardPanelTeacherTop);
		sl_dashboardCardPanelTeacherTop.putConstraint(SpringLayout.WEST, lblNewLabel_2, 37, SpringLayout.WEST,
				dashboardCardPanelTeacherTop);
		sl_dashboardCardPanelTeacherTop.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, 38, SpringLayout.NORTH,
				dashboardCardPanelTeacherTop);
		sl_dashboardCardPanelTeacherTop.putConstraint(SpringLayout.EAST, lblNewLabel_2, 121, SpringLayout.WEST,
				dashboardCardPanelTeacherTop);
		dashboardCardPanelTeacherTop.add(lblNewLabel_2);

		JPanel studentCardPanelTeacherTop = new JPanel();
		cardPanelTopTeacher.add(studentCardPanelTeacherTop, "name_112387896874700");
		SpringLayout sl_studentCardPanelTeacherTop = new SpringLayout();
		studentCardPanelTeacherTop.setLayout(sl_studentCardPanelTeacherTop);

		JLabel lblNewLabel = new JLabel("New label");
		sl_studentCardPanelTeacherTop.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH,
				studentCardPanelTeacherTop);
		sl_studentCardPanelTeacherTop.putConstraint(SpringLayout.WEST, lblNewLabel, 22, SpringLayout.WEST,
				studentCardPanelTeacherTop);
		sl_studentCardPanelTeacherTop.putConstraint(SpringLayout.SOUTH, lblNewLabel, 45, SpringLayout.NORTH,
				studentCardPanelTeacherTop);
		sl_studentCardPanelTeacherTop.putConstraint(SpringLayout.EAST, lblNewLabel, 100, SpringLayout.WEST,
				studentCardPanelTeacherTop);
		studentCardPanelTeacherTop.add(lblNewLabel);

		JPanel modulesCardPanelTeacherTop = new JPanel();
		cardPanelTopTeacher.add(modulesCardPanelTeacherTop, "name_112389746503700");
		SpringLayout sl_modulesCardPanelTeacherTop = new SpringLayout();
		modulesCardPanelTeacherTop.setLayout(sl_modulesCardPanelTeacherTop);

		JLabel lblNewLabel_1 = new JLabel("Modules");
		sl_modulesCardPanelTeacherTop.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 27, SpringLayout.NORTH,
				modulesCardPanelTeacherTop);
		sl_modulesCardPanelTeacherTop.putConstraint(SpringLayout.WEST, lblNewLabel_1, 53, SpringLayout.WEST,
				modulesCardPanelTeacherTop);
		sl_modulesCardPanelTeacherTop.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 68, SpringLayout.NORTH,
				modulesCardPanelTeacherTop);
		sl_modulesCardPanelTeacherTop.putConstraint(SpringLayout.EAST, lblNewLabel_1, 174, SpringLayout.WEST,
				modulesCardPanelTeacherTop);
		modulesCardPanelTeacherTop.add(lblNewLabel_1);

		cardPanelTeacher = new JPanel();
		cardPanelTeacher.setBackground(new Color(255, 255, 255));
		splitPane_1.setRightComponent(cardPanelTeacher);
		cardPanelTeacher.setLayout(cl_cardPanelTeacher);

		JPanel dashboardCardPanelTeacher = new JPanel();
		dashboardCardPanelTeacher.setBackground(new Color(0, 0, 255));
		cardPanelTeacher.add(dashboardCardPanelTeacher, "name_79330044922200");
		dashboardCardPanelTeacher.setLayout(new SpringLayout());

		JPanel studentCardPanelTeacher = new JPanel();
		studentCardPanelTeacher.setBackground(new Color(192, 192, 192));
		cardPanelTeacher.add(studentCardPanelTeacher, "name_79342838523500");
		studentCardPanelTeacher.setLayout(new SpringLayout());

		JPanel modulesCardPanelTeacher = new JPanel();
		modulesCardPanelTeacher.setBackground(new Color(128, 64, 0));
		cardPanelTeacher.add(modulesCardPanelTeacher, "name_79349991822800");
		modulesCardPanelTeacher.setLayout(new SpringLayout());
		splitPane_1.setDividerLocation(100);
		splitPane.setDividerLocation(200);
	}

}
