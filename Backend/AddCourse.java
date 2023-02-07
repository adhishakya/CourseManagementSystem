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

public class AddCourse extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField courseIdTextField;
	private JTextField courseNameTextField;
	private String courseId = "";
	private String courseName = "";
	private JButton addButton;
	private JLabel courseHeading;


	public JTextField getCourseIdTextField() {
		return courseIdTextField;
	}

	public JTextField getCourseNameTextField() {
		return courseNameTextField;
	}

	public String getCourseId() {
		return courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public JButton getAddButton() {
		return addButton;
	}

	public JLabel getCourseHeading() {
		return courseHeading;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddCourse dialog = new AddCourse();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddCourse() {
		setTitle("Add Course | Course Management System");
		setBounds(100, 100, 521, 357);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		SpringLayout sl_contentPanel = new SpringLayout();
		contentPanel.setLayout(sl_contentPanel);

		courseHeading = new JLabel("Add New Course");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, courseHeading, 10, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, courseHeading, 26, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, courseHeading, 48, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, courseHeading, -289, SpringLayout.EAST, contentPanel);
		courseHeading.setFont(new Font("Poppins", Font.BOLD, 20));
		contentPanel.add(courseHeading);

		courseIdTextField = new JTextField();
		sl_contentPanel.putConstraint(SpringLayout.NORTH, courseIdTextField, 11, SpringLayout.SOUTH, courseHeading);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, courseIdTextField, -218, SpringLayout.SOUTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, courseIdTextField, -28, SpringLayout.EAST, contentPanel);
		courseIdTextField.setCaretColor(new Color(128, 128, 255));
		courseIdTextField.setSelectedTextColor(new Color(255, 255, 255));
		courseIdTextField.setSelectionColor(new Color(128, 128, 255));
		courseIdTextField.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(128, 128, 255)));
		courseIdTextField.setFont(new Font("Poppins", Font.PLAIN, 14));
		contentPanel.add(courseIdTextField);
		courseIdTextField.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Course Name:");
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1, 0, SpringLayout.WEST, courseHeading);
		lblNewLabel_1_1.setFont(new Font("Poppins", Font.PLAIN, 16));
		contentPanel.add(lblNewLabel_1_1);

		courseNameTextField = new JTextField();
		sl_contentPanel.putConstraint(SpringLayout.NORTH, courseNameTextField, 3, SpringLayout.NORTH, lblNewLabel_1_1);
		sl_contentPanel.putConstraint(SpringLayout.WEST, courseNameTextField, 23, SpringLayout.EAST, lblNewLabel_1_1);
		sl_contentPanel.putConstraint(SpringLayout.EAST, courseNameTextField, 0, SpringLayout.EAST, courseIdTextField);
		courseNameTextField.setSelectionColor(new Color(128, 128, 255));
		courseNameTextField.setSelectedTextColor(new Color(255, 255, 255));
		courseNameTextField.setCaretColor(new Color(128, 128, 255));
		courseNameTextField.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(128, 128, 255)));
		courseNameTextField.setFont(new Font("Poppins", Font.PLAIN, 14));
		courseNameTextField.setColumns(10);
		contentPanel.add(courseNameTextField);

		JLabel lblNewLabel_1_1_2 = new JLabel("Course ID :");
		sl_contentPanel.putConstraint(SpringLayout.WEST, courseIdTextField, 53, SpringLayout.EAST, lblNewLabel_1_1_2);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1, 37, SpringLayout.SOUTH, lblNewLabel_1_1_2);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_2, 18, SpringLayout.SOUTH, courseHeading);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_2, 26, SpringLayout.WEST, contentPanel);
		lblNewLabel_1_1_2.setFont(new Font("Poppins", Font.PLAIN, 16));
		contentPanel.add(lblNewLabel_1_1_2);

		addButton = new JButton("Add");
		sl_contentPanel.putConstraint(SpringLayout.WEST, addButton, 253, SpringLayout.WEST, contentPanel);
		addButton.setActionCommand("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Add")) {
					if (e.getActionCommand().equals("Add")) {
						courseId = courseIdTextField.getText().trim();
						courseName = courseNameTextField.getText().trim();

						Statement statement = DatabaseConnection.getStatement();
						String insertQuery = "INSERT INTO `coursedetails` (`courseId`, `courseName`)"
								+ " VALUES ('"+courseId+"', '"+courseName+"');";
						try {
							int insertSuccess = statement.executeUpdate(insertQuery);
							if (insertSuccess == 1) {
								JOptionPane.showMessageDialog(contentPanel, "Added Course data successfully!");
								AdminPanel.showCourseDataFromDatabase();
								dispose();
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
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
		sl_contentPanel.putConstraint(SpringLayout.NORTH, addButton, 0, SpringLayout.NORTH, btnNewButton_1);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, addButton, 0, SpringLayout.SOUTH, btnNewButton_1);
		sl_contentPanel.putConstraint(SpringLayout.EAST, addButton, -33, SpringLayout.WEST, btnNewButton_1);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, btnNewButton_1, 66, SpringLayout.SOUTH, courseNameTextField);
		sl_contentPanel.putConstraint(SpringLayout.WEST, btnNewButton_1, 368, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -45, SpringLayout.SOUTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, btnNewButton_1, 0, SpringLayout.EAST, courseIdTextField);
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
