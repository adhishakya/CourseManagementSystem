package courseMngmtSystem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddStudent extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            AddStudent dialog = new AddStudent();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public AddStudent() {
        setBounds(100, 100, 533, 524);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(255, 255, 255));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        SpringLayout sl_contentPanel = new SpringLayout();
        contentPanel.setLayout(sl_contentPanel);

        JLabel lblAddNewStudent = new JLabel("Add New Student");
        lblAddNewStudent.setBackground(new Color(255, 255, 255));
        sl_contentPanel.putConstraint(SpringLayout.NORTH, lblAddNewStudent, 10, SpringLayout.NORTH, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.WEST, lblAddNewStudent, 26, SpringLayout.WEST, contentPanel);
        lblAddNewStudent.setFont(new Font("Poppins", Font.BOLD, 20));
        contentPanel.add(lblAddNewStudent);

        JLabel lblNewLabel_1_1_2 = new JLabel("Full Name :");
        sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_2, 28, SpringLayout.SOUTH, lblAddNewStudent);
        sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_2, 0, SpringLayout.WEST, lblAddNewStudent);
        lblNewLabel_1_1_2.setFont(new Font("Poppins", Font.PLAIN, 16));
        contentPanel.add(lblNewLabel_1_1_2);

        textField = new JTextField();
        sl_contentPanel.putConstraint(SpringLayout.NORTH, textField, 2, SpringLayout.NORTH, lblNewLabel_1_1_2);
        sl_contentPanel.putConstraint(SpringLayout.WEST, textField, 17, SpringLayout.EAST, lblNewLabel_1_1_2);
        sl_contentPanel.putConstraint(SpringLayout.EAST, textField, -37, SpringLayout.EAST, contentPanel);
        textField.setSelectionColor(new Color(128, 128, 255));
        textField.setSelectedTextColor(Color.WHITE);
        textField.setFont(new Font("Poppins", Font.PLAIN, 14));
        textField.setColumns(10);
        textField.setCaretColor(new Color(128, 128, 255));
        textField.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(128, 128, 255)));
        contentPanel.add(textField);

        textField_1 = new JTextField();
        sl_contentPanel.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, textField);
        sl_contentPanel.putConstraint(SpringLayout.EAST, textField_1, 446, SpringLayout.WEST, lblAddNewStudent);
        textField_1.setSelectionColor(new Color(128, 128, 255));
        textField_1.setSelectedTextColor(Color.WHITE);
        textField_1.setFont(new Font("Poppins", Font.PLAIN, 14));
        textField_1.setColumns(10);
        textField_1.setCaretColor(new Color(128, 128, 255));
        textField_1.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(128, 128, 255)));
        contentPanel.add(textField_1);

        JLabel lblNewLabel_1_1 = new JLabel("Phone No :");
        sl_contentPanel.putConstraint(SpringLayout.NORTH, textField_1, 2, SpringLayout.NORTH, lblNewLabel_1_1);
        sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1, 31, SpringLayout.SOUTH, lblNewLabel_1_1_2);
        sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1, 0, SpringLayout.WEST, lblAddNewStudent);
        lblNewLabel_1_1.setFont(new Font("Poppins", Font.PLAIN, 16));
        contentPanel.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_1_1 = new JLabel("Address :");
        lblNewLabel_1_1_1.setBackground(new Color(255, 255, 255));
        sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1, 0, SpringLayout.WEST, lblAddNewStudent);
        lblNewLabel_1_1_1.setFont(new Font("Poppins", Font.PLAIN, 16));
        contentPanel.add(lblNewLabel_1_1_1);

        textField_2 = new JTextField();
        sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1, -2, SpringLayout.NORTH, textField_2);
        sl_contentPanel.putConstraint(SpringLayout.NORTH, textField_2, 34, SpringLayout.SOUTH, textField_1);
        sl_contentPanel.putConstraint(SpringLayout.WEST, textField_2, 0, SpringLayout.WEST, textField);
        sl_contentPanel.putConstraint(SpringLayout.EAST, textField_2, 0, SpringLayout.EAST, textField);
        textField_2.setSelectionColor(new Color(128, 128, 255));
        textField_2.setSelectedTextColor(Color.WHITE);
        textField_2.setFont(new Font("Poppins", Font.PLAIN, 14));
        textField_2.setColumns(10);
        textField_2.setCaretColor(new Color(128, 128, 255));
        textField_2.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(128, 128, 255)));
        contentPanel.add(textField_2);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("Course :");
        sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1_1, 27, SpringLayout.SOUTH,
                lblNewLabel_1_1_1);
        sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1_1, 0, SpringLayout.WEST, lblAddNewStudent);
        lblNewLabel_1_1_1_1.setFont(new Font("Poppins", Font.PLAIN, 16));
        contentPanel.add(lblNewLabel_1_1_1_1);

        JComboBox comboBox = new JComboBox();
        comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sl_contentPanel.putConstraint(SpringLayout.SOUTH, comboBox, -216, SpringLayout.SOUTH, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.NORTH, comboBox, 23, SpringLayout.SOUTH, textField_2);
        sl_contentPanel.putConstraint(SpringLayout.WEST, comboBox, 0, SpringLayout.WEST, textField);
        sl_contentPanel.putConstraint(SpringLayout.EAST, comboBox, 0, SpringLayout.EAST, textField);
        comboBox.setFont(new Font("Poppins", Font.PLAIN, 16));
        comboBox.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 255), new Color(128, 128, 255),

                new Color(255, 255, 255), new Color(255, 255, 255)));
        comboBox.setBackground(Color.WHITE);
        contentPanel.add(comboBox);

        JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Level :");
        sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1_1_1, 0, SpringLayout.WEST, lblAddNewStudent);
        sl_contentPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_1_1_1_1, -167, SpringLayout.SOUTH,
                contentPanel);
        lblNewLabel_1_1_1_1_1.setFont(new Font("Poppins", Font.PLAIN, 16));
        contentPanel.add(lblNewLabel_1_1_1_1_1);

        JComboBox comboBox_1_1 = new JComboBox();
        comboBox_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sl_contentPanel.putConstraint(SpringLayout.NORTH, comboBox_1_1, 0, SpringLayout.NORTH, lblNewLabel_1_1_1_1_1);
        sl_contentPanel.putConstraint(SpringLayout.WEST, comboBox_1_1, 0, SpringLayout.WEST, textField);
        sl_contentPanel.putConstraint(SpringLayout.SOUTH, comboBox_1_1, -162, SpringLayout.SOUTH, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.EAST, comboBox_1_1, 0, SpringLayout.EAST, textField);
        comboBox_1_1.setFont(new Font("Poppins", Font.PLAIN, 16));
        comboBox_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 255), new Color(128, 128, 255),

                new Color(255, 255, 255), new Color(255, 255, 255)));
        comboBox_1_1.setBackground(Color.WHITE);
        contentPanel.add(comboBox_1_1);

        JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Group :");
        sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1_1_1_1, 30, SpringLayout.SOUTH,
                lblNewLabel_1_1_1_1_1);
        sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1_1_1_1, 0, SpringLayout.WEST,
                lblAddNewStudent);
        lblNewLabel_1_1_1_1_1_1.setFont(new Font("Poppins", Font.PLAIN, 16));
        contentPanel.add(lblNewLabel_1_1_1_1_1_1);

        JComboBox comboBox_1_1_1 = new JComboBox();
        comboBox_1_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sl_contentPanel.putConstraint(SpringLayout.NORTH, comboBox_1_1_1, 0, SpringLayout.NORTH,
                lblNewLabel_1_1_1_1_1_1);
        sl_contentPanel.putConstraint(SpringLayout.WEST, comboBox_1_1_1, 0, SpringLayout.WEST, textField);
        sl_contentPanel.putConstraint(SpringLayout.SOUTH, comboBox_1_1_1, 30, SpringLayout.NORTH,
                lblNewLabel_1_1_1_1_1_1);
        sl_contentPanel.putConstraint(SpringLayout.EAST, comboBox_1_1_1, 0, SpringLayout.EAST, textField);
        comboBox_1_1_1.setFont(new Font("Poppins", Font.PLAIN, 16));
        comboBox_1_1_1
                .setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 255), new Color(128, 128, 255),

                        new Color(255, 255, 255), new Color(255, 255, 255)));
        comboBox_1_1_1.setBackground(Color.WHITE);
        contentPanel.add(comboBox_1_1_1);

        JButton btnNewButton = new JButton("Add");
        btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sl_contentPanel.putConstraint(SpringLayout.NORTH, btnNewButton, -58, SpringLayout.SOUTH, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.WEST, btnNewButton, -221, SpringLayout.EAST, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.SOUTH, btnNewButton, -15, SpringLayout.SOUTH, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.EAST, btnNewButton, -150, SpringLayout.EAST, contentPanel);
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setFont(new Font("Poppins", Font.BOLD, 14));
        btnNewButton.setBorder(null);
        btnNewButton.setBackground(new Color(128, 128, 255));
        contentPanel.add(btnNewButton);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sl_contentPanel.putConstraint(SpringLayout.NORTH, btnCancel, 49, SpringLayout.SOUTH, comboBox_1_1_1);
        sl_contentPanel.putConstraint(SpringLayout.WEST, btnCancel, 27, SpringLayout.EAST, btnNewButton);
        sl_contentPanel.putConstraint(SpringLayout.SOUTH, btnCancel, 0, SpringLayout.SOUTH, btnNewButton);
        sl_contentPanel.putConstraint(SpringLayout.EAST, btnCancel, -37, SpringLayout.EAST, contentPanel);
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setFont(new Font("Poppins", Font.BOLD, 14));
        btnCancel.setBorder(null);
        btnCancel.setBackground(new Color(128, 128, 255));
        contentPanel.add(btnCancel);
    }

}
