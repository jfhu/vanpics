package Project.Client.Controller;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import Project.Server.Database.ActivityGroup;

public class StudentTableModel extends DefaultTableModel {
	private List<String[]> list=null;
	
	public StudentTableModel(String[] columnNames, List<String[]> list) {
		super(null, columnNames);
		this.list = list;
	}
	
	public int getColumnCount(){
		return 7;    		
	}
	public int getRowCount(){
		if (list == null) {
			return 0;
		}
		else {
			return list.size();
		}
	}
	public Object getValueAt(int row, int column){
		if(row>=getRowCount()){
			return null;
		}
		String[] o=list.get(row);
		if (column <= getColumnCount() && column < o.length) {
			return o[column];
		}
		//MUSTDO return indexoutofboundsexception
		return null;
	}
}
