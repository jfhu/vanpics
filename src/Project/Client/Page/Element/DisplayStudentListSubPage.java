package Project.Client.Page.Element;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import Project.Client.Controller.MTableModel;
import Project.Client.Controller.MyCSVFileChooser;
import Project.Client.Page.BasePage;
import Project.Server.Object.Student;

public class DisplayStudentListSubPage extends JDialog implements ActionListener {
	JPanel layout = new JPanel();
	JTable jTable = new JTable(10,10);
	JPanel header = new JPanel(new GridLayout(1, 2));
	JLabel name = new JLabel("CMPT 275, Software Engineering - Janice Regan");
	JPanel header_right = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	JPanel submit = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	
	JButton input_export_cvs = new JButton("Export to Spreadsheet");
	JButton input_submit = new JButton("Submit");
	JButton input_discard = new JButton("Discard");
	
	private String courseID;
	
	public void setCourseID(String st) {
		courseID = st;
	}
	
	public DisplayStudentListSubPage() {
		
		ArrayList <Student> students = Student.find(courseID); 
		
		layout.setLayout(new BorderLayout(10, 10));
		setSize(800, 480);
		setLocationRelativeTo(null);
		
		//set JTable
		jTable.setOpaque(false);
		jTable.setGridColor(new Color(200, 200, 200));
		//MUSTDO TABLE
		/*
		String headerName[] = {"SID", "CourseID"};
		String tabName = "ZdcQdw";
		MTableModel mTableModel = new MTableModel(headerName, tabName);
		mTableModel.setCourseID(courseID);
		jTable.setModel(mTableModel);
		*/
		
		submit.add(input_discard);
		submit.add(input_submit);
		
		header.add(name);
		header_right.add(input_export_cvs);
		header.add(header_right);
		
		layout.add(header, BorderLayout.NORTH);
		layout.add(jTable, BorderLayout.CENTER);
		layout.add(submit, BorderLayout.SOUTH);
		setContentPane(layout);
		
		input_submit.addActionListener(this);
		input_discard.addActionListener(this);
		input_export_cvs.addActionListener(this);
	}


	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == input_submit) {
			JOptionPane.showMessageDialog(null, "Submit succeed.", "Succeed", JOptionPane.NO_OPTION);
			dispose();
		} else if (e.getSource() == input_discard) {
			dispose();
		} else if (e.getSource() == input_export_cvs) {
			try {
				JFileChooser c = new MyCSVFileChooser();
				int res = c.showSaveDialog(new JFrame());
				if (res == JFileChooser.APPROVE_OPTION) {
					c.approveSelection();
					File f = c.getSelectedFile();
					String fname = c.getName(f);
					if (fname != null && fname.trim().length() > 0) {
						if (fname.toLowerCase().endsWith(".csv")) {	
						}
						else {
							fname = fname.concat(".csv");
						}
					}
					
					if (f.isFile())
						fname = f.getName();
					
					f = c.getCurrentDirectory();
					f = new File(f.getPath().concat(File.separator).concat(fname));
					
					if (f.exists()) {
						int i = JOptionPane.showConfirmDialog(null, "File exists.\nAre you sure to replace?", "File Exists", JOptionPane.YES_NO_OPTION);
						if (i == JOptionPane.YES_OPTION){
							;
						}
						else {
							return;
						}
					}
					
					f.createNewFile();
					FileWriter fw = new FileWriter(f);
					//MUSTDO: write the table as a csv spreadsheet
					fw.write("This is a CSV spreadsheet.");
					fw.close();
					JOptionPane.showMessageDialog(null, "Export successfully.", "Export done", JOptionPane.NO_OPTION);
				}
				
			} catch (Exception ex) {
				StringBuffer errmsg = new StringBuffer("File export failed.");
				errmsg.append("\n");
				errmsg.append(ex.getMessage());
				JOptionPane.showMessageDialog(null, errmsg.toString() , "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
		}
	}
	
	public void setForSystemManager() {
		
	}
	public void setForInstructor() {
		
	}
	public void setForStudent() {
		input_submit.setEnabled(false);
	}
	public void setForAdministrator() {
		input_submit.setEnabled(false);
	}
}
