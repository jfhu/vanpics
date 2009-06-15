package Project.Client.Page.Element;

import javax.swing.*;

import Project.Exception.Illegal_Input;
import Project.Exception.No_Such_Instructor;
import Project.Server.Operator.Add_Element;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
*/
public class AddCourseSubPage extends BasePageElement {
	private JPanel paneBasic = new JPanel(new GridLayout(2, 4));
	private JPanel paneDescription = new JPanel();
	private JPanel paneSubmit = new JPanel(new GridLayout(1, 2));
	private JPanel paneSubmit_left = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel paneSubmit_right = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	private JPanel southWrapper = new JPanel(new BorderLayout());
	private DisplayActivityPageElement paneActivity = new DisplayActivityPageElement();
	private JLabel courseID = new JLabel("Course ID", JLabel.RIGHT);
	private JLabel courseName = new JLabel("Course Name", JLabel.RIGHT);
	private JLabel instructorId = new JLabel("Instructor", JLabel.RIGHT);
	private JLabel term = new JLabel("Term", JLabel.RIGHT);
	
	private JTextField input_courseID = new JTextField();
	private JTextField input_courseName = new JTextField();
	private JTextField input_instructorId = new JTextField();
	private JTextField input_term = new JTextField();
	private JTextArea input_description = new JTextArea(15,50);
	private JScrollPane scrollPane = new JScrollPane(); 
	
	private JButton input_view_class = new JButton("View Class List");
	private JButton input_reset = new JButton("Reset");
	private JButton input_submit = new JButton("Submit");
	
	private DisplayStudentListSubPage studentList = new DisplayStudentListSubPage();
	
	public AddCourseSubPage() {
		setLayout(new BorderLayout());
		paneDescription.setBorder(BorderFactory.createTitledBorder("Course Description"));
		paneBasic.setBorder(BorderFactory.createTitledBorder("Basic Information"));
		paneActivity.setBorder(BorderFactory.createTitledBorder("Activity"));
		
		//not supported
		input_term.setEnabled(false);
		input_term.setText("N/A");
		
		paneBasic.add(courseID);
		paneBasic.add(input_courseID);
		paneBasic.add(courseName);
		paneBasic.add(input_courseName);
		paneBasic.add(instructorId);
		paneBasic.add(input_instructorId);
		paneBasic.add(term);
		paneBasic.add(input_term);
		
		paneSubmit_left.add(input_view_class);
		paneSubmit_right.add(input_reset);
		paneSubmit_right.add(input_submit);
		paneSubmit.add(paneSubmit_left);
		paneSubmit.add(paneSubmit_right);
		
		input_description.setText("Description goes here.");
		input_description.setLineWrap(true);
		input_description.setWrapStyleWord(true);
		input_description.setCaretPosition(0);
		//input_description.setMinimumSize(new Dimension(200, 100));
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);   
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getViewport().add(input_description, null);
        scrollPane.setSize(500, 400);
		paneDescription.add(scrollPane);
		
		southWrapper.add(paneActivity, BorderLayout.NORTH);
		southWrapper.add(paneSubmit, BorderLayout.SOUTH);
		
		add(paneBasic, BorderLayout.NORTH);
		add(paneDescription, BorderLayout.CENTER);
		add(southWrapper, BorderLayout.SOUTH);
		
		setVisible(true);
		
		input_view_class.addActionListener(this);
		input_reset.addActionListener(this);
		input_submit.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == input_reset) {
			input_courseID.setText("");
			input_courseName.setText("");
			input_instructorId.setText("");
			//input_term.setText("");
			paneActivity.clear();
		}else if (e.getSource() == input_submit) {
			try{
				Add_Element.addCourse(input_courseID.getText() , input_courseName.getText()
						, input_instructorId.getText() , input_term.getText() 
						,input_description.getText());
			}
			catch (Illegal_Input ii){
				JOptionPane.showMessageDialog(null, "Lack of Information.", "WARNING", JOptionPane.NO_OPTION);
				return ;
			}
			catch (RuntimeException re){
				JOptionPane.showMessageDialog(null, "Submit Failed.", "WARNING", JOptionPane.NO_OPTION);
				return ;
			}
			catch (No_Such_Instructor nsi){
				JOptionPane.showMessageDialog(null, "This Instructor doesn't exist.", "WARNING", JOptionPane.NO_OPTION);
				return;
				//TODO: You can make a link to let User can construct this account when it doesn't exist.
			}
			JOptionPane.showMessageDialog(null, "Submit succeed.", "Succeed", JOptionPane.NO_OPTION);
		} else if (e.getSource() == input_view_class) {
			studentList.setCourseID(input_courseID.getText());
			studentList.setVisible(true);
		}
	}
	
	public void setForSystemManager() {
		
	}
	public void setForInstructor() {
		input_courseID.setEditable(false);
		input_courseName.setEditable(false);
		input_instructorId.setEditable(false);
		input_term.setEditable(false);
	}
	public void setForStudent() {
		
	}
	public void setForAdministrator() {
		
	}
}
