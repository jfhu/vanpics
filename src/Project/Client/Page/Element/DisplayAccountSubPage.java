package Project.Client.Page.Element;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.border.Border;

import Project.Server.Operator.Add_Element;

/**
*/
public class DisplayAccountSubPage extends BasePageElement{
/**
*/
	private JPanel paneBasicWrap = new JPanel();
	private JPanel paneBasic = new JPanel(new GridLayout(5, 2));
	private JPanel paneSpecial = new JPanel();
	private JPanel panePasswordWrap = new JPanel();
	private JPanel panePassword = new JPanel(new GridLayout(3, 2));
	private JPanel paneSubmit = new JPanel();
	private JPanel paneMiddleBox = new JPanel();
	
	private JLabel ID = new JLabel("Account ID", JLabel.RIGHT);
	private JLabel name = new JLabel("Name", JLabel.RIGHT);
	private JLabel email = new JLabel("E-mail", JLabel.RIGHT);
	private JLabel phone = new JLabel("Phone", JLabel.RIGHT);
	private JLabel type = new JLabel("Account Type", JLabel.RIGHT);
	
	private JTextField input_ID = new JTextField();
	private JTextField input_name = new JTextField();
	private JTextField input_email = new JTextField();
	private JTextField input_phone = new JTextField();
	//TODO: user type
	private String[] comboBoxItems = {"Student", "Instructor", "Administrator", "System Manager"};
	private JComboBox input_type = new JComboBox( comboBoxItems );
	
	private JLabel password = new JLabel("Password", JLabel.RIGHT);
	private JLabel newPassword = new JLabel("Set New Password", JLabel.RIGHT);
	private JLabel confirmPassword = new JLabel("Confirm Password", JLabel.RIGHT);
	
	private JPasswordField input_password = new JPasswordField();
	private JPasswordField input_newPassword = new JPasswordField();
	private JPasswordField input_confirmPassword = new JPasswordField();
	
	private JLabel specialLabel = new JLabel("Courses Taken", JLabel.RIGHT);
	private JLabel specialLabelNum = new JLabel("10", JLabel.RIGHT);
	private JButton specialButton = new JButton("View Courses");
	
	private JButton input_reset = new JButton("Reset");
	private JButton input_submit = new JButton("Submit");
	
	public DisplayAccountSubPage() {
		setLayout(new BorderLayout());
		paneBasicWrap.setBorder(BorderFactory.createTitledBorder("Basic Information"));
		paneSpecial.setBorder(BorderFactory.createTitledBorder("Related Course"));
		panePasswordWrap.setBorder(BorderFactory.createTitledBorder("Set Password"));
		
		paneBasic.add(ID);
		paneBasic.add(input_ID);
		paneBasic.add(name);
		paneBasic.add(input_name);
		paneBasic.add(email);
		paneBasic.add(input_email);
		paneBasic.add(phone);
		paneBasic.add(input_phone);
		paneBasic.add(type);
		paneBasic.add(input_type);
		paneBasicWrap.add(paneBasic);
		
		//n/a
		specialButton.setEnabled(false);
		paneSpecial.add(specialLabel);
		paneSpecial.add(specialLabelNum);
		paneSpecial.add(specialButton);
		
		
		panePassword.add(password);
		panePassword.add(input_password);
		panePassword.add(newPassword);
		panePassword.add(input_newPassword);
		panePassword.add(confirmPassword);
		panePassword.add(input_confirmPassword);
		panePasswordWrap.add(panePassword);
		
		paneSubmit.add(input_reset);
		paneSubmit.add(input_submit);
		
		
		paneMiddleBox.setLayout(new BoxLayout(paneMiddleBox, BoxLayout.PAGE_AXIS));
		add(paneBasicWrap, BorderLayout.NORTH);
		paneMiddleBox.add(paneSpecial);
		paneMiddleBox.add(panePasswordWrap);
		add(paneMiddleBox, BorderLayout.CENTER);
		add(paneSubmit, BorderLayout.SOUTH);
		
		setVisible(true);
		
		input_submit.addActionListener(this);
		input_reset.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == input_reset) {
			input_ID.setText("");
			input_name.setText("");
			input_email.setText("");
			input_phone.setText("");
			input_password.setText("");
			input_newPassword.setText("");
			input_confirmPassword.setText("");
		}else if (e.getSource() == input_submit) {
			
			try{
				
			String passWord = String.valueOf(input_newPassword.getPassword());
			Add_Element.addAccount(input_ID.getText() , input_type.getSelectedItem().toString() , input_ID.getText() , 
					passWord , input_name.getText() , input_phone.getText(), input_email.getText());
			}
			catch(RuntimeException re){
				JOptionPane.showMessageDialog(null, "Submit Failed.", "Failed", JOptionPane.NO_OPTION);
			
				return ;
			}
			
			if(!input_newPassword.equals(input_confirmPassword)) {
				JOptionPane.showMessageDialog(null, "Passwords dont match.", "Error", JOptionPane.ERROR_MESSAGE);
				input_newPassword.setText("");
				input_confirmPassword.setText("");

			}
				
			JOptionPane.showMessageDialog(null, "Submit succeed.", "Succeed", JOptionPane.NO_OPTION);
		}
		
	}
	
	public void setForSystemManager() {
		specialLabel.setEnabled(false);
		specialLabelNum.setEnabled(false);
		input_password.setEditable(false);
		setVisible(true);
	}
	public void setForInstructor() {
		input_ID.setEditable(false);
		input_name.setEditable(false);
		input_type.setEditable(false);
	}
	public void setForStudent() {
		input_ID.setEditable(false);
		input_name.setEditable(false);
		input_type.setEditable(false);
		input_submit.setEnabled(false);
	}
	public void setForAdministrator() {
		input_ID.setEditable(false);
		input_name.setEditable(false);
		input_type.setEditable(false);
		input_submit.setEnabled(false);
	}
	
}

