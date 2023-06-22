package com.mahesh.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {

	
	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		// Setup the connection with the DB
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/stud_info?"+"user=root&password=root");
		return connection;
	}
	
	// You need to close the resultSet
    public static void close(ResultSet resultSet,Statement statement,PreparedStatement preparedStatement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }
            if (preparedStatement != null) {
            	preparedStatement.close();
            }

            if (connection != null) {
            	connection.close();
            }
        } catch (Exception e) {

        }
    }
	
}
