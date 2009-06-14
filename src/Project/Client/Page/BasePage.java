package Project.Client.Page;

import java.awt.*;
import java.awt.event.ActionListener;

import Project.Client.Mainframe;

public abstract class BasePage extends Mainframe
						implements ActionListener {
	
	public BasePage(Point p) {
		super(p);
	}
	public BasePage() {
	}
	abstract public void setLayout();
	abstract public void setAccordingToAccountType();
}
