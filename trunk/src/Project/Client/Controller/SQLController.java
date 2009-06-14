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
//ִ��SQL���
String query = inputQuery.getText();
statement = connection.createStatement();
resultSet = statement.executeQuery( query );
//�ڱ������ʾ��ѯ���
displayResultSet( resultSet );
}
catch ( SQLException sqlex ) {
sqlex.printStackTrace();
}
}

private void displayResultSet( ResultSet rs )
throws SQLException
{
//��λ�����һ����¼
boolean moreRecords = rs.next();
//���û�м�¼������ʾһ����Ϣ
if ( ! moreRecords ) {
JOptionPane.showMessageDialog( this,
"��������޼�¼" );
setTitle( "�޼�¼��ʾ" );
return;
}
Vector columnHeads = new Vector();
Vector rows = new Vector();
try {
//��ȡ�ֶε�����
ResultSetMetaData rsmd = rs.getMetaData();
for ( int i = 1; i <= rsmd.getColumnCount(); ++i )
columnHeads.addElement( rsmd.getColumnName( i ) );
//��ȡ��¼��
do {
rows.addElement( getNextRow( rs, rsmd ) );
} while ( rs.next() );
//�ڱ������ʾ��ѯ���
table = new JTable( rows, columnHeads );
JScrollPane scroller = new JScrollPane( table );
Container c = getContentPane();
c.remove(1);
c.add( scroller, BorderLayout.CENTER );
//ˢ��Table
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
//����һ����¼
return currentRow;
}

	 */
	
}
