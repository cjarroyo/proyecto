package belatrix.com.logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Cristian Arroyo on 30/12/2016
 */
public class LogToDatabase {
	
	@SuppressWarnings("rawtypes")
	public static void print(boolean work, String message, int type,
			Map dbParams) throws Exception {
		if (work) {
			Properties connectionProps = new Properties();
			connectionProps.put("user", dbParams.get("userName"));
			connectionProps.put("password", dbParams.get("password"));

			Connection connection = DriverManager.getConnection("jdbc:"
					+ dbParams.get("dbms") + "://" + dbParams.get("serverName")
					+ ":" + dbParams.get("portNumber") + "/", connectionProps);

			Statement stmt = connection.createStatement();
			stmt.executeUpdate("insert into Log_Values('" + message + "', "
					+ String.valueOf(type) + ")");
		}
	}
}
