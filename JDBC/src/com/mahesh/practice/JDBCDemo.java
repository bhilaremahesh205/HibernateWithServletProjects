package com.mahesh.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

    public void readUserDetailsFromDatabase() throws Exception {
    	Connection connection = null;
    	Statement statement = null;
    	ResultSet  resultSet = null;
    	try {
            // This will load the MySQL driver, each DB has its own driver
        	connection = getConnection();
            // Statements allow to issue SQL queries to the database
        	statement = connection.createStatement();
            // Result set get the result of the SQL query
        	resultSet = statement.executeQuery("select * from user_details");
            writeResultSet(resultSet);

        } catch (Exception e) {
            throw e;
        } finally {
            close(resultSet,statement,null,connection);
        }

    }
    
    public void checkUserDetails(String username,String password) throws Exception {
    	Connection connection = null;
    	PreparedStatement statement = null;
    	ResultSet  resultSet = null;
    	try {
            // This will load the MySQL driver, each DB has its own driver
        	connection = getConnection();
            // Statements allow to issue SQL queries to the database
        	statement = connection.prepareStatement("");
            // Result set get the result of the SQL query
        	resultSet = statement.executeQuery("select * from user_details");
            writeResultSet(resultSet);

        } catch (Exception e) {
            throw e;
        } finally {
            close(resultSet,statement,null,connection);
        }

    }
    

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		// Setup the connection with the DB
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/stud_info?"+"user=root&password=root");
		return connection;
	}

    private void writeMetaData(ResultSet resultSet) throws SQLException {
        //  Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String user = resultSet.getString("username");
            String pass = resultSet.getString("password");
            Integer id = resultSet.getInt("user_id");
        
            System.out.println("User ID: " + id);
            System.out.println("username: " + user);
            System.out.println("password: " + pass);
        }
    }

    // You need to close the resultSet
    private void close(ResultSet resultSet,Statement statement,PreparedStatement preparedStatement, Connection connection) {
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
    
    
    
    /*
	 * // PreparedStatements can use variables and are more efficient
	 * preparedStatement = connect.
	 * prepareStatement("insert into  feedback values (default, ?, ?, ?, ? , ?, ?)"
	 * ); // "myuser, webpage, datum, summary, COMMENTS from feedback.comments"); //
	 * Parameters start with 1
	 * 
	 * preparedStatement.setString(1, "Test"); preparedStatement.setString(2,
	 * "TestEmail"); preparedStatement.setString(3, "TestWebpage");
	 * preparedStatement.setDate(4, new java.sql.Date(2009, 12, 11));
	 * preparedStatement.setString(5, "TestSummary"); preparedStatement.setString(6,
	 * "TestComment"); preparedStatement.executeUpdate();
	 * 
	 * preparedStatement = connect
	 * .prepareStatement("SELECT myuser, webpage, datum, summary, COMMENTS from feedback"
	 * ); resultSet = preparedStatement.executeQuery(); writeResultSet(resultSet);
	 * 
	 * // Remove again the insert comment preparedStatement =
	 * connect.prepareStatement("delete from feedback where myuser= ? ; ");
	 * preparedStatement.setString(1, "Test"); preparedStatement.executeUpdate();
	 * 
	 * resultSet = statement.executeQuery("select * from feedback");
	 * writeMetaData(resultSet);
	 */
    
}
    