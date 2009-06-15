package Project.Client.Page;

import java.awt.*;
import java.awt.event.ActionListener;

import Project.Client.Mainframe;
import Project.Server.Database.Account;

public abstract class BasePage extends Mainframe
						implements ActionListener {
	
	public BasePage(Point p) {
		super(p);
	}
	public BasePage() {
	}
	abstract public void setLayout();
	
	abstract public void updateName();
	
	protected Account account;
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
}
