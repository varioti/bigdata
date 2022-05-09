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
	    
		// TASK 3
    	System.out.println("TASK 3");
		getAllShippers();
    	
    	// TASK 3
    	System.out.println("TASK 3");
    	getAllShippers();
    	
    	// TASK 4
    	System.out.println("TASK 4");
    	getCustomersWithOrderPreparedByMargaret();
    }
    	
    	
    private static void getAllSupliers() {
    	MongoDBConnection mongoquery = new MongoDBConnection();
    	List<Map<String, Object>> allsuppliers = mongoquery.makeQuery("Suppliers");
		for (Map<String, Object> supplier : allsuppliers) {
			Suppliers sup = new Suppliers(supplier);
            System.out.println(sup);
		}
    	
    }
    
    private static void getSupliersWithProductEscargot() {
    	SQLConnection sql = new SQLConnection("SELECT ProductID, ProductName, SupplierRef FROM Products WHERE ProductName like 'Escargots de Bourgogne'");
    	MongoDBConnection mongoquery = new MongoDBConnection();
    	
    	try {
    		List<Map<String, Object>> products = sql.makeQuery();
    		for (Map<String, Object> product : products) {
    			String id_Product = product.get("SupplierRef").toString();
    			
	            List<Map<String,Object>> suppliers = mongoquery.makeQuery("Suppliers");
	            
	            for (Map<String, Object> supplier : suppliers) {
	            	if (supplier.get("SupplierID").toString().equals((id_Product).toString())) {
	            		System.out.println(supplier);
	            	}
	            }
	            
    		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    
    private static void getAllShippers() {
    	
    	RedisConnection redis = new RedisConnection();
    	Map<String, String> shippers = redis.makeQueryString("SHIPPERS:*");
    	
    	List<Shipper> list_shippers = new ArrayList<Shipper>();
    	for (int i = 1; i <= shippers.size()/2 ; i++) {
    		Shipper shp = new Shipper(i);
    		list_shippers.add(shp);
    	}
    	
    	for (Map.Entry<String,String> entry : shippers.entrySet()) {
    		
    		
    		String key[] = entry.getKey().split(":");
            String value = entry.getValue();
            
            int _id = Integer.parseInt(key[1]);
            String value_type = key[2];
            
            if (value_type.equals("COMPANYNAME")) {
            	list_shippers.get(_id-1).setCompanyName(value);
            }
            
            else if (value_type.equals("PHONE")) {
            	list_shippers.get(_id-1).setPhone(value);
            }
    		
    	}
    	
    	for (Shipper shp : list_shippers) {
        	System.out.println(shp);
        }
            
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
	            List<Map<String, String>> orders = redis.makeQueryHash("ORDER:*");
	            
	            // Filter all orders prepared by a employees with FirstName Margaret
	            List<String> orders_margaret = new ArrayList<>();
	            for (Map<String, String> order : orders) {
	            	if (order.get("EmployeeRef").toString().equals(id_Margaret)) {
	            		orders_margaret.add(order.get("CustomerRef"));
	            		System.out.println(order);
	            	}
	            }
	            // Get all customers (MONGODB)
	            List<Map<String, Object>> customers = mongoquery.makeQuery("Customers");
	            
	            // Print only customers in referenced in orders_margaret
	            for (Map<String, Object> customer : customers) {
	            	if (orders_margaret.contains(customer.get("CustomerID"))) {
	            		//System.out.println(customer);
	            	}
	            }
    		}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
