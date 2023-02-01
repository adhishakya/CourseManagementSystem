package courseMngmtSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SpringLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Cursor;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUp {

    private JFrame signupPanel;
    private JTextField usernameTextField;
    private JTextField emailTextField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JLabel passwordsNotMatchingError;

    public JFrame getSignupPanel() {
        return signupPanel;
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SignUp window = new SignUp();
                    window.signupPanel.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public SignUp() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        signupPanel = new JFrame();
        signupPanel.setTitle("Sign Up | Course Management System");
        signupPanel.setBounds(100, 50, 850, 710);
        signupPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        signupPanel.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        JSplitPane splitPane = new JSplitPane();
        splitPane.setDividerSize(0);
        panel.add(splitPane, BorderLayout.CENTER);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(SignUp.class.getResource("/images/signup.png")));
        lblNewLabel.setBackground(new Color(255, 255, 255));
        splitPane.setLeftComponent(lblNewLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        splitPane.setRightComponent(panel_1);
        SpringLayout sl_panel_1 = new SpringLayout();
        panel_1.setLayout(sl_panel_1);

        JLabel lblNewLabel_1 = new JLabel("Student Sign Up");
        sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 38, SpringLayout.NORTH, panel_1);
        sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_1, 81, SpringLayout.WEST, panel_1);
        lblNewLabel_1.setBackground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Poppins", Font.BOLD, 28));
        panel_1.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Username");
        sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_2, 91, SpringLayout.WEST, panel_1);
        lblNewLabel_2.setFont(new Font("Poppins", Font.BOLD, 18));
        panel_1.add(lblNewLabel_2);

        usernameTextField = new JTextField();
        sl_panel_1.putConstraint(SpringLayout.NORTH, usernameTextField, 161, SpringLayout.NORTH, panel_1);
        sl_panel_1.putConstraint(SpringLayout.EAST, usernameTextField, -29, SpringLayout.EAST, panel_1);
        sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -6, SpringLayout.NORTH, usernameTextField);
        usernameTextField.setSelectionColor(new Color(128, 128, 255));
        usernameTextField.setSelectedTextColor(Color.WHITE);
        usernameTextField.setForeground(new Color(104, 104, 104));
        usernameTextField.setFont(new Font("Poppins", Font.PLAIN, 16));
        usernameTextField.setColumns(10);
        usernameTextField.setCaretColor(new Color(128, 128, 255));
        usernameTextField.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 255),

                new Color(128, 128, 255), new Color(255, 255, 255), new Color(255, 255, 255)));
        panel_1.add(usernameTextField);

        JLabel lblNewLabel_2_1 = new JLabel("");
        sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_2_1, -387, SpringLayout.EAST, panel_1);
        sl_panel_1.putConstraint(SpringLayout.WEST, usernameTextField, 13, SpringLayout.EAST, lblNewLabel_2_1);
        sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1, 156, SpringLayout.NORTH, panel_1);
        sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_2_1, 46, SpringLayout.WEST, panel_1);
        lblNewLabel_2_1.setIcon(new ImageIcon(SignUp.class.getResource("/images/user.png")));
        panel_1.add(lblNewLabel_2_1);

        JLabel lblNewLabel_2_2 = new JLabel("Email");
        sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_2_2, 95, SpringLayout.WEST, panel_1);
        lblNewLabel_2_2.setFont(new Font("Poppins", Font.BOLD, 18));
        panel_1.add(lblNewLabel_2_2);

        emailTextField = new JTextField();
        sl_panel_1.putConstraint(SpringLayout.NORTH, emailTextField, 252, SpringLayout.NORTH, panel_1);
        sl_panel_1.putConstraint(SpringLayout.EAST, emailTextField, -29, SpringLayout.EAST, panel_1);
        sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_2_2, -6, SpringLayout.NORTH, emailTextField);
        emailTextField.setSelectionColor(new Color(128, 128, 255));
        emailTextField.setSelectedTextColor(Color.WHITE);
        emailTextField.setForeground(new Color(104, 104, 104));
        emailTextField.setFont(new Font("Poppins", Font.PLAIN, 16));
        emailTextField.setColumns(10);
        emailTextField.setCaretColor(new Color(128, 128, 255));
        emailTextField.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 255),

                new Color(128, 128, 255), new Color(255, 255, 255), new Color(255, 255, 255)));
        panel_1.add(emailTextField);

        JLabel lblNewLabel_2_2_1 = new JLabel("Password");
        lblNewLabel_2_2_1.setFont(new Font("Poppins", Font.BOLD, 18));
        panel_1.add(lblNewLabel_2_2_1);

        passwordField = new JPasswordField();
        sl_panel_1.putConstraint(SpringLayout.EAST, passwordField, -29, SpringLayout.EAST, panel_1);
        sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_2_2_1, -12, SpringLayout.NORTH, passwordField);
        sl_panel_1.putConstraint(SpringLayout.NORTH, passwordField, 342, SpringLayout.NORTH, panel_1);
        passwordField.setSelectionColor(new Color(128, 128, 255));
        passwordField.setSelectedTextColor(Color.WHITE);
        passwordField.setFont(new Font("Poppins", Font.PLAIN, 16));
        passwordField.setEchoChar('*');
        passwordField.setCaretColor(new Color(128, 128, 255));
        passwordField.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 255), new Color(128, 128, 255),

                new Color(255, 255, 255), new Color(255, 255, 255)));
        panel_1.add(passwordField);

        JLabel lblNewLabel_2_1_1 = new JLabel("");
        sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_2_2_1, 10, SpringLayout.EAST, lblNewLabel_2_1_1);
        sl_panel_1.putConstraint(SpringLayout.WEST, passwordField, 11, SpringLayout.EAST, lblNewLabel_2_1_1);
        sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_2_1_1, 0, SpringLayout.WEST, lblNewLabel_2_1);
        sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_2_1_1, 0, SpringLayout.EAST, lblNewLabel_2_1);
        lblNewLabel_2_1_1.setIcon(new ImageIcon(SignUp.class.getResource("/images/password.png")));
        panel_1.add(lblNewLabel_2_1_1);

        JLabel lblNewLabel_2_2_1_1 = new JLabel("Confirm Password");
        sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_2_2_1_1, 0, SpringLayout.WEST, lblNewLabel_2_2_1);
        lblNewLabel_2_2_1_1.setFont(new Font("Poppins", Font.BOLD, 18));
        panel_1.add(lblNewLabel_2_2_1_1);

        confirmPasswordField = new JPasswordField();
        sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_2_2_1_1, -17, SpringLayout.NORTH,
                confirmPasswordField);
        sl_panel_1.putConstraint(SpringLayout.NORTH, confirmPasswordField, 434, SpringLayout.NORTH, panel_1);
        sl_panel_1.putConstraint(SpringLayout.WEST, confirmPasswordField, 8, SpringLayout.WEST, lblNewLabel_1);
        sl_panel_1.putConstraint(SpringLayout.EAST, confirmPasswordField, -29, SpringLayout.EAST, panel_1);
        confirmPasswordField.setSelectionColor(new Color(128, 128, 255));
        confirmPasswordField.setSelectedTextColor(Color.WHITE);
        confirmPasswordField.setFont(new Font("Poppins", Font.PLAIN, 16));
        confirmPasswordField.setEchoChar('*');
        confirmPasswordField.setCaretColor(new Color(128, 128, 255));
        confirmPasswordField
                .setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 255), new Color(128, 128, 255),

                        new Color(255, 255, 255), new Color(255, 255, 255)));
        panel_1.add(confirmPasswordField);

        JLabel lblNewLabel_2_1_1_1 = new JLabel("");
        sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_2_1_1, -51, SpringLayout.NORTH, lblNewLabel_2_1_1_1);
        sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1_1_1, 422, SpringLayout.NORTH, panel_1);
        sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_2_1_1_1, -206, SpringLayout.SOUTH, panel_1);
        sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_2_1_1_1, 0, SpringLayout.WEST, lblNewLabel_2_1);
        sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_2_1_1_1, 0, SpringLayout.EAST, lblNewLabel_2_1);
        lblNewLabel_2_1_1_1.setIcon(new ImageIcon(SignUp.class.getResource("/images/password.png")));
        panel_1.add(lblNewLabel_2_1_1_1);

        JButton btnSignUp = new JButton("Sign Up");
        btnSignUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String password = String.valueOf(passwordField.getPassword());
                String confirmPassword = String.valueOf(confirmPasswordField.getPassword());
                if (!password.equals(confirmPassword)) {
                    passwordsNotMatchingError.setVisible(true);
                } else {
                    passwordsNotMatchingError.setVisible(false);
                }
                String username = usernameTextField.getText().trim();
                String email = emailTextField.getText().trim();
                Statement statement = DatabaseConnection.getStatement();
                String insertQuery = "INSERT INTO `userdetails` (`username`, `email`, `password`, `usertype`)"
                        + " VALUES ('"
                        + username + "', '" + email + "', '" + password + "', 'Student');";

                try {
                    int insertSuccess = statement.executeUpdate(insertQuery);
                    if (insertSuccess == 1) {
                        JOptionPane.showMessageDialog(null, "Successfully Signed Up!");
                        signupPanel.dispose();
                    }
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        sl_panel_1.putConstraint(SpringLayout.NORTH, btnSignUp, 63, SpringLayout.SOUTH, confirmPasswordField);
        sl_panel_1.putConstraint(SpringLayout.WEST, btnSignUp, 80, SpringLayout.WEST, panel_1);
        sl_panel_1.putConstraint(SpringLayout.EAST, btnSignUp, -29, SpringLayout.EAST, panel_1);
        btnSignUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnSignUp.setForeground(Color.WHITE);
        btnSignUp.setFont(new Font("Poppins", Font.BOLD, 18));
        btnSignUp.setBorder(null);
        btnSignUp.setBackground(new Color(128, 128, 255));
        panel_1.add(btnSignUp);

        JLabel lblNewLabel_6 = new JLabel("Already have an account? ");
        sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 602, SpringLayout.NORTH, panel_1);
        sl_panel_1.putConstraint(SpringLayout.SOUTH, btnSignUp, -26, SpringLayout.NORTH, lblNewLabel_6);
        sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_6, 81, SpringLayout.WEST, panel_1);
        sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_6, -214, SpringLayout.EAST, panel_1);
        lblNewLabel_6.setFont(new Font("Poppins", Font.BOLD, 12));
        panel_1.add(lblNewLabel_6);

        JButton btnNewButton_1 = new JButton("Login");
        sl_panel_1.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, lblNewLabel_6);
        sl_panel_1.putConstraint(SpringLayout.WEST, btnNewButton_1, 6, SpringLayout.EAST, lblNewLabel_6);
        sl_panel_1.putConstraint(SpringLayout.EAST, btnNewButton_1, -168, SpringLayout.EAST, panel_1);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login window = new Login();
                window.getFrmLogin().setVisible(true);
                signupPanel.dispose();
            }
        });
        btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnNewButton_1.setForeground(new Color(128, 128, 255));
        btnNewButton_1.setFont(new Font("Poppins", Font.BOLD, 12));
        btnNewButton_1.setBorder(null);
        btnNewButton_1.setBackground(Color.WHITE);
        panel_1.add(btnNewButton_1);

        JLabel lblNewLabel_2_1_2 = new JLabel("");
        sl_panel_1.putConstraint(SpringLayout.WEST, emailTextField, 13, SpringLayout.EAST, lblNewLabel_2_1_2);
        sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1_2, 252, SpringLayout.NORTH, panel_1);
        sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_2_1_2, -390, SpringLayout.SOUTH, panel_1);
        sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1_1, 47, SpringLayout.SOUTH, lblNewLabel_2_1_2);
        sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_2_1, -53, SpringLayout.NORTH, lblNewLabel_2_1_2);
        sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_2_1_2, 0, SpringLayout.WEST, lblNewLabel_2_1);
        sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_2_1_2, 0, SpringLayout.EAST, lblNewLabel_2_1);
        lblNewLabel_2_1_2.setIcon(new ImageIcon(SignUp.class.getResource("/images/mail.png")));
        panel_1.add(lblNewLabel_2_1_2);

        passwordsNotMatchingError = new JLabel("Passwords do not match.");
        passwordsNotMatchingError.setVisible(false);
        sl_panel_1.putConstraint(SpringLayout.EAST, passwordsNotMatchingError, -14, SpringLayout.EAST, btnNewButton_1);
        passwordsNotMatchingError.setForeground(new Color(255, 0, 0));
        passwordsNotMatchingError.setFont(new Font("Poppins", Font.BOLD, 14));
        sl_panel_1.putConstraint(SpringLayout.NORTH, passwordsNotMatchingError, 6, SpringLayout.SOUTH,
                confirmPasswordField);
        sl_panel_1.putConstraint(SpringLayout.WEST, passwordsNotMatchingError, 91, SpringLayout.WEST, panel_1);
        sl_panel_1.putConstraint(SpringLayout.SOUTH, passwordsNotMatchingError, -20, SpringLayout.NORTH, btnSignUp);
        panel_1.add(passwordsNotMatchingError);
        splitPane.setDividerLocation(370);
    }

}
