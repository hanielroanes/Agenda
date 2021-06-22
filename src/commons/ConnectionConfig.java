package commons;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionConfig {

	// Parametros de conexão
			private final String driver = "com.mysql.cj.jdbc.Driver";
			private final String url = "jdbc:mysql://localhost:3306/agenda?useTimezone=true&serverTimezone=UTC";
			private final String user = "root";
			private final String password = "271005";
			
			public Connection connect() {
				try {
					
					Class.forName(driver);
					
					Connection con = DriverManager.getConnection(url, user, password);
					
					return con;
					
				} catch (Exception e) {
					System.out.println(e);
					return null;
				}
			}
			
			public void teste() {
				try {
					Connection con = connect();
					System.out.println(con);
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
	
}
