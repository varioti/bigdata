package project;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dbconnections.*;

public class Main {

    public static void main(String[] args) {
    	// TASK 1
    	System.out.println("TASK 1");
    	getAllSupliers();
    	
    	// TASK 4
    	System.out.println("TASK 4");
    	getCustomersWithOrderPreparedByMargaret();
    }
    	
    	
    private static void getAllSupliers() {
    	MongoDBConnection mongoquery = new MongoDBConnection();
    	List<Map<String, Object>> allsuppliers = mongoquery.makeQuery("Suppliers");
		for (Map<String, Object> supplier : allsuppliers) {
            System.out.println(supplier);
		}
    	
    }
    
    private void getSupliersWithProductEscargot() {

    }
    
    private void getAllShipers() {

    }
    
    private static void getCustomersWithOrderPreparedByMargaret() {
    	// BD Connections
    	SQLConnection sql = new SQLConnection("SELECT EmployeeID FROM Employees WHERE FirstName = 'Margaret'");
    	RedisConnection redis = new RedisConnection();
    	MongoDBConnection mongoquery = new MongoDBConnection();
    	
    	try {
    		// Get all employees with FirstName is Margaret (SQL)
    		List<Map<String, Object>> employees = sql.makeQuery();
    		for (Map<String, Object> employee : employees) {
    			String id_Margaret = employee.get("EmployeeID").toString();
    			
    			// Get all orders (REDIS)
	            List<Map<String, String>> orders = redis.makeQuery("ORDER:*");
	            
	            // Filter all orders prepared by a employees with FirstName Margaret
	            List<String> orders_margaret = new ArrayList<>();
	            for (Map<String, String> order : orders) {
	            	if (order.get("EmployeeRef").toString().equals(id_Margaret)) {
	            		orders_margaret.add(order.get("CustomerRef"));
	            	}
	            }
	            // Get all customers (MONGODB)
	            List<Map<String, Object>> customers = mongoquery.makeQuery("Customers");
	            
	            // Print only customers in referenced in orders_margaret
	            for (Map<String, Object> customer : customers) {
	            	if (orders_margaret.contains(customer.get("CustomerID"))) {
	            		System.out.println(customer);
	            	}
	            }
    		}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}