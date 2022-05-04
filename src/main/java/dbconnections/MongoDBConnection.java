package dbconnections;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

public class MongoDBConnection {
	static final String DB_URL = "localhost";
	static final int PORT = 27777;
	
	public List<Map<String, Object>> makeQuery(String collection_name)  {
		MongoClient mongoClient = new MongoClient(DB_URL, PORT);
		MongoDatabase database = mongoClient.getDatabase("myMongoDB");
		MongoCollection<Document> collection = database.getCollection(collection_name);
		FindIterable<Document> cursor = collection.find();
		MongoCursor<Document> it = cursor.iterator();
		
		List<Map<String, Object>> result = new ArrayList<>();
		
		while (it.hasNext()) {
			result.add(it.next());
		}
		mongoClient.close();
		return result;
	}
}
