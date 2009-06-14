package Project.Client.Controller;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;

import Project.Server.Database.ActivityGroup;

import java.awt.BorderLayout;
import java.util.*;

public class ActivityTableModel extends DefaultTableModel {
	private List<ActivityGroup> list=null;
	public ActivityTableModel(List<ActivityGroup> list){
		this.list=list;
	}
	public int getColumnCount(){
		return 3;    		
	}
	public int getRowCount(){
		return list.size();
	}
	public Object getValueAt(int row, int column){
		if(row>=list.size()){
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


