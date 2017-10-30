package win.mycorpus.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
	private static Connection connection=null;
	//��������
	public static void loadDriver(){
		String driverName="oracle.jdbc.driver.OracleDriver";  
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			System.out.println("�������ݿ������쳣");
		}
	}
	//��������
	public static Connection connection(){
		String url="jdbc:oracle:thin:@localhost:1521:orcl";  
        String user="c##coruser"; 
        String password="corpus"; 
        try {
			connection=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("�������ݿ��쳣");
		}
        return connection;
	}
	//����򿪵���
	public static void closeConnection(){
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("�ر������쳣");
		}
	}
}
