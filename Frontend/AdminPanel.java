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
        fromAdminPanel.setBounds(100, 100, 606, 409);
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
        btnNewButton.setIconTextGap(10);
        btnNewButton.setBorderPainted(false);
        sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, 10, SpringLayout.NORTH, panel);
        sl_panel.putConstraint(SpringLayout.WEST, btnNewButton, 10, SpringLayout.WEST, panel);
        sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton, -305, SpringLayout.SOUTH, panel);
        sl_panel.putConstraint(SpringLayout.EAST, btnNewButton, -10, SpringLayout.EAST, panel);
        btnNewButton.setIcon(new ImageIcon(
                "D:\\College Stuffs\\Level 5\\Object-Oriented Design and Programming\\hello\\Images\\dashboard.png"));
        btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnNewButton.setBorder(null);
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(128, 128, 255));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(btnNewButton);

        JButton btnTeacher = new JButton("Teacher");
        btnTeacher.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        sl_panel.putConstraint(SpringLayout.NORTH, btnTeacher, 31, SpringLayout.SOUTH, btnNewButton);
        sl_panel.putConstraint(SpringLayout.EAST, btnTeacher, -21, SpringLayout.EAST, panel);
        btnTeacher.setIconTextGap(10);
        btnTeacher.setForeground(Color.WHITE);
        btnTeacher.setFont(new Font("Arial", Font.BOLD, 18));
        btnTeacher.setBorderPainted(false);
        btnTeacher.setBorder(null);
        btnTeacher.setBackground(new Color(128, 128, 255));
        panel.add(btnTeacher);
        splitPane.setDividerLocation(200);
    }
}
