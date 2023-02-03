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
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ItemEvent;

public class AddStudent extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField studentFullNameTextField;
	private JTextField studentAgeTextField;
	private JTextField studentGroupTextField;
	private JTextField studentAddressTextField;
	private JTextField studentPhoneTextField;
	private int uniId;
	private String studentName = "";
	private String studentLevel = "";
	private String studentSemester = "";
	private String studentGroup = "";
	private String studentAddress = "";
	private String studentCourse = "";
	private String studentAge = "";
	private String studentPhone = "";
	private JButton addStudentButton;
	private JLabel addStudentHeading;
	private JTextField uniIdtextField;
	private String courseFromComboBox;
	
	
	public String getCourseFromComboBox() {
		return courseFromComboBox;
	}

	public JTextField getUniIdtextField() {
		return uniIdtextField;
	}

	public JLabel getAddStudentHeading() {
		return addStudentHeading;
	}

	public JPanel getContentPanel() {
		return contentPanel;
	}

	public JTextField getStudentFullNameTextField() {
		return studentFullNameTextField;
	}

	public JTextField getStudentAgeTextField() {
		return studentAgeTextField;
	}

	public JTextField getStudentGroupTextField() {
		return studentGroupTextField;
	}

	public JTextField getStudentAddressTextField() {
		return studentAddressTextField;
	}

	public JTextField getStudentPhoneTextField() {
		return studentPhoneTextField;
	}

	public String getStudentName() {
		return studentName;
	}

	public String getStudentLevel() {
		return studentLevel;
	}

	public String getStudentSemester() {
		return studentSemester;
	}

	public String getStudentGroup() {
		return studentGroup;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public String getStudentCourse() {
		return studentCourse;
	}

	public String getStudentAge() {
		return studentAge;
	}

	public String getStudentPhone() {
		return studentPhone;
	}

	public JButton getAddStudentButton() {
		return addStudentButton;
	}

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
		setBounds(100, 100, 533, 602);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		SpringLayout sl_contentPanel = new SpringLayout();
		contentPanel.setLayout(sl_contentPanel);

		addStudentHeading = new JLabel("Add New Student");
		addStudentHeading.setBackground(new Color(255, 255, 255));
		sl_contentPanel.putConstraint(SpringLayout.NORTH, addStudentHeading, 10, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, addStudentHeading, 26, SpringLayout.WEST, contentPanel);
		addStudentHeading.setFont(new Font("Poppins", Font.BOLD, 20));
		contentPanel.add(addStudentHeading);

		JLabel lblNewLabel_1_1_2 = new JLabel("Full Name :");
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_2, 0, SpringLayout.WEST, addStudentHeading);
		lblNewLabel_1_1_2.setFont(new Font("Poppins", Font.PLAIN, 16));
		contentPanel.add(lblNewLabel_1_1_2);

		studentFullNameTextField = new JTextField();
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_2, -2, SpringLayout.NORTH,
				studentFullNameTextField);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, studentFullNameTextField, -431, SpringLayout.SOUTH,
				contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, studentFullNameTextField, -37, SpringLayout.EAST,
				contentPanel);
		studentFullNameTextField.setSelectionColor(new Color(128, 128, 255));
		studentFullNameTextField.setSelectedTextColor(Color.WHITE);
		studentFullNameTextField.setFont(new Font("Poppins", Font.PLAIN, 14));
		studentFullNameTextField.setColumns(10);
		studentFullNameTextField.setCaretColor(new Color(128, 128, 255));
		studentFullNameTextField.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(128, 128, 255)));
		contentPanel.add(studentFullNameTextField);

		studentAgeTextField = new JTextField();
		sl_contentPanel.putConstraint(SpringLayout.WEST, studentFullNameTextField, 0, SpringLayout.WEST,
				studentAgeTextField);
		sl_contentPanel.putConstraint(SpringLayout.EAST, studentAgeTextField, -37, SpringLayout.EAST, contentPanel);
		studentAgeTextField.setSelectionColor(new Color(128, 128, 255));
		studentAgeTextField.setSelectedTextColor(Color.WHITE);
		studentAgeTextField.setFont(new Font("Poppins", Font.PLAIN, 14));
		studentAgeTextField.setColumns(10);
		studentAgeTextField.setCaretColor(new Color(128, 128, 255));
		studentAgeTextField.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(128, 128, 255)));
		contentPanel.add(studentAgeTextField);

		JLabel lblNewLabel_1_1 = new JLabel("Phone No :");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1, 444, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1, 0, SpringLayout.WEST, addStudentHeading);
		lblNewLabel_1_1.setFont(new Font("Poppins", Font.PLAIN, 16));
		contentPanel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Address :");
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1, 0, SpringLayout.WEST, addStudentHeading);
		lblNewLabel_1_1_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1_1_1.setFont(new Font("Poppins", Font.PLAIN, 16));
		contentPanel.add(lblNewLabel_1_1_1);

		studentGroupTextField = new JTextField();
		sl_contentPanel.putConstraint(SpringLayout.EAST, studentGroupTextField, -37, SpringLayout.EAST, contentPanel);
		studentGroupTextField.setSelectionColor(new Color(128, 128, 255));
		studentGroupTextField.setSelectedTextColor(Color.WHITE);
		studentGroupTextField.setFont(new Font("Poppins", Font.PLAIN, 14));
		studentGroupTextField.setColumns(10);
		studentGroupTextField.setCaretColor(new Color(128, 128, 255));
		studentGroupTextField.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(128, 128, 255)));
		contentPanel.add(studentGroupTextField);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Course :");
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1_1, 0, SpringLayout.WEST, addStudentHeading);
		lblNewLabel_1_1_1_1.setFont(new Font("Poppins", Font.PLAIN, 16));
		contentPanel.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Semester : ");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1_1_1, 209, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1_1_1, 0, SpringLayout.WEST,
				addStudentHeading);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Poppins", Font.PLAIN, 16));
		contentPanel.add(lblNewLabel_1_1_1_1_1);

		JComboBox levelComboBox = new JComboBox();
		sl_contentPanel.putConstraint(SpringLayout.NORTH, levelComboBox, 24, SpringLayout.SOUTH,
				studentFullNameTextField);
		sl_contentPanel.putConstraint(SpringLayout.WEST, levelComboBox, 0, SpringLayout.WEST, studentFullNameTextField);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, levelComboBox, -377, SpringLayout.SOUTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, levelComboBox, -37, SpringLayout.EAST, contentPanel);
		levelComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1) {
					studentLevel = (String) e.getItem();
				}
			}
		});

		levelComboBox.setModel(new DefaultComboBoxModel(new String[] { "Select Level", "4", "5", "6" }));
		levelComboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		levelComboBox.setFont(new Font("Poppins", Font.PLAIN, 16));
		levelComboBox.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 255), new Color(128, 128, 255),

				new Color(255, 255, 255), new Color(255, 255, 255)));
		levelComboBox.setBackground(Color.WHITE);
		contentPanel.add(levelComboBox);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Group :");
		sl_contentPanel.putConstraint(SpringLayout.WEST, studentGroupTextField, 45, SpringLayout.EAST,
				lblNewLabel_1_1_1_1_1_1);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1_1_1_1, -2, SpringLayout.NORTH,
				studentGroupTextField);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1_1_1_1, 0, SpringLayout.WEST,
				addStudentHeading);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Poppins", Font.PLAIN, 16));
		contentPanel.add(lblNewLabel_1_1_1_1_1_1);
		
		JComboBox courseComboBox = new JComboBox();
		courseComboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		sl_contentPanel.putConstraint(SpringLayout.NORTH, courseComboBox, -3, SpringLayout.NORTH, lblNewLabel_1_1_1_1);
		sl_contentPanel.putConstraint(SpringLayout.WEST, courseComboBox, 0, SpringLayout.WEST, studentFullNameTextField);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, courseComboBox, 27, SpringLayout.NORTH, lblNewLabel_1_1_1_1);
		sl_contentPanel.putConstraint(SpringLayout.EAST, courseComboBox, 0, SpringLayout.EAST, studentFullNameTextField);
		courseComboBox.setFont(new Font("Poppins", Font.PLAIN, 16));
		courseComboBox.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 255), new Color(128, 128, 255),

		

								new Color(255, 255, 255), new Color(255, 255, 255)));
		courseComboBox.setBackground(Color.WHITE);
		contentPanel.add(courseComboBox);
		
		courseComboBox.setModel(new DefaultComboBoxModel(new String[] { "Select Course" }));
		String fetchCoursesQuery = "SELECT courseName FROM `coursedetails`";
		String[] coursesArray = new String[5];
		int i = 0;
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

		addStudentButton = new JButton("Add");
		addStudentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Add")) {
					uniId = Integer.parseInt(getUniIdtextField().getText().trim());
					studentName = studentFullNameTextField.getText().trim();
					studentLevel = studentLevel.trim();
					studentSemester = studentSemester.trim();
					studentGroup = studentGroupTextField.getText().trim();
					studentAddress = studentAddressTextField.getText().trim();
					studentCourse = courseFromComboBox.trim();
					studentAge = studentAgeTextField.getText().trim();
					studentPhone = studentPhoneTextField.getText().trim();

					Statement statement = DatabaseConnection.getStatement();
					String insertQuery = "INSERT INTO `studentdetails` "
							+ "(`Id`, `studentName`, `level`, `semester`, `studentgroup`, `studentAddress`,"
							+ " `studentCourse`, `studentAge`, `studentPhone`)" + " VALUES (" + uniId + ", '"
							+ studentName + "', '" + studentLevel + "', '" + studentSemester + "'," + " '"
							+ studentGroup + "', '" + studentAddress + "', '" + studentCourse + "', '" + studentAge
							+ "'," + " '" + studentPhone + "');";
					try {
						int insertSuccess = statement.executeUpdate(insertQuery);
						if (insertSuccess == 1) {
							JOptionPane.showMessageDialog(contentPanel, "Added Student data successfully!");
							AdminPanel.showStudentDataFromDatabase();
							AdminPanel.getStudentIdForComboBox();
							dispose();
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		addStudentButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		sl_contentPanel.putConstraint(SpringLayout.NORTH, addStudentButton, -58, SpringLayout.SOUTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, addStudentButton, -221, SpringLayout.EAST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, addStudentButton, -15, SpringLayout.SOUTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, addStudentButton, -150, SpringLayout.EAST, contentPanel);
		addStudentButton.setForeground(Color.WHITE);
		addStudentButton.setFont(new Font("Poppins", Font.BOLD, 14));
		addStudentButton.setBorder(null);
		addStudentButton.setBackground(new Color(128, 128, 255));
		contentPanel.add(addStudentButton);

		JButton btnCancel = new JButton("Cancel");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, btnCancel, 0, SpringLayout.NORTH, addStudentButton);
		sl_contentPanel.putConstraint(SpringLayout.WEST, btnCancel, 27, SpringLayout.EAST, addStudentButton);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, btnCancel, -15, SpringLayout.SOUTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, btnCancel, -37, SpringLayout.EAST, contentPanel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Poppins", Font.BOLD, 14));
		btnCancel.setBorder(null);
		btnCancel.setBackground(new Color(128, 128, 255));
		contentPanel.add(btnCancel);

		studentAddressTextField = new JTextField();
		sl_contentPanel.putConstraint(SpringLayout.NORTH, studentAddressTextField, 315, SpringLayout.NORTH,
				contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, studentAddressTextField, 32, SpringLayout.EAST,
				lblNewLabel_1_1_1);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, studentAddressTextField, -63, SpringLayout.NORTH,
				studentAgeTextField);
		sl_contentPanel.putConstraint(SpringLayout.EAST, studentAddressTextField, -37, SpringLayout.EAST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1, -2, SpringLayout.NORTH,
				studentAddressTextField);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, studentGroupTextField, -28, SpringLayout.NORTH,
				studentAddressTextField);
		studentAddressTextField.setSelectionColor(new Color(128, 128, 255));
		studentAddressTextField.setSelectedTextColor(Color.WHITE);
		studentAddressTextField.setFont(new Font("Poppins", Font.PLAIN, 14));
		studentAddressTextField.setColumns(10);
		studentAddressTextField.setCaretColor(new Color(128, 128, 255));
		studentAddressTextField.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(128, 128, 255)));
		contentPanel.add(studentAddressTextField);

		JLabel lblNewLabel_1_1_1_2 = new JLabel("Level :");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1_2, 3, SpringLayout.NORTH, levelComboBox);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1_2, 0, SpringLayout.WEST, addStudentHeading);
		lblNewLabel_1_1_1_2.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblNewLabel_1_1_1_2.setBackground(Color.WHITE);
		contentPanel.add(lblNewLabel_1_1_1_2);

		JComboBox semesterComboBox = new JComboBox();
		sl_contentPanel.putConstraint(SpringLayout.NORTH, semesterComboBox, 206, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, semesterComboBox, 17, SpringLayout.EAST,
				lblNewLabel_1_1_1_1_1);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, semesterComboBox, -27, SpringLayout.NORTH,
				studentGroupTextField);
		sl_contentPanel.putConstraint(SpringLayout.EAST, semesterComboBox, -37, SpringLayout.EAST, contentPanel);
		semesterComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1) {
					studentSemester = (String) e.getItem();
				}
			}
		});
		semesterComboBox.setModel(new DefaultComboBoxModel(new String[] { "Select Semester", "1", "2" }));
		semesterComboBox.setFont(new Font("Poppins", Font.PLAIN, 16));
		semesterComboBox
				.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 255), new Color(128, 128, 255),

						new Color(255, 255, 255), new Color(255, 255, 255)));
		semesterComboBox.setBackground(Color.WHITE);
		contentPanel.add(semesterComboBox);

		JLabel lblNewLabel_1_1_3 = new JLabel("Age :");
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_1_1_1, -17, SpringLayout.NORTH,
				lblNewLabel_1_1_3);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, studentAgeTextField, 2, SpringLayout.NORTH,
				lblNewLabel_1_1_3);
		sl_contentPanel.putConstraint(SpringLayout.WEST, studentAgeTextField, 65, SpringLayout.EAST, lblNewLabel_1_1_3);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_3, 0, SpringLayout.WEST, addStudentHeading);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_1_3, -18, SpringLayout.NORTH, lblNewLabel_1_1);
		lblNewLabel_1_1_3.setFont(new Font("Poppins", Font.PLAIN, 16));
		contentPanel.add(lblNewLabel_1_1_3);

		studentPhoneTextField = new JTextField();
		sl_contentPanel.putConstraint(SpringLayout.NORTH, studentPhoneTextField, 2, SpringLayout.NORTH,
				lblNewLabel_1_1);
		sl_contentPanel.putConstraint(SpringLayout.WEST, studentPhoneTextField, 20, SpringLayout.EAST, lblNewLabel_1_1);
		sl_contentPanel.putConstraint(SpringLayout.EAST, studentPhoneTextField, -37, SpringLayout.EAST, contentPanel);
		studentPhoneTextField.setSelectionColor(new Color(128, 128, 255));
		studentPhoneTextField.setSelectedTextColor(Color.WHITE);
		studentPhoneTextField.setFont(new Font("Poppins", Font.PLAIN, 14));
		studentPhoneTextField.setColumns(10);
		studentPhoneTextField.setCaretColor(new Color(128, 128, 255));
		studentPhoneTextField.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(128, 128, 255)));
		contentPanel.add(studentPhoneTextField);

		JLabel lblNewLabel_1_1_2_1 = new JLabel("Uni Id :");
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_2_1, 0, SpringLayout.WEST, addStudentHeading);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_1_2_1, -16, SpringLayout.NORTH,
				lblNewLabel_1_1_2);
		lblNewLabel_1_1_2_1.setFont(new Font("Poppins", Font.PLAIN, 16));
		contentPanel.add(lblNewLabel_1_1_2_1);

		uniIdtextField = new JTextField();
		sl_contentPanel.putConstraint(SpringLayout.NORTH, uniIdtextField, 0, SpringLayout.NORTH, lblNewLabel_1_1_2_1);
		sl_contentPanel.putConstraint(SpringLayout.WEST, uniIdtextField, 0, SpringLayout.WEST,
				studentFullNameTextField);
		sl_contentPanel.putConstraint(SpringLayout.EAST, uniIdtextField, 343, SpringLayout.WEST,
				studentFullNameTextField);
		uniIdtextField.setSelectionColor(new Color(128, 128, 255));
		uniIdtextField.setSelectedTextColor(Color.WHITE);
		uniIdtextField.setFont(new Font("Poppins", Font.PLAIN, 14));
		uniIdtextField.setColumns(10);
		uniIdtextField.setCaretColor(new Color(128, 128, 255));
		uniIdtextField.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(128, 128, 255)));
		contentPanel.add(uniIdtextField);
		
		

		
	}

}
