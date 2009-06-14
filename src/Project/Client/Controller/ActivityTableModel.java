package Project.Client.Controller;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;

import Project.Server.Database.ActivityGroup;

import java.util.*;

public class ActivityTableModel extends DefaultTableModel {
	private List<ActivityGroup> list=null;
	
	public ActivityTableModel(String[] columnNames, List<ActivityGroup> list) {
		super(null, columnNames);
		this.list = list;
	}
	
	public int getColumnCount(){
		return 3;    		
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
		ActivityGroup o=list.get(row);
		if(column==0){
			return row+1;
		} else if(column == 1){
			return o.getId();
		} else if (column == 2){
			return o.getPercent();
		} else {
			return null;
		}
	}
}


