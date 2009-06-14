package Project.Client.Page.Element;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public abstract class BasePageElement extends JPanel implements ActionListener {

	public abstract void actionPerformed(ActionEvent e);
}
