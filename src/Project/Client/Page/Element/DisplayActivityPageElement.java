package Project.Client.Page.Element;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
*/
public class DisplayActivityPageElement extends BasePageElement {
	private JPanel paneActivity_button = new JPanel(new BorderLayout());
	private JPanel paneActivity_button_minusplus = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	
	private JButton input_plus = new JButton("+");
	private JButton input_minus = new JButton("-");
	private JButton input_loadPast = new JButton("Load From Past");
	
	private JTable list = new JTable(3, 3);
	
	public DisplayActivityPageElement() {
		setLayout(new BorderLayout());
		
		list.setGridColor(new Color(200, 200, 200));
		list.setOpaque(false);
		
		//not required
		input_loadPast.setEnabled(false);
		
		paneActivity_button_minusplus.add(input_plus, BorderLayout.LINE_END);
		paneActivity_button_minusplus.add(input_minus, BorderLayout.LINE_END);
		paneActivity_button.add(input_loadPast, BorderLayout.PAGE_START);
		paneActivity_button.add(paneActivity_button_minusplus, BorderLayout.PAGE_END);
		add(paneActivity_button, BorderLayout.WEST);
		add(list, BorderLayout.CENTER);
		
	}
	
	public void clear() {
		list.removeAll();
		list.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == input_plus) {
			
		} else if (e.getSource() == input_minus) {
			
		}
		
	}
}

