package courseMngmtSystem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;

public class createTeacher extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			createTeacher dialog = new createTeacher();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public createTeacher() {
		setTitle("Add Teacher");
		setBounds(100, 100, 521, 467);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		SpringLayout sl_contentPanel = new SpringLayout();
		contentPanel.setLayout(sl_contentPanel);
		
		JLabel lblNewLabel = new JLabel("Add New Teacher");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel, 48, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, lblNewLabel, -289, SpringLayout.EAST, contentPanel);
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 20));
		contentPanel.add(lblNewLabel);
		
		textField = new JTextField();
		sl_contentPanel.putConstraint(SpringLayout.NORTH, textField, 14, SpringLayout.SOUTH, lblNewLabel);
		textField.setCaretColor(new Color(128, 128, 255));
		textField.setSelectedTextColor(new Color(255, 255, 255));
		textField.setSelectionColor(new Color(128, 128, 255));
		textField.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(128, 128, 255)));
		textField.setFont(new Font("Poppins", Font.PLAIN, 14));
		sl_contentPanel.putConstraint(SpringLayout.WEST, textField, 128, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, textField, -28, SpringLayout.EAST, contentPanel);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Phone No :");
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1, 26, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Poppins", Font.PLAIN, 16));
		contentPanel.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, textField, -29, SpringLayout.NORTH, textField_1);
		textField_1.setSelectionColor(new Color(128, 128, 255));
		textField_1.setSelectedTextColor(new Color(255, 255, 255));
		textField_1.setCaretColor(new Color(128, 128, 255));
		textField_1.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(128, 128, 255)));
		sl_contentPanel.putConstraint(SpringLayout.NORTH, textField_1, 122, SpringLayout.NORTH, contentPanel);
		textField_1.setFont(new Font("Poppins", Font.PLAIN, 14));
		sl_contentPanel.putConstraint(SpringLayout.WEST, textField_1, 23, SpringLayout.EAST, lblNewLabel_1_1);
		sl_contentPanel.putConstraint(SpringLayout.EAST, textField_1, -28, SpringLayout.EAST, contentPanel);
		textField_1.setColumns(10);
		contentPanel.add(textField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Address :");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1, 46, SpringLayout.SOUTH, lblNewLabel_1_1);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1, 26, SpringLayout.WEST, contentPanel);
		lblNewLabel_1_1_1.setFont(new Font("Poppins", Font.PLAIN, 16));
		contentPanel.add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		sl_contentPanel.putConstraint(SpringLayout.EAST, lblNewLabel_1_1_1, -26, SpringLayout.WEST, textField_2);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, textField_2, 195, SpringLayout.NORTH, contentPanel);
		textField_2.setSelectionColor(new Color(128, 128, 255));
		textField_2.setSelectedTextColor(new Color(255, 255, 255));
		textField_2.setCaretColor(new Color(128, 128, 255));
		textField_2.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(128, 128, 255)));
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, textField_1, -42, SpringLayout.NORTH, textField_2);
		textField_2.setFont(new Font("Poppins", Font.PLAIN, 14));
		sl_contentPanel.putConstraint(SpringLayout.WEST, textField_2, 128, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, textField_2, -28, SpringLayout.EAST, contentPanel);
		textField_2.setColumns(10);
		contentPanel.add(textField_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Module :");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1_1, 40, SpringLayout.SOUTH, lblNewLabel_1_1_1);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1_1, 26, SpringLayout.WEST, contentPanel);
		lblNewLabel_1_1_1_1.setFont(new Font("Poppins", Font.PLAIN, 16));
		contentPanel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Type :");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1_1_1, 28, SpringLayout.SOUTH, lblNewLabel_1_1_1_1);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1_1_1, 26, SpringLayout.WEST, contentPanel);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Poppins", Font.PLAIN, 16));
		contentPanel.add(lblNewLabel_1_1_1_1_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Full-Time");
		sl_contentPanel.putConstraint(SpringLayout.EAST, lblNewLabel_1_1_1_1_1, -36, SpringLayout.WEST, rdbtnNewRadioButton);
		rdbtnNewRadioButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, textField_2, -87, SpringLayout.NORTH, rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBackground(new Color(255, 255, 255));
		sl_contentPanel.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton, -2, SpringLayout.NORTH, lblNewLabel_1_1_1_1_1);
		sl_contentPanel.putConstraint(SpringLayout.WEST, rdbtnNewRadioButton, 0, SpringLayout.WEST, textField);
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Poppins", Font.PLAIN, 14));
		contentPanel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnParttime = new JRadioButton("Part-Time");
		rdbtnParttime.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnParttime.setBackground(new Color(255, 255, 255));
		sl_contentPanel.putConstraint(SpringLayout.NORTH, rdbtnParttime, -2, SpringLayout.NORTH, lblNewLabel_1_1_1_1_1);
		sl_contentPanel.putConstraint(SpringLayout.WEST, rdbtnParttime, 41, SpringLayout.EAST, rdbtnNewRadioButton);
		buttonGroup.add(rdbtnParttime);
		rdbtnParttime.setFont(new Font("Poppins", Font.PLAIN, 14));
		contentPanel.add(rdbtnParttime);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Full Name :");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_2, 18, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_2, 26, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1, 35, SpringLayout.SOUTH, lblNewLabel_1_1_2);
		lblNewLabel_1_1_2.setFont(new Font("Poppins", Font.PLAIN, 16));
		contentPanel.add(lblNewLabel_1_1_2);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(128, 128, 255));
		sl_contentPanel.putConstraint(SpringLayout.WEST, btnNewButton, 280, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, btnNewButton, -15, SpringLayout.SOUTH, contentPanel);
		btnNewButton.setFont(new Font("Poppins", Font.BOLD, 14));
		sl_contentPanel.putConstraint(SpringLayout.NORTH, btnNewButton, 21, SpringLayout.SOUTH, rdbtnParttime);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(128, 128, 255));
		btnNewButton_1.setBorder(null);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, btnNewButton_1, 139, SpringLayout.SOUTH, textField_2);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -15, SpringLayout.SOUTH, contentPanel);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		sl_contentPanel.putConstraint(SpringLayout.EAST, btnNewButton, -26, SpringLayout.WEST, btnNewButton_1);
		sl_contentPanel.putConstraint(SpringLayout.WEST, btnNewButton_1, -89, SpringLayout.EAST, textField);
		btnNewButton_1.setFont(new Font("Poppins", Font.BOLD, 14));
		sl_contentPanel.putConstraint(SpringLayout.EAST, btnNewButton_1, 0, SpringLayout.EAST, textField);
		contentPanel.add(btnNewButton_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Module"}));
		sl_contentPanel.putConstraint(SpringLayout.NORTH, comboBox, 0, SpringLayout.NORTH, lblNewLabel_1_1_1_1);
		sl_contentPanel.putConstraint(SpringLayout.WEST, comboBox, 0, SpringLayout.WEST, textField);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, comboBox, 31, SpringLayout.NORTH, lblNewLabel_1_1_1_1);
		sl_contentPanel.putConstraint(SpringLayout.EAST, comboBox, 0, SpringLayout.EAST, textField);
		comboBox.setFont(new Font("Poppins", Font.PLAIN, 16));
		comboBox.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 255), new Color(128, 128, 255),

						new Color(255, 255, 255), new Color(255, 255, 255)));
		comboBox.setBackground(Color.WHITE);
		contentPanel.add(comboBox);
	}
}
