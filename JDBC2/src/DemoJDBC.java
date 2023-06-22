		// TODO Auto-generated method stub
		import java.sql.Connection;
		import java.sql.DriverManager;
		import java.sql.ResultSet;
		import java.sql.SQLException;
		import java.sql.Statement;
		 
		public class DemoJDBC
		{
		  /* static block is executed when a class is loaded into memory 
		   * this block loads MySQL's JDBC driver
		   */
		  static
		  {
		    try
		    {
		      // loads com.mysql.jdbc.Driver into memory
		      Class.forName("com.mysql.jdbc.Driver");
		    } 
		    catch (ClassNotFoundException cnf) 
		    {
		      System.out.println("Driver could not be loaded: " + cnf);
		    }
		  }
		 
		  public static void main(String[] args)
		  {
		    String connectionUrl = "jdbc:mysql://localhost:3306/student_info";
		    String dbUser = "root";
		    String dbPwd = "root";
		    Connection conn;
		    ResultSet rs;
		    String queryString = "SELECT id,name FROM stud_info";
		 
		    try
		    {
		      conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
		      Statement stmt = conn.createStatement();
		 
		      // INSERT A RECORD
		      stmt.executeUpdate("INSERT INTO student user,password VALUES (\"Mahesh\",)");
		 
		      // SELECT ALL RECORDS FROM EXPTABLE
		      rs = stmt.executeQuery(queryString);
		 
		      System.out.println("user \t password");
		      System.out.println("============");
		      while(rs.next())
		      {
		        System.out.print(rs.getString("user") + ".\t" + rs.getString("password"));
		        System.out.println();
		      }
		      if (conn != null)
		      {
		        conn.close();
		        conn = null;
		      }
		    }
		    catch (SQLException sqle) 
		    {
		      System.out.println("SQL Exception thrown: " + sqle);
		    }
		  }
		} //JDBC_Connection_Demo ends here
		 