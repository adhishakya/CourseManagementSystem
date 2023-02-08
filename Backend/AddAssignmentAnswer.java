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

public class AddAssignmentAnswer extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField questionOneAnswerTextField;
	private JTextField questionTwoAnswerTextField;
	private JButton addButton;
	private JLabel assignmentHeading;


	public JTextField getQuestionOneAnswerTextField() {
		return questionOneAnswerTextField;
	}

	public JTextField getQuestionTwoAnswerTextField() {
		return questionTwoAnswerTextField;
	}

	

	public JButton getAddButton() {
		return addButton;
	}

	public JLabel getAssignmentHeading() {
		return assignmentHeading;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddAssignmentAnswer dialog = new AddAssignmentAnswer("",0);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddAssignmentAnswer(String moduleName, int studentId) {
		setTitle("Assignment Answer | Course Management System");
		setBounds(100, 100, 521, 339);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		SpringLayout sl_contentPanel = new SpringLayout();
		contentPanel.setLayout(sl_contentPanel);

		assignmentHeading = new JLabel("Upload Assignment");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, assignmentHeading, 10, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, assignmentHeading, 26, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, assignmentHeading, 48, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, assignmentHeading, -261, SpringLayout.EAST, contentPanel);
		assignmentHeading.setFont(new Font("Poppins", Font.BOLD, 20));
		contentPanel.add(assignmentHeading);

		questionOneAnswerTextField = new JTextField();
		sl_contentPanel.putConstraint(SpringLayout.NORTH, questionOneAnswerTextField, 6, SpringLayout.SOUTH, assignmentHeading);
		sl_contentPanel.putConstraint(SpringLayout.EAST, questionOneAnswerTextField, -28, SpringLayout.EAST, contentPanel);
		questionOneAnswerTextField.setCaretColor(new Color(128, 128, 255));
		questionOneAnswerTextField.setSelectedTextColor(new Color(255, 255, 255));
		questionOneAnswerTextField.setSelectionColor(new Color(128, 128, 255));
		questionOneAnswerTextField.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(128, 128, 255)));
		questionOneAnswerTextField.setFont(new Font("Poppins", Font.PLAIN, 14));
		contentPanel.add(questionOneAnswerTextField);
		questionOneAnswerTextField.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Answer 2:");
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1, 0, SpringLayout.WEST, assignmentHeading);
		lblNewLabel_1_1.setFont(new Font("Poppins", Font.PLAIN, 16));
		contentPanel.add(lblNewLabel_1_1);

		questionTwoAnswerTextField = new JTextField();
		sl_contentPanel.putConstraint(SpringLayout.WEST, questionTwoAnswerTextField, 0, SpringLayout.WEST, questionOneAnswerTextField);
		sl_contentPanel.putConstraint(SpringLayout.EAST, questionTwoAnswerTextField, -28, SpringLayout.EAST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, questionTwoAnswerTextField, -23, SpringLayout.NORTH, lblNewLabel_1_1);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, questionTwoAnswerTextField, 26, SpringLayout.NORTH, lblNewLabel_1_1);
		questionTwoAnswerTextField.setSelectionColor(new Color(128, 128, 255));
		questionTwoAnswerTextField.setSelectedTextColor(new Color(255, 255, 255));
		questionTwoAnswerTextField.setCaretColor(new Color(128, 128, 255));
		questionTwoAnswerTextField.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(128, 128, 255)));
		questionTwoAnswerTextField.setFont(new Font("Poppins", Font.PLAIN, 14));
		questionTwoAnswerTextField.setColumns(10);
		contentPanel.add(questionTwoAnswerTextField);

		JLabel lblNewLabel_1_1_2 = new JLabel("Answer 1:");
		sl_contentPanel.putConstraint(SpringLayout.WEST, questionOneAnswerTextField, 53, SpringLayout.EAST, lblNewLabel_1_1_2);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, questionOneAnswerTextField, 0, SpringLayout.SOUTH, lblNewLabel_1_1_2);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1, 46, SpringLayout.SOUTH, lblNewLabel_1_1_2);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_2, 26, SpringLayout.SOUTH, assignmentHeading);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_2, 0, SpringLayout.WEST, assignmentHeading);
		lblNewLabel_1_1_2.setFont(new Font("Poppins", Font.PLAIN, 16));
		contentPanel.add(lblNewLabel_1_1_2);

		addButton = new JButton("Add");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, addButton, 50, SpringLayout.SOUTH, questionTwoAnswerTextField);
		sl_contentPanel.putConstraint(SpringLayout.WEST, addButton, 253, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, addButton, -25, SpringLayout.SOUTH, contentPanel);
		addButton.setActionCommand("Add");
		addButton.addActionListener(new ActionListener() {
			String moduleNameFromDB;
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Add")) {
					String moduleNameFromDB = moduleName;
					String firstAnswer = questionOneAnswerTextField.getText().trim();
					String secondAnswer = questionTwoAnswerTextField.getText().trim();
					String assignmentQuery = "INSERT INTO `answerdetails` (`answer_1`, `answer_2`, `course`,`studentId`) "
							+ "VALUES ('" + firstAnswer + "', '" + secondAnswer + "', '" + moduleNameFromDB + "',"+studentId+")";
					Statement statement2 = DatabaseConnection.getStatement();
					try {
						int assignmentUploadSuccess = statement2.executeUpdate(assignmentQuery);
						if (assignmentUploadSuccess == 1) {
							JOptionPane.showMessageDialog(contentPanel, "Answer Submitted!");
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
		sl_contentPanel.putConstraint(SpringLayout.EAST, addButton, -38, SpringLayout.WEST, btnNewButton_1);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, btnNewButton_1, 0, SpringLayout.SOUTH, addButton);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, addButton);
		sl_contentPanel.putConstraint(SpringLayout.WEST, btnNewButton_1, 368, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, btnNewButton_1, 0, SpringLayout.EAST, questionOneAnswerTextField);
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

	}
}
