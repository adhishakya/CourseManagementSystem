package courseMngmtSystem;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Window.Type;

public class LogoutPromptAdmin extends JDialog {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LogoutPromptAdmin dialog = new LogoutPromptAdmin();
                    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    dialog.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the dialog.
     */
    public LogoutPromptAdmin() {
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Logout");
        setResizable(false);
        setAlwaysOnTop(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage(LogoutPromptAdmin.class.getResource("/images/warning.png")));
        getContentPane().setBackground(new Color(255, 255, 255));
        SpringLayout springLayout = new SpringLayout();
        getContentPane().setLayout(springLayout);

        JLabel lblNewLabel = new JLabel("Are you sure you want to logout?");
        springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 20, SpringLayout.NORTH, getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 39, SpringLayout.WEST, getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -54, SpringLayout.EAST, getContentPane());
        lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 16));
        getContentPane().add(lblNewLabel);

        JButton btnNewButton = new JButton("Confirm");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminPanel.getFrmAdminPanel().dispose();
                Login window = new Login();
                window.getFrmLogin().setVisible(true);
                dispose();
            }
        });
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(128, 128, 255));
        btnNewButton.setBorder(null);
        btnNewButton.setFont(new Font("Poppins", Font.BOLD, 16));
        btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 74, SpringLayout.NORTH, getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -42, SpringLayout.SOUTH, getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -15, SpringLayout.NORTH, btnNewButton);
        springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 38, SpringLayout.WEST, getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, btnNewButton, 145, SpringLayout.WEST, getContentPane());
        getContentPane().add(btnNewButton);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setForeground(new Color(255, 255, 255));
        btnCancel.setBackground(new Color(128, 128, 255));
        btnCancel.setBorder(null);
        btnCancel.setFont(new Font("Poppins", Font.BOLD, 16));
        btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        springLayout.putConstraint(SpringLayout.NORTH, btnCancel, 15, SpringLayout.SOUTH, lblNewLabel);
        springLayout.putConstraint(SpringLayout.WEST, btnCancel, -154, SpringLayout.EAST, getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, btnCancel, 39, SpringLayout.NORTH, btnNewButton);
        springLayout.putConstraint(SpringLayout.EAST, btnCancel, -54, SpringLayout.EAST, getContentPane());
        getContentPane().add(btnCancel);
        setBounds(250, 280, 375, 192);

    }
}
