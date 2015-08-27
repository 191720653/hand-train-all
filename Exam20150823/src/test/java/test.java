import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.hand.util.ConnectionFactory;

public class test {
	
	private static String driver;
	private static String dburl;
	private static String user;
	private static String password;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		try {
			connection = ConnectionFactory.getInstance().makeConnection();
			connection.setAutoCommit(false);
			
			System.out.println(connection==null);
			
			boolean bool =false;

			String sql = "select * from customer where first_name=?";
			PreparedStatement preparedStatement;
			try {
				preparedStatement = connection.prepareCall(sql);
				preparedStatement.setString(1, "zehao");
				bool=preparedStatement.executeQuery().next();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("INFO-->"+"查詢用戶信息失敗");
			}
			System.out.println(bool);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("INFO-->"+"查詢用戶信息失敗");
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("eed");

	}
	

}
