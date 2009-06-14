package Project.Client.Controller;

import java.sql.*;

import javax.swing.JOptionPane;

public class SQLController {
	//private final static String url = "jdbc:mysql://10.71.101.17:3306/seProject";
	private final String url = "jdbc:mysql://222.205.90.228:3306/seProject";
	private final static String user = "se";
	private final static String password = "ybG4Um5";
	
	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static ResultSetMetaData rsMetaData;
	
	public SQLController() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
		}
		catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error loading JDBC/ODBC Driver.", "Error", JOptionPane.NO_OPTION);
			System.out.println("Error loading JDBC/ODBC Driver.");
			e.printStackTrace();
			System.exit(1);
		}
		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Cannot connect to server.", "Error", JOptionPane.NO_OPTION);
			System.out.println("Cannot connect to server.");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	/* REFERENCE */
	/*
	 * private void getTable()
{
try {
//执行SQL语句
String query = inputQuery.getText();
statement = connection.createStatement();
resultSet = statement.executeQuery( query );
//在表格中显示查询结果
displayResultSet( resultSet );
}
catch ( SQLException sqlex ) {
sqlex.printStackTrace();
}
}

private void displayResultSet( ResultSet rs )
throws SQLException
{
//定位到达第一条记录
boolean moreRecords = rs.next();
//如果没有记录，则提示一条消息
if ( ! moreRecords ) {
JOptionPane.showMessageDialog( this,
"结果集中无记录" );
setTitle( "无记录显示" );
return;
}
Vector columnHeads = new Vector();
Vector rows = new Vector();
try {
//获取字段的名称
ResultSetMetaData rsmd = rs.getMetaData();
for ( int i = 1; i <= rsmd.getColumnCount(); ++i )
columnHeads.addElement( rsmd.getColumnName( i ) );
//获取记录集
do {
rows.addElement( getNextRow( rs, rsmd ) );
} while ( rs.next() );
//在表格中显示查询结果
table = new JTable( rows, columnHeads );
JScrollPane scroller = new JScrollPane( table );
Container c = getContentPane();
c.remove(1);
c.add( scroller, BorderLayout.CENTER );
//刷新Table
c.validate();
}
catch ( SQLException sqlex ) {
sqlex.printStackTrace();
}
}


private Vector getNextRow( ResultSet rs,
ResultSetMetaData rsmd )
throws SQLException
{
Vector currentRow = new Vector();
for ( int i = 1; i <= rsmd.getColumnCount(); ++i )
currentRow.addElement( rs.getString( i ) );
//返回一条记录
return currentRow;
}

	 */
	
}
