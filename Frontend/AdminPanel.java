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

    public JFrame getFrmAdminPanel() {
        return fromAdminPanel;
    }

    private JFrame fromAdminPanel;

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
        fromAdminPanel.setBounds(100, 100, 682, 565);
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

        JButton btnNewButton = new JButton("Dashboard");
        sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, 20, SpringLayout.NORTH, panel);
        sl_panel.putConstraint(SpringLayout.WEST, btnNewButton, 26, SpringLayout.WEST, panel);
        sl_panel.putConstraint(SpringLayout.EAST, btnNewButton, -10, SpringLayout.EAST, panel);
        btnNewButton.setIconTextGap(16);
        btnNewButton.setBorderPainted(false);
        btnNewButton.setIcon(new ImageIcon("C:\\Users\\shaky\\Downloads\\dashboard (2).png"));
        btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnNewButton.setBorder(null);
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(128, 128, 255));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton.setFont(new Font("Poppins", Font.BOLD, 18));
        panel.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Teacher");
        sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1, 100, SpringLayout.NORTH, panel);
        sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton, -16, SpringLayout.NORTH, btnNewButton_1);
        btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\shaky\\Downloads\\teacher-svgrepo-com (1).png"));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton_1.setIconTextGap(15);
        btnNewButton_1.setForeground(Color.WHITE);
        btnNewButton_1.setFont(new Font("Poppins", Font.BOLD, 18));
        btnNewButton_1.setBorderPainted(false);
        btnNewButton_1.setBorder(null);
        btnNewButton_1.setBackground(new Color(128, 128, 255));
        panel.add(btnNewButton_1);

        JButton btnNewButton_1_1 = new JButton("Student");
        sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1_1, 0, SpringLayout.WEST, btnNewButton_1);
        sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton_1_1, -310, SpringLayout.SOUTH, panel);
        btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\shaky\\Downloads\\student.png"));
        btnNewButton_1_1.setIconTextGap(15);
        btnNewButton_1_1.setForeground(Color.WHITE);
        btnNewButton_1_1.setFont(new Font("Poppins", Font.BOLD, 18));
        btnNewButton_1_1.setBorderPainted(false);
        btnNewButton_1_1.setBorder(null);
        btnNewButton_1_1.setBackground(new Color(128, 128, 255));
        panel.add(btnNewButton_1_1);

        JButton btnNewButton_1_1_1 = new JButton("Log Out");
        sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1, 0, SpringLayout.WEST, btnNewButton_1_1_1);
        sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1_1_1, 27, SpringLayout.WEST, panel);
        sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton_1_1_1, -22, SpringLayout.SOUTH, panel);
        btnNewButton_1_1_1.setIcon(new ImageIcon(
                "D:\\College Stuffs\\Level 5\\Object-Oriented Design and Programming\\hello\\Images\\logout.png"));
        btnNewButton_1_1_1.setIconTextGap(16);
        btnNewButton_1_1_1.setForeground(Color.WHITE);
        btnNewButton_1_1_1.setFont(new Font("Poppins", Font.BOLD, 18));
        btnNewButton_1_1_1.setBorderPainted(false);
        btnNewButton_1_1_1.setBorder(null);
        btnNewButton_1_1_1.setBackground(new Color(128, 128, 255));
        panel.add(btnNewButton_1_1_1);

        JButton btnNewButton_1_1_2 = new JButton("Courses");
        sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1_1_2, 26, SpringLayout.SOUTH, btnNewButton_1_1);
        sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1_1_2, 27, SpringLayout.WEST, panel);
        sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_1_1_2, -36, SpringLayout.EAST, panel);
        btnNewButton_1_1_2.setIcon(new ImageIcon(
                "D:\\College Stuffs\\Level 5\\Object-Oriented Design and Programming\\hello\\Images\\books.png"));
        btnNewButton_1_1_2.setIconTextGap(14);
        btnNewButton_1_1_2.setForeground(Color.WHITE);
        btnNewButton_1_1_2.setFont(new Font("Poppins", Font.BOLD, 18));
        btnNewButton_1_1_2.setBorderPainted(false);
        btnNewButton_1_1_2.setBorder(null);
        btnNewButton_1_1_2.setBackground(new Color(128, 128, 255));
        panel.add(btnNewButton_1_1_2);

        JButton btnNewButton_1_1_2_1 = new JButton("Report");
        sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1_1_2_1, 30, SpringLayout.SOUTH, btnNewButton_1_1_2);
        sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1_1_2_1, 0, SpringLayout.WEST, btnNewButton_1);
        btnNewButton_1_1_2_1.setIcon(new ImageIcon(
                "D:\\College Stuffs\\Level 5\\Object-Oriented Design and Programming\\hello\\Images\\report.png"));
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

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(255, 255, 255));
        splitPane_1.setRightComponent(panel_2);
        SpringLayout sl_panel_2 = new SpringLayout();
        panel_2.setLayout(sl_panel_2);

        JLabel lblNewLabel_1 = new JLabel(
                "<html>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1002<br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Students\r\n</html>\r\n\r\n\r\n");
        lblNewLabel_1.setFont(new Font("Poppins", Font.BOLD, 24));
        sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 46, SpringLayout.NORTH, panel_2);
        sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_1, 36, SpringLayout.WEST, panel_2);
        sl_panel_2.putConstraint(SpringLayout.EAST, lblNewLabel_1, -249, SpringLayout.EAST, panel_2);
        lblNewLabel_1.setBorder(new MatteBorder(1, 1, 5, 5, (Color) new Color(128, 128, 255)));
        lblNewLabel_1.setBackground(new Color(255, 255, 255));
        panel_2.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel(
                "<html>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;53<br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Teachers\r\n</html>\r\n\r\n\r\n");
        lblNewLabel_1_1.setFont(new Font("Poppins", Font.BOLD, 24));
        sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1, 46, SpringLayout.NORTH, panel_2);
        sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_1_1, 33, SpringLayout.EAST, lblNewLabel_1);
        sl_panel_2.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_1, -252, SpringLayout.SOUTH, panel_2);
        sl_panel_2.putConstraint(SpringLayout.EAST, lblNewLabel_1_1, -36, SpringLayout.EAST, panel_2);
        sl_panel_2.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 0, SpringLayout.SOUTH, lblNewLabel_1_1);
        lblNewLabel_1_1.setBorder(new MatteBorder(1, 1, 5, 5, (Color) new Color(128, 128, 255)));
        lblNewLabel_1_1.setBackground(Color.WHITE);
        panel_2.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_1_1 = new JLabel(
                "<html>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2<br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Courses\r\n</html>\r\n\r\n\r\n");
        lblNewLabel_1_1_1.setFont(new Font("Poppins", Font.BOLD, 24));
        sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1, 36, SpringLayout.SOUTH, lblNewLabel_1);
        sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1, 143, SpringLayout.WEST, panel_2);
        sl_panel_2.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_1_1, -92, SpringLayout.SOUTH, panel_2);
        sl_panel_2.putConstraint(SpringLayout.EAST, lblNewLabel_1_1_1, -142, SpringLayout.EAST, panel_2);
        lblNewLabel_1_1_1.setBorder(new MatteBorder(1, 1, 5, 5, (Color) new Color(128, 128, 255)));
        lblNewLabel_1_1_1.setBackground(Color.WHITE);
        panel_2.add(lblNewLabel_1_1_1);

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(255, 255, 255));
        splitPane_1.setLeftComponent(panel_3);
        SpringLayout sl_panel_3 = new SpringLayout();
        panel_3.setLayout(sl_panel_3);

        JLabel lblNewLabel = new JLabel("Welcome Back, Admin!");
        sl_panel_3.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, panel_3);
        sl_panel_3.putConstraint(SpringLayout.WEST, lblNewLabel, 41, SpringLayout.WEST, panel_3);
        sl_panel_3.putConstraint(SpringLayout.SOUTH, lblNewLabel, 89, SpringLayout.NORTH, panel_3);
        sl_panel_3.putConstraint(SpringLayout.EAST, lblNewLabel, -59, SpringLayout.EAST, panel_3);
        lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 30));
        panel_3.add(lblNewLabel);
        splitPane_1.setDividerLocation(100);
        splitPane.setDividerLocation(200);
    }
}
