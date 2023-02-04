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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ItemEvent;

public class AddModule extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField moduleIdTextField;
    private JTextField moduleNameTextField;
    private JButton addButton;
    private JLabel moduleHeading;
    private String moduleId;
    private String moduleName;
    private String courseFromComboBox;
    private String moduleLeaderFromComboBox;
    private String valueFromLevelComboBox;
    private int valueFromLevelComboBoxInt;
    // JComboBox levelComboBox = new JComboBox();

    public String getValueFromLevelComboBox() {
        return valueFromLevelComboBox;
    }

    public String getModuleLeaderFromComboBox() {
        return moduleLeaderFromComboBox;
    }

    public String getCourseFromComboBox() {
        return courseFromComboBox;
    }

    public JLabel getModuleHeading() {
        return moduleHeading;
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

        moduleHeading = new JLabel("Add New Module");
        sl_contentPanel.putConstraint(SpringLayout.NORTH, moduleHeading, 10, SpringLayout.NORTH, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.WEST, moduleHeading, 26, SpringLayout.WEST, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.SOUTH, moduleHeading, 48, SpringLayout.NORTH, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.EAST, moduleHeading, -289, SpringLayout.EAST, contentPanel);
        moduleHeading.setFont(new Font("Poppins", Font.BOLD, 20));
        contentPanel.add(moduleHeading);

        moduleIdTextField = new JTextField();
        sl_contentPanel.putConstraint(SpringLayout.NORTH, moduleIdTextField, 20, SpringLayout.SOUTH, moduleHeading);
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
        sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1, 0, SpringLayout.WEST, moduleHeading);
        lblNewLabel_1_1.setFont(new Font("Poppins", Font.PLAIN, 16));
        contentPanel.add(lblNewLabel_1_1);

        moduleNameTextField = new JTextField();
        sl_contentPanel.putConstraint(SpringLayout.NORTH, moduleNameTextField, -6, SpringLayout.NORTH, lblNewLabel_1_1);
        sl_contentPanel.putConstraint(SpringLayout.WEST, moduleNameTextField, 0, SpringLayout.WEST, moduleIdTextField);
        sl_contentPanel.putConstraint(SpringLayout.SOUTH, moduleNameTextField, 0, SpringLayout.SOUTH, lblNewLabel_1_1);
        sl_contentPanel.putConstraint(SpringLayout.EAST, moduleNameTextField, 0, SpringLayout.EAST, moduleIdTextField);
        moduleNameTextField.setSelectionColor(new Color(128, 128, 255));
        moduleNameTextField.setSelectedTextColor(new Color(255, 255, 255));
        moduleNameTextField.setCaretColor(new Color(128, 128, 255));
        moduleNameTextField.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(128, 128, 255)));
        moduleNameTextField.setFont(new Font("Poppins", Font.PLAIN, 14));
        moduleNameTextField.setColumns(10);
        contentPanel.add(moduleNameTextField);

        JLabel lblNewLabel_1_1_1 = new JLabel("Module Leader : ");
        sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1, 33, SpringLayout.SOUTH, lblNewLabel_1_1);
        sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1, 0, SpringLayout.WEST, moduleHeading);
        sl_contentPanel.putConstraint(SpringLayout.EAST, lblNewLabel_1_1_1, -335, SpringLayout.EAST, contentPanel);
        lblNewLabel_1_1_1.setFont(new Font("Poppins", Font.PLAIN, 16));
        contentPanel.add(lblNewLabel_1_1_1);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("Course :");
        sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1_1, 34, SpringLayout.SOUTH,
                lblNewLabel_1_1_1);
        sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1_1, 26, SpringLayout.WEST, contentPanel);
        lblNewLabel_1_1_1_1.setFont(new Font("Poppins", Font.PLAIN, 16));
        contentPanel.add(lblNewLabel_1_1_1_1);

        JLabel lblNewLabel_1_1_2 = new JLabel("Module Id:");
        sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1, 33, SpringLayout.SOUTH, lblNewLabel_1_1_2);
        sl_contentPanel.putConstraint(SpringLayout.WEST, moduleIdTextField, 62, SpringLayout.EAST, lblNewLabel_1_1_2);
        sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_2, 24, SpringLayout.WEST, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_1_2, 0, SpringLayout.SOUTH, moduleIdTextField);
        lblNewLabel_1_1_2.setFont(new Font("Poppins", Font.PLAIN, 16));
        contentPanel.add(lblNewLabel_1_1_2);

        addButton = new JButton("Add");
        sl_contentPanel.putConstraint(SpringLayout.NORTH, addButton, 354, SpringLayout.NORTH, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.WEST, addButton, 280, SpringLayout.WEST, contentPanel);
        addButton.setActionCommand("Add");

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
        sl_contentPanel.putConstraint(SpringLayout.WEST, courseComboBox, 0, SpringLayout.WEST, moduleIdTextField);
        sl_contentPanel.putConstraint(SpringLayout.SOUTH, courseComboBox, 0, SpringLayout.SOUTH, lblNewLabel_1_1_1_1);
        sl_contentPanel.putConstraint(SpringLayout.EAST, courseComboBox, 0, SpringLayout.EAST, moduleIdTextField);

        courseComboBox.setFont(new Font("Poppins", Font.PLAIN, 16));
        courseComboBox
                .setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 255), new Color(128, 128, 255),

                        new Color(255, 255, 255), new Color(255, 255, 255)));
        courseComboBox.setBackground(Color.WHITE);
        contentPanel.add(courseComboBox);

        JComboBox moduleLeaderComboBox = new JComboBox();
        sl_contentPanel.putConstraint(SpringLayout.NORTH, moduleLeaderComboBox, -5, SpringLayout.NORTH,
                lblNewLabel_1_1_1);
        sl_contentPanel.putConstraint(SpringLayout.WEST, moduleLeaderComboBox, 0, SpringLayout.WEST, moduleIdTextField);
        sl_contentPanel.putConstraint(SpringLayout.EAST, moduleLeaderComboBox, 0, SpringLayout.EAST, moduleIdTextField);
        moduleLeaderComboBox.setFont(new Font("Poppins", Font.PLAIN, 16));
        moduleLeaderComboBox
                .setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 255), new Color(128, 128, 255),

                        new Color(255, 255, 255), new Color(255, 255, 255)));
        moduleLeaderComboBox.setBackground(Color.WHITE);
        contentPanel.add(moduleLeaderComboBox);

        moduleLeaderComboBox.setModel(new DefaultComboBoxModel(new String[] { "Select Teacher" }));
        String fetchTeacherQuery = "SELECT teacherName FROM `teacherdetails`";
        String[] teachersArray = new String[15];
        int i = 0;
        try {
            Statement statement = DatabaseConnection.getStatement();
            ResultSet resultSet = statement.executeQuery(fetchTeacherQuery);

            while (resultSet.next()) {
                teachersArray[i] = resultSet.getString("TeacherName");
                moduleLeaderComboBox.addItem(teachersArray[i]);
                i++;
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        moduleLeaderComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    moduleLeaderFromComboBox = (String) e.getItem();
                }
            }
        });

        courseComboBox.setModel(new DefaultComboBoxModel(new String[] { "Select Course" }));

        JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Level :");
        sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1_1_1, 25, SpringLayout.WEST, contentPanel);
        lblNewLabel_1_1_1_1_1.setFont(new Font("Poppins", Font.PLAIN, 16));
        contentPanel.add(lblNewLabel_1_1_1_1_1);

        JComboBox levelComboBox = new JComboBox();
        levelComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    valueFromLevelComboBox = (String) e.getItem();
                    valueFromLevelComboBoxInt = Integer.parseInt(valueFromLevelComboBox);
                }
            }
        });

        sl_contentPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_1_1_1_1, 0, SpringLayout.SOUTH, levelComboBox);
        sl_contentPanel.putConstraint(SpringLayout.NORTH, levelComboBox, 15, SpringLayout.SOUTH, courseComboBox);
        levelComboBox.setModel(new DefaultComboBoxModel(new String[] { "Select Level", "4", "5", "6" }));
        sl_contentPanel.putConstraint(SpringLayout.WEST, levelComboBox, 0, SpringLayout.WEST, moduleIdTextField);
        sl_contentPanel.putConstraint(SpringLayout.EAST, levelComboBox, 0, SpringLayout.EAST, moduleIdTextField);
        levelComboBox.setFont(new Font("Poppins", Font.PLAIN, 16));
        levelComboBox.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 255), new Color(128, 128, 255),

                new Color(255, 255, 255), new Color(255, 255, 255)));
        levelComboBox.setBackground(Color.WHITE);
        contentPanel.add(levelComboBox);
        String fetchCoursesQuery = "SELECT courseName FROM `coursedetails`";
        String[] coursesArray = new String[5];
        i = 0;
        try {
            Statement statement = DatabaseConnection.getStatement();
            ResultSet resultSet = statement.executeQuery(fetchCoursesQuery);

            while (resultSet.next()) {
                coursesArray[i] = resultSet.getString("CourseName");
                courseComboBox.addItem(coursesArray[i]);
                i++;
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        courseComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    courseFromComboBox = (String) e.getItem();
                }
            }
        });

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Add")) {
                    moduleId = moduleIdTextField.getText().trim();
                    moduleName = moduleNameTextField.getText().trim();
                    Statement statement = DatabaseConnection.getStatement();

                    String insertQuery = "INSERT INTO `moduledetails` "
                            + "(`moduleId`, `moduleName`, `moduleLeader`, `course`, `inLevel`)" + " VALUES ('"
                            + moduleId + "', '"
                            + moduleName + "', '" + moduleLeaderFromComboBox + "', '" + courseFromComboBox + "','"
                            + valueFromLevelComboBoxInt + "');";
                    try {
                        int insertSuccess = statement.executeUpdate(insertQuery);
                        if (insertSuccess == 1) {
                            JOptionPane.showMessageDialog(contentPanel, "Added Module data successfully!");
                            AdminPanel.showModuleDataFromDatabase();
                            dispose();
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
