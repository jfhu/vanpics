package Project.Client.Page;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

import Project.Client.Controller.Login;
import Project.Client.Controller.SQLController;
import Project.Exception.Password_Error;

public class LoginPage extends BasePage {
	//menu
	private JMenuBar	menuBar = new JMenuBar();
	private JMenu		command = new JMenu("System");
	private JMenuItem 	exit = new JMenuItem("Exit");
	
	//layout
	private JLabel 		uid = new JLabel("User ID ");
	private JTextField 	input_id = new JTextField();
	private JLabel 		password = new JLabel("Password ");
	private JPasswordField 	input_password = new JPasswordField();
	private JButton 	login = new JButton("Login");
	private JButton 	forgot = new JButton("Forgot password");
	
	//controller		
	private Login		login_control = new Login();
	
	//debug menu
	private JMenu		debug = new JMenu("Develop");
	private JMenuItem	debug_instructor = new JMenuItem("Goto Instructor Page");
	private JMenuItem	debug_system_manager = new JMenuItem("Goto System Manager Page");
	
	public LoginPage() {
		setLayout();
		//new SQLController();
	}
	public LoginPage (Point p) {
		super(p);
		setLayout();
	}
	
	@Override
	public void setLayout() {
		frame.setLayout(new FlowLayout(FlowLayout.CENTER));
		JPanel centerPanel = new JPanel(new GridLayout(2, 3));
		
		uid.setHorizontalAlignment(JLabel.RIGHT);
		password.setHorizontalAlignment(JLabel.RIGHT);
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.ALT_MASK));
		
		//debug
		debug.add(debug_instructor);
		debug.add(debug_system_manager);
		debug_instructor.addActionListener(this);
		debug_system_manager.addActionListener(this);
		
		command.add(exit);
		menuBar.add(command);
		
		//debug
		menuBar.add(debug);
		
		centerPanel.add(uid);
		centerPanel.add(input_id);
		centerPanel.add(forgot);
		centerPanel.add(password);
		centerPanel.add(input_password);
		centerPanel.add(login);
		
        frame.add(centerPanel);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
        
        input_id.requestFocus();
        
        login.addActionListener(this);
        forgot.addActionListener(this);
        exit.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if (command.equals("Login")) {
			String type = "UnKnow";
			try{
				type = login_control.checkAccount(input_id.getText(), String.valueOf( input_password.getPassword() ) );
				
			}
			catch (Password_Error pe){
			//	System.err.println(pe.getCause());
			//	pe.printStackTrace();
				JOptionPane.showMessageDialog(null, "WARNING:The Username/password combination is invalid.", "Login Error", JOptionPane.ERROR_MESSAGE);
				return ;
			}
			catch (RuntimeException re){
				System.err.println(re.getCause());
				JOptionPane.showMessageDialog(null, "WARNING:No Such User.", "Login Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			
				if (type == "Instructor"){
					super.newFrame = new InstructorPage(super.frame.getLocation());
					frame.setVisible(false);
				}
				else if (type == "SystemManager"){
					
					super.newFrame = new SystemManagerPage(super.frame.getLocation());
					frame.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "ERROR:Account Type Error, Please System Manager.", "Login Error", JOptionPane.ERROR_MESSAGE);
				}
				
		
			
		}
		else if (command.equals("Forgot password")) { 
			if (input_id.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Please input username first.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else if (input_id.getText().equals("instructor")) {
				input_password.setText("123456");
			}
			else if (input_id.getText().equals("system manager")) {
				input_password.setText("234567");
			}
			else {
				JOptionPane.showMessageDialog(null, "No Such User.", "Login Error", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		else if (command.equals("Exit")) {
			System.exit(0);
		}

		//debug
		if (command == "Goto Instructor Page") {
			super.newFrame = new InstructorPage(super.frame.getLocation());
			frame.setVisible(false);
		}
		else if (command == "Goto System Manager Page") {
			super.newFrame = new SystemManagerPage(super.frame.getLocation());
			frame.setVisible(false);
		}
	}
}
