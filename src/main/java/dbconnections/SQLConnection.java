package dbconnections;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SQLConnection {
	static final String DB_URL = "jdbc:mysql://localhost:3399/reldata?useSSL=false";
	static final String USER = "root";
	static final String PASS = "password";
	String query;
	
	public SQLConnection(String newquery) {
		this.query = newquery;
	}
	
	public List<Map<String, Object>> makeQuery() throws SQLException {
	    // Open a connection
		List<Map<String, Object>> result = new ArrayList<>();
	    try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    	 Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(query);) {
	    	 while (rs.next()) {
	            Map<String, Object> resMap = new HashMap<>();
	            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
	                resMap.put(rs.getMetaData().getColumnName(i), rs.getObject(i));
	            }
	            result.add(resMap);
	         }
	    	 return result;
	    	 
	    } catch (SQLException e) {
	         e.printStackTrace();
	         throw e;
	    } 
	}
}
