package Project.Client.Controller;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import Project.Server.Database.AccountIdCourseIdDAO;

public class MTableModel extends AbstractTableModel {
	//table name
	private String tabName = null;
	
	private String headerName[] = null;
	private Vector dataVec = null;
	
	private String courseId;
	
	public MTableModel(String headerName[], String tabName) {
		this.tabName = tabName;
		this.headerName = headerName;
		initialize();
	}
	
	private void initialize() {
		//MUSTDO I don't know whether the query is correct
		String hql = getHql(headerName, tabName);
		System.out.println(hql);
		AccountIdCourseIdDAO ac = new AccountIdCourseIdDAO();
		List result = ac.findByCourseId(courseId); 
		dataVec = new Vector();
		for (int i = 0; i < result.size(); i++) {
			String row[] = new String[headerName.length];
			List rowList = (List)result.get(i);
			for (int j = 0; j < headerName.length; j++) {
				if (rowList.get(j) == null) {
					row[j] = "null";
				}
				else {
					row[j] = rowList.get(j).toString();
				}
			}
			dataVec.add(row);
		}
	}
	
	private String getHql(String headerName[], String tabName) {
		StringBuffer sb = new StringBuffer();
		sb.append("select new list(");
		StringBuffer columnString = new StringBuffer();
		for (int i= 0, len = headerName.length; i < len; i++) {
			columnString.append(",");
			columnString.append(headerName[i]);
		}
		sb.append(columnString.substring(1));
		sb.append(") from ");
		sb.append(tabName);
		
		return sb.toString();
	}
	
	public int getColumnCount() {
		return headerName.length;
	}

	public int getRowCount() {
		return dataVec.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		String row[] = (String[])dataVec.get(rowIndex);
		Object rs = row[columnIndex];
		return rs;
	}
	
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		String row[] = (String[]) dataVec.elementAt(rowIndex);
		row[columnIndex] = aValue.toString();
		dataVec.setElementAt(row, rowIndex);
	}
	
	public void removeRow(int rowIndex) {
		dataVec.removeElement(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);
	}
	
	public void insertRow(int rowIndex, String[] everyRow) {
		dataVec.insertElementAt(everyRow, rowIndex);
		fireTableRowsInserted(rowIndex, rowIndex);
	}
	
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}
}

