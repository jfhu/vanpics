package Project.Client;

import java.awt.*;

import javax.swing.*;

import Project.Client.Page.*;

public class Mainframe {

	protected JFrame frame;
	protected BasePage newFrame;
	
	private final static int WINDOW_HEIGHT = 600;
	private final static int WINDOW_WIDTH = 800;

    public Mainframe()
    {
    	frame = new JFrame("Grade Recording, Calculation, and Displaying System - by VanPics");
    	frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public Mainframe(Point p) {
    	frame = new JFrame("Grade Recording, Calculation, and Displaying System - by VanPics");
    	frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(p);
        frame.setVisible(true);
    }
    
    public void run_once() {
    	newFrame = new LoginPage();
    	frame.setVisible(false);
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		// Use an appropriate Look and Feel 
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        // Turn off metal's use of bold fonts 
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        */
		
		Mainframe frame = new Mainframe();
		frame.run_once();
	}

}
