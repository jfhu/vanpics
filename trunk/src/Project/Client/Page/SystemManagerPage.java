package Project.Client.Page;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Project.Client.Page.Element.*;
import Project.Server.Database.Account;

public class SystemManagerPage extends BasePage 
								implements ItemListener {

	
	//menu
	private JMenuBar	menuBar = new JMenuBar();
	private JMenu		command = new JMenu("USERNAME");
	private JMenuItem 	logout = new JMenuItem("Logout");
	private JMenuItem	exit = new JMenuItem("Exit");
	
	//layout
	private JPanel		centerPanel = new JPanel(new CardLayout());
	private	JPanel		comboBoxPane = new JPanel();
	private JComboBox	comboBox;
	
	//different cards
	private AddCourseSubPage card_addCourse = new AddCourseSubPage();
		final static String ADDCOURSE = "Add Course";
	private DisplayAccountSubPage	card_addAccount = new DisplayAccountSubPage();
		final static String ADDACCOUNT = "Add Account";
	
	public SystemManagerPage() {
		setLayout();
	}
	public SystemManagerPage(Point p) {
		super(p);
		if (account != null) {
			command = new JMenu(account.getName());
		}
		setLayout();
	}
	
	@Override
	public void setLayout() {
		frame.setLayout(new BorderLayout());
		String comboBoxItems[] = { ADDCOURSE , ADDACCOUNT };
		comboBox = new JComboBox(comboBoxItems);
		comboBox.setEditable(false);
		comboBox.addItemListener(this);
		comboBoxPane.add(new JLabel("Command:"));
		comboBoxPane.add(comboBox);
		card_addCourse.setForSystemManager();
		card_addAccount.setForSystemManager();
		centerPanel.add(card_addCourse, ADDCOURSE);
		centerPanel.add(card_addAccount, ADDACCOUNT);
		
		logout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.ALT_MASK));
		
		command.add(logout);
		command.add(exit);
		menuBar.add(command);
		
		frame.add(comboBoxPane, BorderLayout.PAGE_START);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
        
        logout.addActionListener(this);
        exit.addActionListener(this);
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
		CardLayout cl = (CardLayout)(centerPanel.getLayout());
        cl.show(centerPanel, (String)e.getItem());
	}
}
