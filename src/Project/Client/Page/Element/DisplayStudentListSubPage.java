package Project.Client.Page.Element;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.management.RuntimeErrorException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Project.Client.Controller.ActivityTableModel;
import Project.Client.Controller.MyCSVFileChooser;
import Project.Client.Controller.StudentTableModel;
import Project.Client.Page.BasePage;
import Project.Server.Object.Student;
import Project.Server.Operator.Add_Element;

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
	
	//MUSTDO return a ArrayList from database
	//studentID, grade1, grade2, grade3
	//studentID, grade1, grade2, grade3
	ArrayList<String[]> list;
	
	private String courseID;
	
	public void setCourseID(String st) {
		courseID = st;
	}
	
	public DisplayStudentListSubPage() {
		
		//MUSTDO: See line 44
		String[] a = {"stu1", "80", "90", "85"};
		String[] b = {"stu2", "75", "85", "90"};
		String[] c = {"stu3", "60", "65", "70"};
		list = new ArrayList();
		list.add(a);
		list.add(b);
		list.add(c);
		
		
		layout.setLayout(new BorderLayout(10, 10));
		setSize(800, 480);
		setLocationRelativeTo(null);
		
		//set JTable
		jTable.setOpaque(false);
		jTable.setGridColor(new Color(200, 200, 200));
		String[] columnNames = {"Student ID", "Activity1", "Activity2", "Activity3", "Activity4", "Activity5", "Activity6"};
		jTable.setModel(new StudentTableModel(columnNames, list));
		JScrollPane scrollTable = new JScrollPane();
		scrollTable.getViewport().add(jTable, null);
		scrollTable.setPreferredSize(new Dimension(getPreferredSize().width, getPreferredSize().height));
		
		submit.add(input_discard);
		submit.add(input_submit);
		
		header.add(name);
		header_right.add(input_export_cvs);
		header.add(header_right);
		
		layout.add(header, BorderLayout.NORTH);
		layout.add(scrollTable, BorderLayout.CENTER);
		layout.add(submit, BorderLayout.SOUTH);
		setContentPane(layout);
		
		input_submit.addActionListener(this);
		input_discard.addActionListener(this);
		input_export_cvs.addActionListener(this);
	}

		
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == input_submit) {
			
			DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
			
			int i;
			System.err.println(tableModel.getValueAt(0, 0).toString());
			// MUSTDO: add student
			try{
			
				Add_Element.addStudent((String) tableModel.getValueAt(0, 0) , this.courseID);
			}
			catch(Throwable re){
				JOptionPane.showMessageDialog(null, "Submit Failed.", "WARNING", JOptionPane.NO_OPTION);
			}
			
			
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
					
					//MUSTDO see line 60
					for (String[] st: list) {
						for (int i = 0; i < st.length; i++) {
							fw.write(st[i]);
							if (i != st.length -1) {
								fw.write(",\t");
							} else {
								fw.write("\n");
							}
						}
					}
					
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
