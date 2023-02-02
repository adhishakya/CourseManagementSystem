package courseMngmtSystem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ItemEvent;

public class AddModule extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField moduleIdTextField;
    private JTextField moduleNameTextField;
    private JTextField moduleLeaderTextField;
    private JButton addButton;
    private JLabel heading;
    private String moduleId;
    private String moduleName;
    private String moduleLeader;

    public JLabel getHeading() {
        return heading;
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JTextField getModuleIdTextField() {
        return moduleIdTextField;
    }

    public JTextField getModuleNameTextField() {
        return moduleNameTextField;
    }

    public JTextField getModuleLeaderTextField() {
        return moduleLeaderTextField;
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            AddModule dialog = new AddModule();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public AddModule() {
        setTitle("Add Teacher | Course Management System");
        setBounds(100, 100, 521, 467);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(255, 255, 255));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        SpringLayout sl_contentPanel = new SpringLayout();
        contentPanel.setLayout(sl_contentPanel);

        heading = new JLabel("Add New Module");
        sl_contentPanel.putConstraint(SpringLayout.NORTH, heading, 10, SpringLayout.NORTH, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.WEST, heading, 26, SpringLayout.WEST, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.SOUTH, heading, 48, SpringLayout.NORTH, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.EAST, heading, -289, SpringLayout.EAST, contentPanel);
        heading.setFont(new Font("Poppins", Font.BOLD, 20));
        contentPanel.add(heading);

        moduleIdTextField = new JTextField();
        sl_contentPanel.putConstraint(SpringLayout.NORTH, moduleIdTextField, 20, SpringLayout.SOUTH, heading);
        sl_contentPanel.putConstraint(SpringLayout.SOUTH, moduleIdTextField, -321, SpringLayout.SOUTH, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.EAST, moduleIdTextField, -28, SpringLayout.EAST, contentPanel);
        moduleIdTextField.setCaretColor(new Color(128, 128, 255));
        moduleIdTextField.setSelectedTextColor(new Color(255, 255, 255));
        moduleIdTextField.setSelectionColor(new Color(128, 128, 255));
        moduleIdTextField.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(128, 128, 255)));
        moduleIdTextField.setFont(new Font("Poppins", Font.PLAIN, 14));
        contentPanel.add(moduleIdTextField);
        moduleIdTextField.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("Module Name :");
        sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1, 0, SpringLayout.WEST, heading);
        lblNewLabel_1_1.setFont(new Font("Poppins", Font.PLAIN, 16));
        contentPanel.add(lblNewLabel_1_1);

        moduleNameTextField = new JTextField();
        sl_contentPanel.putConstraint(SpringLayout.NORTH, moduleNameTextField, 32, SpringLayout.SOUTH,
                moduleIdTextField);
        sl_contentPanel.putConstraint(SpringLayout.SOUTH, moduleNameTextField, -258, SpringLayout.SOUTH, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.WEST, moduleNameTextField, 0, SpringLayout.WEST, moduleIdTextField);
        sl_contentPanel.putConstraint(SpringLayout.EAST, moduleNameTextField, -28, SpringLayout.EAST, contentPanel);
        moduleNameTextField.setSelectionColor(new Color(128, 128, 255));
        moduleNameTextField.setSelectedTextColor(new Color(255, 255, 255));
        moduleNameTextField.setCaretColor(new Color(128, 128, 255));
        moduleNameTextField.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(128, 128, 255)));
        moduleNameTextField.setFont(new Font("Poppins", Font.PLAIN, 14));
        moduleNameTextField.setColumns(10);
        contentPanel.add(moduleNameTextField);

        JLabel lblNewLabel_1_1_1 = new JLabel("Module Leader : ");
        sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1, 0, SpringLayout.WEST, heading);
        sl_contentPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_1_1, -189, SpringLayout.SOUTH, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.EAST, lblNewLabel_1_1_1, -335, SpringLayout.EAST, contentPanel);
        lblNewLabel_1_1_1.setFont(new Font("Poppins", Font.PLAIN, 16));
        contentPanel.add(lblNewLabel_1_1_1);

        moduleLeaderTextField = new JTextField();
        sl_contentPanel.putConstraint(SpringLayout.NORTH, moduleLeaderTextField, 38, SpringLayout.SOUTH,
                moduleNameTextField);
        sl_contentPanel.putConstraint(SpringLayout.WEST, moduleLeaderTextField, 6, SpringLayout.EAST,
                lblNewLabel_1_1_1);
        sl_contentPanel.putConstraint(SpringLayout.SOUTH, moduleLeaderTextField, -189, SpringLayout.SOUTH,
                contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.EAST, moduleLeaderTextField, -28, SpringLayout.EAST, contentPanel);
        moduleLeaderTextField.setSelectionColor(new Color(128, 128, 255));
        moduleLeaderTextField.setSelectedTextColor(new Color(255, 255, 255));
        moduleLeaderTextField.setCaretColor(new Color(128, 128, 255));
        moduleLeaderTextField.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(128, 128, 255)));
        moduleLeaderTextField.setFont(new Font("Poppins", Font.PLAIN, 14));
        moduleLeaderTextField.setColumns(10);
        contentPanel.add(moduleLeaderTextField);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("Course :");
        sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1_1, 0, SpringLayout.WEST, heading);
        lblNewLabel_1_1_1_1.setFont(new Font("Poppins", Font.PLAIN, 16));
        contentPanel.add(lblNewLabel_1_1_1_1);

        JLabel lblNewLabel_1_1_2 = new JLabel("Module Id:");
        sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1, 45, SpringLayout.SOUTH, lblNewLabel_1_1_2);
        sl_contentPanel.putConstraint(SpringLayout.WEST, moduleIdTextField, 62, SpringLayout.EAST, lblNewLabel_1_1_2);
        sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_2, 24, SpringLayout.WEST, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_1_2, 0, SpringLayout.SOUTH, moduleIdTextField);
        lblNewLabel_1_1_2.setFont(new Font("Poppins", Font.PLAIN, 16));
        contentPanel.add(lblNewLabel_1_1_2);

        addButton = new JButton("Add");
        sl_contentPanel.putConstraint(SpringLayout.NORTH, addButton, 354, SpringLayout.NORTH, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.WEST, addButton, 280, SpringLayout.WEST, contentPanel);
        addButton.setActionCommand("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Add")) {
                    moduleId = moduleIdTextField.getText().trim();
                    moduleName = moduleNameTextField.getText().trim();
                    moduleLeader = moduleLeaderTextField.getText().trim();
                    Statement statement = DatabaseConnection.getStatement();

                    String insertQuery = "INSERT INTO `moduledetails` "
                            + "(`moduleId`, `moduleName`, `moduleLeader`, `course`)"
                            + " VALUES ('" + moduleId + "', '" + moduleName + "', '" + moduleLeader + "', 'bcs');";
                    try {
                        int insertSuccess = statement.executeUpdate(insertQuery);
                        if (insertSuccess == 1) {
                            JOptionPane.showMessageDialog(contentPanel, "Added Module data successfully!");
                            // AdminPanel.showTeacherDataFromDatabase();
                            dispose();
                        }
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }

            }
        });
        addButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addButton.setForeground(new Color(255, 255, 255));
        addButton.setBorder(null);
        addButton.setBackground(new Color(128, 128, 255));
        addButton.setFont(new Font("Poppins", Font.BOLD, 14));
        contentPanel.add(addButton);

        JButton btnNewButton_1 = new JButton("Cancel");
        sl_contentPanel.putConstraint(SpringLayout.NORTH, btnNewButton_1, 354, SpringLayout.NORTH, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.WEST, btnNewButton_1, 380, SpringLayout.WEST, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -19, SpringLayout.SOUTH, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.EAST, btnNewButton_1, -28, SpringLayout.EAST, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.SOUTH, addButton, 0, SpringLayout.SOUTH, btnNewButton_1);
        sl_contentPanel.putConstraint(SpringLayout.EAST, addButton, -31, SpringLayout.WEST, btnNewButton_1);
        btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnNewButton_1.setForeground(new Color(255, 255, 255));
        btnNewButton_1.setBackground(new Color(128, 128, 255));
        btnNewButton_1.setBorder(null);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnNewButton_1.setFont(new Font("Poppins", Font.BOLD, 14));
        contentPanel.add(btnNewButton_1);

        JComboBox courseComboBox = new JComboBox();
        sl_contentPanel.putConstraint(SpringLayout.NORTH, courseComboBox, 39, SpringLayout.SOUTH,
                moduleLeaderTextField);
        sl_contentPanel.putConstraint(SpringLayout.SOUTH, courseComboBox, -53, SpringLayout.NORTH, addButton);
        sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1_1, 3, SpringLayout.NORTH, courseComboBox);
        sl_contentPanel.putConstraint(SpringLayout.WEST, courseComboBox, 0, SpringLayout.WEST, moduleIdTextField);
        sl_contentPanel.putConstraint(SpringLayout.EAST, courseComboBox, 0, SpringLayout.EAST, moduleIdTextField);
        courseComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                }
            }
        });
        courseComboBox.setModel(new DefaultComboBoxModel(new String[] { "Select Course" }));
        courseComboBox.setFont(new Font("Poppins", Font.PLAIN, 16));
        courseComboBox
                .setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 255), new Color(128, 128, 255),

                        new Color(255, 255, 255), new Color(255, 255, 255)));
        courseComboBox.setBackground(Color.WHITE);
        contentPanel.add(courseComboBox);

    }
}
