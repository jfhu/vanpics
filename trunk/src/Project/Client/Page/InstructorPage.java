package Project.Client.Page;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

import Project.Client.Page.Element.AddCourseSubPage;
import Project.Server.Database.Account;

public class InstructorPage extends BasePage 
					implements ItemListener
{

	private static final LayoutManager BoderLayout = null;
	
//	menu
	private JMenuBar	menuBar = new JMenuBar();
	private JMenu		command = new JMenu("USERNAME");
	private JMenuItem 	logout = new JMenuItem("Logout");
	private JMenuItem	exit = new JMenuItem("Exit");
	
//	LayOut
	private JComboBox	comboBox; 
	private JPanel		comboBoxPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel		centerPane = new JPanel();
	private AddCourseSubPage addCourseSubpage = new AddCourseSubPage();
	
//	Course
	private String MYCOURSE1 = new String("YOYO's the best!");
	private String MYCOURSE2 = new String("Milki's the worst~");
	
	public InstructorPage() {
		if (account != null)
			command.setText(account.getUserName());
		setLayout();
		
	}
	public InstructorPage(Point p) {
		super(p);
		setLayout();
	}
	
	@Override
	public void setLayout() {
		frame.setLayout(new BorderLayout());
		String comboBoxItem [] = {MYCOURSE1, MYCOURSE2};
		comboBox = new JComboBox(comboBoxItem);
		comboBox.setEditable(false);
		comboBoxPane.add(new JLabel("Course List"));
		comboBoxPane.add(comboBox);
		
		addCourseSubpage.setForInstructor();
		
		frame.add(comboBoxPane, BorderLayout.NORTH);
		frame.add(addCourseSubpage, BorderLayout.CENTER);
		
		logout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.ALT_MASK));
		
		command.add(logout);
		command.add(exit);
		menuBar.add(command);

        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
        
        logout.addActionListener(this);
        exit.addActionListener(this);
        comboBox.addItemListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command == "Logout") {
			super.newFrame = new LoginPage(super.frame.getLocation());
			frame.setVisible(false);
		}else if (command == "Exit") {
			System.exit(0);
		}
	}
	public void itemStateChanged(ItemEvent e) {
		// MUSTDO Auto-generated method stub
		
	}
}
