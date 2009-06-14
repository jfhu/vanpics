package Project.Client.Controller;

import java.io.File;
import java.io.FileFilter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class MyCSVFileChooser extends JFileChooser{
    String sysdefine = "~`!@#$%^&()[]{}?<>:,\"";
    javax.swing.filechooser.FileFilter filter;
    
    class MyCSVFilter extends javax.swing.filechooser.FileFilter {
    	public boolean accept(File file) {
			if (file.isDirectory()) {
				return true;
			} else {
				String path = file.getAbsolutePath().toLowerCase();
				if (path.endsWith(".csv")) {
					return true;
				}
			}
			return false;
		}

		@Override
		public String getDescription() {
			return "Comma separated values (CSV) Spreadsheet";
		}
    }
    
    public MyCSVFileChooser() {
    	filter = new MyCSVFilter();
    	setFileFilter(filter);
    }
    
    private boolean validity(String name){
        int len = sysdefine.toCharArray().length;
        for(int i=0; i<len; i++){
            if(name.indexOf(sysdefine.charAt(i))!=-1){
                return true;
            }
        }
        return false;
    }
    
    public void approveSelection() {            
        String inputFileName = getSelectedFile().getName();
        if (validity(inputFileName)) {
            JOptionPane.showMessageDialog(getParent(), "A File name should not have \\ / : * ? \" < > |");
            return;
        }
        super.approveSelection();
    }
}