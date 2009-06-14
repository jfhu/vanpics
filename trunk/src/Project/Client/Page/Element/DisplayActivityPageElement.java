package Project.Client.Page.Element;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.*;

import java.util.List;

import Project.Client.Controller.ActivityTableModel;
import Project.Server.Database.ActivityGroup;
import Project.Server.Database.AccountIdCourseId;

/**
*/
public class DisplayActivityPageElement extends BasePageElement {
	private JPanel paneActivity_button = new JPanel(new BorderLayout());
	private JPanel paneActivity_button_minusplus = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	
	private JButton input_plus = new JButton("+");
	private JButton input_minus = new JButton("-");
	private JButton input_loadPast = new JButton("Load From Past");
	
	private JTable jTable = new JTable();
	
	private String courseId = "5";
	
	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public DisplayActivityPageElement() {
		
		ArrayList <ActivityGroup> activityGroups = ActivityGroup.find(this.courseId);
		for (ActivityGroup a : activityGroups) {
			System.out.println(a.getId() + " " + a.getPercent());
		}
		
		
		setLayout(new BorderLayout());
		
		jTable.setGridColor(new Color(200, 200, 200));
		jTable.setOpaque(false);
		String[] columnNames = {"#", "Activity Name", "Proportion"};
		jTable.setModel(new ActivityTableModel(columnNames, activityGroups));
		
		
		//not required
		input_loadPast.setEnabled(false);
		
		paneActivity_button_minusplus.add(input_plus, BorderLayout.LINE_END);
		paneActivity_button_minusplus.add(input_minus, BorderLayout.LINE_END);
		paneActivity_button.add(input_loadPast, BorderLayout.PAGE_START);
		paneActivity_button.add(paneActivity_button_minusplus, BorderLayout.PAGE_END);
		add(paneActivity_button, BorderLayout.WEST);
		add(jTable, BorderLayout.CENTER);
		
	}
	
	public void clear() {
		jTable.removeAll();
		jTable.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == input_plus) {
			
		} else if (e.getSource() == input_minus) {
			
		}
		
	}
}

